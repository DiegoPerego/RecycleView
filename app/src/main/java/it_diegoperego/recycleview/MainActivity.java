package it_diegoperego.recycleview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecycle;
    LinearLayoutManager mLayout;
    private Button inserisci;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecycle = (RecyclerView) findViewById(R.id.recyclerV);
        mRecycle.setHasFixedSize(true);
        mLayout = new LinearLayoutManager(this);
        mRecycle.setLayoutManager(mLayout);

        final List<Dipendente> list= init();

        final MyAdapter adapter = new MyAdapter(list, getApplicationContext());

        mRecycle.setAdapter(adapter);

        inserisci =(Button) findViewById(R.id.bInserisci);

        inserisci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.add(new Dipendente(7, "Diego", "Perego"));
                adapter.notifyDataSetChanged();
            }
        });
    }

    public List<Dipendente> init(){
        Dipendente uno = new Dipendente(1, "Francesco", "Neri");
        Dipendente due = new Dipendente(2, "Michele", "Rossi");
        Dipendente tre = new Dipendente(3, "Antonio", "Bianco");
        List<Dipendente>dip =new ArrayList<>();
        dip.add(uno);
        dip.add(due);
        dip.add(tre);
        return dip;
    }
}
