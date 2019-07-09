package com.example.dwindibudimulia.moviecatalogue;

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
    private String[] sDataName;
    private String[] sDataDescription;
    private String[] sDataDate;
    private TypedArray mDataPhoto;
    private MovieAdapter adapter;
    private ArrayList<Movie> mMovies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new MovieAdapter(this);
        ListView listView = findViewById(R.id.lv_list);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "Kamu memilih " + mMovies.get(i).getsName(), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this, MovieDetailActivity.class);
                intent.putExtra(MovieDetailActivity.EXTRA_MOVIE, mMovies.get(i));

                startActivity(intent);
            }
        });
    }

    private void addItem(){
        mMovies = new ArrayList<>();
        for (int i = 0 ; i < sDataName.length; i++){
            Movie movie = new Movie();
            movie.setmPhoto(mDataPhoto.getResourceId(i, -1));
            movie.setsName(sDataName[i]);
            movie.setsDescription(sDataDescription[i]);
            movie.setsDate(sDataDate[i]);
            mMovies.add(movie);
        }
        adapter.setmMovies(mMovies);
    }

    private void prepare(){
        sDataName = getResources().getStringArray(R.array.movie_name);
        sDataDescription = getResources().getStringArray(R.array.movie_description);
        sDataDate = getResources().getStringArray(R.array.movie_date);
        mDataPhoto = getResources().obtainTypedArray(R.array.movie_photo);
    }
}
