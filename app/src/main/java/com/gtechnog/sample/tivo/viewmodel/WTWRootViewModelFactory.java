package com.gtechnog.sample.tivo.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.gtechnog.sample.tivo.utils.Injector;

public class WTWRootViewModelFactory extends ViewModelProvider.AndroidViewModelFactory {

    private Application application;
    public WTWRootViewModelFactory(@NonNull Application application) {
        super(application);
        this.application = application;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new WTWRootViewModel(application, Injector.getWTWRepository());
    }
}
