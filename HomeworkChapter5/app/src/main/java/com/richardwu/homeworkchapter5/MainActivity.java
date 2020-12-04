package com.richardwu.homeworkchapter5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.richardwu.homeworkchapter5.Service.VideoService;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private static final OkHttpClient client = new OkHttpClient.Builder().
            connectTimeout(60, TimeUnit.SECONDS).
            readTimeout(60, TimeUnit.SECONDS).
            writeTimeout(60, TimeUnit.SECONDS).build();

    private final Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api-sjtu-camp.bytedance.com/").
            addConverterFactory(GsonConverterFactory.create()).client(client).build();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button getButton = findViewById(R.id.button_get);
        Button postButton = findViewById(R.id.button_post);
        TextView listsText = findViewById(R.id.text_lists);

        getButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VideoService videoService = retrofit.create(VideoService.class);
                Call<VideoPojo> call = videoService.getVideoInfoList();
                Log.d("Main", "onClick: ");
                call.enqueue(new Callback<VideoPojo>() {
                    @Override
                    public void onResponse(Call<VideoPojo> call, Response<VideoPojo> response) {
                        Log.d("Main", "onResponse: http响应");
                        if (!response.isSuccessful()) {
                            return;
                        }
                        final VideoPojo videoPojo = response.body();
                        final List<VideoInfo> videoInfoList = videoPojo.getVideoLists();
                        StringBuilder stringBuilder = new StringBuilder();
                        for (int i = 0; i < videoInfoList.size(); ++i) {
                            final VideoInfo videoInfo = videoInfoList.get(i);
                            stringBuilder.append("学生ID ").append(videoInfo.getStudentId()).append(" ")
                                    .append("用户名 ").append(videoInfo.getUsername()).append("\n")
                                    .append("视频地址：").append(videoInfo.getVideoUrl()).append("\n");
                        }
                        listsText.setText(stringBuilder.toString());
                    }

                    @Override
                    public void onFailure(Call<VideoPojo> call, Throwable t) {
                        Log.d("Main", "onFailure: ");
                        t.printStackTrace();
                    }
                });
            }
        });

        postButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MultipartBody.Part imagePart = getAssets("cover_image","cov_image.png");
                MultipartBody.Part videoPart = getAssets("video","game_video.mp4");

                VideoService videoService = retrofit.create(VideoService.class);
                listsText.setText("开始上传");
                Call<PostResult> call = videoService.postVideo("bilibili","hello-kitty","what's this",imagePart,videoPart);
                call.enqueue(new Callback<PostResult>() {
                    @Override
                    public void onResponse(Call<PostResult> call, Response<PostResult> response) {
                        if (!response.isSuccessful()) {
                            return;
                        }
                        PostResult result = response.body();
                        if (result == null || !result.isSuccessful()) {
                            listsText.setText("请求返回为空");
                            return;
                        }
//                        VideoInfo videoInfo = result.getVideoInfo();
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("上传成功\n");
//                        stringBuilder.append("学生ID ").append(videoInfo.getStudentId()).append(" ")
//                                .append("用户名 ").append(videoInfo.getUsername()).append("\n")
//                                .append("视频地址：").append(videoInfo.getVideoUrl()).append("\n");
                        stringBuilder.append("视频url: ").append(result.getVideoUrl());
                        listsText.setText(stringBuilder.toString());
                    }

                    @Override
                    public void onFailure(Call<PostResult> call, Throwable t) {
                        listsText.setText("上传失败\n");
                        t.printStackTrace();
                    }
                });
            }
        });
    }

    private MultipartBody.Part getAssets( String partKey, String localFileName) {
        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"),fileNameToByte(localFileName));
        return MultipartBody.Part.createFormData(partKey,localFileName,requestFile);
    }

    private byte[]  fileNameToByte(String filename) {
        try {
            final AssetManager assetManager = this.getAssets();
            final InputStream inputStream = assetManager.open(filename);
            final ByteArrayOutputStream output = new ByteArrayOutputStream();
            byte[] buffer = new byte[40960];
            int n = 0;
            while (-1 != (n = inputStream.read(buffer))) {
                output.write(buffer, 0, n);
            }
            return output.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            return new byte[1];
        }
    }
}