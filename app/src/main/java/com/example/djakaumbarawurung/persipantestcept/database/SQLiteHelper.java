package com.example.djakaumbarawurung.persipantestcept.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.SyncStateContract;
import android.renderscript.ScriptIntrinsicYuvToRGB;
import android.util.Log;

import java.security.PublicKey;

/**
 * Created by Djaka Umbara Wurung on 7/29/2016.
 */
public class SQLiteHelper extends SQLiteOpenHelper {

    // GRAMMAR
    public static final String TABLE_GRAMMAR                    = "TB_GRAMMAR";
    public static final String COLUMN_ID_GRAMMAR                = "ID_GRAMMAR ";
    public static final String COLUMN_PERTANYAAN_GRAMMAR        = "PERTANYAAN";
    public static final String COLUMN_JAWABAN_GRAMMAR           = "JAWABAN";
    public static final String COLUMN_PENJELASAN_GRAMMAR        = "PENJELASAN";

    // OPSI_GRAMMAR
    public static final String TABLE_OPSI_GRAMMAR               = "TB_OPSI_GRAMMAR";
    public static final String COLUMN_ID_OPSI_GRAMMAR           = "ID_OPSI ";
    public static final String COLUMN_OPSI_GRAMMAR              = "PILIHAN";

    // TABLE LOG GRAMMAR
    public static final String TABLE_LOG_GRAMMAR = "log_grammar";
    public static final String COLUMN_ID_LOG_GRAMMAR="id_log_grammar";


    // TABLE_soal_READING
    public static final String TABLE_READING = "TB_SOAL_READING";
    public static final String COLUMN_ID_READING = "ID_READING";
    public static final String COLUMN_PERTANYAAN_READING = " PERTANYAAN";
    public static final String COLUMN_JAWABAN_READING = " JAWABAN";
    public static final String COLUMN_NARASI_READING = "READING";
    public static final String COLUMN_PENJELASAN_READING = "PENJELASAN";

    // TABLE NARASI READING
    public static final String TABLE_NARASI_READING = "TB_NARASI_READING";
    public static final String COLUMN_ID_NARASI = " ID_NARASI_READING";
    public static final String COLUMN_NARASI = " NARASI";


    public static final String COLUMN_ID_TANYA_READING = "id_tanya_Reading";

    // TABLE OPSI READING

    public static final String TABLE_OPSI_READING = "TB_OPSI_READING";
    public static final String COLUMN_ID_OPSI_READING = "ID_OPSI ";
    public static final String COLUMN_OPSI_READING = "PILIHAN";

    // table log reading
    public static final String TABLE_LOG_READING = "log_reading";
    public static final String COLUMN_ID_LOG_READING = "id_log_Reading";




    // NAMA TABLE

    private static final String NAME_DATABASE = "CEPT";
    private static final Integer DATABASE_VERSION = 1;


    // DATABASE Creation SQL statement
    /**
     * tabel pertanyaan grammar
     * untuk menyimpan soal tipe grammar
     * -------------------------
     * Tabel pertanyaan grammar
     * id_tanya_grammar
     * pertanyaan
     * jawaban
     * penjelasan
     */
    private static final String CREATE_TABLE_TANYA_GRAMMAR = "create table "
            + TABLE_GRAMMAR + " ("
            + COLUMN_ID_GRAMMAR         + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_PERTANYAAN_GRAMMAR + " TEXT NOT NULL, "
            + COLUMN_JAWABAN_GRAMMAR    + " TEXT NOT NULL,"
            + COLUMN_PENJELASAN_GRAMMAR + " TEXT NOT NULL );";

    /**
     * tabel opsi grammar
     * untuk menyimpan opsi soal tipe grammar
     * ------------------
     * Tabel opsi grammar
     * id_opsi_grammar
     * opsi
     * id_tanya_grammar
     */

    private static final String CREATE_TABLE_OPSI_GRAMMAR = "create table "
            + TABLE_OPSI_GRAMMAR + " ("
            + COLUMN_ID_OPSI_GRAMMAR    + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_OPSI_GRAMMAR       + " TEXT NOT NULL, "
            + COLUMN_ID_GRAMMAR         + " INTEGER );";

