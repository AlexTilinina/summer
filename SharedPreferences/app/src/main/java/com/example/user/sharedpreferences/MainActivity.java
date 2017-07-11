package com.example.user.sharedpreferences;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {

    EditText name, surname, address;
    Button save, takePhoto;
    ImageView photo;
    Gson gson = new Gson();
    long time;

    SharedPreferences sharedPreferences;
    public static final String KEY_NUMBER = "number";
    public static final int DEFAULT = 0;
    public static final String KEY_USER = "user";
    public static final int CAMERA_REQUEST = 2;
    public static final long TIME = 10000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.name);
        surname = (EditText) findViewById(R.id.surname);
        address = (EditText) findViewById(R.id.address);
        save = (Button) findViewById(R.id.save);
        takePhoto = (Button) findViewById(R.id.take_photo);
        photo = (ImageView) findViewById(R.id.photo);
        time = System.currentTimeMillis();

        sharedPreferences = getPreferences(MODE_PRIVATE);

        User prev = getUser(KEY_USER);

        if (prev != null) {
            if (time - prev.getLastLogin() > TIME){
                putUser(KEY_USER, null);
            }
            name.setText(prev.getName());
            surname.setText(prev.getSurname());
            address.setText(prev.getAddress());
            photo.setImageURI(Uri.fromFile(new File(prev.getPhotoPath())));
        }

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createUser();
            }
        });

        takePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
                    if(ActivityCompat.shouldShowRequestPermissionRationale
                            (MainActivity.this, Manifest.permission.CAMERA)){
                        Toast.makeText(MainActivity.this, "¯\\_(ツ)_/¯", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        ActivityCompat.requestPermissions(MainActivity.this,
                                new String[]{Manifest.permission.CAMERA}, 1);
                    }
                }
                else {
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    if (intent.resolveActivity(getPackageManager()) != null){
                        startActivityForResult(intent, CAMERA_REQUEST);
                    }
                }
            }
        });
    }

    private void createUser(){
        String nameS = name.getText().toString();
        String surnameS = surname.getText().toString();
        String add = address.getText().toString();

        User user = getUser(KEY_USER);

        if (user == null){
            user = new User(nameS, surnameS, add, System.currentTimeMillis());
        }
        else {
            user.setName(nameS);
            user.setSurname(surnameS);
            user.setAddress(add);
            user.setLastLogin(System.currentTimeMillis());
        }
        putUser(KEY_USER, user);
    }

    private void putInt(String key, int i){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, i);
        editor.apply();
    }

    private int getInt(String key){
       return sharedPreferences.getInt(key, DEFAULT);
    }

    private void putUser(String key, User user){
        String json = gson.toJson(user);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, json);
        editor.apply();
    }

    private User getUser(String key){
        String json = sharedPreferences.getString(key, "");
        if (json.equals("")) return null;
        return gson.fromJson(json, User.class);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK){
            Bundle extras = data.getExtras();
            Bitmap bitmap = (Bitmap) extras.get("data");

            File file = new File(this.getFilesDir(), "photo.jpeg");
            FileOutputStream fos = null;

            try {
                fos = new FileOutputStream(file);
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } finally {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            photo.setImageBitmap(bitmap);
            createUser();
            User user = getUser(KEY_USER);
            user.setPhotoPath(file.getAbsolutePath());
            user.setLastLogin(System.currentTimeMillis());
            putUser(KEY_USER, user);

        }
    }
}
