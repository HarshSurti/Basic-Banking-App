package com.example.bankingsystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    private String TABLE_NAME = "user_table";
    private String TABLE_NAME1 = "transfers_table";

    public DatabaseHelper(@Nullable Context context) {
        super(context, "User.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (PHONENUMBER INTEGER PRIMARY KEY ,NAME TEXT,BALANCE DECIMAL,EMAIL VARCHAR,ACCOUNT_NO VARCHAR,IFSC_CODE VARCHAR)");
        db.execSQL("create table " + TABLE_NAME1 +" (TRANSACTIONID INTEGER PRIMARY KEY AUTOINCREMENT,DATE TEXT,FROMNAME TEXT,TONAME TEXT,AMOUNT DECIMAL,STATUS TEXT)");
        db.execSQL("insert into user_table values(9987654321,'Ross',5060.00,'ross50@gmail.com','XXXXXXXXXXXX9987','XYZ99876543')");
        db.execSQL("insert into user_table values(9876543219,'Rachel',7962.12,'rachel79@gmail.com','XXXXXXXXXXXX9876','XZY98765432')");
        db.execSQL("insert into user_table values(9765432198,'Chandler',15000.26,'chandler15@gmail.com','XXXXXXXXXXXX9765','YXZ97654321')");
        db.execSQL("insert into user_table values(9654321987,'Monica',3500.51,'monica35@gmail.com','XXXXXXXXXXXX9654','YZX96543219')");
        db.execSQL("insert into user_table values(9543219876,'Joey',1000.56,'joey10@gmail.com','XXXXXXXXXXXX9543','ZXY95432198')");
        db.execSQL("insert into user_table values(9432198765,'Phoebe',700.95,'phoebe70@gmail.com','XXXXXXXXXXXX9432','ZYX94321987')");
        db.execSQL("insert into user_table values(9321987654,'Ted',6500.00,'ted65@gmail.com','XXXXXXXXXXXX9321','XYZ93219876')");
        db.execSQL("insert into user_table values(9219876543,'Robin',300.78,'robin30@gmail.com','XXXXXXXXXXXX9219','XZY92198765')");
        db.execSQL("insert into user_table values(9198765432,'Marshall',4690.41,'marshall46@gmail.com','XXXXXXXXXXXX9198','YXZ91987654')");
        db.execSQL("insert into user_table values(9876543210,'Lily',2756.70,'lily27gmail.com','XXXXXXXXXXXX9678','YZX97865432')");
        db.execSQL("insert into user_table values(90123456789,'Barney',20000.90,'barney20@gmail.com','XXXXXXXXXXXX9012','ZXY90123456')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME1);
        onCreate(db);
    }

    public Cursor readalldata(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from user_table", null);
        return cursor;
    }

    public Cursor readparticulardata(String phonenumber){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from user_table where phonenumber = " +phonenumber, null);
        return cursor;
    }

    public Cursor readselectuserdata(String phonenumber) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from user_table except select * from user_table where phonenumber = " +phonenumber, null);
        return cursor;
    }

    public void updateAmount(String phonenumber, String amount){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update user_table set balance = " + amount + " where phonenumber = " +phonenumber);
    }

    public Cursor readtransferdata(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from transfers_table", null);
        return cursor;
    }

    public boolean insertTransferData(String date,String from_name, String to_name, String amount, String status){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("DATE", date);
        contentValues.put("FROMNAME", from_name);
        contentValues.put("TONAME", to_name);
        contentValues.put("AMOUNT", amount);
        contentValues.put("STATUS", status);
        Long result = db.insert(TABLE_NAME1, null, contentValues);
        if(result == -1){
            return false;
        }else{
            return true;
        }
    }
}