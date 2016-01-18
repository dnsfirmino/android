package json.curso.com.br;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ToolBox {

    public static String readFile(int iID, Context context) {
        StringBuilder contents = new StringBuilder();

        try {

            InputStream inputStream = context.getResources().openRawResource(
                    iID);

            InputStreamReader inputreader = new InputStreamReader(inputStream);
            BufferedReader input = new BufferedReader(inputreader);

            try {
                String line = null;

                while ((line = input.readLine()) != null) {
                    contents.append(line);
                }
            } finally {
                input.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return contents.toString();
    }
}
