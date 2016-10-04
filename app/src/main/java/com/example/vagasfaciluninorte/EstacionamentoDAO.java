package com.example.vagasfaciluninorte;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class EstacionamentoDAO {
	
	public static final String NOME_TABELA = "unidades";
	public static final String ENDERECO = "endereco";
	public static final String NUMERO = "numero";
	
	public static final String CRIACAO_TABELA_ESTACIONAMENTO = "create or replace table " +NOME_TABELA+"("+NUMERO+
			" integer primary key not null, "+ENDERECO+" character varying[100])";
	
	private SQLiteDatabase db = null;
	
	private static EstacionamentoDAO instance;
	
	public static final String SCRIPT_DELECAO_TABELA =  "DROP TABLE IF EXISTS " + NOME_TABELA;
	 	
	public static EstacionamentoDAO getinstance(Context c){
		if(instance == null){
			instance = new EstacionamentoDAO(c);
		}
		return instance;
	}
	
	public EstacionamentoDAO(Context c) {
		PersistenciaHelper persistenceHelper = PersistenciaHelper.getInstance(c);
        db = persistenceHelper.getWritableDatabase();
	}
	
	
	
	public void salvar(Estacionameto estacionamento) {
		
		ContentValues values = gerarContentValeuesEstacionamento(estacionamento);
        db.insert(NOME_TABELA, null, values);
        
    }
	
	public List<Estacionameto> recuperarTodos() {
        String queryReturnAll = "SELECT * FROM " + NOME_TABELA;
        Cursor cursor = db.rawQuery(queryReturnAll, null);
        List<Estacionameto> veiculos = construirEstacionamentoPorCursor(cursor);
        
        return veiculos;
	}
	
	public void fecharConexao() {
        if(db != null && db.isOpen())
            db.close(); 
    }
	
	private List<Estacionameto> construirEstacionamentoPorCursor(Cursor cursor) {
        List<Estacionameto> estacionamento = new ArrayList<Estacionameto>();
        if(cursor == null)
            return estacionamento;
         
        try {
 
            if (cursor.moveToFirst()) {
                do {
 
                    int indexENDERECO = cursor.getColumnIndex(ENDERECO);
                    int indexNum = cursor.getColumnIndex(NUMERO);
                    
 
                    int id = cursor.getInt(indexNum);
                    String ednereco = cursor.getString(indexENDERECO);
 
                    Estacionameto estacionamento_mo = new Estacionameto(id, ednereco);
                    
 
                    estacionamento.add(estacionamento_mo);
 
                } while (cursor.moveToNext());
            }
             
        } finally {
            cursor.close();
        }
        return estacionamento;
    }
	
	private ContentValues gerarContentValeuesEstacionamento(Estacionameto estacionamento) {
        ContentValues values = new ContentValues();
        values.put(ENDERECO, estacionamento.getEndereco());
        values.put(NUMERO, estacionamento.getNumero_unidade());
       
 
        return values;
    }
	
}
