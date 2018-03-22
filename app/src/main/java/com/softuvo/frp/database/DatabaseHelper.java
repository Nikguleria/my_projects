package com.softuvo.frp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;

public class DatabaseHelper extends SQLiteOpenHelper {
    private SQLiteDatabase database;
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "SQLiteDatabase.db";
    private static final String TABLE_NAME = "TRUCKDEFECTS";
    private static final String COLUMN_ID = "ID";
    private static final String COLUMN_DATE = "DATE";
    private static final String COLUMN_DEFECTS_OF = "DEFECTS_OF";
    private static final String COLUMN_DEFECTS = "DEFECTS_NAME";
    private Gson gson;

    private static final String DOCUMENTS_TABLE = "Documents";
    private static final String COLUMN_DOCUMENT_NAME = "DOCUMENT_NAME";
    private static final String COLUMN_IMAGE_PATH = "IMAGE_PATH";
    private static final String COLUMN_REMARKS = "REMARKS";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        gson = new Gson();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_NAME + " ( " + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_DATE + " VARCHAR ,"
                + COLUMN_DEFECTS_OF + " VARCHAR ," + COLUMN_DEFECTS + " VARCHAR ,"+ COLUMN_REMARKS +" VARCHAR);");
        sqLiteDatabase.execSQL("CREATE TABLE " + DOCUMENTS_TABLE + " ( " + COLUMN_DOCUMENT_NAME + " VARCHAR," + COLUMN_IMAGE_PATH + " VARCHAR); ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DOCUMENTS_TABLE);
        onCreate(sqLiteDatabase);
    }

    public void insertUpdateTruckRecord(String Date, String Defects,String Remarks) {
        database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT " + COLUMN_DEFECTS + " FROM " + TABLE_NAME + " WHERE " + COLUMN_DATE
                + " = '" + Date + "'", null);
        if (cursor.getCount() > 0) {
            database.execSQL("update " + TABLE_NAME + " set " + COLUMN_DEFECTS + " = '" + Defects + "' , " + COLUMN_REMARKS + " = '" + Remarks
                    + "' where " + COLUMN_DATE + " = '" + Date + "'");
        } else {
            ContentValues contentValues = new ContentValues();
            contentValues.put(COLUMN_DATE, Date);
            contentValues.put(COLUMN_DEFECTS, Defects);
            contentValues.put(COLUMN_DEFECTS_OF, "TRUCK");
            contentValues.put(COLUMN_REMARKS,Remarks);
            database.insert(TABLE_NAME, null, contentValues);
        }
        database.close();
    }

    public void insertUpdateTrailerRecord(String Date, String defectsOf, String trailerDefects,String Remarks) {
        database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT " + COLUMN_DEFECTS + " FROM " + TABLE_NAME + " WHERE " + COLUMN_DATE
                + " = '" + Date + "' AND " + COLUMN_DEFECTS_OF + " = '" + defectsOf + "'", null);
        if (cursor.getCount() > 0) {
            database.execSQL("update " + TABLE_NAME + " set " + COLUMN_DEFECTS + " = '" + trailerDefects + "' , " + COLUMN_REMARKS + " = '" + Remarks
                    + "' where " + COLUMN_DATE + " = '" + Date + "' AND " + COLUMN_DEFECTS_OF + " = '" + defectsOf + "'");
        } else {
            ContentValues contentValues = new ContentValues();
            contentValues.put(COLUMN_DATE, Date);
            contentValues.put(COLUMN_DEFECTS, trailerDefects);
            contentValues.put(COLUMN_DEFECTS_OF, defectsOf);
            contentValues.put(COLUMN_REMARKS,Remarks);
            database.insert(TABLE_NAME, null, contentValues);
        }
        database.close();
    }

    public String getAllTruckDefects(String Date) {
        database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT " + COLUMN_DEFECTS + " FROM " + TABLE_NAME + " WHERE " + COLUMN_DATE
                + " = '" + Date + "'", null);

        String Defects = "";
        if (cursor.getCount() > 0) {
            cursor.moveToNext();
            Defects = cursor.getString(0);
        }
        cursor.close();
        database.close();

        return Defects;
    }

    public String getRemarks(String Date) {
        database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT " + COLUMN_REMARKS + " FROM " + TABLE_NAME + " WHERE " + COLUMN_DATE
                + " = '" + Date + "' LIMIT 1", null);

        String Remarks = "";
        if (cursor.getCount() > 0) {
            cursor.moveToNext();
            Remarks = cursor.getString(0);
        }
        cursor.close();
        database.close();

        return Remarks;
    }

    public HashMap<Integer, ArrayList<String>> getAllTrailerDefects(String Date) {
        HashMap<Integer, ArrayList<String>> trailerDefects = new HashMap<>();
        Type type = new TypeToken<ArrayList<String>>() {
        }.getType();
        database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_DATE
                + " = '" + Date + "' AND " + COLUMN_DEFECTS_OF + " LIKE '%TRAILER%' ORDER BY " + COLUMN_DEFECTS_OF + " ASC", null);

        if (cursor.getCount() > 0) {
            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToNext();
                Integer trailerNumber = Integer.valueOf(cursor.getString(2).replace("TRAILER", ""));
                ArrayList<String> sqliteTrailerArray = gson.fromJson(cursor.getString(3), type);
                trailerDefects.put(trailerNumber, sqliteTrailerArray);
            }
        }
        cursor.close();
        database.close();

        return trailerDefects;
    }

    /*
        for Documents
    */


    public void insertRecord(String DocumentName, String imagePath) {
        database = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_DOCUMENT_NAME, DocumentName);
        contentValues.put(COLUMN_IMAGE_PATH, imagePath);
        database.insert(DOCUMENTS_TABLE, null, contentValues);
        database.close();
    }

    public String getImagePath(String DocumentName) {
        String imagePath = "";
        database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT " + COLUMN_IMAGE_PATH + " FROM " + DOCUMENTS_TABLE + " WHERE " + COLUMN_DOCUMENT_NAME
                + " = '" + DocumentName + "' LIMIT 1", null);
        if (cursor.getCount() > 0) {
            cursor.moveToNext();
            imagePath = cursor.getString(0);

        }
        cursor.close();
        database.close();

        return imagePath;
    }

    public ArrayList<String> getDocumentsType() {
        database = this.getReadableDatabase();
        Cursor cursor = database.query(DOCUMENTS_TABLE, null, null, null, null, null, null);

        ArrayList<String> DocumentsType = new ArrayList<String>();
        if (cursor.getCount() > 0) {
            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToNext();
                DocumentsType.add(cursor.getString(0));

            }
        }
        cursor.close();
        database.close();

        return DocumentsType;
    }

    public Boolean checkDocumentNameexists(String DocumentName) {
        Boolean Flag = true;
        database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT " + COLUMN_DOCUMENT_NAME + " FROM " + DOCUMENTS_TABLE + " WHERE " + COLUMN_DOCUMENT_NAME
                + " = '" + DocumentName + "'", null);
        if (cursor.getCount() > 0) {
            cursor.moveToNext();
            Flag = false;
        }
        cursor.close();
        database.close();
        return Flag;
    }

    public void deleteImage(String DocumentName) {
        database = this.getReadableDatabase();
        database.execSQL("delete from " + DOCUMENTS_TABLE + " where " + COLUMN_DOCUMENT_NAME + " = '" + DocumentName + "'");
        database.close();
    }

    public void updateImage(String DocumentName, String imagePath) {
        database = this.getReadableDatabase();
        database.execSQL("update " + DOCUMENTS_TABLE + " set " + COLUMN_IMAGE_PATH + " = '" + imagePath
                + "' where " + COLUMN_DOCUMENT_NAME + " = '" + DocumentName + "'");
        database.close();
    }
}

