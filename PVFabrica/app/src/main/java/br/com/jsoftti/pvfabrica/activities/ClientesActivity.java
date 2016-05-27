package br.com.jsoftti.pvfabrica.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import br.com.jsoftti.pvfabrica.R;
import br.com.jsoftti.pvfabrica.adapter.ClienteAdapter;
import br.com.jsoftti.pvfabrica.dao.ClienteDao;
import br.com.jsoftti.pvfabrica.model.Cliente;

public class ClientesActivity extends AppCompatActivity {

    ListView lvClientes;
    ArrayList<Cliente> lstCliente;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes);
        lvClientes = (ListView)findViewById(R.id.lvClientes);
        this.carregarClientes();
    }

    public void carregarClientes(){
        lstCliente = new ClienteDao(this).getLista();
        ClienteAdapter clienteAdapter = new ClienteAdapter(this,lstCliente);
        lvClientes.setAdapter(clienteAdapter);
    }

    public void abrirCadastrarCliente(View view){
        Intent it = new Intent(this,ClienteActivity.class);
        startActivity(it);
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.carregarClientes();
    }
}
