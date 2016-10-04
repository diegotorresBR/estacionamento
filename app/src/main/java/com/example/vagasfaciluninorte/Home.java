package com.example.vagasfaciluninorte;

import java.util.ArrayList;
import java.util.List;

import entidade.Unidade;
import entidade.UnidadeRepositorio;
import android.R.string;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class Home extends Activity implements OnClickListener{

	SQLiteDatabase banco = null;
	String nome_banco = "estacionamento";
	Spinner lista_spinner;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.inicial_2);
		
		UnidadeRepositorio rep = new UnidadeRepositorio(this);
		List<Unidade> unidades = new ArrayList<Unidade>();
		
		unidades = rep.listarTodasUnidades();
		rep.close();
		
		
		
		List<String> lista = new ArrayList<String>();
		lista.add("tsead");
		lista.add(unidades.get(0).getEndereco_unidade().toString());
		Button botao_com_cancela = (Button) findViewById(R.id.vaga_com_cancela);
		botao_com_cancela.setOnClickListener(this);
		
		Button botao_sem_cancela = (Button) findViewById(R.id.vaga_sem_cancela);
		botao_sem_cancela.setOnClickListener(this);
		
		lista_spinner = (Spinner) findViewById(R.id.lista_spinner);
		ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, lista);
//		lista_spinner.setAdapter(adaptador);
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.home, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		
		switch (v.getId()){
		
		case R.id.vaga_com_cancela:
			Intent it = new Intent(this, Seleciona_unidade.class);
			startActivity(it);
			break;
			
		case R.id.vaga_sem_cancela:
			Intent it2 = new Intent(this, Teste_Consulta_Banco.class);
			//Toast.makeText(this, "foi inicial", Toast.LENGTH_LONG).show();
			startActivity(it2);
			break;
			
		default:
			Toast.makeText(this, "ainda n�o implementado", Toast.LENGTH_LONG).show();
		}
		
	}

	public void cria_banco(){
		try {
			
			banco = openOrCreateDatabase(nome_banco, MODE_PRIVATE, null);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void preencher_spinner(){
		
		
		
		
		
	}
}
