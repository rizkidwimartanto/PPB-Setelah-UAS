package com.example.tugas_akhir_p_tahap1_art2.model_ruqyah;

public class ModelDashboard {
    private String namaMenu;
    private String namaLayanan;
    private int namaDeskripsi;
    private int gambarMenu;
    private int gambarLayanan;
    private int gambarDeskripsi;

    public ModelDashboard() {
    }

    public ModelDashboard(String namaMenu, String namaLayanan, int namaDeskripsi, int gambarMenu, int gambarLayanan, int gambarDeskripsi) {
        this.namaMenu = namaMenu;
        this.namaLayanan = namaLayanan;
        this.namaDeskripsi = namaDeskripsi;
        this.gambarMenu = gambarMenu;
        this.gambarLayanan = gambarLayanan;
        this.gambarDeskripsi = gambarDeskripsi;
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

    public int getNamaDeskripsi() {
        return namaDeskripsi;
    }

    public void setNamaDeskripsi(int namaDeskripsi) {
        this.namaDeskripsi = namaDeskripsi;
    }

    public int getGambarDeskripsi() {
        return gambarDeskripsi;
    }

    public void setGambarDeskripsi(int gambarDeskripsi) {
        this.gambarDeskripsi = gambarDeskripsi;
    }
}
