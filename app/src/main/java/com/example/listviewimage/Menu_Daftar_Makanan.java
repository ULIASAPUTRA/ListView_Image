package com.example.listviewimage;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Locale;

public class Menu_Daftar_Makanan extends AppCompatActivity {

    ListView lvItem;
    EditText Edtcari;
    ListViewAdapterCall adapter;
    ArrayList<ListViewAdapterMenu> arraylist = new ArrayList<ListViewAdapterMenu>();

    int[] Gambar;
    String[] NamaItem;
    String[] HargaItem;
    String[] Deskripsi;
    String[] NomorHP;
    String[] Lat;
    String[] Long;

    @Override
    public void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_daftar_makanan);

        lvItem		= (ListView)findViewById(R.id.listView1);
        Edtcari     = (EditText)findViewById(R.id.editText1);


        Gambar		= new int[]{
                R.mipmap.a_tumisbungapepaya,
                R.mipmap.b_lawarikan,
                R.mipmap.c_jagungbose,
                R.mipmap.d_seisapi,
                R.mipmap.e_jagungtiti};

        NamaItem 	= new String[]{
                "Sayur Tumis Pepaya",
                "Lawar Ikan",
                "Jagung Bose",
                "Sei Sapi",
                "Jagung Titi"};

        HargaItem 	= new String[]{
                "Rp. 25.000",
                "Rp. 50.000",
                "Rp. 100.000",
                "Rp. 125.000",
                "Rp. 50.000"};

        Deskripsi 	= new String[]{
                "Sayur tumis pepaya merupakan makanan khas daerah NTT, dimana sayur ini tidak memiliki " +
                        "rasa pahit namun sangat nikmat dan manis bila disantap dengan ikan panggang " +
                        "atau menu makanan lainnya yang berkuah",

                "Lawar Ikan merupakan makanan semi lombok yang diberikan cuka, bawang merah, garam, dan ikan alus untuk " +
                        "dimakan bersama lauk pauk lainnya",

                "Jagung bose adalah makanan khas daerah Timor",

                "Sei sapi enak dan bergizi tinggi, dikelola dengan cara diasapi",

                "Jagung titi enaknya!"};


        //Nomor HP harus dimulai dengan kode negara yaitu : +62
        NomorHP  = new String[]{
                "+6281615444433",
                "+6281324607225",
                "+6281615444433",
                "+6281324607225",
                "+6281324607225"
        };

        Lat  = new String[]{
                "-10.1760821",
                "-10.1768035",
                "-10.171799",
                "-10.1748536",
                "-10.1747994"
        };

        Long  = new String[]{
                "123.6235399",
                "123.6229451",
                "123.6285576",
                "123.6262513",
                "123.6261514"
        };


        for (int i = 0; i < NamaItem.length; i++)
        {
            ListViewAdapterMenu wp = new ListViewAdapterMenu(NamaItem[i], HargaItem[i], Deskripsi[i], Gambar[i], NomorHP[i], Lat[i], Long[i]);
            arraylist.add(wp);
        }

        adapter = new ListViewAdapterCall(this, arraylist);
        lvItem.setAdapter(adapter);

        Edtcari.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable arg0) {
                String text = Edtcari.getText().toString().toLowerCase(Locale.getDefault());
                adapter.filter(text);
                showToastMessage("Pencarian dilakukan");
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
                // TODO Auto-generated method stub
            }
            @Override
            public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
                // TODO Auto-generated method stub
            }
        });

    }

    void showToastMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}
