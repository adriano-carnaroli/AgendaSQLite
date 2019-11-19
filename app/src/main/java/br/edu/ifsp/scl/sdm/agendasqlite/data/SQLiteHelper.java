package br.edu.ifsp.scl.sdm.agendasqlite.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

class SQLiteHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "agenda.db";
    static final String TABLE_NAME = "contatos";
    static final String KEY_ID = "id";
    static final String KEY_NOME = "nome";
    static final String KEY_FONE = "fone";
    static final String KEY_EMAIL = "email";
    static final String KEY_FAVORITO = "favorito";
    static final String KEY_FONE_SECUNDARIO = "foneSecundario";
    static final String KEY_DATA_ANIVERSARIO = "dataAniversario";

    private static final int DATABASE_VERSION = 4;

    private static final String CREATE_TABLE = "CREATE TABLE "+ TABLE_NAME + " (" +
                                                KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                                KEY_NOME + " TEXT, " +
                                                KEY_FONE + " TEXT, " +
                                                KEY_EMAIL + " TEXT); "
                                                ;

    public SQLiteHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < 2){
            String sql="ALTER TABLE "+TABLE_NAME+" ADD COLUMN "+KEY_FAVORITO+" BOOLEAN DEFAULT 0";
            db.execSQL(sql);
        }
        if (oldVersion < 3){
            String sql="ALTER TABLE "+TABLE_NAME+" ADD COLUMN "+KEY_FONE_SECUNDARIO+" TEXT ";
            db.execSQL(sql);
        }
        if (oldVersion < 4){
            String sql="ALTER TABLE "+TABLE_NAME+" ADD COLUMN "+KEY_DATA_ANIVERSARIO+" TEXT ";
            db.execSQL(sql);
        }
    }
}
