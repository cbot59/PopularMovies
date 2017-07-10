package com.example.android.popularmovies;

import java.util.List;

/**
 * Created by cbot59 on 10/07/17.
 */

public class Movie {
    String mTitle;
    String mYear;
    String mThumbnail;
    String mTrailerUri;

    private List<Movie> Movies;

    public Movie(String mTitle, String mYear, String mThumbnail, String mTrailerUri) {
        this.mTitle = mTitle;
        this.mYear = mYear;
        this.mThumbnail = mThumbnail;
        this.mTrailerUri = mTrailerUri;
    }
}
