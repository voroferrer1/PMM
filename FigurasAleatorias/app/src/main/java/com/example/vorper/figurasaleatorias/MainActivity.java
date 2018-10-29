package com.example.vorper.figurasaleatorias;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launchDrawShape1(View clickedButton){
        Intent activityIntent =
                new Intent(this,DrawShapes1.class);
        startActivity(activityIntent);
    }
    public void launchDrawShape2(View clickedButton){
        Intent activityIntent =
                new Intent(this,DrawShapes2.class);
        startActivity(activityIntent);
    }
}

