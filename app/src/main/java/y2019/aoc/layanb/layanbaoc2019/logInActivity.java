package y2019.aoc.layanb.layanbaoc2019;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
            if(editTextPassword.getText().toString().equals(""))
            {
                Toast.makeText(this, "empty password or email", Toast.LENGTH_LONG).show();
            }

            else
                {
                Intent i = new Intent(this, MainActivity.class);
                i.putExtra("email",editTextEmail.getText().toString());
                i.putExtra("password",editTextPassword.getText().toString());
                startActivity(i);
                }

        }
    }
}
