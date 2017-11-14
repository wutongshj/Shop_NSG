package com.bwie.shop_nsg.mine.view;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.shop_nsg.R;
import com.bwie.shop_nsg.mine.view.Bean.EventBean;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import utils.SharedPreferencesUtils;

/**
 * Created by Administrator on 2017/11/9 0009.
 */

public class User extends Fragment {

    @BindView(R.id.user_img)
    ImageView userImg;
    @BindView(R.id.login_success_name)
    TextView loginSuccessName;
    Unbinder unbinder;
    private String name;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.item_user, null);

        unbinder = ButterKnife.bind(this, view);


        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.user_img)
    public void onViewClicked() {
        //注册EventBus
        if (!EventBus.getDefault().isRegistered(this))
        {
            EventBus.getDefault().register(this);
        }

        if(!loginSuccessName.getText().toString().equals("未登录")){
            AlertDialog alertDialog = new AlertDialog.Builder(getActivity())
                    .setTitle("确定退出吗？")
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            SharedPreferencesUtils.setParam(getActivity(),"name","未登录");
                            SharedPreferencesUtils.setParam(getActivity(),"isLogin",false);
                            loginSuccessName.setText("未登录");
                            Toast.makeText(getActivity(),"退出",Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    })
                    .create();
            alertDialog.show();
        }else {
            Intent intent = new Intent(getActivity(), LoginActivity.class);
            startActivity(intent);
        }

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(EventBean bean) {
        String mobile = bean.getMsg();
        Log.d("name", mobile);
        loginSuccessName.setText(mobile);
        Toast.makeText(getActivity(), mobile, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        EventBus.getDefault().unregister(this);//反注册EventBus
    }

    //每次显示当前页面都会调用该方法
    @Override
    public void onResume() {
        super.onResume();

        boolean isLogin = (boolean) SharedPreferencesUtils.getParam(getActivity(), "isLogin", false);

        name = (String) SharedPreferencesUtils.getParam(getActivity(),"name","未登录");
        loginSuccessName.setText(name);

    }
}
