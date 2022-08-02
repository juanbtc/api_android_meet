package com.jbtc.rickymorty.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jbtc.rickymorty.databinding.CardviewCharacterBinding;
import com.jbtc.rickymorty.model.Character;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder> {
    private List<Character> items = new ArrayList<>();

    public void setItems(List<Character> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CharacterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CharacterViewHolder(CardviewCharacterBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CharacterViewHolder holder, int position) {
        Picasso.get()
                .load(items.get(position).getImage())
                .into(holder.binding.ivCharacterImagen);
        holder.binding.tvCharacterName.setText( items.get(position).getName() );
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class CharacterViewHolder extends RecyclerView.ViewHolder{
        CardviewCharacterBinding binding;
        public CharacterViewHolder(CardviewCharacterBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
    }
}
