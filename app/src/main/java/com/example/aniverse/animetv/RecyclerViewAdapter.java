package com.example.aniverse.animetv;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aniverse.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
    private static final String TAG = "RecyclerViewAdapter";
    private List<List<String>> episodeURLs;
    private Context context;
    public RecyclerViewAdapter(List<List<String>> episodeURLs, Context context) {
        this.episodeURLs = episodeURLs;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_list_item,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        viewHolder.name.setText(episodeURLs.get(i).get(0));
        final int  tmp_i=i;
        viewHolder.parent_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent=new Intent(context, VideoViewer.class);
                intent.putExtra("url",episodeURLs.get(tmp_i).get(1));
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return episodeURLs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
       TextView name;
       ConstraintLayout parent_layout;
       //Context context;
       public ViewHolder(@NonNull View itemView) {
           super(itemView);
           name=itemView.findViewById(R.id.episode_name);
           parent_layout=itemView.findViewById(R.id.parent_layout);
           //context=itemView.getContext();
       }
   }

}
