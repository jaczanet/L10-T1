package app.movies.repository;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import app.movies.R;
import app.movies.model.Movie;
import app.movies.util.JsonUtils;

public class MoviesRepository {
    public static List<Movie> loadMoviesFromJson(Context context) throws IOException, JSONException {
        JSONArray moviesJsonArray = new JSONArray(JsonUtils.readJsonFile(context, R.raw.movies));

        ArrayList<Movie> movies = new ArrayList<>();
        for (int i = 0; i < moviesJsonArray.length(); i++) {
            JSONObject movieJson = moviesJsonArray.getJSONObject(i);
            Movie movie = jsonObjectToMovie(movieJson);
            movies.add(movie);
        }

        return movies;
    }

    private static Movie jsonObjectToMovie(JSONObject movieJson) {
        // Missing or empty or null fields will have assigned "N/A" (or "0")
        String title = movieJson.optString("title", "N/A");
        // Invalid data formats: Math.abs to change the sign; .optInt always truncates a Double to Int
        Integer year = Math.abs(movieJson.optInt("year", 0));
        String genre = movieJson.optString("genre", "N/A");
        String posterResource = movieJson.optString("poster", "N/A");

        return new Movie(title, year, genre, posterResource);
    }
}
