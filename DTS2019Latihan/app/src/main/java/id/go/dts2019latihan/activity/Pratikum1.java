package id.go.dts2019latihan.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import id.go.dts2019latihan.R;

public class Pratikum1 extends AppCompatActivity implements View.OnClickListener {

    Button btn_change_color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pratikum1);
        btn_change_color = findViewById(R.id.action_btn_change_color);
        btn_change_color.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
            btn_change_color.setBackgroundColor(Color.RED);
            btn_change_color.setBackgroundColor(getResources().getColor(R.color.custom));
    }
}
