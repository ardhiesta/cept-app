package com.example.djakaumbarawurung.persipantestcept.utils;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.djakaumbarawurung.persipantestcept.Model_Set_get.Grammar;
import com.example.djakaumbarawurung.persipantestcept.Model_Set_get.Opsi;
import com.example.djakaumbarawurung.persipantestcept.R;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wonderlabs on 3/25/17.
 */

public class GrammarAdapter extends
        RecyclerView.Adapter<GrammarAdapter.ViewHolder> {
    // Store a member variable for the grammar data
    private List<Grammar> mGrammars;

    // Pass in the grammar array into the constructor
    public GrammarAdapter(List<Grammar> grammars) {
        mGrammars = grammars;
    }

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView tvSoalGrammar;
        public TextView tvJawabanGrammar;
        public TextView tvPenjelasanGrammar;
        public TextView tvOpsiGrammar;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            tvSoalGrammar = (TextView) itemView.findViewById(R.id.tv_soal_grammar_cv);
            tvJawabanGrammar = (TextView) itemView.findViewById(R.id.tv_jawaban_grammar_cv);
            tvPenjelasanGrammar = (TextView) itemView.findViewById(R.id.tv_penjelasan_grammar_cv);
            tvOpsiGrammar = (TextView) itemView.findViewById(R.id.tv_opsi_grammar_cv);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View contactView = inflater.inflate(R.layout.card_grammar, parent, false);

        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        Grammar grammar = mGrammars.get(position);

        TextView tvSoalGrammar = viewHolder.tvSoalGrammar;
        tvSoalGrammar.setText(grammar.getPertanyaan());
        TextView tvJawabanGrammar = viewHolder.tvJawabanGrammar;
        tvJawabanGrammar.setText(grammar.getJawaban());
        TextView tvPenjelasanGrammar = viewHolder.tvPenjelasanGrammar;
        tvPenjelasanGrammar.setText(grammar.getPenjelasan());

        String opsi = "";
        ArrayList<Opsi> opsiArrayList = grammar.getOpsiArrayList();
        for (int i = 0; i < opsiArrayList.size(); i++) {
            opsi = opsi + opsiArrayList.get(i).getOpsi() + "\n";
        }
        TextView tvOpsiGrammar = viewHolder.tvOpsiGrammar;
        tvOpsiGrammar.setText(opsi);
    }

    @Override
    public int getItemCount() {
        return mGrammars.size();
    }

}
