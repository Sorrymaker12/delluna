package com.example.delluna;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.zip.Inflater;

public class rvAdapter extends RecyclerView.Adapter<rvAdapter.ViewHolder> {

    Context context;
    String[] pPrice;
    String[] pName;
    int[] pImage;

    private rvClickListener listener;

    public rvAdapter (Context context, String[] pName, String[] pPrice, int[] pImage, rvClickListener listener) {
        this.context = context;
        this.pName = pName;
        this.pPrice = pPrice;
        this.pImage = pImage;
        this.listener = listener;
    }
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView pPrice;
        ImageView pImage;

        public ViewHolder (@NonNull View itemView) {
            super(itemView);
            pPrice = itemView.findViewById(R.id.pPrice);
            pImage = itemView.findViewById(R.id.pImage);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View itemView) {
            listener.onClick(itemView, getAdapterPosition());
        }
    }



    @NonNull
    @Override
    public rvAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull rvAdapter.ViewHolder holder, int position) {
        holder.pPrice.setText(pPrice[position]);
        holder.pImage.setImageResource(pImage[position]);
    }

    @Override
    public int getItemCount() {
        return pPrice.length;
    }

    public interface rvClickListener{
        void onClick(View v, int position);
    }
}
