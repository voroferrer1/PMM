package com.example.vorper.fragmentodinamico;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    int mStackPosition =1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button button =(Button)findViewById(R.id.newFragment);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                addFragment();
            }
        });

        if(savedInstanceState == null){
            Fragment newFragment = SimpleFragment.newInstance(mStackPosition);
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.fragmentShow, newFragment).commit();
        }else{
            mStackPosition=savedInstanceState.getInt("position");
        }
    }
    void addFragment(){
        mStackPosition++;

        Fragment newFragment = SimpleFragment.newInstance(mStackPosition);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragmentShow, newFragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);

        ft.addToBackStack(null);
        ft.commit();
    }


    public void onSaveInstance(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("position",mStackPosition);
    }
}
