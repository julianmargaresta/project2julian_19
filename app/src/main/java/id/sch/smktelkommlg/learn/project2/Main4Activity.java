package id.sch.smktelkommlg.learn.project2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class Main4Activity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    CheckBox baca, olahraga, menggambar, menulis, Nonton;
    TextView tvHasil, tvHobi;
    int nHobi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        baca = findViewById(R.id.CB1);
        olahraga = findViewById(R.id.CB2);
        menggambar = findViewById(R.id.CB3);
        menulis = findViewById(R.id.CB4);
        Nonton = findViewById(R.id.CB5);
        tvHobi = findViewById(R.id.TextViewHobi);
        tvHasil = findViewById(R.id.textViewHasil);
        baca.setOnCheckedChangeListener(this);
        olahraga.setOnCheckedChangeListener(this);
        menggambar.setOnCheckedChangeListener(this);
        menulis.setOnCheckedChangeListener(this);
        Nonton.setOnCheckedChangeListener(this);


        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doClick();
            }

            private void doClick() {
                String hasil = "Hobi anda : \n";
                int Startlen = hasil.length();
                if (baca.isChecked()) hasil += baca.getText() + "\n";
                if (olahraga.isChecked()) hasil += olahraga.getText() + "\n";
                if (menggambar.isChecked()) hasil += menggambar.getText() + "\n";
                if (menulis.isChecked()) hasil += menulis.getText() + "\n";
                if (Nonton.isChecked()) hasil += Nonton.getText() + "\n";

                if (hasil.length() == Startlen) hasil += "Tidak ada pilihan";
                tvHasil.setText(hasil);
            }
        });
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        if (isChecked) nHobi += 1;
        else nHobi -= 1;

        tvHobi.setText("Hobi(" + nHobi + "Terpilih)");
    }
}

