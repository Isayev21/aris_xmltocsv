package com.example.aris_xmltocsv;

import com.example.aris_xmltocsv.entities.Bills;
import com.example.aris_xmltocsv.entities.InsideLines;
import com.example.aris_xmltocsv.service.DaoSortResult;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ArisXmltocsvApplication {

    public static void main(String[] args) {
        DaoSortResult daoSortResult = new DaoSortResult();

        List<Bills> billsList = daoSortResult.readBillsXml();
        daoSortResult.generateBillsCsv(billsList);

        List<InsideLines> insideLinesList = daoSortResult.readLinesXml();
        daoSortResult.generateLinesCsv(insideLinesList);
        SpringApplication.run(ArisXmltocsvApplication.class, args);
    }

}
