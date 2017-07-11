package com.example.android.popularmovies;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.ParseException;

public class DetailsMovieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_movie);

        TextView tvTitle = (TextView) findViewById(R.id.tv_movie_title);
        ImageView ivThumbnail = (ImageView) findViewById(R.id.iv_thumbnail);
        TextView tvSynopsis = (TextView) findViewById(R.id.tv_synopsis);
        TextView tvRating = (TextView) findViewById(R.id.tv_rating);
        TextView tvReleaseYear = (TextView) findViewById(R.id.tv_release_year);

        Intent intent = getIntent();
        Movie movie = intent.getParcelableExtra(getString(R.string.parcel_movie));

        tvTitle.setText(movie.getTitle());

        Picasso.with(this)
                .load(movie.getThumbnailUri())
                .resize(getResources().getInteger(R.integer.thumbnail_width),
                        getResources().getInteger(R.integer.thumbnail_height))
                .error(R.drawable.not_found)
                .placeholder(R.drawable.searching)
                .into(ivThumbnail);

        String synopsis = movie.getSynopsis();
        if (synopsis == null) {
            tvSynopsis.setTypeface(null, Typeface.ITALIC);
            synopsis = getResources().getString(R.string.no_synopsis_found);
        }
        tvSynopsis.setText(synopsis);

        tvRating.setText(movie.getRatingToString());

        String releaseYear = movie.getReleaseYear();
        if (releaseYear != null) {
            try {
                releaseYear = SimpleDateHelper.getLocalizedDate(this, releaseYear, movie.getDateFormat());
            } catch (ParseException e) {
                Log.e(DetailsMovieActivity.class.getSimpleName(), getString(R.string.error_parsing_date), e);
            }
        } else {
            tvReleaseYear.setTypeface(null, Typeface.ITALIC);
            releaseYear = getResources().getString(R.string.no_release_date_found);
        }
        tvReleaseYear.setText(releaseYear);
    }
}
