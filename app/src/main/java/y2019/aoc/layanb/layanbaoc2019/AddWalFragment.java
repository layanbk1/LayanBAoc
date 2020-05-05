package y2019.aoc.layanb.layanbaoc2019;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
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


public class AddWalFragment extends Fragment {

    private FirebaseAuth mAuth;
    DatabaseReference IncomePath;
    DatabaseReference OutcomePath;
    DatabaseReference BalancePath;

    EditText editTextWalName2;
    EditText editTextWalName;
    EditText editTextBal;
    Button buttonCancel;
    Button buttonADD;
    TextView walNameTextView;


    // private OnFragmentInteractionListener mListener;

    public AddWalFragment() {
    }


    /*@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAuth = FirebaseAuth.getInstance(); //יוצרים אוביקט של DB
        FirebaseUser user = mAuth.getCurrentUser();
        FirebaseDatabase database = FirebaseDatabase.getInstance();

        IncomePath = database.getReference(user.getUid() + "/income");
        OutcomePath = database.getReference(user.getUid() + "/Outcome");


    }*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mAuth = FirebaseAuth.getInstance(); //יוצרים אוביקט של DB
        FirebaseUser user = mAuth.getCurrentUser();
        FirebaseDatabase database = FirebaseDatabase.getInstance();

        IncomePath = database.getReference(user.getUid() + "/income");
        OutcomePath = database.getReference(user.getUid() + "/Outcome");
        BalancePath = database.getReference(user.getUid()+"/balance");

        View v = inflater.inflate(R.layout.fragment_add_wal, container, false);

        AlertDialog dialog = new AlertDialog.Builder(getActivity())
                .setTitle("IMPORTANT")
                .setMessage("If you want to make anew wallet the old one will be deleted")
                .setNegativeButton("I understand", null)
                .show();
        dialog.show();

        walNameTextView = (TextView) v.findViewById(R.id.walNameTextView);


        editTextWalName2 = v.findViewById(R.id.editTextWalName2);

        editTextBal = v.findViewById(R.id.editTextBal);

        buttonADD = (Button) v.findViewById(R.id.buttonADD);
        buttonADD.setOnClickListener(new View.OnClickListener()  {
                                            @Override
                                            public void onClick(View view) {

                                                Intent i = new Intent(getActivity(), MainActivity.class);
                                                String s=editTextWalName2.getText().toString();
                                                i.putExtra("name", s);

                                                    OutcomePath.removeValue();
                                                    IncomePath.removeValue();
                                                    BalancePath.removeValue();
                                                    BalancePath.push().setValue(editTextBal.getText().toString());

                                                    startActivity(i);
                                            }
                                        });

        buttonCancel = (Button) v.findViewById(R.id.buttonCancel);
        buttonCancel.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View view) {
                                             Intent i = new Intent(getActivity(), MainActivity.class);
                                             startActivity(i);
                                         }
                                     });



        // Inflate the layout for this fragment
        return v;
    }


    
   /* // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }*/
    }

