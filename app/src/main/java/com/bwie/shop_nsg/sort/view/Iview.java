package com.bwie.shop_nsg.sort.view;

import com.bwie.shop_nsg.sort.bean.DataleftBean;
import com.bwie.shop_nsg.sort.bean.DatarightBean;

/**
 * Created by Administrator on 2017/11/8 0008.
 */

public interface Iview {

    //获得左边的数据
    void getData(DataleftBean leftbean);

    //获得右边的数据
    void getrightData(DatarightBean rightbean);

    //获得右边GridView
//    void getgridData(DateGridBean gridbean);
}
