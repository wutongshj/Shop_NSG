package com.bwie.shop_nsg.mine.view.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bwie.shop_nsg.R;
import com.bwie.shop_nsg.mine.bean.UserBean;
import com.bwie.shop_nsg.mine.view.Bean.ReMessage;
import com.bwie.shop_nsg.mine.view.presenter.Re_presenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ZhuceActivity extends AppCompatActivity implements Re_Iview {

    @BindView(R.id.comeback)
    ImageView comeback;
    @BindView(R.id.re_name)
    EditText reName;
    @BindView(R.id.re_pass1)
    EditText rePass1;
    @BindView(R.id.re_pass2)
    EditText rePass2;
    @BindView(R.id.re_email)
    EditText reEmail;
    @BindView(R.id.re_button)
    Button reButton;
    @BindView(R.id.activity_zhuce)
    LinearLayout activityZhuce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhuce);
        ButterKnife.bind(this);

    }

    @Override
    public void getView(ReMessage list) {
        Log.d("message", list.getMsg());
    }

    @OnClick({R.id.comeback, R.id.re_button})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.comeback:
                finish();
                break;
            case R.id.re_button:
                String name = reName.getText().toString();
                String pass1 = rePass1.getText().toString();
                String pass2 = rePass2.getText().toString();
                if(pass1.equals(pass2)){
                    UserBean bean = new UserBean(name, pass1);
                    Re_presenter rePresenter = new Re_presenter(this);
                    rePresenter.geturl(bean);
                    Log.d("message_bean",bean.getMobile());
                }else if(pass1.length()<6||pass2.length()<6){
                    Toast.makeText(ZhuceActivity.this,"密码不能小于六位",Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(ZhuceActivity.this,"密码不一致",Toast.LENGTH_SHORT).show();
                }

                break;
        }
    }
}
