package com.example.listamultimedia;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class WebFragment extends Fragment {

    private static final String ARG_URL = "url";
    private static final String ARG_CONTENEDOR_ID = "contenedor_id";
    private int contenedorId;

    public static WebFragment newInstance(String url, int contenedorId) {
        WebFragment fragment = new WebFragment();
        Bundle args = new Bundle();
        args.putString(ARG_URL, url);
        args.putInt(ARG_CONTENEDOR_ID, contenedorId);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_web, container, false);
        WebView webView = view.findViewById(R.id.webView);
        Button btnVolver = view.findViewById(R.id.btnVolver);

        if (getArguments() != null) {
            contenedorId = getArguments().getInt(ARG_CONTENEDOR_ID);
            String url = getArguments().getString(ARG_URL);

            if (url != null) {
                // Configurar WebView
                WebSettings webSettings = webView.getSettings();
                webSettings.setJavaScriptEnabled(true);
                webSettings.setDomStorageEnabled(true);  // Habilitar almacenamiento local
                webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);  // Evitar problemas de caché

                // Manejar la carga de páginas dentro del WebView
                webView.setWebViewClient(new WebViewClient());

                // Cargar la URL
                webView.loadUrl(url);
            }
        }

        // Botón "Volver" que oculta el fragmento
        btnVolver.setOnClickListener(v -> {
            if (getActivity() != null) {
                getActivity().findViewById(contenedorId).setVisibility(View.GONE);
            }
        });

        return view;
    }
}
