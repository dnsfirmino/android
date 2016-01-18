package viewpage.curso.com.br;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by no3511 on 28/10/2015.
 */
public class Frag_01 extends Fragment{

    private Button btn_mudar;
    //private MainActivity host;
    public interface  iFrag_01{
        public void mudarf(int position);
    }

    public  iFrag_01 delegate;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.frag_01, container, false);

        btn_mudar = (Button) view.findViewById(R.id.frag01_btn_monstrar);
        //host = (MainActivity) getActivity();

        btn_mudar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //host.mudarFragment(2);
                if (delegate != null){
                    delegate.mudarf(2);
                }
            }
        });

        return view;
    }
}
