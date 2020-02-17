package id.go.dts2019latihan.activity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import id.go.dts2019latihan.R;

public class PraktekInternalStorage extends AppCompatActivity implements View.OnClickListener {

    static final String _NAMAFILE = "filelatihan.txt";
    Button actionBuat,actionUbah,actionBaca,actionHapus;
    EditText edtPesan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_praktek_internal_storage);

        actionBuat = findViewById(R.id.actionBuat);
        actionUbah = findViewById(R.id.actionUbah);
        actionBaca = findViewById(R.id.actionBaca);
        actionHapus = findViewById(R.id.actionHapus);
        edtPesan = findViewById(R.id.edtPesan);

        actionBuat.setOnClickListener(this);
        actionUbah.setOnClickListener(this);
        actionBaca.setOnClickListener(this);
        actionHapus.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.actionBuat:
            case R.id.actionUbah:
                buatFile();
                break;
            case R.id.actionBaca:
                bacaFile();
                break;
            case R.id.actionHapus:
                hapusFile();
                break;
        }
    }

    void buatFile(){
        String isiFile = edtPesan.getText().toString();
        if(isiFile.length()==0) {
            return;
        }

        File file = new File(getFilesDir(),_NAMAFILE);
        try {
            file.createNewFile();
            FileOutputStream outputStream = new FileOutputStream(file,false);
            outputStream.write(isiFile.getBytes());
            outputStream.flush();
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    void bacaFile(){
        File file = new File(getFilesDir(),_NAMAFILE);
        if(file.exists()){
            StringBuilder text = new StringBuilder();

            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line = br.readLine();
                while (line!=null){
                    text.append(line);
                    line = br.readLine();
                }
                br.close();
                edtPesan.setText(text);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }

    void hapusFile(){
        File file = new File(getFilesDir(),_NAMAFILE);
        if(file.exists()){
            file.delete();
        }
    }
}
