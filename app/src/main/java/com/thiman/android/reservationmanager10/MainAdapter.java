package com.thiman.android.reservationmanager10;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Asus on 1/24/2018.
 */

class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
        ArrayList<String> roomId;
        ArrayList<String> checkinDate;
        ArrayList<String> checkoutDate;

    public MainAdapter(ArrayList<String> roomId,ArrayList<String> checkinDate,ArrayList<String> checkoutDate) {
        this.roomId = roomId;
        this.checkinDate = checkinDate;
        this.checkoutDate = checkoutDate;
    }



    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MainAdapter.ViewHolder holder, int position) {

        holder.roomNoId.setText(roomId.get(position));
        holder.checkIn.setText(checkinDate.get(position));
        holder.checkout.setText(checkoutDate.get(position));

    }

    @Override
    public int getItemCount() {
        return roomId.size();


    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView roomNoId;
        public TextView checkIn;
        public TextView checkout;


        public ViewHolder(View itemView) {
            super(itemView);

            roomNoId = (TextView)  itemView.findViewById(R.id.tv_text);
            checkIn = (TextView) itemView.findViewById(R.id.tv_text1);
            checkout = (TextView) itemView.findViewById(R.id.tv_text2);
        }
    }
}
