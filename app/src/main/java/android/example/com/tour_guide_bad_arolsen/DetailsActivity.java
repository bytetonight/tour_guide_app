package android.example.com.tour_guide_bad_arolsen;

import android.content.Intent;
import android.databinding.DataBindingUtil;

import android.example.com.tour_guide_bad_arolsen.databinding.ActivityDetailsBinding;

import android.example.com.tour_guide_bad_arolsen.poi.interfaces.PointOfInterest;
import android.example.com.tour_guide_bad_arolsen.utils.Utils;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;


public class DetailsActivity extends AppCompatActivity {

    private PointOfInterest poi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Intent senderIntent = getIntent();
        if (senderIntent != null && senderIntent.hasExtra(Utils.ARG_POI)) {
            poi = senderIntent.getParcelableExtra(Utils.ARG_POI);

        }

        if (savedInstanceState != null) {
            poi = savedInstanceState.getParcelable(Utils.ARG_POI);
        }

        ActivityDetailsBinding binding = DataBindingUtil.setContentView(DetailsActivity.this, R.layout.activity_details);
        binding.setPoi(this.getPoi());

        setTitle(poi.getName());


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, R.string.action_coming_soon, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(Utils.ARG_POI, poi);
    }

    public PointOfInterest getPoi() {
        return poi;
    }
}
