package dbase.br.com.curso.banco;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by no3511 on 13/10/2015.
 */
public class Dao {
    private Context context;
    protected SQLiteDatabase db;

    public Dao(Context context) {
        this.context = context;
    }

    protected void abrirBanco(){
        SQLIteHelper sqlLiteHelper_var = new SQLIteHelper(context, Constantes.database, null, Constantes.versao);
        this.db = sqlLiteHelper_var.getReadableDatabase();
    }

    protected void fecharBanco(){
        //
        if (this.db != null){
            this.db.close();
        }
    }
}
