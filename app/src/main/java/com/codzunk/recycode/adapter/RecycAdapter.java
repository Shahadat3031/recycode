package com.codzunk.recycode.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.codzunk.recycode.R;
import com.codzunk.recycode.data.model.DataModel;

import java.util.List;

public class RecycAdapter extends RecyclerView.Adapter<RecycAdapter.ViewHolder> {
    private List<DataModel> imgUrls;
    private RecycOnClickListener onClickListener;

    public RecycAdapter(List<DataModel> imgUrls, RecycOnClickListener onClickListener) {
        this.imgUrls = imgUrls;
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recyc, parent, false);
        return new ViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        holder.imageView.setImageResource(imgUrls.get(position).getImgResId());
        String itemCount = "" + (position + 1);
        holder.countView.setText(itemCount);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickListener.onClick(v, holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return imgUrls.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView imageView;
        private TextView countView;

        ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            countView = itemView.findViewById(R.id.countView);
        }

        @Override
        public void onClick(View v) {
            onClickListener.onClick(v, getAdapterPosition());
        }
    }

    public interface RecycOnClickListener {
        void onClick(View view, int position);
    }
}
