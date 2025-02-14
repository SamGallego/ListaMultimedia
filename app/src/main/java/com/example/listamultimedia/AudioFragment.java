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
    private static final String ARG_CONTENEDOR_ID = "contenedor_id";
    private MediaPlayer mediaPlayer;
    private int contenedorId;

    // Nueva función newInstance que acepta ruta y contenedorId
    public static AudioFragment newInstance(String ruta, int contenedorId) {
        AudioFragment fragment = new AudioFragment();
        Bundle args = new Bundle();
        args.putString(ARG_RUTA, ruta);
        args.putInt(ARG_CONTENEDOR_ID, contenedorId);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_audio, container, false);
        Button btnPlay = view.findViewById(R.id.btnPlay);
        Button btnVolver = view.findViewById(R.id.btnVolver);

        if (getArguments() != null) {
            contenedorId = getArguments().getInt(ARG_CONTENEDOR_ID);
            mediaPlayer = MediaPlayer.create(getContext(), Uri.parse(getArguments().getString(ARG_RUTA)));
        }

        btnPlay.setOnClickListener(v -> mediaPlayer.start());

        // Botón "Volver" que oculta el contenedor del fragmento
        btnVolver.setOnClickListener(v -> {
            if (getActivity() != null) {
                getActivity().findViewById(contenedorId).setVisibility(View.GONE);
            }
        });

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
