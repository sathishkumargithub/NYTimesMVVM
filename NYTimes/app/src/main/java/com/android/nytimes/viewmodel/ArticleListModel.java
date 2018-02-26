package com.android.nytimes.viewmodel;

import android.arch.core.util.Function;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;

import com.android.nytimes.common.data.DataCallBack;
import com.android.nytimes.common.repository.ApiServiceInteractor;
import com.android.nytimes.model.Artical;
import com.android.nytimes.model.Result;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sathish on 21-02-2018.
 */

public class ArticleListModel extends ViewModel {


    private MutableLiveData<List<Result>> results = new MutableLiveData<>();
    private final ApiServiceInteractor mApiServiceInteractor;

    public ArticleListModel(ApiServiceInteractor mApiServiceInteractor) {
        this.mApiServiceInteractor = mApiServiceInteractor;
    }

    public LiveData<List<Artical>> getArticalsList() {
        final List<Artical> articalList = new ArrayList<>();
        return Transformations.map(results, new Function<List<Result>, List<Artical>>() {
            @Override
            public List<Artical> apply(List<Result> input) {
                for (Result result : results.getValue()) {
                    Artical artical = new Artical();
                    artical.setTitle(result.getTitle());
                    artical.setAuthor(result.getByline());
                    artical.setPublished_date(result.getPublishedDate());
                    artical.setUrl(result.getUrl());
                    if (result.getMedia().size() > 0 && result.getMedia().get(0).getMediaMetadata().size() > 0)
                        artical.setImageurl(result.getMedia().get(0).getMediaMetadata().get(0).getUrl());
                    articalList.add(artical);
                }

                return articalList;
            }
        });

    }


    public void getArticals() {

        mApiServiceInteractor.getArticles(new DataCallBack<List<Result>>() {

            @Override
            public void success(List<Result> resultList) {
                results.setValue(resultList);
            }

            @Override
            public void failure(String message) {

            }
        });
    }

}
