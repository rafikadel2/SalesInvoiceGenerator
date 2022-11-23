/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fwd.salesinvoicegenerator.models;

import java.util.ArrayList;

/**
 *
 * @author rafikadel
 */
public class InvoiceListModel {
    
    private ArrayList<InvoiceModel> invoiceModelList;

    public ArrayList<InvoiceModel> getInvoiceModelList() {
        return invoiceModelList;
    }
    
    public InvoiceListModel()
    {
        invoiceModelList= new ArrayList<>();
    }
    
    
    public InvoiceModel getInvoiceWithNumber(int invoiceNumber)
    {
        for(InvoiceModel invoice : invoiceModelList)
        {
          if(invoice.getInvoiceNumber()==invoiceNumber)
              return invoice;
        
        }
        return null;
    }
    
    
}
