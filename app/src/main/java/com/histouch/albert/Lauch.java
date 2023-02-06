package com.histouch.albert;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Lauch extends AppCompatActivity {
    protected int _splashTime = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lauch);
        date3();
    }



    void date3(){



        //HH converts hour in 24 hours format (0-23), day calculation
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

        Date d1 = null;
        Date d2 = null;

        try {
            d1 = format.parse(Constants.dateStart);
            d2 = format.parse(Constants.dateStop);

            //in milliseconds
            long diff = d2.getTime() - d1.getTime();

            long diffSeconds = diff / 1000 % 60;
            long diffMinutes = diff / (60 * 1000) % 60;
            long diffHours = diff / (60 * 60 * 1000) % 24;
            long diffDays = diff / (24 * 60 * 60 * 1000);

            System.out.print(diffDays + " days, ");
            System.out.print(diffHours + " hours, ");
            System.out.print(diffMinutes + " minutes, ");
            System.out.print(diffSeconds + " seconds.");


            System.out.println(diff);

            if(diffDays>18){
                Toast.makeText(this, "days Expired", Toast.LENGTH_LONG);
                finish();

            }else{


                Handler timer = new Handler();

                Runnable r = new Runnable() {

                    @Override
                    public void run() {

                        startActivity(new Intent(Lauch.this, Drawer.class));


                    }
                };

                timer.postDelayed(r, _splashTime);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
