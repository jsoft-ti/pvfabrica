package br.com.jsoftti.pvfabrica.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import br.com.jsoftti.pvfabrica.R;
import br.com.jsoftti.pvfabrica.adapter.ProdutoAdapter;
import br.com.jsoftti.pvfabrica.dao.ProdutoDao;
import br.com.jsoftti.pvfabrica.model.Produto;


public class ProdutosActivity extends AppCompatActivity {

    ListView lvProdutos;
    ArrayList<Produto> lstProduto;
    //String[] lstProdutos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produtos);
        lvProdutos = (ListView)findViewById(R.id.lvProdutos);
        this.carregarProdutos();
        //lvProdutos.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,lstProdutos));



    }

    public void carregarProdutos(){
      /*  lstProduto = new ArrayList<Produto>();
        lstProduto.add(new Produto(0, "Produto 00", 10, 50.0));
        lstProduto.add(new Produto(1,"Produto 01",20,40.0));
        lstProduto.add(new Produto(2, "Produto 02", 30, 30.0));
        lstProduto.add(new Produto(3,"Produto 03",40,20.0));
        lstProduto.add(new Produto(4, "Produto 04", 50, 10.0));*/
        //lstProdutos=new String[]{"Produto 01","Produto 02","Produto 03","Produto 04","Produto 05"};

        lstProduto = new ProdutoDao(this).getLista();
        ProdutoAdapter produtoAdapter = new ProdutoAdapter(this,lstProduto);
        lvProdutos.setAdapter(produtoAdapter);
    }

    public void abrirCadastrarProduto(View view){
        Intent it = new Intent(this,CadastrarProdutoActivity.class);
        startActivity(it);

    }

    @Override
    protected void onResume() {
        super.onResume();
        this.carregarProdutos();
        //lvProdutos.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,lstProdutos));


    }
}
