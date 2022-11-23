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
public class InvoiceModel {
    
    public int invoiceNumber;
    public String invoiceDate;
    public String customerName;
    public double invoiceTotal;
    public ArrayList<InvoiceItemModel> invoiceItemsList ;

  
    
    
    public InvoiceModel()
    {
        invoiceItemsList= new ArrayList<>();
    }
    
    public void setInvoice(int invoiceNumber, String invoiceDate,String customerName,ArrayList<InvoiceItemModel> invoiceItemsList)
    {
        this.invoiceNumber = invoiceNumber;
        this.invoiceDate = invoiceDate;
        this.customerName = customerName;
        setInvoiceItemsList(invoiceItemsList);
        calculateInvoiceTotal();
    }
    
    public void calculateInvoiceTotal ()
    {
        this.invoiceTotal = 0;
        for(InvoiceItemModel item : invoiceItemsList)
        {
            invoiceTotal+=item.getItemtotal();
                
        }
        
         
        
    }
    
    public int getInvoiceNumber() {
        return invoiceNumber;
    }    

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getInvoiceTotal() {
        return invoiceTotal;
    }
    
    public void setInvoiceItemsList(ArrayList<InvoiceItemModel> invoiceItemsList) {
        for(InvoiceItemModel item :invoiceItemsList){
            if(item.getInvoiceNumber()==this.invoiceNumber)
            {
                this.invoiceItemsList.add(item);
            }
            
        }
        
        
    }

    public ArrayList<InvoiceItemModel> getInvoiceItemsList() {
        return invoiceItemsList;
    }

    public void updateInvoice(InvoiceModel newInvoiceModel) {
        
        this.customerName=newInvoiceModel.getCustomerName();
        this.invoiceDate=newInvoiceModel.getInvoiceDate();
        this.invoiceTotal=newInvoiceModel.getInvoiceTotal();
        this.invoiceItemsList = newInvoiceModel.getInvoiceItemsList();
    }
    
    
}
