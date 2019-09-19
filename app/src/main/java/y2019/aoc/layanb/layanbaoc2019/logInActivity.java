package y2019.aoc.layanb.layanbaoc2019;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class logInActivity extends AppCompatActivity implements View.OnClickListener {

    //1.properties defenition
    EditText editTextEmail, editTextPassword;
    Button buttonLogIn ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        //2.initialize properties
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);

        buttonLogIn = findViewById(R.id.buttonLogIn);
        buttonLogIn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v == buttonLogIn)
        {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }
    }
}
