package com.bwie.shop_nsg.sort.presenter;

import com.bwie.shop_nsg.sort.bean.DataleftBean;
import com.bwie.shop_nsg.sort.bean.DatarightBean;
import com.bwie.shop_nsg.sort.model.UserModel;
import com.bwie.shop_nsg.sort.view.Iview;

/**
 * Created by Administrator on 2017/11/8 0008.
 */

public class UserPresenter implements UserModel.Sort_Finish,UserModel.Right_Finish{

    private final Iview sort_iview;
    private final UserModel sort_model;

    public UserPresenter(Iview sort_iview) {
        this.sort_iview = sort_iview;
        sort_model=new UserModel();
        sort_model.setOnfinish(this);
        sort_model.setrightfinish(this);

    }

    public void getUser(){
        sort_model.getmessage();
    }

    public void getrightUser(String id){
        sort_model.getrightmessage(id);
    }

//    public void getgridData(String id2){
//        sort_model.getgridmessage(id2);
//    }

    @Override
    public void sortmessage(DataleftBean leftbean) {
        sort_iview.getData(leftbean);
    }

    @Override
    public void sortrightmessage(DatarightBean rightbean) {
        sort_iview.getrightData(rightbean);
    }

//    @Override
//    public void sortgridmessage(DateGridBean gridbean) {
//        sort_iview.getgridData(gridbean);
//    }
}
