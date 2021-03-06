package y2019.aoc.layanb.layanbaoc2019;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TabHost;
import android.widget.Toast;

import java.util.Calendar;

public class OverviewActivity extends AppCompatActivity implements View.OnClickListener{

  //  private OverviewActivity.SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    ImageButton ButtonCalendar,ButtonHome;
    BottomNavigationView bottomNavigationView;



    private  MoneyFragment moneyFrag;
    private  TranFragment tranFrag;
    private  SetFragment setFrag;
    private PlanningsFragment planFrag;
    private OverviewFragment overFrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview);



        moneyFrag = new MoneyFragment();
        tranFrag = new TranFragment();
        setFrag = new SetFragment();
        planFrag = new PlanningsFragment();
        overFrag = new OverviewFragment();

        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        ButtonHome = findViewById(R.id.ButtonHome);
        ButtonHome.setOnClickListener(this);

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
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_overview:
                        setFragment(overFrag);
                        return true;
                    case R.id.action_transaction:
                        setFragment(tranFrag);
                        return true;
                    case R.id.action_plus:
                        setFragment(moneyFrag);
                        return true;
                    case R.id.action_plannings:
                        setFragment(planFrag);
                        return true;
                    case R.id.action_walsettings:
                        setFragment(setFrag);
                        return true;


                    default:
                        return false;
                }
            }
        });
    }

    private void setFragment(Fragment fragment) {

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_fra,fragment);
        fragmentTransaction.commit();
    }

    DatePickerDialog.OnDateSetListener dateSetListener =
            new DatePickerDialog.OnDateSetListener() {
                public void onDateSet(DatePicker view, int year, int month, int day) {
                    Toast.makeText(getApplicationContext(), "selected date is " + view.getYear() +
                            " / " + (view.getMonth()+1) +
                            " / " + view.getDayOfMonth(), Toast.LENGTH_SHORT).show();
                }
            };

    @Override
    public void onClick(View v) {

        if (v == ButtonHome) {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }

}
    }