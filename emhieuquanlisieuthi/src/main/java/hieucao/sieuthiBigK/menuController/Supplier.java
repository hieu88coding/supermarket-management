/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hieucao.sieuthiBigK.menuController;

import hieucao.sieuthiBigK.menuController.MenuAdmin;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class Supplier extends javax.swing.JFrame {
    private DefaultTableModel tableModel;
    /**
     * Creates new form Supplier
     */
    public Supplier() {
        initComponents();
        SelectSup();
    }
    Connection Con = null;
    Statement St =null;
    ResultSet Rs =null;
    public void SelectSup(){
    try {
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarket","root","");
            St = Con.createStatement();
            Rs = St.executeQuery("Select * from supplier");
            ResultSetMetaData rsmd = Rs.getMetaData();
            tableModel =(DefaultTableModel)SupTbl.getModel();
            String []colsName = {"ID", "Name","Telephone"};
            tableModel.setColumnIdentifiers(colsName);
     
            String ID,Name,Telephone;
            while(Rs.next())
            {
                ID = Rs.getString(1);
                Name = Rs.getString(2);
                Telephone = Rs.getString(3);
                String[] add ={ID,Name,Telephone};
                tableModel.addRow(add);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        SupName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        SupId = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        SupTel = new javax.swing.JTextField();
        AddBtn = new javax.swing.JButton();
        UpdateBtn = new javax.swing.JButton();
        ClearBtn = new javax.swing.JButton();
        Delbtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        SupTbl = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        AddBtn1 = new javax.swing.JButton();
        name_src = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 102, 102));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Raleway ExtraBold", 1, 30)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 102, 102));
        jLabel7.setText("MANAGE SUPPLIERS");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Raleway ExtraBold", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 102, 102));
        jLabel2.setText("ID");

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Raleway ExtraBold", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 102, 102));
        jLabel3.setText("NAME");

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Raleway ExtraBold", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 102, 102));
        jLabel5.setText("TELEPHONE");

        SupTel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SupTelActionPerformed(evt);
            }
        });

        AddBtn.setBackground(new java.awt.Color(255, 102, 102));
        AddBtn.setFont(new java.awt.Font("Raleway Light", 1, 18)); // NOI18N
        AddBtn.setForeground(new java.awt.Color(255, 255, 255));
        AddBtn.setText("Add");
        AddBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 102), 3));
        AddBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddBtnMouseClicked(evt);
            }
        });
        AddBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddBtnActionPerformed(evt);
            }
        });

        UpdateBtn.setBackground(new java.awt.Color(255, 102, 102));
        UpdateBtn.setFont(new java.awt.Font("Raleway Light", 1, 18)); // NOI18N
        UpdateBtn.setForeground(new java.awt.Color(255, 255, 255));
        UpdateBtn.setText("Update");
        UpdateBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 102), 3));
        UpdateBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UpdateBtnMouseClicked(evt);
            }
        });
        UpdateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateBtnActionPerformed(evt);
            }
        });

        ClearBtn.setBackground(new java.awt.Color(255, 102, 102));
        ClearBtn.setFont(new java.awt.Font("Raleway Light", 1, 18)); // NOI18N
        ClearBtn.setForeground(new java.awt.Color(255, 255, 255));
        ClearBtn.setText("Clear");
        ClearBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 102), 3));
        ClearBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ClearBtnMouseClicked(evt);
            }
        });

        Delbtn.setBackground(new java.awt.Color(255, 102, 102));
        Delbtn.setFont(new java.awt.Font("Raleway Light", 1, 18)); // NOI18N
        Delbtn.setForeground(new java.awt.Color(255, 255, 255));
        Delbtn.setText("Delete");
        Delbtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 102), 3));
        Delbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DelbtnMouseClicked(evt);
            }
        });

        SupTbl.setFont(new java.awt.Font("Raleway Medium", 0, 14)); // NOI18N
        SupTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NAME", "TELEPHONE"
            }
        ));
        SupTbl.setGridColor(new java.awt.Color(102, 102, 102));
        SupTbl.setRowHeight(25);
        SupTbl.setSelectionBackground(new java.awt.Color(255, 102, 102));
        SupTbl.setSelectionForeground(new java.awt.Color(255, 255, 255));
        SupTbl.setShowGrid(true);
        SupTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SupTblMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(SupTbl);

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Raleway ExtraBold", 1, 30)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 102, 102));
        jLabel9.setText("SUPPLIER LIST");

        AddBtn1.setBackground(new java.awt.Color(255, 102, 102));
        AddBtn1.setFont(new java.awt.Font("Raleway Light", 1, 18)); // NOI18N
        AddBtn1.setForeground(new java.awt.Color(255, 255, 255));
        AddBtn1.setText("Search");
        AddBtn1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 102), 3));

        name_src.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                name_srcKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(SupName, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SupId, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(174, 174, 174)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(Delbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ClearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                                .addComponent(SupTel, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 856, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(225, 225, 225)))))
                .addContainerGap(27, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(301, 301, 301))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(AddBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(UpdateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(AddBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(name_src, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(SupTel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(SupId, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(SupName, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(120, 120, 120)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UpdateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Delbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ClearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(name_src)
                    .addComponent(AddBtn1, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE))
                .addGap(0, 86, Short.MAX_VALUE))
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(30, 110, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void SupTelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SupTelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SupTelActionPerformed

    private void AddBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddBtnMouseClicked
        // TODO add your handling code here:
        if(SupId.getText().isEmpty() || SupName.getText().isEmpty() || SupTel.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Missing Information");
        }else{
            try {
                Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarket","root","");
                PreparedStatement add =Con.prepareStatement("insert into SUPPLIER values(?,?,?)");
                add.setInt(1, Integer.valueOf(SupId.getText()));
                add.setString(2, SupName.getText());
                add.setString(3, SupTel.getText());
                int row = add.executeUpdate();
                JOptionPane.showMessageDialog(this, "Supplier Added Successfully");
                tableModel.getDataVector().removeAllElements();
                tableModel.fireTableDataChanged();
                SelectSup();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_AddBtnMouseClicked

    private void AddBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddBtnActionPerformed

    private void UpdateBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateBtnMouseClicked
        if(SupId.getText().isEmpty() || SupName.getText().isEmpty() || SupTel.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"Missing Infor");
        }else{
            try {
                Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarket","root","");
                String Query = "Update SUPPLIER set SUPNAME='" + SupName.getText() + "'" + ",SUPTP='" + SupTel.getText() + "'"+ "where SUPID=" + SupId.getText();
                Statement Add = Con.createStatement();
                Add.executeUpdate(Query);
                JOptionPane.showMessageDialog(this,"Seller Updated");
                tableModel.getDataVector().removeAllElements();
                tableModel.fireTableDataChanged();
                SelectSup();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_UpdateBtnMouseClicked

    private void UpdateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateBtnActionPerformed

    private void ClearBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClearBtnMouseClicked
        SupId.setText("");
        SupName.setText("");
        SupTel.setText("");
    }//GEN-LAST:event_ClearBtnMouseClicked

    private void DelbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DelbtnMouseClicked
        if(SupId.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Select Customer to be deleted");
        }else{
            try {
                Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarket","root","");
                String SId = SupId.getText();
                String Query = "Delete from SUPPLIER where SUPPLIER.SupID="+SId;
                Statement Add = Con.createStatement();
                Add.executeUpdate(Query);
                int delRow =SupTbl.getSelectedRow();
                JOptionPane.showMessageDialog(this, "Supplier successfully deleted");
                tableModel.removeRow(delRow);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_DelbtnMouseClicked

    private void SupTblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SupTblMouseClicked
        tableModel =(DefaultTableModel)SupTbl.getModel();
        int myIndex =SupTbl.getSelectedRow();
        SupId.setText(tableModel.getValueAt(myIndex, 0).toString());
        SupName.setText(tableModel.getValueAt(myIndex, 1).toString());
        SupTel.setText(tableModel.getValueAt(myIndex, 2).toString());
    }//GEN-LAST:event_SupTblMouseClicked

    private void name_srcKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_name_srcKeyReleased
        try{

            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarket","root","");
            St = Con.createStatement();
            Rs = St.executeQuery("Select * from supplier where SUPNAME LIKE'%"+name_src.getText()+"%'");
            ResultSetMetaData rsmd = Rs.getMetaData();
            tableModel =(DefaultTableModel)SupTbl.getModel();
            tableModel.setRowCount(0);
            String []colsName = {"ID", "Name","Telephone"};
            tableModel.setColumnIdentifiers(colsName);

            String ID,Name,Telephone;
            while(Rs.next())
            {
                ID = Rs.getString(1);
                Name = Rs.getString(2);
                Telephone = Rs.getString(3);
                String[] add ={ID,Name,Telephone};
                tableModel.addRow(add);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_name_srcKeyReleased

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        new MenuAdmin().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

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
            java.util.logging.Logger.getLogger(Supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Supplier().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddBtn;
    private javax.swing.JButton AddBtn1;
    private javax.swing.JButton ClearBtn;
    private javax.swing.JButton Delbtn;
    private javax.swing.JTextField SupId;
    private javax.swing.JTextField SupName;
    private javax.swing.JTable SupTbl;
    private javax.swing.JTextField SupTel;
    private javax.swing.JButton UpdateBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField name_src;
    // End of variables declaration//GEN-END:variables
}
