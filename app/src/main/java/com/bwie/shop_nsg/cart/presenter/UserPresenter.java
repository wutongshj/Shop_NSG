package com.bwie.shop_nsg.cart.presenter;

import com.bwie.shop_nsg.cart.bean.SearchCartBean;
import com.bwie.shop_nsg.cart.model.UserModel;
import com.bwie.shop_nsg.cart.view.Iview;

/**
 * Created by Administrator on 2017/11/8 0008.
 */

public class UserPresenter implements UserModel.Carsel{

    private final Iview view;
    private final UserModel model;

    public UserPresenter(Iview view) {
        this.view = view;
        model=new UserModel();
        model.setCarsel(this);
    }

    public void getUser(String uid){
        model.getcargoods(uid);
    }

    @Override
    public void setcars(SearchCartBean car) {
        view.getview(car);
    }

}
