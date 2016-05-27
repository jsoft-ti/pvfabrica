package br.com.jsoftti.pvfabrica.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import br.com.jsoftti.pvfabrica.R;
import br.com.jsoftti.pvfabrica.model.Cliente;

/**
 * Created by guilherme on 22/05/16.
 */
public class ClienteAdapter extends BaseAdapter {
    ArrayList<Cliente> lstCliente;
    Context context;

    public ClienteAdapter(Context context,ArrayList<Cliente> lstCliente){
        this.lstCliente = lstCliente;
        this.context = context;
    }

    @Override
    public int getCount() {
        return lstCliente.size();
    }

    @Override
    public Object getItem(int position) {
        return lstCliente.get(position);
    }

    @Override
    public long getItemId(int position) {
        return lstCliente.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Cliente cliente = lstCliente.get(position);
        convertView = LayoutInflater.from(context).inflate(R.layout.item_cliente, null);

        TextView txtClienteCodigo = (TextView)convertView.findViewById(R.id.txtClienteCodigo);
        TextView txtClienteRg = (TextView)convertView.findViewById(R.id.txtClienteRg);
        TextView txtClienteNome = (TextView)convertView.findViewById(R.id.txtClienteNome);

        txtClienteCodigo.setText(String.valueOf(cliente.getId()));
        txtClienteNome.setText(String.valueOf(cliente.getNome()));
        txtClienteRg.setText(String.valueOf(cliente.getRg()));

        return convertView;
    }
}
