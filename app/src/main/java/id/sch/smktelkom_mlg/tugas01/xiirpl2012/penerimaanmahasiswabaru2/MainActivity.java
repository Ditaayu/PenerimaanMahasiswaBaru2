package id.sch.smktelkom_mlg.tugas01.xiirpl2012.penerimaanmahasiswabaru2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText nama, telp;
    TextView hasil;
    RadioGroup jk;
    CheckBox SI, TP, KB;
    Spinner sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nama = (EditText) findViewById(R.id.editTextNama);
        telp = (EditText) findViewById(R.id.editTextNoTelp);
        hasil = (TextView) findViewById(R.id.textViewHasil);
        jk = (RadioGroup) findViewById(R.id.RadioGroupJK);
        sp = (Spinner) findViewById(R.id.spinnerAsalProvinsi);
        SI = (CheckBox) findViewById(R.id.checkBoxSI);
        TP = (CheckBox) findViewById(R.id.checkBoxTP);
        KB = (CheckBox) findViewById(R.id.checkBoxKB);
        findViewById(R.id.buttonSAVE).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doClick();
            }
        });
    }

    private void doClick() {
        if (isValid()) {
            String hsl = null;
            String hl = "Jurusan Anda:\n";
            int startlen = hl.length();
            if (SI.isChecked()) hl += SI.getText() + "\n";
            if (TP.isChecked()) hl += TP.getText() + "\n";
            if (KB.isChecked()) hl += KB.getText() + "\n";

            if (hl.length() == startlen) hl += "Tidak Ada Pilihan";

            if (jk.getCheckedRadioButtonId() != -1) {
                RadioButton rb = (RadioButton)
                        findViewById(jk.getCheckedRadioButtonId());
                hsl = rb.getText().toString();
            }
            if (hsl == null) {
                hasil.setText("Belum memilih jenis kelamin");
            } else {
                String nm = nama.getText().toString();
                int nmr = Integer.parseInt(telp.getText().toString());
                StringBuilder builder = new StringBuilder();
                builder.append("Nama : " + nm + "\n");
                builder.append("Nomor Telp : " + nmr + "\n");
                builder.append("Jenis Kelamin anda :" + hsl + "\n");
                builder.append(hl + "\n");
                builder.append("Wilayah Provinsi : " + sp.getSelectedItem().toString());
                hasil.setText(builder);
            }
        }

    }

    private boolean isValid() {

        boolean valid = true;

        String nm = nama.getText().toString();
        String nmr = telp.getText().toString();

        if (nm.isEmpty()) {
            nama.setError("Nama Belum Diisi");
            valid = false;
        } else if (nm.length() < 3) {
            nama.setError("Nama minimal 3 karakter");
            valid = false;
        } else {
            nama.setError(null);
        }
        if (nmr.isEmpty()) {
            telp.setError("Nomor Belum Diisi");
            valid = false;
        }
        return valid;

    }
}

