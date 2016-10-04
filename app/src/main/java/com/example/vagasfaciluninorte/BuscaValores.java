package com.example.vagasfaciluninorte;

import conexao.Http;
import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class BuscaValores extends Activity implements OnClickListener, Runnable {

	private Handler handler = new Handler();
	private ProgressDialog dialog;
	private static String IP_texto;
	protected static String URL;
	private EditText ip;
		
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.visualiza_unidade2);
		ImageView atualiza = (ImageView) findViewById(R.id.atualiza);
		atualiza.setOnClickListener(this);
		
		//IP
		
		ip = (EditText) findViewById(R.id.IP);
		
	}
	
	@Override
	public void run() {
		
		try {
			
			IP_texto = ip.getText().toString();
			URL = "http://"+IP_texto+":8080/Server_vagas/Consulta_vagas_servlet";
			
			final String vagas = Http.getinstance(Http.NORMAL).download(URL);
			handler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					Button text = (Button) findViewById(R.id.vagas_disponiveis);
					text.setText(vagas);	
				}
			});
		} catch (Throwable e) {
			e.printStackTrace();
		}finally{
			dialog.dismiss();
		}
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		dialog = ProgressDialog.show(this, "Teste", "Carregando, aguarde", false, true);
		
		new Thread(this).start();
	}

}
