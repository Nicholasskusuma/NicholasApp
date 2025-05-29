package com.example.nicholasapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.text.DecimalFormat;



import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class KalkulatorActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_kalkulator);
        // Inisialisasi komponen
        EditText editText1 = findViewById(R.id.edtPertamaA);
        EditText editText2 = findViewById(R.id.edtPertamaB);
        TextView txtHasil = findViewById(R.id.txthasil);

        Button btnTambah = findViewById(R.id.btnTambah);
        Button btnKali = findViewById(R.id.btnKali);
        Button btnBagi = findViewById(R.id.btnBagi);
        DecimalFormat format = new DecimalFormat("0.#");
// Tombol Tambah
        btnTambah.setOnClickListener(v -> {
            double a = Double.parseDouble(editText1.getText().toString());
            double b = Double.parseDouble(editText2.getText().toString());
            double hasil = a + b;
            txtHasil.setText(" " + format.format(hasil));
        });

// Tombol Kali
        btnKali.setOnClickListener(v -> {
            double a = Double.parseDouble(editText1.getText().toString());
            double b = Double.parseDouble(editText2.getText().toString());
            double hasil = a * b;
            txtHasil.setText(" " + format.format(hasil));
        });

// Tombol Bagi
        btnBagi.setOnClickListener(v -> {
            double a = Double.parseDouble(editText1.getText().toString());
            double b = Double.parseDouble(editText2.getText().toString());
            if (b != 0) {
                double hasil = a / b;
                txtHasil.setText(" " + format.format(hasil));
            } else {
                txtHasil.setText("Tidak bisa dibagi dengan 0");
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}