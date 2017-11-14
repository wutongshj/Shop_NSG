package com.bwie.shop_nsg.sort.view;

import android.widget.GridView;

import com.bwie.shop_nsg.sort.bean.DateGridBean;

import java.util.List;

/**
 * Created by Administrator on 2017/11/14 0014.
 */

public interface IRightDataView {
    void getData(List<DateGridBean.DatasBean.ClassListBean> list, GridView gridView);
}
