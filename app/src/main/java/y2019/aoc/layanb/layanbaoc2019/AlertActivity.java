package y2019.aoc.layanb.layanbaoc2019;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class AlertActivity extends AppCompatActivity {

    private Button buttonPpic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert);

        buttonPpic = (button)findViewById(R.id.buttonPpic);
        EvantHandler();
    }
}
