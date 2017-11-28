package it_diegoperego.recycleview;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by utente3.academy on 22-Nov-17.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.DipViewHolder> {

    private List<Dipendente>dipendenti;
    private Context context;

    public static class DipViewHolder extends RecyclerView.ViewHolder{

        public CardView card;
        public TextView nome;
        public TextView cognome;
        public TextView matricola;
        public Dipendente dipendent;

        public DipViewHolder(View v, final Context context){

            super(v);
            card = (CardView) itemView.findViewById(R.id.cardV);
            nome = (TextView) v.findViewById(R.id.textNome);
            cognome = (TextView) v.findViewById(R.id.textCognome);
            matricola = (TextView) v.findViewById(R.id.textMatricola);

            card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String s = dipendent.getNome().toString()+"\n"+dipendent.getCognome().toString()+"\n"+dipendent.getMatricola();
                    Toast.makeText(context,s,Toast.LENGTH_SHORT).show();
                }
            });

        }

    }

    public MyAdapter(List<Dipendente> dipendenti, Context context) {
        this.dipendenti = dipendenti;
        this.context = context;
    }

    @Override
    public MyAdapter.DipViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardsimple, parent,false);

        DipViewHolder dip = new DipViewHolder(v, context);
        return dip;
    }

    @Override
    public void onBindViewHolder(MyAdapter.DipViewHolder holder, int position) {

        Dipendente dipe= dipendenti.get(position);
        holder.nome.setText(dipe.getNome());
        holder.cognome.setText(dipe.getCognome());
        holder.matricola.setText(""+dipe.getMatricola());
        holder.dipendent=dipe;

    }

    @Override
    public int getItemCount() {
        return dipendenti.size();
    }
}
