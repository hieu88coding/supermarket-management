/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hieucao.sieuthiBigK.menuController;

import hieucao.sieuthiBigK.reportsController.ReportView;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class Invoice extends javax.swing.JFrame {
    private DefaultTableModel tableModel;
    /**
     * Creates new form Invoice
     */
    public Invoice() {
        initComponents();
        SelectInv();
    }
    Connection Con = null;
    Statement St =null;
    ResultSet Rs =null;
    public void SelectInv(){
        double PaidTxt=0.0,BalanceTxt=0.0;
    try {
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarket","root","");
            St = Con.createStatement();
            Rs = St.executeQuery("Select * from bill");
            ResultSetMetaData rsmd = Rs.getMetaData();
            tableModel =(DefaultTableModel)InVTable.getModel();
            String []colsName = {"BillId", "CusId","Customer Name","Total","Balance"};
            tableModel.setColumnIdentifiers(colsName);

            String BillId,CusId,CustomerName,Total,Balance;
            while(Rs.next())
            {
                BillId = Rs.getString(1);
                CusId = Rs.getString(2);
                CustomerName = Rs.getString(3);
                Total =Rs.getString(4);
                Balance= Rs.getString(5);
                String[] add ={BillId,CusId,CustomerName,Total,Balance};
                tableModel.addRow(add);
                PaidTxt+=Double.valueOf(Total);
                BalanceTxt+=Double.valueOf(Balance);
            }
            Paid.setText(String.valueOf(PaidTxt));
            Due.setText(String.valueOf(BalanceTxt));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        BilId = new javax.swing.JTextField();
        AddBtn = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        InVTable = new javax.swing.JTable();
        name_src = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        DelBtn = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        Paid = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        Due = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel5.setBackground(new java.awt.Color(255, 102, 102));
        jPanel5.setPreferredSize(new java.awt.Dimension(1137, 937));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setPreferredSize(new java.awt.Dimension(960, 857));

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Raleway ExtraBold", 1, 30)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 102, 102));
        jLabel13.setText("INVOICING");

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Raleway ExtraBold", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 102, 102));
        jLabel7.setText("BILLID");

        BilId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                BilIdKeyReleased(evt);
            }
        });

        AddBtn.setBackground(new java.awt.Color(255, 102, 102));
        AddBtn.setFont(new java.awt.Font("Raleway Light", 1, 18)); // NOI18N
        AddBtn.setForeground(new java.awt.Color(255, 255, 255));
        AddBtn.setText("Show Invoice");
        AddBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 102), 3));
        AddBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddBtnMouseClicked(evt);
            }
        });

        InVTable.setFont(new java.awt.Font("Raleway Medium", 0, 14)); // NOI18N
        InVTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "BillID", "CusID", "Customer Name", "Total", "Balance"
            }
        ));
        InVTable.setGridColor(new java.awt.Color(102, 102, 102));
        InVTable.setRowHeight(25);
        InVTable.setSelectionBackground(new java.awt.Color(255, 102, 102));
        InVTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        InVTable.setShowGrid(true);
        jScrollPane3.setViewportView(InVTable);

        name_src.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                name_srcKeyReleased(evt);
            }
        });

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Raleway ExtraBold", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 102, 102));
        jLabel8.setText("CUSTOMER NAME");

        DelBtn.setBackground(new java.awt.Color(255, 102, 102));
        DelBtn.setFont(new java.awt.Font("Raleway Light", 1, 18)); // NOI18N
        DelBtn.setForeground(new java.awt.Color(255, 255, 255));
        DelBtn.setText("Return");
        DelBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 102), 3));
        DelBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DelBtnMouseClicked(evt);
            }
        });
        DelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DelBtnActionPerformed(evt);
            }
        });

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 102, 102));
        jLabel9.setText("TOTAL PAID:");

        Paid.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Paid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                PaidKeyReleased(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 102, 102));
        jLabel6.setText("TOTAL DUE:");
        jLabel6.setToolTipText("");

        Due.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addGap(500, 500, 500))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BilId, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                    .addComponent(name_src))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(98, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(AddBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(DelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 763, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(99, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(279, 279, 279)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Paid)
                    .addComponent(Due, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BilId, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(name_src, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Paid, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Due)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(219, Short.MAX_VALUE))
        );

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Raleway ExtraBold", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("X");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 199, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(121, 121, 121)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 1305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 914, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void name_srcKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_name_srcKeyReleased
        try{

            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarket","root","");
            St = Con.createStatement();
            Rs = St.executeQuery("Select * from bill where CUSNAME LIKE'%"+name_src.getText()+"%'");
            ResultSetMetaData rsmd = Rs.getMetaData();
            tableModel =(DefaultTableModel)InVTable.getModel();
            tableModel.setRowCount(0);
            String []colsName = {"BillId", "CusId","Customer Name","Total","Balance"};
            tableModel.setColumnIdentifiers(colsName);

            String BillId,CusId,CustomerName,Total,Balance;
            while(Rs.next())
            {
                BillId = Rs.getString(1);
                CusId = Rs.getString(2);
                CustomerName = Rs.getString(3);
                Total =Rs.getString(4);
                Balance= Rs.getString(5);
                String[] add ={BillId,CusId,CustomerName,Total,Balance};
                tableModel.addRow(add);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_name_srcKeyReleased

    private void AddBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddBtnMouseClicked
            HashMap para = new HashMap();
            para.put("invo_para", BilId.getText());
        
            ReportView r =new ReportView("src\\main\\java\\hieucao\\sieuthiBigK\\reportsController\\report1.jasper",para);
            r.setVisible(true);
        
    }//GEN-LAST:event_AddBtnMouseClicked

    private void DelBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DelBtnMouseClicked
            this.dispose();
        
    }//GEN-LAST:event_DelBtnMouseClicked

    private void BilIdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BilIdKeyReleased
        try{

            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarket","root","");
            St = Con.createStatement();
            Rs = St.executeQuery("Select * from bill where BILLID LIKE'%"+BilId.getText()+"%'");
            ResultSetMetaData rsmd = Rs.getMetaData();
            tableModel =(DefaultTableModel)InVTable.getModel();
            tableModel.setRowCount(0);
            String []colsName = {"BillId", "CusId","Customer Name","Total","Balance"};
            tableModel.setColumnIdentifiers(colsName);

            String BillId,CusId,CustomerName,Total,Balance;
            while(Rs.next())
            {
                BillId = Rs.getString(1);
                CusId = Rs.getString(2);
                CustomerName = Rs.getString(3);
                Total =Rs.getString(4);
                Balance= Rs.getString(5);
                String[] add ={BillId,CusId,CustomerName,Total,Balance};
                tableModel.addRow(add);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_BilIdKeyReleased

    private void DelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DelBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DelBtnActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        new MenuAdmin().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void PaidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PaidKeyReleased
       
    }//GEN-LAST:event_PaidKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Invoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Invoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Invoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Invoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Invoice().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddBtn;
    private javax.swing.JTextField BilId;
    private javax.swing.JButton DelBtn;
    private javax.swing.JTextField Due;
    private javax.swing.JTable InVTable;
    private javax.swing.JTextField Paid;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField name_src;
    // End of variables declaration//GEN-END:variables
}
