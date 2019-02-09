package com.bignerdranch.android.learning.reneroost.biitpoks;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public abstract class UheFragmendiActivity extends AppCompatActivity {

    protected abstract Fragment looFragment();

    protected int saaPaigutuseResId() {
        return R.layout.activity_fragment;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(saaPaigutuseResId());

        FragmentManager fragmendiHaldur = getSupportFragmentManager();
        Fragment fragment = fragmendiHaldur.findFragmentById(R.id.fragmendi_konteiner);

        if (fragment == null) {
            fragment = looFragment();
            fragmendiHaldur.beginTransaction()
                    .add(R.id.fragmendi_konteiner, fragment)
                    .commit();
        }

    }

}
