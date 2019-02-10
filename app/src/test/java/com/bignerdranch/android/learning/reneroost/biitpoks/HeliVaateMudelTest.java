package com.bignerdranch.android.learning.reneroost.biitpoks;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class HeliVaateMudelTest {
    private BiitPoks biitPoks;
    private Heli heli;
    private HeliVaateMudel subjekt;

    @Before
    public void setUp() throws Exception {
        biitPoks = mock(BiitPoks.class);
        heli = new Heli("varaTee");
        subjekt = new HeliVaateMudel(biitPoks);
        subjekt.maaraHeli(heli);
    }

    @Test
    public void valjastabHeliNimesidPealkirjadena() {
        assertThat(subjekt.getPealkiri(), is(heli.saaNimi()));
    }

    @Test
    public void kutsubBiitPoksMangiOnNupuVajutatud() {
        subjekt.onNuppVajutatud();

        verify(biitPoks).mangi(heli);
    }
}