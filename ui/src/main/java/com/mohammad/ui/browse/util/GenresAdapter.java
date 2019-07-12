package com.mohammad.ui.browse.util;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mohammad.ui.R;
import com.mohammad.ui.model.Genre;

import java.util.List;

import javax.inject.Inject;

public class GenresAdapter extends RecyclerView.Adapter<GenresAdapter.GenreViewHolder>{

    private List<Genre> mGenres ;
    private MovieClickListener mListener;

    @Inject
    public GenresAdapter(){}

    @NonNull
    @Override
    public GenreViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new GenreViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_genre_row, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull GenreViewHolder mGenreViewHolder, int mPosition) {
        mGenreViewHolder.mGenreName.setText(mGenres.get(mPosition).getName());

        mGenreViewHolder.itemView.setOnClickListener(v ->
                mListener.onMovieClickListener(mGenreViewHolder.getAdapterPosition()));
    }

    @Override
    public int getItemCount() {
        return mGenres.size();
    }

    public class GenreViewHolder extends RecyclerView.ViewHolder{

        private TextView mGenreName ;

        public GenreViewHolder(@NonNull View itemView) {
            super(itemView);
            mGenreName = itemView.findViewById(R.id.txt_genre_name);
        }
    }
}
