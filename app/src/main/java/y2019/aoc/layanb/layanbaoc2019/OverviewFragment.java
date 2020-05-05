package y2019.aoc.layanb.layanbaoc2019;


import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


/**
 * A simple {@link Fragment} subclass.
 */
public class OverviewFragment extends Fragment implements View.OnClickListener {

    TextView textViewBalance;
    TextView textView7;
    TextView textView8;
    TextView textView10;
    String balance;
    Button refresh;

    DatabaseReference IncomePath;
    DatabaseReference OutcomePath;
    DatabaseReference BalancePath;

    double sumIncome;
    double sumOutcome;

    private FirebaseAuth mAuth;

    TextView incomeText;


    public OverviewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_overview, container, false);

        incomeText = v.findViewById(R.id.textView8);

        mAuth = FirebaseAuth.getInstance(); //יוצרים אוביקט של DB
        FirebaseUser user = mAuth.getCurrentUser();
        FirebaseDatabase database = FirebaseDatabase.getInstance();

        IncomePath = database.getReference(user.getUid()+"/income");
        OutcomePath = database.getReference(user.getUid()+"/outcome");
        BalancePath = database.getReference(user.getUid()+"/balance");

        refresh = (Button) v.findViewById(R.id.refresh);
        refresh.setOnClickListener(this);


        textView7 = v.findViewById(R.id.textView7);




      /*  IncomePath.addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

              Wallet w = dataSnapshot.getValue(Wallet.class);
                double num = w.getIncome();
                sumIncome += num;


            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
*/

        return v;
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.refresh:

              //  incomeText.setText(sumIncome+"") ;
                break;
        }
    }


}
