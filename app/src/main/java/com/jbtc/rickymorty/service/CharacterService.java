package com.jbtc.rickymorty.service;

import com.jbtc.rickymorty.model.PaginationCharacter;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface CharacterService {
    @GET("character")
    Call<PaginationCharacter> getCharacters(@Query("page")int page);

    @GET("character/{id}")
    Call<Character> getCharacter(@Path("id") int id);

    @GET("character")
    Call<PaginationCharacter> getCharactersByNameAndStatus(@Query("name") String name, @Query("status") String status);
}
