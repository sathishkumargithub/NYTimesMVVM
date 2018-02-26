package com.android.nytimes.common.data;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.android.nytimes.common.repository.ApiServiceInteractor;
import com.android.nytimes.viewmodel.ArticleListModel;

/**
 * Created by sathish on 24-02-2018.
 */

public class ArticleListModelFactory implements ViewModelProvider.Factory {

    private final ApiServiceInteractor apiServiceInteractor;

    public ArticleListModelFactory(ApiServiceInteractor webServiceInteractor) {
        this.apiServiceInteractor = webServiceInteractor;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(ArticleListModel.class))
            return (T) new ArticleListModel(apiServiceInteractor);

        return null;
    }
}
