package com.pao11.readerapp.injector.component;

import android.app.Activity;

import com.pao11.readerapp.injector.module.FragmentModule;
import com.pao11.readerapp.injector.scope.FragmentScope;

import dagger.Component;

/**
 * Created by pao11 on 2017/3/21.
 */

@FragmentScope
@Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {
    Activity getActivity();

}
