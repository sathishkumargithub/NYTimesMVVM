package com.android.nytimes.view.ui;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.nytimes.R;
import com.android.nytimes.common.data.ArticleInjection;
import com.android.nytimes.common.data.ArticleListModelFactory;

import com.android.nytimes.databinding.FragmentArticalListBinding;
import com.android.nytimes.model.Artical;
import com.android.nytimes.view.adapter.ArticleAdapter;
import com.android.nytimes.view.callback.FragmentCallBackEvent;
import com.android.nytimes.view.callback.ListItemClickCallBack;
import com.android.nytimes.viewmodel.ArticleListModel;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ArticleListFragment extends Fragment implements ListItemClickCallBack {

    FragmentArticalListBinding mArticalListBinding;
    private Context mContext;
    ArticleListModel mArticalListModel;
    ArticleAdapter mArticalAdapter;
    FragmentCallBackEvent mFragmentCallBackEvent;


    public ArticleListFragment() {

    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArticleListModelFactory mArticleListModelFactory = ArticleInjection.getViewModelFactory(getActivity());
        mArticalListModel = ViewModelProviders.of(getActivity(), mArticleListModelFactory).get(ArticleListModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mArticalListBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_artical_list, container, false);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mArticalListBinding.recyclerview.setLayoutManager(mLayoutManager);
        //  mArticalAdapter =new ArticalAdapter(getActivity(), mArticalListModel.getArticals(),mListItemClickCallBack);


        return mArticalListBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mFragmentCallBackEvent.showProgressDialog();
        mArticalListModel.getArticals();

        mArticalListModel.getArticalsList().observe(getActivity(), new Observer<List<Artical>>() {
            @Override
            public void onChanged(@Nullable List<Artical> articals) {
                if (articals != null) {
                    mArticalAdapter = new ArticleAdapter(getActivity(), articals, mListItemClickCallBack);
                    mArticalListBinding.recyclerview.setAdapter(mArticalAdapter);
                    mFragmentCallBackEvent.dismissProgressDialog();
                }
            }
        });

    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mFragmentCallBackEvent = (FragmentCallBackEvent) context;
    }


    ListItemClickCallBack mListItemClickCallBack = new ListItemClickCallBack() {
        @Override
        public void onItemClick(String s) {
            mFragmentCallBackEvent.openDetailFragment(s);

        }
    };

    @Override
    public void onItemClick(String url) {

    }
}
