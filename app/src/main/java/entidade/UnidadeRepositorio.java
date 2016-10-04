package entidade;

import java.util.ArrayList;
import java.util.List;

import com.persistencia.SQLHelper;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class UnidadeRepositorio extends SQLiteOpenHelper{
	
	public static final String NOME_TABELA = "UNIDADE";
	public static final String COLUNA_NUMERO_UNIDADE = "NUMERO_UNIDADE";
	public static final String COLUNA_ENDERECO = "ENDERECO_UNIDADE";
	public static final String NOME_BANCO = "VAGASFACIL";
	public static final int VERSAO_BANCO = 2;
	private final Context c;
	//private SQLHelper dbhelper;
	private SQLiteDatabase database = null;
	private static final String CONSULTA = "SELECT * FROM unidade";
	/*public static final String SCRIPT_CRIACAO_TABELA_UNIDADE = "CREATE TABLE" +NOME_TABELA + "("
			+ COLUNA_NUMERO_UNIDADE + "INTEGER PRIMARY KEY," + COLUNA_ENDERECO + "TEXT" + ")";
*/	
	public static final String[] SCRIPT_INSERCAO_INICIAL = new String[]{
		"CREATE TABLE " +NOME_TABELA + " ("
				+ COLUNA_NUMERO_UNIDADE + " INTEGER PRIMARY KEY, " + COLUNA_ENDERECO + " TEXT " + ") ",		
		"INSERT INTO UNIDADE(NUMERO_UNIDADE, ENDERECO_UNIDADE) VALUES (4, 'RUA HUASCAR DE FIGUEREDO, CENTRO');"
	};
	
	
	
	//protected UnidadeRepositorio(){	}
	
	
	
	public UnidadeRepositorio(Context c) {
		//database = c.openOrCreateDatabase(NOME_BANCO, Context.MODE_PRIVATE, null);
		//dbhelper = new SQLHelper(c, NOME_BANCO, VERSAO_BANCO, SCRIPT_INSERCAO_INICIAL);
		super(c, NOME_BANCO, null, VERSAO_BANCO);
		this.c = c;
		
	}
	
	public Cursor getTodasAsUnidades(){
		Cursor c = null;
		try {
			//c = database.query(NOME_TABELA, null, null, null, null, null, null);
			 SQLiteDatabase db = getReadableDatabase();
			 c = db.query(NOME_TABELA, null, null, null, null, null, null, null);
			 //db.close();
		} catch (Exception e) {
			// TODO: handle exception
			Log.e(null, "Erro ao buscar " + e.toString());
			//Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
			
		}
		return c;
	}
	
	public List<Unidade> listarTodasUnidades(){
		Cursor c = getTodasAsUnidades();
		List<Unidade> unidade = new ArrayList<Unidade>();
		if(c.moveToFirst()){
			int idxNumeroUnidade = c.getColumnIndex(COLUNA_NUMERO_UNIDADE);
			int idxEnderecoUnidade = c.getColumnIndex(COLUNA_ENDERECO);
			
			do{
				Unidade uni = new Unidade();
				unidade.add(uni);
				uni.numero_unidade = c.getInt(idxNumeroUnidade);
				uni.endereco_unidade  = c.getString(idxEnderecoUnidade);
				
			}while(c.moveToNext());
		}
		return unidade;
	}
	
	public void fechar(){
		if(database!=null){
			database.close();
		}
	}

	@Override
	public void onCreate(SQLiteDatabase arg0) {
		// TODO Auto-generated method stub
		int qtdeScripts = SCRIPT_INSERCAO_INICIAL.length;
		
		for(int i = 0; i<qtdeScripts; i++){
			String sql = SCRIPT_INSERCAO_INICIAL[i];
			arg0.execSQL(sql);
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}
	

}
