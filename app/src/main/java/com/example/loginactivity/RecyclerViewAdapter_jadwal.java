package com.example.loginactivity;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter_jadwal extends RecyclerView.Adapter<RecyclerViewAdapter_jadwal.MyViewHolder> {

    Context mContext ;
    List<JadwalItem> mData;
    Dialog myDialog;

    public RecyclerViewAdapter_jadwal(Context mContext, List<JadwalItem> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.jadwal_item,parent,false);
        final MyViewHolder vHolder = new MyViewHolder(v);

        //Dialog ini

        myDialog = new Dialog(mContext);
        myDialog.setContentView(R.layout.dialog_token_soal);
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));


        vHolder.item_jadwal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView dialog_mapel_tv = (TextView) myDialog.findViewById(R.id.dialog_mapel);
                TextView dialog_statussoal_tv = (TextView) myDialog.findViewById(R.id.dialog_statussoal);
                dialog_mapel_tv.setText(mData.get(vHolder.getAdapterPosition()).getMapel());
                dialog_statussoal_tv.setText(mData.get(vHolder.getAdapterPosition()).getStatussoal());
                Toast.makeText(mContext, "Test KLIK"+String.valueOf(vHolder.getAdapterPosition()), Toast.LENGTH_SHORT).show();
                myDialog.show();
            }
        });

        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.tv_mapel.setText(mData.get(position).getMapel());
        holder.tv_status.setText(mData.get(position).getStatus());
        holder.tv_namaguru.setText(mData.get(position).getNamaguru());
        holder.tv_waktumengerjakan.setText(mData.get(position).getWaktumengerjakan());
        holder.tv_statussoal.setText(mData.get(position).getStatussoal());
        holder.tv_jumlahsoal.setText(mData.get(position).getJumlahsoal());
        holder.tv_waktumulai.setText(mData.get(position).getWaktumulai());
        holder.img_note.setImageResource(mData.get(position).getImgnote());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private RelativeLayout item_jadwal;
        private TextView tv_mapel;
        private TextView tv_status;
        private TextView tv_namaguru;
        private TextView tv_waktumengerjakan;
        private TextView tv_statussoal;
        private TextView tv_jumlahsoal;
        private TextView tv_waktumulai;
        private ImageView img_note;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            item_jadwal = (RelativeLayout) itemView.findViewById(R.id.jdwl_item);
            tv_mapel = (TextView) itemView.findViewById(R.id.mapel);
            tv_status = (TextView) itemView.findViewById(R.id.status);
            tv_namaguru = (TextView) itemView.findViewById(R.id.namaguru);
            tv_waktumengerjakan = (TextView) itemView.findViewById(R.id.waktumengerjakan);
            tv_statussoal = (TextView) itemView.findViewById(R.id.statussoal);
            tv_jumlahsoal = (TextView) itemView.findViewById(R.id.jumlahsoal);
            tv_waktumulai = (TextView) itemView.findViewById(R.id.waktumulai);
            img_note = (ImageView) itemView.findViewById(R.id.imgnote);
        }
    }
}
