package id.sch.smktelkommlg.learn.project2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {
    RadioGroup rgStatus;
    RadioButton rbBM, rbM, rbD, rbJ;
    TextView Hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        /*rbBM = (RadioButton)findViewById(R.id.R1);
        rbM = (RadioButton) findViewById(R.id.R2);
        rbD = (RadioButton) findViewById(R.id.R3);
        rbJ = (RadioButton) findViewById(R.id.R4);*/
        rgStatus = findViewById(R.id.radioGroupStatus);

        Hasil = findViewById(R.id.tvHasil);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doClick();
            }

            private void doClick() {
                String hasil = null;
                if (rgStatus.getCheckedRadioButtonId() != -1) {
                    RadioButton rb = findViewById(rgStatus.getCheckedRadioButtonId());
                    hasil = rb.getText().toString();
                    if (rgStatus.getCheckedRadioButtonId() != R.id.R1) {
                        EditText etJA = findViewById(R.id.editTextJA);
                        hasil += "\nJumlah Anak : " + etJA.getText();
                    }
                }
                /*if(rbBM.isChecked())
                {
                    hasil = rbBM.getText().toString();
                }
                else if(rbM.isChecked())
                {
                    hasil = rbM.getText().toString();
                }
                else if(rbD.isChecked())
                {
                    hasil = rbD.getText().toString();
                }
                else if(rbJ.isChecked())
                {
                    hasil = rbJ.getText().toString();
                }*/

                if (hasil == null) {
                    Hasil.setText("Belum Memilih Status");
                } else {
                    Hasil.setText("Status Anda : " + hasil);
                }
            }
        });

        rgStatus.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.R1) {
                    findViewById(R.id.tilJA).setVisibility(View.GONE);
                } else {
                    findViewById(R.id.tilJA).setVisibility(View.VISIBLE);
                }
            }
        });
    }

}
