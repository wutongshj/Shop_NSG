package com.bwie.shop_nsg.cart.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwie.shop_nsg.R;
import com.bwie.shop_nsg.cart.bean.CarSelectBean;

/**
 * Created by Administrator on 2017/11/17 0017.
 */

public class CargoodsAdapter extends RecyclerView.Adapter<CargoodsAdapter.MyViewHolder> {

    Context context;
    CarSelectBean goods;

    public CargoodsAdapter(Context context, CarSelectBean goods) {
        this.context = context;
        this.goods = goods;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.car_item, null));
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
//        Log.d("cargood",goods.getData().get(0).getList().get(position).getTitle());
        holder.text.setText(goods.getData().get(position).getList().get(0).getTitle());
        holder.price.setText(goods.getData().get(position).getList().get(0).getPrice()+"");
    }

    @Override
    public int getItemCount() {
        Log.d("length",goods.getData().size()+"");
        return goods.getData().size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView text,price;
        public MyViewHolder(View itemView) {
            super(itemView);
            text= (TextView) itemView.findViewById(R.id.car_text);
            price= (TextView) itemView.findViewById(R.id.item_price);
        }
    }
}
