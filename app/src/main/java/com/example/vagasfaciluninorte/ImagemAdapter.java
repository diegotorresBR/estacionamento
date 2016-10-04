package com.example.vagasfaciluninorte;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class ImagemAdapter extends BaseAdapter {
	
	private Context ctx;
	private final int[] imagens;
	private final android.view.ViewGroup.LayoutParams param;
	
	public ImagemAdapter(Context c, int[] imagens, android.view.ViewGroup.LayoutParams param){
		this.ctx = c;
		this.imagens = imagens;
		this.param = param;	
		
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return imagens.length;
	}

	@Override
	public Object getItem(int posicao) {
		// TODO Auto-generated method stub
		return posicao;
	}

	@Override
	public long getItemId(int posicao) {
		// TODO Auto-generated method stub
		return posicao;
	}

	@Override
	public View getView(int posicao, View covertView, ViewGroup parent) {
		ImageView img = new ImageView(ctx);
		img.setImageResource(imagens[posicao]);
		img.setAdjustViewBounds(true);
		img.setLayoutParams(param);
		return img;
	}

}
