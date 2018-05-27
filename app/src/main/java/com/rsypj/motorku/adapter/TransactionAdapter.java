package com.rsypj.motorku.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rsypj.motorku.R;
import com.rsypj.motorku.adapter.viewholder.TransactionBodyViewHolder;
import com.rsypj.motorku.adapter.viewholder.TransactionFooterViewHolder;
import com.rsypj.motorku.constant.ConstantTransaction;
import com.rsypj.motorku.model.TransactionModel;

import java.util.ArrayList;

/**
 * Created by dhadotid on 16/03/2018.
 */

public class TransactionAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    ArrayList<TransactionModel> data = new ArrayList<>();

    public TransactionAdapter(Context context, ArrayList<TransactionModel> data) {
        this.context = context;
        this.data = data;
    }


    @Override
    public int getItemViewType(int position) {
        if (position == data.size()){
            return ConstantTransaction.TAG_FOOTER;
        }else {
            return ConstantTransaction.TAG_BODY;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof TransactionBodyViewHolder){
            TransactionModel transactionModel = data.get(position);

            ((TransactionBodyViewHolder) holder).setUpDataToUI(transactionModel);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ConstantTransaction.TAG_BODY){
            View view = LayoutInflater.from(context).inflate(R.layout.custom_transaction, null);

            return new TransactionBodyViewHolder(view);
        }else {
            View view = LayoutInflater.from(context).inflate(R.layout.custom_footbar, null);

            return new TransactionFooterViewHolder(view);
        }
    }

    @Override
    public int getItemCount() {
        return data.size() + 1;
    }
}
