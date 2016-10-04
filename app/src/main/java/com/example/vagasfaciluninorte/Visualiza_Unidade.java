package com.example.vagasfaciluninorte;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewSwitcher.ViewFactory;



public class Visualiza_Unidade extends Activity implements OnClickListener{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.visualiza_unidade2);
		
	/*	ViewPager galeria = (ViewPager) findViewById(R.id.galeria);
		GaleriaImagensAdapter ad = new GaleriaImagensAdapter(this);
		galeria.setAdapter(ad);
		
	*/	
	
		
		
		
		
		ImageView home = (ImageView) findViewById(R.id.botaohome);
		home.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		switch (v.getId()) {
		
			
		case R.id.botaohome:
			Intent it2 = new Intent(this, Home.class);
			startActivity(it2);
			break;

		default:
			break;
		}
		
		
		
	}

}
