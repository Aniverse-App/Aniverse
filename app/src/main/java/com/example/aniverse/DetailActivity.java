package com.example.aniverse;

import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.chaek.android.RatingBar;
import org.json.JSONException;
import org.json.JSONObject;

public class DetailActivity extends AppCompatActivity {

    private BaseObject detailItem;
    private RequestQueue requestQueue;
    private AppCompatImageView detailImage;
    private TextView detailTitle;
    private TextView detailDescription;
    private RatingBar ratingBar;
    private TextView genres;
    private TextView authors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manga_detail);

        requestQueue = Volley.newRequestQueue(this);

        detailImage = findViewById(R.id.detail_image);
        detailTitle = findViewById(R.id.detail_title);
        detailDescription = findViewById(R.id.detail_description);
        ratingBar = findViewById(R.id.rating_score);
        genres = findViewById(R.id.detail_genres);
        authors = findViewById(R.id.detail_authors);

        detailItem = (BaseObject) getIntent().getSerializableExtra("detailItem");
        if (detailItem != null) {
            getDetail(detailItem);
            if (detailItem.getType() == 2) {
                this.setTitle(R.string.manga_detail);
            }
        }

    }

    private void getDetail(BaseObject item) {
        String objectType = item.getType() == 1 ? "anime" : "manga";
        int id = item.getId();

        final String detailUrl = APIEndpoint.DETAIL_API_URL.replace("{type}", objectType).replace("{item_id}", Integer.toString(id));

        StringRequest stringRequest = new StringRequest(Request.Method.GET, detailUrl,
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                            try {
                                JSONObject responseJson = new JSONObject(response);
                                Glide.with(getApplicationContext()).load(Util.getDetailImageUrl(responseJson, detailItem.getImageUrl())).into(detailImage);
                                detailTitle.setText(Util.getTitle(responseJson, detailItem.getTitle()));
                                detailDescription.setText(Html.fromHtml(Util.getDescription(responseJson)));
                                ratingBar.setScore(Util.getRatingScore(responseJson));
                                genres.setText(Html.fromHtml(Util.getGenres(responseJson)));
                                String authorsStr = detailItem.getType() == 1 ? Util.getProducers(responseJson) : Util.getAuthors(responseJson);
                                authors.setText(Html.fromHtml(authorsStr));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i("response error", error.toString());
                        Toast.makeText(getApplicationContext(), APIEndpoint.API_FAILED, Toast.LENGTH_SHORT).show();
                    }
                }
        );
        // Add the request to the RequestQueue.
        this.requestQueue.add(stringRequest);
    }



}
