package y2019.aoc.layanb.layanbaoc2019;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.Toast;

public class OverviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview);

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







}
