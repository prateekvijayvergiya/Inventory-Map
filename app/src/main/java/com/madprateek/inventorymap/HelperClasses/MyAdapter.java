package com.madprateek.inventorymap.HelperClasses;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.madprateek.inventorymap.FillDetailsActivity;
import com.madprateek.inventorymap.ModelClasses.InventoryModel;
import com.madprateek.inventorymap.R;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    ArrayList<InventoryModel> inventoryModels;
    Context context;


    public MyAdapter(ArrayList<InventoryModel> inventoryModels, Context context) {
        this.inventoryModels = inventoryModels;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView mOtnValue,mPreviousValue,mRemainingValue;
        Button mFillDetailsBtn;
        public ViewHolder(View itemView) {
            super(itemView);
            mOtnValue = (TextView) itemView.findViewById(R.id.otnValue);
            mPreviousValue = (TextView) itemView.findViewById(R.id.previousValue);
            mRemainingValue = (TextView) itemView.findViewById(R.id.remainingValue);
            mFillDetailsBtn = (Button) itemView.findViewById(R.id.fillDetailsBtn);
        }
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_recycler_adapter, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final InventoryModel inventoryModel = inventoryModels.get(position);
        holder.mOtnValue.setText(inventoryModel.getOTN_NO());
        holder.mPreviousValue.setText(String.valueOf(inventoryModel.getRUNNING_LENGTH()));
        holder.mRemainingValue.setText(String.valueOf(inventoryModel.getREMAINING_WORK()));

        holder.mFillDetailsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent detailsIntent = new Intent(context, FillDetailsActivity.class);
                detailsIntent.putExtra("otnNo",inventoryModel.getOTN_NO());
                detailsIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(detailsIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return inventoryModels.size();
    }


}
