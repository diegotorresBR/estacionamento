package conexao;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class HttpNormalImpl extends Http {

	
	
	@Override
	public String download(String url) {
		// TODO Auto-generated method stub
		try {
			URL u = new URL(url);
			HttpURLConnection conn = (HttpURLConnection) u.openConnection();
			conn.setRequestMethod("GET");
			conn.setDoInput(true);
			conn.setDoOutput(false);
			conn.connect();
			InputStream in = conn.getInputStream();
			String arquivo = readString(in);
			conn.disconnect();
			return arquivo;
		} catch (MalformedURLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String doPost(String url, Map map) {
		
		return null;
	}
	
	private String readString(InputStream in) throws IOException{
		byte[] bytes = readBytes(in);
		String texto = new String(bytes);
		return texto;
	}
	
	private byte[] readBytes(InputStream in) throws IOException{
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		
		try {
			byte[] buffer = new byte[1024];
			int len;
			while ((len = in.read(buffer)) > 0){
				bos.write(buffer, 0, len);
			}
			byte [] bytes = bos.toByteArray();
			return bytes;
		} finally {
			bos.close();
			in.close();
		}
	}

}
