package com.mohammad.ui.browse.util;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private final String All_MOVIES_TITLE = "All Movies";
    private final String All_GENRES_TITLE = "All Genres";
    private List<Fragment> mFragments;

    @Inject
    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
        mFragments = new ArrayList<>();
    }

    @Override
    public Fragment getItem(int mPosition) {
        return mFragments.get(mPosition);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int mPosition) {
        if (mPosition == 0)
            return All_MOVIES_TITLE;
        return All_GENRES_TITLE;
    }

    public void addFragment(Fragment mFragment) {
        mFragments.add(mFragment);
    }
}
