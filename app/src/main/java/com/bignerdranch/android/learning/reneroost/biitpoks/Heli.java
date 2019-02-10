package com.bignerdranch.android.learning.reneroost.biitpoks;

public class Heli {

    private String failiAadress;
    private String nimi;
    private Integer heliId;

    public Heli(String varaTee) {
        this.failiAadress = varaTee;
        String[] komponendid = varaTee.split("/");
        String failinimi = komponendid[komponendid.length - 1];
        nimi = failinimi.replace(".wav", "");
    }

    public String saaAadress() {
        return failiAadress;
    }

    public String saaNimi() {
        return nimi;
    }

    public Integer saaHeliId() {
        return heliId;
    }

    public void maaraHeliId(int heliId) {
        this.heliId = heliId;
    }
}
