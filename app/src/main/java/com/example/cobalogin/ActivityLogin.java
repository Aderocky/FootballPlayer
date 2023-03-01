package com.example.cobalogin;

import static com.example.cobalogin.MainActivity.keySPusername;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityLogin extends AppCompatActivity {

    private EditText etUsername, etPassword;
    private Button btnLogin;
    private String userName , password;
    KendaliLogin Kl = new KendaliLogin();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userName = etUsername.getText().toString();
                password = etPassword.getText().toString();

                if(userName.trim().equals("")){
                    etUsername.setError("User name tidak boleh kosong");
                }
                else if (password.trim().equals("")){
                    etPassword.setError("Password tidak boleh kosong");
                }
                else {
                    if(userName.trim().equals("AdeRocky")&& (password.trim().equals("10032003"))){
                        Kl.setPref(ActivityLogin.this , MainActivity
                                .keySPusername,userName);
                        Kl.setPref(ActivityLogin.this , MainActivity
                                .keySPname,"Ade Ganteng");
                        startActivity(new Intent(ActivityLogin.this,MainActivity.class));
                        finish();
                    }
                    else{
                        Toast.makeText(ActivityLogin.this, "UserName dan password belum tepat",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}