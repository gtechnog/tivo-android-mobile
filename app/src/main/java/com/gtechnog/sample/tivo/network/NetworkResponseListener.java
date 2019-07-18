package com.gtechnog.sample.tivo.network;

public interface NetworkResponseListener<T> {
    void onSuccess(T type);
    void onError();
}
