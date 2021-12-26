package com.example.aris_xmltocsv.service;

import com.example.aris_xmltocsv.entities.Bills;
import com.example.aris_xmltocsv.entities.InsideLines;
import com.example.aris_xmltocsv.entities.Lines;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class DaoSortResult {

    //xml files path
    private static final String xmlFilePath1 = "xmlFiles\\T_K21F05-A04768_20211206144632274.xml";
    private static final String xmlFilePath2 = "xmlFiles\\T_K21F05-A04768_20211206144759244.xml";

    //path to the generated csv files
    private static final String csvGeneratedBills = "csvFiles\\bills.csv";
    private static final String csvGeneratedLines = "csvFiles\\lines.csv";

    private final static String BillsHeader = "UserID, MachineNumber, MachineModel, DepositNumber, PackageNumber, StartedAt, EndedAt, SendedAt, RejectionExists, CurrencyCode, Nominal, Quantity, Amount, Rejected";
    private final static String LinesHeader = "Nominal, SerialNumber, SuitableForATM, Fit, Unfit, ErrorCode";


    public List<Bills> readBillsXml() {
        try {
            File xmlFile = new File(xmlFilePath1);

            ArrayList<Bills> billsArrayList = new ArrayList<>();

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("line");

            NodeList nodeList1 = doc.getElementsByTagName("SortResult");
            Node node1 = nodeList1.item(0);
            Element element = (Element) node1;

            for (int j = 0; j < nodeList.getLength(); j++) {
                Node node = nodeList.item(j);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element e = (Element) node;

                    Bills billLines = new Bills();

                    billLines.setUserId(element.getAttribute("UserID"));
                    billLines.setMachineNumber(element.getAttribute("machineNumber"));
                    billLines.setMachineModel(element.getAttribute("machine"));
                    billLines.setDepositNumber(element.getAttribute("depositNumber"));
                    billLines.setPackageNumber(element.getAttribute("packageNumber"));
                    billLines.setStartDateTime(element.getAttribute("startDateTime"));
                    billLines.setEndDateTime(element.getAttribute("endDateTime"));
                    billLines.setSendDateTime(element.getAttribute("sendDateTime"));
                    billLines.setRejectionExists(Boolean.parseBoolean(element.getAttribute("rejectionExists")));
                    billLines.setCurrencyCode((e.getElementsByTagName("currencyCode").item(0).getTextContent()));
                    billLines.setNominal(Integer.parseInt(e.getElementsByTagName("nominal").item(0).getTextContent()));
                    billLines.setQty(Integer.parseInt(e.getElementsByTagName("qty").item(0).getTextContent()));
                    billLines.setAmount(Integer.parseInt(e.getElementsByTagName("nominal").item(0).getTextContent()) * Integer.parseInt(e.getElementsByTagName("qty").item(0).getTextContent()));
                    billLines.setRejected(Boolean.parseBoolean(e.getElementsByTagName("rejected").item(0).getTextContent()));
                    billsArrayList.add(billLines);

//                    System.out.println(billLines);

                }
            }
            return billsArrayList;
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public void generateBillsCsv(List<Bills> bills) {
        try (FileWriter writer = new FileWriter(csvGeneratedBills)) {

            writer.append(BillsHeader);
            for (Bills bill : bills) {
                writer.append("\n");
                writer.append((bill.getUserId()) + ",");
                writer.append((bill.getMachineNumber()) + ",");
                writer.append((bill.getMachineModel()) + ",");
                writer.append((bill.getDepositNumber()) + ",");
                writer.append((bill.getPackageNumber()) + ",");
                writer.append((bill.getStartDateTime()) + ",");
                writer.append((bill.getEndDateTime()) + ",");
                writer.append((bill.getSendDateTime()) + ",");
                writer.append((bill.isRejectionExists()) + ",");
                writer.append((bill.getCurrencyCode()) + ",");
                writer.append((bill.getNominal()) + ",");
                writer.append((bill.getQty()) + ",");
                writer.append((bill.getAmount()) + ",");
                writer.append((bill.isRejected()) + ",");

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public List<InsideLines> readLinesXml() {
        try {
            File xmlFile = new File(xmlFilePath1);
            ArrayList<InsideLines> insideLinesArrayList = new ArrayList<>();

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("line");
            for (int i = 0; i < nList.getLength(); i++) {
                Node node = nList.item(i);
                Element element = (Element) node;
                InsideLines insideLines1 = new InsideLines();
                ArrayList<Lines> linesArrayList = new ArrayList<>();

                insideLines1.setNominal(element.getElementsByTagName("nominal").item(0).getTextContent());

                int count = 1;
                while (Integer.parseInt(element.getElementsByTagName("qty").item(0).getTextContent()) >= count) {

                    Lines lines = new Lines();
                    NodeList noTags = element.getElementsByTagName("No" + count);
                    Element noTag = (Element) noTags.item(0);
                    lines.setSerialNumber(noTag.getElementsByTagName("SN").item(0).getTextContent());
                    lines.setSuitableForAtm(parseToString(Integer.parseInt(noTag.getElementsByTagName("ATM").item(0).getTextContent())));
                    lines.setFit(parseToString(Integer.parseInt(noTag.getElementsByTagName("FIT").item(0).getTextContent())));
                    lines.setUnfit(parseToString(Integer.parseInt(noTag.getElementsByTagName("Unfit").item(0).getTextContent())));
                    lines.setErrorCode(noTag.getElementsByTagName("ERROR").item(0).getTextContent());
                    linesArrayList.add(lines);
//                        System.out.println(lines);
                    count++;
                }
                insideLines1.setLines(linesArrayList);
                insideLinesArrayList.add(insideLines1);
            }
            return insideLinesArrayList;
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }


    public void generateLinesCsv(List<InsideLines> insideLines) {
        try (FileWriter writer = new FileWriter(csvGeneratedLines)) {
            for (InsideLines insideLine : insideLines) {
                writer.append(LinesHeader);
                writer.append("\n");

                for (Lines line : insideLine.getLines()) {

                    writer.append((insideLine.getNominal()) + ",");
                    writer.append((line.getSerialNumber()) + ",");
                    writer.append((line.getSuitableForAtm()) + ",");
                    writer.append((line.getFit()) + ",");
                    writer.append((line.getUnfit()) + ",");
                    writer.append((line.getErrorCode()) + ",");
                    writer.append("\n");
                }
                writer.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static String parseToString(int result) {
        if (result == 0) {
            return "False";
        } else
            return "True";
    }

}

