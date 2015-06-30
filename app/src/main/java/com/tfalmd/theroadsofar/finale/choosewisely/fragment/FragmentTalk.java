package com.tfalmd.theroadsofar.finale.choosewisely.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.tfalmd.theroadsofar.finale.choosewisely.R;

import java.util.Random;

public class FragmentTalk extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_talk, container, false);
        ImageView iv = (ImageView) v.findViewById(R.id.ivFragment);

        Random r = new Random();

        if ((r.nextInt() % 4) == 0) {
            iv.setImageResource(R.drawable.imbatman);
        } else {
            iv.setImageResource(R.drawable.right);
        }

        return v;
    }
}