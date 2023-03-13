package com.example.footballplayer_sqllite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.google.android.material.tabs.TabLayout;

public class myDataClassHelper extends SQLiteOpenHelper {
    private Context ctx;
    private static final String DataBase_Name = "db_football";
    private static final int DataBase_Version = 1;
    private static final String Table_Name="tbl_player";
    private static final String Field_Id="id";
    private static final String Field_Name="nama";
    private static final String Field_Nomor="nomor";
    private static final String Field_Klub="klub";

    public myDataClassHelper(@Nullable Context context) {
        super(context, DataBase_Name, null, DataBase_Version);
        this.ctx = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + Table_Name + " (" +
                Field_Id + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                Field_Name + " VARCHAR(50), " +
                Field_Nomor + " INTEGER(2)," +
                Field_Klub + " TEXT)"
                ;
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String query = "Drop Table If Exists " + Table_Name;
        sqLiteDatabase.execSQL(query);
        onCreate(sqLiteDatabase);
    }
    public long tambahPlayer (String name , String nomor , String klub){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(Field_Name, name );
        cv.put(Field_Nomor, nomor);
        cv.put(Field_Klub,klub);

        long eksekusi = DB.insert(Table_Name, null , cv);
        return eksekusi;
    }
    public Cursor bacadataPlayer (){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + Table_Name;

        Cursor varCursor = null;
        if(db != null){
            varCursor = db.rawQuery(query , null);
        }
        return  varCursor;
    }
}
