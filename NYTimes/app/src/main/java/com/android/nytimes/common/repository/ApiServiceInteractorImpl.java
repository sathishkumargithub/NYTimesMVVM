package com.android.nytimes.common.repository;

import com.android.nytimes.common.data.DataCallBack;
import com.android.nytimes.model.MainData;

/**
 * Created by sathish on 24-02-2018.
 */

public class ApiServiceInteractorImpl implements ApiServiceInteractor {


    @Override
    public void getArticles(final DataCallBack dataCallBack) {

        DataHelper.getArticalsDetail(new DataCallBack<MainData>() {

            @Override
            public void success(MainData mainData) {
                if (dataCallBack != null)
                    dataCallBack.success(mainData.getResults());
            }

            @Override
            public void failure(String message) {
                if (dataCallBack != null)
                    dataCallBack.failure(message);

            }
        });
    }

}
