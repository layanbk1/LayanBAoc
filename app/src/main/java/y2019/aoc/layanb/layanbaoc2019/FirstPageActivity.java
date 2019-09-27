package y2019.aoc.layanb.layanbaoc2019;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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

    @Override
    public void onClick(View v) {
        if (v == buttonToGoLogIn) {
            Intent i = new Intent(this, LogInActivity.class);
            startActivity(i);

        } else if (v == buttonGoToSignUp) {
            Intent i = new Intent(this, SignUpActivity.class);
            startActivity(i);
        }

    }




}
