package com.bwie.shop_nsg.sort.presenter;

import android.util.Log;
import android.widget.GridView;

import com.bwie.shop_nsg.sort.bean.DateGridBean;
import com.bwie.shop_nsg.sort.model.RightDataModel;
import com.bwie.shop_nsg.sort.view.IRightDataView;

import java.util.List;

/**
 * Created by Administrator on 2017/11/14 0014.
 */

public class RightDataPresenter implements RightDataModel.OnRightUserFinish{
    private final IRightDataView userview;
    private final RightDataModel usermodel;

    public RightDataPresenter(IRightDataView userview) {
        this.userview = userview;
        this.usermodel = new RightDataModel();
        usermodel.setOnfinish(this);
    }

    public void getUrl(String url, String str, GridView gridView){
        usermodel.getUrl(url,str,gridView);
    }

    @Override
    public void onFInishListener(List<DateGridBean.DatasBean.ClassListBean> list, GridView gridView) {
        Log.d("Main","!!!!!!!!!!!!!!!!!!!!!!!!");
        userview.getData(list,gridView);
    }
}
