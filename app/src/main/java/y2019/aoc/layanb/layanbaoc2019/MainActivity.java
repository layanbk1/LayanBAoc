package y2019.aoc.layanb.layanbaoc2019;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TabHost;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton imageWalButton,imageAddWal;
    private  AddWalFragment AddWalFrag;
    TextView walNameTextView;

  // public static FragmentManager fragmentmanager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageAddWal = findViewById(R.id.imageAddWal);
        imageAddWal.setOnClickListener(this);

        AddWalFrag = new AddWalFragment();

        imageWalButton = findViewById(R.id.imageWalButton);
        imageWalButton.setOnClickListener(this);


        walNameTextView = (TextView)findViewById(R.id.walNameTextView);
        Intent iin= getIntent();
        Bundle b = iin.getExtras();

        if(b!=null)
        {
            String j =(String) b.get("name");
            walNameTextView.setText(j);
        }
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.app_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.about_us:
                Intent i = new Intent(this, AboutUsActivity.class);
                startActivity(i);
                break;
            case R.id.settings:
                Intent j = new Intent(this, Settings.class);
                startActivity(j);
                break;

        }
        return super.onOptionsItemSelected(item);

    }

    @Override
     public void onClick(View v) {

      if (v == imageAddWal) {
          setFragment(AddWalFrag);
      }

        if (v == imageWalButton) {
            Intent i = new Intent(this, OverviewActivity.class);
           startActivity(i);
        }

    }

    private void setFragment(Fragment fragment) {

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.wal_fra,fragment);
        fragmentTransaction.commit();
    }
}
