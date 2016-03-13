package dnsystem.com.br.recyclerview;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

import java.util.List;

import dnsystem.com.br.recyclerview.interfaces.RecyclerViewOnClickListenerHack;

/**
 * Created by dnsfirmino on 24/02/16.
 */
public class ActivityPrincipal extends AppCompatActivity implements RecyclerViewOnClickListenerHack {
    private RecyclerView mRecyclerView;
    private List<Carros> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_principal);

        setTitle("RecyclerView");

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                LinearLayoutManager llm = (LinearLayoutManager) mRecyclerView.getLayoutManager();

            }
        });
    }

    @Override
    public void onClickListener(View view, int position) {

    }
}
