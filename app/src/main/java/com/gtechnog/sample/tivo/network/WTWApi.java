package com.gtechnog.sample.tivo.network;

import com.gtechnog.sample.tivo.models.FeedItemFind;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface WTWApi {

    @POST("mind32/")
    Call<FeedItemFind> feedItemFind(@Query("type") String requestType,
                                    @Body RequestBody body);

}
