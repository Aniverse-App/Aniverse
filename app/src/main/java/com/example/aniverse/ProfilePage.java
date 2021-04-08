package com.example.aniverse;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ProfilePage extends AppCompatActivity {
    ImageView profileImage;
    TextView username;
    Button changeImage;
    @Override
    public void onCreate (Bundle savedInstanceState) {
        setContentView(R.layout.profile_activity);
        super.onCreate(savedInstanceState);
        username = findViewById(R.id.rvUsername); //change it to another username
        profileImage = findViewById(R.id.rvProfileImage);
        changeImage = findViewById(R.id.rvChangeImage);

        changeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //open Gallery
                Intent openGalleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(openGalleryIntent, 1); //change request code later
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1){
            if(resultCode == Activity.RESULT_OK){
                Uri imagineUri =data.getData();
                profileImage.setImageURI(imagineUri);
            }
        }

    }

}
