package com.android.nytimes.common.repository;

import com.android.nytimes.common.data.DataCallBack;

/**
 * Created by sathish on 24-02-2018.
 */

public interface ApiServiceInteractor {

    void getArticles(DataCallBack dataCallBack);
}
