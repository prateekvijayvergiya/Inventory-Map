package com.madprateek.inventorymap.ModelClasses;

public class InventoryModel {

    String MAP_SERIAL_NO;
    String ITEM_NO;
    String QUALITY;
    String DESIGN;
    String GR_COLOR_NAME;
    String BR_COLOR_NAME;
    String GROUND_COLOR;
    String BORDER_COLOR;
    String SIZE;
    String SHAPE;
    int PRIORITY;
    String CURRENT_STATUS;
    String PRODUCTION_ORDER_NO;
    String OTN_NO;
    String PRODUCTION_LOCATION;
    String BRANCH_MANAGER;
    String WEAVER_NAME;
    int RUNNING_LENGTH;
    int REMAINING_WORK;
    String ACTUAL_WEAVER_ISSUE_DATE;
    String REVISED_ORDER_DUE_DATE;
    String QS;
    String PTN_NO;
    String WEAVER_ON_LOOM_DATE;
    String OFF_LOOM_DATE_FOR_SALES;
    String MERCHANT_NAME;

    public InventoryModel(String MAP_SERIAL_NO, String ITEM_NO, String QUALITY, String DESIGN, String GR_COLOR_NAME, String BR_COLOR_NAME, String GROUND_COLOR, String BORDER_COLOR, String SIZE, String SHAPE, int PRIORITY, String CURRENT_STATUS, String PRODUCTION_ORDER_NO, String OTN_NO, String PRODUCTION_LOCATION, String BRANCH_MANAGER, String WEAVER_NAME, int RUNNING_LENGTH, int REMAINING_WORK, String ACTUAL_WEAVER_ISSUE_DATE, String REVISED_ORDER_DUE_DATE, String QS, String PTN_NO, String WEAVER_ON_LOOM_DATE, String MERCHANT_NAME, String TERRITORY_HEAD) {
        this.MAP_SERIAL_NO = MAP_SERIAL_NO;
        this.ITEM_NO = ITEM_NO;
        this.QUALITY = QUALITY;
        this.DESIGN = DESIGN;
        this.GR_COLOR_NAME = GR_COLOR_NAME;
        this.BR_COLOR_NAME = BR_COLOR_NAME;
        this.GROUND_COLOR = GROUND_COLOR;
        this.BORDER_COLOR = BORDER_COLOR;
        this.SIZE = SIZE;
        this.SHAPE = SHAPE;
        this.PRIORITY = PRIORITY;
        this.CURRENT_STATUS = CURRENT_STATUS;
        this.PRODUCTION_ORDER_NO = PRODUCTION_ORDER_NO;
        this.OTN_NO = OTN_NO;
        this.PRODUCTION_LOCATION = PRODUCTION_LOCATION;
        this.BRANCH_MANAGER = BRANCH_MANAGER;
        this.WEAVER_NAME = WEAVER_NAME;
        this.RUNNING_LENGTH = RUNNING_LENGTH;
        this.REMAINING_WORK = REMAINING_WORK;
        this.ACTUAL_WEAVER_ISSUE_DATE = ACTUAL_WEAVER_ISSUE_DATE;
        this.REVISED_ORDER_DUE_DATE = REVISED_ORDER_DUE_DATE;
        this.QS = QS;
        this.PTN_NO = PTN_NO;
        this.WEAVER_ON_LOOM_DATE = WEAVER_ON_LOOM_DATE;
        this.MERCHANT_NAME = MERCHANT_NAME;
        this.TERRITORY_HEAD = TERRITORY_HEAD;
    }

    public InventoryModel() {

    }

    public String getMAP_SERIAL_NO() {

        return MAP_SERIAL_NO;
    }

    public void setMAP_SERIAL_NO(String MAP_SERIAL_NO) {
        this.MAP_SERIAL_NO = MAP_SERIAL_NO;
    }

    public String getITEM_NO() {
        return ITEM_NO;
    }

    public void setITEM_NO(String ITEM_NO) {
        this.ITEM_NO = ITEM_NO;
    }

    public String getQUALITY() {
        return QUALITY;
    }

    public void setQUALITY(String QUALITY) {
        this.QUALITY = QUALITY;
    }

    public String getDESIGN() {
        return DESIGN;
    }

    public void setDESIGN(String DESIGN) {
        this.DESIGN = DESIGN;
    }

    public String getGR_COLOR_NAME() {
        return GR_COLOR_NAME;
    }

    public void setGR_COLOR_NAME(String GR_COLOR_NAME) {
        this.GR_COLOR_NAME = GR_COLOR_NAME;
    }

    public String getBR_COLOR_NAME() {
        return BR_COLOR_NAME;
    }

    public void setBR_COLOR_NAME(String BR_COLOR_NAME) {
        this.BR_COLOR_NAME = BR_COLOR_NAME;
    }

    public String getGROUND_COLOR() {
        return GROUND_COLOR;
    }

