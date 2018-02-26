package com.android.nytimes.common.data;

import android.content.Context;

import com.android.nytimes.common.repository.ApiServiceInteractor;
import com.android.nytimes.common.repository.ApiServiceInteractorImpl;

/**
 * Created by sathish on 24-02-2018.
 */

public class ArticleInjection {

    public static ApiServiceInteractor getDataProvider(Context context) {
        return new ApiServiceInteractorImpl();
    }

    public static ArticleListModelFactory getViewModelFactory(Context context) {
        ApiServiceInteractor dataProvider = getDataProvider(context);
        return new ArticleListModelFactory(dataProvider);
    }

}
