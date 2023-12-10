package com.example.listviewimage;

class ListViewAdapterMenu {
    private String NamaItem, HargaItem, Deskripsi, NomorHP, Lat, Long;
    private int Gambar;

    public ListViewAdapterMenu(String NamaItem, String HargaItem, String Deskripsi, int Gambar, String NomorHP, String Lat, String Long) {
        this.NamaItem = NamaItem;
        this.HargaItem = HargaItem;
        this.Deskripsi = Deskripsi;
        this.Gambar = Gambar;
        this.NomorHP = NomorHP;
        this.Lat = Lat;
        this.Long = Long;


    }

    public String getNamaItem() {
        return this.NamaItem;
    }

    public String getHargaItem() {
        return this.HargaItem;
    }

    public String getDeskripsi() {
        return this.Deskripsi;
    }

    public int getGambar() {
        return this.Gambar;
    }

    public String getNomorHP() {
        return this.NomorHP;
    }

    public String getLat() {
        return this.Lat;
    }

    public String getLong() {
        return this.Long;
    }
}