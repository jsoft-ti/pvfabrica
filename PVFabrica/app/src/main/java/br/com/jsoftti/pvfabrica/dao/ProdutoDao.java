package br.com.jsoftti.pvfabrica.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import br.com.jsoftti.pvfabrica.model.Produto;


public class ProdutoDao extends SQLiteOpenHelper{
    private static final int VERSAO = 1;
    private static final String TABELA="produtos";
    private static final String BANCO="pvfabrica";

    public ProdutoDao(Context context) {
        // TODO Auto-generated constructor stub
        super(context,BANCO,null,VERSAO);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String ddl="CREATE TABLE "+TABELA+" (id INTEGER PRIMARY KEY,nome TEXT,qtd INTEGER,valor REAL);";
        db.execSQL(ddl);

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS "+TABELA;
        db.execSQL(sql);
        onCreate(db);
        // TODO Auto-generated method stub

    }

    public void cadastrar(Produto produto){
        ContentValues values = new ContentValues();
        values.put("nome", produto.getNome());
        values.put("qtd", produto.getQtd());
        values.put("valor", produto.getValor());

        getWritableDatabase().insert(TABELA, null, values);
    }

    public ArrayList<Produto> getLista(){
        ArrayList<Produto> lstProduto = new ArrayList<Produto>();

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from "+TABELA + ";", null);
        while(cursor.moveToNext()){
            Produto p = new Produto();
            p.setId(cursor.getInt(cursor.getColumnIndex("id")));
            p.setNome(cursor.getString(cursor.getColumnIndex("nome")));
            p.setQtd(cursor.getInt(cursor.getColumnIndex("qtd")));
            p.setValor(cursor.getDouble(cursor.getColumnIndex("valor")));
            lstProduto.add(p);
        }


        return lstProduto;
    }

}