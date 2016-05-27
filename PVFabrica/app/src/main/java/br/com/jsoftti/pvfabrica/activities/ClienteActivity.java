package br.com.jsoftti.pvfabrica.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

import br.com.jsoftti.pvfabrica.R;
import br.com.jsoftti.pvfabrica.dao.ClienteDao;
import br.com.jsoftti.pvfabrica.model.Cliente;

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

    public void cadastrarCliente (View view){
        Cliente cliente = new Cliente();
        cliente.setId(0);
        cliente.setNome(txtNome.getText().toString());
        cliente.setRg(txtRg.getText().toString());
        ClienteDao dao = new ClienteDao(this);
        dao.cadastrar(cliente);
        finish();

    }
}
