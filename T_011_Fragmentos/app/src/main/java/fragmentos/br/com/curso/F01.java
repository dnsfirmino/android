package fragmentos.br.com.curso;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by no3511 on 08/10/2015.
 */
public class F01 extends Fragment {
    private Button btn_monstrar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.f_01, container, false);

        inicializaVariavel(view);
        inicializarAcao();

        return view;
    }

    private void inicializaVariavel(View view) {
        btn_monstrar = (Button) view.findViewById(R.id.f_01_btn_01);

        btn_monstrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Olá eu sou um framento f_01", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void inicializarAcao() {

    }
}
