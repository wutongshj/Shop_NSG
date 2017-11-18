package com.bwie.shop_nsg.cart.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwie.shop_nsg.R;
import com.bwie.shop_nsg.cart.adapter.ExAdapter;
import com.bwie.shop_nsg.cart.bean.SearchCartBean;
import com.bwie.shop_nsg.cart.presenter.UserPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import utils.SharedPreferencesUtils;

/**
 * Created by Administrator on 2017/11/9 0009.
 */

public class Cart extends Fragment implements Iview {
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.subtitle)
    TextView subtitle;
    @BindView(R.id.top_bar)
    LinearLayout topBar;
//    @BindView(R.id.car_re)
//    RecyclerView carRe;
    @BindView(R.id.all_chekbox)
    CheckBox allChekbox;
    @BindView(R.id.tv_total_price)
    TextView tvTotalPrice;
    @BindView(R.id.tv_go_to_pay)
    TextView tvGoToPay;
    @BindView(R.id.ll_info)
    LinearLayout llInfo;
    @BindView(R.id.tv_share)
    TextView tvShare;
    @BindView(R.id.tv_save)
    TextView tvSave;
    @BindView(R.id.tv_delete)
    TextView tvDelete;
    @BindView(R.id.ll_shar)
    LinearLayout llShar;
    Unbinder unbinder;
    @BindView(R.id.exListView)
    ExpandableListView exListView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.item_car, null);
        unbinder = ButterKnife.bind(this, view);

//        carRe.setLayoutManager(new LinearLayoutManager(getActivity()));

        UserPresenter userPresenter = new UserPresenter(this);
        String uid = (String) SharedPreferencesUtils.getParam(getActivity(), "uid", "1");
        userPresenter.getUser(uid);


        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    @Override
    public void getview(SearchCartBean car) {
        Log.d("car", car.getMsg());
        Log.d("mylog", "getview: " + car.getData().get(1).getList().get(0).getTitle());
//        CargoodsAdapter adapter = new CargoodsAdapter(getActivity(), car);
//        carRe.setAdapter(adapter);
        ExAdapter adapter = new ExAdapter(car,getActivity());
        exListView.setAdapter(adapter);
//        for (int i = 0 ; i < adapter.getGroupCount() ; i++){
//            exListView.expandGroup(i);
//        }
    }
}
