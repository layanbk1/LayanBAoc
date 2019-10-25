package y2019.aoc.layanb.layanbaoc2019;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.TabHost;
import android.widget.Toast;

import java.util.Calendar;

public class OverviewActivity extends AppCompatActivity {

    ImageButton ButtonCalendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview);

        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        ButtonCalendar = findViewById(R.id.ButtonCalendar);
        ButtonCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("CALANDAR", year+" "+month+" "+day+" ");
                DatePickerDialog datePickerDialog = new DatePickerDialog(OverviewActivity.this, dateSetListener, year, month, day);
                if(datePickerDialog != null)
                    datePickerDialog.show();
            }
        });

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

    private DatePickerDialog.OnDateSetListener dateSetListener =
            new DatePickerDialog.OnDateSetListener() {
                public void onDateSet(DatePicker view, int year, int month, int day) {
                    Toast.makeText(getApplicationContext(), "selected date is " + view.getYear() +
                            " / " + (view.getMonth()+1) +
                            " / " + view.getDayOfMonth(), Toast.LENGTH_SHORT).show();
                }
            };
}
