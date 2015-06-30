package com.tfalmd.theroadsofar.finale.choosewisely;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.LocalBroadcastManager;
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
import com.tfalmd.theroadsofar.finale.choosewisely.model.Message;
import com.tfalmd.theroadsofar.finale.choosewisely.model.Power;
import com.tfalmd.theroadsofar.finale.choosewisely.model.dao.HeroDao;
import com.tfalmd.theroadsofar.finale.choosewisely.model.dao.MessageDao;
import com.tfalmd.theroadsofar.finale.choosewisely.model.dao.PowerDao;
import com.tfalmd.theroadsofar.finale.choosewisely.service.MessageService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class MainActivity extends ActionBarActivity implements RegisterDialog.RegisterListiner {
    private HeroDao hd = new HeroDao(this);
    private PowerDao pd = new PowerDao(this);
    private MessageDao md = new MessageDao(this);
    private List<Power> powers = new ArrayList<Power>();
    private PendingIntent resultPendingIntent;
    private static int notificationCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startNotification();

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

                hd.update(h);

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
            case R.id.action_logout:
                Bundle extras = getIntent().getExtras();
                extras.putString("user", "");
                Intent login = new Intent(this, LogInActivity.class);
                startActivity(login);
                return true;
            case R.id.action_about:
                Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent);
                return true;
            case R.id.action_ranking:
                Intent ranking = new Intent(this, RankingActivity.class);
                startActivity(ranking);
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

    private void startNotification() {
        Intent serviceIntent = new Intent(this, MessageService.class);
        startService(serviceIntent);
        setupBroadcastReceiver();
    }

    private void setupBroadcastReceiver() {
        LocalBroadcastManager bManager = LocalBroadcastManager.getInstance(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("MESSAGE");
        bManager.registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if (intent.getAction().equals("MESSAGE")) {
                    Bundle e = intent.getExtras();
                    onReceiveMessage(e.getString("author"));
                }
            }
        }, intentFilter);
    }

    private void onReceiveMessage(String author) {
        try {
            Message m = md.find(author);
            notifyPhone(m);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    private void notifyPhone(Message m) {
        int idNotification = m.getId();

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);
        mBuilder.setSmallIcon(android.R.drawable.ic_dialog_email);
        mBuilder.setContentTitle(m.getAuthor());
        mBuilder.setContentText(m.getMessage());

        Intent resultIntent = new Intent(this, MessageActivity.class);
        resultIntent.putExtra("author", m.getAuthor());
        resultIntent.putExtra("message", m.getMessage());
        resultIntent.putExtra("image", m.getImage());

        resultPendingIntent = PendingIntent.getActivity(getApplicationContext(), notificationCounter++, resultIntent, 0);
        mBuilder.setContentIntent(resultPendingIntent);

        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mBuilder.setAutoCancel(true);
        mNotificationManager.notify(idNotification, mBuilder.build());
    }
}