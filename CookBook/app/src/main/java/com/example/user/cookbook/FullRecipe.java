package com.example.user.cookbook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FullRecipe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_recipe);

        TextView name = (TextView) findViewById(R.id.name);
        TextView time = (TextView) findViewById(R.id.time);
        TextView difficulty = (TextView) findViewById(R.id.difficulty);
        TextView description = (TextView) findViewById(R.id.description);
        Button ok = (Button) findViewById(R.id.ok);

        if (getIntent().getExtras() != null){
            Recipe recipe = (Recipe) getIntent().getExtras().getSerializable(MainActivity.RECIPE);
            name.setText(recipe.getName());
            time.setText(recipe.getTime());
            difficulty.setText(recipe.getDifficulty());
            description.setText(recipe.getDescription());
        }

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
