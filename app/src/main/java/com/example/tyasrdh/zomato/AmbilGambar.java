package com.example.tyasrdh.zomato;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class AmbilGambar extends AsyncTask<String, Void, Bitmap> {
    ImageView kategori_image;
    public AmbilGambar(ImageView kategori_image) {
        this.kategori_image = kategori_image;
    }

    @Override
    protected Bitmap doInBackground(String... strings) {
        String urlImage = strings[0];
        Bitmap bitmap = null;

        InputStream inputStream = null;
        try{
            inputStream = new URL(urlImage).openStream();
            bitmap = BitmapFactory.decodeStream(inputStream);
        } catch (IOException e ){
            Log.e("Error",e.getMessage());
        }
        return bitmap;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        kategori_image.setImageBitmap(bitmap);
    }
}
