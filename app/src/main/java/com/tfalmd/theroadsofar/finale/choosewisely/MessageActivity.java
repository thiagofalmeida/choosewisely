package com.tfalmd.theroadsofar.finale.choosewisely;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
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
}
