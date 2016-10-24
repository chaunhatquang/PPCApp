package com.perfectproperties.app.ppc_app.Buy;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.perfectproperties.app.ppc_app.Other.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Me on 10/18/2016.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DBNAME = "PPC.sqlite";
    public static final String DBLOCATION = "/data/data/com.perfectproperties.app.ppc_app/databases/";
    private Context mContext;
    private SQLiteDatabase mDatabase;

    public DatabaseHelper(Context context) {
        super(context, DBNAME, null, 1);
        this.mContext = context;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void openDatabase() {
        String dbPath = mContext.getDatabasePath(DBNAME).getPath();
        if(mDatabase != null && mDatabase.isOpen()) {
            return;
        }
        mDatabase = SQLiteDatabase.openDatabase(dbPath, null, SQLiteDatabase.OPEN_READWRITE);
    }

    public void closeDatabase() {
        if(mDatabase!=null) {
            mDatabase.close();
        }
    }

    public List<Model> getListModel() {
        try{
            Model model = null;
            List<Model> list = new ArrayList<>();
            openDatabase();
            Cursor cursor = mDatabase.rawQuery("SELECT * FROM Customer_Lease WHERE ID<58", null);
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                model = new Model(cursor.getInt(0),cursor.getString(2),cursor.getString(9),cursor.getString(6),cursor.getString(16),cursor.getString(15),cursor.getInt(7),
                        cursor.getString(12),cursor.getString(18),cursor.getString(17),cursor.getBlob(14),cursor.getString(3));
                list.add(model);
                cursor.moveToNext();
            }
            cursor.close();
            closeDatabase();
            return list;
        }catch(Exception e){
            Log.v("GetListModel_Failed", e.getMessage());
            return null;
        }

    }
}
