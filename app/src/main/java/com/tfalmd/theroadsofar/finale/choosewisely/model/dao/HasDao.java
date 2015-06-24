package com.tfalmd.theroadsofar.finale.choosewisely.model.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.tfalmd.theroadsofar.finale.choosewisely.model.Has;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tfalmd on 24/06/15.
 */
public class HasDao extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "choosev1";
    private static final int DATABASE_VERSION = 1;

    public HasDao(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE has (id INTEGER PRIMARY KEY AUTOINCREMENT, powerId INT, heroId INT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS has");
        onCreate(db);
    }

    public void create(Has has) {
        ContentValues values = new ContentValues();
        values.put("powerId", has.getPowerId());
        values.put("heroId", has.getHeroId());

        SQLiteDatabase db = this.getWritableDatabase();
        db.insert("has", null, values);

        db.close();
    }

    public List<Has> all() {
        List<Has> result = new ArrayList<Has>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT  * FROM has", null);

        if (cursor.moveToFirst()) {
            do {
                result.add(new Has(cursor.getInt(0), cursor.getInt(1), cursor.getInt(2)));
            } while (cursor.moveToNext());
        }

        db.close();
        return result;
    }

    public Has find(int id) {
        Has result = null;

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query("has", new String[]{"id, powerId", "heroId"}, "id=?",
                new String[]{String.valueOf(id)}, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            result = new Has(cursor.getInt(0), cursor.getInt(1), cursor.getInt(2));
        }

        db.close();

        return result;
    }
}
