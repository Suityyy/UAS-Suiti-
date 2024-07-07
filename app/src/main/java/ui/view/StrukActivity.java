package ui.view;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.suiti.uts.R;

import helper.DatabaseHelper;

public class StrukActivity extends AppCompatActivity {
    TextView nama_penyewa, jenis_mobil, lama_sewa, total, uang_bayar, uang_kembali;
    DatabaseHelper db;

    @SuppressLint("Range")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_struk);
        nama_penyewa = findViewById(R.id.nama_penyewa);
        jenis_mobil = findViewById(R.id.jenis_mobil);
        lama_sewa = findViewById(R.id.lama_sewa);
        total = findViewById(R.id.total);
        uang_bayar = findViewById(R.id.uang_bayar);
        uang_kembali = findViewById(R.id.uang_kembali);

        // Inisialisasi DatabaseHelper
        db = new DatabaseHelper(this);

        // Mengambil data terakhir dari database
        Cursor cursor = db.getLastSewa();
        if (cursor.moveToFirst()) {
            nama_penyewa.setText(cursor.getString(cursor.getColumnIndex("nama")));
            jenis_mobil.setText(cursor.getString(cursor.getColumnIndex("mobil")));
            lama_sewa.setText(String.valueOf(cursor.getInt(cursor.getColumnIndex("lama"))));
            total.setText(String.valueOf(cursor.getInt(cursor.getColumnIndex("total"))));
            uang_bayar.setText(String.valueOf(cursor.getInt(cursor.getColumnIndex("uang"))));
            uang_kembali.setText(String.valueOf(cursor.getInt(cursor.getColumnIndex("kembalian"))));
        }
        cursor.close();
    }

    public void hal_utama(View view) {
        Intent intent = new Intent(StrukActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
