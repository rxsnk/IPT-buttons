package com.example.trial1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private ImageButton superButton;
    private ImageButton likeButton;
    private ImageButton navHeartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // 1. superButton opens SecondActivity via Intent
        superButton = findViewById(R.id.superButton);
        if (superButton != null) {
            superButton.setOnClickListener(v -> {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            });
        }

        // 2. likeButton (post heart) shows Toast message
        likeButton = findViewById(R.id.imageButton5);
        if (likeButton != null) {
            likeButton.setOnClickListener(v -> {
                Toast.makeText(MainActivity.this, "Liked post!", Toast.LENGTH_SHORT).show();
            });
        }

        // 3. navHeartButton (navbar heart - imageButton14) opens SecondActivity via Intent
        navHeartButton = findViewById(R.id.imageButton14);
        if (navHeartButton != null) {
            navHeartButton.setOnClickListener(v -> {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            });
        }
    }

    // Function called by android:onClick="openSecondActivity" in XML for ImageButton14
    public void openSecondActivity(View view) {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        startActivity(intent);
    }
}