package br.com.jsoftti.pvfabrica.dao;

import android.app.ActionBar;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Guilherme Golfetto on 21/05/2016.
 */
public class ClienteDao extends SQLiteOpenHelper{
    private static final int VERSAO = 1;
    private static final String
            TABELA="clientes",
            BANCO="pvfabrica";

    public ClienteDao(Context context){
        super(context,BANCO,null,VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String dll="CREATE TABLE "+ TABELA+"(id INTEGER PRIMARY KEY, nome TEXT,rg TEXT)";
        db.execSQL(dll);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS "+TABELA;
        db.execSQL(sql);
        onCreate(db);
    }

    public void cadastrar(Cliente cliente){
        ContentValues values = new ContentValues();
        values.put("nome", cliente.getNome());
        values.put("rg", cliente.getRg());

        getWritableDatabase().insert(TABELA,null,values);
    }

    public ArrayList<Cliente> getLista(){
        ArrayList<Cliente> lstCliente = new ArrayList<Cliente>();

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+TABELA+";",null);
        while(cursor.moveToNext()){
            Cliente c = new Cliente();
            c.setId(cursor.getInt(cursor.getColumnIndex("id")));
            c.setNome(cursor.getString(cursor.getColumnIndex("nome")));
            c.setRg(cursor.getString(cursor.getColumnIndex("rg")));
            lstCliente.add(c);
        }
        return lstCliente;
    }
}
