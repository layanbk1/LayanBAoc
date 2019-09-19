package y2019.aoc.layanb.layanbaoc2019;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FirstPageActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonToGoLogIn, buttonGoToSignUp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);

        buttonToGoLogIn = findViewById(R.id.GoToLogIn);
        buttonToGoLogIn.setOnClickListener(this);

        buttonGoToSignUp = findViewById(R.id.GoToSignUp);
        buttonGoToSignUp.setOnClickListener(this);


    }
}
