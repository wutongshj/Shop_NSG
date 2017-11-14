package com.bwie.shop_nsg.mine.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.shop_nsg.R;
import com.bwie.shop_nsg.mine.bean.LoginMessage;
import com.bwie.shop_nsg.mine.bean.UserBean;
import com.bwie.shop_nsg.mine.presenter.UserPresenter;
import com.bwie.shop_nsg.mine.view.Bean.EventBean;
import com.bwie.shop_nsg.mine.view.view.ZhuceActivity;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import utils.SharedPreferencesUtils;
import utils.Toasts;

public class LoginActivity extends AppCompatActivity implements Iview{

    @BindView(R.id.comeback)
    ImageView comeback;
    @BindView(R.id.login_image)
    ImageView loginImage;
    @BindView(R.id.user_name)
    EditText userName;
    @BindView(R.id.user_pass)
    EditText userPass;
    @BindView(R.id.zhuce)
    TextView zhuce;
    @BindView(R.id.login_button)
    Button loginButton;
    @BindView(R.id.activity_login)
    RelativeLayout activityLogin;
    private String name;
    private String pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);



    }

    @OnClick({R.id.comeback, R.id.zhuce, R.id.login_button})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.comeback:
                finish();
                break;
            case R.id.zhuce:
                Intent intent = new Intent(this, ZhuceActivity.class);
                startActivity(intent);
                break;
            case R.id.login_button:
                name = userName.getText().toString();
                pass = userPass.getText().toString();
                UserBean bean = new UserBean(name, pass);
                UserPresenter userPresenter = new UserPresenter(this);
                userPresenter.geturl(bean);
                break;
        }
    }

    @Override
    public void getData(LoginMessage list) {
        Log.d("main1",list.getMsg());
        Toasts.show(LoginActivity.this,list.getMsg(),2000);
        if (list.getCode().equals("0")){
            Toast.makeText(LoginActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
            EventBus.getDefault().post(new EventBean(name));
            SharedPreferencesUtils.setParam(LoginActivity.this,"name",name);
            SharedPreferencesUtils.setParam(LoginActivity.this,"isLogin",true);
            finish();
        }
    }
}
