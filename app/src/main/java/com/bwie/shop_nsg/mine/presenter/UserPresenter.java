package com.bwie.shop_nsg.mine.presenter;

import com.bwie.shop_nsg.mine.bean.LoginMessage;
import com.bwie.shop_nsg.mine.bean.UserBean;
import com.bwie.shop_nsg.mine.model.UserModel;
import com.bwie.shop_nsg.mine.view.Iview;

/**
 * Created by Administrator on 2017/11/8 0008.
 */

public class UserPresenter implements UserModel.OnFinish {

    private final Iview iview;
    private final UserModel model;

    public UserPresenter(Iview iview) {
        this.iview = iview;
        model=new UserModel();
        model.setOnFinish(this);
    }

    public void geturl(UserBean bean){
        model.getMessage(bean);
    }


    @Override
    public void onFinishListenter(LoginMessage list) {
        iview.getData(list);
    }
}
