package com.example.listamultimedia;

import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;


public class VideoFragment extends Fragment {

    private static final String ARG_RUTA = "ruta";

    public static VideoFragment newInstance(String ruta) {
        VideoFragment fragment = new VideoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_RUTA, ruta);
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_video, container, false);
        VideoView videoView = view.findViewById(R.id.videoView);

        if (getArguments() != null) {
            String ruta = getArguments().getString(ARG_RUTA);
            if (ruta != null) {
                videoView.setVideoURI(Uri.parse(ruta));
                videoView.setMediaController(new MediaController(getContext()));
                videoView.requestFocus();
                videoView.start();
            }
        }

        return view;
    }
}