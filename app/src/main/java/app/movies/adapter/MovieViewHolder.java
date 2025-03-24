package app.movies.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import app.movies.R;
import app.movies.model.Movie;

public class MovieViewHolder extends RecyclerView.ViewHolder {
    private TextView titleTextView;
    private TextView yearTextView;
    private TextView genreTextView;
    private ImageView posterImageView;

    public MovieViewHolder(@NonNull View MovieView) {
        super(MovieView);
        titleTextView = MovieView.findViewById(R.id.titleTextViewID);
        yearTextView = MovieView.findViewById(R.id.yearTextViewID);
        genreTextView = MovieView.findViewById(R.id.genreTextViewID);
        posterImageView = MovieView.findViewById(R.id.posterImageViewID);
    }

    public void bind(Movie movie){
        titleTextView.setText(movie.getTitle());
        yearTextView.setText(movie.getYear().toString());
        genreTextView.setText(movie.getGenre());
        posterImageView.setImageResource(R.drawable.placeholder_movie_image);
    }
}
