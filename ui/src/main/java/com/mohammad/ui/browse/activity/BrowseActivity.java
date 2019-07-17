package com.mohammad.ui.browse.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.mohammad.presentation.MoviesViewModel;
import com.mohammad.ui.R;
import com.mohammad.ui.ViewModelFactory;
import com.mohammad.ui.browse.fragment.FragmentAllGenres;
import com.mohammad.ui.browse.fragment.FragmentAllMovies;
import com.mohammad.ui.browse.util.ViewPagerAdapter;
import com.mohammad.ui.mapper.MovieMapper;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class BrowseActivity extends DaggerAppCompatActivity{

    @Inject
    public MovieMapper mMapper ;

    @Inject
    public ViewModelFactory mViewModelFactory;

    @Inject
    public MoviesViewModel mViewModel;

//    @Inject
    public ViewPagerAdapter mViewPagerAdapter ;

    private ViewPager mViewPager ;
    private TabLayout mTabLayout ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse);

        mViewModel = ViewModelProviders.of(this, mViewModelFactory).get(MoviesViewModel.class);

        setUpViews();
    }

    private void setUpViewPager(){
//        mViewPagerAdapter = new ViewPagerAdapter(this.getSupportFragmentManager());
        mViewPagerAdapter.addFragment(new FragmentAllMovies());
        mViewPagerAdapter.addFragment(new FragmentAllGenres());
        mViewPager.setAdapter(mViewPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    private void setUpViews(){
        mViewPager = findViewById(R.id.view_pager);
        mTabLayout = findViewById(R.id.tab_layout);
    }
}
