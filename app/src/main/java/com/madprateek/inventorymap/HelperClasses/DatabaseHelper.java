package com.madprateek.inventorymap.HelperClasses;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.madprateek.inventorymap.ModelClasses.InventoryModel;
import com.madprateek.inventorymap.ModelClasses.MapDetailsModel;
import com.madprateek.inventorymap.ModelClasses.QualityCheckModel;

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
    private static final String LENGTH_IN_INCHES = "lengthInInches";
    private static final String KARNI_1 = "karni1";
    private static final String KARNI_2 = "karni2";
    private static final String DHARAWAT = "dharawat";
    private static final String SAVE_DATE = "saveDate";
    private static final String MAP_DETAILS = "mapDetails";
    private static final String LOCATION = "location";
    private static final String QUALITY_CHECK = "qualityCheck";
    private static final String TANI_Dhili = "tani_dhili";
    private static final String TANI_Tight = "tani_tight";
    private static final String COLOR_Sahi = "color_sahi";
    private static final String COLOR_Galat = "color_galat";
    private static final String Dharawat_Kam = "dharawat_kam";
    private static final String Dharawat_Jyada = "dharawat_jyada";
    private static final String Design_Galat = "design_galat";
    private static final String Design_Sahi = "design_sahi";

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


        String CREATION_MAP_DETAILS = "CREATE TABLE "+MAP_DETAILS+" (" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + OTN_NO + " TEXT,"
                + LENGTH_IN_INCHES + " INTEGER,"
                + KARNI_1 + " INTEGER," + KARNI_2 + " INTEGER," + DHARAWAT + " INTEGER," + SAVE_DATE + " TEXT," + LOCATION + " TEXT)";
        db.execSQL(CREATION_MAP_DETAILS);
        Log.d("TAG","Map Details table created");


        String CREATION_QUALITY_CHECK = "CREATE TABLE "+QUALITY_CHECK+" (" +KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + MAP_SERIAL_NO + " TEXT,"
                + Dharawat_Kam + " TEXT," + Dharawat_Jyada + " TEXT," + TANI_Dhili + " TEXT," + TANI_Tight + " TEXT," + Design_Sahi + " TEXT,"
                + Design_Galat + " TEXT," + COLOR_Sahi + " TEXT," + COLOR_Galat + " TEXT)";
        db.execSQL(CREATION_QUALITY_CHECK);
        Log.d("TAG","Quality check table created");
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
       // Log.d("TAG","Rugline Row Added");
    }

    public void addMapDetails(MapDetailsModel mapDetails){

        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(OTN_NO, mapDetails.getOtnNo());
        values.put(LENGTH_IN_INCHES, mapDetails.getLengthInInches());
        values.put(KARNI_1, mapDetails.getKarni1());
        values.put(KARNI_2, mapDetails.getKarni2());
        values.put(DHARAWAT, mapDetails.getDharawat());
        values.put(SAVE_DATE, mapDetails.getSaveDate());
        values.put(LOCATION, mapDetails.getLocation());
        db.insert(MAP_DETAILS, null, values);
        Log.d("TAG","map Details Row Added");
    }


    public void addQualityCheck(QualityCheckModel qualityCheckModel){

        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(MAP_SERIAL_NO, qualityCheckModel.getMapNo());
        values.put(Dharawat_Kam, qualityCheckModel.getDharawatKam());
        values.put(Dharawat_Jyada, qualityCheckModel.getDharawatJyada());
        values.put(TANI_Dhili, qualityCheckModel.getTaniDhili());
        values.put(TANI_Tight, qualityCheckModel.getTaniTight());
        values.put(Design_Sahi, qualityCheckModel.getDesignSahi());
        values.put(Design_Galat, qualityCheckModel.getDesignGalat());
        values.put(COLOR_Sahi, qualityCheckModel.getColorSahi());
        values.put(COLOR_Galat, qualityCheckModel.getColorGalat());
        db.insert(QUALITY_CHECK, null, values);
        Log.d("TAG","quality check Row Added");
    }


    public List<InventoryModel> getAllMaps(String mapNo){

        List<InventoryModel> fetchMaps = new ArrayList<>();
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

    public List<MapDetailsModel> getAllMapDetails(){

        List<MapDetailsModel> fetchDetails = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + MAP_DETAILS;
        db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,null);
        MapDetailsModel mapDetails;

        if (cursor.moveToFirst()){

            do {
                mapDetails = new MapDetailsModel();
                mapDetails.setOtnNo(cursor.getString(1));
                mapDetails.setLengthInInches(cursor.getString(2));
                mapDetails.setKarni1(cursor.getString(3));
                mapDetails.setKarni2(cursor.getString(4));
                mapDetails.setDharawat(cursor.getString(5));
                mapDetails.setSaveDate(cursor.getString(6));
                mapDetails.setLocation(cursor.getString(7));
                fetchDetails.add(mapDetails);
            }while (cursor.moveToNext());
        }
        return fetchDetails;
    }


    public List<QualityCheckModel> getAllQualityCheck(){

        List<QualityCheckModel> fetchDetails = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + QUALITY_CHECK;
        db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,null);
        QualityCheckModel qualityCheckModel;

        if (cursor.moveToFirst()){

            do {
                qualityCheckModel = new QualityCheckModel();
                qualityCheckModel.setMapNo(cursor.getString(1));
                qualityCheckModel.setDharawatKam(cursor.getString(2));
                qualityCheckModel.setDharawatJyada(cursor.getString(3));
                qualityCheckModel.setTaniDhili(cursor.getString(4));
                qualityCheckModel.setTaniTight(cursor.getString(5));
                qualityCheckModel.setDesignSahi(cursor.getString(6));
                qualityCheckModel.setDesignGalat(cursor.getString(7));
                qualityCheckModel.setColorSahi(cursor.getString(8));
                qualityCheckModel.setColorGalat(cursor.getString(9));
                fetchDetails.add(qualityCheckModel);
            }while (cursor.moveToNext());
        }
        return fetchDetails;
    }
    public void deleteAllMaps(){
        db = this.getWritableDatabase();
        db.delete(RUGLINE,null,null);
    }

    public void deleteMapDetails(MapDetailsModel mapDetail){
        db = this.getWritableDatabase();
        db.delete(MAP_DETAILS,KEY_ID + " = ?", new String[]{String.valueOf(mapDetail.getId())});
    }

    public void deleteAllMapDetails(){
        db = this.getWritableDatabase();
        db.delete(MAP_DETAILS, null, null);
    }

    public void deleteAllQualityCheck(){
        db = this.getWritableDatabase();
        db.delete(QUALITY_CHECK, null, null);
    }
}
