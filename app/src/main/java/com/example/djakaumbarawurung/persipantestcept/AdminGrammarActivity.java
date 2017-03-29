package com.example.djakaumbarawurung.persipantestcept;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.example.djakaumbarawurung.persipantestcept.Model_Set_get.Grammar;
import com.example.djakaumbarawurung.persipantestcept.database.DataSource_PenghubungTabel;
import com.example.djakaumbarawurung.persipantestcept.utils.GrammarAdapter;
import java.util.ArrayList;

public class AdminGrammarActivity extends AppCompatActivity {
    DataSource_PenghubungTabel dataSource_penghubungTabel;

    // ambil data soal grammar
    ArrayList<Grammar> grammarArrayList = new ArrayList<>();

    RecyclerView recyclerView;

    GrammarAdapter grammarAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_grammar);

        dataSource_penghubungTabel = new DataSource_PenghubungTabel(this);
        dataSource_penghubungTabel.open();

        recyclerView = (RecyclerView) findViewById(R.id.rv_gramar);

        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        getDataGrammar();

        grammarAdapter = new GrammarAdapter(grammarArrayList, AdminGrammarActivity.this);
        recyclerView.setAdapter(grammarAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(this,
                recyclerView, new ClickListener() {

            @Override
            public void onClick(View view, final int position) {
            }

            @Override
            public void onLongClick(View view, int position) {
                //creating a popup menu
                TextView tvSoalGrammarCv = (TextView) view.findViewById(R.id.tvSoalGrammarCv);
                String soal = tvSoalGrammarCv.getText().toString();
                showPopUpMenu(view, soal, position);
            }

        }));
    }

    // membuat menu popup untuk delete dan edit
    private void showPopUpMenu(View view, final String soal, final int position){
        PopupMenu popup = new PopupMenu(AdminGrammarActivity.this, view);
        //inflating menu from xml resource
        popup.inflate(R.menu.menu_cv_grammar);
        //adding click listener
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menuCvGrammarEdit:
                        //handle menu edit click
                        break;
                    case R.id.menuCvGrammarDelete:
                        //handle menu delete click
                        showDeleteConfirmDialog(soal, position);
                        break;
                }
                return false;
            }
        });
        //displaying the popup
        popup.show();
    }

    //membuat popup menu konfirmasi delete data
    private void showDeleteConfirmDialog(final String soal, final int position){
        AlertDialog.Builder builder = new AlertDialog.Builder(AdminGrammarActivity.this);
        builder.setCancelable(true);
        builder.setTitle("Are you sure to delete this data?");
        builder.setMessage(soal);
        builder.setPositiveButton("Delete",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        hapusDataGrammar(soal, position);
                    }
                });
        builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void hapusDataGrammar(String soal, int position){
        int idGrammar = dataSource_penghubungTabel.getIdGrammarBySoal(soal);

        int testDeleteGrammar = dataSource_penghubungTabel.hapusDataGrammar(idGrammar);
        System.out.println("testDeleteGrammar: "+testDeleteGrammar);

        int testDeleteOpsiGrammar = dataSource_penghubungTabel.hapusDataOpsiGrammar(idGrammar);
        System.out.println("testDeleteOpsiGrammar: "+testDeleteOpsiGrammar);

        grammarAdapter.removeAt(position);

    }

    // mengambil data soal grammar dari database
    private void getDataGrammar() {
        grammarArrayList = dataSource_penghubungTabel.ambilDataSoalGrammar();
    }

    @Override
    protected void onResume() {
        dataSource_penghubungTabel.open();
        super.onResume();
    }

    @Override
    protected void onPause() {
        dataSource_penghubungTabel.close();
        super.onPause();
    }

    public static interface ClickListener {
        public void onClick(View view, int position);

        public void onLongClick(View view, int position);
    }

    class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

        private ClickListener clicklistener;
        private GestureDetector gestureDetector;

        public RecyclerTouchListener(Context context, final RecyclerView recycleView, final ClickListener clicklistener) {

            this.clicklistener = clicklistener;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recycleView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && clicklistener != null) {
                        clicklistener.onLongClick(child, recycleView.getChildAdapterPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if (child != null && clicklistener != null && gestureDetector.onTouchEvent(e)) {
                clicklistener.onClick(child, rv.getChildAdapterPosition(child));
            }

            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {

        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    }
}
