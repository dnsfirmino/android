package http.curso.com.br;

import org.apache.http.client.HttpClient;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;

/**
 * Created by no3511 on 22/10/2015.
 */
public class Util  {


    public static final String comunicacao(String targetURL, String params){
        StringBuilder sb = new StringBuilder();

        URL url;
        HttpURLConnection conn = null;

        try{
            url = new URL(targetURL);
            conn = (HttpURLConnection) url.openConnection();

            //Opcional
            conn.setReadTimeout(60000);
            conn.setConnectTimeout(60000);
            conn.setRequestMethod("POST");
            conn.setDoInput(true); //Recebendo dados do servidor
            conn.setDoOutput(true); //Enviando dados para servidor

            StringBuilder resultParams = new StringBuilder();
            resultParams.append(URLEncoder.encode("json", "UTF-8")).append("=").append(URLEncoder.encode(params, "UTF-8"));

            OutputStream os = conn.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
            writer.write(resultParams.toString());
            writer.flush(); // Descarregar
            writer.close(); // Fecha a porta de conexão
            os.close();
            sb.append(readStream(conn.getInputStream()));
        }catch (Exception e){
            sb.append("Erro:").append(e.toString());
        }finally {
            if(conn != null){
                conn.disconnect();
            }
        }

        return sb.toString();
    }

    private static String readStream(InputStream inputStream) {
        Reader reader = null;
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];

        try {
            reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));

            int n;

            while ((n=reader.read(buffer)) != -1){
                writer.write(buffer, 0, n);
            }
        }catch (Exception e){

        }finally {
            try {
                if (reader != null){
                    reader.close();
                }
            } catch (IOException e) {
            }
        }
        return writer.toString();
    }

}
