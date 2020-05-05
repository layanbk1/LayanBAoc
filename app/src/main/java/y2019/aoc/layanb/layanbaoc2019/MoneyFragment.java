package y2019.aoc.layanb.layanbaoc2019;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


/**
 * A simple {@link Fragment} subclass.
 */
public class MoneyFragment extends Fragment /* implements View.OnClickListener */ {

    private  MoneyFragment moneyFrag;
    private OverviewFragment overFrag;

    EditText money;
    Button doneInc;
    Button doneOut;
    double num;
    TextView textView9;

    private FirebaseAuth mAuth;
    DatabaseReference IncomePath;
    DatabaseReference OutcomePath;

  //  Wallet w;


    public MoneyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_money, container, false);

        mAuth = FirebaseAuth.getInstance(); //יוצרים אוביקט של DB
        FirebaseUser user = mAuth.getCurrentUser();
        FirebaseDatabase database = FirebaseDatabase.getInstance();

        IncomePath = database.getReference(user.getUid()+"/income");
        OutcomePath = database.getReference(user.getUid()+"/Outcome");

        moneyFrag = new MoneyFragment();
        overFrag = new OverviewFragment();


        money = v.findViewById(R.id.editTextMoney);
       // num = Double.parseDouble(money.getText().toString());
        doneInc = (Button) v.findViewById(R.id.doneInc);
        doneInc.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View view) {

                setFragment(overFrag);
                IncomePath.push().setValue(money.getText().toString());


            }
        });

        doneOut = (Button) v.findViewById(R.id.doneOut);
        doneOut.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View view) {

                setFragment(overFrag);
                OutcomePath.push().setValue(money.getText().toString());


            }
        });



        /*
        IncomePath.addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                w = dataSnapshot.getValue(Wallet.class);


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


        // Inflate the layout for this fragment
        return v;
    }

    private void setFragment(Fragment fragment) {

        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_fra,fragment);
        fragmentTransaction.commit();
    }



   /*@Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.doneInc:
               // w.addIncome(num);
                // IncomePath.removeValue();
                IncomePath.push().setValue(money.getText().toString());
            break;

            case R.id.doneOut:
                OutcomePath.push().setValue(money.getText().toString());
                break;
        }
    } */
}
