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

        // Inicializar RecyclerView
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Crear lista de elementos multimedia
        multimediaList = new ArrayList<>();
        multimediaList.add(new Multimedia("Video Submarinista", "android.resource://com.example.listamultimedia/" + R.raw.video_submarinista, "video"));
//        multimediaList.add(new Multimedia("Video Documental", "android.resource://com.example.listamultimedia/" + R.raw.video_documental, "video"));
        multimediaList.add(new Multimedia("Audio Guitarra", "android.resource://com.example.listamultimedia/" + R.raw.audio_guitar, "audio"));
//        multimediaList.add(new Multimedia("Audio Jazz", "android.resource://com.example.listamultimedia/" + R.raw.audio_jazz, "audio"));
        multimediaList.add(new Multimedia("Google", "https://www.google.com", "web"));
        multimediaList.add(new Multimedia("Wikipedia", "https://www.wikipedia.org", "web"));

        // Configurar el adaptador
        adapter = new MultimediaAdapter(this, multimediaList);
        recyclerView.setAdapter(adapter);
    }
}
