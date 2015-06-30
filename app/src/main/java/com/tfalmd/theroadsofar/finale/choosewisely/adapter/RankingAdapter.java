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
import com.tfalmd.theroadsofar.finale.choosewisely.model.Power;

import java.util.List;

/**
 * Created by tfalmd on 24/06/15.
 */
public class RankingAdapter extends BaseAdapter {
    private List<Hero> heroes;
    private LayoutInflater inflater;
    private List<Power> powers;

    public RankingAdapter(List<Hero> heroes, List<Power> powers, LayoutInflater inflater) {
        this.heroes = heroes;
        this.inflater = inflater;
        this.powers = powers;
    }

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
        //Power pTemp = powers.get(position);

        View v = inflater.inflate(R.layout.ranking_adapter, null);

        TextView name = (TextView) v.findViewById(R.id.tvRName);
        TextView power = (TextView) v.findViewById(R.id.tvRPower);
        RatingBar rb = (RatingBar) v.findViewById(R.id.rbRanking);
        ImageView thumb = (ImageView) v.findViewById(R.id.ivThumb);

        name.setText(temp.getName());

        //Log.d("TESTANDO", "chegou ate aqui");

        for(Power p : powers) {
            //Log.d("TESTANDO", "LIST VIEW1 " + p.getName());
            if (temp.getHasId() == p.getId()) {
                //Log.d("TESTANDO", "LIST VIEW2 " + p.getName());
                power.setText(p.getName());
                rb.setRating(p.getUtility());
            }
        }

        return v;
    }

}
