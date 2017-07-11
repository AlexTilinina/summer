package com.example.user.cookbook;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecipeAdapter.OnRecipeClickListener{

    List<Recipe> list;
    RecyclerView.LayoutManager layoutManager;
    RecipeAdapter adapt;
    RecyclerView recyclerView;
    public final static String RECIPE = "recipe";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createList();
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        adapt = new RecipeAdapter(list, this);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setAdapter(adapt);
        recyclerView.setLayoutManager(layoutManager);
    }

    public void createList(){
        list = new ArrayList<>();
        list.add(new Recipe("Яичница", "5 мин", "*", "Простой и сытный завтрак",
                "Для приготовления достаточно будет взять два яйца, немного подсолнечного масла, соль и перец по вкусу. Разогреваем " +
                        "сковороду..... и так далее"));
        list.add(new Recipe("Test", "3 min", "* *", "Just test information", "Here you can read much and much more. I think... Err, it doesn't matter"));
        list.add(new Recipe("Test2", "7 min", "* * *", "Just test2 information", "Test test test 228"));
        list.add(new Recipe("Test3", "8 min", "* * * *", "Just test3 information", "Test test test 118"));
        list.add(new Recipe("Test4", "9 min", "* * *", "Just test4 information", "Test test test 00"));
        list.add(new Recipe("Test5", "71 min", "* * * * *", "Just test5 information", "Test test test 12"));
    }

    @Override
    public void OnRecipeClick(Recipe recipe) {
        Intent intent = new Intent(this, FullRecipe.class);
        intent.putExtra(RECIPE, recipe);
        startActivity(intent);
    }


    @Override
    public void OnRecipeLongClick(final Recipe recipe) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Delete")
                .setMessage("Are you sure?")
                .setPositiveButton("YES",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                list.remove(list.indexOf(recipe));
                                adapt = new RecipeAdapter(list, MainActivity.this);
                                layoutManager = new LinearLayoutManager(MainActivity.this);
                                recyclerView.setAdapter(adapt);
                                recyclerView.setLayoutManager(layoutManager);
                            }
                        }
                        )
                .setNegativeButton("NO",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
