package com.bwie.shop_nsg.sort.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwie.shop_nsg.R;
import com.bwie.shop_nsg.sort.view.bean.ItemGoodsBean;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by Administrator on 2017/11/16 0016.
 */

public class GoodsListAdapter extends RecyclerView.Adapter<GoodsListAdapter.MyviewHodel> {

    ItemGoodsBean goods;
    Context context;

    public GoodsListAdapter(ItemGoodsBean goods, Context context) {
        this.goods = goods;
        this.context = context;
    }

    public interface OnItemClickLitener {
        void onItemClick(View view, int position);
//        void onItemLongClick(View view , int position);
    }

    private OnItemClickLitener mOnItemClickLitener;

    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener){
        this.mOnItemClickLitener = mOnItemClickLitener;
    }

    @Override
    public MyviewHodel onCreateViewHolder(ViewGroup parent, int viewType) {
        MyviewHodel hodel =  new MyviewHodel(LayoutInflater.from(context).inflate(R.layout.itemgoods_item, null));
        return hodel;
    }

    @Override
    public void onBindViewHolder(final MyviewHodel holder, int position) {
        holder.price.setText("价格："+goods.getData().get(position).getPrice()+"");
        holder.title.setText(goods.getData().get(position).getTitle());
        holder.subhead.setText(goods.getData().get(position).getSalenum()+"");
        String images = goods.getData().get(position).getImages();
        String[] split = images.split("\\|");
        holder.img.setImageURI(split[0]);

        // 如果设置了回调，则设置点击事件
        if (mOnItemClickLitener != null)
        {
            holder.itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickLitener.onItemClick(holder.itemView, pos);
                }
            });

        }
    }

    @Override
    public int getItemCount() {
        return goods.getData().size();
    }

    class MyviewHodel extends RecyclerView.ViewHolder{

        SimpleDraweeView img;
        TextView price,title,subhead;
        public MyviewHodel(View itemView) {
            super(itemView);

            img= (SimpleDraweeView) itemView.findViewById(R.id.item_goods);
            price= (TextView) itemView.findViewById(R.id.item_price);
            title= (TextView) itemView.findViewById(R.id.item_title);
            subhead= (TextView) itemView.findViewById(R.id.item_subhead);
        }
    }
}
