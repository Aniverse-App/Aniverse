package com.example.aniverse.fragments;


import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SearchView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.aniverse.R;
import com.example.aniverse.animetv.MainRecyclerViewAdapter;
import com.example.aniverse.animetv.SearchActivity;
import com.example.aniverse.scraper.SiteTools;

import java.util.ArrayList;
import java.util.List;

public class AnimeFragment extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private MainRecyclerViewAdapter mainRecyclerViewAdapter;
    private List<List<String>> animeList=new ArrayList<>();
    private RequestQueue requestQueue;
    private StringRequest stringRequest;
    private String url="http://www.anime1.com/ongoing/";
    private List<ArrayList<String>> allAnime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initializes all the objects
        progressBar=findViewById(R.id.progressBar);
        recyclerView=findViewById(R.id.mainRecyclerView);
        mainRecyclerViewAdapter=new MainRecyclerViewAdapter(animeList,this);
        recyclerView.setAdapter(mainRecyclerViewAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));

        //Gets all anime present in anime1 site.
        requestQueue= Volley.newRequestQueue(this);
        stringRequest=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d(TAG,"Got Response");
                animeList.addAll(SiteTools.getOngoingAnimeList(response));
                progressBar.setVisibility(View.INVISIBLE);
                mainRecyclerViewAdapter.notifyItemRangeInserted(0,animeList.size());

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_search_bar, menu);
        // Associate searchable configuration with the SearchView
        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        MenuItem searchItem = menu.findItem(R.id.menuSearch);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(new ComponentName(this, SearchActivity.class)));
        return true;
    }
}

