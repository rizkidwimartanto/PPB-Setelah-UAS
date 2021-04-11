package com.example.tugas_akhir_p_tahap1_art2.model_ruqyah;

public class ModelPeruqyah {
    private String id, nama, alamat, no_hp, photo;

    public ModelPeruqyah() {
    }

    public ModelPeruqyah(String id, String nama, String alamat, String no_hp, String photo) {
        this.id = id;
        this.nama = nama;
        this.alamat = alamat;
        this.no_hp = no_hp;
        this.photo = photo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNo_hp() {
        return no_hp;
    }

    public void setNo_hp(String no_hp) {
        this.no_hp = no_hp;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
