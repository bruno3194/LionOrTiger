package com.bruno.naveen.lionortiger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private enum player{
        ZERO,ONE,TWO
    };
    private ArrayList<player> arr=new ArrayList<player>();
    private int ii,str;
    private boolean cont;

    private player current;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        for(ii=1;ii<=9;ii++)
        {
            arr.add(player.ZERO);
        }
        cont=true;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        current= player.ONE;

    }
    public void anime(View V) {
        if (cont == true) {
            ii = 10;
            ImageView i = (ImageView) V;
            str = V.getId() % ii;
            if (str != 0) {
                arr.set(str - 2, current);
            } else {
                arr.set(8, current);
            }

            if (i.getAlpha() == 0.2f) {
                if (current == player.ONE) {
                    i.setImageResource(R.drawable.tiger);
                    current = player.TWO;
                } else {
                    i.setImageResource(R.drawable.lion);

                    current = player.ONE;
                }
                i.setTranslationX(-2000);
                i.animate().translationXBy(2000).rotation(3600).alpha(1).setDuration(1000);

            }
            isWon();
            if (!arr.contains(player.ZERO)&&cont==true)
                Toast.makeText(MainActivity.this, "NOBODY WINS", Toast.LENGTH_LONG).show();
            Log.i("my", " : " + str);

        }
    }
        public void isWon()
        {
            if((arr.get(0)==player.ONE&&arr.get(1)==player.ONE&&arr.get(2)==player.ONE)||
                    (arr.get(3)==player.ONE&&arr.get(4)==player.ONE&&arr.get(5)==player.ONE)||
                    (arr.get(6)==player.ONE&&arr.get(7)==player.ONE&&arr.get(8)==player.ONE)||
                    (arr.get(0)==player.ONE&&arr.get(3)==player.ONE&&arr.get(6)==player.ONE)||
                    (arr.get(1)==player.ONE&&arr.get(4)==player.ONE&&arr.get(7)==player.ONE)||
                    (arr.get(2)==player.ONE&&arr.get(5)==player.ONE&&arr.get(8)==player.ONE)||
                    (arr.get(0)==player.ONE&&arr.get(4)==player.ONE&&arr.get(8)==player.ONE)||
                    (arr.get(2)==player.ONE&&arr.get(4)==player.ONE&&arr.get(6)==player.ONE)) {
                Toast.makeText(MainActivity.this, "PLAYER ONE WINS", Toast.LENGTH_LONG).show();
                cont=false;
            }
            else if((arr.get(0)==player.TWO&&arr.get(1)==player.TWO&&arr.get(2)==player.TWO)||
                    (arr.get(3)==player.TWO&&arr.get(4)==player.TWO&&arr.get(5)==player.TWO)||
                    (arr.get(6)==player.TWO&&arr.get(7)==player.TWO&&arr.get(8)==player.TWO)||
                    (arr.get(0)==player.TWO&&arr.get(3)==player.TWO&&arr.get(6)==player.TWO)||
                    (arr.get(1)==player.TWO&&arr.get(4)==player.TWO&&arr.get(7)==player.TWO)||
                    (arr.get(2)==player.TWO&&arr.get(5)==player.TWO&&arr.get(8)==player.TWO)||
                    (arr.get(0)==player.TWO&&arr.get(4)==player.TWO&&arr.get(8)==player.TWO)||
                    (arr.get(2)==player.TWO&&arr.get(4)==player.TWO&&arr.get(6)==player.TWO)) {
                Toast.makeText(MainActivity.this, "PLAYER TWO WINS", Toast.LENGTH_LONG).show();
                cont=false;

            }
        }
}