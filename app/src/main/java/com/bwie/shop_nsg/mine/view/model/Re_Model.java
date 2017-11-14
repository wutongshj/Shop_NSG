package com.bwie.shop_nsg.mine.view.model;

import android.util.Log;

import com.bwie.shop_nsg.mine.view.Bean.ReMessage;
import com.bwie.shop_nsg.mine.bean.UserBean;

import java.util.HashMap;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import utils.RetroFactory_login;

/**
 * Created by Administrator on 2017/11/13 0013.
 */

public class Re_Model implements Re_Imodel {

    private ReMessage list;
    private Finish onFinish;

    public interface Finish{
        void setFinishListenter(ReMessage list);
    }

    public void setOnFinish(Finish onFinish) {
        this.onFinish = onFinish;
    }

    @Override
    public void getData(UserBean bean) {
        list=new ReMessage();
        HashMap<String, String> map = new HashMap<>();
        map.put("mobile",bean.getMobile());
        map.put("password",bean.getPassword());
        Observable<ReMessage> message = RetroFactory_login.getInstance().getReMessage(map);
        message.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ReMessage>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(ReMessage message) {
                        list=message;
                        Log.d("message2",message.getMsg());
                        onFinish.setFinishListenter(list);

                    }
                });
    }
}
