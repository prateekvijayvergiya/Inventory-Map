package com.madprateek.inventorymap.HelperClasses;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.madprateek.inventorymap.ModelClasses.InventoryModel;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "new_data";
    private static final String RUGLINE = "RUGLINE";
    private static final String KEY_ID = "id";
    private static final String MAP_SERIAL_NO = "mapNo";
    private static final String ITEM_NO = "itemNo";
    private static final String QUALITY = "quality";
    private static final String DESIGN = "design";
    private static final String GR_COLOR_NAME = "grColor";
    private static final String BR_COLOR_NAME = "brColor";
    private static final String GROUND_COLOR = "groundColor";
    private static final String BORDER_COLOR = "borderColor";
    private static final String SIZE = "size";
    private static final String SHAPE = "shape";
    private static final String PRIORITY = "priority";
    private static final String CURRENT_STATUS = "currentStatus";
    private static final String PRODUCTION_ORDER_NO = "proOrderNo";
    private static final String OTN_NO = "otnNo";
    private static final String PRODUCTION_LOCATION = "prodLoc";
    private static final String BRANCH_MANAGER = "branchManager";
    private static final String WEAVER_NAME = "weaverName";
    private static final String RUNNING_LENGTH = "runningLength";
    private static final String REMAINING_WORK = "remainingWork";
    private static final String ACTUAL_WEAVER_ISSUE_DATE = "actualIssueDate";
    private static final String REVISED_ORDER_DUE_DATE = "revisedDuedate";
    private static final String QS = "qs";
    private static final String PTN_NO = "ptnNo";
    private static final String WEAVER_ON_LOOM_DATE = "weaverOnLoomDate";
    private static final String MERCHANT_NAME = "merchantName";
    private static final String TERRITORY_HEAD = "territoryHead";
    SQLiteDatabase db;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATION_RUGLINE = "CREATE TABLE "+RUGLINE+" (" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + MAP_SERIAL_NO + " INTEGER," + ITEM_NO + " TEXT,"
                + QUALITY + " TEXT," + DESIGN + " TEXT," + GR_COLOR_NAME + " TEXT," + BR_COLOR_NAME + " TEXT," + GROUND_COLOR + " TEXT," + BORDER_COLOR + " TEXT,"
                + SIZE + " TEXT," + SHAPE + " TEXT," + PRIORITY + " INTEGER," + CURRENT_STATUS + " TEXT," + PRODUCTION_ORDER_NO + " TEXT," + OTN_NO + " TEXT,"
                + PRODUCTION_LOCATION + " TEXT," + BRANCH_MANAGER + " TEXT," + WEAVER_NAME + " TEXT," + RUNNING_LENGTH + " INTEGER," + REMAINING_WORK + " INTEGER,"
                + ACTUAL_WEAVER_ISSUE_DATE + " TEXT," + REVISED_ORDER_DUE_DATE + " TEXT," + QS + " TEXT," + PTN_NO + " TEXT," + WEAVER_ON_LOOM_DATE + " TEXT,"
                + MERCHANT_NAME + " TEXT," + TERRITORY_HEAD + " TEXT)";
        db.execSQL(CREATION_RUGLINE);
        Log.d("TAG","Rugline table created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public void addRugline(InventoryModel inventoryModel){

        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(MAP_SERIAL_NO, inventoryModel.getMAP_SERIAL_NO());
        values.put(ITEM_NO, inventoryModel.getITEM_NO());
        values.put(QUALITY, inventoryModel.getQUALITY());
        values.put(DESIGN, inventoryModel.getDESIGN());
        values.put(GR_COLOR_NAME, inventoryModel.getGR_COLOR_NAME());
        values.put(BR_COLOR_NAME, inventoryModel.getBR_COLOR_NAME());
        values.put(GROUND_COLOR, inventoryModel.getGROUND_COLOR());
        values.put(BORDER_COLOR, inventoryModel.getBORDER_COLOR());
        values.put(SIZE, inventoryModel.getSIZE());
        values.put(SHAPE, inventoryModel.getSHAPE());
        values.put(PRIORITY, inventoryModel.getPRIORITY());
        values.put(CURRENT_STATUS, inventoryModel.getCURRENT_STATUS());
        values.put(PRODUCTION_ORDER_NO, inventoryModel.getPRODUCTION_ORDER_NO());
        values.put(OTN_NO, inventoryModel.getOTN_NO());
        values.put(PRODUCTION_LOCATION, inventoryModel.getPRODUCTION_LOCATION());
        values.put(BRANCH_MANAGER, inventoryModel.getBRANCH_MANAGER());
        values.put(WEAVER_NAME, inventoryModel.getWEAVER_NAME());
        values.put(RUNNING_LENGTH, inventoryModel.getRUNNING_LENGTH());
        values.put(REMAINING_WORK, inventoryModel.getREMAINING_WORK());
        values.put(ACTUAL_WEAVER_ISSUE_DATE, inventoryModel.getACTUAL_WEAVER_ISSUE_DATE());
        values.put(REVISED_ORDER_DUE_DATE, inventoryModel.getREVISED_ORDER_DUE_DATE());
        values.put(QS, inventoryModel.getQS());
        values.put(PTN_NO, inventoryModel.getPTN_NO());
        values.put(WEAVER_ON_LOOM_DATE, inventoryModel.getWEAVER_ON_LOOM_DATE());
        values.put(MERCHANT_NAME, inventoryModel.getMERCHANT_NAME());
        values.put(TERRITORY_HEAD, inventoryModel.getTERRITORY_HEAD());
        db.insert(RUGLINE,null,values);
        Log.d("TAG","Rugline Row Added");
    }

    public List<InventoryModel> getAllMaps(String mapNo){

        List<InventoryModel> fetchMaps = new ArrayList<>();
        Log.d("TAG",mapNo);
        String selectQuery = "SELECT * FROM " + RUGLINE + " WHERE " + MAP_SERIAL_NO + " = " + mapNo;
        db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,null);
        InventoryModel inventoryModel;

        if (cursor.moveToFirst()){
            do {
                inventoryModel = new InventoryModel();
                inventoryModel.setMAP_SERIAL_NO(cursor.getString(1));
                inventoryModel.setQUALITY(cursor.getString(3));
                inventoryModel.setDESIGN(cursor.getString(4));
                inventoryModel.setGR_COLOR_NAME(cursor.getString(5));
                inventoryModel.setBR_COLOR_NAME(cursor.getString(6));
                inventoryModel.setGROUND_COLOR(cursor.getString(7));
                inventoryModel.setBORDER_COLOR(cursor.getString(8));
                inventoryModel.setSIZE(cursor.getString(9));
                inventoryModel.setSHAPE(cursor.getString(10));
                inventoryModel.setOTN_NO(cursor.getString(14));
                inventoryModel.setPRODUCTION_LOCATION(cursor.getString(15));
                inventoryModel.setWEAVER_NAME(cursor.getString(17));
                inventoryModel.setRUNNING_LENGTH(cursor.getInt(18));
                inventoryModel.setREMAINING_WORK(cursor.getInt(19));
                inventoryModel.setACTUAL_WEAVER_ISSUE_DATE(cursor.getString(20));
                inventoryModel.setREVISED_ORDER_DUE_DATE(cursor.getString(21));
                inventoryModel.setQS(cursor.getString(22));
                fetchMaps.add(inventoryModel);
            }while (cursor.moveToNext());
        }
        Log.d("TAG","Size is" + fetchMaps.size());
        return  fetchMaps;
    }
}
