package y2019.aoc.layanb.layanbaoc2019;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editTextName,editTextLastName ,editTextEmailTwo ,editTextPasswordTwo ,editTextConfirmPassword;
    Button buttonNext;
    ImageButton imageButton3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Title")
                .setMessage("example message")
                .setNegativeButton("OK",null)
                .show();

        editTextName = findViewById(R.id.editTextName);
        editTextLastName = findViewById(R.id.editTextLastName);
        editTextEmailTwo = findViewById(R.id.editTextEmailTwo);
        editTextPasswordTwo = findViewById(R.id.editTextPasswordTwo);
        editTextConfirmPassword = findViewById(R.id.editTextConfirmPassword);

        buttonNext = findViewById(R.id.buttonNext);
        buttonNext.setOnClickListener(this);

        imageButton3 = findViewById(R.id.imageButton3);
        imageButton3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == buttonNext)
        {

            if(editTextPasswordTwo.getText().toString().equals("")|| editTextEmailTwo.getText().toString().equals(""))
            {
                Toast.makeText(this, "empty password or email", Toast.LENGTH_LONG).show();
            }

            else {
                if (!editTextPasswordTwo.getText().toString().equals(editTextConfirmPassword.getText().toString())) {
                    Toast.makeText(this, "password is wrong reconfirm password", Toast.LENGTH_LONG).show();

                } else {
                    Intent i = new Intent(this, WhenSignUpActivity.class);
                    i.putExtra("name", editTextName.getText().toString());
                    i.putExtra("last name", editTextLastName.getText().toString());
                    i.putExtra("email", editTextEmailTwo.getText().toString());
                    i.putExtra("password", editTextPasswordTwo.getText().toString());
                    i.putExtra("confirmed password", editTextConfirmPassword.getText().toString());
                    startActivity(i);

                }
            }
        }

     if (v == imageButton3) {
        Intent i = new Intent(this, CameraActivity.class);
        startActivity(i);
    }

}
}