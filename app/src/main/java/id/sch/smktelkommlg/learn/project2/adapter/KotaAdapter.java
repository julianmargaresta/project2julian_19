package id.sch.smktelkommlg.learn.project2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import id.sch.smktelkommlg.learn.project2.R;

/**
 * Created by M12RjUL14n on 18/01/2018.
 */

public class KotaAdapter extends ArrayAdapter<String> {
    String mProvinsi = "";


    public KotaAdapter(Context context, ArrayList<String> listkota) {
        super(context, R.layout.row_spinner_kota, listkota);
    }

    public void setProvinsi(String provinsi) {
        this.mProvinsi = provinsi;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        return getCustomView(position, view, parent);
    }

    @Override
    public View getDropDownView(int position, View view, ViewGroup parent) {
        return getCustomView(position, view, parent);
    }

    private View getCustomView(int position, View view, ViewGroup parent) {
        if (view == null)
            view = LayoutInflater.from(getContext())
                    .inflate(R.layout.row_spinner_kota, parent, false);

        TextView tvTitle = view.findViewById(R.id.TextViewTitle);
        tvTitle.setText(getItem(position).substring(0, 1));
        TextView tvKota = view.findViewById(R.id.TextViewKota);
        tvKota.setText(getItem(position));
        TextView tvProvinsi = view.findViewById(R.id.TextViewProvinsi);
        tvProvinsi.setText(mProvinsi);

        return view;
    }
}
