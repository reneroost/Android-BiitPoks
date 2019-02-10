package com.bignerdranch.android.learning.reneroost.biitpoks;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

public class HeliVaateMudel extends BaseObservable {
    private Heli heli;
    private final BiitPoks biitPoks;

    public HeliVaateMudel(BiitPoks biitPoks) {
        this.biitPoks = biitPoks;
    }

    @Bindable
    public String getPealkiri() {
        return heli.saaNimi();
    }

//    public Heli saaHeli() {
//        return heli;
//    }

    public void maaraHeli(Heli heli) {
        this.heli = heli;
        notifyChange();
    }

    public void onNuppVajutatud() {
        biitPoks.mangi(heli);
    }
}
