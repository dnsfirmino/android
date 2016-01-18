package fragmentos.br.com.curso;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by no3511 on 08/10/2015.
 */
public class F02 extends Fragment {
    private TextView tv_valor;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.f_02, container, false);
        inicializarVariavel(view);
        inicializarAcao();

        return view;
    }

    private void inicializarVariavel(View view) {
        tv_valor = (TextView) view.findViewById(R.id.f_02_tv_valor);
    }

    private void inicializarAcao() {

    }
}
