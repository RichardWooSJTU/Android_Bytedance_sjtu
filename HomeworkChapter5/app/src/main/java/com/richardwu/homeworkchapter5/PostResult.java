package com.richardwu.homeworkchapter5;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class PostResult {
    @SerializedName("results")
    private VideoInfo videoInfo;
    @SerializedName("url")
    private String videoUrl;
    @SerializedName("success")
    private boolean isSuccessful;

    public VideoInfo getVideoInfo() {
        return videoInfo;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public boolean isSuccessful() {
        return isSuccessful;
    }
}
