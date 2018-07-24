package com.madprateek.inventorymap.ModelClasses;

public class QualityCheckModel {

    String mapNo,dharawatKam, dharawatJyada, taniDhili, taniTight, designSahi, designGalat, colorSahi, colorGalat;

    public QualityCheckModel() {

    }

    public String getMapNo() {
        return mapNo;
    }

    public void setMapNo(String mapNo) {
        this.mapNo = mapNo;
    }

    public QualityCheckModel(String mapNo, String dharawatKam, String dharawatJyada, String taniDhili, String taniTight, String designSahi, String designGalat, String colorSahi, String colorGalat) {
        this.mapNo = mapNo;
        this.dharawatKam = dharawatKam;
        this.dharawatJyada = dharawatJyada;
        this.taniDhili = taniDhili;
        this.taniTight = taniTight;
        this.designSahi = designSahi;
        this.designGalat = designGalat;
        this.colorSahi = colorSahi;
        this.colorGalat = colorGalat;
    }

    public String getDharawatKam() {

        return dharawatKam;
    }

    public void setDharawatKam(String dharawatKam) {
        this.dharawatKam = dharawatKam;
    }

    public String getDharawatJyada() {
        return dharawatJyada;
    }

    public void setDharawatJyada(String dharawatJyada) {
        this.dharawatJyada = dharawatJyada;
    }

    public String getTaniDhili() {
        return taniDhili;
    }

    public void setTaniDhili(String taniDhili) {
        this.taniDhili = taniDhili;
    }

    public String getTaniTight() {
        return taniTight;
    }

    public void setTaniTight(String taniTight) {
        this.taniTight = taniTight;
    }

    public String getDesignSahi() {
        return designSahi;
    }

    public void setDesignSahi(String designSahi) {
        this.designSahi = designSahi;
    }

    public String getDesignGalat() {
        return designGalat;
    }

    public void setDesignGalat(String designGalat) {
        this.designGalat = designGalat;
    }

    public String getColorSahi() {
        return colorSahi;
    }

    public void setColorSahi(String colorSahi) {
        this.colorSahi = colorSahi;
    }

    public String getColorGalat() {
        return colorGalat;
    }

    public void setColorGalat(String colorGalat) {
        this.colorGalat = colorGalat;
    }
}
