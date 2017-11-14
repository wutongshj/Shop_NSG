package com.bwie.shop_nsg.home.presenter;

import com.bwie.shop_nsg.home.bean.HomeBean;
import com.bwie.shop_nsg.home.model.UserModel;
import com.bwie.shop_nsg.home.view.Iview;

/**
 * Created by Administrator on 2017/11/8 0008.
 */

public class UserPresenter implements UserModel.Onfinish{

    private final Iview userview;
    private final UserModel usermodel;

    public UserPresenter(Iview userview) {
        this.userview = userview;
        usermodel=new UserModel(this);

    }

    public void getUser(){
        usermodel.getUrl();
    }


    @Override
    public void OnFinishListener(HomeBean list) {
        userview.getData(list);
    }
}
