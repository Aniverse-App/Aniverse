package com.example.aniverse.login;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.aniverse.R;
import com.example.aniverse.fragments.AnimeFragment;
import com.example.aniverse.fragments.CharacterFragment;
import com.example.aniverse.fragments.ComposeFragment;
import com.example.aniverse.fragments.DiscussionFragment;
import com.example.aniverse.fragments.MangaFragment;
import com.example.aniverse.fragments.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";

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
}


