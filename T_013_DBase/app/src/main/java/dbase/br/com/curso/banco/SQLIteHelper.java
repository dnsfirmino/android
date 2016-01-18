package dbase.br.com.curso.banco;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by no3511 on 13/10/2015.
 */
public class SQLIteHelper extends SQLiteOpenHelper{


    public SQLIteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE [contatos] (\n" +
                "  [idcontato] BIGINT NOT NULL, \n" +
                "  [nome] NVARCHAR(200) NOT NULL, \n" +
                "  [telefone] NVARCHAR(14) NOT NULL, \n" +
                "  [idade] INT NOT NULL, \n" +
                "  CONSTRAINT [] PRIMARY KEY ([idcontato]));");
        //
        String[] SQlComandos = sb.toString().split(";");

        //
        for (int i = 0; i < SQlComandos.length; i++) {
            db.execSQL(SQlComandos[i].toLowerCase());
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        StringBuilder sb = new StringBuilder();
        sb.append("DROP TABLE IF EXISTS contatos;");

        String[] SqlComandos = sb.toString().split(";");

        for (int i = 0; i < SqlComandos.length; i++) {
            db.execSQL(SqlComandos[i].toLowerCase());
        }

        onCreate(db);
    }
}
