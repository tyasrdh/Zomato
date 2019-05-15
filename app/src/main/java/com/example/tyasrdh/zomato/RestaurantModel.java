package com.example.tyasrdh.zomato;

public class RestaurantModel {
    String nama_restaurant;
    String lokasi;
    String harga;
    String imageUrl;
    public String getNama_restaurant() {
        return nama_restaurant;
    }

    public void setNama_restaurant(String nama_restaurant) {
        this.nama_restaurant = nama_restaurant;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getImageURL() {
        return imageUrl;
    }

    public void setImageURL(String imageUrl) {
        this.imageUrl= imageUrl;
    }
}
