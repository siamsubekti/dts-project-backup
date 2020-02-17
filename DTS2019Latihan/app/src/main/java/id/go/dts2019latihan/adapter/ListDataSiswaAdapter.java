package id.go.dts2019latihan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import id.go.dts2019latihan.R;
import id.go.dts2019latihan.model.Siswa;

public class ListDataSiswaAdapter extends ArrayAdapter<Siswa> {
    Context context;
    int resource;

    public ListDataSiswaAdapter(Context context, int resource) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listViewItem = convertView;

        if (listViewItem == null) {
            listViewItem = LayoutInflater.from(context).inflate(resource, null);
        }

        ImageView imgGambar = listViewItem.findViewById(R.id.imgGambar);
        TextView txtNama = listViewItem.findViewById(R.id.txtNama);
        TextView txtEmail = listViewItem.findViewById(R.id.txtEmail);
        TextView txtAlamat = listViewItem.findViewById(R.id.txtAlamat);

        imgGambar.setImageResource(getItem(position).getImage());
        txtNama.setText(getItem(position).getNama());
        txtEmail.setText(getItem(position).getEmail());
        txtAlamat.setText(getItem(position).getAlamat());

        return listViewItem;
    }
}
