package com.suiti.uts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;

public class Dasboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dasboard);
    }

    public void Tombol_info(View view) {
        Intent intent =new Intent(Dasboard.this, DaftarMobilActivity.class);
        startActivity(intent);
    }

    public void tombol_sewa(View view) {
        Intent intent =new Intent(Dasboard.this, SewaMobilActivity.class);
        startActivity(intent);
    }

    public void tombol_contact(View view) {
        Intent intent =new Intent(Dasboard.this, ContactActivity.class);
        startActivity(intent);
    }
}