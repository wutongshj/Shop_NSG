package com.bwie.shop_nsg.sort.model;

import com.bwie.shop_nsg.sort.bean.DataleftBean;
import com.bwie.shop_nsg.sort.bean.DatarightBean;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import utils.RetroFactory_sort;

/**
 * Created by Administrator on 2017/11/8 0008.
 */

public class UserModel implements Imodel{

    DataleftBean leftbean;
    DatarightBean rightbean;
//    DateGridBean gridbean;

    private Sort_Finish onfinish;
    private Right_Finish finish;
//    private Grid_Finish grid_finish;

    public interface Sort_Finish{
        void sortmessage(DataleftBean leftbean);
    }
    public interface Right_Finish{
        void sortrightmessage(DatarightBean rightbean);
    }
//    public interface Grid_Finish{
//        void sortgridmessage(DateGridBean gridbean);
//    }


    public void setOnfinish(Sort_Finish onfinish) {
        this.onfinish = onfinish;
    }

    public void setrightfinish(Right_Finish finish) {
        this.finish = finish;
    }

//    public void setGrid_finish(Grid_Finish grid_finish) {
//        this.grid_finish = grid_finish;
//    }

    @Override
    public void getmessage() {
        leftbean=new DataleftBean();
        Observable<DataleftBean> getsort = RetroFactory_sort.getInstance().getsort();
        getsort.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DataleftBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(DataleftBean dataleftBean) {
                        leftbean=dataleftBean;
                        onfinish.sortmessage(leftbean);
                    }
                });

    }

    @Override
    public void getrightmessage(String id) {
        leftbean=new DataleftBean();
        Observable<DatarightBean> getrightsort = RetroFactory_sort.getInstance().getrightsort(id);
        getrightsort.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DatarightBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(DatarightBean dataleftBean) {
                        rightbean=dataleftBean;
                        finish.sortrightmessage(rightbean);
                    }
                });
    }

//    @Override
//    public void getgridmessage(String id2, Grid_Finish grid_finish) {
//
//    }
//
//    //    @Override
//    public void getgridmessage(String id2) {
//        gridbean=new DateGridBean();
//        Observable<DateGridBean> getgridsort = RetroFactory_sort.getInstance().getgridsort(id2);
//        getgridsort.subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<DateGridBean>() {
//                    @Override
//                    public void onCompleted() {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onNext(DateGridBean dateGridBean) {
//                        Log.d("maing",dateGridBean.getDatas().getClass_list().get(0).getGc_name()+"");
//                        gridbean=dateGridBean;
//                        grid_finish.sortgridmessage(dateGridBean);
//                    }
//                });
//    }
}
