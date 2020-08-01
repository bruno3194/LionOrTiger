package com.bruno.naveen.lionortiger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private enum player{
        ONE,TWO
    };
    private player current;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        current= player.ONE;
    }
    public void anime(View V)
    {
        ImageView i=(ImageView)V;

        if(i.getAlpha()==0.2f)
        {
            if(current==player.ONE)
            {i.setImageResource(R.drawable.tiger);
             current=player.TWO;}
            else
            {i.setImageResource(R.drawable.lion);
             current=player.ONE;}
            i.setTranslationX(-2000);
            i.animate().translationXBy(2000).rotation(3600).alpha(1).setDuration(1000);

        }
            Log.i("my","alpha : "+i.getAlpha());
        }
}