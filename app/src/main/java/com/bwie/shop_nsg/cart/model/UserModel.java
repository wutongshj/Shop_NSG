package com.bwie.shop_nsg.cart.model;

import android.util.Log;

import com.bwie.shop_nsg.cart.bean.SearchCartBean;

import java.util.HashMap;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import utils.RetroFactory_car;

/**
 * Created by Administrator on 2017/11/8 0008.
 */

public class UserModel implements Imodel{

    SearchCartBean car;
    private Carsel carsel;

    public interface Carsel{
        void setcars(SearchCartBean car);
    }

    public void setCarsel(Carsel carsel) {
        this.carsel = carsel;
    }

    @Override
    public void getcargoods(String uid) {
        HashMap<String,String> map=new HashMap<>();
        map.put("uid",uid);
        Observable<SearchCartBean> selcar = RetroFactory_car.getInstance().selcar(map);
        selcar.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SearchCartBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(SearchCartBean carSelectBean) {
                        Log.d("cars",carSelectBean.getMsg());
                        car=carSelectBean;
                        carsel.setcars(car);
                    }
                });
    }
}
