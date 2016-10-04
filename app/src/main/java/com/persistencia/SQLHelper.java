package com.persistencia;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;


public class SQLHelper extends SQLiteOpenHelper{
	
	private String[] scriptCreate;
	
	public SQLHelper(Context context, String nameBanco, int versaoBanco, String [] scriptCreate ) {
		super(context, nameBanco, null, versaoBanco);
		this.scriptCreate = scriptCreate;
	}

	@Override
	public void onCreate(SQLiteDatabase arg0) {
		int qtdScripts = scriptCreate.length;
		for(int i=0; i<qtdScripts;i++){
			String sql = scriptCreate[i];
			arg0.execSQL(sql);
		}
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}
	
	

}
