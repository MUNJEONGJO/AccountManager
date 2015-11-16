package com.example.jomunjeong.hello;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Random;




/**
 * Created by jomunjeong on 2015. 11. 15..
 */
public class MyRecyclerAdapter extends Adapter<MyRecyclerAdapter.ViewHolder> {

    Context context;
    private List<ViewModel> items;
    private int itemLayout;



    public MyRecyclerAdapter(Context context,List<ViewModel> items,int itemLayout) {
        this.context = context;
        this.items = items;
        this.itemLayout = itemLayout;
    }


    @Override
    public int getItemCount() {
        return items.size();
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        //get element at this position
        ViewModel item = items.get(position);

        //replace the contents of the view with that element
        holder.itemView.setTag(item);
        holder.text.setText(item.getTitle());
        holder.image.setBackgroundColor(getRandomColor());
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //Create a new view
        View view = LayoutInflater.from(parent.getContext()).inflate(itemLayout,parent,false);

        //set the view's size
        if(parent.getHeight() > 0){
            view.getLayoutParams().height = parent.getHeight() / 6;
        }
        return new ViewHolder(view);
    }


    //Provide a reference to the views for each data item
    //Complex data items may need more than one view per item
    public static class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView image;
        public TextView text;

        public ViewHolder(View itemView) {
            super(itemView);
            image = (ImageView)itemView.findViewById(R.id.item_img);
            text=(TextView)itemView.findViewById(R.id.item_txt);
        }
    }


    private int getImageResource(int pos){
        if(pos % 2 == 0)
            return R.drawable.bg_test1;
        else
            return R.drawable.bg_test2;
    }

    public int getRandomColor() {
        Random rnd = new Random();
        int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        return color;
    }

}
