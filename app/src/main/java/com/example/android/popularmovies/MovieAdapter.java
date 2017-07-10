package com.example.android.popularmovies;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by cbot59 on 10/07/17.
 */

public class MovieAdapter extends ArrayAdapter<Movie> {
    Activity mActivity;
    ArrayList<Movie> mMovies;
    public MovieAdapter(Activity context, ArrayList<Movie> movies) {
        super(context, 0, movies);
        this.mActivity = context;
        this.mMovies = movies;
    }

    @Override
    public int getCount() {
        return mMovies.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        parent = null;

        if (convertView == null) {
            convertView = LayoutInflater.from(mActivity)
                    .inflate(R.layout.gridview_image, parent);

            viewHolder = new ViewHolder();
            viewHolder.mImageViewMovie = (ImageView) convertView.findViewById(R.id.image_movie);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Picasso.with(mActivity)
        .load(mMovies.get(position).mThumbnail)
        .into(viewHolder.mImageViewMovie);

        return convertView;
    }

    private static class ViewHolder {
        ImageView mImageViewMovie;
    }
}
