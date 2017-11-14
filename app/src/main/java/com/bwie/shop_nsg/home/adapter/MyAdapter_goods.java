package com.bwie.shop_nsg.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.shop_nsg.R;
import com.bwie.shop_nsg.home.bean.HomeBean;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;


/**
 * Created by Administrator on 2017/10/24 0024.
 */

public class MyAdapter_goods extends RecyclerView.Adapter<MyAdapter_goods.MyViewHolder> {

    Context context;
    private List<HomeBean.DataBean.SubjectsBean.GoodsListBeanX> goodslist;

    public MyAdapter_goods(Context context, List<HomeBean.DataBean.SubjectsBean.GoodsListBeanX> goodslist) {
        this.context = context;
        this.goodslist = goodslist;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                context).inflate(R.layout.item_home_three, parent,
                false));
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position)
    {

        holder.text3.setText(goodslist.get(position).getGoods_name());
        ImageLoader.getInstance().displayImage(goodslist.get(position).getGoods_img(),holder.img3);

    }

    @Override
    public int getItemCount()
    {
        return goodslist.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {

        ImageView img3;
        TextView text3;
        public MyViewHolder(View view)
        {
            super(view);
            img3= (ImageView) view.findViewById(R.id.item_home_three_image);
            text3= (TextView) view.findViewById(R.id.item_home_three_text);

        }
    }
}
