package com.tfalmd.theroadsofar.finale.choosewisely.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.tfalmd.theroadsofar.finale.choosewisely.R;
import com.tfalmd.theroadsofar.finale.choosewisely.model.Hero;

import java.util.ArrayList;

/**
 * Created by tfalmd on 24/06/15.
 */
public class RankingAdapter extends BaseAdapter {
    private ArrayList<Hero> heroes;
    private LayoutInflater inflater;

    @Override
    public int getCount() {
        return heroes.size();
    }

    @Override
    public Object getItem(int position) {
        return heroes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Hero temp = heroes.get(position);
        View v = inflater.inflate(R.layout.ranking_adapter, null);

        TextView name = (TextView) v.findViewById(R.id.tvRName);
        TextView power = (TextView) v.findViewById(R.id.tvRPower);
        RatingBar rb = (RatingBar) v.findViewById(R.id.rbRanking);
        ImageView thumb = (ImageView) v.findViewById(R.id.ivThumb);

        name.setText(temp.getName());
        // BUSCAR NOME DO PODER, UTILIDADE E IMAGEM

        return v;
    }

}
