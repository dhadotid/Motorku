package com.rsypj.motorku.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rsypj.motorku.R;
import com.rsypj.motorku.adapter.viewholder.RecordViewHolder;
import com.rsypj.motorku.model.RecordModel;

import java.util.ArrayList;

/**
 * Created by dhadotid on 16/03/2018.
 */

public class RecordAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    ArrayList<RecordModel> data = new ArrayList<>();

    public RecordAdapter(Context context, ArrayList<RecordModel> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.custom_record, null);
        return new RecordViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof RecordViewHolder){
            RecordModel recordModel = data.get(position);

            ((RecordViewHolder) holder).setDataToUI(recordModel);
        }
    }
}
