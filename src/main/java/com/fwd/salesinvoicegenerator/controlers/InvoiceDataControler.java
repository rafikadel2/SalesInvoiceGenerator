/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fwd.salesinvoicegenerator.controlers;

import com.fwd.salesinvoicegenerator.models.*;
import com.fwd.salesinvoicegenerator.view.MainFrame;

import java.util.ArrayList;

/**
 * @author rafikadel
 */
public class InvoiceDataControler {

    private FileOperations fileOperations;
    private MainFrame mainFrame;
    ArrayList<InvoiceItemModel> invoiceItemsList;
    InvoiceListModel invoiceListModel;
    InvoiceModel loadedInvoice;

    public InvoiceDataControler(MainFrame mainFrame) {
        fileOperations = new FileOperations();
        this.mainFrame = mainFrame;

    }

    public void loadData() {
        invoiceItemsList = fileOperations.readInvoiceItemData();
        invoiceListModel = fileOperations.readInvoicesData(invoiceItemsList);
        System.out.println("last item count");
        System.out.println(invoiceItemsList.get(invoiceItemsList.size() - 1).getInvoiceNumber());
        System.out.println(invoiceListModel.getInvoiceModelList().get(invoiceListModel.getInvoiceModelList().size() - 1).getInvoiceNumber());
        populateInvoicesListTable();

    }

    private void populateInvoicesListTable() {
        clearInvoicesTableContent();
        for (int i = 0; i < invoiceListModel.getInvoiceModelList().size(); i++) {
            incrementInvoicesTableRowsCount();
            mainFrame.getInvoicesListTable().getModel().setValueAt(invoiceListModel.getInvoiceModelList().get(i).getInvoiceNumber(), i, 0);
            mainFrame.getInvoicesListTable().getModel().setValueAt(invoiceListModel.getInvoiceModelList().get(i).getInvoiceDate(), i, 1);
            mainFrame.getInvoicesListTable().getModel().setValueAt(invoiceListModel.getInvoiceModelList().get(i).getCustomerName(), i, 2);
            mainFrame.getInvoicesListTable().getModel().setValueAt(invoiceListModel.getInvoiceModelList().get(i).getInvoiceTotal(), i, 3);
        }

    }

    public void loadInvoiceDetails(int invoiceNumber) {
        loadedInvoice = invoiceListModel.getInvoiceWithNumber(invoiceNumber);
        mainFrame.getInvoiceNumberValue().setText(String.valueOf(loadedInvoice.getInvoiceNumber()));

        mainFrame.getInvoiceDateTF().setText(loadedInvoice.getInvoiceDate());
        mainFrame.getInvoiceTotalValue().setText(String.valueOf(loadedInvoice.getInvoiceTotal()));
        mainFrame.getInvoiceNameTF().setText(loadedInvoice.getCustomerName());
        clearInvoiceItemsTableContent();
        mainFrame.defaultInvoiceItemTable.setRowCount(loadedInvoice.getInvoiceItemsList().size());
        mainFrame.getInvoiceItemsTable().getModel().setValueAt(mainFrame.defaultInvoiceItemTable.getRowCount(), mainFrame.defaultInvoiceItemTable.getRowCount() - 1, 0);

        for (int i = 0; i < loadedInvoice.getInvoiceItemsList().size(); i++) {

            mainFrame.getInvoiceItemsTable().getModel().setValueAt(i + 1, i, 0);
            mainFrame.getInvoiceItemsTable().getModel().setValueAt(loadedInvoice.getInvoiceItemsList().get(i).getItemName(), i, 1);
            mainFrame.getInvoiceItemsTable().getModel().setValueAt(loadedInvoice.getInvoiceItemsList().get(i).getItemPrice(), i, 2);
            mainFrame.getInvoiceItemsTable().getModel().setValueAt(loadedInvoice.getInvoiceItemsList().get(i).getCount(), i, 3);
            mainFrame.getInvoiceItemsTable().getModel().setValueAt(loadedInvoice.getInvoiceItemsList().get(i).getItemtotal(), i, 4);
        }

    }

