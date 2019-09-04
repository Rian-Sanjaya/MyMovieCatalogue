package com.lonecode.mymoviecatalogue;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class MovieDetailActivity extends AppCompatActivity {
    public static final String EXTRA_MOVIE_DETAIL = "extra_movie_detail";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        // set action bar title and show the back icon
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Movie Detail");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        MovieDetail movieDetail = getIntent().getParcelableExtra(EXTRA_MOVIE_DETAIL);

        ImageView imgDetailMovie = findViewById(R.id.img_detail_movie);
        imgDetailMovie.setImageResource(movieDetail.getPhoto());

        TextView tvDetailMovieName = findViewById(R.id.tv_detail_movie_name);
        tvDetailMovieName.setText(movieDetail.getName());

        TextView tvDetailUserscore = findViewById(R.id.tv_detail_userscore);
        tvDetailUserscore.setText(movieDetail.getUserScore());

        TextView tvDetailRuntime = findViewById(R.id.tv_detail_runtime);
        tvDetailRuntime.setText(movieDetail.getRuntime());

        TextView tvDetailGenres = findViewById(R.id.tv_detail_genres);
        tvDetailGenres.setText(movieDetail.getGenres());

        TextView tvDetailMovieDescription = findViewById(R.id.tv_detail_movie_description);
        tvDetailMovieDescription.setText(movieDetail.getDescription());
    }

    // make the back icon to navigate back
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
