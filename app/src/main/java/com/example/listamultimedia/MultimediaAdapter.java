package com.example.listamultimedia;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MultimediaAdapter extends RecyclerView.Adapter<MultimediaAdapter.ViewHolder> {

    private List<Multimedia> multimediaList;
    private FragmentActivity activity;

    public MultimediaAdapter(FragmentActivity activity, List<Multimedia> multimediaList) {
        this.activity = activity;
        this.multimediaList = multimediaList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.multimedia, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Multimedia multimedia = multimediaList.get(position);
        holder.tvTitulo.setText(multimedia.getTitulo());

        // Generar un ID único para cada contenedor
        if (holder.itemFragmentContainer.getId() == View.NO_ID) {
            holder.itemFragmentContainer.setId(View.generateViewId());
        }

        holder.btnVer.setOnClickListener(v -> {
            Fragment fragment;
            switch (multimedia.getTipo()) {
                case "video":
                    fragment = VideoFragment.newInstance(multimedia.getRuta(), holder.itemFragmentContainer.getId());
                    break;
                case "audio":
                    fragment = AudioFragment.newInstance(multimedia.getRuta(), holder.itemFragmentContainer.getId());
                    break;
                case "web":
                default:
                    fragment = WebFragment.newInstance(multimedia.getRuta(), holder.itemFragmentContainer.getId());
                    break;
            }

            // Hacer visible el contenedor del fragmento SOLO en este ítem
            holder.itemFragmentContainer.setVisibility(View.VISIBLE);

            // Reemplazar solo en este contenedor
            FragmentManager fragmentManager = activity.getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(holder.itemFragmentContainer.getId(), fragment)
                    .commit();
        });
    }

    @Override
    public int getItemCount() {
        return multimediaList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitulo;
        Button btnVer;
        FrameLayout itemFragmentContainer;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitulo = itemView.findViewById(R.id.tvTitulo);
            btnVer = itemView.findViewById(R.id.btnVer);
            itemFragmentContainer = itemView.findViewById(R.id.itemFragmentContainer);
        }
    }
}
