package com.example.nithin.newsapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nithin on 16/3/18.
 */

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder> {

    private Article[] mData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    // data is passed into the constructor
    RecycleViewAdapter(Context context, Article[] data,ItemClickListener itemClickListener) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
        this.mClickListener=itemClickListener;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recyclerview_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.TextView1.setText(String.valueOf(mData[position].getTitle()));
        holder.TextView2.setText(String.valueOf(mData[position].getDescription()));
//        holder.url.setText(String.valueOf(mData[position].getUrl()));
    }


    // total number of rows
    @Override
    public int getItemCount() {
        return mData.length;
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView TextView1;
        TextView TextView2;
//        TextView url;


        ViewHolder(View itemView) {
            super(itemView);
            TextView1 = itemView.findViewById(R.id.title);
            TextView2 = itemView.findViewById(R.id.description);
//            url = itemView.findViewById(R.id.url);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            mClickListener.onItemClick(mData[getAdapterPosition()]);
        }
    }



    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(Article article);
    }
}
