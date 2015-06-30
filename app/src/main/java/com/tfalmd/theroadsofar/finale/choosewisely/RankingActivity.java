package com.tfalmd.theroadsofar.finale.choosewisely;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;

import com.tfalmd.theroadsofar.finale.choosewisely.adapter.RankingAdapter;
import com.tfalmd.theroadsofar.finale.choosewisely.model.Hero;
import com.tfalmd.theroadsofar.finale.choosewisely.model.Power;
import com.tfalmd.theroadsofar.finale.choosewisely.model.dao.HeroDao;
import com.tfalmd.theroadsofar.finale.choosewisely.model.dao.PowerDao;

import java.util.ArrayList;
import java.util.List;


public class RankingActivity extends ActionBarActivity {
    private HeroDao hd = new HeroDao(this);
    private PowerDao pd = new PowerDao(this);
    private List<Power> powers = new ArrayList<Power>();
    private List<Hero> heroes = new ArrayList<Hero>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        powers = pd.all();
        heroes = hd.all();

        RankingAdapter ra = new RankingAdapter(heroes, powers, getLayoutInflater());

        ListView lv = (ListView) findViewById(R.id.lvRanking);
        lv.setAdapter(ra);
    }
}