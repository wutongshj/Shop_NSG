package com.bwie.shop_nsg.home.model;

import android.util.Log;

import com.bwie.shop_nsg.home.bean.HomeBean;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import utils.RetroFactory;

/**
 * Created by Administrator on 2017/11/8 0008.
 */

public class UserModel implements Imodel{

   HomeBean list;
    private Onfinish onfinish;

    public interface Onfinish{
        void  OnFinishListener(HomeBean list);
    }

    public UserModel(Onfinish onfinish) {
        this.onfinish = onfinish;
    }

    @Override
    public void getUrl() {

        Log.d("main2","=================");
        list=new HomeBean();

        final Observable<HomeBean> home = RetroFactory.getInstance().getHome();
        home.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HomeBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("main2","onError");
                    }

                    @Override
                    public void onNext(HomeBean homeBean) {

                        Log.d("main2",homeBean.getCode()+"====");
                        list = homeBean;
                        onfinish.OnFinishListener(list);
                    }
                });
    }
}
