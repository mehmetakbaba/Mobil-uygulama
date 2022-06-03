package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity3 extends AppCompatActivity {
    VideoView videoView;
    MediaController mediaController;
    RadioGroup radioGroup;
    RadioButton r1,r2,r3,r4;
    String videoPath;
    Uri uri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        String anahtar;
        Intent intent=getIntent();
        anahtar=intent.getStringExtra("key");
        radioGroup=findViewById(R.id.radioGroup);
        r1=findViewById(R.id.radio1);
        r2=findViewById(R.id.radio2);
        r3=findViewById(R.id.radio3);
        r4=findViewById(R.id.radio4);
        videoView=findViewById(R.id.vd);
        String[][] cevapBat=new String[][]{{"Korku bir araçtır. O ışık gökyüzünde belirdiğinde… sadece bir çağrı değil. Bir uyarıdır !","" +
                "Korku bir yoldur. O ışığı gördüğümde. Bu sadece bir çağrı değil. Bu bir uyarı.","" +
                "korku bir araçtır. O ışığı gördüklerinde. Bu sadece onlar için bir çağrı değil. Bu bir uyarı.","" +
                "Aletten korkar. O ışığı gördüğünde. Bu bir çağrı."},{" Silahı bırak !Elbette , sadece küçük maskeni çıkar ve bize gerçekte kim ",
        "Silahı bana ver Tamam,  ama önce maskeni çıkar ve bize gerçekte kim olduğunu göster",
        "Silahımı düşürdüm Tabii , ama önce maskeni çıkar ve bize yüzünü göster",
        "Silahı bırak! Elbette , sadece büyük maskeni çıkar ve bize kim olduğunu    göster"},{"iyi akşamlar bayanlar baylar. Biz bu gecenin eğlencesiyiz! Sadece bir sorum var. Harvey Dent nerede?",
        " İyi geceler bayanlar baylar. Bu gecenin şovu biziz! Sadece bir   sorum var. Harvey Dent nerede?",
        "İyi akşamlar bayanlar ve baylar. Biz bu gecenin şovmenleriyiz! Bir sorum var. Harveys'in borcu nerede?",
        "İyi günler erkekler ve kadınlar. Biz bu gecenin eğlencesiyiz! Bir sorum var. Harvey Dent nerede?"},{"Merhaba güzelim. Sen Harvey'nin arkadaşı olmalısın. Ve sen güzelsin. Ah, gergin görünüyorsun. Yaralar olduğu için mi?",
        "Merhaba güzelim. Sen Harvey'nin arkadaşı olmalısın. Ve sen güzelsin. Ah, üzgün görünüyorsun. Yaralar olduğu için mi?",
        "Merhaba güzelim. Sen Harvey'nin arkadaşı olmalısın. Ve sen güzelsin. Ah, gergin görünüyorsun. Bıçaktan mı?",
        "Merhaba aşkım. Sen Harvey'nin kızı olmalısın. Ve üzgünsün. Ah, korkmuş görünüyorsun. Arabalar olduğu için mi?"},{
            "Ona ne gösterdiğini bana göster Belki de sadece arkadaşını aramalısın","Bana ona ne söylediğini söyle Belki de sadece arkadaşını aramalısın",
                "Ona ne gösterdiğini bana göster Belki de bana arkadaşım demelisin","Ona ne gösterdiğini bize göster Arkadaşını ara"},
                {"Bir daha asla erkek arkadaş bulamayacağım. Yaşlı bir hizmetçi olarak öleceğim. -Oh, yaşlı bir hizmetçi olarak ölmeyeceksin. Belki yasli.. bir kız kurusu aşçı.",
                "Yine erkek arkadaş istemiyorum. Yaşlı bir hizmetçi olarak ölmek istiyorum. -Oh, yaşlı bir hizmetçi olarak ölmeyeceksin. Belki yasli.. bir kız kurusu aşçı.",
                "Bir daha asla arkadaş bulamayacağım. Yaşlı bir hizmetçi olarak öleceğim. Oh, yaşlı bir hizmetçi olarak ölmeyeceksin. Belki yaşlı bir ağaç gibi.",
                "Bir daha asla erkek arkadaş bulamayacağım. yalnız öleceğim dostum. Oh, yalnız ölmeyeceksin."},{"Ne söylediğimin veya nerede söylediğimin önemli olduğunu düşündüm.",
        "Kavga ettim çünkü ne söylediğimin veya nerede söylediğimin önemli olduğunu düşünüyorum.","Ne söylediğimin ve nerede söylediğimin önemli olduğunu düşünüyorum.",
        "Ne söylediğimin ya da nerede söylediğimin bir önemi olmadığını düşündüm."},{"Böyle öğrenmek zorunda kaldığın için çok ozur dilerim. Üzgünüm ama .. onu sevdiğim doğru -Benim en iyi arkadaşım ve kız kardeşim !",
        "Böyle öğrenmek zorunda kaldığın için çok ozur dilerim. Üzgünüm ama .. doğru değil onu sevmiyorum En iyi arkadaşım ve kız kardeşim!",
        "Bu şekilde öğrenmelisin. Ozur dilerim .. onu sevdiğim doğru En iyi arkadaşım ve kız kardeşim!",
        "Ozur dilerim.. ikinizi sevdiğim doğru En iyi arkadaşım ve kız kardeşim!"},
                {"Peki , yardımı olacaksa.. çok iyi çalıştı! Ortaya çıkana kadar çalışıyordu,. Sen büyük bir ağaçsin",
                "Peki, sana yardım edersem, iyi çalışacaksın! Sen gelene kadar çalışıyordu. sen büyük bir ağaçsin",
                "Tamam, sana yardım edersem, iyi çalışacaksın! Sen gelene kadar çalışıyordu. Sen büyük bir Yalancisin ",
                "Tamam, çok iyi çalıştın! -Sen ortaya çıktığında iş oldu. Sen iyi bir arkadaşsın."},{"Bay Sallamanka! Sen kimsin ki sana işimi mi söylüyor? Güveninize ihanet etmedi!",
        " Bay Salman Khan! Sen kimsin ki bana işimi anlatacaksın?!Güveninize ihanet etmedi!",
        "Bay Salmanka !+ - Sen kimsin ki sana işimi mi söylüyor?! Güveninize ihanet etti!",
        "Bay satıcı! Sen kimsin ki benimle konuşuyorsun?! Seninle kalmadı!"},
                {"O halde, bana tekrar söyle. İki büyük çanta para aldım, yedi milyar dolar!",
                "O halde, bana tekrar anlat.Çok para kazandıracak bir resim, yedi milyar dolar!",
                "Lütfen, tekrar söyle. Büyük bir çanta dolusu para çaldım, yedi milyar dolar!",
                "Oyleyse, bana itiraf et. Iki büyük çanta para aldım, yedi milyar dolar!"},{"Paramı çaldınız demek ha,Paranı kimse çalmadı",
        "paramı calıp karşımda oturuyosun he paran bizde değil","Param nerede , bizde değil","paramı bulun,peki bulacağız"}};
        //videoPath="android.resource://"+getPackageName()+"/"+R.raw.bat1;

        uri=Uri.parse(anahtar);
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                radioGroup.setVisibility(videoView.VISIBLE);
                if (anahtar.equals("android.resource://"+getPackageName()+"/"+R.raw.bat1)){
                    r1.setText(cevapBat[0][0]);
                    r2.setText(cevapBat[0][1]);
                    r3.setText(cevapBat[0][2]);
                    r4.setText(cevapBat[0][3]);
                    r1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            r1.setTextColor(getResources().getColor(R.color.green));
                            r2.setTextColor(getResources().getColor(R.color.red));
                            r3.setTextColor(getResources().getColor(R.color.red));
                            r4.setTextColor(getResources().getColor(R.color.red));
                        }
                    });
                    r2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            r2.setTextColor(getResources().getColor(R.color.red));
                        }
                    });
                    r3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            r3.setTextColor(getResources().getColor(R.color.red));
                        }
                    });
                    r4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            r4.setTextColor(getResources().getColor(R.color.red));
                        }
                    });
                }
                else if (anahtar.equals("android.resource://"+getPackageName()+"/"+R.raw.bat2)) {
                    r3.setText(cevapBat[1][0]);
                    r2.setText(cevapBat[1][1]);
                    r1.setText(cevapBat[1][2]);
                    r4.setText(cevapBat[1][3]);
                    r1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            r1.setTextColor(getResources().getColor(R.color.red));

                        }
                    });
                    r2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            r2.setTextColor(getResources().getColor(R.color.red));
                        }
                    });
                    r3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            r3.setTextColor(getResources().getColor(R.color.green));
                            r2.setTextColor(getResources().getColor(R.color.red));
                            r1.setTextColor(getResources().getColor(R.color.red));
                            r4.setTextColor(getResources().getColor(R.color.red));
                        }
                    });
                    r4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            r4.setTextColor(getResources().getColor(R.color.red));
                        }
                    });
                }
                else if (anahtar.equals("android.resource://"+getPackageName()+"/"+R.raw.bat3)) {
                    r2.setText(cevapBat[2][0]);
                    r3.setText(cevapBat[2][1]);
                    r1.setText(cevapBat[2][2]);
                    r4.setText(cevapBat[2][3]);
                    r1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            r1.setTextColor(getResources().getColor(R.color.red));

                        }
                    });
                    r2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            r3.setTextColor(getResources().getColor(R.color.red));
                            r2.setTextColor(getResources().getColor(R.color.green));
                            r1.setTextColor(getResources().getColor(R.color.red));
                            r4.setTextColor(getResources().getColor(R.color.red));
                        }
                    });
                    r3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            r3.setTextColor(getResources().getColor(R.color.red));

                        }
                    });
                    r4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            r4.setTextColor(getResources().getColor(R.color.red));
                        }
                    });
                }
                else if (anahtar.equals("android.resource://"+getPackageName()+"/"+R.raw.bat4)){
                    r1.setText(cevapBat[3][0]);
                    r2.setText(cevapBat[3][1]);
                    r3.setText(cevapBat[3][2]);
                    r4.setText(cevapBat[3][3]);
                    r1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            r1.setTextColor(getResources().getColor(R.color.green));
                            r2.setTextColor(getResources().getColor(R.color.red));
                            r3.setTextColor(getResources().getColor(R.color.red));
                            r4.setTextColor(getResources().getColor(R.color.red));
                        }
                    });
                    r2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            r2.setTextColor(getResources().getColor(R.color.red));
                        }
                    });
                    r3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            r3.setTextColor(getResources().getColor(R.color.red));
                        }
                    });
                    r4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            r4.setTextColor(getResources().getColor(R.color.red));
                        }
                    });
                }
                else if (anahtar.equals("android.resource://"+getPackageName()+"/"+R.raw.how1)) {
                    r3.setText(cevapBat[4][0]);
                    r2.setText(cevapBat[4][1]);
                    r1.setText(cevapBat[4][2]);
                    r4.setText(cevapBat[4][3]);
                    r1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            r1.setTextColor(getResources().getColor(R.color.red));

                        }
                    });
                    r2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            r2.setTextColor(getResources().getColor(R.color.red));
                        }
                    });
                    r3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            r3.setTextColor(getResources().getColor(R.color.green));
                            r2.setTextColor(getResources().getColor(R.color.red));
                            r1.setTextColor(getResources().getColor(R.color.red));
                            r4.setTextColor(getResources().getColor(R.color.red));
                        }
                    });
                    r4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            r4.setTextColor(getResources().getColor(R.color.red));
                        }
                    });
                }
                else if (anahtar.equals("android.resource://"+getPackageName()+"/"+R.raw.how2)){
                    r1.setText(cevapBat[5][0]);
                    r2.setText(cevapBat[5][1]);
                    r3.setText(cevapBat[5][2]);
                    r4.setText(cevapBat[5][3]);
                    r1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            r1.setTextColor(getResources().getColor(R.color.green));
                            r2.setTextColor(getResources().getColor(R.color.red));
                            r3.setTextColor(getResources().getColor(R.color.red));
                            r4.setTextColor(getResources().getColor(R.color.red));
                        }
                    });
                    r2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            r2.setTextColor(getResources().getColor(R.color.red));
                        }
                    });
                    r3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            r3.setTextColor(getResources().getColor(R.color.red));
                        }
                    });
                    r4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            r4.setTextColor(getResources().getColor(R.color.red));
                        }
                    });
                }
                else if (anahtar.equals("android.resource://"+getPackageName()+"/"+R.raw.how3)){
                    r1.setText(cevapBat[6][0]);
                    r2.setText(cevapBat[6][1]);
                    r3.setText(cevapBat[6][2]);
                    r4.setText(cevapBat[6][3]);
                    r1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            r1.setTextColor(getResources().getColor(R.color.green));
                            r2.setTextColor(getResources().getColor(R.color.red));
                            r3.setTextColor(getResources().getColor(R.color.red));
                            r4.setTextColor(getResources().getColor(R.color.red));
                        }
                    });
                    r2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            r2.setTextColor(getResources().getColor(R.color.red));
                        }
                    });
                    r3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            r3.setTextColor(getResources().getColor(R.color.red));
                        }
                    });
                    r4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            r4.setTextColor(getResources().getColor(R.color.red));
                        }
                    });
                }
                else if (anahtar.equals("android.resource://"+getPackageName()+"/"+R.raw.how4)) {
                    r2.setText(cevapBat[7][0]);
                    r3.setText(cevapBat[7][1]);
                    r1.setText(cevapBat[7][2]);
                    r4.setText(cevapBat[7][3]);
                    r1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            r1.setTextColor(getResources().getColor(R.color.red));

                        }
                    });
                    r2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            r3.setTextColor(getResources().getColor(R.color.red));
                            r2.setTextColor(getResources().getColor(R.color.green));
                            r1.setTextColor(getResources().getColor(R.color.red));
                            r4.setTextColor(getResources().getColor(R.color.red));
                        }
                    });
                    r3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            r3.setTextColor(getResources().getColor(R.color.red));

                        }
                    });
                    r4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            r4.setTextColor(getResources().getColor(R.color.red));
                        }
                    });
                }
                else if (anahtar.equals("android.resource://"+getPackageName()+"/"+R.raw.saul1)){
                    r1.setText(cevapBat[8][0]);
                    r2.setText(cevapBat[8][1]);
                    r3.setText(cevapBat[8][2]);
                    r4.setText(cevapBat[8][3]);
                    r1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            r1.setTextColor(getResources().getColor(R.color.green));
                            r2.setTextColor(getResources().getColor(R.color.red));
                            r3.setTextColor(getResources().getColor(R.color.red));
                            r4.setTextColor(getResources().getColor(R.color.red));
                        }
                    });
                    r2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            r2.setTextColor(getResources().getColor(R.color.red));
                        }
                    });
                    r3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            r3.setTextColor(getResources().getColor(R.color.red));
                        }
                    });
                    r4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            r4.setTextColor(getResources().getColor(R.color.red));
                        }
                    });
                }
                else if (anahtar.equals("android.resource://"+getPackageName()+"/"+R.raw.saul2)){
                    r1.setText(cevapBat[9][0]);
                    r2.setText(cevapBat[9][1]);
                    r3.setText(cevapBat[9][2]);
                    r4.setText(cevapBat[9][3]);
                    r1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            r1.setTextColor(getResources().getColor(R.color.green));
                            r2.setTextColor(getResources().getColor(R.color.red));
                            r3.setTextColor(getResources().getColor(R.color.red));
                            r4.setTextColor(getResources().getColor(R.color.red));
                        }
                    });
                    r2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            r2.setTextColor(getResources().getColor(R.color.red));
                        }
                    });
                    r3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            r3.setTextColor(getResources().getColor(R.color.red));
                        }
                    });
                    r4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            r4.setTextColor(getResources().getColor(R.color.red));
                        }
                    });
                }
                else if (anahtar.equals("android.resource://"+getPackageName()+"/"+R.raw.saul3)) {
                    r2.setText(cevapBat[10][0]);
                    r3.setText(cevapBat[10][1]);
                    r1.setText(cevapBat[10][2]);
                    r4.setText(cevapBat[10][3]);
                    r1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            r1.setTextColor(getResources().getColor(R.color.red));

                        }
                    });
                    r2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            r3.setTextColor(getResources().getColor(R.color.red));
                            r2.setTextColor(getResources().getColor(R.color.green));
                            r1.setTextColor(getResources().getColor(R.color.red));
                            r4.setTextColor(getResources().getColor(R.color.red));
                        }
                    });
                    r3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            r3.setTextColor(getResources().getColor(R.color.red));

                        }
                    });
                    r4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            r4.setTextColor(getResources().getColor(R.color.red));
                        }
                    });
                }
                else if (anahtar.equals("android.resource://"+getPackageName()+"/"+R.raw.saul4)){
                    r1.setText(cevapBat[11][0]);
                    r2.setText(cevapBat[11][1]);
                    r3.setText(cevapBat[11][2]);
                    r4.setText(cevapBat[11][3]);
                    r1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            r1.setTextColor(getResources().getColor(R.color.green));
                            r2.setTextColor(getResources().getColor(R.color.red));
                            r3.setTextColor(getResources().getColor(R.color.red));
                            r4.setTextColor(getResources().getColor(R.color.red));
                        }
                    });
                    r2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            r2.setTextColor(getResources().getColor(R.color.red));
                        }
                    });
                    r3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            r3.setTextColor(getResources().getColor(R.color.red));
                        }
                    });
                    r4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            r4.setTextColor(getResources().getColor(R.color.red));
                        }
                    });
                }
            }
        });
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                videoView.start();
                if (mediaController==null){
                    mediaController=new MediaController(MainActivity3.this);
                    videoView.setMediaController(mediaController);
                    mediaController.setAnchorView(videoView);

                }
            }
        });
        videoView.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mediaPlayer, int i, int i1) {
                Toast.makeText(MainActivity3.this, "hata", Toast.LENGTH_SHORT).show();
                return false;
            }
        });


    }
}