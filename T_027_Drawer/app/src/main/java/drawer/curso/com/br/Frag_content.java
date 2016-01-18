package drawer.curso.com.br;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by no3511 on 29/10/2015.
 */
public class Frag_content extends Fragment {

    private TextView tv_texto;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.frag_content,container, false);

        tv_texto = (TextView) view.findViewById(R.id.frag_content_tv_texto);

        return view;
    }

    public void modificarTexto(String texto){
        tv_texto.setText(texto);
    }
}
