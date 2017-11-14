package com.bwie.shop_nsg.mine.model;

import com.bwie.shop_nsg.mine.bean.LoginMessage;
import com.bwie.shop_nsg.mine.bean.UserBean;

import java.util.HashMap;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import utils.RetroFactory_login;

/**
 * Created by Administrator on 2017/11/8 0008.
 */

public class UserModel implements Imodel{

    private LoginMessage list;
    private OnFinish onFinish;

    public void setOnFinish(OnFinish onFinish) {
        this.onFinish = onFinish;
    }

    public interface OnFinish{
        void onFinishListenter(LoginMessage list);
    }

    @Override
    public void getMessage(UserBean bean) {

        list=new LoginMessage();
        HashMap<String, String> map = new HashMap<>();
        map.put("mobile",bean.getMobile());
        map.put("password",bean.getPassword());
        Observable<LoginMessage> message = RetroFactory_login.getInstance().getMessage(map);
        message.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginMessage>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(LoginMessage message) {
                        list=message;
                        onFinish.onFinishListenter(list);

                    }
                });
    }
}
