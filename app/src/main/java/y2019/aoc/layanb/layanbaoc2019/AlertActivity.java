package y2019.aoc.layanb.layanbaoc2019;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AlertActivity extends AppCompatActivity {

    private Button buttonPpic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert);

        buttonPpic = findViewById(R.id.buttonNext);
        buttonPpic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder Builder = new AlertDialog.Builder(AlertActivity.this);
                Builder.setMessage("You can click on the icon to choose a profile picture").setCancelable(false)
                        .setNegativeButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog Alert = Builder.create();
                Alert.show();

            }
        });
    }

}
