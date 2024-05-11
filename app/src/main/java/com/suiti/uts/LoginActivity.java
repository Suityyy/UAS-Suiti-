package com.suiti.uts;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    TextView btn;
    EditText inputEmail, inputPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn = findViewById(R.id.textViewSignUp);
        inputEmail = findViewById(R.id.inputEmail);
        inputPassword = findViewById(R.id.inputPassword);
        btnLogin = findViewById(R.id.btnlogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkCredentials();
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });
    }

    private void checkCredentials() {
        String email = inputEmail.getText().toString();
        String password = inputPassword.getText().toString();

        if (email.isEmpty() || !email.contains("@")) {
            showError(inputEmail, "Email is not valid!");
        } else if (password.isEmpty() || password.length() < 7) {
            showError(inputPassword, "Password must be 7 characters long!");
        } else {
            // Jika validasi berhasil, lakukan login
            performLogin();
        }
    }

    private void performLogin() {
        // Simpan logika login Anda di sini
        // Misalnya, Anda dapat memeriksa kredensial dengan server atau database
        // Jika berhasil, Anda dapat pindah ke halaman dashboard
        startActivity(new Intent(LoginActivity.this, Dasboard.class));
    }

    private void showError(EditText input, String message) {
        input.setError(message);
        input.requestFocus();
    }
}