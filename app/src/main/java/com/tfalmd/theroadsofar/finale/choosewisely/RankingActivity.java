package com.tfalmd.theroadsofar.finale.choosewisely;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
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

        RankingAdapter ra = new RankingAdapter(heroes, powers, getLayoutInflater(), getApplicationContext());

        ListView lv = (ListView) findViewById(R.id.lvRanking);
        lv.setAdapter(ra);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_about:
                Intent intent = new Intent(this, AboutActivity.class);
                startActivity(intent);
                return true;
            case R.id.action_logout:
                Bundle extras = getIntent().getExtras();
                extras.putString("user", "");
                Intent login = new Intent(this, LogInActivity.class);
                startActivity(login);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}