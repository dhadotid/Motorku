package com.rsypj.motorku.adapter.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.rsypj.motorku.R;
import com.rsypj.motorku.helper.Helper;
import com.rsypj.motorku.model.TransactionModel;

/**
 * Created by dhadotid on 16/03/2018.
 */

public class TransactionBodyViewHolder extends RecyclerView.ViewHolder{

    TextView tvNamaSparepart;
    TextView tvHarga;

    public TransactionBodyViewHolder(View view) {
        super(view);

        tvNamaSparepart = view.findViewById(R.id.custom_transaction_tvSparepart);
        tvHarga = view.findViewById(R.id.custom_transaction_tvHarga);
    }

    public void setUpDataToUI(TransactionModel data){
        tvNamaSparepart.setText(data.getNamaSparepart());
        tvHarga.setText("Rp. " + data.getHarga());

        Helper.totalBayar += data.getHarga();
    }
}
