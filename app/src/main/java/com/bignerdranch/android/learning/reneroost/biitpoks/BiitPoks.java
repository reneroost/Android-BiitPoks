package com.bignerdranch.android.learning.reneroost.biitpoks;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BiitPoks {
    private static final String SILT = "BiitPoks";

    private static final String HELIDE_KAUST = "naite_helid";
    private static final int MAKSIMUM_HELISID = 5;

    private AssetManager vara;
    private List<Heli> helid = new ArrayList<>();
    private SoundPool heliBassein;

    public BiitPoks(Context kontekst) {
        vara = kontekst.getAssets();
        heliBassein = new SoundPool(MAKSIMUM_HELISID, AudioManager.STREAM_MUSIC, 0);
        laadiHelid();
    }

    public void mangi(Heli heli) {
        Integer heliId = heli.saaHeliId();
        if (heliId == null) {
            return;
        }
        heliBassein.play(heliId, 1.0f, 1.0f, 1, 0, 1.0f);
    }

    public void vabasta() {
        heliBassein.release();
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
            try {
                String heliTee = HELIDE_KAUST + "/" + failinimi;
                Heli heli = new Heli(heliTee);
                laadi(heli);
                helid.add(heli);
            } catch (IOException ioe) {
                Log.e(SILT, "Ei suutnud laadida helifaili " + failinimi, ioe);
            }
        }
    }

    private void laadi(Heli heli) throws IOException {
        AssetFileDescriptor afd = vara.openFd(heli.saaAadress());
        int heliId = heliBassein.load(afd, 1);
        heli.maaraHeliId(heliId);
    }

    public List<Heli> saaHelid() {
        return helid;
    }

}
