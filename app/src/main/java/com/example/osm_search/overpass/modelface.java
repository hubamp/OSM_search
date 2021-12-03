package com.example.osm_search.overpass;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface modelface {

    String subUrl = "search";

    @GET(subUrl)
    Call<ArrayList<model>>
    getData
            (@Query("q") String q,
            @Query("countrycodes") String country ,
            @Query("limit") int limit ,
            @Query("format") String format);
}
