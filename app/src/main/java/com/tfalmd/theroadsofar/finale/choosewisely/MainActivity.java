package com.tfalmd.theroadsofar.finale.choosewisely;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.tfalmd.theroadsofar.finale.choosewisely.dialog.RegisterDialog;
import com.tfalmd.theroadsofar.finale.choosewisely.model.Hero;
import com.tfalmd.theroadsofar.finale.choosewisely.model.Power;
import com.tfalmd.theroadsofar.finale.choosewisely.model.dao.HeroDao;
import com.tfalmd.theroadsofar.finale.choosewisely.model.dao.PowerDao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class MainActivity extends ActionBarActivity implements RegisterDialog.RegisterListiner {

    private HeroDao hd = new HeroDao(this);
    private PowerDao pd = new PowerDao(this);
    private List<Power> powers = new ArrayList<Power>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.btnChoose);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                powers = pd.all();

                Collections.shuffle(powers);

                Bundle extras = getIntent().getExtras();

                Hero h = hd.find(extras.getString("user"));
                h.setHasId(powers.get(0).getId());

                TextView name = (TextView) findViewById(R.id.tvPower);
                TextView adv = (TextView) findViewById(R.id.tvAdvT);
                TextView dis = (TextView) findViewById(R.id.tvDisT);
                RatingBar util = (RatingBar) findViewById(R.id.ratingBar);
                ImageView iv = (ImageView) findViewById(R.id.ivChoose);

                name.setText(powers.get(0).getName());
                adv.setText(powers.get(0).getAdvantage());
                dis.setText(powers.get(0).getDisadvantage());
                util.setRating(powers.get(0).getUtility());

                try {
                    Bitmap bm = BitmapFactory.decodeStream(getAssets().open(powers.get(0).getImageFile()));
                    iv.setImageBitmap(bm);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_register:
                RegisterDialog rd = new RegisterDialog();
                rd.show(getFragmentManager(), null);
                return true;
            case R.id.action_about:
                Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onDialogPositiveClick(String name) {
        Hero h = new Hero(0, name, 0);
        hd.create(h);
    }
}