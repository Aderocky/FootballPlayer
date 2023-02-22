package com.example.cobalogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    KendaliLogin Kl = new KendaliLogin();
    private TextView tvsesi;
    private Button btnLogout;
    public static String keySPusername = "GtPJAx45lMjkuICbExYElQ==_username";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        if (Kl.isLogin(MainActivity.this , keySPusername)){
            setContentView(R.layout.activity_main);
            tvsesi = findViewById(R.id.tv_sesi);
            btnLogout = findViewById((R.id.btn_logout));
        }
        else {
            startActivity(new Intent(MainActivity.this , ActivityLogin.class));
            finish();
        }




    }
}