package sulthon.com.skorbulutangkis;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class Main3Activity extends AppCompatActivity {

    TextView tv_TimA1, tv_TimA2, tv_TimB1, tv_TimB2;
    TextView scoreViewA, scoreViewB;
    String nama_TimA1,nama_TimA2, nama_TimB1, nama_TimB2;
    Button timA_getOnePoin, timA_minOnePoin, timB_getOnePoin, timB_minOnePoin;
    ImageView cursorServiceA, cursorServiceB;

    int scoreTimA = 0;
    int scoreTimB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        tv_TimA1 = (TextView) findViewById(R.id.tv_timA1);
        tv_TimA2 = (TextView) findViewById(R.id.tv_timA2);
        tv_TimB1 = (TextView) findViewById(R.id.tv_timB1);
        tv_TimB2 = (TextView) findViewById(R.id.tv_timB2);

        Bundle b = getIntent().getExtras();

        nama_TimA1 = b.getString("parse_A1");
        nama_TimA2 = b.getString("parse_A2");
        nama_TimB1 = b.getString("parse_B1");
        nama_TimB2 = b.getString("parse_B2");

        tv_TimA1.setText(nama_TimA1);
        tv_TimA2.setText(nama_TimA2);
        tv_TimB1.setText(nama_TimB1);
        tv_TimB2.setText(nama_TimB2);

        timA_getOnePoin = (Button) findViewById(R.id.bt_Poin1);
        timA_minOnePoin = (Button) findViewById(R.id.bt_Poin2);
        timB_getOnePoin = (Button) findViewById(R.id.bt_Poin3);
        timB_minOnePoin = (Button) findViewById(R.id.bt_Poin4);

        scoreViewA = (TextView) findViewById(R.id.tv_scoreViewA);
        scoreViewB = (TextView) findViewById(R.id.tv_scoreViewB);

        cursorServiceA = (ImageView) findViewById(R.id.iv_serveA);
        cursorServiceB = (ImageView) findViewById(R.id.iv_serveB);

        timA_getOnePoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (scoreTimA <= 20) {
                    scoreTimA = scoreTimA + 1;
                    scoreViewA.setText(String.valueOf(scoreTimA));
                    cursorServiceA.setVisibility(View.VISIBLE);
                    cursorServiceB.setVisibility(View.INVISIBLE);
                } else {
                    int difference = scoreTimA - scoreTimB;
                    if (scoreTimB <= 20) {
                        scoreTimA = scoreTimA + 1;
                        scoreViewA.setText(String.valueOf(scoreTimA));
                        cursorServiceA.setVisibility(View.VISIBLE);
                        cursorServiceB.setVisibility(View.INVISIBLE);
                    } else {
                        scoreViewA.setText(String.valueOf(scoreTimA));
                    }
                }
            }
        });

        timA_minOnePoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (scoreTimA >= 1) {
                    scoreTimA = scoreTimA - 1;
                    scoreViewA.setText(String.valueOf(scoreTimA));
                } else {
                    scoreViewB.setText(String.valueOf(scoreTimB));
                }
                timA_getOnePoin.setEnabled(true);
            }
        });

        timB_getOnePoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (scoreTimB <= 20) {
                    scoreTimB = scoreTimB + 1;
                    scoreViewB.setText(String.valueOf(scoreTimB));
                    cursorServiceB.setVisibility(View.VISIBLE);
                    cursorServiceA.setVisibility(View.INVISIBLE);
                } else {
                    int difference = scoreTimB - scoreTimA;
                    if (difference <= 1) {
                        scoreTimB = scoreTimB + 1;
                        scoreViewB.setText(String.valueOf(scoreTimB));
                        cursorServiceB.setVisibility(View.VISIBLE);
                        cursorServiceA.setVisibility(View.INVISIBLE);
                    } else {
                        scoreViewB.setText(String.valueOf(scoreTimB));
                    }
                }
            }
        });

        timB_minOnePoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (scoreTimB >= 1) {
                    scoreTimB = scoreTimB - 1;
                    scoreViewB.setText(String.valueOf(scoreTimB));
                } else {
                    scoreViewB.setText(String.valueOf(scoreTimB));
                }
                timB_getOnePoin.setEnabled(true);
            }
        });
    }

    public void resetpoint (View v) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setCancelable(true);
        builder.setTitle("Hapus Poin?");
        builder.setMessage("Apakah Anda yakin ingin menghapus semua poin?");
        builder.setPositiveButton("Ya",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        scoreTimA = 0;
                        scoreTimB = 0;
                        scoreViewA.setText(String.valueOf(scoreTimA));
                        scoreViewB.setText(String.valueOf(scoreTimA));
                        cursorServiceA.setVisibility(View.INVISIBLE);
                        cursorServiceB.setVisibility(View.INVISIBLE);
                    }
                }
        );
        builder.setNegativeButton("Tidak",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                }
        );
        builder.show();
    }
}