    public void setGROUND_COLOR(String GROUND_COLOR) {
        this.GROUND_COLOR = GROUND_COLOR;
    }

    public String getBORDER_COLOR() {
        return BORDER_COLOR;
    }

    public void setBORDER_COLOR(String BORDER_COLOR) {
        this.BORDER_COLOR = BORDER_COLOR;
    }

    public String getSIZE() {
        return SIZE;
    }

    public void setSIZE(String SIZE) {
        this.SIZE = SIZE;
    }

    public String getSHAPE() {
        return SHAPE;
    }

    public void setSHAPE(String SHAPE) {
        this.SHAPE = SHAPE;
    }

    public int getPRIORITY() {
        return PRIORITY;
    }

    public void setPRIORITY(int PRIORITY) {
        this.PRIORITY = PRIORITY;
    }

    public String getCURRENT_STATUS() {
        return CURRENT_STATUS;
    }

    public void setCURRENT_STATUS(String CURRENT_STATUS) {
        this.CURRENT_STATUS = CURRENT_STATUS;
    }

    public String getPRODUCTION_ORDER_NO() {
        return PRODUCTION_ORDER_NO;
    }

    public void setPRODUCTION_ORDER_NO(String PRODUCTION_ORDER_NO) {
        this.PRODUCTION_ORDER_NO = PRODUCTION_ORDER_NO;
    }

    public String getOTN_NO() {
        return OTN_NO;
    }

    public void setOTN_NO(String OTN_NO) {
        this.OTN_NO = OTN_NO;
    }

    public String getPRODUCTION_LOCATION() {
        return PRODUCTION_LOCATION;
    }

    public void setPRODUCTION_LOCATION(String PRODUCTION_LOCATION) {
        this.PRODUCTION_LOCATION = PRODUCTION_LOCATION;
    }

    public String getBRANCH_MANAGER() {
        return BRANCH_MANAGER;
    }

    public void setBRANCH_MANAGER(String BRANCH_MANAGER) {
        this.BRANCH_MANAGER = BRANCH_MANAGER;
    }

    public String getWEAVER_NAME() {
        return WEAVER_NAME;
    }

    public void setWEAVER_NAME(String WEAVER_NAME) {
        this.WEAVER_NAME = WEAVER_NAME;
    }

    public int getRUNNING_LENGTH() {
        return RUNNING_LENGTH;
    }

    public void setRUNNING_LENGTH(int RUNNING_LENGTH) {
        this.RUNNING_LENGTH = RUNNING_LENGTH;
    }

    public int getREMAINING_WORK() {
        return REMAINING_WORK;
    }

    public void setREMAINING_WORK(int REMAINING_WORK) {
        this.REMAINING_WORK = REMAINING_WORK;
    }

    public String getACTUAL_WEAVER_ISSUE_DATE() {
        return ACTUAL_WEAVER_ISSUE_DATE;
    }

    public void setACTUAL_WEAVER_ISSUE_DATE(String ACTUAL_WEAVER_ISSUE_DATE) {
        this.ACTUAL_WEAVER_ISSUE_DATE = ACTUAL_WEAVER_ISSUE_DATE;
    }

    public String getREVISED_ORDER_DUE_DATE() {
        return REVISED_ORDER_DUE_DATE;
    }

    public void setREVISED_ORDER_DUE_DATE(String REVISED_ORDER_DUE_DATE) {
        this.REVISED_ORDER_DUE_DATE = REVISED_ORDER_DUE_DATE;
    }

    public String getQS() {
        return QS;
    }

    public void setQS(String QS) {
        this.QS = QS;
    }

    public String getPTN_NO() {
        return PTN_NO;
    }

    public void setPTN_NO(String PTN_NO) {
        this.PTN_NO = PTN_NO;
    }

    public String getWEAVER_ON_LOOM_DATE() {
        return WEAVER_ON_LOOM_DATE;
    }

    public void setWEAVER_ON_LOOM_DATE(String WEAVER_ON_LOOM_DATE) {
        this.WEAVER_ON_LOOM_DATE = WEAVER_ON_LOOM_DATE;
    }

    public String getOFF_LOOM_DATE_FOR_SALES() {
        return OFF_LOOM_DATE_FOR_SALES;
    }

    public void setOFF_LOOM_DATE_FOR_SALES(String OFF_LOOM_DATE_FOR_SALES) {
        this.OFF_LOOM_DATE_FOR_SALES = OFF_LOOM_DATE_FOR_SALES;
    }

    public String getMERCHANT_NAME() {
        return MERCHANT_NAME;
    }

    public void setMERCHANT_NAME(String MERCHANT_NAME) {
        this.MERCHANT_NAME = MERCHANT_NAME;
    }

    public String getTERRITORY_HEAD() {
        return TERRITORY_HEAD;
    }

    public void setTERRITORY_HEAD(String TERRITORY_HEAD) {
        this.TERRITORY_HEAD = TERRITORY_HEAD;
    }

    String TERRITORY_HEAD;
}
