package br.com.jsoftti.pvfabrica.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.com.jsoftti.pvfabrica.R;
import br.com.jsoftti.pvfabrica.dao.ProdutoDao;
import br.com.jsoftti.pvfabrica.model.Produto;

public class CadastrarProdutoActivity extends AppCompatActivity {

    EditText txtNome;
    EditText txtquantidade;
    EditText txtValor;
    Button btnCadastrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_produto);
        txtNome = (EditText)findViewById(R.id.txtNome);
        txtquantidade = (EditText)findViewById(R.id.txtQuantidade);
        txtValor = (EditText)findViewById(R.id.txtValor);
        btnCadastrar = (Button)findViewById(R.id.btnCadastrar);

    }

    public void cadastrarProduto(View view){
        Produto produto = new Produto();
        produto.setId(0);
        produto.setNome(txtNome.getText().toString());
        produto.setQtd(Integer.parseInt(txtquantidade.getText().toString()));
        produto.setValor(Double.parseDouble(txtValor.getText().toString()));
        new ProdutoDao(this).cadastrar(produto);
        finish();
    }
}
