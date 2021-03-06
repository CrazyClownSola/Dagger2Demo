package com.sola.github.dagger2demo.di.app;

import android.app.Application;
import android.content.Context;

import com.sola.github.dagger2demo.executor.NetExecutor;
import com.sola.github.dagger2demo.executor.UIThread;
import com.sola.github.data.exception.ErrorDelegateImpl;
import com.sola.github.data.net.AApiConnection;
import com.sola.github.data.net.ApiHttpConnection;
import com.sola.github.data.net.ApiHttpsConnection;
import com.sola.github.data.repository.BBSDataRepository;
import com.sola.github.data.repository.demo.UserCenterDataDemoRepository;
import com.sola.github.data.scope.HttpRestAdapter;
import com.sola.github.data.scope.HttpsRestAdapter;
import com.sola.github.domain.exception.ErrorDelegate;
import com.sola.github.domain.executor.NetExecutorThread;
import com.sola.github.domain.executor.UIExecutorThread;
import com.sola.github.domain.interactor.ABBSCase;
import com.sola.github.domain.interactor.impl.BBSCaseImpl;
import com.sola.github.domain.repository.repository.BBSRepository;
import com.sola.github.domain.repository.repository.UserCenterRepository;
import com.sola.github.tools.utils.LogUtils;

import java.lang.ref.WeakReference;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by slove
 * 2016/12/14.
 * 标记接口：指定Application生命周期中所持有的实例
 */
@Module
public class AppModule {
    // ===========================================================
    // Constants
    // ===========================================================

    private final static String TAG = "Sola/AppModule";

    // ===========================================================
    // Fields
    // ===========================================================

    private final WeakReference<Application> mApplication;

    // ===========================================================
    // Constructors
    // ===========================================================

    public AppModule(Application mApplication) {
        LogUtils.i(TAG, "AppModule call");
        this.mApplication = new WeakReference<>(mApplication);
    }

    // ===========================================================
    // Getter & Setter
    // ===========================================================

    // ===========================================================
    // 工具类映射
    // ===========================================================

    @Provides //This annotation means that method below provides dependency 自己翻译去
    @Singleton
    Context provideApplication() {
        return mApplication.get();
    }

    @Provides
    @Singleton
    NetExecutorThread provideNetExecutorThread(NetExecutor executor) {
        return executor;
    }

    @Provides
    @Singleton
    UIExecutorThread provideUIExecutorThread(UIThread thread) {
        return thread;
    }

    @Provides
    @Singleton
    ErrorDelegate provideErrorDelegate(ErrorDelegateImpl impl) {
        return impl;
    }

    @Provides
    @Singleton
    @HttpRestAdapter
        // 作为一种标识存在
    AApiConnection provideApiHttpConnection(ApiHttpConnection impl) {
        return impl;
    }

    @Provides
    @Singleton
    @HttpsRestAdapter
        // 作为标识存在
    AApiConnection provideApiHttpsConnection(ApiHttpsConnection impl) {
        return impl;
    }

    // ===========================================================
    // Case集合的映射类
    // ===========================================================

    @Provides
    @Singleton
    ABBSCase provideABBSCase(BBSCaseImpl impl) {
        return impl;
    }

    @Provides
    @Singleton
    BBSRepository provideBBSRepository(BBSDataRepository repository) {
        return repository;
    }

//    @Provides
//    @Singleton
//    UserCenterRepository provideUserCenterRepository(UserCenterDataDemoRepository repository) {
//        return repository;
//    }

    @Provides
    @Singleton
    UserCenterRepository provideUserCenterRepository(
            UserCenterDataDemoRepository repository) { // 这里可以切换实例的绑定可以在一个适当的时间将demo实例废弃
        return repository;
    }

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================

}
