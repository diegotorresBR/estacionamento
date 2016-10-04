package com.example.vagasfaciluninorte;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class GaleriaImagensAdapter extends PagerAdapter {
	
	private Context ctx;
	private int [] imagens = new int[] {R.drawable.unidade04_1, R.drawable.unidade04_2};
	
	public GaleriaImagensAdapter(Context ctx) {
		this.ctx = ctx;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return imagens.length;
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		// TODO Auto-generated method stub
		return arg0.equals(arg1);
	}
	
	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		// TODO Auto-generated method stub
		((ViewPager) container).removeView((ImageView)object);
	}
	
	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		// TODO Auto-generated method stub
		ImageView imagem = new ImageView(ctx);
		imagem.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
		imagem.setImageResource(imagens[position]);
		((ViewPager)container).addView(imagem, 0);
		return imagem;
	}

}
