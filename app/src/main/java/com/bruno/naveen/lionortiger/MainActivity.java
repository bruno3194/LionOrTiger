package com.bruno.naveen.lionortiger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import androidx.gridlayout.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private enum player{
        ZERO,ONE,TWO
    };
    private ArrayList<player> arr=new ArrayList<player>();
    private int ii,str,count=0;
    private boolean cont;
    private Button b1;
    private GridLayout gridLayout;
    private ImageView fg,gh;
    private player current;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        for(ii=1;ii<=9;ii++)
        {
            arr.add(player.ZERO);
        }
        cont=true;
        super.onCreate(savedInstanceState);
        current= player.ONE;

        setContentView(R.layout.select);

    }
    public void anime(View V) {
        if (cont == true) {

            ImageView i = (ImageView) V;
            str = Integer.parseInt(i.getTag().toString());
            arr.set(str,current);

            if (i.getAlpha() == 0.2f) {
                if (current == player.ONE) {
                  i.setImageDrawable(fg.getDrawable());
                  current = player.TWO;
                } else {
                    i.setImageDrawable(gh.getDrawable());
                 //   i=gh;
                    current = player.ONE;
                }
                i.setTranslationX(-2000);
                i.animate().translationXBy(2000).rotation(3600).alpha(1).setDuration(1000);

            }
            isWon();
            if (!arr.contains(player.ZERO)&&cont==true) {
                Toast.makeText(MainActivity.this, "NOBODY WINS", Toast.LENGTH_LONG).show();
                b1.setVisibility(View.VISIBLE);
            }Log.i("my", " : " + str);

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
                b1.setVisibility(View.VISIBLE);
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
                b1.setVisibility(View.VISIBLE);

            }
        }
        public void reset(View vr){
        for(int im=0;im<gridLayout.getChildCount();im++)
        {
            ImageView imo=(ImageView)gridLayout.getChildAt(im);
            imo.setImageDrawable(null);

            imo.setAlpha(0.2f);
        }
            for(ii=0;ii<9;ii++)
            {
                arr.set(ii,player.ZERO);
            }
            cont=true;
            current= player.ONE;
            b1.setVisibility(View.GONE);
            count=0;
            fg=null;
            gh=null;
            setContentView(R.layout.select);
        }
        public void sel(View v)
        {
            if(count==0)
            {fg=(ImageView)v;
                count++;
                fg.setAlpha(0.2f);
                return;
            }
            else if(count==1)
            {
                gh=(ImageView)v;
                count++;
                gh.setAlpha(0.2f);
                setContentView(R.layout.activity_main);
                b1=(Button)findViewById(R.id.button);
                gridLayout=(GridLayout) findViewById(R.id.grid);

            }
        }
}