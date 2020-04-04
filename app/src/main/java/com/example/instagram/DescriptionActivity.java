package com.example.instagram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class DescriptionActivity extends AppCompatActivity {

    private CircleImageView avatarView;
    private TextView nameView;
    private ImageView imageView;
    private ImageView likeView;
    private TextView viewView;
    private TextView name2View;
    private TextView descriptionView;
    private boolean liked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        Intent intent = getIntent();

        String avatar = intent.getStringExtra("avatar");
        String name = intent.getStringExtra("name");
        String image = intent.getStringExtra("image");
        String view = intent.getStringExtra("view");
        String description = intent.getStringExtra("description");
        liked = intent.getBooleanExtra("liked", false);

        avatarView = findViewById(R.id.detailedAvatar);
        nameView = findViewById(R.id.detailedName);
        imageView = findViewById(R.id.detailedImage);
        descriptionView = findViewById(R.id.detailedDescription);
        likeView = findViewById(R.id.detailedLike);
        name2View = findViewById(R.id.detailedName2);
        viewView = findViewById(R.id.detailedView);

        Glide.with(this)
                .asBitmap()
                .load(avatar)
                .into(avatarView);

        nameView.setText(name);
        if(liked){
            likeView.setImageResource(R.drawable.heart);
            liked = true;
        }else{
            likeView.setImageResource(R.drawable.passion);
            liked = false;
        }


        Glide.with(this)
                .asBitmap()
                .load(image)
                .into(imageView);

        viewView.setText(view);
        viewView.append(" просмотров");

        name2View.setText(name);

        descriptionView.setText(description);
    }
}
