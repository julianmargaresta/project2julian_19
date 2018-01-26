package id.sch.smktelkommlg.learn.project2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    EditText etNama;
    EditText etTahun;
    Button ok;
    TextView Hasil;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        etNama = findViewById(R.id.editTextNama);
        etTahun = findViewById(R.id.editTextTahun);
        ok = findViewById(R.id.buttonOK);
        Hasil = findViewById(R.id.textViewHasil);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doProcces();
            }
        });
    }

    private void doProcces() {
        if (isValid()) {
            String nama = etNama.getText().toString();
            int tahun = Integer.parseInt(etTahun.getText().toString());
            int usia = 2016 - tahun;
            Hasil.setText(nama + "berusia" + usia + "tahun");
        }
    }

    private boolean isValid() {
        boolean valid = true;

        String nama = etNama.getText().toString();
        String tahun = etTahun.getText().toString();

        if (nama.isEmpty()) {
            etNama.setError("Nama Belum Diisi");
            valid = false;
        } else if (nama.length() < 3) {
            etNama.setError("Nama Harus Lebih Dari 3 Karakter");
            valid = false;
        } else {
            etNama.setError(null);
        }
        if (tahun.isEmpty()) {
            etTahun.setError("Tahun Belum Diisi");
            valid = false;
        } else if (tahun.length() != 4) {
            etTahun.setError("Format Tahun Bukan yyyy");
            valid = false;
        } else {
            etTahun.setError(null);
        }
        return valid;
    }
}
