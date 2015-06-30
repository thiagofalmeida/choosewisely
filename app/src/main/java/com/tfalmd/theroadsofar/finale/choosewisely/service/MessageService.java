package com.tfalmd.theroadsofar.finale.choosewisely.service;

import android.app.IntentService;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;

import com.tfalmd.theroadsofar.finale.choosewisely.model.Message;
import com.tfalmd.theroadsofar.finale.choosewisely.model.dao.MessageDao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by tfalmd on 26/06/15.
 */
public class MessageService extends IntentService {
    private boolean isRunning = true;
    private MessageDao md = new MessageDao(this);
    private List<Message> messages = new ArrayList<Message>();

    public MessageService() {
        super("Message Service");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        synchronized (this){
            while(isRunning){
                messages = md.all();

                Collections.shuffle(messages);

                int id = messages.get(1).getId();
                String message = messages.get(1).getMessage();
                String author = messages.get(1).getAuthor();
                String image = messages.get(1).getImage();

                Intent i = new Intent("MESSAGE");
                i.putExtra("id", id);
                i.putExtra("message", message);
                i.putExtra("author", author);
                i.putExtra("image", image);

                LocalBroadcastManager.getInstance(this).sendBroadcast(i);

                try{
                    wait(15000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void onDestroy() {
        isRunning = false;
        super.onDestroy();
    }
}
