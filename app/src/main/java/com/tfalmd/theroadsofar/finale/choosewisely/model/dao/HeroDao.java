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

        db.execSQL("INSERT INTO powers (name, advantage, disadvantage, utility, imageFile) VALUES ('Tecnopatia', 'Poderá trocar de canal sem mais precisar do controle remoto', 'Único problema é que seu cerebro pode dar tela azul', 4, 'tecnocinese.png')");
        db.execSQL("INSERT INTO powers (name, advantage, disadvantage, utility, imageFile) VALUES ('Hidrocinese', 'Se algum dia acontecer um tsunami você estará a salvo', 'Ninguem vai querer namorar alguem que fala com peixes', 3, 'hidrocinese.png')");
        db.execSQL("INSERT INTO powers (name, advantage, disadvantage, utility, imageFile) VALUES ('Gordura Instantânea', 'Não precisa mais comer obrigado quando sua mãe mandar', 'Terá de fazer mais exercicios', 1, 'gordura.png')");
        db.execSQL("INSERT INTO powers (name, advantage, disadvantage, utility, imageFile) VALUES ('Invisibilidade Solitária', '**************', '******************', 1, 'alone.png')");
        db.execSQL("INSERT INTO powers (name, advantage, disadvantage, utility, imageFile) VALUES ('Pirocinese', 'Jamais passará frio', 'Sempre que tentar tomar sorvete você acaba tomando sopa', 3, 'pirocinese.png')");
        db.execSQL("INSERT INTO powers (name, advantage, disadvantage, utility, imageFile) VALUES ('Absorção de Poderes', 'Poderá ter qual poder quiser', 'Infelizmente não poderá beijar ninguém durante toda sua vida', 5, 'absorcao.png')");
        db.execSQL("INSERT INTO powers (name, advantage, disadvantage, utility, imageFile) VALUES ('Aderência Física', 'Você agora pode fazer quadradinho de 8 até de cabeça pra baixo', 'Absurdamente aderente', 2, 'aderencia.png')");
        db.execSQL("INSERT INTO powers (name, advantage, disadvantage, utility, imageFile) VALUES ('Botão Destrutivo', 'Que bosta de poder hein!', 'Vai ter que assistir o mesmo canal eternamente', 1, 'botao.png')");
        db.execSQL("INSERT INTO powers (name, advantage, disadvantage, utility, imageFile) VALUES ('Lágrimas de Ácido', 'Qual é esse poder é dolorosamente inútil', 'Risque os dramas de sua lista de coisas para assistir', 1, 'choroacido.png')");
        db.execSQL("INSERT INTO powers (name, advantage, disadvantage, utility, imageFile) VALUES ('Fator de Cura', 'Não precisa mais sofre passando merthiolate nos seus ferimentos', 'Cirurgia plastica no more', 5, 'fatordecura.png')");
        db.execSQL("INSERT INTO powers (name, advantage, disadvantage, utility, imageFile) VALUES ('Flatulência Quântica', 'Sempre terá lugar para você sentar', 'Não vai mais poder comer feijoada', 1, 'flatulencia.png')");
        db.execSQL("INSERT INTO powers (name, advantage, disadvantage, utility, imageFile) VALUES ('Gerar Campos de Força', 'Sair na chuva sem se molhar', 'Terá que usar um anel verde ridiculo', 3, 'gerarcampo.png')");
        db.execSQL("INSERT INTO powers (name, advantage, disadvantage, utility, imageFile) VALUES ('Grito Supersônico', 'Chamar garçons nunca mais será um problema', 'Irão te chamar de sem volume', 2, 'gritosuper.png')");
        db.execSQL("INSERT INTO powers (name, advantage, disadvantage, utility, imageFile) VALUES ('Ilusionismo', 'Pode ganhar uma grana fazendo truques com baralho pelas ruas', '********************', 4, 'ilusionismo.png')");
        db.execSQL("INSERT INTO powers (name, advantage, disadvantage, utility, imageFile) VALUES ('Insanidade', 'Passará o resto da vida louco', 'Cuidado com os enfermeiros do hospicio', 2, 'insanidade.png')");
        db.execSQL("INSERT INTO powers (name, advantage, disadvantage, utility, imageFile) VALUES ('Intangibilidade', 'Agora vai escapar das chineladas da sua mãe like a boss', '**************', 4, 'intangibilidade.png')");
        db.execSQL("INSERT INTO powers (name, advantage, disadvantage, utility, imageFile) VALUES ('Invisibilidade', '************************', 'Deve ser por isso que ninguém lembra do seu aniversario, nem pelo facebook', 5, 'invisibilidade.png')");
        db.execSQL("INSERT INTO powers (name, advantage, disadvantage, utility, imageFile) VALUES ('Levitar lado direito do corpo', 'Um feito impressionante', 'Não serve pra porra nenhuma', 2, 'levitardireito.png')");
        db.execSQL("INSERT INTO powers (name, advantage, disadvantage, utility, imageFile) VALUES ('Supervelocidade', 'Nunca mais vai chegar atrasado no ENEM', 'Terá dificuldades no namoro', 5, 'velocidade.png')");
        db.execSQL("INSERT INTO powers (name, advantage, disadvantage, utility, imageFile) VALUES ('Petrificação', 'Sempre terá um peso de papel ou de porta a disposição', '**************', 3, 'pretrificacao.png')");
        db.execSQL("INSERT INTO powers (name, advantage, disadvantage, utility, imageFile) VALUES ('Visão de Raio-X Infinita', 'Completamente inútil', 'Absurdamente inútil', 0, 'raioxeterno.png')");
        db.execSQL("INSERT INTO powers (name, advantage, disadvantage, utility, imageFile) VALUES ('Superforça', 'Não precisa mais frequentar a academia', 'Cuidado para não explodir o vaso sanitario quando for ao banheiro', 4, 'superforca.png')");
        db.execSQL("INSERT INTO powers (name, advantage, disadvantage, utility, imageFile) VALUES ('Teletransporte de 8 cm', 'Você pode se teletransportar (:', 'É mais simples você dar um passo', 1, 'teletransporte.png')");
        db.execSQL("INSERT INTO powers (name, advantage, disadvantage, utility, imageFile) VALUES ('Toque da Morte', 'Não terá problemas em conseguir trabalho em um abatedouro', 'Nunca será chamado para abraços em grupo', 4, 'toquedamorte.png')");
        db.execSQL("INSERT INTO powers (name, advantage, disadvantage, utility, imageFile) VALUES ('Transmutação Corporal', 'Suas fotos do facebook serão as melhores', 'Pode ter problemas de sexualidade', 5, 'transmutacao.png')");
        db.execSQL("INSERT INTO powers (name, advantage, disadvantage, utility, imageFile) VALUES ('Viagem entre dimensões', 'Voltar no tempo e impedir o nascimento da Banda Restart', 'Poderá ser comido por um dinossauro', 5, 'viajardimensoes.png')");
        db.execSQL("INSERT INTO powers (name, advantage, disadvantage, utility, imageFile) VALUES ('Visão de Raio-X', 'Não precisa mais esperar seu exame de raio-x chegar', 'Cuidado para não ver algo desagradável', 4, 'visaoderaiox.png')");
        db.execSQL("INSERT INTO powers (name, advantage, disadvantage, utility, imageFile) VALUES ('Voar', 'Não vai ficar mais preso em filas no trânsito', 'Seus cabelos nunca estarão arrumados', 5, 'voar.png')");
        db.execSQL("INSERT INTO powers (name, advantage, disadvantage, utility, imageFile) VALUES ('Telepatia', 'Irá poder ler a mente do professor ou do nerd da sala durante a prova', 'Vai saber que a gatinha que você tá afim na verdade quer seu amigo', 5, 'telepatia.png')");
        db.execSQL("INSERT INTO powers (name, advantage, disadvantage, utility, imageFile) VALUES ('Mágica', 'Pode fazer aquele coelho sumir no aniversário do seu sobrinho', 'Ninguém vai te levar a serio', 4, 'magica.png')");
        db.execSQL("INSERT INTO powers (name, advantage, disadvantage, utility, imageFile) VALUES ('Possessão', 'Pode possuir o presidente e aprovar uma lei que libere refrigerante em todos os bebedouros', '*********************', 4, 'seducao.png')");
        db.execSQL("INSERT INTO powers (name, advantage, disadvantage, utility, imageFile) VALUES ('Soco de Cura', 'Poderá curar seus aliados e descontar a raiva ao mesmo tempo', 'Seus inimigos é que agradecem', 2, 'socodecura.png')");
        db.execSQL("INSERT INTO powers (name, advantage, disadvantage, utility, imageFile) VALUES ('Onipotência', 'O nome já diz tudo', 'Fala serio né!', 5, 'onipotencia.png')");
        db.execSQL("INSERT INTO powers (name, advantage, disadvantage, utility, imageFile) VALUES ('Ressucitar Insetos', 'Pode queimar as formigas e traze-las de novo a vida só para poder queima-las novamente', 'Te acusaram de ser o responsável pelas pragas', 2, 'insetos.png')");
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