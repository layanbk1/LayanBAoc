package y2019.aoc.layanb.layanbaoc2019;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvEmail,tvPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String password = getIntent().getStringExtra("password");

        String email = getIntent().getStringExtra("email");

        tvEmail = findViewById(R.id.tvEmail);
        tvPassword = findViewById(R.id.tvPassword);

        tvEmail.setText(email);
        tvPassword.setText(password);



    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.app_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.profile:
                Intent i = new Intent(this, Profile.class);
                startActivity(i);
                break;
            case R.id.settings:
                Intent j = new Intent(this, Settings.class);
                startActivity(j);
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
