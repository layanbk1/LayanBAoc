package y2019.aoc.layanb.layanbaoc2019;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "FIREBASE";
    EditText editTextName,editTextLastName ,editTextEmailTwo ,editTextPasswordTwo ,editTextConfirmPassword;
    Button buttonNext;
    ImageButton imageButton3;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mAuth = FirebaseAuth.getInstance();

        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Tip ;)")
                .setMessage("you can click on the profile icon and choose your own image")
                .setNegativeButton("OK",null)
                .show();
        dialog.show();

        editTextName = findViewById(R.id.editTextName);
        editTextLastName = findViewById(R.id.editTextLastName);
        editTextEmailTwo = findViewById(R.id.editTextEmailTwo);
        editTextPasswordTwo = findViewById(R.id.editTextPasswordTwo);
        editTextConfirmPassword = findViewById(R.id.editTextConfirmPassword);

        buttonNext = findViewById(R.id.buttonNext);
        buttonNext.setOnClickListener(this);

        imageButton3 = findViewById(R.id.imageButton3);
        imageButton3.setOnClickListener(this);
    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
       // updateUI(currentUser);
    }
    public void createAccount(String email, String password){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Intent i = new Intent(SignUpActivity.this, WhenSignUpActivity.class);
                            i.putExtra("name", editTextName.getText().toString());
                            i.putExtra("last name", editTextLastName.getText().toString());
                            startActivity(i);

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(SignUpActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }
                    }
                });
    }
    @Override
    public void onClick(View v) {
        if(v == buttonNext)
        {

            if(editTextPasswordTwo.getText().toString().equals("")|| editTextEmailTwo.getText().toString().equals(""))
            {
                Toast.makeText(this, "empty password or email", Toast.LENGTH_LONG).show();
            }

            else {
                if (!editTextPasswordTwo.getText().toString().equals(editTextConfirmPassword.getText().toString())) {
                    Toast.makeText(this, "password is wrong reconfirm password", Toast.LENGTH_LONG).show();

                } else {
                   createAccount(editTextEmailTwo.getText().toString(), editTextPasswordTwo.getText().toString());

                }
            }
        }

     if (v == imageButton3) {
        Intent i = new Intent(this, CameraActivity.class);
        startActivity(i);
    }

}
}