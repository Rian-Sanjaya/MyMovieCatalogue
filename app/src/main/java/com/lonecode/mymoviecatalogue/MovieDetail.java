package com.lonecode.mymoviecatalogue;

import android.os.Parcel;
import android.os.Parcelable;

public class MovieDetail implements Parcelable {
    private int photo;
    private String name;
    private String userScore;
    private String description;
    private String runtime;
    private String genres;

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUserScore() {
        return userScore;
    }

    public void setUserScore(String userScore) {
        this.userScore = userScore;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.photo);
        dest.writeString(this.name);
        dest.writeString(this.userScore);
        dest.writeString(this.description);
        dest.writeString(this.runtime);
        dest.writeString(this.genres);
    }

    public MovieDetail() {
    }

    protected MovieDetail(Parcel in) {
        this.photo = in.readInt();
        this.name = in.readString();
        this.userScore = in.readString();
        this.description = in.readString();
        this.runtime = in.readString();
        this.genres = in.readString();
    }

    public static final Parcelable.Creator<MovieDetail> CREATOR = new Parcelable.Creator<MovieDetail>() {
        @Override
        public MovieDetail createFromParcel(Parcel source) {
            return new MovieDetail(source);
        }

        @Override
        public MovieDetail[] newArray(int size) {
            return new MovieDetail[size];
        }
    };
}
