package id.go.dts2019latihan.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import id.go.dts2019latihan.R;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {
    Button action_pratikum1, action_pratikum2, action_pratikum3, action_pratikum4, action_pratikum5,action_pratikum6,action_pratikum7;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_layout);
        action_pratikum1 = findViewById(R.id.action_pratikum1);
        action_pratikum1.setOnClickListener(this);
        action_pratikum2 = findViewById(R.id.action_pratikum2);
        action_pratikum2.setOnClickListener(this);
        action_pratikum3 = findViewById(R.id.action_pratikum3);
        action_pratikum3.setOnClickListener(this);
        action_pratikum4 = findViewById(R.id.action_pratikum4);
        action_pratikum4.setOnClickListener(this);
        action_pratikum5 = findViewById(R.id.action_pratikum5);
        action_pratikum5.setOnClickListener(this);
        action_pratikum6 = findViewById(R.id.action_pratikum6);
        action_pratikum6.setOnClickListener(this);
        action_pratikum7 = findViewById(R.id.action_pratikum7);
        action_pratikum7.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.action_pratikum1:
                Intent intentPratikum1 = new
                        Intent(MenuActivity.this,
                        Pratikum1.class);
                startActivity(intentPratikum1);
                break;
            case R.id.action_pratikum2:
                startActivity(new Intent(MenuActivity.this, Pratikum2.class));
                break;
            case R.id.action_pratikum3:
                startActivity(new Intent(MenuActivity.this, Pratikum3.class));
                break;
            case R.id.action_pratikum4:
                startActivity(new Intent(MenuActivity.this, PraktekInternalStorage.class));
                break;
            case R.id.action_pratikum5:
                startActivity(new Intent(MenuActivity.this, EksternalStorage.class));
                break;
            case R.id.action_pratikum6:
                startActivity(new Intent(MenuActivity.this, LatihanSqlLiteActivity.class));
                break;
            case R.id.action_pratikum7:
                startActivity(new Intent(MenuActivity.this, LatihanVolleyActivity.class));
                break;
        }

    }
}
