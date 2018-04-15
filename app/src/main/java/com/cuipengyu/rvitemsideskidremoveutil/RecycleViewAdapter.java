package com.cuipengyu.rvitemsideskidremoveutil;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;

/**
 * Create by    ： 崔鹏宇
 * Time  is     ： 2018/4/13
 * Email        ： cuipengyusoul@gmail.com
 * Github       ： https://github.com/SolitarySoul
 * Instructions ：
 */
public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder> {
    List<Integer> mData;
    Context mContext;

    RecycleViewAdapter(Context context, List<Integer> data) {
        this.mContext = context;
        this.mData = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder viewHolder = new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_rv, parent, false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.contentTv.setText(String.valueOf(position));
        holder.itemView.setBackgroundColor(Color.RED);
        holder.deleteTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "delete onclick" + position, Toast.LENGTH_SHORT).show();
            }
        });

        holder.moreTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "moreTv onclick" + position, Toast.LENGTH_SHORT).show();
            }
        });



        holder.duo_a.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                }
                return false;
            }
        });


    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }



    class ViewHolder extends RecyclerView.ViewHolder {
        public TextView contentTv;
        public TextView deleteTv;
        public TextView moreTv;
        public LinearLayout mLinearLayout;
        public ImageView duo_a;
        public RelativeLayout item_connext;

        public ViewHolder(View itemView) {
            super(itemView);
            contentTv = itemView.findViewById(R.id.list_item);
            deleteTv = itemView.findViewById(R.id.delete);
            moreTv = itemView.findViewById(R.id.more);
            item_connext = itemView.findViewById(R.id.item_connext);
            duo_a = (ImageView) itemView.findViewById(R.id.duo_a);
            mLinearLayout = itemView.findViewById(R.id.delete_layout);
        }
    }


}
