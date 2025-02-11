package com.example.listamultimedia;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MultimediaAdapter adapter;
    private List<Multimedia> multimediaList;

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

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        multimediaList = new ArrayList<>();
        multimediaList.add(new Multimedia("Video Ejemplo", "android.resource://com.example.listamultimedia/" + R.raw.video_submarinista, "video"));
        multimediaList.add(new Multimedia("Audio Ejemplo", "android.resource://com.example.listamultimedia/" + R.raw.audio_guitar, "audio"));
        multimediaList.add(new Multimedia("Página Web", "https://www.google.com", "web"));

        adapter = new MultimediaAdapter(this, multimediaList);
        recyclerView.setAdapter(adapter);
    }
}