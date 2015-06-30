package com.tfalmd.theroadsofar.finale.choosewisely.model.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.tfalmd.theroadsofar.finale.choosewisely.model.Message;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tfalmd on 26/06/15.
 */
public class MessageDao extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "choosev1";
    private static final int DATABASE_VERSION = 1;

    public MessageDao(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {}

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS messages");
        onCreate(db);
    }

    public Message find(String author) {
        Message result = null;

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query("messages", new String[]{"id", "message", "author, image"}, "author=?",
                new String[]{String.valueOf((author))}, null, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            result = new Message(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));
        }

        db.close();

        return result;
    }

    public List<Message> all() {
        List<Message> result = new ArrayList<Message>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM messages", null);

        if (cursor.moveToFirst()) {
            do {
                result.add(new Message(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3)));
            } while (cursor.moveToNext());
        }

        db.close();
        return result;
    }
}