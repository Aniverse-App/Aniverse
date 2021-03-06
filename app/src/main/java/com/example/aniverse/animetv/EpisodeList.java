package com.example.aniverse.animetv;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.aniverse.R;
import com.example.aniverse.scraper.Anime;

import java.util.ArrayList;
import java.util.List;

public class EpisodeList extends AppCompatActivity {
    private static final String TAG = "EpisodeList";
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private List<List<String>> episodeList=new ArrayList<>();
    private RequestQueue requestQueue;
    private StringRequest stringRequest;
    private ProgressBar progressBar;
    private String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_episode_list);

        //This get the params from the intent.
        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            url = bundle.getString("url");
        }
        else{
            //This case causes errors.
        }

        recyclerView=findViewById(R.id.recyclerView);
        progressBar=findViewById(R.id.progressBar);

        progressBar.setVisibility(View.VISIBLE);
        recyclerViewAdapter=new RecyclerViewAdapter(episodeList,this);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Log.d(TAG,"Created Recycler View");




        requestQueue= Volley.newRequestQueue(this);
        stringRequest=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d(TAG,"Got Response");
                Anime anime = new Anime(response.toString());
                episodeList.addAll(anime.getAnimeEpisodeList());
                progressBar.setVisibility(View.INVISIBLE);
                recyclerViewAdapter.notifyItemRangeInserted(0,episodeList.size());

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG,"error in connection");
            }
        });
        requestQueue.add(stringRequest);
        Log.d(TAG,"Made the request");

    }
}
