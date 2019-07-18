package com.gtechnog.sample.tivo.models;

import androidx.annotation.NonNull;

import com.gtechnog.sample.tivo.network.NetworkApi;
import com.gtechnog.sample.tivo.network.NetworkResponseListener;
import com.gtechnog.sample.tivo.network.RequestBody;
import com.gtechnog.sample.tivo.network.WTWApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WTWRepository {

    private static final String TAG = WTWRepository.class.getSimpleName();
    private static WTWRepository sInstance;
    private final Retrofit retrofit;
    private final WTWApi wtwapi;

    private WTWRepository() {
        retrofit = new Retrofit.Builder().baseUrl(NetworkApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        wtwapi = retrofit.create(WTWApi.class);
    }

    public static WTWRepository getInstance() {
        if (sInstance == null) {
            synchronized (WTWRepository.class) {
                if (sInstance == null) {
                    sInstance = new WTWRepository();
                }
            }
        }
        return sInstance;
    }

    public void getWTWRootTabs(final NetworkResponseListener<FeedItemFind> listener) {

        RequestBody body = new RequestBody("feedItemFind",    // TODO: Remove hard code value
                "tsn:8D000019025246D",                      // TODO: Remove hard code value
                10,                                    // TODO: Remove hard code value
                "/feedList/mobileRoot"                   // TODO: Remove hard code value
        );
        performFeedItemFind(body, listener);
    }

    public void getTabFeedList(@NonNull String feedName,  final NetworkResponseListener<FeedItemFind> listener) {
        RequestBody body = new RequestBody("feedItemFind",    // TODO: Remove hard code value
                "tsn:8D000019025246D",                      // TODO: Remove hard code value
                10,                                    // TODO: Remove hard code value
                feedName                                           // TODO: Remove hard code value
        );
        performFeedItemFind(body, listener);
    }

    private void performFeedItemFind(@NonNull RequestBody body,
                                     final NetworkResponseListener<FeedItemFind> listener) {
        Call<FeedItemFind> call = wtwapi.feedItemFind("feedItemFind", body);
        call.enqueue(new Callback<FeedItemFind>() {
            @Override
            public void onResponse(Call<FeedItemFind> call, Response<FeedItemFind> response) {
                if (listener != null) listener.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<FeedItemFind> call, Throwable t) {
                if (listener != null) listener.onError();
            }
        });
    }

}
