package com.babulgam.facebookdemo.sqllogin;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DabaseHelper  extends SQLiteOpenHelper {

    private static final String DATABASE_NaME="userDetails.db";
    private static final String TABLE_NAME="user_Details";
    private static final String ID="Id";
    private static final String NAME="Name";
    private static final String EMAIL="Email";
    private static final String USERNAME="Username";
    private static final String PASSWORD="Password";
    private static final int VERSION_NUMBER=1;
    private static final String SELECT_ALL = "SELECT * FROM " + TABLE_NAME;
    private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+"("+ID+" " +
            "INTEGER PRIMARY KEY AUTOINCREMENT,"+NAME+" VARCHAR (255) NOT NULL,"+EMAIL+" TEXT NOT NULL," +
            ""+USERNAME +" TEXT NOT NULL ,"+PASSWORD +" TEXT NOT NULL  );";
    private static final String DROP_TABLE = "DROP TABLE IF EXISTS "+TABLE_NAME;
    private Context context;

    public DabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NaME, null, VERSION_NUMBER);
        this.context=context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        try{

            db.execSQL(CREATE_TABLE);
            Toast.makeText(context, "onCreate Is Called", Toast.LENGTH_SHORT).show();


        }catch (Exception e)

        {
            Toast.makeText(context, "Exception: "+ e, Toast.LENGTH_SHORT).show();


        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        try{
            Toast.makeText(context, "onUpgrade Is Called", Toast.LENGTH_SHORT).show();
            db.execSQL(DROP_TABLE);
            onCreate(db);


        }catch (Exception e)

        {
            Toast.makeText(context, "Exception: "+ e, Toast.LENGTH_SHORT).show();


        }

    }

    public long insertData(UserDetails userDetails)
    {
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(NAME,userDetails.getName());
        contentValues.put(EMAIL,userDetails.getEmail());
        contentValues.put(USERNAME,userDetails.getUsername());
        contentValues.put(PASSWORD,userDetails.getPassword());


        long rowid=sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        return rowid;
    }


    public boolean findpassword(String namedh,String passdh)
    {
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("SELECT * FROM "+TABLE_NAME,null);
        Boolean result =false;

        if (cursor.getCount() ==0)
        {
            Toast.makeText(context, "No data is found", Toast.LENGTH_SHORT).show();
        }
        else
        {
            while (cursor.moveToNext())
            {
                String username=cursor.getString(3);
                String password=cursor.getString(4);

                if (username.equals(namedh)  &&  password.equals(passdh))
                {
                    result =true;
                    break;
                }

            }



        }
        return result;

    }

    public Cursor displayAllData(){

        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery(SELECT_ALL,null);
        return cursor;
    }

    public boolean updateDAta(String id,String name,String email,String username,String password)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(ID,id);
        contentValues.put(NAME,name);
        contentValues.put(EMAIL,email);
        contentValues.put(USERNAME,username);
        contentValues.put(PASSWORD,password);

        db.update(TABLE_NAME,contentValues,ID+"=?",new String[] {id});
        return true;
    }

    public int deletedData(String id)
    {
        SQLiteDatabase db =this.getWritableDatabase();
        return db.delete(TABLE_NAME,ID + " = ? ",new String[] {id});
    }

}