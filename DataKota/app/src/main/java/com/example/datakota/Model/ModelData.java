package com.example.datakota.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelData {

    @SerializedName("id_kota")
    @Expose
    private String SNid;

    @SerializedName("nama_kota")
    @Expose
    private String SNnamakota;

    public static final String namakota = "ID KOTA";
    public static final String id = "ID KOTA";

    public ModelData(String SNid, String SNnamakota) {
        this.SNid = SNid;
        this.SNnamakota = SNnamakota;
    }

    public String getSNid() {
        return SNid;
    }

    public void setSNid(String SNid) {
        this.SNid = SNid;
    }

    public String getSNnamakota() {
        return SNnamakota;
    }

    public void setSNnamakota(String SNnamakota) {
        this.SNnamakota = SNnamakota;
    }
}
