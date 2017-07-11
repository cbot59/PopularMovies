package com.example.android.popularmovies;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by cbot59 on 10/07/17.
 */

public class MovieAdapter extends BaseAdapter {
    private final Context mContext;
    private final Movie[] mMovies;

    public MovieAdapter(Context mContext, Movie[] mMovies) {
        this.mContext = mContext;
        this.mMovies = mMovies;
    }

    @Override
    public int getCount() {
        if (mMovies == null || mMovies.length == 0) {
            return -1;
        }

        return mMovies.length;
    }

    @Override
    public Object getItem(int position) {
        if (mMovies == null || mMovies.length == 0) {
            return null;
        }

        return mMovies[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;

        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setAdjustViewBounds(true);
        } else {
            imageView = (ImageView) convertView;
        }

        Picasso.with(mContext)
                .load(mMovies[position].getThumbnailUri())
                .resize(mContext.getResources().getInteger(R.integer.thumbnail_width),
                        mContext.getResources().getInteger(R.integer.thumbnail_height))
                .error(R.drawable.not_found)
                .placeholder(R.drawable.searching)
                .into(imageView);

        return imageView;
    }
}