    /**
     * tabel log grammar
     * untuk menyimpan jawaban yang dipilih user pada soal bertipe grammar
     * ------------------
     * Tabel log grammar
     * id_log_grammar
     * id_tanya_grammar
     * jawaban_user
     */

    private static final String CREATE_TABLE_LOG_GRAMMAR = "create table "
            + TABLE_LOG_GRAMMAR
            + " (" + COLUMN_ID_LOG_GRAMMAR   + " integer primary key, "
            + COLUMN_ID_GRAMMAR             + " integer not null, "
            + COLUMN_JAWABAN_GRAMMAR        + " text);";




    /**
     * tabel pertanyaan reading
     * untuk menyimpan soal tipe reading
     * ------------------------
     * Tabel pertanyaan reading
     * id_tanya_reading
     * pertanyaan
     * jawaban
     * penjelasan
     * id_bacaan
     */
    private static final String CREATE_TABLE_SOAL_READING = " create table "
            + TABLE_READING + " ("
            + COLUMN_ID_READING             + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_PERTANYAAN_READING     + " TEXT NOT NULL, " +
            COLUMN_JAWABAN_READING          + " TEXT NOT NULL, " +
            COLUMN_ID_NARASI                + " INTEGER NOT NULL, " +
            COLUMN_PENJELASAN_READING       + " TEXT NOT NULL );";




    /**
     * tabel bacaan reading
     * untuk menyimpan teks bacaan soal tipe reading
     * ----------------------------
     * Tabel bacaan reading
     * id_bacaan
     * bacaan
     */
    private static final String CREATE_TABLE_NARASI_READING = " create table "
            + TABLE_NARASI_READING + " ("
            + COLUMN_ID_NARASI + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_NARASI + " TEXT NOT NULL );";




    /**
     * tabel opsi reading
     * untuk menyimpan opsi soal tipe reading
     * --------------------
     * Tabel opsi reading
     * id_opsi_reading
     * opsi
     * id_tanya_reading
     */

    private static final String CREATE_TABLE_OPSI_READING = "create table "
            + TABLE_OPSI_READING + " ("
            + COLUMN_ID_OPSI_READING    + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_OPSI_READING       + " TEXT NOT NULL, "
            + COLUMN_ID_READING         + " INTEGER NOT NULL );";

    private static final String CREATE_TABLE_LOG_READING = "create table "
            + TABLE_LOG_READING + " ("
            + COLUMN_ID_LOG_READING     + " integer primary key, "
            + COLUMN_ID_TANYA_READING   + " integer not null, "
            + COLUMN_JAWABAN_READING    + " text);";




    public SQLiteHelper(Context context) {
        super(context, NAME_DATABASE, null, DATABASE_VERSION);
    }

    @Override // untuk melakukan eksekusi
    public void onCreate(SQLiteDatabase database) {

        database.execSQL(CREATE_TABLE_TANYA_GRAMMAR);
        database.execSQL(CREATE_TABLE_OPSI_GRAMMAR);
        database.execSQL(CREATE_TABLE_LOG_GRAMMAR)
        ;
        database.execSQL(CREATE_TABLE_NARASI_READING);
        database.execSQL(CREATE_TABLE_SOAL_READING);
        database.execSQL(CREATE_TABLE_OPSI_READING);
        database.execSQL(CREATE_TABLE_LOG_READING);

    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        Log.w
                (SQLiteHelper.class.getName(),
                        "Upgrading database from version " + oldVersion + " to "
                                + newVersion + ", which will destroy all old data");
        database.execSQL(" DROP TABLE IF EXIST " + TABLE_GRAMMAR);
        database.execSQL(" DROP TABLE IF EXIST " + TABLE_OPSI_GRAMMAR);
        database.execSQL(" DROP TABLE IF EXIST " + TABLE_LOG_GRAMMAR);

        //Reading
        database.execSQL(" DROP TABLE IF EXIST " + TABLE_READING);
        database.execSQL(" DROP TABLE IF EXIST " + TABLE_NARASI_READING);
        database.execSQL(" DROP TABLE IF EXIST " + TABLE_OPSI_READING );
        database.execSQL(" DROP TABLE IF EXIST " + TABLE_LOG_READING);


        onCreate(database);

    }
}
