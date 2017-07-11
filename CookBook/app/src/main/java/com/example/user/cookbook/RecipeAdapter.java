package com.example.user.cookbook;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by User on 10.07.2017.
 */

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>{

    List<Recipe> recipes;
    OnRecipeClickListener listener;

    public RecipeAdapter(List<Recipe> recipes, OnRecipeClickListener listener) {
        this.recipes = recipes;
        this.listener = listener;
    }

    @Override
    public RecipeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RecipeViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recipe_item,parent,false));
    }

    @Override
    public void onBindViewHolder(RecipeViewHolder holder, int position) {
        final Recipe recipe = recipes.get(position);
        holder.name.setText(recipe.getName());
        holder.time.setText(recipe.getTime());
        holder.difficulty.setText(recipe.getDifficulty());
        holder.shortDescription.setText(recipe.getShortDescription());
        holder.description = recipe.getDescription();
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.OnRecipeClick(recipe);
            }
        });
        holder.relativeLayout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                listener.OnRecipeLongClick(recipe);
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }

    public class RecipeViewHolder extends RecyclerView.ViewHolder{

        TextView name;
        TextView time;
        TextView difficulty;
        TextView shortDescription;
        String description;
        RelativeLayout relativeLayout;

        public RecipeViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            time = (TextView) itemView.findViewById(R.id.time);
            difficulty = (TextView) itemView.findViewById(R.id.difficulty);
            shortDescription = (TextView) itemView.findViewById(R.id.description);
            relativeLayout = (RelativeLayout) itemView.findViewById(R.id.relative_layout);
        }
    }

    interface OnRecipeClickListener{
        void OnRecipeClick(Recipe recipe);
        void OnRecipeLongClick(Recipe recipe);
    }
}
