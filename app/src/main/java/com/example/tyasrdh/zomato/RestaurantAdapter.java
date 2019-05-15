package com.example.tyasrdh.zomato;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class RestaurantAdapter extends ArrayAdapter<RestaurantModel> {
    Context context;
    int resource;

    public RestaurantAdapter(Context context, int resource) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        RestaurantAdapter.Holder holder = null;

        if (convertView == null) {
            holder = new RestaurantAdapter.Holder();
            convertView = LayoutInflater.from(context).inflate(resource, parent, false);
            holder.text_nama_restaurant = convertView.findViewById(R.id.text_nama_restaurant);
            holder.text_lokasi = convertView.findViewById(R.id.text_lokasi);
            holder.text_harga = convertView.findViewById(R.id.text_harga);
            holder.imageHeader2 = convertView.findViewById(R.id.imageHeader2);
            holder.restaurantLayout= convertView.findViewById(R.id.restaurantLayout);
            convertView.setTag(holder);
        } else {
            holder = (RestaurantAdapter.Holder) convertView.getTag();
        }
        holder.text_nama_restaurant.setText(getItem(position).getNama_restaurant());
        holder.text_lokasi.setText(getItem(position).getLokasi());
        holder.text_harga.setText(getItem(position).getHarga() + " per dua orang (approx)");


        holder.restaurantLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("URL", getItem(position).getImageURL());
                context.startActivity(intent);
            }
        });

        new AmbilGambar(holder.imageHeader2).execute(new String[]{getItem(position).getImageURL()});
        return convertView;
    }
    class Holder{
        TextView text_nama_restaurant,text_lokasi,text_harga;
        ImageView imageHeader2;
        LinearLayout restaurantLayout;
    }
}
