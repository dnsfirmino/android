package dbase.br.com.curso.util;

import java.util.HashMap;

/**
 * Created by no3511 on 13/10/2015.
 */
public class HMAux extends HashMap<String, String> {
    public static final String ID = "ID";
    public static final String TEXTO_01 = "texto_01";
    public static final String TEXTO_02 = "texto_02";
    public static final String TEXTO_03 = "texto_03";
    public static final String TEXTO_04 = "texto_04";
    public static final String TEXTO_05 = "texto_05";
    public static final String TEXTO_06 = "texto_06";

    @Override
    public String toString() {
        return get(TEXTO_01);
    }
}
