package com.madprateek.inventorymap.ModelClasses;

public class QualityCheckModel {

    String mapNo,dharawat,tani,design,color;

    public QualityCheckModel() {

    }

    public String getMapNo() {
        return mapNo;
    }

    public void setMapNo(String mapNo) {
        this.mapNo = mapNo;
    }

    public String getDharawat() {
        return dharawat;
    }

    public void setDharawat(String dharawat) {
        this.dharawat = dharawat;
    }

    public String getTani() {
        return tani;
    }

    public void setTani(String tani) {
        this.tani = tani;
    }

    public String getDesign() {
        return design;
    }

    public void setDesign(String design) {
        this.design = design;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public QualityCheckModel(String mapNo, String dharawat, String tani, String design, String color) {

        this.mapNo = mapNo;
        this.dharawat = dharawat;
        this.tani = tani;
        this.design = design;
        this.color = color;
    }
}
