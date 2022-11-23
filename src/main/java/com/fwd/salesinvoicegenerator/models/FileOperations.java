/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fwd.salesinvoicegenerator.models;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import com.opencsv.CSVWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;

/**
 *
 * @author rafikadel
 */
public class FileOperations {

    private final String invoicesFilePath = "src/main/java/resources/invoices.csv";
    private final String invoiceItemsFilePath = "src/main/java/resources/invoicesItems.csv";

    public ArrayList<InvoiceItemModel> readInvoiceItemData() {

        ArrayList<InvoiceItemModel> invoiceItemsList = new ArrayList<>();
        String line = "";
        String splitBy = ",";
        try {
//parsing a CSV file into BufferedReader class constructor  
            BufferedReader br = new BufferedReader(new FileReader(invoiceItemsFilePath));
            while ((line = br.readLine()) != null) {
                String[] item = line.split(splitBy);
                InvoiceItemModel invoiceItem = new InvoiceItemModel(Integer.parseInt(item[0]),
                        item[1], Double.parseDouble(item[2]), Integer.parseInt(item[3]));
                invoiceItemsList.add(invoiceItem);
            }
            if (!invoiceItemsFilePath.split("[.]")[1].contains("csv")) {
                throw new Exception("wrong file format");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return invoiceItemsList;
    }

    public InvoiceListModel readInvoicesData(ArrayList<InvoiceItemModel> invoicesList) {

        InvoiceListModel invoiceListModel = new InvoiceListModel();
        String line = "";
        String splitBy = ",";
        try {
//parsing a CSV file into BufferedReader class constructor  
            BufferedReader br = new BufferedReader(new FileReader(invoicesFilePath));
            while ((line = br.readLine()) != null) {
                String[] item = line.split(splitBy);
                InvoiceModel invoiceModel = new InvoiceModel();
                invoiceModel.setInvoice(Integer.parseInt(item[0]), item[1], item[2], invoicesList);
                invoiceListModel.getInvoiceModelList().add(invoiceModel);
            }
            if (!invoicesFilePath.split("[.]")[1].contains("csv")) {
                throw new Exception("wrong file format");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return invoiceListModel;
    }

    public void writeCSV(InvoiceListModel invoiceListModel) {

        try {
            CSVWriter writer = new CSVWriter(new FileWriter(invoicesFilePath),
                    CSVWriter.DEFAULT_SEPARATOR,
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.RFC4180_LINE_END);
            for (InvoiceModel invoice : invoiceListModel.getInvoiceModelList()) {
                String line[] = {String.valueOf(invoice.getInvoiceNumber()), invoice.getInvoiceDate(), invoice.getCustomerName()};
                writer.writeNext(line);
            }

            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void writeCSVForItems(InvoiceListModel invoiceListModel) {

        try {
            CSVWriter writer = new CSVWriter(new FileWriter(invoiceItemsFilePath),
                    CSVWriter.DEFAULT_SEPARATOR,
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.RFC4180_LINE_END);

            for (InvoiceModel invoice : invoiceListModel.getInvoiceModelList()) {

                System.out.println(invoice.invoiceNumber);
                System.out.println("{");
                System.out.println(invoice.invoiceDate);
                System.out.println(invoice.customerName);

                for (InvoiceItemModel invoiceitem : invoice.getInvoiceItemsList()) {

                    String line[] = {String.valueOf(invoiceitem.getInvoiceNumber()), invoiceitem.getItemName(), String.valueOf(invoiceitem.getItemPrice()), String.valueOf(invoiceitem.getCount())};
                    System.out.println(line[1] + " " + line[2] + " " + line[3]);
                    writer.writeNext(line);
                }
                
                System.out.println("}");
            }

            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
