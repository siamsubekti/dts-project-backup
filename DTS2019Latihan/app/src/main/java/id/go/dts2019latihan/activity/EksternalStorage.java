package id.go.dts2019latihan.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
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

public class EksternalStorage extends AppCompatActivity implements View.OnClickListener {
    static final String _NAMAFILE = "filelatihan.txt";
    Button actionBuat,actionUbah,actionBaca,actionHapus;
    EditText edtPesan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eksternal_storage);
        actionBuat = findViewById(R.id.actionBuat);
        actionUbah = findViewById(R.id.actionUbah);
        actionBaca = findViewById(R.id.actionBaca);
        actionHapus = findViewById(R.id.actionHapus);
        edtPesan = findViewById(R.id.edtPesan);

        actionBuat.setOnClickListener(this);
        actionUbah.setOnClickListener(this);
        actionBaca.setOnClickListener(this);
        actionHapus.setOnClickListener(this);
        bacaListFolder();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.actionBuat:
            case R.id.actionUbah:
                if(periksaIzinPenyimpanan()) {
                    buatFile();
                }
                break;
            case R.id.actionBaca:
                if(periksaIzinPenyimpanan()) {
                    bacaFile();
                }
                break;
            case R.id.actionHapus:
                if(periksaIzinPenyimpanan()) {
                    hapusFile();
                }
                break;
        }
    }

    void buatFile(){
        String isiFile = edtPesan.getText().toString();
        if(isiFile.length()==0) {
            return;
        }

        File file = new File("/storage/sdcard1/",_NAMAFILE);
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

    void bacaListFolder() {

        File file = new File("/storage/sdcard1/");
        String[] data = file.list();

        String isiFile = "123456";
        if(isiFile.length()==0) {
            return;
        }

        File file1 = new File("/storage/sdcard1/",_NAMAFILE);
        try {
            file1.createNewFile();
            FileOutputStream outputStream = new FileOutputStream(file1,false);
            outputStream.write(isiFile.getBytes());
            outputStream.flush();
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        for(String tes:data) {
            Log.e("data : ", ""+tes);
        }
    }

    void bacaFile(){
        File file = new File("/storage/sdcard1/",_NAMAFILE);
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
        File file = new File(Environment.getExternalStorageDirectory(),_NAMAFILE);
        if(file.exists()){
            file.delete();
        }
    }

    boolean periksaIzinPenyimpanan() {
        if(Build.VERSION.SDK_INT >= 23) {
            if(checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED ) {
                return true;
            }else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        100);
                return false;
            }

        }else {
            return true;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode==100){

        }

        //event ketika Required Permission di setujui atau tidak


    }
}
