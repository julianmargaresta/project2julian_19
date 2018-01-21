package id.sch.smktelkommlg.learn.project2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

import id.sch.smktelkommlg.learn.project2.adapter.KotaAdapter;

public class Main5Activity extends AppCompatActivity {
    Spinner spProvinsi, spKota;
    TextView tvHasil;
    String[][] arkota = {{"Jakarta Barat", "Jakarta Pusat", "Jakarta Selatan", "Jakarta Timur", "Jakarta Utara"},
            {"Bandung", "Bekasi", "Cirebon"}, {"Semarang", "Magelang", "Surakarta"},
            {"Surabaya", "Malang", "Blitar"}, {"Denpasar"}};
    ArrayList<String> listkota = new ArrayList<>();
    KotaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        spProvinsi = findViewById(R.id.spinnerProvinsi);
        tvHasil = findViewById(R.id.TextViewHasil);
        spKota = findViewById(R.id.spinnerKota);
        adapter = new KotaAdapter(this, listkota);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spKota.setAdapter(adapter);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doClick();
            }
        });

        spProvinsi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {
                listkota.clear();
                listkota.addAll(Arrays.asList(arkota[pos]));
                adapter.setProvinsi((String) spProvinsi.getItemAtPosition(pos));
                adapter.notifyDataSetChanged();
                spKota.setSelection(0);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void doClick() {
        StringBuilder builder = new StringBuilder();
        builder.append("wilayah Provinsi ");
        builder.append(spProvinsi.getSelectedItem().toString());
        builder.append(" Kota ");
        builder.append(spKota.getSelectedItem().toString());
        builder.append("\n\n\n");

        builder.append("Kota yang tidak dipilih adalah : \n\n");

        String[] arProvinsi = getResources().getStringArray(R.array.Provinsi);
        int posProv = spProvinsi.getSelectedItemPosition();
        int posKota = spKota.getSelectedItemPosition();

        for (int i = 0; i < arProvinsi.length; i++) {
            builder.append(arProvinsi[i]).append(":\n");
            for (int j = 0; j < arkota[i].length; j++) {
                if (!(i == posProv && j == posKota)) {
                    builder.append("\t").append(arkota[i][j]).append("\n");
                }
            }
        }
        tvHasil.setText(builder);
    }
}
