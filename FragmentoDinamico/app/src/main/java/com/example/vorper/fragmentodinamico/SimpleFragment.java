package com.example.vorper.fragmentodinamico;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SimpleFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SimpleFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SimpleFragment extends Fragment {
    int mNum;

    public static SimpleFragment newInstance(int number) {
        SimpleFragment f= new SimpleFragment();
        Bundle args = new Bundle();
        args.putInt("num",number);
        f.setArguments(args);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mNum = getArguments().getInt("num");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = null;
        View tv;
        if(mNum % 2 == 0){
            v= inflater.inflate(R.layout.fragment_simple,null);
            tv = v.findViewById(R.id.text);
        }else{
            v = inflater.inflate(R.layout.fragment_simple2,null);
            tv = v.findViewById(R.id.text2);
        }
        ((TextView)tv).setText("Fragmento numero #"+mNum);
        return v;
    }


}
