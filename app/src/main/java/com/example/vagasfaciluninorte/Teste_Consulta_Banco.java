package com.example.vagasfaciluninorte;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vagasfaciluninorte.PersistenciaHelper;

import entidade.Unidade;
import entidade.UnidadeRepositorio;

public class Teste_Consulta_Banco extends Activity implements OnClickListener{

	public static UnidadeRepositorio rep;
	public List<Unidade> unidades;
	Cursor c;
	private static final String LOGS = "logs";

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		rep = new UnidadeRepositorio(this);
		//Toast.makeText(this, "foi teste concults", Toast.LENGTH_LONG).show();
		
		unidades = rep.listarTodasUnidades();
		Log.i(LOGS, "teste de system.out.println");
		teste_lista(unidades);
		
		
		//c = rep.getTodasAsUnidades();
		
		/*try {
			unidades = rep.listarTodasUnidades();
		} catch (NullPointerException e) {
			Log.e(null, "erro doido " +e.toString());
		}*/
		
		
	}
	
	private void teste_lista(List<Unidade> lista){
		List<Unidade> listadoida = new ArrayList<Unidade>();
		listadoida = lista;
		for(int i=0; i<listadoida.size();i++){
			int numero = listadoida.get(i).getNumero_unidade();
			Integer numero_cast = numero;
			String texto = numero_cast.toString();
			Log.i(LOGS, texto);
			Log.i(LOGS, listadoida.get(i).getEndereco_unidade().toString());
		}
	}
	
	@Override
	public void onClick(View arg0) {
				
	}
	
	
	
}
