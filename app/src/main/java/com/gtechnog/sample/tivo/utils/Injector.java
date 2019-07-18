package com.gtechnog.sample.tivo.utils;

import android.app.Application;

import com.gtechnog.sample.tivo.models.WTWRepository;
import com.gtechnog.sample.tivo.viewmodel.WTWRootViewModelFactory;

public class Injector {

    public static WTWRepository getWTWRepository() {
        return WTWRepository.getInstance();
    }

    public static WTWRootViewModelFactory getWTWRootViewModelFactory(Application application) {
        return new WTWRootViewModelFactory(application);
    }


}
