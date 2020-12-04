package com.richardwu.homeworkchapter5;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class VideoPojo {
    @SerializedName("feeds")
    private ArrayList<VideoInfo> videoLists;

    @SerializedName("success")
    private boolean isSuccess;

    public ArrayList<VideoInfo> getVideoLists() {
        return videoLists;
    }

}
