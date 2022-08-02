package com.jbtc.rickymorty.service;

import com.jbtc.rickymorty.model.PaginationCharacter;
import com.jbtc.rickymorty.model.PaginationLocation;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface LocationService {
    @GET("location")
    Call<PaginationLocation> getLocations(@Query("page")int page);

    @GET("location/{id}")
    Call<Character> getLocation(@Path("id") int id);

    @GET("location")
    Call<PaginationLocation> getLocationsByNameAndStatus(@Query("name") String name, @Query("status") String status);
}
