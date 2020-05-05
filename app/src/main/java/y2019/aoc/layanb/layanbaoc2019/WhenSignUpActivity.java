package y2019.aoc.layanb.layanbaoc2019;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Currency;
import java.util.List;

public class WhenSignUpActivity extends AppCompatActivity implements View.OnClickListener{

    Button createWal;
    EditText editTextWalName;
    EditText editTextCurrent;
    String first;
    String name;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_when_sign_up);

        editTextWalName = findViewById(R.id.editTextWalName);
        editTextCurrent = findViewById(R.id.editTextCurrent);

        name = editTextWalName.getText().toString() ;
        first = editTextCurrent.getText().toString();

        Wallet wallet = new Wallet();
        wallet.setName(name);
        wallet.setSpend(first);

        createWal = findViewById(R.id.buttonCreateWal);
        createWal.setOnClickListener(this);

        Spinner s = (Spinner) findViewById(R.id.spinner1);
        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(WhenSignUpActivity.this, parent.getSelectedItem().toString(), Toast.LENGTH_SHORT);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

            });


    }


    @Override
    public void onClick(View v) {
            if(v == createWal)
        {
            Intent i = new Intent(this, MainActivity.class);
            String s=editTextWalName.getText().toString();
            i.putExtra("name", s);
            startActivity(i);
        }
    }
}
