package com.bwie.shop_nsg.sort.view.model;

import android.util.Log;

import com.bwie.shop_nsg.sort.view.bean.ItemGoodsBean;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import utils.RetroFactory_itemgood;

/**
 * Created by Administrator on 2017/11/16 0016.
 */

public class Goods_model implements Goods_imodel {

    ItemGoodsBean goods;
    private Goodsmessage message;

    public interface Goodsmessage{
        void setmessage(ItemGoodsBean goods);
    }

    public void setMessage(Goodsmessage message) {
        this.message = message;
    }

    @Override
    public void getgoodslist(final String goodsid) {
        Log.d("goodsid",goodsid);
        goods=new ItemGoodsBean();
        final Observable<ItemGoodsBean> getgoods = RetroFactory_itemgood.getInstance().getgoods(goodsid);
        getgoods.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ItemGoodsBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(ItemGoodsBean itemGoods) {
                        Log.d("goods",itemGoods.getMsg());
                        goods=itemGoods;
                        message.setmessage(goods);
                    }
                });
    }

}
