package com.sola.github.dagger2demo.di.activity;

import com.sola.github.dagger2demo.di.base.ActivityComponent;
import com.sola.github.dagger2demo.di.base.SubComponentBuilder;
import com.sola.github.dagger2demo.di.scope.ActivityScope;
import com.sola.github.dagger2demo.ui.MainActivity;

import dagger.Module;
import dagger.Subcomponent;

/**
 * Created by slove
 * 2016/12/16.
 */
@ActivityScope
@Subcomponent(
        modules = MainActivityComponent.MainActivityModule.class
)
public interface MainActivityComponent extends ActivityComponent<MainActivity> {
    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================

    @Subcomponent.Builder
    interface Builder extends SubComponentBuilder<MainActivityModule, MainActivityComponent> {
    }

    @Module
    class MainActivityModule {

        public MainActivityModule() {
        }
    }

    // ===========================================================
    // Methods
    // ===========================================================

    void inject(MainActivity activity);

}