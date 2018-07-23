package com.madprateek.inventorymap.ModelClasses;

public class MapDetailsModel {

    String otnNo;
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSaveDate() {
        return saveDate;
    }

    public void setSaveDate(String saveDate) {
        this.saveDate = saveDate;
    }

    String saveDate;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    String location;
    String lengthInInches,karni1,karni2,dharawat;

    public MapDetailsModel() {

    }

    public String getOtnNo() {
        return otnNo;
    }

    public void setOtnNo(String otnNo) {
        this.otnNo = otnNo;
    }

    public String getLengthInInches() {
        return lengthInInches;
    }

    public void setLengthInInches(String lengthInInches) {
        this.lengthInInches = lengthInInches;
    }

    public String getKarni1() {
        return karni1;
    }

    public void setKarni1(String karni1) {
        this.karni1 = karni1;
    }

    public String getKarni2() {
        return karni2;
    }

    public void setKarni2(String karni2) {
        this.karni2 = karni2;
    }

    public String getDharawat() {
        return dharawat;
    }

    public void setDharawat(String dharawat) {
        this.dharawat = dharawat;
    }

    public MapDetailsModel(String otnNo, String lengthInInches, String karni1, String karni2, String dharawat, String saveDate, String location) {

        this.otnNo = otnNo;
        this.lengthInInches = lengthInInches;
        this.karni1 = karni1;
        this.karni2 = karni2;
        this.dharawat = dharawat;
        this.saveDate = saveDate;
        this.location = location;
    }
}
