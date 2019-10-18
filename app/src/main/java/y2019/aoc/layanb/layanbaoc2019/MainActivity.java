package y2019.aoc.layanb.layanbaoc2019;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TabHost;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton imageWalButton;
    TextView textViewWalName;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageWalButton = findViewById(R.id.imageWalButton);
        imageWalButton.setOnClickListener(this);

        TabHost tabHost = (TabHost) findViewById(R.id.tabHost);
        tabHost.setup();

        TabHost.TabSpec spec = tabHost.newTabSpec("transactions");
        spec.setContent(R.id.tabTran);
        spec.setIndicator("transactions");
        tabHost.addTab(spec);


       spec = tabHost.newTabSpec("overview");
        spec.setContent(R.id.tabOverview);
        spec.setIndicator("overview");
        tabHost.addTab(spec);

        spec = tabHost.newTabSpec("+");
        spec.setContent(R.id.tabPlus);
        spec.setIndicator("+");
        tabHost.addTab(spec);

        spec = tabHost.newTabSpec("plannings");
        spec.setContent(R.id.tabPlannings);
        spec.setIndicator("plannings");
        tabHost.addTab(spec);

        spec = tabHost.newTabSpec("settings");
        spec.setContent(R.id.tabSettings);
        spec.setIndicator("settings");
        tabHost.addTab(spec);



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

    public void onClick(View v) {

        if (v == imageWalButton) {
            Intent i = new Intent(this, OverviewActivity.class);
            i.putExtra("name", textViewWalName.getText().toString());
            startActivity(i);
        }

    }
}
