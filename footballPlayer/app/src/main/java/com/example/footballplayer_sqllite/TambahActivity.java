package com.example.footballplayer_sqllite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TambahActivity extends AppCompatActivity {

    private EditText et_nama , et_nomor , et_klub;
    private Button btnTambah;
    myDataClassHelper db = new myDataClassHelper(TambahActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);

        et_nama = findViewById(R.id.et_nama);
        et_nomor = findViewById(R.id.et_nomor);
        et_klub = findViewById(R.id.et_klub);
        btnTambah = findViewById(R.id.btn_nambah);

        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama , nomor,klub;

                nama = et_nama.getText().toString();
                nomor = et_nomor.getText().toString();
                klub = et_klub.getText().toString();

                if (nama.trim().equals("")){
                    et_nama.setError("nama tidak boleh kosong");
                }
                else if (nomor.trim().equals("")){
                    et_nomor.setError("nomor tidak boleh kosong");
                }
                else if (klub.trim().equals("")){
                    et_klub.setError("nama klub tidak boleh kosong");
                }
                else {
                    long ex = db.tambahPlayer(nama,nomor,klub);
                    if (ex == -1){
                        Toast.makeText(TambahActivity.this , "gagal menambah data",Toast.LENGTH_SHORT).show();
                        et_nama.requestFocus();
                    }
                    else{
                        Toast.makeText(TambahActivity.this,"berhasil menambah data" , Toast.LENGTH_LONG).show();
                        finish();
                    }
                }
            }
        });
    }
}