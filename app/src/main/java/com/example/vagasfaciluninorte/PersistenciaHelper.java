package com.example.vagasfaciluninorte;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PersistenciaHelper extends SQLiteOpenHelper{

	public static final String NOME_BANCO =  "estacionamento_final";
    public static final int VERSAO =  1;
    private static PersistenciaHelper instance;
    
    
    public PersistenciaHelper(Context context) {
        super(context, NOME_BANCO, null, VERSAO);
   }
    
    public static PersistenciaHelper getInstance(Context context) {
        if(instance == null)
            instance = new PersistenciaHelper(context);
    return instance;
    }
        
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(EstacionamentoDAO.CRIACAO_TABELA_ESTACIONAMENTO);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL(EstacionamentoDAO.SCRIPT_DELECAO_TABELA);
        onCreate(db);
		
	}

}
