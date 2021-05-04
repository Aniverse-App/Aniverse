package com.example.aniverse.fragments;


import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.SearchView;



import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
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

public class  AnimeFragment extends Fragment {
    private static final String TAG = "MainActivity";

    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private MainRecyclerViewAdapter mainRecyclerViewAdapter;
    private List<List<String>> animeList=new ArrayList<>();
    private RequestQueue requestQueue;
    private StringRequest stringRequest;
    private String url="http://www.anime1.com/ongoing/";
    private List<ArrayList<String>> allAnime;

    public AnimeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_anime, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        //Initializes all the objects
        progressBar= view.findViewById(R.id.progressBar);
        recyclerView= view.findViewById(R.id.mainRecyclerView);
        mainRecyclerViewAdapter=new MainRecyclerViewAdapter(animeList,getContext());
        recyclerView.setAdapter(mainRecyclerViewAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),3));

        //Gets all anime present in anime1 site.
        requestQueue= Volley.newRequestQueue(getContext());
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
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // Inflate the menu; this adds items to the action bar if it is present.
        inflater.inflate(R.menu.menu_search_bar, menu);
        super.onCreateOptionsMenu(menu, inflater);
        // Associate searchable configuration with the SearchView
        SearchManager searchManager =
                (SearchManager) getActivity().getSystemService(Context.SEARCH_SERVICE);
        MenuItem searchItem = menu.findItem(R.id.menuSearch);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(new ComponentName(getContext(), SearchActivity.class)));
    }
}

