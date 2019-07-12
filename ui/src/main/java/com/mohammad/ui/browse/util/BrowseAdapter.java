package com.mohammad.ui.browse.util;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mohammad.ui.R;
import com.mohammad.ui.model.Movie;

import java.util.List;

import javax.inject.Inject;

public class BrowseAdapter extends RecyclerView.Adapter<BrowseAdapter.BrowseViewHolder> {

    private List<Movie> mMovies;
    private MovieClickListener mListener;

    @Inject
    BrowseAdapter() {
    }

    @NonNull
    @Override
    public BrowseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int mViewType) {
        return new BrowseViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_movie_row, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final BrowseViewHolder mBrowseViewHolder, int mPosition) {
        Movie mMovie = mMovies.get(mPosition);
        mBrowseViewHolder.mMovieName.setText(mMovie.getTitle());
        mBrowseViewHolder.mMovieName.setText(mMovie.getGenres());

        Glide.with(mBrowseViewHolder.itemView.getContext())
                .load(mMovie.getPoster())
                .into(mBrowseViewHolder.mMovieImage);

        mBrowseViewHolder.itemView.setOnClickListener(v ->
                mListener.onMovieClickListener(mBrowseViewHolder.getAdapterPosition()));
//        mBrowseViewHolder.mMovieImage.setImageDrawable();
    }

    @Override
    public int getItemCount() {
        return mMovies.size();
    }

    public class BrowseViewHolder extends RecyclerView.ViewHolder {

        private TextView mMovieName;
        private TextView mGenres;
        private ImageView mMovieImage;

        public BrowseViewHolder(@NonNull View itemView) {
            super(itemView);

            mMovieName = itemView.findViewById(R.id.txt_movie_title);
            mGenres = itemView.findViewById(R.id.txt_movie_genres);
            mMovieImage = itemView.findViewById(R.id.img_movie_poster);
        }
    }
}
