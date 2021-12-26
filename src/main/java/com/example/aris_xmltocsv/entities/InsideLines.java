package com.example.aris_xmltocsv.entities;


import java.util.ArrayList;

public class InsideLines {
    private String nominal;

    private ArrayList<Lines> lines;


    public InsideLines() {
    }

    public String getNominal() {
        return nominal;
    }

    public InsideLines setNominal(String nominal) {
        this.nominal = nominal;
        return this;
    }

    public ArrayList<Lines> getLines() {
        return lines;
    }

    public InsideLines setLines(ArrayList<Lines> lines) {
        this.lines = lines;
        return this;
    }

    @Override
    public String toString() {
        return "InsideLines{" +
                "nominal='" + nominal + '\'' +
                ", lines=" + lines +
                '}';
    }
}
