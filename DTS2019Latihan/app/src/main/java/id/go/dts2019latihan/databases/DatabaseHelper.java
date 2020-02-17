package id.go.dts2019latihan.databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String _NAMA_DATABASE = "DB_SISWA";
    public static final int _VERSION = 1;
    Context context;

    public DatabaseHelper(Context context) {
        super(context, _NAMA_DATABASE, null, _VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE tb_siswa " +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT, firstname TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS tb_siswa");
        onCreate(sqLiteDatabase);
    }

    public void tambahSiswa(String namaSiswa) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("firstname", namaSiswa);

        long insert = db.insert("tb_siswa", null,
                contentValues);

        try {
            db.execSQL("");
        }catch (SQLException e){
            
        }



        long update = db.update("tb_siswa", contentValues,
                "id="+2, null);

        long delete = db.delete("tb_siswa","id="+2,
                null);

        if (insert != -1) {
            Toast.makeText(context, "Simpan Database berhasil",
                    Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Simpan Database Gagal",
                    Toast.LENGTH_SHORT).show();
        }
    }


    public ArrayList<String> getSemuaDataSiswa() {
        ArrayList<String> data = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "select * from tb_siswa";

        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                data.add(cursor.getString(1));
            } while (cursor.moveToNext());

        }

        return data;
    }

    public String getDataSiswa(int id) {
        String siswa = "";

        SQLiteDatabase db = this.getReadableDatabase();
        String query = "select * from tb_siswa where id=?";
        Cursor cursor = db.rawQuery(query, new String[]{"" + id});


        if(cursor.moveToFirst()) {

            do {
                siswa = cursor.getString(1);

            }while (cursor.moveToNext());
        }

        return siswa;
    }
}
