package com.mohammad.ui.browse.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mohammad.ui.R;

public class FragmentAllGenres extends Fragment {

    private RecyclerView mRecyclerView ;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.fragment_all_genres,container,false);
        mRecyclerView = mView.findViewById(R.id.recycler_view_all_genres);
        return mView ;
    }
}
