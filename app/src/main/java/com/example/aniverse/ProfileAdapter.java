package com.example.aniverse;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.aniverse.login.Post;

import java.util.List;

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ViewHolder> {
    List<Post>posts;
    Context context;
    public ProfileAdapter(Context context, List<Post>posts) {
        this.context = context;
        this.posts = posts;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ImageView view = new ImageView(context);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(posts.get(position));
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imagePosts;
        public ViewHolder(@NonNull ImageView itemView) {
            super(itemView);
            imagePosts = itemView;
        }

        public void bind(Post post){
            String imagePath = post.getImage().getUrl();
            Glide.with(context).load(imagePath).into(imagePosts);
        }
    }
}
