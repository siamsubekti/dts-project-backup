package id.go.dts2019latihan.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import id.go.dts2019latihan.adapter.ListDataSiswaAdapter;
import id.go.dts2019latihan.R;
import id.go.dts2019latihan.model.Siswa;

public class Pratikum3 extends AppCompatActivity {

    ListView listView;
    ListDataSiswaAdapter adapter;
    ArrayList<Siswa> dataArray = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pratikum3);
        listView = findViewById(R.id.listView);
        adapter = new ListDataSiswaAdapter(this, R.layout.item_list);
        listView.setAdapter(adapter);
        buatData();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Siswa data = (Siswa) adapterView.getAdapter().getItem(i);
                Intent intent = new Intent(Pratikum3.this, LatihanSqlLiteActivity.class);
                intent.putExtra("id",2);
                intent.putExtra("nama","udin");
                intent.putExtra("alamat","depok");

                startActivity(intent);

                Toast.makeText(Pratikum3.this, ""+
                        data.getNama(),Toast.LENGTH_SHORT).show();

            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Siswa data = (Siswa) adapterView.getAdapter().getItem(i);
                Toast.makeText(Pratikum3.this, ""+data.getNama(),Toast.LENGTH_SHORT).show();
                new AlertDialog.Builder(Pratikum3.this).setItems(
                        new String[]{"Edit", "delete"}, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                if(i==0) {

                                }else {

                                }


                            }
                        }).show();

                return true;
            }
        });

    }

    void buatData() {
        dataArray.clear();
        adapter.clear();

        Integer[] bendara = {R.drawable.bendara_indonesia,R.drawable.bendara_inggris,R.drawable.bendera_thailand
        };
        String[] namaSiswa = {"Syamsi","Udin","Joko"};
        String[] emailSiswa = {"syamsi@mail.com", "udin@mail.com","joko@mail.com"};
        String[] alamatSiswa = {
                "Jl Mi Ridwan Rais No 47 Rt 04/05 Kec Beji, Beji Timur",
                "JL Damai Kami Sepanjang Hari No 47 Rt 04/05 Kec Beji, Beji Timur",
                "JL Kembang Beji No 47 Rt 04/05 Kec Beji, Beji Timur"
        };

        for (int i =0; i< namaSiswa.length; i++){
            Siswa data = new Siswa();
            data.setImage(bendara[i]);
            data.setNama(namaSiswa[i]);
            data.setEmail(emailSiswa[i]);
            data.setAlamat(alamatSiswa[i]);
            dataArray.add(data);

        }

        adapter.addAll(dataArray);
        adapter.notifyDataSetChanged();



    }
}
