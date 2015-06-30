package com.tfalmd.theroadsofar.finale.choosewisely;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;


public class MessageActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        TextView message = (TextView) findViewById(R.id.tvMessage);
        TextView author = (TextView) findViewById(R.id.tvAuthor);
        ImageView iv = (ImageView) findViewById(R.id.ivMessage);

        Bundle extras = getIntent().getExtras();

        Log.d("TESTANDO", "PRIMEIRo: " + extras.getString("image"));

        message.setText(extras.getString("message"));
        author.setText(extras.getString("author"));

        try {
            Bitmap bm = BitmapFactory.decodeStream(getAssets().open(extras.getString("image")));
            iv.setImageBitmap(bm);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
            case R.id.action_ranking:
                Intent ranking = new Intent(this, RankingActivity.class);
                startActivity(ranking);
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
