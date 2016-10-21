package com.example.haitr.ppc_app;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.haitr.ppc_app.Other.Item_News;
import com.example.haitr.ppc_app.Other.Item_Partner;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Me on 10/19/2016.
 */

public class SellDatabaseOpenHelper extends SQLiteOpenHelper {
    private static String DB_PATH = "";
    private static String DB_NAME = "PPC.sqlite";
    private static String SELL_TABLE = "Project";
    private static final int DB_VERSION = 1;
    Context context;
    private SQLiteDatabase db;

    public SellDatabaseOpenHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;
        if (android.os.Build.VERSION.SDK_INT >= 17) {
            DB_PATH = context.getApplicationInfo().dataDir + "/databases/";
        } else {
            DB_PATH = "/data/data/" + context.getPackageName() + "/databases/";
        }
        this.context = context;
    }

    public void create() throws IOException {
        boolean dbExist = checkDataBase();
        if (dbExist) {
            //do nothing - database already exist
        } else {
            // By calling this method and empty database will be created into the default system path
            // of your application so we are gonna be able to overwrite that database with our database.
            this.getReadableDatabase();
            try {
                copyDataBase();
            } catch (IOException e) {
                throw new Error("Error copying database");
            }
        }
    }

    private void copyDataBase() throws IOException {
        //Open your local db as the input stream
        InputStream myInput = context.getAssets().open(DB_NAME);

        String outFileName = DB_PATH + DB_NAME;

        //Open the empty db as the output stream
        OutputStream myOutput = new FileOutputStream(outFileName);

        //transfer bytes from the inputfile to the outputfile
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer)) > 0) {
            myOutput.write(buffer, 0, length);
        }

        myOutput.flush();
        myOutput.close();
        myInput.close();
    }

    //Open the database
    public boolean open() {
        try {
            String myPath = DB_PATH + DB_NAME;
            db = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);
            return true;
        } catch (SQLException sqle) {
            db = null;
            return false;
        }
    }

    @Override
    public synchronized void close() {
        if (db != null)
            db.close();
        super.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    private boolean checkDataBase() {
        // Check if the database exist to avoid re-copy the data
        SQLiteDatabase checkDB = null;
        try {
            String path = DB_PATH + DB_NAME;
            checkDB = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READONLY);
        } catch (SQLiteException e) {
            // database don't exist yet.
            e.printStackTrace();
        }
        if (checkDB != null) {
            checkDB.close();
        }
        return checkDB != null ? true : false;
    }

    public List<SellsEntity> getListSells() {
        List<SellsEntity> listSells = new ArrayList<>();
        String query = "SELECT Thumb,Block,Project,View,City,District,Price,Badroom,Note,Latitude,Longtitude FROM Customer_Sale";
        SQLiteDatabase db = SQLiteDatabase.openDatabase(DB_PATH + DB_NAME, null, SQLiteDatabase.OPEN_READWRITE);
        Cursor cursor = db.rawQuery(query, null);
        while (cursor.moveToNext()) {
            byte[] image = cursor.getBlob(cursor.getColumnIndex("Thumb"));
            String title = cursor.getString(cursor.getColumnIndex("Project"));
            String view = cursor.getString(cursor.getColumnIndex("View"));
            String city = cursor.getString(cursor.getColumnIndex("City"));
            String district = cursor.getString(cursor.getColumnIndex("District"));
            String price = cursor.getString(cursor.getColumnIndex("Price"));
            String badroom = cursor.getString(cursor.getColumnIndex("Badroom"));
            String note = cursor.getString(cursor.getColumnIndex("Note"));
            Float Latitude = cursor.getFloat(cursor.getColumnIndex("Latitude"));
            Float Lontitude = cursor.getFloat(cursor.getColumnIndex("Longtitude"));
            String block = cursor.getString(cursor.getColumnIndex("Block"));
            SellsEntity getSellEntity = new SellsEntity(image, title, view, city, district, price, badroom, note, Latitude, Lontitude, block);
            listSells.add(getSellEntity);
        }
        return listSells;
    }

    public List<Item_News> getListNew() {
        List<Item_News> listItemNew = new ArrayList<>();
        String query = "SELECT * FROM News";
        SQLiteDatabase db = SQLiteDatabase.openDatabase(DB_PATH + DB_NAME, null, SQLiteDatabase.OPEN_READWRITE);
        Cursor cursor = db.rawQuery(query, null);
        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndex("Name"));
            String link = cursor.getString(cursor.getColumnIndex("Link"));
            Item_News getItemNews = new Item_News(name, R.drawable.bg_news, link);
            listItemNew.add(getItemNews);
        }
        return listItemNew;
    }
    public List<Item_Partner> getListPartner() {
        List<Item_Partner> listItemPartner = new ArrayList<>();
        String query = "SELECT * FROM Partner";
        SQLiteDatabase db = SQLiteDatabase.openDatabase(DB_PATH + DB_NAME, null, SQLiteDatabase.OPEN_READWRITE);
        Cursor cursor = db.rawQuery(query, null);
        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndex("Name"));
            String link = cursor.getString(cursor.getColumnIndex("Link"));
            Item_Partner getItemPartner = new Item_Partner(name, R.drawable.icon_partner, link);
            listItemPartner.add(getItemPartner);
        }
        return listItemPartner;
    }
}
