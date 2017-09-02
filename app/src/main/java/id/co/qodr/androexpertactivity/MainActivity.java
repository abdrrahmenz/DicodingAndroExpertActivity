package id.co.qodr.androexpertactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

// TODO Menambahkan Kode Logika Sederhana pada MainActivity
// TODO Menambahkan implement View.OnClickListener setelah appCompatActivity untuk action Button
public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    // TODO apabila terjadi perubahan orientasi hasil nilai akan hilang tambahkan kode berikut
    private static final String STATE_HASIL = "state_hasil";

    // TODO Menambahkan Deklarasi View pada layout xml kita
    private EditText edtWidth, edtHeight, edtLength;
    private Button btnCalculate;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO Menambahkan Inisialisasi View pada deklarasi layout xml diatas
        edtWidth = (EditText) findViewById(R.id.edt_widt);
        edtHeight = (EditText) findViewById(R.id.edt_height);
        edtLength = (EditText) findViewById(R.id.edt_length);
        btnCalculate = (Button) findViewById(R.id.btn_calculate);
        tvResult = (TextView) findViewById(R.id.tv_result);
        btnCalculate.setOnClickListener(this);

        // TODO menambahkan logika ketika nilai bundle yg sudah disimpan mau ditampilkan lagi
        if (savedInstanceState != null) {
            String hasil = savedInstanceState.getString(STATE_HASIL);
            tvResult.setText(hasil);
        }
    }

    // TODO tambahlan method onsaveinstancestate untuk menyimpan hasil perhitungan dlm bundle
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(STATE_HASIL, tvResult.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onClick(View view) {
        // TODO Menambahkan Logika action Button ketika diklik
        if (view.getId() == R.id.btn_calculate) {
            // TODO Mendapatkan value(nilai) dari editText dan dikonversi menjadi String
            String length = edtLength.getText().toString().trim();
            String width = edtWidth.getText().toString().trim();
            String height = edtHeight.getText().toString().trim();
            boolean isEmptyField = false;

            // TODO Menambahkan Validasi editText agar tidak boleh Kosong
            if (TextUtils.isEmpty(length)){
                isEmptyField = true;
                edtLength.setError("Field ini tidak boleh kosong");
            }
            if (TextUtils.isEmpty(width)) {
                isEmptyField = true;
                edtWidth.setError("Field ini tidak boleh kosong");
            }
            if (TextUtils.isEmpty(height)){
                isEmptyField = true;
                edtHeight.setError("Field ini tidak boleh kosong");
            }
            // TODO Bila editText tidak kosong menghasilkan nilai volume dg memasukan rumus volume
            if (!isEmptyField){
                double l = Double.parseDouble(length);
                double w = Double.parseDouble(width);
                double h = Double.parseDouble(height);
                double volume = l * w * h;
                tvResult.setText(String.valueOf(volume));
            }
        }

    }
}
