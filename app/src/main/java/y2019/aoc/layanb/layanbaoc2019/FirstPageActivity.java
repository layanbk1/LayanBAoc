package y2019.aoc.layanb.layanbaoc2019;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class FirstPageActivity extends AppCompatActivity  implements View.OnClickListener {

    Button buttonGoToLogIn, buttonGoToSignUp;
    ViewPager dotsViewPager;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);


     //   ViewPager pager = (ViewPager) findViewById(R.id.photos_viewpager);
    //    PagerAdapter adapter = new PhotosAdapter(getChildFragmentManager(), photosUrl);
      //  pager.setAdapter(adapter);

      //  TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
      //  tabLayout.setupWithViewPager(pager, true);

      /*  dotsViewPager = (ViewPager) findViewById(R.id.dots_viewpager);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabDots);
        tabLayout.setupWithViewPager(dotsViewPager, true);*/

        buttonGoToLogIn = findViewById(R.id.GoToLogIn);
        buttonGoToLogIn.setOnClickListener(this);

        buttonGoToSignUp = findViewById(R.id.GoToSignUp);
        buttonGoToSignUp.setOnClickListener(this);

     //   ViewGroup rootView = (ViewGroup) inflater.inflate(
    //    R.layout.fragment_screen_slide_page, container, false);

//   return rootView;

    }

    @Override
    public void onClick(View v) {
        if (v == buttonGoToLogIn) {
            Intent i = new Intent(this, LogInActivity.class);
            startActivity(i);

        } else if (v == buttonGoToSignUp) {
            Intent i = new Intent(this, SignUpActivity.class);
            startActivity(i);
        }

    }




}
