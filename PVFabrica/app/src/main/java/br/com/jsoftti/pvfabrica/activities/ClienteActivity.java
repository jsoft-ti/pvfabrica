package br.com.jsoftti.pvfabrica.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

import br.com.jsoftti.pvfabrica.R;

public class ClienteActivity extends AppCompatActivity {
   EditText txtId, txtNome,txtRg;
    Button btnCadastrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente);

        txtId = (EditText) findViewById(R.id.txtId);
        txtNome = (EditText) findViewById(R.id.txtNome);
        txtRg = (EditText) findViewById(R.id.txtRg);
        btnCadastrar = (Button) findViewById(R.id.btnCadastrar);

    }

    public void CadastrarCliente (View view){
        Cliente cliente = new Cliente();
        Cliente.setId(0);
        Cliente.setNome(txtNome.getText().toString());
        Cliente.setRG(txtRg.getText().toString());
        new ClienteDao(this).cadastrar(cliente);
        finish();

    }
}
