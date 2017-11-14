package com.bwie.shop_nsg.home.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.shop_nsg.R;
import com.bwie.shop_nsg.home.bean.GlideImageLoader;
import com.bwie.shop_nsg.home.bean.HomeBean;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerClickListener;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/11/9 0009.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {



    HomeBean.DataBean list;
    Context mcontext;
    ArrayList mlist;
    ArrayList mlist2;
    ArrayList imgs_gwc;
    ArrayList<HomeBean.DataBean.SubjectsBean.GoodsListBeanX> goodslist;
    private Intent intent;

    //枚举类型
    private enum Item_Type{
        Typeone ,Typetwo,Typethree,Typefour,Typefive,Typesix;
    }

    public RecyclerAdapter(Context mcontext, HomeBean.DataBean list) {
        this.mcontext = mcontext;
        this.list = list;
//        intent = new Intent(mcontext, HomeWebActivity.class);

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == Item_Type.Typeone.ordinal()) {
            View mView = LayoutInflater.from(mcontext).inflate(R.layout.recycler_item_one, null);
            ViewHolderA viewHolder = new ViewHolderA(mView);
            return viewHolder;

        } else if (viewType == Item_Type.Typetwo.ordinal()) {

            View mView = LayoutInflater.from(mcontext).inflate(R.layout.recycler_item_two, null);
            ViewHolderB viewHolder = new ViewHolderB(mView);
            return viewHolder;
        } else if (viewType == Item_Type.Typethree.ordinal()) {
            View mView = LayoutInflater.from(mcontext).inflate(R.layout.recycler_item_three, null);
            ViewHolderC viewHolder = new ViewHolderC(mView);
            return viewHolder;
        }else if (viewType == Item_Type.Typefour.ordinal()) {
            View mView = LayoutInflater.from(mcontext).inflate(R.layout.recycler_item_four, null);
            ViewHolderD viewHolder = new ViewHolderD(mView);
            return viewHolder;
        }else if (viewType == Item_Type.Typefive.ordinal()) {
            View mView = LayoutInflater.from(mcontext).inflate(R.layout.recycler_item_five, null);
            ViewHolderE viewHolder = new ViewHolderE(mView);
            return viewHolder;
        }else if (viewType == Item_Type.Typesix.ordinal()) {
            View mView = LayoutInflater.from(mcontext).inflate(R.layout.recycler_item_six, null);
            ViewHolderF viewHolder = new ViewHolderF(mView);
            return viewHolder;
        }

        return null;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolderA) {
            mlist=new ArrayList();
            for(int i=0;i<list.getAd1().size();i++){
                mlist.add(list.getAd1().get(i).getImage());
            }
            //设置图片加载器
            ((ViewHolderA) holder).mbanner.setImageLoader(new GlideImageLoader());
            ((ViewHolderA) holder).mbanner.setImages(mlist);
            ((ViewHolderA) holder).mbanner.start();

            ((ViewHolderA) holder).mbanner.setOnBannerClickListener(new OnBannerClickListener() {
                @Override
                public void OnBannerClick(int position) {
                    String data = list.getAd1().get(position-1).getAd_type_dynamic_data();
                    intent.putExtra("url",data);
                    mcontext.startActivity(intent);
                    Toast.makeText(mcontext,data,Toast.LENGTH_SHORT).show();

                }
            });

        }
        else if (holder instanceof ViewHolderB) {
//            ((ViewHolderB) holder).text.setText(list.getDefaultGoodsList().get(position).getGoods_name() + "------样式二");
            ((ViewHolderB) holder).t1.setText(list.getAd5().get(0).getTitle());
            ((ViewHolderB) holder).t2.setText(list.getAd5().get(1).getTitle());
            ((ViewHolderB) holder).t3.setText(list.getAd5().get(2).getTitle());
            ((ViewHolderB) holder).t4.setText(list.getAd5().get(3).getTitle());

            ImageLoader.getInstance().displayImage(list.getAd5().get(0).getImage(),((ViewHolderB) holder).img1);
            ImageLoader.getInstance().displayImage(list.getAd5().get(1).getImage(),((ViewHolderB) holder).img2);
            ImageLoader.getInstance().displayImage(list.getAd5().get(2).getImage(),((ViewHolderB) holder).img3);
            ImageLoader.getInstance().displayImage(list.getAd5().get(3).getImage(),((ViewHolderB) holder).img4);

        } else if (holder instanceof ViewHolderC) {
//            ((ViewHolderC) holder).text.setText(list.getDefaultGoodsList().get(position).getGoods_name()+ "------样式三");
        }else if (holder instanceof ViewHolderD) {
            imgs_gwc=new ArrayList();
            for(int i=0;i<list.getActivityInfo().getActivityInfoList().size();i++){
                imgs_gwc.add(list.getActivityInfo().getActivityInfoList().get(i).getActivityImg());
            }
            ((ViewHolderD) holder).re2.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL));
            ((ViewHolderD) holder).re2.setAdapter(new MyAdapter_gwc(imgs_gwc,mcontext));

        }else if (holder instanceof ViewHolderE) {
            mlist2=new ArrayList();
            for(int i=0;i<list.getSubjects().size();i++){
                mlist2.add(list.getSubjects().get(i).getImage());
            }
            //设置图片加载器
            ((ViewHolderE) holder).banner2.setImageLoader(new GlideImageLoader());
            ((ViewHolderE) holder).banner2.setImages(mlist2);
            ((ViewHolderE) holder).banner2.start();

            ((ViewHolderE) holder).banner2.setOnBannerClickListener(new OnBannerClickListener() {
                @Override
                public void OnBannerClick(int position) {
                    String wapUrl = list.getSubjects().get(position).getWapUrl();
                    intent.putExtra("url",wapUrl);
                    mcontext.startActivity(intent);
                }
            });
        }else if (holder instanceof ViewHolderF) {
            goodslist=new ArrayList();
            for(int i=0;i<list.getDefaultGoodsList().size();i++){
                String goods_name = list.getDefaultGoodsList().get(i).getGoods_name();
                String goods_img = list.getDefaultGoodsList().get(i).getGoods_img();
                goodslist.add(new HomeBean.DataBean.SubjectsBean.GoodsListBeanX(goods_name,goods_img));
            }

            ((ViewHolderF) holder).re3.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL));
            ((ViewHolderF) holder).re3.setAdapter(new MyAdapter_goods(mcontext,goodslist));
        }

    }

    @Override
    public int getItemCount() {
        return 6;
    }

    //返回值赋值给onCreateViewHolder的参数 viewType
    @Override
    public int getItemViewType(int position) {
        // return super.getItemViewType(position);

        if (position == 0) {
            return Item_Type.Typeone.ordinal();
        } else if (position == 1) {
            return Item_Type.Typetwo.ordinal();
        } else if (position == 2) {
            return Item_Type.Typethree.ordinal();
        }else if (position == 3) {
            return Item_Type.Typefour.ordinal();
        }else if (position == 4) {
            return Item_Type.Typefive.ordinal();
        }else if (position == 5) {
            return Item_Type.Typesix.ordinal();
        }
        return -1;

    }

    class ViewHolderA extends RecyclerView.ViewHolder {
        public Banner mbanner;

        public ViewHolderA(View itemView) {
            super(itemView);

            mbanner = (Banner) itemView.findViewById(R.id.banner);
        }
    }

    class ViewHolderB extends RecyclerView.ViewHolder {
        public TextView t1;
        public TextView t2;
        public TextView t3;
        public TextView t4;

        public ImageView img1;
        public ImageView img2;
        public ImageView img3;
        public ImageView img4;

        public ViewHolderB(View itemView) {
            super(itemView);

            t1= (TextView) itemView.findViewById(R.id.id_num1);
            t2= (TextView) itemView.findViewById(R.id.id_num2);
            t3= (TextView) itemView.findViewById(R.id.id_num3);
            t4= (TextView) itemView.findViewById(R.id.id_num4);

            img1= (ImageView) itemView.findViewById(R.id.id_image1);
            img2= (ImageView) itemView.findViewById(R.id.id_image2);
            img3= (ImageView) itemView.findViewById(R.id.id_image3);
            img4= (ImageView) itemView.findViewById(R.id.id_image4);
        }
    }

    class ViewHolderC extends RecyclerView.ViewHolder {

        public ViewHolderC(View itemView) {
            super(itemView);

        }
    }
    class ViewHolderD extends RecyclerView.ViewHolder {

        public RecyclerView re2;

        public ViewHolderD(View itemView) {
            super(itemView);
            re2= (RecyclerView) itemView.findViewById(R.id.id_recyclerview2);
        }
    }

    class ViewHolderE extends RecyclerView.ViewHolder {


        public Banner banner2;
        public ViewHolderE(View itemView) {
            super(itemView);

            banner2= (Banner) itemView.findViewById(R.id.banner2);
        }
    }
    class ViewHolderF extends RecyclerView.ViewHolder {

        public RecyclerView re3;
        public ViewHolderF(View itemView) {
            super(itemView);
            re3= (RecyclerView) itemView.findViewById(R.id.id_recyclerview_bottom);

        }
    }
}
