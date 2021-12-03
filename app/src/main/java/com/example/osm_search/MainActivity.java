package com.example.osm_search;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.osm_search.search.SearchActivity;

public class MainActivity extends AppCompatActivity {

    private TextView searchDestination;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchDestination = findViewById(R.id.destinationSearchId);
        searchDestination.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SearchActivity.class);
                startActivityIfNeeded(i, 100);
            }
        });
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.e("onActivity001", "started");
        if (resultCode == Activity.RESULT_OK && requestCode == 100) {

            Log.e("onActivity001", "Result is ok");

            if (data != null) {
                Log.e("onActivity001", "Data not null");

                if (data.hasExtra(new SearchActivity().theNameID))
                    Log.e("onActivity001", "has Name");
                if (data.hasExtra(new SearchActivity().theLatID))
                    Log.e("onActivity001", "has Latitude");
                if (data.hasExtra(new SearchActivity().theLonID))
                    Log.e("onActivity001", "has Longitude");
                String datas = data.getExtras().getString("theLocationName") + " " + data.getExtras().getDouble("theLat", 0.0) + " " + data.getExtras().getDouble("theLon", 0.0);
                Log.e("onActivity001-Data", datas);

                searchDestination.setText(data.getExtras().getString("theLocationName"));

                Log.e("Result", data.getExtras().getString(new SearchActivity().theNameID));
             /*   infoNameD = data.getExtras().getString("theLocationName");
                infoLonD = String.valueOf(data.getExtras().getDouble("theLon", 0.0));
                infoLatD = String.valueOf(data.getExtras().getDouble("theLat", 0.0));

                Log.i("onActivity001", "Lon :" + infoLonD);
                Log.i("onActivity001", "Lat :" + infoLatD);*/
            }


        }



        }

}