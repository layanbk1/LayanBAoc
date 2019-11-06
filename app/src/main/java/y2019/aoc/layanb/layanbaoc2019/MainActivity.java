package y2019.aoc.layanb.layanbaoc2019;

import android.content.Intent;
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
    TextView textViewWalName;

    @Override
    protected void onCreate(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

imageWalButton =findViewById(R.id.imageWalButton);
imageWalButton.setOnClickListener(this);

        View view = inflater.inflate(R.layout.fragment_rssitem_detail,
                container, false);
        ImageButton imageButton = (ImageButton) view.findViewById(R.id.imageAddWal);
        ImageButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // do something
            }
        });
        return view;

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
//            i.putExtra("name", textViewWalName.getText().toString());
            startActivity(i);
        }
        if (v == imageAddWal) {
            Intent i = new Intent(this, WhenSignUpActivity.class);
            startActivity(i);}

    }
}
