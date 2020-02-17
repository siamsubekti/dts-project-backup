package id.go.dts2019latihan.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import id.go.dts2019latihan.R;
import id.go.dts2019latihan.databases.DatabaseHelper;

public class LatihanVolleyActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etName,etPosition,etSalary;
    TextView tvNames;
    Button btnStore,btnGet;
    boolean isEdit = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_latihan_volley);

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


    void kirimData() {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://10.24.1.200/aplikasipegawai/tambahpgw.php";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        Log.e("response", ""+ response);
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            Toast.makeText(LatihanVolleyActivity.this, jsonObject.getString("result"),
                                    Toast.LENGTH_SHORT).show();



                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(LatihanVolleyActivity.this, "Terjadi Kesalahan",
                        Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() {
                Map<String,String> parameter = new HashMap<>();

                parameter.put("name", etName.getText().toString());
                parameter.put("position", etPosition.getText().toString());
                parameter.put("salary", etSalary.getText().toString());

                return parameter;
            }
        };

        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }


    void getAlldata() {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://10.24.1.200/aplikasipegawai/tampilsemuapgw.php";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        Log.e("response", ""+ response);
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            JSONArray jsonArray = jsonObject.getJSONArray("result");



                            String names = "";
                            for(int i=0; i< jsonArray.length();i++){
                                JSONObject item = jsonArray.getJSONObject(i);

                                names += item.getString("name")+"\n";
                            }
                            tvNames.setText(names);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(LatihanVolleyActivity.this, "Terjadi Kesalahan",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btnStore:
                kirimData();
                break;
            case R.id.btnGet:
                getAlldata();

                break;
        }
    }
}
