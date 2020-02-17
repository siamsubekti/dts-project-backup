package id.go.dts2019latihan.activity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import id.go.dts2019latihan.R;
import id.go.dts2019latihan.databases.DatabaseHelper;

public class LatihanSqlLiteActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etName,etPosition,etSalary;
    TextView tvNames;
    Button btnStore,btnGet;
    boolean isEdit = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_latihan_sql_lite);

        Bundle extras = getIntent().getExtras();

        if(extras != null) {
            if(extras.getInt("id", 0)>0) {
                isEdit = true;
            }else {
                isEdit = false;
            }
        }else {
            isEdit = false;
        }


        etName = findViewById(R.id.etName);
        etPosition = findViewById(R.id.etPosition);
        etSalary = findViewById(R.id.etSalary);
        tvNames = findViewById(R.id.tvNames);
        btnStore = findViewById(R.id.btnStore);
        btnGet = findViewById(R.id.btnGet);

        btnStore.setOnClickListener(this);
        btnGet.setOnClickListener(this);

        if(isEdit) {
           String siswa = new DatabaseHelper(this).getDataSiswa(getIntent()
                    .getExtras().getInt("id",0));
        }

    }


    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btnStore:
                if(isEdit){
                    if(etName.getText().toString().length()>0) {
                        new DatabaseHelper(this).
                                tambahSiswa(etName.getText().toString());
                    }
                }else {
                    if(etName.getText().toString().length()>0) {
                        new DatabaseHelper(this).
                                tambahSiswa(etName.getText().toString());
                    }
                }

                break;
            case R.id.btnGet:
                ArrayList<String> data = new DatabaseHelper(this)
                        .getSemuaDataSiswa();

                String names = "";
                for(int i=0; i < data.size(); i++){
                    names += data.get(i)+"\n";
                }

                tvNames.setText(names);


                break;
        }
    }
}
