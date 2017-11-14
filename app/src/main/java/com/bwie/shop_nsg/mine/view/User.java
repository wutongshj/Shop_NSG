package com.bwie.shop_nsg.mine.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/11/9 0009.
 */

public class User extends Fragment {

    @BindView(R.id.user_img)
    ImageView userImg;
    @BindView(R.id.login_success_name)
    TextView loginSuccessName;
    Unbinder unbinder;

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
        Intent intent = new Intent(getActivity(), LoginActivity.class);
        startActivity(intent);
    }

    @Subscribe
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
}
