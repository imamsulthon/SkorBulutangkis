package sulthon.com.skorbulutangkis;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    String var_pemainA1, var_pemainA2, var_pemainB1, var_pemainB2;
    EditText pemainA1, pemainA2, pemainB1, pemainB2;
    Button lanjut, bersihkan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        pemainA1 = (EditText) findViewById(R.id.et_PemainA1);
        pemainA2 = (EditText) findViewById(R.id.et_PemainA2);
        pemainB1 = (EditText) findViewById(R.id.et_PemainB1);
        pemainB2 = (EditText) findViewById(R.id.et_PemainB2);

        lanjut = (Button) findViewById(R.id.bt_lanjut);
        bersihkan = (Button) findViewById(R.id.bt_bersihkan);

        lanjut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                var_pemainA1 = pemainA1.getText().toString();
                var_pemainA2 = pemainA2.getText().toString();
                var_pemainB1 = pemainB1.getText().toString();
                var_pemainB2 = pemainB2.getText().toString();

                Intent i2Activity = new Intent(Main2Activity.this, Main3Activity.class);

                Bundle b = new Bundle();
                b.putString("parse_A1", var_pemainA1);
                b.putString("parse_A2", var_pemainA2);
                b.putString("parse_B1", var_pemainB1);
                b.putString("parse_B2", var_pemainB2);

                i2Activity.putExtras(b);
                startActivity(i2Activity);
            }
        });

        bersihkan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pemainA1.setText("");
                pemainA2.setText("");
                pemainB1.setText("");
                pemainB2.setText("");
            }
        });
    }

    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Apa anda yakin ingin keluar?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Main2Activity.this.finish();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }
}
