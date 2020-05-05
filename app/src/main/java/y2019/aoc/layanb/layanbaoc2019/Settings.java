package y2019.aoc.layanb.layanbaoc2019;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Settings extends AppCompatActivity implements View.OnClickListener {

    ImageView imageView6;
    TextView textView11;
    TextView textView12;
    TextView textView13;
    Button button5;
    Button button2;


    private static final int CAMERA_REQUEST = 0;
    private static final int GALLERY_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        button5 = findViewById(R.id.button5);
        button5.setOnClickListener(this);

        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(this);

        imageView6 = findViewById(R.id.imageView4);
        textView11 = findViewById(R.id.editTextName);
        textView12 = findViewById(R.id.editTextEmail);
        textView13 = findViewById(R.id.editTextPassword);


    }

    @Override
    public void onClick(View v) {
        if (v == button5) {
            Intent i = new Intent(this, CameraActivity.class);
            startActivity(i);
        }
        if (v == button2) {
            Intent i = new Intent(this, FirstPageActivity.class);
            startActivity(i);
        }
    }
}
