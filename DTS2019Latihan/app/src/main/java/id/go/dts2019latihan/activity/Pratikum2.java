package id.go.dts2019latihan.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import id.go.dts2019latihan.R;

public class Pratikum2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pratikum2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.menu_1){
            startActivity(new Intent(this, Menu1.class));
        }else if(item.getItemId()==R.id.menu_2){
            startActivity(new Intent(this, Menu2.class));
        }else if(item.getItemId()==R.id.menu_3){
            startActivity(new Intent(this, Menu3.class));
        }


        return super.onOptionsItemSelected(item);
    }
}
