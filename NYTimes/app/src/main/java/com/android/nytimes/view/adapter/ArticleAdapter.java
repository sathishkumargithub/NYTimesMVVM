package com.android.nytimes.view.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.android.nytimes.R;
import com.android.nytimes.databinding.ArticalViewBinding;
import com.android.nytimes.model.Artical;
import com.android.nytimes.view.callback.ListItemClickCallBack;

import java.util.List;

/**
 * Created by sathish on 21-02-2018.
 */

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticalsViewHolder> {

    private Context mContext;
    private List<Artical> articalList;
    private ListItemClickCallBack mListItemClickCallBack;


    public ArticleAdapter(Context mContext, List<Artical> articalList, ListItemClickCallBack listItemClickCallBack) {
        this.mContext = mContext;
        this.articalList = articalList;
        mListItemClickCallBack = listItemClickCallBack;

    }

    @Override
    public ArticleAdapter.ArticalsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        ArticalViewBinding mBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.artical_view, parent, false);

        return new ArticalsViewHolder(mBinding);
    }

    @Override
    public void onBindViewHolder(ArticleAdapter.ArticalsViewHolder holder, int position) {
        Artical artical = articalList.get(position);
        holder.mArticalViewBinding.setArticle(artical);
        holder.mArticalViewBinding.setClickevent(mListItemClickCallBack);

    }

    @Override
    public int getItemCount() {
        return articalList.size();
    }

    public class ArticalsViewHolder extends RecyclerView.ViewHolder {

        public ArticalViewBinding mArticalViewBinding;

        public ArticalsViewHolder(ArticalViewBinding articalViewBinding) {
            super(articalViewBinding.getRoot());
            mArticalViewBinding = articalViewBinding;
        }
    }


}

