package com.lonecode.mymoviecatalogue;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private String[] dataNameMovie;
    private String[] dataDescriptionMovie;
    private TypedArray dataPhotoMovie;
    private MovieAdapter adapter;
    private ArrayList<Movie> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. define adapter for ListView
        adapter = new MovieAdapter(this);
        // 2. define a ListView reference to layout (lv_list)
        ListView listView = findViewById(R.id.lv_list);
        // 3. set the listView adapter
        listView.setAdapter(adapter);

        // 4. prepare / set the data content to be used for ListView
        prepare();
        // 5. add the data content to the adapter
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(MainActivity.this, movies.get(i).getName(), Toast.LENGTH_SHORT).show();
//            }

            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String[] dataUserScore = getResources().getStringArray(R.array.data_user_score);
                String[] dataRuntime = getResources().getStringArray(R.array.data_runtime);
                String[] dataGenres = getResources().getStringArray(R.array.data_genres);

                MovieDetail movieDetail = new MovieDetail();
                movieDetail.setPhoto(dataPhotoMovie.getResourceId(i, -1));
                movieDetail.setName(dataNameMovie[i]);
                movieDetail.setUserScore(dataUserScore[i]);
                movieDetail.setRuntime(dataRuntime[i]);
                movieDetail.setGenres(dataGenres[i]);
                movieDetail.setDescription(dataDescriptionMovie[i]);

                Intent movieDetailIntent = new Intent(MainActivity.this, MovieDetailActivity.class);
                movieDetailIntent.putExtra(MovieDetailActivity.EXTRA_MOVIE_DETAIL, movieDetail);
                startActivity(movieDetailIntent);
            }
        });

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("My Movie Catalogue");
        }
    }

    private void addItem() {
        movies = new ArrayList<>();

        for (int i = 0; i < dataNameMovie.length; i++) {
            Movie movie = new Movie();
            movie.setPhoto(dataPhotoMovie.getResourceId(i, -1));
            movie.setName(dataNameMovie[i]);
            movie.setDescription(dataDescriptionMovie[i]);
            movies.add(movie);
        }

        adapter.setMovies(movies);
    }

    private void prepare() {
        dataNameMovie = getResources().getStringArray(R.array.data_name_movie);
        dataDescriptionMovie = getResources().getStringArray(R.array.data_description_movie);
        dataPhotoMovie = getResources().obtainTypedArray(R.array.data_photo_movie);
    }
}
