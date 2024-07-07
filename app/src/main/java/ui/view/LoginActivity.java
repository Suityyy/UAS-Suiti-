package ui.view;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.suiti.uts.R;

import java.util.List;

import api.ApiConfig;
import model.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

        ApiConfig.getRetrofitClient().getAllUser().enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if(response.isSuccessful()&&response.body()!=null){
                    boolean isSucesfullLogin = false;
                    for (User user : response.body()){
                        if (email.equals(user.getEmail())&&password.equals("password")){
                            isSucesfullLogin=true;
                            break;
                        }
                    }
                    if (email.isEmpty() || password.isEmpty()) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                        builder.setMessage("Email atau password harus diisi")
                                .setNegativeButton("Ulangi", null)
                                .create().show();
                    } else if (isSucesfullLogin) {
                        performLogin();
                    } else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                        builder.setMessage("Email atau password salah")
                                .setNegativeButton("Ulangi", null)
                                .create().show();

                    }
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable throwable) {

            }
        });
    }

    private void performLogin() {
        // Simpan logika login Anda di sini
        // Misalnya, Anda dapat memeriksa kredensial dengan server atau database
        // Jika berhasil, Anda dapat pindah ke halaman dashboard
        startActivity(new Intent(LoginActivity.this, Dasboard.class));
    }
}