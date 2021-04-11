package com.example.tugas_akhir_p_tahap1_art2.model_ruqyah;

public class ModelAkun {
    private int id;
    private String nama, username, foto;

    public ModelAkun() {
    }

    public ModelAkun(int id, String nama, String username, String foto) {
        this.id = id;
        this.nama = nama;
        this.username = username;
        this.foto = foto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
