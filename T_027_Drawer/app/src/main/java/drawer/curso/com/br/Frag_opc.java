package drawer.curso.com.br;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by no3511 on 29/10/2015.
 */
public class Frag_opc extends Fragment {
    private Button btn_opc;
    public interface iFrag_opc{
        public  void mudarTT(String texto);
    }

    public iFrag_opc delegate;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.frag_opc, container, false);

        btn_opc = (Button) view.findViewById(R.id.frag_opc_btn_acionar_opc);
        btn_opc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (delegate != null){
                    delegate.mudarTT("Novo Texto Hugo");
                }
            }
        });

        return view;
    }
}
