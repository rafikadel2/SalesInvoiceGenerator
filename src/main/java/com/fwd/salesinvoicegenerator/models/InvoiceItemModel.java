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

    public InvoiceItemModel(int invoiceNumber, String itemName, int itemPrice, int count, int itemtotal) {
        this.invoiceNumber = invoiceNumber;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.count = count;
        this.itemtotal = itemtotal;
    }
  
  
  
  
  
}
