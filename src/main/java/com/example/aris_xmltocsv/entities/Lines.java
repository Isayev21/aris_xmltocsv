package com.example.aris_xmltocsv.entities;

public class Lines {
    private String currencyCode;
    private String serialNumber;
    private String suitableForAtm;
    private String fit;
    private String unfit;
    private String errorCode;

    public Lines() {
    }


    public String getCurrencyCode() {
        return currencyCode;
    }

    public Lines setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
        return this;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public Lines setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
        return this;
    }

    public String getSuitableForAtm() {
        return suitableForAtm;
    }

    public Lines setSuitableForAtm(String suitableForAtm) {
        this.suitableForAtm = suitableForAtm;
        return this;
    }

    public String getFit() {
        return fit;
    }

    public Lines setFit(String fit) {
        this.fit = fit;
        return this;
    }

    public String getUnfit() {
        return unfit;
    }

    public Lines setUnfit(String unfit) {
        this.unfit = unfit;
        return this;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public Lines setErrorCode(String errorCode) {
        this.errorCode = errorCode;
        return this;
    }

    @Override
    public String toString() {
        return "Lines{" +
                "currencyCode='" + currencyCode + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", suitableForAtm='" + suitableForAtm + '\'' +
                ", fit='" + fit + '\'' +
                ", unfit='" + unfit + '\'' +
                ", errorCode='" + errorCode + '\'' +
                '}';
    }
}

