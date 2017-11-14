package utils;


import com.bwie.shop_nsg.home.bean.HomeBean;
import com.bwie.shop_nsg.mine.bean.LoginMessage;
import com.bwie.shop_nsg.mine.view.Bean.ReMessage;
import com.bwie.shop_nsg.sort.bean.DataleftBean;
import com.bwie.shop_nsg.sort.bean.DatarightBean;
import com.bwie.shop_nsg.sort.bean.DateGridBean;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by fan on 2017/11/8.
 */

public interface ApiServer {

    @GET("umIPmfS6c83237d9c70c7c9510c9b0f97171a308d13b611?uri=homepage")
    Observable<HomeBean> getHome();

    @POST("user/login")
    Observable<LoginMessage> getMessage(@QueryMap Map<String,String> map);

    @POST("user/reg")
    Observable<ReMessage> getReMessage(@QueryMap Map<String,String> map);

    @GET("index.php?act=goods_class")
    Observable<DataleftBean> getsort();

    @GET("index.php?act=goods_class")
    Observable<DatarightBean> getrightsort(@Query("gc_id") String id);

    @GET("index.php?act=goods_class")
    Observable<DateGridBean> getgridsort(@Query("gc_id") String id2);
}
