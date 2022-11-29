/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.fwd.salesinvoicegenerator.view;

import com.fwd.salesinvoicegenerator.controlers.InvoiceDataControler;

/**
 *
 * @author rafikadel
 */
public class SettingFilesDialoge extends javax.swing.JDialog {

    /**
     * Creates new form SettingFilesDialoge
     */
    private InvoiceDataControler invoiceDataControler;

    public SettingFilesDialoge(java.awt.Frame parent, boolean modal, InvoiceDataControler invoiceDataControler) {
        super(parent, modal);
        initComponents();
        this.invoiceDataControler = invoiceDataControler;
        this.headersValidation.setVisible(false);
        this.itemsValidation.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        OpenFileBtn = new javax.swing.JButton();
        CancelBtn = new javax.swing.JButton();
        incoiveHeaders = new javax.swing.JTextField();
        invoiceItems = new javax.swing.JTextField();
        headersValidation = new javax.swing.JLabel();
        itemsValidation = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Choose Files");

        jLabel1.setText("Invoice Headers");

        jLabel2.setText("Invoice Items");

        OpenFileBtn.setText("Open");
        OpenFileBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenFileBtnActionPerformed(evt);
            }
        });

        CancelBtn.setText("Cancel");
        CancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelBtnActionPerformed(evt);
            }
        });

        incoiveHeaders.setToolTipText("please enter absolute path of invoice headers");

        invoiceItems.setToolTipText("please enter absolute path of invoice items");
        invoiceItems.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invoiceItemsActionPerformed(evt);
            }
        });

        headersValidation.setForeground(new java.awt.Color(204, 0, 0));
        headersValidation.setText("Above field is mandatory");

        itemsValidation.setForeground(new java.awt.Color(204, 0, 0));
        itemsValidation.setText("Above field is mandatory");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(359, Short.MAX_VALUE)
                .addComponent(CancelBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(OpenFileBtn)
                .addGap(106, 106, 106))
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(76, 76, 76)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(invoiceItems, javax.swing.GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
                        .addComponent(incoiveHeaders))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(itemsValidation)
                            .addComponent(headersValidation))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(incoiveHeaders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(headersValidation)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(invoiceItems, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(itemsValidation)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OpenFileBtn)
                    .addComponent(CancelBtn))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OpenFileBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenFileBtnActionPerformed

        String invoicesHeadersPath, invoicesItemsPath;
        invoicesHeadersPath = incoiveHeaders.getText();
        invoicesItemsPath = invoiceItems.getText();
        if (!invoicesHeadersPath.equals("") || !invoicesItemsPath.equals("")) {
            invoiceDataControler.loadData(invoicesHeadersPath, invoicesItemsPath);
            this.setVisible(false);
        }
        else{
            this.headersValidation.setVisible(true);
            this.itemsValidation.setVisible(true);
            
        }


    }//GEN-LAST:event_OpenFileBtnActionPerformed

    private void CancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelBtnActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_CancelBtnActionPerformed

    private void invoiceItemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invoiceItemsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_invoiceItemsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelBtn;
    private javax.swing.JButton OpenFileBtn;
    private javax.swing.JLabel headersValidation;
    private javax.swing.JTextField incoiveHeaders;
    private javax.swing.JTextField invoiceItems;
    private javax.swing.JLabel itemsValidation;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
