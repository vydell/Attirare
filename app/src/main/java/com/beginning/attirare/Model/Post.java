package com.beginning.attirare.Model;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Post {

    private String postImage;

    public Post(String postid, String postImage, String description) {
        this.postImage = postImage;
    }

    public Post() {

    }
    public String getPostImage() {
        return postImage;
    }

    public void setPostImage(String postImage) {
        this.postImage = postImage;
    }
}
