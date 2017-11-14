package com.bwie.shop_nsg.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bwie.shop_nsg.R;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/10/23 0023.
 */

public class MyAdapter_gwc extends RecyclerView.Adapter<MyAdapter_gwc.MyViewHolder> {

    // 数据源
    ArrayList<String> lists;
    // 上下文
    Context context;

    public MyAdapter_gwc(ArrayList<String> lists, Context context) {
        this.lists = lists;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_home_two, parent,
                false));
        return holder;
    }

    public interface OnItemClickLitener
    {
        void onItemClick(View view, int position);
    }

    private OnItemClickLitener mOnItemClickLitener;

    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener)
    {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position)
    {
        ImageLoader.getInstance().displayImage(lists.get(position),holder.img);

        // 点击事件
        if (mOnItemClickLitener != null)
        {
            holder.itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    int pos = holder.getPosition();
                    mOnItemClickLitener.onItemClick(holder.itemView, pos);
                }
            });
        }
    }

    @Override
    public int getItemCount()
    {
        return lists.size();
    }

    class MyViewHolder extends ViewHolder
    {
        ImageView img;
        public MyViewHolder(View view)
        {
            super(view);
            img = (ImageView) view.findViewById(R.id.item_home_two_image);
        }
    }
}
