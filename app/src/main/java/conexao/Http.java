package conexao;

import java.util.Map;

public abstract class Http {
	
	public static final int NORMAL = 1;
	
	public static Http getinstance(int tipo){
		switch(tipo){
		
		case NORMAL:
			return new HttpNormalImpl();
		default:
			return new HttpNormalImpl();
		
		}
		
		
			
		
	}
	
	public abstract String download(String url);
	public abstract String doPost(String url, Map map);

}
