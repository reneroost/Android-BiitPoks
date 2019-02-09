package com.bignerdranch.android.learning.reneroost.biitpoks;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class BiitPoksActivity extends UheFragmendiActivity {
    @Override
    protected Fragment looFragment() {
        return BiitPoksFragment.uusInstants();
    }
}
