package com.example.movieticketbookingassignment;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class ViewPagerAdaptor extends PagerAdapter {
    List<Integer> list;
    Context context;

    public ViewPagerAdaptor(List<Integer> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater layoutInflater = LayoutInflater.from(container.getContext());
        View view = layoutInflater.inflate(R.layout.view_pager_item_layout, container, false);
        ImageView imageView = view.findViewById(R.id.imageview);
        imageView.setImageResource(list.get(position));
       /* view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                  Intent intent = new Intent(context, SeatBookActivity.class);
                    intent.putExtra("my image",list.get(position));
                    context.startActivity(intent);
                    }
        });*/
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
