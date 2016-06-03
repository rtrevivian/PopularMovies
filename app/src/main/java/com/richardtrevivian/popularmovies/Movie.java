package com.richardtrevivian.popularmovies;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by richard on 6/1/16.
 */
public class Movie {

    public class Keys {
        public static final String PAGE = "page";
        public static final String RESULTS = "results";
        public static final String TOTAL_RESULTS = "total_results";
        public static final String TOTAL_PAGES = "total_pages";

        public static final String POSTER_PATH = "poster_path";
        public static final String ADULT = "adult";
        public static final String OVERVIEW = "overview";
        public static final String RELEASE_DATE = "release_date";
        public static final String GENRE_ID = "genre_ids";
        public static final String ID = "id";
        public static final String ORIGINAL_TITLE = "original_title";
        public static final String ORIGINAL_LANGUAGE = "original_language";
        public static final String TITLE = "title";
        public static final String BACKDROP_PATH = "backdrop_path";
        public static final String POPULARITY = "popularity";
        public static final String VOTE_COUNT = "vote_count";
        public static final String VIDEO = "video";
        public static final String VOTE_AVERAGE = "vote_average";
    }

    public String poster_path;
    public String title;
    public String release_date;
    public String vote_average;
    public String overview;

    Movie(JSONObject jsonObject) throws JSONException {
        poster_path = "http://image.tmdb.org/t/p/w185" + jsonObject.getString(Keys.POSTER_PATH);
        title = jsonObject.getString(Keys.TITLE);
        release_date = jsonObject.getString(Keys.RELEASE_DATE);
        vote_average = jsonObject.getString(Keys.VOTE_AVERAGE);
        overview = jsonObject.getString(Keys.OVERVIEW);
    }

}
