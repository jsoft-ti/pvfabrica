package br.com.jsoftti.pvfabrica.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.jsoftti.pvfabrica.R;
import br.com.jsoftti.pvfabrica.model.Produto;

/**
 * Created by jsoft on 5/21/2016.
 */
public class ProdutoAdapter extends BaseAdapter {
    ArrayList<Produto> lstProduto;
    Context context;

    public ProdutoAdapter(Context context,ArrayList<Produto> lstProduto) {
        this.lstProduto = lstProduto;
        this.context = context;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return lstProduto.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return lstProduto.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub

        return lstProduto.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Produto produto = lstProduto.get(position);
        convertView = LayoutInflater.from(context).inflate(R.layout.item_produto, null);

        TextView txtCodigo  = (TextView)convertView.findViewById(R.id.txtCodigo);
        TextView txtNome  = (TextView)convertView.findViewById(R.id.txtNome);
        TextView txtValor = (TextView)convertView.findViewById(R.id.txtValor);

        txtCodigo.setText(String.valueOf(produto.getId()));
        txtNome.setText(produto.getNome());

        txtValor.setText(String.valueOf(produto.getValor()));

        return convertView;
    }
}
