package soexample.umeng.com.fengzelin20181203.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;


/**
 * date:2018/12/3
 * author:冯泽林(asus)
 * function:
 */
public class Dao {
    private final SQLiteDatabase database;
    public Dao(Context context){
        DaoHelper helper = new DaoHelper(context, "zhoukao.db", null, 1);
        database=helper.getWritableDatabase();
    }
    public long add(String data){
        ContentValues contentValues = new ContentValues();
        contentValues.put("data",data);
        return  database.insert("zhoukao",null,contentValues);
    }
    public List<String> query(){
        ArrayList<String> list = new ArrayList<>();
        Cursor zhoukao = database.query("zhoukao", null, null, null, null, null, null);
        while (zhoukao.moveToNext()){
            String data = zhoukao.getString(zhoukao.getColumnIndex("data"));
            list.add(data);
        }
        return list;
    }
    public void delete(){
        database.delete("zhoukao",null,null);
    }
}
