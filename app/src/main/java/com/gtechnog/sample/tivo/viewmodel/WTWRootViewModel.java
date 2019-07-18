package com.gtechnog.sample.tivo.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.gtechnog.sample.tivo.models.FeedItemFind;
import com.gtechnog.sample.tivo.models.WTWRepository;
import com.gtechnog.sample.tivo.network.NetworkResponseListener;

import java.util.Objects;

public class WTWRootViewModel extends AndroidViewModel {

    private static final String TAG = WTWRootViewModel.class.getSimpleName();
    private WTWRepository repository;
    private MutableLiveData<FeedItemFind> rootTabs = new MutableLiveData<>();

    WTWRootViewModel(@NonNull Application application, WTWRepository wtwRepository) {
        super(application);
        this.repository = wtwRepository;
        prepareWTWRootTabs();
    }

    private void prepareWTWRootTabs() {
        repository.getWTWRootTabs(new NetworkResponseListener<FeedItemFind>() {
            @Override
            public void onSuccess(FeedItemFind type) {
                Log.d(TAG+"Gaurav", "onSuccess: got all the root tabs");
                rootTabs.postValue(type);
            }

            @Override
            public void onError() {
                Log.d(TAG+"Gaurav", "onError: error in getting root tabs");
            }
        });
    }

    public void getFeedItemList(String feedName) {
            repository.getTabFeedList(feedName, new NetworkResponseListener<FeedItemFind>() {
                @Override
                public void onSuccess(FeedItemFind type) {
                    Log.d(TAG+"Gaurav", "onSuccess: got all the tab data");
                }

                @Override
                public void onError() {
                    Log.d(TAG+"Gaurav", "onError: error in getting tab data");
                }
            });
    }

    private void getFeedListForATab(FeedItemFind type) {
        for (int i = 0; i< type.items.size(); i++) {
            final String feed = type.items.get(i).kernel.feedName;
            repository.getTabFeedList(feed, new NetworkResponseListener<FeedItemFind>() {
                @Override
                public void onSuccess(FeedItemFind type) {
                    Log.d(TAG+"Gaurav", "onSuccess: got all the tab data");
                    getItemsForFeedList(type);
                }

                @Override
                public void onError() {
                    Log.d(TAG+"Gaurav", "onError: error in getting tab data");
                }
            });
        }
    }

    private void getItemsForFeedList(FeedItemFind type) {
        for (int i = 0; i<type.items.size(); i++) {
            final String feed = type.items.get(i).kernel.feedName;
            repository.getTabFeedList(feed, new NetworkResponseListener<FeedItemFind>() {
                @Override
                public void onSuccess(FeedItemFind type) {
                    Log.d(TAG+"Gaurav", "onSuccess: got the content ids");
                }

                @Override
                public void onError() {
                    Log.d(TAG+"Gaurav", "onError: error in getting content ids");
                }
            });
        }
    }

    public MutableLiveData<FeedItemFind> getRootTabs() {
        return rootTabs;
    }
}
