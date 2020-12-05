package com.richardwu.homeworkchapter5;

import com.google.gson.annotations.SerializedName;

public class VideoInfo {
    @SerializedName("_id") String id;
    @SerializedName("student_id") String studentId;
    @SerializedName("user_name") String username;
    @SerializedName("video_url") String videoUrl;
    @SerializedName("image_url") String imageUrl;

    public String getId() {
        return id;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getUsername() {
        return username;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }
}
