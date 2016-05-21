package br.com.jsoftti.pvfabrica.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import br.com.jsoftti.pvfabrica.R;

public class PrincipalActivity extends AppCompatActivity {

    ImageButton btnImgProdutos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        ImageButton btnImgProdutos = (ImageButton)findViewById(R.id.btnImgProdutos);

    }

    public void abrirActivityProduto(View view){
        Intent it = new Intent(this,ProdutosActivity.class);
        startActivity(it);
    }
}
