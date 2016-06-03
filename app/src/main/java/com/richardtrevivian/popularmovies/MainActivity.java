package com.richardtrevivian.popularmovies;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {

    private final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MainActivityFragment mainActivityFragment = (MainActivityFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);
                Movie movie = mainActivityFragment.imageAdapter.movies[position];
                pushDetail(movie);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            startActivity(new Intent(this, SettingsActivity.class));
            return true;
        } else {
            Log.v(LOG_TAG, id + " clicked");
        }

        return super.onOptionsItemSelected(item);
    }

    public void pushDetail(Movie movie) {

        Intent intent = new Intent(this, DetailActivity.class)
                .putExtra(Movie.Keys.POSTER_PATH, movie.poster_path)
                .putExtra(Movie.Keys.TITLE, movie.title)
                .putExtra(Movie.Keys.RELEASE_DATE, movie.release_date)
                .putExtra(Movie.Keys.VOTE_AVERAGE, movie.vote_average)
                .putExtra(Movie.Keys.OVERVIEW, movie.overview);
        startActivity(intent);

    }
}
