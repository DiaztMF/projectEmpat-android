package com.diazt.implicitintent;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.net.Uri;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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
        ImageButton google = findViewById(R.id.google);
        ImageButton youtube = findViewById(R.id.youtube);
        ImageButton gmail = findViewById(R.id.gmail);
        ImageButton drive = findViewById(R.id.drive);

        google.setOnClickListener(v -> {
            Uri uri = Uri.parse("https://www.google.com");
            Intent googleIntent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(googleIntent);
        });

        youtube.setOnClickListener(v -> {
            Uri uri = Uri.parse("https://www.youtube.com");
            Intent youtubeIntent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(youtubeIntent);
        });

        gmail.setOnClickListener(v -> {
            Uri uri = Uri.parse("https://www.gmail.com");
            Intent gmailIntent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(gmailIntent);
        });

        drive.setOnClickListener(v -> {
            Uri uri = Uri.parse("https://www.drive.com");
            Intent driveIntent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(driveIntent);
        });
    }
}