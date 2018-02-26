package com.android.nytimes.view.ui;

import android.app.ProgressDialog;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.android.nytimes.R;
import com.android.nytimes.databinding.ActivityMainBinding;
import com.android.nytimes.view.callback.FragmentCallBackEvent;


public class MainActivity extends AppCompatActivity implements FragmentCallBackEvent {


    private FragmentManager mManager;
    private ArticleListFragment mArticalListFragment;
    private ProgressDialog mProgressDialog;
    private static boolean IS_DETAIL_FRAGMENT = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mManager = getSupportFragmentManager();
        FragmentTransaction transaction = mManager.beginTransaction();
        mArticalListFragment = new ArticleListFragment();

        if (mManager.findFragmentByTag(getString(R.string.txt_listfragment)) == null)
            transaction.add(R.id.main_container, mArticalListFragment, getString(R.string.txt_listfragment)).commit();
    }

    @Override
    public void showProgressDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setCancelable(false);
            mProgressDialog.setMessage(getString(R.string.txt_loading));
        }
        mProgressDialog.show();
    }

    @Override
    public void dismissProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    @Override
    public void openDetailFragment(String url) {
        if(url!=null) {
            IS_DETAIL_FRAGMENT = true;
            ArticleDetailFragment mArticalDetailFragment = new ArticleDetailFragment();
            Bundle bundle = new Bundle();
            bundle.putString(getString(R.string.txt_key_url), url);
            mArticalDetailFragment.setArguments(bundle);
            mManager.beginTransaction().add(R.id.main_container, mArticalDetailFragment, getString(R.string.txt_detailfragment)).addToBackStack(null).commit();

        }}

    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
            IS_DETAIL_FRAGMENT = false;
        } else {
            super.onBackPressed();
        }

    }


}
