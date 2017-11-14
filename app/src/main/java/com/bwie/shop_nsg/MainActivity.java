package com.bwie.shop_nsg;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Toast;

import com.bwie.shop_nsg.cart.view.Cart;
import com.bwie.shop_nsg.home.view.Home;
import com.bwie.shop_nsg.mine.view.User;
import com.bwie.shop_nsg.sort.view.FenClass;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import utils.SharedPreferencesUtils;

public class MainActivity extends FragmentActivity {

    @BindView(R.id.frag)
    FrameLayout frag;
    @BindView(R.id.shou)
    RadioButton shou;
    @BindView(R.id.fenclass)
    RadioButton fenclass;
    @BindView(R.id.car)
    RadioButton car;
    @BindView(R.id.user)
    RadioButton user;
    @BindView(R.id.activity_main)
    LinearLayout activityMain;
    private FragmentManager fm;
    private Home home;
    private FenClass sort;
    private Cart cart;
    private User mine;
    private FragmentTransaction beginTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        String name = (String) SharedPreferencesUtils.getParam(MainActivity.this, "name", "1");
        String pass = (String) SharedPreferencesUtils.getParam(MainActivity.this, "pass", "1");
        if(!name.equals("")||!pass.equals("")){
            Toast.makeText(MainActivity.this,name+"======="+pass,Toast.LENGTH_SHORT).show();
        }
        init();
    }

    private void init() {

        fm = getSupportFragmentManager();

        home = new Home();
        sort = new FenClass();
        cart = new Cart();
        mine = new User();

        //开启事务
        beginTransaction = fm.beginTransaction();

        beginTransaction.add(R.id.frag,home);
        beginTransaction.add(R.id.frag,sort);
        beginTransaction.add(R.id.frag,cart);
        beginTransaction.add(R.id.frag,mine);

        beginTransaction.show(home);
        beginTransaction.hide(sort);
        beginTransaction.hide(cart);
        beginTransaction.hide(mine);

        beginTransaction.commit();
    }

    @OnClick({R.id.shou, R.id.fenclass, R.id.car, R.id.user})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.shou:
                beginTransaction = fm.beginTransaction();
                beginTransaction.show(home);
                beginTransaction.hide(sort);
                beginTransaction.hide(cart);
                beginTransaction.hide(mine);
                beginTransaction.commit();
                break;
            case R.id.fenclass:
                beginTransaction = fm.beginTransaction();
                beginTransaction.show(sort);
                beginTransaction.hide(home);
                beginTransaction.hide(cart);
                beginTransaction.hide(mine);
                beginTransaction.commit();
                break;
            case R.id.car:
                beginTransaction = fm.beginTransaction();
                beginTransaction.show(cart);
                beginTransaction.hide(sort);
                beginTransaction.hide(home);
                beginTransaction.hide(mine);
                beginTransaction.commit();
                break;
            case R.id.user:
                beginTransaction = fm.beginTransaction();
                beginTransaction.show(mine);
                beginTransaction.hide(sort);
                beginTransaction.hide(cart);
                beginTransaction.hide(home);
                beginTransaction.commit();
                break;
        }
    }
}
