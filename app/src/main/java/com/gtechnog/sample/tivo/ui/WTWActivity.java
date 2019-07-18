package com.gtechnog.sample.tivo.ui;

import android.app.Application;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.gtechnog.sample.tivo.R;
import com.gtechnog.sample.tivo.models.FeedItemFind;
import com.gtechnog.sample.tivo.utils.Injector;
import com.gtechnog.sample.tivo.viewmodel.WTWRootViewModel;

public class WTWActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wtw);

        // Viewmodel setup
        WTWRootViewModel viewModel = ViewModelProviders.of(this,
                Injector.getWTWRootViewModelFactory((Application) getApplicationContext()))
                .get(WTWRootViewModel.class);

        final WTWViewPagerAdapter pagerAdapter = new WTWViewPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(pagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        viewModel.getRootTabs().observe(this, new Observer<FeedItemFind>() {
            @Override
            public void onChanged(FeedItemFind feedItemFind) {
                pagerAdapter.setRootTabs(feedItemFind.items);
            }
        });
    }
}