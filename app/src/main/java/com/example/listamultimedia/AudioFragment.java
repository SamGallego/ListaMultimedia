package com.example.listamultimedia;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class AudioFragment extends Fragment {

    private static final String ARG_RUTA = "ruta";
    private MediaPlayer mediaPlayer;

    public static AudioFragment newInstance(String ruta) {
        AudioFragment fragment = new AudioFragment();
        Bundle args = new Bundle();
        args.putString(ARG_RUTA, ruta);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_audio, container, false);
        Button btnPlay = view.findViewById(R.id.btnPlay);
        mediaPlayer = MediaPlayer.create(getContext(), Uri.parse(getArguments().getString(ARG_RUTA)));

        btnPlay.setOnClickListener(v -> mediaPlayer.start());
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
