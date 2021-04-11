package com.example.tugas_akhir_tahap_1;

public class Model {
    private String namaMenu;
    private String namaLayanan;
    private String namaDeskripsi;
    private int gambarDeskripsi;
    private int gambarMenu;
    private int gambarLayanan;

    public Model() {
    }

    public Model(String namaMenu, String namaLayanan, int gambarMenu, int gambarLayanan) {
        this.namaMenu = namaMenu;
        this.namaLayanan = namaLayanan;
        this.gambarMenu = gambarMenu;
        this.gambarLayanan = gambarLayanan;
    }

    public String getNamaMenu() {
        return namaMenu;
    }

    public void setNamaMenu(String namaMenu) {
        this.namaMenu = namaMenu;
    }

    public String getNamaLayanan() {
        return namaLayanan;
    }

    public void setNamaLayanan(String namaLayanan) {
        this.namaLayanan = namaLayanan;
    }

    public int getGambarMenu() {
        return gambarMenu;
    }

    public void setGambarMenu(int gambarMenu) {
        this.gambarMenu = gambarMenu;
    }

    public int getGambarLayanan() {
        return gambarLayanan;
    }

    public void setGambarLayanan(int gambarLayanan) {
        this.gambarLayanan = gambarLayanan;
    }

    public String getNamaDeskripsi() {
        return namaDeskripsi;
    }

    public void setNamaDeskripsi(String namaDeskripsi) {
        this.namaDeskripsi = namaDeskripsi;
    }

    public int getGambarDeskripsi() {
        return gambarDeskripsi;
    }

    public void setGambarDeskripsi(int gambarDeskripsi) {
        this.gambarDeskripsi = gambarDeskripsi;
    }
}
