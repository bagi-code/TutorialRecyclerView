package com.bagicode.tutorialrecyclerview;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    private RecyclerView rvMovie;
    private ArrayList<MovieModel> movies = new ArrayList<>();

    private String[] dataName;
    private String[] dataDescription;
    private TypedArray dataPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        rvMovie = findViewById(R.id.rv_movie);
        rvMovie.setHasFixedSize(true);
        prepare();
        addItem();

    }

    private void prepare() {
        dataName = getResources().getStringArray(R.array.movie_name);
        dataDescription = getResources().getStringArray(R.array.movie_description);
        dataPhoto = getResources().obtainTypedArray(R.array.movie_photo);
    }

    private void addItem() {
        movies = new ArrayList<>();

        for (int i = 0; i < dataName.length; i++) {
            MovieModel filmModel = new MovieModel();
            filmModel.setPhoto(dataPhoto.getResourceId(i, -1));
            filmModel.setName(dataName[i]);
            filmModel.setDesc(dataDescription[i]);
            movies.add(filmModel);
        }

        rvMovie.setLayoutManager(new LinearLayoutManager(this));
        MovieAdapter listHeroAdapter = new MovieAdapter(this);
        listHeroAdapter.setListHero(movies);
        rvMovie.setAdapter(listHeroAdapter);

        ItemClickSupport.addTo(rvMovie).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {

                // detail

            }
        });
    }
}
