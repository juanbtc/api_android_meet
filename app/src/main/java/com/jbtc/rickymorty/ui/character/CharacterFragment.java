package com.jbtc.rickymorty.ui.character;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.jbtc.rickymorty.adapter.CharacterAdapter;
import com.jbtc.rickymorty.config.ConfigVar;
import com.jbtc.rickymorty.databinding.FragmentCharacterBinding;
import com.jbtc.rickymorty.model.PaginationCharacter;
import com.jbtc.rickymorty.service.CharacterService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CharacterFragment extends Fragment {

    private static final String TAG = "GDSD";
    private FragmentCharacterBinding binding;
    private CharacterAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentCharacterBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initAdapter();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConfigVar.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CharacterService serviceCharacter = retrofit.create(CharacterService.class);
        serviceCharacter.getCharacters(5).enqueue(new Callback<PaginationCharacter>() {
            @Override
            public void onResponse(Call<PaginationCharacter> call, Response<PaginationCharacter> response) {
                //Log.i(TAG, "onResponse: respuesta: "+response.body());
                adapter.setItems(response.body().getResults());

            }

            @Override
            public void onFailure(Call<PaginationCharacter> call, Throwable t) {
                Log.e(TAG, "onFailure: ", t);
            }
        });

    }

    private void initAdapter() {
        binding.rvCharacters.setHasFixedSize(true);
        adapter = new CharacterAdapter();
        binding.rvCharacters.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}