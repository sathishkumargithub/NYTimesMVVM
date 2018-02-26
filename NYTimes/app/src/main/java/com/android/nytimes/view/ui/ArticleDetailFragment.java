package com.android.nytimes.view.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.android.nytimes.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ArticleDetailFragment extends Fragment {

    View mDetailView;

    public ArticleDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (mDetailView == null) {
            mDetailView = inflater.inflate(R.layout.fragment_artical_detail, container, false);
        }

        Bundle bundle = getArguments();
        if (bundle != null) {
            String url = bundle.getString(getString(R.string.txt_key_url));
            WebView mWebView = (WebView) mDetailView.findViewById(R.id.webview);
            mWebView.loadUrl(url);
            WebSettings webSettings = mWebView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            mWebView.setWebViewClient(new WebViewClient());
        }
        return mDetailView;
    }

}
