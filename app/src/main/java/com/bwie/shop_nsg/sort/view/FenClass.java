package com.bwie.shop_nsg.sort.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.bwie.shop_nsg.R;
import com.bwie.shop_nsg.sort.adapter.MyAdapter_left;
import com.bwie.shop_nsg.sort.adapter.MyAdapter_right;
import com.bwie.shop_nsg.sort.bean.DataleftBean;
import com.bwie.shop_nsg.sort.bean.DatarightBean;
import com.bwie.shop_nsg.sort.bean.DateGridBean;
import com.bwie.shop_nsg.sort.presenter.UserPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/11/9 0009.
 */

public class FenClass extends Fragment implements Iview{


    @BindView(R.id.type_rvleft)
    RecyclerView typeRvleft;
    @BindView(R.id.type_rvright)
    RecyclerView typeRvright;
    Unbinder unbinder;
    private MyAdapter_left adapter_left;
    private UserPresenter presenter;
    private MyAdapter_right adapter_right;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_class, null);
        unbinder = ButterKnife.bind(this, view);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT);
        //得到WindowManager
        WindowManager windowManager = getActivity().getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        //得到屏幕宽
        int width = display.getWidth();
        //将RecyclerView宽设置为屏幕宽的1/5
        params.width = width * 1 / 5;
        typeRvleft.setLayoutParams(params);
//        //得到RecyclerView布局管理器
//        LinearLayoutManager leftLayoutManager = new LinearLayoutManager(getActivity());
//        //RecyclerView设置布局管理器
//        typeRvleft.setLayoutManager(leftLayoutManager);
//        //得到RecyclerView布局管理器
//        LinearLayoutManager rightLayoutManager = new LinearLayoutManager(getActivity());
//        //RecyclerView设置布局管理器
//        typeRvright.setLayoutManager(rightLayoutManager);
//        //获取后台数据，添加适配器
//        getServerData();

        presenter = new UserPresenter(this);
        presenter.getUser();



        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    @Override
    public void getData(final DataleftBean leftbean) {
        Log.d("main",leftbean.getDatas().getClass_list().get(0).getGc_name());
        typeRvleft.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter_left = new MyAdapter_left(getActivity(), leftbean);
        typeRvleft.setAdapter(adapter_left);

        //子条目点击监听
        adapter_left.setRecycleViewItemClickListener(new MyAdapter_left.OnRecycleViewItemClickListener() {
            @Override
            public void recycleViewItemClickListener(int position, View view, RecyclerView.ViewHolder viewHolder) {
                adapter_left.setTagPosition(position);
                adapter_left.notifyDataSetChanged();
                presenter.getrightUser(position+"");
                //请求二级数据
//                getServerTypeData(leftbean.getDatas().getClass_list().get(position).getGc_id(),position);
                presenter.getrightUser(leftbean.getDatas().getClass_list().get(position).getGc_id());
            }
        });

    }

    //二级列表
    @Override
    public void getrightData(DatarightBean rightbean) {
        typeRvright.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter_right = new MyAdapter_right(getActivity(), rightbean);
        typeRvright.setAdapter(adapter_right);
    }

    @Override
    public void getgridData(DateGridBean gridbean) {
        Log.d("maingrid",gridbean.getCode()+"");
//        adapter_right.myHolder.gv.setAdapter(new MyAdapter_TypeGridView(context,dateGridBean.getDatas().getClass_list()));
    }


    public interface OnGetServerDateLisnter {
        void getData(String string);
    }
    //请求二级数据
    public void getServerTypeData(final String gc_id, final int position) {


    }
}
