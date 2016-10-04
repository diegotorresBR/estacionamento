package com.example.vagasfaciluninorte;

import java.util.ArrayList;
import java.util.HashMap;

import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;


public class Seleciona_unidade extends Activity implements OnClickListener{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.seleciona_unidade2);
		
		
		//Cada "U", significa "Unidade"
		
		Button u1 = (Button) findViewById(R.id.U1);
		u1.setOnClickListener(this);
		
		Button u2 = (Button) findViewById(R.id.U2);
		u2.setOnClickListener(this);
		
		Button u4 = (Button) findViewById(R.id.U4);
		u4.setOnClickListener(this);
		
		//Não existe unidade 5
		
		Button u6 = (Button) findViewById(R.id.U6);
		u6.setOnClickListener(this);
		
		Button u7 = (Button) findViewById(R.id.U7);
		u7.setOnClickListener(this);
		
		Button u8 = (Button) findViewById(R.id.U8);
		u8.setOnClickListener(this);
		
		Button u9 = (Button) findViewById(R.id.U9);
		u9.setOnClickListener(this);
		
		Button u10 = (Button) findViewById(R.id.U10);
		u10.setOnClickListener(this);
		
		Button u11 = (Button) findViewById(R.id.U11);
		u11.setOnClickListener(this);
		
		Button u12 = (Button) findViewById(R.id.U12);
		u12.setOnClickListener(this);
		
		Button u13 = (Button) findViewById(R.id.U13);
		u13.setOnClickListener(this);
		
	}


	@Override
	public void onClick(View v) {
		
		switch (v.getId()) {
		case R.id.U4:
			Intent it = new Intent(this, BuscaValores.class);
			startActivity(it);
			break;

		default:
			Toast.makeText(this, "Ainda nao Implementado", Toast.LENGTH_SHORT).show();
			break;
		}
		
		
	}

}
