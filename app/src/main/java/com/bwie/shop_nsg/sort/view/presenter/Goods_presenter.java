package com.bwie.shop_nsg.sort.view.presenter;

import com.bwie.shop_nsg.sort.view.bean.ItemGoodsBean;
import com.bwie.shop_nsg.sort.view.model.Goods_model;
import com.bwie.shop_nsg.sort.view.view.Goods_iview;

/**
 * Created by Administrator on 2017/11/16 0016.
 */

public class Goods_presenter implements Goods_model.Goodsmessage{

    private final Goods_iview iview;
    private final Goods_model model;

    public Goods_presenter(Goods_iview iview) {
        this.iview = iview;
        model=new Goods_model();
        model.setMessage(this);
    }

    public void getgoodslist(String id){
        model.getgoodslist(id);
    }

    @Override
    public void setmessage(ItemGoodsBean goods) {
        iview.setmessage(goods);
    }
}
