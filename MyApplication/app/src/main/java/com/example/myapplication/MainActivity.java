package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {
    TextToSpeech textToSpeech;
    Context context=this;
    Random random=new Random();
    ImageButton imageButton;
    ChipGroup chipGroup;
    Chip chip1,chip2,chip3,chip4,chip5,chip6;
    TextView textView,textIpucu1,textIpucu2,textIpucu3,textIpucu4;
    Button gec,btn1,btn2,btn3,btn4;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    SwitchCompat translate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chipGroup=findViewById(R.id.chip_gp);
        chip1=findViewById(R.id.a1);
        chip2=findViewById(R.id.a2);
        chip3=findViewById(R.id.b1);
        chip4=findViewById(R.id.b2);
        chip5=findViewById(R.id.c1);
        chip6=findViewById(R.id.c2);
        btn1=findViewById(R.id.button);
        btn2=findViewById(R.id.button2);
        btn3=findViewById(R.id.button3);
        btn4=findViewById(R.id.button4);
        textView=findViewById(R.id.textView1);
        translate=findViewById(R.id.switch1);
        gec=findViewById(R.id.gec);

        textIpucu1=findViewById(R.id.t1);
        textIpucu2=findViewById(R.id.t2);
        textIpucu3=findViewById(R.id.t3);
        textIpucu4=findViewById(R.id.t4);
        imageButton=findViewById(R.id.imagebtn);
        textToSpeech=new TextToSpeech(context,this);

        chipGroup.setOnCheckedChangeListener(new ChipGroup.OnCheckedChangeListener() {

            ArrayList buton1i=new ArrayList();
            ArrayList buton2i=new ArrayList();
            ArrayList buton3i=new ArrayList();
            ArrayList buton4i=new ArrayList();
            ArrayList buton1t=new ArrayList();
            ArrayList buton2t=new ArrayList();
            ArrayList buton3t=new ArrayList();
            ArrayList buton4t=new ArrayList();
            int randomIndex,randomButton;



            @Override
            public void onCheckedChanged(ChipGroup group, int checkedId) {

                gec.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        gec.setText("Geç");
                        randomButton=random.nextInt(3);
                        randomIndex= random.nextInt(107);
                        butonColor();
                        textIpucu1.setVisibility(view.INVISIBLE);
                        textIpucu2.setVisibility(view.INVISIBLE);
                        textIpucu3.setVisibility(view.INVISIBLE);
                        textIpucu4.setVisibility(view.INVISIBLE);
                        if (randomButton==0){
                            if (translate.isChecked()==true) textView.setText(buton1t.get(randomIndex).toString());
                            else {
                                textView.setText(buton1i.get(randomIndex).toString());
                            }
                            btn1.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    btn1.setBackgroundColor(getResources().getColor(R.color.green));
                                    btn2.setBackgroundColor(getResources().getColor(R.color.red));
                                    btn3.setBackgroundColor(getResources().getColor(R.color.red));
                                    btn4.setBackgroundColor(getResources().getColor(R.color.red));

                                }
                            });
                            btn2.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    btn2.setBackgroundColor(getResources().getColor(R.color.red));
                                    vibrator();
                                }
                            });
                            btn3.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    btn3.setBackgroundColor(getResources().getColor(R.color.red));
                                    vibrator();
                                }
                            });
                            btn4.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    btn4.setBackgroundColor(getResources().getColor(R.color.red));
                                    vibrator();
                                }
                            });

                        }
                        else if (randomButton==1){
                            if (translate.isChecked()==true) textView.setText(buton2t.get(randomIndex).toString());
                            else {
                                textView.setText(buton2i.get(randomIndex).toString());
                            }

                            btn1.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    btn1.setBackgroundColor(getResources().getColor(R.color.red));
                                    vibrator();
                                }
                            });
                            btn2.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    btn2.setBackgroundColor(getResources().getColor(R.color.green));
                                    btn1.setBackgroundColor(getResources().getColor(R.color.red));
                                    btn3.setBackgroundColor(getResources().getColor(R.color.red));
                                    btn4.setBackgroundColor(getResources().getColor(R.color.red));

                                }
                            });
                            btn3.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    btn3.setBackgroundColor(getResources().getColor(R.color.red));
                                    vibrator();
                                }
                            });
                            btn4.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    btn4.setBackgroundColor(getResources().getColor(R.color.red));
                                    vibrator();
                                }
                            });


                        }
                        else if (randomButton==2){
                            if (translate.isChecked()==true) textView.setText(buton3t.get(randomIndex).toString());
                            else {
                                textView.setText(buton3i.get(randomIndex).toString());
                            }

                            btn1.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    btn1.setBackgroundColor(getResources().getColor(R.color.red));
                                    vibrator();
                                }
                            });
                            btn2.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    btn2.setBackgroundColor(getResources().getColor(R.color.red));
                                    vibrator();
                                }
                            });
                            btn3.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    btn3.setBackgroundColor(getResources().getColor(R.color.green));
                                    btn2.setBackgroundColor(getResources().getColor(R.color.red));
                                    btn4.setBackgroundColor(getResources().getColor(R.color.red));
                                    btn1.setBackgroundColor(getResources().getColor(R.color.red));
                                }
                            });
                            btn4.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    btn4.setBackgroundColor(getResources().getColor(R.color.red));
                                    vibrator();
                                }
                            });


                        }
                        else if (randomButton==3){
                            if (translate.isChecked()==true) textView.setText(buton4t.get(randomIndex).toString());
                            else {
                                textView.setText(buton4i.get(randomIndex).toString());
                            }

                            btn1.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    btn1.setBackgroundColor(getResources().getColor(R.color.red));
                                    vibrator();
                                }
                            });
                            btn2.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    btn2.setBackgroundColor(getResources().getColor(R.color.red));
                                    vibrator();
                                }
                            });
                            btn3.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    btn3.setBackgroundColor(getResources().getColor(R.color.red));
                                    vibrator();
                                }
                            });
                            btn4.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    btn4.setBackgroundColor(getResources().getColor(R.color.green));
                                    btn2.setBackgroundColor(getResources().getColor(R.color.red));
                                    btn1.setBackgroundColor(getResources().getColor(R.color.red));
                                    btn3.setBackgroundColor(getResources().getColor(R.color.red));
                                }
                            });


                        }

                        if (translate.isChecked()==true){
                            translate.setText("İngilizce");
                            imageButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    textIpucu1.setText(buton1t.get(randomIndex).toString());
                                    textIpucu2.setText(buton2t.get(randomIndex).toString());
                                    textIpucu3.setText(buton3t.get(randomIndex).toString());
                                    textIpucu4.setText(buton4t.get(randomIndex).toString());
                                    textIpucu1.setVisibility(view.VISIBLE);
                                    textIpucu2.setVisibility(view.VISIBLE);
                                    textIpucu3.setVisibility(view.VISIBLE);
                                    textIpucu4.setVisibility(view.VISIBLE);
                                }
                            });
                            btn1.setText(buton1i.get(randomIndex).toString());
                            btn2.setText(buton2i.get(randomIndex).toString());
                            btn3.setText(buton3i.get(randomIndex).toString());
                            btn4.setText(buton4i.get(randomIndex).toString());
                            findViewById(R.id.btn1ses).setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    convertTextToSpeech(buton1i.get(randomIndex).toString());
                                }
                            });
                            findViewById(R.id.btn2ses).setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    convertTextToSpeech(buton2i.get(randomIndex).toString());
                                }
                            });
                            findViewById(R.id.btn3ses).setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    convertTextToSpeech(buton3i.get(randomIndex).toString());
                                }
                            });
                            findViewById(R.id.btn4ses).setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    convertTextToSpeech(buton4i.get(randomIndex).toString());
                                }
                            });
                        }else {
                            translate.setText("Türkçe");
                            imageButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {

                                    textIpucu1.setText(buton1i.get(randomIndex).toString());
                                    textIpucu2.setText(buton2i.get(randomIndex).toString());
                                    textIpucu3.setText(buton3i.get(randomIndex).toString());
                                    textIpucu4.setText(buton4i.get(randomIndex).toString());
                                    textIpucu1.setVisibility(view.VISIBLE);
                                    textIpucu2.setVisibility(view.VISIBLE);
                                    textIpucu3.setVisibility(view.VISIBLE);
                                    textIpucu4.setVisibility(view.VISIBLE);

                                }
                            });
                            btn1.setText(buton1t.get(randomIndex).toString());
                            btn2.setText(buton2t.get(randomIndex).toString());
                            btn3.setText(buton3t.get(randomIndex).toString());
                            btn4.setText(buton4t.get(randomIndex).toString());
                            findViewById(R.id.btn1ses).setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    convertTextToSpeech(buton1t.get(randomIndex).toString());
                                }
                            });
                            findViewById(R.id.btn2ses).setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    convertTextToSpeech(buton2t.get(randomIndex).toString());
                                }
                            });
                            findViewById(R.id.btn3ses).setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    convertTextToSpeech(buton3t.get(randomIndex).toString());
                                }
                            });
                            findViewById(R.id.btn4ses).setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    convertTextToSpeech(buton4t.get(randomIndex).toString());
                                }
                            });
                        }


                    }
                });







                if (chip1.isChecked()){fr("a1","a1Tr",buton1i,buton2i,buton3i,buton4i,buton1t,buton2t,buton3t,buton4t);}
                if (chip2.isChecked()){fr("a2","a2Tr",buton1i,buton2i,buton3i,buton4i,buton1t,buton2t,buton3t,buton4t);}
                if (chip3.isChecked()){fr("b1","b1Tr",buton1i,buton2i,buton3i,buton4i,buton1t,buton2t,buton3t,buton4t);}
                if (chip4.isChecked()){fr("b2","b2Tr",buton1i,buton2i,buton3i,buton4i,buton1t,buton2t,buton3t,buton4t);}
                if (chip5.isChecked()){fr("c1","c1Tr",buton1i,buton2i,buton3i,buton4i,buton1t,buton2t,buton3t,buton4t);}
                if (chip6.isChecked()){fr("c2","c2Tr",buton1i,buton2i,buton3i,buton4i,buton1t,buton2t,buton3t,buton4t);}



            }
        });

    }



    public void butonColor(){
        imageButton.setVisibility(textView.VISIBLE);
        btn1.setVisibility(textView.VISIBLE);
        btn2.setVisibility(textView.VISIBLE);
        btn3.setVisibility(textView.VISIBLE);
        btn4.setVisibility(textView.VISIBLE);
        btn1.setBackgroundColor(getResources().getColor(R.color.black));
        btn2.setBackgroundColor(getResources().getColor(R.color.black));
        btn3.setBackgroundColor(getResources().getColor(R.color.black));
        btn4.setBackgroundColor(getResources().getColor(R.color.black));
    }
    public void fr(String path1,String path2,ArrayList arrayList1,ArrayList arrayList2,ArrayList arrayList3,
                   ArrayList arrayList4,ArrayList arrayList5,ArrayList arrayList6,ArrayList arrayList7,ArrayList arrayList8){
        arrayList1.clear();
        arrayList2.clear();
        arrayList3.clear();
        arrayList4.clear();
        arrayList5.clear();
        arrayList6.clear();
        arrayList7.clear();
        arrayList8.clear();
        DatabaseReference myRef = database.getReference(path1);
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int i=0;
                Iterable<DataSnapshot> keys=snapshot.getChildren();
                for (DataSnapshot key:keys){
                    if (i<107) arrayList1.add(key.getValue().toString());
                    else if (i>107&&i<214) arrayList2.add(key.getValue().toString());
                    else if (i>214&&i<321) arrayList3.add(key.getValue().toString());
                    else {
                        arrayList4.add(key.getValue().toString());
                    }
                    i++;

                }

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(MainActivity.this, "Bekleyin", Toast.LENGTH_SHORT).show();
            }
        });

        DatabaseReference myRef2 = database.getReference(path2);
        myRef2.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int i=0;
                Iterable<DataSnapshot> keys=snapshot.getChildren();
                for (DataSnapshot key:keys){
                    if (i<107) arrayList5.add(key.getValue().toString());
                    else if (i>107&&i<214) arrayList6.add(key.getValue().toString());
                    else if (i>214&&i<321) arrayList7.add(key.getValue().toString());
                    else {
                        arrayList8.add(key.getValue().toString());
                    }
                    i++;

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(MainActivity.this, "Bekleyin", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void vibrator(){
        ((Vibrator)context.getSystemService(Context.VIBRATOR_SERVICE)).vibrate(300);
    }

    public void onInit(int i) {
        if (i==textToSpeech.SUCCESS){
            int sonuc=textToSpeech.setLanguage(Locale.ENGLISH);
            if (sonuc==textToSpeech.LANG_MISSING_DATA || sonuc==textToSpeech.LANG_NOT_SUPPORTED){
                Toast.makeText(context, "dil desteklenmiyor", Toast.LENGTH_SHORT).show();

            }
            else {

            }
        }else {
            Toast.makeText(context, "hata", Toast.LENGTH_SHORT).show();
        }


        }
        public void convertTextToSpeech(String s){
            textToSpeech.speak(s,textToSpeech.QUEUE_FLUSH,null);
        }


    }
