package com.bwie.shop_nsg.sort.view.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bwie.shop_nsg.MainActivity;
import com.bwie.shop_nsg.R;
import com.bwie.shop_nsg.cart.bean.CarBean;
import com.bwie.shop_nsg.mine.view.LoginActivity;
import com.bwie.shop_nsg.sort.view.bean.DetailsBean;
import com.dou361.ijkplayer.listener.OnShowThumbnailListener;
import com.dou361.ijkplayer.widget.IjkVideoView;
import com.dou361.ijkplayer.widget.PlayStateParams;
import com.dou361.ijkplayer.widget.PlayerView;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import utils.Api;
import utils.ApiServer;
import utils.RetroFactory_car;
import utils.SharedPreferencesUtils;

import static utils.SharedPreferencesUtils.getParam;

public class ItemGoodsDetailsActivity extends AppCompatActivity {

    View rootView;
    PlayerView player;
    @BindView(R.id.btn_back)
    ImageView btnBack;
    @BindView(R.id.details_linear1)
    LinearLayout detailsLinear1;
    @BindView(R.id.video_view)
    IjkVideoView videoView;
    @BindView(R.id.iv_trumb)
    ImageView ivTrumb;
    @BindView(R.id.ll_bg)
    LinearLayout llBg;
    @BindView(R.id.app_video_status_text)
    TextView appVideoStatusText;
    @BindView(R.id.app_video_replay_icon)
    ImageView appVideoReplayIcon;
    @BindView(R.id.app_video_replay)
    LinearLayout appVideoReplay;
    @BindView(R.id.app_video_netTie_icon)
    TextView appVideoNetTieIcon;
    @BindView(R.id.app_video_netTie)
    LinearLayout appVideoNetTie;
    @BindView(R.id.app_video_speed)
    TextView appVideoSpeed;
    @BindView(R.id.app_video_loading)
    LinearLayout appVideoLoading;
    @BindView(R.id.app_video_volume_icon)
    ImageView appVideoVolumeIcon;
    @BindView(R.id.app_video_volume)
    TextView appVideoVolume;
    @BindView(R.id.app_video_volume_box)
    LinearLayout appVideoVolumeBox;
    @BindView(R.id.app_video_brightness_icon)
    ImageView appVideoBrightnessIcon;
    @BindView(R.id.app_video_brightness)
    TextView appVideoBrightness;
    @BindView(R.id.app_video_brightness_box)
    LinearLayout appVideoBrightnessBox;
    @BindView(R.id.app_video_fastForward)
    TextView appVideoFastForward;
    @BindView(R.id.app_video_fastForward_target)
    TextView appVideoFastForwardTarget;
    @BindView(R.id.app_video_fastForward_all)
    TextView appVideoFastForwardAll;
    @BindView(R.id.app_video_fastForward_box)
    LinearLayout appVideoFastForwardBox;
    @BindView(R.id.app_video_center_box)
    FrameLayout appVideoCenterBox;
    @BindView(R.id.app_video_finish)
    ImageView appVideoFinish;
    @BindView(R.id.app_video_title)
    TextView appVideoTitle;
    @BindView(R.id.app_video_menu)
    ImageView appVideoMenu;
    @BindView(R.id.app_video_top_box)
    LinearLayout appVideoTopBox;
    @BindView(R.id.app_video_play)
    ImageView appVideoPlay;
    @BindView(R.id.app_video_currentTime_full)
    TextView appVideoCurrentTimeFull;
    @BindView(R.id.app_video_currentTime_left)
    TextView appVideoCurrentTimeLeft;
    @BindView(R.id.app_video_endTime_left)
    TextView appVideoEndTimeLeft;
    @BindView(R.id.app_video_lift)
    LinearLayout appVideoLift;
    @BindView(R.id.app_video_seekBar)
    SeekBar appVideoSeekBar;
    @BindView(R.id.app_video_currentTime)
    TextView appVideoCurrentTime;
    @BindView(R.id.app_video_endTime)
    TextView appVideoEndTime;
    @BindView(R.id.app_video_center)
    LinearLayout appVideoCenter;
    @BindView(R.id.app_video_endTime_full)
    TextView appVideoEndTimeFull;
    @BindView(R.id.app_video_process_panl)
    LinearLayout appVideoProcessPanl;
    @BindView(R.id.app_video_stream)
    TextView appVideoStream;
    @BindView(R.id.ijk_iv_rotation)
    ImageView ijkIvRotation;
    @BindView(R.id.app_video_fullscreen)
    ImageView appVideoFullscreen;
    @BindView(R.id.ll_bottom_bar)
    LinearLayout llBottomBar;
    @BindView(R.id.simple_player_volume_controller)
    SeekBar simplePlayerVolumeController;
    @BindView(R.id.simple_player_volume_controller_container)
    LinearLayout simplePlayerVolumeControllerContainer;
    @BindView(R.id.simple_player_brightness_controller)
    SeekBar simplePlayerBrightnessController;
    @BindView(R.id.simple_player_brightness_controller_container)
    LinearLayout simplePlayerBrightnessControllerContainer;
    @BindView(R.id.simple_player_settings_container)
    LinearLayout simplePlayerSettingsContainer;
    @BindView(R.id.simple_player_select_streams_list)
    ListView simplePlayerSelectStreamsList;
    @BindView(R.id.simple_player_select_stream_container)
    LinearLayout simplePlayerSelectStreamContainer;
    @BindView(R.id.play_icon)
    ImageView playIcon;
    @BindView(R.id.app_video_box)
    RelativeLayout appVideoBox;
    @BindView(R.id.search_goods_subhead)
    TextView searchGoodsSubhead;
    @BindView(R.id.search_goods_bargainPrice)
    TextView searchGoodsBargainPrice;
    @BindView(R.id.search_goods_price)
    TextView searchGoodsPrice;
    @BindView(R.id.search_goods_salenum)
    TextView searchGoodsSalenum;
    @BindView(R.id.kefu)
    RadioButton kefu;
    @BindView(R.id.dianpu)
    RadioButton dianpu;
    @BindView(R.id.shoucang)
    RadioButton shoucang;
    @BindView(R.id.add_cart)
    Button addCart;
    @BindView(R.id.add_buy)
    Button addBuy;
    @BindView(R.id.activity_item_goods_details)
    RelativeLayout activityItemGoodsDetails;
    @BindView(R.id.search_goods_title)
    TextView searchGoodsTitle;
    private String pid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_goods_details);
        ButterKnife.bind(this);


        rootView = getLayoutInflater().from(this).inflate(R.layout.simple_player_view_player, null);
        String url = "http://9890.vod.myqcloud.com/9890_9c1fa3e2aea011e59fc841df10c92278.f20.mp4";
        player = new PlayerView(ItemGoodsDetailsActivity.this)
                .setTitle("视频")
                .setScaleType(PlayStateParams.fitparent)
                .hideMenu(true)
                .forbidTouch(false)
                .showThumbnail(new OnShowThumbnailListener() {
                    @Override
                    public void onShowThumbnail(ImageView ivThumbnail) {
                        Glide.with(ItemGoodsDetailsActivity.this)
                                .load("http://pic2.nipic.com/20090413/406638_125424003_2.jpg")
                                .placeholder(R.color.colorAccent)
                                .error(R.color.grey_color1)
                                .into(ivThumbnail);
                    }
                })
                .setPlaySource(url)
                .startPlay();


    }

    @Override
    protected void onResume() {
        super.onResume();

        pid = getIntent().getStringExtra("pid");
        Toast.makeText(ItemGoodsDetailsActivity.this, pid +"====",Toast.LENGTH_SHORT).show();
        message(pid);
    }

    public void message(String pid){
        Retrofit build = new Retrofit.Builder()
                .baseUrl(Api.GOODS_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        ApiServer apiServer = build.create(ApiServer.class);
        Observable<DetailsBean> getgoodsdetails = apiServer.getgoodsdetails(pid);
        getgoodsdetails.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DetailsBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(DetailsBean detailsBean) {
                        Log.d("detail",detailsBean.getData().getTitle());
                        searchGoodsTitle.setText(detailsBean.getData().getTitle());
                        searchGoodsSubhead.setText(detailsBean.getData().getSubhead()+"");
                        searchGoodsBargainPrice.setText("商品原价"+detailsBean.getData().getBargainPrice()+"");
                        searchGoodsPrice.setText("商品现价:"+detailsBean.getData().getPrice()+"");
                    }
                });

    }

    @OnClick({R.id.add_cart, R.id.add_buy})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.add_cart:
                boolean islogin= (boolean) getParam(ItemGoodsDetailsActivity.this,"isLogin",false);
                if(islogin==true){
                    String uid= (String) SharedPreferencesUtils.getParam(ItemGoodsDetailsActivity.this,"uid","1");
//                    Log.d("uid",uid);
//                    Log.d("pid",pid);

                    //添加到购物车
                    HashMap<String, String> map = new HashMap<>();
                    map.put("uid",uid);
                    map.put("pid",pid);
                    Observable<CarBean> addcar = RetroFactory_car.getInstance().addcar(map);
                    addcar.subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(new Observer<CarBean>() {
                                @Override
                                public void onCompleted() {


                                }

                                @Override
                                public void onError(Throwable e) {

                                }

                                @Override
                                public void onNext(CarBean carBean) {
                                    Log.d("add",carBean.getMsg());
                                    String code = carBean.getCode();
                                    if(code.equals("0")){
                                        Intent intent = new Intent(ItemGoodsDetailsActivity.this, MainActivity.class);
                                        intent.putExtra("frag",6);
                                        startActivity(intent);
                                    }
                                }
                            });


                }else{
                    Intent intent = new Intent(ItemGoodsDetailsActivity.this, LoginActivity.class);
                    startActivity(intent);
                }

                break;
            case R.id.add_buy:
                break;
        }
    }
}
