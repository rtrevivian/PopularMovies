package com.richardtrevivian.popularmovies;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * A placeholder fragment containing a simple view.
 */
public class DetailActivityFragment extends Fragment {

    private final String LOG_TAG = DetailActivityFragment.class.getSimpleName();

    private ImageView poster;

    private TextView title;
    private TextView release_date;
    private TextView vote_average;
    private TextView overview;

    public DetailActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        poster = (ImageView) view.findViewById(R.id.fragment_detail_imageview_poster);
        title = (TextView) view.findViewById(R.id.fragment_detail_textview_title);
        release_date = (TextView) view.findViewById(R.id.fragment_detail_textview_release_date);
        vote_average = (TextView) view.findViewById(R.id.fragment_detail_textview_vote_average);
        overview = (TextView) view.findViewById(R.id.fragment_detail_textview_overview);

        Intent intent = getActivity().getIntent();
        if (intent != null) {
            if (intent.hasExtra(Movie.Keys.POSTER_PATH)) {
                String poster_path = (String) intent.getStringExtra(Movie.Keys.POSTER_PATH);
                Picasso.with(getContext())
                        .load(poster_path)
                        .into(poster);
            }
            if (intent.hasExtra(Movie.Keys.TITLE)) {
                title.setText((String) intent.getStringExtra(Movie.Keys.TITLE));
            }
            if (intent.hasExtra(Movie.Keys.RELEASE_DATE)) {
                String year = (String) intent.getStringExtra(Movie.Keys.RELEASE_DATE);
                release_date.setText(year.substring(0, 4));
            }
            if (intent.hasExtra(Movie.Keys.VOTE_AVERAGE)) {
                String average = (String) intent.getStringExtra(Movie.Keys.VOTE_AVERAGE);
                vote_average.setText(average + "/10");
            }
            if (intent.hasExtra(Movie.Keys.OVERVIEW)) {
                overview.setText((String) intent.getStringExtra(Movie.Keys.OVERVIEW));
            }
        }

        return view;
    }

}
