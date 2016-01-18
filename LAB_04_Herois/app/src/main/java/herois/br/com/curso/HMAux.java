package herois.br.com.curso;

import java.util.HashMap;

/**
 * Created by no3511 on 06/10/2015.
 */

//Hash map - redução de consumo de recurso
public class HMAux extends HashMap<String, String>{
    public static final String ID = "id";
    public static final String TEXTO_01 = "texto_01";
    public static final String TEXTO_02 = "texto_02";
    public static final String TEXTO_03 = "texto_03";

    //
    @Override
    public String toString() {
        return get(TEXTO_01);
    }
}
