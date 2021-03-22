package kylec.me.g2048.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

/**
 * Created by KYLE on 2019/5/3 - 15:37
 */
public class GameDatabaseHelper extends SQLiteOpenHelper {

    private static final String CREATE_G4 = "create table G4 ("
            + "id integer primary key autoincrement, "
            + "x integer, "
            + "y integer, "
            + "num integer)";

    private static final String CREATE_G5 = "create table G5 ("
            + "id integer primary key autoincrement, "
            + "x integer, "
            + "y integer, "
            + "num integer)";

    private static final String CREATE_G6 = "create table G6 ("
            + "id integer primary key autoincrement, "
            + "x integer, "
            + "y integer, "
            + "num integer)";

    private static final String CREATE_G_INFINITE = "create table G_INFINITE ("
            + "id integer primary key autoincrement, "
            + "x integer, "
            + "y integer, "
            + "num integer)";

    public GameDatabaseHelper(@Nullable Context context, @Nullable String name,
                              @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_G4);
        db.execSQL(CREATE_G5);
        db.execSQL(CREATE_G6);
        db.execSQL(CREATE_G_INFINITE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
