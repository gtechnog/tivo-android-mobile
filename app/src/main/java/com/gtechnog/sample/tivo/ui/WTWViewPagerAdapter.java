package com.gtechnog.sample.tivo.ui;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.gtechnog.sample.tivo.models.Item;

import java.util.ArrayList;

public class WTWViewPagerAdapter extends FragmentStatePagerAdapter {

    private final Context mContext;
    private ArrayList<Item> mRootTabItems;

    WTWViewPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        return WTWTabFragment.newInstance(mRootTabItems.get(position).itemId,
                mRootTabItems.get(position).kernel.feedName);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (mRootTabItems != null) {
            return mRootTabItems.get(position).details.caption;
        }
        return "";
    }

    @Override
    public int getCount() {
        if (mRootTabItems != null) {
            return mRootTabItems.size();
        }
        return 0;
    }

    void setRootTabs(ArrayList<Item> items) {
        mRootTabItems = items;
        notifyDataSetChanged();
    }
}