package com.w3xplorers.recyclerviewasgridview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Avijit on 8/5/2017.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private ArrayList<AndroidVersion> android;
    private Context context;

    public CustomAdapter(Context context, ArrayList<AndroidVersion>android){
        this.android = android;
        this.context = context;
    }
    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.vText.setText(android.get(position).getAndroid_version_name());
        Picasso.with(context).load(android.get(position).getAndroid_image_url()).resize(240,120).into(holder.vImg);
    }

    @Override
    public int getItemCount() {
        return android.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView vText;
        private ImageView vImg;
        public ViewHolder(View view) {
            super(view);

            vText = (TextView)view.findViewById(R.id.text);
            vImg = (ImageView) view.findViewById(R.id.img);

            //to add onclick listener
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(context, vText.getText()+" is clicked.",Toast.LENGTH_SHORT).show();
        }
    }
}
