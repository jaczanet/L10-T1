package app.movies;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import app.movies.adapter.MovieAdapter;
import app.movies.model.Movie;
import app.movies.repository.MoviesRepository;

public class MainActivity extends AppCompatActivity {
    private RecyclerView movieRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Movie> movies = loadMovieData();
        MovieAdapter adapter = new MovieAdapter(movies);
        setUpRecyclerView(adapter);
    }

    private void setUpRecyclerView(MovieAdapter adapter){
        movieRecyclerView = findViewById(R.id.recyclerViewMoviesID);
        movieRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        movieRecyclerView.setHasFixedSize(true);
        movieRecyclerView.setAdapter(adapter);
    }

    private List<Movie> loadMovieData(){
        List<Movie> movies = new ArrayList<>();
        try {
            movies = MoviesRepository.loadMoviesFromJson(this);
        } catch (IOException exc) {
            showError("Error accessing movies data. Please try again.");
        } catch (JSONException exc){
            showError("Error reading movies data. Please try again.");
        }
        return movies;
    }

    private void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}