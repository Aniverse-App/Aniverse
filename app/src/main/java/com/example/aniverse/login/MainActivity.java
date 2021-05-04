package com.example.aniverse.login;

import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.example.aniverse.R;
import com.example.aniverse.animetv.SearchActivity;
import com.example.aniverse.fragments.AnimeFragment;
import com.example.aniverse.fragments.CharacterFragment;
import com.example.aniverse.fragments.DiscussionFragment;
import com.example.aniverse.fragments.MangaFragment;
import com.example.aniverse.fragments.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {
    public static final String TAG = "AnimeActivity";

    final FragmentManager fragmentManager = getSupportFragmentManager();
    private BottomNavigationView bottomNavigationView;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);

        bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment fragment;
                switch (menuItem.getItemId()) {
                    case R.id.action_anime:
                        Toast.makeText(MainActivity.this, "Anime!", Toast.LENGTH_SHORT).show();
                        fragment = new AnimeFragment();
                        break;
                    case R.id.action_manga:
                        Toast.makeText(MainActivity.this, "Manga!", Toast.LENGTH_SHORT).show();
                        fragment = new MangaFragment();
                        break;
                    case R.id.action_character:
                        Toast.makeText(MainActivity.this, "Character!", Toast.LENGTH_SHORT).show();
                        fragment = new CharacterFragment();
                        break;
                    case R.id.action_discussion:
                        Toast.makeText(MainActivity.this, "Discussion!", Toast.LENGTH_SHORT).show();
                        fragment = new DiscussionFragment();
                        break;
                    case R.id.action_profile:
                    default:
                        Toast.makeText(MainActivity.this, "Profile!", Toast.LENGTH_SHORT).show();
                        fragment = new ProfileFragment();
                        break;
                }
                fragmentManager.beginTransaction().replace(R.id.flContainer, fragment).commit();
                return true;
            }
        });
        // Set default selection
        bottomNavigationView.setSelectedItemId(R.id.action_anime);
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



