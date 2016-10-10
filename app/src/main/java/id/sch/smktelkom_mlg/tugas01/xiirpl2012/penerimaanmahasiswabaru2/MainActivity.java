package id.sch.smktelkom_mlg.tugas01.xiirpl2012.penerimaanmahasiswabaru2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText nama, telp;
    TextView hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nama = (EditText) findViewById(R.id.editTextNama);
        telp = (EditText) findViewById(R.id.editTextNoTelp);
        hasil = (TextView) findViewById(R.id.textViewHasil);
        findViewById(R.id.buttonSAVE).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doClick();
            }
        });
    }

    private void doClick() {
        if (isValid()) {
            String nm = nama.getText().toString();
            int nmr = Integer.parseInt(telp.getText().toString());
            hasil.setText("Nama : " + nm + "\n" + "Nomer Telp : " + nmr + "\n");
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

