package com.beginning.attirare.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.beginning.attirare.Model.Post;
import com.beginning.attirare.R;
import com.google.firebase.auth.FirebaseUser;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {

    public Context mContext;
    public List<Post> mPost;
    private FirebaseUser firebaseUser;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_post, viewGroup, false);
        return new PostAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mPost.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView image_post, profpic_post, heart_post, cart_post, share_post;
        public TextView desc_post, pricetext_post, price_post;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image_post = itemView.findViewById(R.id.post_image);
            profpic_post = itemView.findViewById(R.id.profpic_post);
            heart_post = itemView.findViewById(R.id.heart_post);
            cart_post = itemView.findViewById(R.id.cart_post);
            share_post = itemView.findViewById(R.id.share_post);
            desc_post = itemView.findViewById(R.id.desc_post);
            pricetext_post = itemView.findViewById(R.id.pricetext_post);
            price_post = itemView.findViewById(R.id.price_post);

        }
    }
}
