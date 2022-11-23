/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fwd.salesinvoicegenerator.models;

/**
 *
 * @author rafikadel
 */
public class InvoiceItemModel {
    
  private int invoiceNumber;
  private String itemName;
  private double itemPrice;
  private int count;
  private double itemtotal;

    public InvoiceItemModel(int invoiceNumber, String itemName, double itemPrice, int count) {
        this.invoiceNumber = invoiceNumber;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.count = count;
        this.itemtotal = itemPrice*count;
    }

    public double getItemtotal() {
        return itemtotal;
    } 
    
    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public int getCount() {
        return count;
    }

    public String getItemName() {
        return itemName;
    }
    
    
    
    
}
