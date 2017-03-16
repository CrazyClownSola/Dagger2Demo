package com.sola.github.dagger2demo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.sola.github.dagger2demo.R;
import com.sola.github.dagger2demo.di.app.AppComponent;
import com.sola.github.dagger2demo.di.base.HasComponent;
import com.sola.github.dagger2demo.navigator.BundleFactory;
import com.sola.github.dagger2demo.navigator.Navigator;
import com.sola.github.dagger2demo.ui.cj_demo.CJMainActivity;

import butterknife.OnClick;

/**
 * Created by Sola
 * 2017/2/23.
 */
public class EmptyActivity extends RxBaseActivity {

    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================

    // ===========================================================
    // Constructors
    // ===========================================================

    // ===========================================================
    // Getter & Setter
    // ===========================================================

    @SuppressWarnings("unchecked")
    private Navigator getNavigator() {
        return ((HasComponent<AppComponent>) getApplication()).getComponent().provideNavigator();
    }

    @SuppressWarnings("unchecked")
    private BundleFactory getBundleFactory() {
        return ((HasComponent<AppComponent>) getApplication()).getComponent().provideBundleFactory();
    }

    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty);
    }

    @Override
    protected void doAfterView() {
        findViewById(R.id.id_btn_cj_main).setOnClickListener(this::btnClick);
        findViewById(R.id.id_btn_main).setOnClickListener(this::btnClick);
        findViewById(R.id.id_btn_test).setOnClickListener(this::btnClick);
        findViewById(R.id.id_btn_binding).setOnClickListener(this::btnClick);
    }

    @Override
    protected void initExtras(Intent intent) {

    }

    // ===========================================================
    // Methods
    // ===========================================================

    @OnClick({
            R.id.id_btn_cj_main,
            R.id.id_btn_main,
            R.id.id_btn_test,
            R.id.id_btn_binding
    })
    public void btnClick(View view) {
        switch (view.getId()) {
            case R.id.id_btn_cj_main:
                getNavigator().switchActivity(
                        this,
                        CJMainActivity.class,
                        getBundleFactory()
                                .putString("title", "CJ_Main")
                                .build()
                );
                break;
            case R.id.id_btn_main:
                getNavigator().switchActivity(
                        this,
                        MainActivity.class,
                        getBundleFactory()
                                .putString("title", "Main")
                                .build()
                );
                break;
            case R.id.id_btn_test:
                break;

            case R.id.id_btn_binding:
                break;
        }
    }

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================

}
