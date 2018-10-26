package com.example.saisankar.uicontrolexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "MyContactDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE mycontact(id int, contact_name text, contact_number text, contact_type text, contact_email text)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void storeData(Contact contact){

        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("contact_name",contact.getContact_name());
        values.put("contact_number",contact.getContact_number());
        values.put("contact_type",contact.getContact_type());
        values.put("contact_email",contact.getContact_email());
        db.insert("mycontact",null,values);

    }

    public Contact getData(){

        SQLiteDatabase db =getReadableDatabase();
        String query="SELECT * FROM mycontact";
        Cursor cursor = db.rawQuery(query,null);
        if(cursor.moveToLast()){
            Contact contact = new Contact();
            contact.setContact_name(cursor.getString(cursor.getColumnIndex("contact_name")));
            contact.setContact_number(cursor.getString(cursor.getColumnIndex("contact_number")));
            contact.setContact_type(cursor.getString(cursor.getColumnIndex("contact_type")));
            contact.setContact_email(cursor.getString(cursor.getColumnIndex("contact_email")));
            return contact;
        }
        return null;
    }
}
