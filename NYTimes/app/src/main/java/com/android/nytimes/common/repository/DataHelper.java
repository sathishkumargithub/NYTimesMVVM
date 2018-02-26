package com.android.nytimes.common.repository;

import com.android.nytimes.common.data.ApiConstants;
import com.android.nytimes.common.data.AppController;
import com.android.nytimes.common.data.DataCallBack;
import com.android.nytimes.model.MainData;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import org.json.JSONObject;

/**
 * Created by sathish on 22-02-2018.
 */

public class DataHelper {

    public static void getArticalsDetail(final DataCallBack serverCallBack) {
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                ApiConstants.MOST_POPULAR_URL, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                JsonParser parser = new JsonParser();
                JsonElement mJson = parser.parse(response.toString());
                Gson gson = new Gson();
                MainData mainData = gson.fromJson(mJson, MainData.class);
                serverCallBack.success(mainData);
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

                serverCallBack.failure(error.getMessage());

            }
        });

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(jsonObjReq);
    }
}
