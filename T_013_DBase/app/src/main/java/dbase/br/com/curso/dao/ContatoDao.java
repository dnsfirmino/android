package dbase.br.com.curso.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;

import dbase.br.com.curso.banco.Dao;
import dbase.br.com.curso.model.Contato;
import dbase.br.com.curso.util.HMAux;

/**
 * Created by no3511 on 13/10/2015.
 */
public class ContatoDao extends Dao {

    public ContatoDao(Context context) {
        super(context);
    }

    public ArrayList<HMAux> obterListaContatos() {
        ArrayList<HMAux> contatos = new ArrayList<>();
        //
        abrirBanco();
        //
        Cursor cursor = null;
        //
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(" select idcontato, nome, telefone from contatos order by nome ");
            //
            cursor = db.rawQuery(sb.toString(), null);
            //
            while (cursor.moveToNext()) {
                HMAux item = new HMAux();
                //
                item.put(HMAux.ID, String.valueOf(cursor.getLong(cursor.getColumnIndex("idcontato"))));
                item.put(HMAux.TEXTO_01, cursor.getString(cursor.getColumnIndex("nome")));
                item.put(HMAux.TEXTO_02, cursor.getString(cursor.getColumnIndex("telefone")));
                //
                contatos.add(item);
            }
        } catch (Exception e) {
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        //
        fecharBanco();
        //
        return contatos;
    }

    public void inserirContato(Contato contato) {
        abrirBanco();
        //
        ContentValues cv = new ContentValues();
        //
        cv.put("idcontato", contato.getIdcontato());
        cv.put("nome", contato.getNome());
        cv.put("telefone", contato.getTelefone());
        cv.put("idade", contato.getIdade());
        //
        db.insert("contatos", null, cv);
        //
        fecharBanco();
    }

    public void atualizarContato(Contato contato) {
        abrirBanco();
        //
        String[] parametros =
                new String[]{
                        String.valueOf(contato.getIdcontato())
                };
        //
        String Filtro = "idcontato = ?";
        //
        ContentValues cv = new ContentValues();
        //
        //cv.put("idcontato", contato.getIdcontato());
        cv.put("nome", contato.getNome());
        cv.put("telefone", contato.getTelefone());
        cv.put("idade", contato.getIdade());
        //
        db.update("contatos", cv, Filtro, parametros);
        //
        fecharBanco();
    }

    public void apagarContato(long idcontato) {
        abrirBanco();
        //
        String[] parametros =
                new String[]{
                        String.valueOf(idcontato)
                };
        //
        String Filtro = "idcontato = ?";
        //
        db.delete("contatos", Filtro, parametros);
        //
        fecharBanco();
    }

    public Contato obterContatoByID(long idcontato) {
        Contato cAux = null;
        //
        abrirBanco();
        //
        Cursor cursor = null;
        //
        try {
            String[] parametros =
                    new String[]{
                            String.valueOf(idcontato)
                    };
            //
            //String Filtro = "idcontato = ?";
            //
            StringBuilder sb = new StringBuilder();
            sb.append("select * from contatos where idcontato = ?");
            //
            cursor = db.rawQuery(sb.toString(), parametros);
            //
            while (cursor.moveToNext()) {
                cAux = new Contato();
                //
                cAux.setIdcontato(cursor.getLong(cursor.getColumnIndex("idcontato")));
                cAux.setNome(cursor.getString(cursor.getColumnIndex("nome")));
                cAux.setTelefone(cursor.getString(cursor.getColumnIndex("telefone")));
                cAux.setIdade(cursor.getInt(cursor.getColumnIndex("idade")));
            }

        } catch (Exception e) {

        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        //
        fecharBanco();
        //
        return cAux;
    }

    public long proximoID() {
        long proID = 0;
        //
        abrirBanco();
        //
        StringBuilder sb = new StringBuilder();
        sb.append("select max(idcontato)+1 as id from contatos");
        //
        Cursor cursor = null;
        //
        try {
            cursor = db.rawQuery(sb.toString(), null);
            //
            while (cursor.moveToNext()) {
                proID = cursor.getLong(cursor.getColumnIndex("id"));
            }

            if (proID == 0) {
                proID = 1;
            }
        } catch (Exception e) {
        } finally {
            if (cursor != null){
                cursor.close();
            }
        }
        //
        fecharBanco();
        //
        return proID;
    }
}
