package com.bwie.shop_nsg.home.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.shop_nsg.R;
import com.bwie.shop_nsg.home.adapter.RecyclerAdapter;
import com.bwie.shop_nsg.home.bean.HomeBean;
import com.bwie.shop_nsg.home.presenter.UserPresenter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/11/8 0008.
 */

public class Home extends Fragment implements Iview{


    private UserPresenter userPresenter;
    private XRecyclerView xr;

    private List<String > list=new ArrayList<>();
    //获取数据的开始
    private int curr;
    private RecyclerAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.item_home, null);


        userPresenter = new UserPresenter(this);
        userPresenter.getUser();


        //新加的
        xr= (XRecyclerView)view.findViewById(R.id.xre_xrv);
        //加布局管理器
        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        xr.setLayoutManager(layoutManager);

//        xr.setLoadingListener(new XRecyclerView.LoadingListener() {
//            @Override
//            public void onRefresh() {
//                curr=0;
//                list.clear();
//                getData(path_url,curr);
//                xr.refreshComplete();
//            }
//
//            @Override
//            public void onLoadMore() {
//                curr++;
//                getData(path_url,curr);
//                xr.refreshComplete();
//            }
//        });

        return view;

    }

    @Override
    public void getData(HomeBean list) {
        adapter=new RecyclerAdapter(getActivity(),list.getData());
        xr.setAdapter(adapter);
    }
}
