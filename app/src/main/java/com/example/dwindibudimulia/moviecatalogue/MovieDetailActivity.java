package com.example.dwindibudimulia.moviecatalogue;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MovieDetailActivity extends AppCompatActivity {

    public static final String EXTRA_MOVIE = "extra_movie";

    TextView tvObject;
    TextView tvDescription;
    TextView tvDate;
    ImageView imgPhoto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        tvObject = findViewById(R.id.tv_object);
        tvDescription = findViewById(R.id.txt_description);
        tvDate = findViewById(R.id.txt_date);
        imgPhoto = findViewById(R.id.img_photo);

        Movie movie = getIntent().getParcelableExtra(EXTRA_MOVIE);


        tvObject.setText(movie.getsName());
        tvDescription.setText(movie.getsDescription());
        tvDate.setText(movie.getsDate());
        imgPhoto.setImageResource(movie.getmPhoto());


    }
}

