package com.example.vagasfaciluninorte;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher.ViewFactory;

public class SwitcherImagem extends Activity implements ViewFactory {

	//Imagens unidade
	private int[] imagens = {R.drawable.unidade04_1, R.drawable.unidade04_2};

	private ImageSwitcher isw;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.visualiza_unidade);
		
		isw = (ImageSwitcher) findViewById(R.id.efeito_imagem);
		isw.setFactory(this);
		isw.setInAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_in));
		
		Gallery g = (Gallery) findViewById(R.id.galeria_imagens_unidade);
		g.setAdapter(new ImagemAdapter(this, imagens, new Gallery.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)));
		
		g.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				isw.setImageResource(imagens[arg2]);
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		
			
		});
	}
	
	
	@Override
	public View makeView() {
		
		ImageView img = new ImageView(this);
		img.setBackgroundColor(0xFF000000);
		img.setScaleType(ImageView.ScaleType.FIT_CENTER);
		return img;
		
	}
	
	
	
	
	
	

}
