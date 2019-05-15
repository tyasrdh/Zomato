package com.example.tyasrdh.zomato;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView kategori;
    KategoriAdapter adapter;
    Resources res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        kategori = findViewById(R.id.kategori);
        adapter = new KategoriAdapter(this, R.layout.activity_kategori);
        kategori.setAdapter(adapter);
        res = getResources();
        initData();
    }

    private void initData() {
//        String[] title = new String[]{"Terpopuler Minggu Ini", "Sarapan Pagi", "Jajanan Malam",
//                             "Kopi Terbaik", "Untuk Si Pecinta Manis"};
//        String[] outlet = new String[]{"4", "4", "8", "2", "4"};
//        String[] desc = new String[]{"Restoran terpopuler di kotamu minggu ini", "Sajian sarapan nikmat untuk memulai harimu dengan semangat",
//                            "Karena lapar bisa datang kapan saja", "Lepaskan bebanmu disni dengan nikmatnya secangkir kopi", "Manjakan lidahmu dengan makanan manis ini"};
//        String[] imageUrl = new String[]{};
        String[] title = res.getStringArray(R.array.title);
        String[] outlet = res.getStringArray(R.array.outlet);
        String[] desc = res.getStringArray(R.array.desc);
        String[] imageURL = res.getStringArray(R.array.imageURL);

        for(int i=0; i< title.length;i++) {
            KategoriModel model = new KategoriModel();
            model.setTitle(title[i]);
            model.setOutlet(outlet[i]);
            model.setDesc(desc[i]);
            model.setImageUrl(imageURL[i]);
            adapter.add(model);
        }

        adapter.notifyDataSetChanged();
        for(int i=0; i< title.length;i++) {
            KategoriModel model = new KategoriModel();
            model.setTitle(title[i]);
            model.setOutlet(outlet[i]);
            model.setDesc(desc[i]);
            model.setImageUrl(imageURL[i]);
            adapter.add(model);
        }
        adapter.notifyDataSetChanged();
    }
}
