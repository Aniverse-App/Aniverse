package com.example.aniverse.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.aniverse.R;
import com.example.aniverse.GuessModeActivity;

import java.util.ArrayList;
import java.util.Random;

import static com.parse.Parse.getApplicationContext;

/**
 * A simple {@link Fragment} subclass.
 */
public class CharacterFragment extends Fragment {

    public static final String TAG = "CharacterFragment";
    Button quit;
    Button guessMode;
    Intent intent;
    LinearLayout mainMenuLayout;
    ArrayList<Integer> backgroundImages = new ArrayList<>();
    ImageView backgroundImage;

    void loadImageBackground() {
        //Let's load the different images into the arraylist
        backgroundImages.add(R.drawable.eren);
        backgroundImages.add(R.drawable.kaneki);
        backgroundImages.add(R.drawable.luffy);
        backgroundImages.add(R.drawable.naruto);
        backgroundImages.add(R.drawable.sasuke);
        backgroundImages.add(R.drawable.usopp);
        backgroundImages.add(R.drawable.zoro);
        backgroundImages.add(R.drawable.narutosmile);

        Random ranImageBackground= new Random();
        int randomizedIndex=ranImageBackground.nextInt(backgroundImages.size()-1);
        backgroundImage.setImageResource(backgroundImages.get(randomizedIndex));

    }

    public CharacterFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_character, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Binding variables with XML variables
        mainMenuLayout=(LinearLayout)view.findViewById(R.id.mainMenu);
        quit = (Button) view.findViewById(R.id.quit);
        // normalMode = (Button) view.findViewById(R.id.normalMode);
        // characterInfos = (Button) view.findViewById(R.id.characterInfos);
        guessMode=(Button)view.findViewById(R.id.guessMode);
        backgroundImage=(ImageView)view.findViewById(R.id.backgroundImage);

        //When we first open the app we want a background image to be displayed
        loadImageBackground();

        //Guess mode where character gets asked QuestionsActivity and he has to find out the appropriate character

        guessMode.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                intent= new Intent(getApplicationContext(), GuessModeActivity.class);
                startActivity(intent);
            }
        });
        //this button let users read info about anime characters
     /*  characterInfos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent=new Intent(getApplicationContext(), DisplayCharactersActivity.class);
                startActivity(intent);
            }
        });*/
        //Exit From App
        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finish();
            }
        });

    }

}