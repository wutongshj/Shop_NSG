package com.bwie.shop_nsg.sort.view.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.bwie.shop_nsg.R;
import com.bwie.shop_nsg.sort.view.adapter.GoodsListAdapter;
import com.bwie.shop_nsg.sort.view.bean.ItemGoodsBean;
import com.bwie.shop_nsg.sort.view.presenter.Goods_presenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GoodsListActivity extends AppCompatActivity implements Goods_iview {

    @BindView(R.id.goods_list)
    RecyclerView goodsList;
    @BindView(R.id.activity_goods_list)
    RelativeLayout activityGoodsList;
    private GoodsListAdapter adapter;

    private int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_list);
        ButterKnife.bind(this);

        Goods_presenter goods_presenter = new Goods_presenter(this);
        goods_presenter.getgoodslist("2");
//        int position = getIntent().getIntExtra("position",1);
//        int i = position % 2;
//        if(i==0){
//            goods_presenter.getgoodslist("2");
//        }else if (i==1){
//            goods_presenter.getgoodslist("2");
//        }


//        Goods_presenter presenter = new Goods_presenter(this);
//        presenter.getgoodslist("1");

        goodsList.setLayoutManager(new GridLayoutManager(this,3));

//        EventBus.getDefault().register(this);
    }

    @Override
    public void setmessage(final ItemGoodsBean goods) {
        Log.d("goods1",goods.getMsg());
        adapter = new GoodsListAdapter(goods, this);
        goodsList.setAdapter(adapter);
        adapter.setOnItemClickLitener(new GoodsListAdapter.OnItemClickLitener()
        {

            @Override
            public void onItemClick(View view, int position)
            {
                Toast.makeText(GoodsListActivity.this, position + " click",
                        Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(GoodsListActivity.this, ItemGoodsDetailsActivity.class);
                intent.putExtra("pid",position+1+"");
                startActivity(intent);
            }

        });



    }

//    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
//    public void onGoodsMessage(GoodsEvent event){
//        Log.d("position",event.getId()+"");
////        Goods_presenter presenter = new Goods_presenter(this);
////        presenter.getgoodslist(event.getId()+"");
////        i = event.getId() % 2;
////        if(i==1||i==0){
////            goods_presenter = new Goods_presenter(this);
////            goods_presenter.getgoodslist("1");
////        }else if (i==2){
////            goods_presenter = new Goods_presenter(this);
////            goods_presenter.getgoodslist("2");
////        }
//
//    }

//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        EventBus.getDefault().unregister(this);
//    }
}
