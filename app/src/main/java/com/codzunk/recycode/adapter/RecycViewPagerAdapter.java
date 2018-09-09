package com.codzunk.recycode.adapter;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.codzunk.recycode.R;
import com.codzunk.recycode.data.model.DataModel;

import java.util.List;

public class RecycViewPagerAdapter extends PagerAdapter {
    private List<DataModel> dataModels;

    public RecycViewPagerAdapter(List<DataModel> dataModels) {
        this.dataModels = dataModels;
    }

    @Override
    public int getCount() {
        return dataModels.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(container.getContext());
        View rootView = inflater.inflate(R.layout.item_pager, container, false);
        ImageView imageView = rootView.findViewById(R.id.full_image);

        if (dataModels != null){
            imageView.setImageResource(dataModels.get(position).getImgResId());
        }
        container.addView(rootView);
        return rootView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
