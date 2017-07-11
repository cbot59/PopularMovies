package com.example.android.popularmovies;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by cbot59 on 10/07/17.
 */

public class Movie implements Parcelable {
    private static final String DATE_FORMAT = "yyyy-MM-dd";
    private String mTitle;
    private String mThumbnailUri;
    private String mSynopsis;
    private Double mRating;
    private String mReleaseYear;

    public Movie() {

    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public void setThumbnailUri(String mThumbnailUri) {
        this.mThumbnailUri = mThumbnailUri;
    }

    public void setSynopsis(String mSynopsis) {
        if (!mSynopsis.equals("null")) {
            this.mSynopsis = mSynopsis;
        }
    }

    public void setRating(Double mRating) {
        this.mRating = mRating;
    }

    public void setReleaseYear(String mReleaseYear) {
        if (!mReleaseYear.equals("null")) {
            this.mReleaseYear = mReleaseYear;
        }
    }

    public String getDateFormat() {
        return DATE_FORMAT;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getThumbnailUri() {
        final String TMDB_POSTER_BASE_URL = "https://image.tmdb.org/t/p/w185";
        return TMDB_POSTER_BASE_URL + mThumbnailUri;
    }

    public String getSynopsis() {
        return mSynopsis;
    }

    private Double getRating() {
        return mRating;
    }

    public String getRatingToString() {
        return String.valueOf(getRating() + "/10");
    }

    public String getReleaseYear() {
        return mReleaseYear;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mTitle);
        dest.writeString(mThumbnailUri);
        dest.writeString(mSynopsis);
        dest.writeValue(mRating);
        dest.writeString(mReleaseYear);
    }

    private Movie(Parcel in) {
        mTitle = in.readString();
        mThumbnailUri = in.readString();
        mSynopsis = in.readString();
        mRating = (Double) in.readValue(Double.class.getClassLoader());
        mReleaseYear = in.readString();
    }

    public static final Parcelable.Creator<Movie> CREATOR = new Parcelable.Creator<Movie>() {
        public Movie createFromParcel(Parcel source) {
            return new Movie(source);
        }

        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
}
