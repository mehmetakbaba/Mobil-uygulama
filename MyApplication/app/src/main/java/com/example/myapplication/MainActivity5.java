package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity5 extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        Random random=new Random();
        int a;
        a=random.nextInt(10);
        String[] hadis=new String[]{"There are two eyes that the fire of Hell will not touch them: an eye that weeps out of fear of Allah, and an eye that spends its night in the way of Allah, keeping watch. Tirmidhi, Fedâilü'l-Cihâd, 12.",
        "None of you can be a true believer until he wishes for his (believing) brother what he wishes for himself. Bukhari, Iman, 7; Muslim, Iman, 71.",
        "A Muslim is a person from whose hand and tongue people are safe. Tirmidhi, Iman, 12; Nesai, Iman, 8.",
        "You cannot enter Paradise unless you believe, and you cannot truly believe unless you love one another. Muslim, Iman, 93; Tirmidhi, Sıfâtu'l-kıyâme, 56.",
        "It is enough for a person to belittle his Muslim brother.(Muslim, Birr, 32)",
        "Whoever denotes a good deed will receive a reward like the one who did it.(Beyhak)",
        "Tie up your camel, then put your trust in Allah.” (Tirmidhi)",
        "Eating whatever you want is also a waste of money.” (Abu Dawud)",
        "Blessed is the person whose life is long and whose deeds, work and worship are good!” (Tabarani)",
         "The most beloved of deeds to Allah is the one that is continuous, even if it is little.” (Bukhari)"};



        textView=findViewById(R.id.textHadis);
        textView.setText(hadis[a]);

        findViewById(R.id.alistirmaGec).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity5.this,MainActivity.class);

                startActivity(intent);
            }
        });
        findViewById(R.id.listGec).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity5.this,MainActivity2.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.camGec).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity5.this,MainActivity4.class);
                startActivity(intent);
            }
        });
    }
}