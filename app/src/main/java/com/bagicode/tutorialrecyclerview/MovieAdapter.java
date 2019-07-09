package com.bagicode.tutorialrecyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.CategoryViewHolder> {
    private Context context;

    private ArrayList<MovieModel> getListHero() {
        return listHero;
    }

    public void setListHero(ArrayList<MovieModel> listHero) {
        this.listHero = listHero;
    }

    private ArrayList<MovieModel> listHero;


    public MovieAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false);
        return new CategoryViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        holder.tvName.setText(getListHero().get(position).getName());
        holder.tvDesc.setText(getListHero().get(position).getDesc());

        Glide.with(context)
                .load(getListHero().get(position).getPhoto())
                .apply(new RequestOptions().override(100, 100))
                .into(holder.imgPhoto);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return getListHero().size();
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvDesc;
        ImageView imgPhoto;

        CategoryViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.txt_name);
            tvDesc = itemView.findViewById(R.id.txt_description);
            imgPhoto = itemView.findViewById(R.id.iv_photo);
        }
    }
}