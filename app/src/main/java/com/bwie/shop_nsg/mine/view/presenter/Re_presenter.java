package com.bwie.shop_nsg.mine.view.presenter;

import com.bwie.shop_nsg.mine.view.Bean.ReMessage;
import com.bwie.shop_nsg.mine.bean.UserBean;
import com.bwie.shop_nsg.mine.view.model.Re_Model;
import com.bwie.shop_nsg.mine.view.view.Re_Iview;

/**
 * Created by Administrator on 2017/11/13 0013.
 */

public class Re_presenter implements Re_Model.Finish {

    private final Re_Iview iview;
    private final Re_Model model;

    public Re_presenter(Re_Iview iview) {
        this.iview = iview;
        model=new Re_Model();
        model.setOnFinish(this);
    }

    public void geturl(UserBean bean){
        model.getData(bean);
    }

    @Override
    public void setFinishListenter(ReMessage list) {
        iview.getView(list);
    }
}
