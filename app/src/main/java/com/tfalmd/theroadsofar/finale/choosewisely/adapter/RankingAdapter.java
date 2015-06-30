package com.tfalmd.theroadsofar.finale.choosewisely.adapter;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by tfalmd on 24/06/15.
 */
public class RankingAdapter extends BaseAdapter {
    private final Context context;
    private List<Hero> heroes;
    private LayoutInflater inflater;
    private List<Power> powers;

    public RankingAdapter(List<Hero> heroes, List<Power> powers, LayoutInflater inflater, Context context) {
        this.heroes = heroes;
        this.inflater = inflater;
        this.powers = powers;
        this.context = context;
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

        View v = inflater.inflate(R.layout.ranking_adapter, null);

        TextView name = (TextView) v.findViewById(R.id.tvRName);
        TextView power = (TextView) v.findViewById(R.id.tvRPower);
        RatingBar rb = (RatingBar) v.findViewById(R.id.rbRanking);
        ImageView thumb = (ImageView) v.findViewById(R.id.ivThumb);

        for(Power p : powers) {
            if (temp.getHasId() == p.getId()) {
                name.setText(temp.getName());
                power.setText(p.getName());
                rb.setRating(p.getUtility());

                try {
                    AssetManager am = context.getAssets();
                    InputStream is = am.open(p.getImageFile());
                    Bitmap bm = BitmapFactory.decodeStream(is);
                    thumb.setImageBitmap(bm);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return v;
    }
}