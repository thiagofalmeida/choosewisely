package com.tfalmd.theroadsofar.finale.choosewisely.model.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.tfalmd.theroadsofar.finale.choosewisely.model.Hero;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tfalmd on 24/06/15.
 */
public class HeroDao extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "choosev1";
    private static final int DATABASE_VERSION = 1;

    public HeroDao(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE heroes (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, hasId INT)");
        db.execSQL("CREATE TABLE powers (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, advantage TEXT, disadvantage TEXT, utility INT, imageFile TEXT)");

        db.execSQL("INSERT INTO powers (name, advantage, disadvantage, utility, imageFile) VALUES ('Tecnocinese', 'vantagem', 'tela azul', 3, 'tecnocinese.png')");
        db.execSQL("INSERT INTO powers (name, advantage, disadvantage, utility, imageFile) VALUES ('Tecnocinese', 'vantagem', 'tela azul', 3, 'hidrocinese.png')");
        db.execSQL("INSERT INTO powers (name, advantage, disadvantage, utility, imageFile) VALUES ('Tecnocinese', 'vantagem', 'tela azul', 3, 'gordura.png')");
        db.execSQL("INSERT INTO powers (name, advantage, disadvantage, utility, imageFile) VALUES ('Tecnocinese', 'vantagem', 'tela azul', 3, 'alone.png')");
        db.execSQL("INSERT INTO powers (name, advantage, disadvantage, utility, imageFile) VALUES ('Tecnocinese', 'vantagem', 'tela azul', 3, 'pirocinese.png')");
        db.execSQL("INSERT INTO powers (name, advantage, disadvantage, utility, imageFile) VALUES ('Tecnocinese', 'vantagem', 'tela azul', 3, 'absorcao.png')");
        db.execSQL("INSERT INTO powers (name, advantage, disadvantage, utility, imageFile) VALUES ('Tecnocinese', 'vantagem', 'tela azul', 3, 'aderencia.png')");
        db.execSQL("INSERT INTO powers (name, advantage, disadvantage, utility, imageFile) VALUES ('Tecnocinese', 'vantagem', 'tela azul', 3, 'botao.png')");
        db.execSQL("INSERT INTO powers (name, advantage, disadvantage, utility, imageFile) VALUES ('Tecnocinese', 'vantagem', 'tela azul', 3, 'choroacido.png')");
        db.execSQL("INSERT INTO powers (name, advantage, disadvantage, utility, imageFile) VALUES ('Tecnocinese', 'vantagem', 'tela azul', 3, 'fatorcura.png')");
        db.execSQL("INSERT INTO powers (name, advantage, disadvantage, utility, imageFile) VALUES ('Tecnocinese', 'vantagem', 'tela azul', 3, 'flatulencia.png')");
        db.execSQL("INSERT INTO powers (name, advantage, disadvantage, utility, imageFile) VALUES ('Tecnocinese', 'vantagem', 'tela azul', 3, 'gerarcampo.png')");
        db.execSQL("INSERT INTO powers (name, advantage, disadvantage, utility, imageFile) VALUES ('Tecnocinese', 'vantagem', 'tela azul', 3, 'gritosuper.png')");
        db.execSQL("INSERT INTO powers (name, advantage, disadvantage, utility, imageFile) VALUES ('Tecnocinese', 'vantagem', 'tela azul', 3, 'ilusionismo.png')");
        db.execSQL("INSERT INTO powers (name, advantage, disadvantage, utility, imageFile) VALUES ('Tecnocinese', 'vantagem', 'tela azul', 3, 'insanidade.png')");
        db.execSQL("INSERT INTO powers (name, advantage, disadvantage, utility, imageFile) VALUES ('Tecnocinese', 'vantagem', 'tela azul', 3, 'intangibilidade.png')");
        db.execSQL("INSERT INTO powers (name, advantage, disadvantage, utility, imageFile) VALUES ('Tecnocinese', 'vantagem', 'tela azul', 3, 'invisibilidade.png')");
        db.execSQL("INSERT INTO powers (name, advantage, disadvantage, utility, imageFile) VALUES ('Tecnocinese', 'vantagem', 'tela azul', 3, 'levitardireito.png')");
        db.execSQL("INSERT INTO powers (name, advantage, disadvantage, utility, imageFile) VALUES ('Tecnocinese', 'vantagem', 'tela azul', 3, 'velocidade.png')");
        db.execSQL("INSERT INTO powers (name, advantage, disadvantage, utility, imageFile) VALUES ('Tecnocinese', 'vantagem', 'tela azul', 3, 'pretrificacao.png')");
        db.execSQL("INSERT INTO powers (name, advantage, disadvantage, utility, imageFile) VALUES ('Tecnocinese', 'vantagem', 'tela azul', 3, 'raioxeterno.png')");
        db.execSQL("INSERT INTO powers (name, advantage, disadvantage, utility, imageFile) VALUES ('Tecnocinese', 'vantagem', 'tela azul', 3, 'superforca.png')");
        db.execSQL("INSERT INTO powers (name, advantage, disadvantage, utility, imageFile) VALUES ('Tecnocinese', 'vantagem', 'tela azul', 3, 'teletransporte.png')");
        db.execSQL("INSERT INTO powers (name, advantage, disadvantage, utility, imageFile) VALUES ('Tecnocinese', 'vantagem', 'tela azul', 3, 'toquedamorte.png')");
        db.execSQL("INSERT INTO powers (name, advantage, disadvantage, utility, imageFile) VALUES ('Tecnocinese', 'vantagem', 'tela azul', 3, 'transmutacao.png')");
        db.execSQL("INSERT INTO powers (name, advantage, disadvantage, utility, imageFile) VALUES ('Tecnocinese', 'vantagem', 'tela azul', 3, 'vijardimensoes.png')");
        db.execSQL("INSERT INTO powers (name, advantage, disadvantage, utility, imageFile) VALUES ('Tecnocinese', 'vantagem', 'tela azul', 3, 'visaoderaiox.png')");
        db.execSQL("INSERT INTO powers (name, advantage, disadvantage, utility, imageFile) VALUES ('Tecnocinese', 'vantagem', 'tela azul', 3, 'voar.png')");
        db.execSQL("INSERT INTO powers (name, advantage, disadvantage, utility, imageFile) VALUES ('Tecnocinese', 'vantagem', 'tela azul', 3, 'telepatia.png')");
        db.execSQL("INSERT INTO powers (name, advantage, disadvantage, utility, imageFile) VALUES ('Tecnocinese', 'vantagem', 'tela azul', 3, 'magica.png')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS heroes");
        onCreate(db);
    }

    public void create(Hero h) {
        ContentValues values = new ContentValues();
        values.put("name", h.getName());

        SQLiteDatabase db = this.getWritableDatabase();
        db.insert("heroes", null, values);
        db.close();
    }

    public int count() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT COUNT(*) FROM powers", null);
        cursor.moveToFirst();
        int count = cursor.getInt(0);
        db.close();
        return count;
    }

    public Hero find(String name) {
        Hero result = null;

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query("heroes", new String[]{"id", "name", "hasId"}, "name=?",
                new String[]{String.valueOf(name)}, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            result = new Hero(cursor.getInt(0), cursor.getString(1), cursor.getInt(2));
        }

        db.close();

        return result;
    }

    public List<Hero> all() {
        List<Hero> result = new ArrayList<Hero>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT  * FROM heroes", null);

        if (cursor.moveToFirst()) {
            do {
                result.add(new Hero(cursor.getInt(0), cursor.getString(1), cursor.getInt(2)));
            } while (cursor.moveToNext());
        }

        db.close();
        return result;
    }
}