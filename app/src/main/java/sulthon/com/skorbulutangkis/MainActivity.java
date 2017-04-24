package sulthon.com.skorbulutangkis;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button buttonLogin;
    EditText text_username, text_password;
    String username, password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonLogin = (Button) findViewById(R.id.buttonLogin);
        text_username = (EditText) findViewById(R.id.et_username);
        text_password = (EditText) findViewById(R.id.et_password);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = text_username.getText().toString();
                password = text_password.getText().toString();

                if (username.contains("wasit") | password.contains("admin")) {
                    Toast.makeText(getApplicationContext(), "login berhasil", Toast.LENGTH_LONG).show();
                    Intent pindah1 = new Intent(MainActivity.this, Main2Activity.class);
                    startActivity(pindah1);
                } else if (username.matches("") | password.matches("")) {
                    Toast.makeText(getApplicationContext(), "Silakan masukan nama pengguna dan sandi", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "nama pengguna dan sandi salah", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
