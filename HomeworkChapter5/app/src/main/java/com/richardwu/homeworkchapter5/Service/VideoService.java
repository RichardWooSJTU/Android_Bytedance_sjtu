package com.richardwu.homeworkchapter5.Service;

import com.richardwu.homeworkchapter5.PostResult;
import com.richardwu.homeworkchapter5.VideoPojo;

import java.util.List;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface VideoService {
    @GET("invoke/video")
    Call<VideoPojo> getVideoInfoList();

    @Multipart
    @POST("invoke/video")
    Call<PostResult> postVideo(@Query("student_id") String studentId, @Query("user_name")String userName, @Query("extra_value") String extraValue,
                               @Part MultipartBody.Part coverImage, @Part MultipartBody.Part video);
}
