package com.alamin.androidretrofit;

import com.google.gson.annotations.SerializedName;

public class Post {
    private Integer id;
    private int userId;
    private String title;

    public Post(int userId, String title, String text) {
        this.userId = userId;
        this.title = title;
        this.text = text;
    }

    @SerializedName("body")
    private String text;

    public int getUserId() {
        return userId;
    }
    public Integer getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getText() {
        return text;
    }
}
