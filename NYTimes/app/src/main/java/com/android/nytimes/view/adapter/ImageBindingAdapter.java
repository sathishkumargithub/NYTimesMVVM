package com.android.nytimes.view.adapter;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by sathish on 22-02-2018.
 */

public class ImageBindingAdapter {
    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView imageView, String url) {
        if (!url.equals("")) {
            Picasso.with(imageView.getContext()).load(url).into(imageView);
        }
    }
}
