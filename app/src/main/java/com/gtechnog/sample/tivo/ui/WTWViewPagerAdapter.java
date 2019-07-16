package com.gtechnog.sample.tivo.ui;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentStatePagerAdapter {

    private final Context mContext;

    SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        return WTWTabFragment.newInstance(position + 1);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return "hello";
    }

    @Override
    public int getCount() {
        return 2;
    }
}