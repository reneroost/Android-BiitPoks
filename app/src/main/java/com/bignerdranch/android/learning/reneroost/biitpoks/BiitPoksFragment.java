package com.bignerdranch.android.learning.reneroost.biitpoks;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.android.learning.reneroost.biitpoks.databinding.FragmentBiitPoksBinding;
import com.bignerdranch.android.learning.reneroost.biitpoks.databinding.NimekirjaUksusHeliBinding;

import java.util.List;
import java.util.Objects;

public class BiitPoksFragment extends Fragment {

    BiitPoks biitPoks;

    public static BiitPoksFragment uusInstants() {
        return new BiitPoksFragment();
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

        biitPoks = new BiitPoks(Objects.requireNonNull(getActivity()));
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater taispuhuja, ViewGroup konteiner, Bundle savedInstanceState) {
        FragmentBiitPoksBinding sidumine = DataBindingUtil.inflate(taispuhuja, R.layout.fragment_biit_poks,
                konteiner, false);

        sidumine.taaskasutajaVaade.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        sidumine.taaskasutajaVaade.setAdapter(new HeliAdapter(biitPoks.saaHelid()));
        sidumine.setVaateMudel(biitPoks);
        return sidumine.getRoot();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        biitPoks.vabasta();
    }

    private class HeliHoidja extends RecyclerView.ViewHolder {
        private final NimekirjaUksusHeliBinding sidumine;

        private HeliHoidja(NimekirjaUksusHeliBinding sidumine) {
            super(sidumine.getRoot());
            this.sidumine = sidumine;
            sidumine.setVaateMudel(new HeliVaateMudel(biitPoks));
        }

        public void bind(Heli heli) {
            sidumine.getVaateMudel().maaraHeli(heli);
            sidumine.executePendingBindings();
        }
    }

    private class HeliAdapter extends RecyclerView.Adapter<HeliHoidja> {
        private final List<Heli> helid;

        public HeliAdapter(List<Heli> helid) {
            this.helid = helid;
        }

        @NonNull
        @Override
        public HeliHoidja onCreateViewHolder(@NonNull ViewGroup vanem, int i) {
            LayoutInflater taispuhuja = LayoutInflater.from(getActivity());
            NimekirjaUksusHeliBinding sidumine = DataBindingUtil
                    .inflate(taispuhuja, R.layout.nimekirja_uksus_heli, vanem, false);
            return new HeliHoidja(sidumine);
        }

        @Override
        public void onBindViewHolder(@NonNull HeliHoidja heliHoidja, int positsioon) {
            Heli heli = helid.get(positsioon);
            heliHoidja.bind(heli);
        }

        @Override
        public int getItemCount() {
            return helid.size();
        }
    }
}