    public void clearInvoicesTableContent() {
        mainFrame.defaultInvoicesListTable.setRowCount(0);
        mainFrame.getInvoicesListTable().setModel(mainFrame.defaultInvoicesListTable);
    }
    public void incrementInvoicesTableRowsCount() {
        int currentCount = mainFrame.defaultInvoicesListTable.getRowCount();
        System.out.println("Before count "+ currentCount);
        mainFrame.defaultInvoicesListTable.setRowCount(++currentCount);
        System.out.println("my default count is " );mainFrame.defaultInvoicesListTable.getRowCount();
        mainFrame.getInvoicesListTable().setModel(mainFrame.defaultInvoicesListTable);
        System.out.println("after count "+ mainFrame.getInvoicesListTable().getRowCount());

    }
    public void clearInvoiceItemsTableContent() {

        mainFrame.defaultInvoiceItemTable.setRowCount(0);
        mainFrame.getInvoiceItemsTable().setModel(mainFrame.defaultInvoiceItemTable);
//        mainFrame.defaultInvoiceItemTable.setRowCount(1);
//        mainFrame.getInvoiceItemsTable().getModel().setValueAt(mainFrame.defaultInvoiceItemTable.getRowCount(), mainFrame.defaultInvoiceItemTable.getRowCount() - 1, 0);

    }

    public int getNextInvoiceNumber() {
        int lastElementIndex = invoiceListModel.getInvoiceModelList().size() - 1;
        return invoiceListModel.getInvoiceModelList().get(lastElementIndex).getInvoiceNumber() + 1;

    }

    public void saveInvoice() {

        ArrayList<InvoiceItemModel> newInvoiceItems = new ArrayList<>();
        InvoiceModel newInvoiceModel = new InvoiceModel();
        System.out.println("count " + mainFrame.getInvoiceItemsTable().getRowCount());
        for (int i = 0; i < mainFrame.getInvoiceItemsTable().getRowCount(); i++) {
            String itemName = mainFrame.getInvoiceItemsTable().getModel().getValueAt(i, 1).toString();
            double itemPrice = Double.parseDouble(mainFrame.getInvoiceItemsTable().getModel().getValueAt(i, 2).toString());
            int itemCount = Integer.parseInt(mainFrame.getInvoiceItemsTable().getModel().getValueAt(i, 3).toString());
            InvoiceItemModel item = new InvoiceItemModel(Integer.parseInt(mainFrame.getInvoiceNumberValue().getText()), itemName, itemPrice, itemCount);
            newInvoiceItems.add(item);
        }

        newInvoiceModel.setInvoice(Integer.parseInt(mainFrame.getInvoiceNumberValue().getText()), mainFrame.getInvoiceDateTF().getText(), mainFrame.getInvoiceNameTF().getText(), newInvoiceItems);

        if (Integer.parseInt(mainFrame.getInvoiceNumberValue().getText()) == getNextInvoiceNumber()) {
            //add record 
            invoiceListModel.getInvoiceModelList().add(newInvoiceModel);
            loadInvoiceDetails(Integer.parseInt(mainFrame.getInvoiceNumberValue().getText()));
            mainFrame.defaultInvoicesListTable.setRowCount(invoiceListModel.getInvoiceModelList().size());
        } else {
            // update record 
            for (int i = 0; i < invoiceListModel.getInvoiceModelList().size(); i++) {

                if (invoiceListModel.getInvoiceModelList().get(i).invoiceNumber == newInvoiceModel.getInvoiceNumber()) {
                    invoiceListModel.getInvoiceModelList().get(i).updateInvoice(newInvoiceModel);
                }
            }
        }
        populateInvoicesListTable();

    }

    public void removeInvoiceWithNumber(int invoiceNumber) {
        InvoiceListModel tempInvoices = invoiceListModel;
        ArrayList<InvoiceItemModel> tempItems = invoiceItemsList;

        for (int i = 0; i < invoiceListModel.getInvoiceModelList().size(); i++) {

            if (invoiceListModel.getInvoiceModelList().get(i).getInvoiceNumber() == invoiceNumber) {
                tempInvoices.getInvoiceModelList().remove(i);
                break;
            }

        }

        for (int i = 0; i < invoiceItemsList.size(); i++) {

            if (invoiceItemsList.get(i).getInvoiceNumber() == invoiceNumber) {
                tempItems.remove(i);

            }

        }

        invoiceListModel = tempInvoices;
        invoiceItemsList = tempItems;

    }

    public void expoetToCSV() {

        fileOperations.writeCSV(invoiceListModel);
        fileOperations.writeCSVForItems(invoiceListModel);

    }

}
