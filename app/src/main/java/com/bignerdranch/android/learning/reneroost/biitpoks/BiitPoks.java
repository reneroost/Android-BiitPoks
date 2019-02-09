package com.bignerdranch.android.learning.reneroost.biitpoks;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BiitPoks {
    private static final String SILT = "BiitPoks";

    private static final String HELIDE_KAUST = "naite_helid";

    private AssetManager vara;
    private List<Heli> helid = new ArrayList<>();

    public BiitPoks(Context kontekst) {
        vara = kontekst.getAssets();
        laadiHelid();
    }

    private void laadiHelid() {
        String[] heliNimed;
        try{
            heliNimed = vara.list(HELIDE_KAUST);
            Log.w(SILT, "Leidsin " + heliNimed.length + " heli");
        } catch (IOException ioe) {
            Log.w(SILT, "Ei suutnud vara kätte saada", ioe);
            return;
        }

        for (String failinimi: heliNimed) {
            String heliTee = HELIDE_KAUST + "/" + failinimi;
            Heli heli = new Heli(heliTee);
            helid.add(heli);
        }
    }

    public List<Heli> saaHelid() {
        return helid;
    }

}
