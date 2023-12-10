package com.example.listviewimage;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Menu_Detail_Makanan extends Activity {

    String HargaItem, NamaItem, Deskripsi, NomorHP, Lat, Long;
    int Gambar;
    int position;
    TextView tvHarga, tvNamaItem, tvDeskripsi, tvNomorHP;
    ImageView ImgGembar;
    Button btnPesan, btnMap;

    @Override
    public void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_detail_makanan);

        tvHarga		    = (TextView)findViewById(R.id.textView1);
        tvNamaItem		= (TextView)findViewById(R.id.textView2);
        tvDeskripsi		= (TextView)findViewById(R.id.textView3);
        ImgGembar		= (ImageView)findViewById(R.id.imageView1);
        tvNomorHP		= (TextView)findViewById(R.id.textView);
        btnPesan		    = (Button)findViewById(R.id.button);
        btnMap		    = (Button)findViewById(R.id.button2);

        Intent i 		= getIntent();
        position 		= i.getExtras().getInt("position");
        HargaItem		= i.getStringExtra("HargaItem");
        NamaItem		= i.getStringExtra("NamaItem");
        Deskripsi	 	= i.getStringExtra("Deskripsi");
        NomorHP 	 	= i.getStringExtra("NomorHP");
        Gambar			= i.getIntExtra("Gambar", Gambar);
        Lat 	 	    = i.getStringExtra("Lat");
        Long 	 	    = i.getStringExtra("Long");

        tvHarga.setText(HargaItem);
        tvNamaItem.setText(NamaItem);
        tvDeskripsi.setText(Deskripsi);
        tvNomorHP.setText(NomorHP);
        ImgGembar.setImageResource(Gambar);

        btnPesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i;
                i = new Intent(Intent.ACTION_VIEW, Uri.parse(
                        "https://api.whatsapp.com/send?phone="+NomorHP+"&text=Saya memesan makanan : \n"+NamaItem+"\n\nSebanyak :"));
                startActivity(i);


            }
        });

        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Uri gmmIntentUri = Uri.parse("google.navigation:q="+Lat+","+Long);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                if (mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mapIntent);
                }

            }
        });

    }
}