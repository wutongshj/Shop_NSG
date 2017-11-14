package com.bwie.shop_nsg.sort.model;

import android.widget.GridView;

import com.bwie.shop_nsg.sort.bean.DateGridBean;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import utils.RetroFactory_sort;

/**
 * Created by Administrator on 2017/11/14 0014.
 */

public class RightDataModel implements IRIghtDataModel {

    List<DateGridBean.DatasBean.ClassListBean> list = new ArrayList<>();

    private OnRightUserFinish onfinish;


    public interface OnRightUserFinish{
        void onFInishListener(List<DateGridBean.DatasBean.ClassListBean> list, GridView gridView);
    }

    public void setOnfinish(OnRightUserFinish onfinish) {
        this.onfinish = onfinish;
    }

    @Override
    public void getUrl(String url, String id, final GridView gridView) {
        Observable<DateGridBean> getrightsort = RetroFactory_sort.getInstance().getgridsort(id);
        getrightsort.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DateGridBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(DateGridBean dataleftBean) {
                        list = dataleftBean.getDatas().getClass_list();
                        onfinish.onFInishListener(list,gridView);
                    }
                });
    }
}
