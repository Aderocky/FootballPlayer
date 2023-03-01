package com.example.cobalogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    KendaliLogin Kl = new KendaliLogin();
    private TextView tvsesi , tvName;
    private Button btnLogout;
    public static String keySPusername = "GtPJAx45lMjkuICbExYElQ==_username";
    //keytvname
    public static String keySPname = "GtPJAx45lMjkuICbExYElQ==_name";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        if (Kl.isLogin(MainActivity.this , keySPusername)){
            setContentView(R.layout.activity_main);
            tvsesi = findViewById(R.id.tv_sesi);
            tvName = findViewById(R.id.tv_name);
            btnLogout = findViewById((R.id.btn_logout));

            tvName.setText(Kl.getPref(MainActivity.this,keySPname));
            tvsesi.setText(Kl.getPref(MainActivity.this,keySPusername));

            btnLogout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Kl.setPref(MainActivity.this,keySPusername, null);
                    Kl.setPref(MainActivity.this,keySPname, null);
                    startActivity(new Intent(MainActivity.this,ActivityLogin.class));
                    finish();
                }
            });
        }
        else {
            startActivity(new Intent(MainActivity.this , ActivityLogin.class));
            finish();
        }




    }
}