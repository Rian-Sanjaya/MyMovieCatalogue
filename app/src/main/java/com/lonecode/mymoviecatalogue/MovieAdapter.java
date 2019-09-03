package com.lonecode.mymoviecatalogue;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MovieAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Movie> movies;

    public MovieAdapter(Context context) {
        this.context = context;
        movies = new ArrayList<>();
    }

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int i) {
        return movies.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_movie, viewGroup,false);
        }

        ViewHolder viewHolder = new ViewHolder(view);
        Movie movie = (Movie) getItem(i);
        viewHolder.bind(movie);

        return view;
    }

    private class ViewHolder {
        private TextView txtMovieName;
        private TextView txtMovieDescription;
        private ImageView imgMoviePhoto;

        public ViewHolder(View view) {
            txtMovieName = view.findViewById(R.id.txt_movie_name);
            txtMovieDescription = view.findViewById(R.id.txt_movie_description);
            imgMoviePhoto = view.findViewById(R.id.img_movie_photo);
        }

        public void bind(Movie movie) {
            txtMovieName.setText(movie.getName());
            txtMovieDescription.setText(movie.getDescription());
            imgMoviePhoto.setImageResource(movie.getPhoto());
        }
    }
}
