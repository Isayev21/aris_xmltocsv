package com.example.aris_xmltocsv.entities;


public class Bills {
    private String userId;
    private String machineNumber;
    private String machineModel;
    private String depositNumber;
    private String packageNumber;
    private String startDateTime;
    private String endDateTime;
    private String sendDateTime;
    private boolean rejectionExists;
    private String currencyCode;
    private int qty;
    private long nominal;
    private long amount;
    private boolean rejected;

    public Bills() {
    }

    public String getUserId() {
        return userId;
    }

    public Bills setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String getMachineNumber() {
        return machineNumber;
    }

    public Bills setMachineNumber(String machineNumber) {
        this.machineNumber = machineNumber;
        return this;
    }

    public String getMachineModel() {
        return machineModel;
    }

    public Bills setMachineModel(String machineModel) {
        this.machineModel = machineModel;
        return this;
    }

    public String getDepositNumber() {
        return depositNumber;
    }

    public Bills setDepositNumber(String depositNumber) {
        this.depositNumber = depositNumber;
        return this;
    }

    public String getPackageNumber() {
        return packageNumber;
    }

    public Bills setPackageNumber(String packageNumber) {
        this.packageNumber = packageNumber;
        return this;
    }

    public String getStartDateTime() {
        return startDateTime;
    }

    public Bills setStartDateTime(String startDateTime) {
        this.startDateTime = startDateTime;
        return this;
    }

    public String getEndDateTime() {
        return endDateTime;
    }

    public Bills setEndDateTime(String endDateTime) {
        this.endDateTime = endDateTime;
        return this;
    }

    public String getSendDateTime() {
        return sendDateTime;
    }

    public Bills setSendDateTime(String sendDateTime) {
        this.sendDateTime = sendDateTime;
        return this;
    }

    public boolean isRejectionExists() {
        return rejectionExists;
    }

    public Bills setRejectionExists(boolean rejectionExists) {
        this.rejectionExists = rejectionExists;
        return this;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public Bills setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
        return this;
    }


    public int getQty() {
        return qty;
    }

    public Bills setQty(int qty) {
        this.qty = qty;
        return this;
    }

    public long getNominal() {
        return nominal;
    }

    public Bills setNominal(long nominal) {
        this.nominal = nominal;
        return this;
    }

    public long getAmount() {
        return amount;
    }

    public Bills setAmount(long amount) {
        this.amount = amount;
        return this;
    }

    public boolean isRejected() {
        return rejected;
    }

    public Bills setRejected(boolean rejected) {
        this.rejected = rejected;
        return this;
    }

    @Override
    public String toString() {
        return "Bills{" +
                "userId='" + userId + '\'' +
                ", machineNumber='" + machineNumber + '\'' +
                ", machineModel='" + machineModel + '\'' +
                ", depositNumber='" + depositNumber + '\'' +
                ", packageNumber='" + packageNumber + '\'' +
                ", startDateTime='" + startDateTime + '\'' +
                ", endDateTime='" + endDateTime + '\'' +
                ", sendDateTime='" + sendDateTime + '\'' +
                ", rejectionExists=" + rejectionExists +
                ", currencyCode='" + currencyCode + '\'' +
                ", qty=" + qty +
                ", nominal=" + nominal +
                ", amount=" + amount +
                ", rejected=" + rejected +
                '}';
    }
}

