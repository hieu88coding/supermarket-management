/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hieucao.sieuthiBigK.menuController;

import hieucao.sieuthiBigK.reportsController.ReportView;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.plaf.FileChooserUI;
import javax.swing.table.DefaultTableModel;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Admin
 */
public class ProductMenu extends javax.swing.JFrame {

    /**
     * Creates new form ProductMenu
     */
    private DefaultTableModel tableModel;
    public ProductMenu() {
        initComponents();
        SelectProduct();
        GetCat();
        GetSup();
        SelectCat();
        GetUnit();
    }
    Connection Con = null;
    Statement St =null;
    ResultSet Rs =null;
    
    public void SelectProduct()
    {
        try {
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarket","root","");
            St = Con.createStatement();
            Rs = St.executeQuery("Select * from product");
            ResultSetMetaData rsmd = Rs.getMetaData();
            tableModel =(DefaultTableModel)ProductTbl.getModel();
            String []colsName = {"ID","Name","Cat", "Unit"," Price","Barcode","SupName","CostPrice","ExpiredDate","MFGDate","Quantity","Description","Company","Brand"};
            tableModel.setColumnIdentifiers(colsName);
     
            String ID,Name,Cat, Quantity, Price,Barcode,SupName,CostPrice,ExpiredDate,Unit,MFGDate,Description,Company,Brand;
            while(Rs.next())
            {
                ID = Rs.getString(1);
                Name = Rs.getString(2);
                Quantity = Rs.getString(3);
                Price =Rs.getString(4);
                Cat= Rs.getString(5);
                Unit=Rs.getString(12);
                Barcode=Rs.getString(6);
                SupName=Rs.getString(8);
                CostPrice=Rs.getString(9);
                ExpiredDate=Rs.getString(10);
                MFGDate=Rs.getString(11);
                Company=Rs.getString(13);
                Brand=Rs.getString(14);
                Description=Rs.getString(15);
                String[] add ={ID,Name,Cat, Unit, Price,Barcode,SupName,CostPrice,ExpiredDate,MFGDate,Quantity,Description,Company,Brand};
                tableModel.addRow(add);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
  
    }
    
    public void GetCat(){
        try {
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarket","root","");
            St = Con.createStatement();
            String Query ="Select * from category";
            Rs = St.executeQuery(Query);
            while (Rs.next()) {                
                String MyCat =Rs.getString("CATNAME");
                CatCb.addItem(MyCat);
                CatCb1.addItem(MyCat);
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void GetSup(){
        try {
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarket","root","");
            St = Con.createStatement();
            String Query ="Select * from supplier";
            Rs = St.executeQuery(Query);
            Vector v =new Vector();
            while (Rs.next()) {                
                v.add(Rs.getString("SupName"));
                DefaultComboBoxModel cm =new DefaultComboBoxModel(v);
                SupName.setModel(cm);
                SupName1.setModel(cm);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void GetUnit(){
        try {
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarket","root","");
            St = Con.createStatement();
            String Query ="Select * from unit";
            Rs = St.executeQuery(Query);
            Vector v =new Vector();
            while (Rs.next()) {                
                v.add(Rs.getString("NAME"));
                DefaultComboBoxModel cm =new DefaultComboBoxModel(v);
                Unit.setModel(cm);
               
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    public void SelectCat(){
    try {
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarket","root","");
            St = Con.createStatement();
            Rs = St.executeQuery("Select * from category");
            ResultSetMetaData rsmd = Rs.getMetaData();
            tableModel =(DefaultTableModel)CatTable.getModel();
            String []colsName = {"ID", "Name","Desc"};
            tableModel.setColumnIdentifiers(colsName);
     
            String ID,Name,Desc;
            while(Rs.next())
            {
                ID = Rs.getString(1);
                Name = Rs.getString(2);
                Desc = Rs.getString(3);
                String[] add ={ID,Name,Desc};
                tableModel.addRow(add);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ProductTbl = new javax.swing.JTable();
        name_src = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        ProdName = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        CatCb = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        comp = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        SupName = new javax.swing.JComboBox<>();
        jLabel33 = new javax.swing.JLabel();
        brand = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        ProdName1 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        ProdId = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        ProdPrice1 = new javax.swing.JTextField();
        ProdQty1 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        CatCb1 = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        Code1 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        SupName1 = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        CPrice1 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        exp_date = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        Unit = new javax.swing.JComboBox<>();
        jLabel26 = new javax.swing.JLabel();
        description = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        mfg_date = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        comp1 = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        brand1 = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        note = new javax.swing.JTextField();
        QRcodeBtn = new javax.swing.JButton();
        AddBtn = new javax.swing.JButton();
        UpdateBtn = new javax.swing.JButton();
        DelBtn = new javax.swing.JButton();
        ClearBtn = new javax.swing.JButton();
        ExImport = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        name_src1 = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        CatName = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        CatId = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        CatDesc = new javax.swing.JTextField();
        AddBtn4 = new javax.swing.JButton();
        UpdateBtn2 = new javax.swing.JButton();
        ClrBtn = new javax.swing.JButton();
        DelBtn2 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        CatTable = new javax.swing.JTable();
        jLabel32 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel4.setForeground(new java.awt.Color(255, 102, 102));

        jPanel2.setBackground(new java.awt.Color(255, 102, 102));

        jLabel7.setBackground(new java.awt.Color(255, 102, 102));
        jLabel7.setFont(new java.awt.Font("Raleway ExtraBold", 1, 30)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Admin Menu");

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Documents\\NetBeansProjects\\emhieuquanlisieuthi\\src\\main\\java\\images\\icons8-cat-64.png")); // NOI18N

        jLabel12.setBackground(new java.awt.Color(153, 153, 153));
        jLabel12.setFont(new java.awt.Font("Raleway ExtraBold", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Return");
        jLabel12.setToolTipText("");
        jLabel12.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(63, 63, 63))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(163, 163, 163)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addGap(84, 84, 84))
        );

        jTabbedPane2.setForeground(new java.awt.Color(255, 102, 102));
        jTabbedPane2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel25.setBackground(new java.awt.Color(255, 255, 255));
        jLabel25.setFont(new java.awt.Font("Raleway ExtraBold", 1, 30)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 102, 102));
        jLabel25.setText("MANAGE PRODUCTS");

        ProductTbl.setFont(new java.awt.Font("Raleway Medium", 0, 14)); // NOI18N
        ProductTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NAME", "QUANTITY", "PRICE", "CATEGORY", "BARCODE"
            }
        ));
        ProductTbl.setGridColor(new java.awt.Color(102, 102, 102));
        ProductTbl.setRowHeight(25);
        ProductTbl.setSelectionBackground(new java.awt.Color(255, 102, 102));
        ProductTbl.setSelectionForeground(new java.awt.Color(255, 255, 255));
        ProductTbl.setShowGrid(true);
        ProductTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProductTblMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ProductTbl);

        name_src.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        name_src.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                name_srcKeyReleased(evt);
            }
        });

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Raleway ExtraBold", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 102, 102));
        jLabel4.setText("NAME");

        ProdName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Raleway ExtraBold", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 102, 102));
        jLabel8.setText("CATEGORY");

        CatCb.setFont(new java.awt.Font("Raleway ExtraBold", 1, 12)); // NOI18N
        CatCb.setForeground(new java.awt.Color(255, 102, 102));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Raleway ExtraBold", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 102, 102));
        jLabel5.setText("COMPANY NAME");

        comp.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        comp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compActionPerformed(evt);
            }
        });

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Raleway ExtraBold", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 102, 102));
        jLabel13.setText("SUPLIER NAME");

        SupName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        SupName.setForeground(new java.awt.Color(255, 102, 102));
        SupName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SupNameActionPerformed(evt);
            }
        });

        jLabel33.setBackground(new java.awt.Color(255, 255, 255));
        jLabel33.setFont(new java.awt.Font("Raleway ExtraBold", 1, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 102, 102));
        jLabel33.setText("BRAND");

        brand.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        brand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brandActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ProdName)
                    .addComponent(CatCb, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(SupName, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(comp, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addComponent(jLabel33)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(brand, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(ProdName, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(CatCb, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(comp, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(brand, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel33))
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel8))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13)
                                    .addComponent(SupName, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 102));
        jLabel1.setText("SEARCH");

        jButton1.setBackground(new java.awt.Color(255, 102, 102));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Show Full Detail");
        jButton1.setToolTipText("");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(347, 347, 347)
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 930, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(name_src, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(72, 72, 72)
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(name_src, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(52, 52, 52)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(162, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("All Product's", jPanel5);

        jPanel1.setVerifyInputWhenFocusTarget(false);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Raleway ExtraBold", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 102, 102));
        jLabel10.setText("PROID :");

        ProdName1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Raleway ExtraBold", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 102, 102));
        jLabel16.setText("NAME :");

        ProdId.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("Raleway ExtraBold", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 102, 102));
        jLabel17.setText("QUANTITY :");

        ProdPrice1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        ProdQty1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ProdQty1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProdQty1ActionPerformed(evt);
            }
        });

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("Raleway ExtraBold", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 102, 102));
        jLabel18.setText("SELL PRICE :");

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setFont(new java.awt.Font("Raleway ExtraBold", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 102, 102));
        jLabel19.setText("CATEGORY :");

        CatCb1.setFont(new java.awt.Font("Raleway ExtraBold", 1, 12)); // NOI18N

        jLabel20.setBackground(new java.awt.Color(255, 255, 255));
        jLabel20.setFont(new java.awt.Font("Raleway ExtraBold", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 102, 102));
        jLabel20.setText("BARCODE :");

        Code1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Code1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Code1ActionPerformed(evt);
            }
        });

        jLabel22.setBackground(new java.awt.Color(255, 255, 255));
        jLabel22.setFont(new java.awt.Font("Raleway ExtraBold", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 102, 102));
        jLabel22.setText("SUPLIER NAME :");

        SupName1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        SupName1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SupName1ActionPerformed(evt);
            }
        });

        jLabel23.setBackground(new java.awt.Color(255, 255, 255));
        jLabel23.setFont(new java.awt.Font("Raleway ExtraBold", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 102, 102));
        jLabel23.setText("COST PRICE :");

        CPrice1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CPrice1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CPrice1ActionPerformed(evt);
            }
        });

        jLabel24.setBackground(new java.awt.Color(255, 255, 255));
        jLabel24.setFont(new java.awt.Font("Raleway ExtraBold", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 102, 102));
        jLabel24.setText("EXP DATE :");

        exp_date.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        exp_date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exp_dateActionPerformed(evt);
            }
        });

        jLabel21.setBackground(new java.awt.Color(255, 255, 255));
        jLabel21.setFont(new java.awt.Font("Raleway ExtraBold", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 102, 102));
        jLabel21.setText("UNIT:");

        Unit.setFont(new java.awt.Font("Raleway ExtraBold", 1, 12)); // NOI18N

        jLabel26.setBackground(new java.awt.Color(255, 255, 255));
        jLabel26.setFont(new java.awt.Font("Raleway ExtraBold", 1, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 102, 102));
        jLabel26.setText("DESCRIPTION :");
        jLabel26.setToolTipText("");

        description.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        description.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descriptionActionPerformed(evt);
            }
        });

        jLabel27.setBackground(new java.awt.Color(255, 255, 255));
        jLabel27.setFont(new java.awt.Font("Raleway ExtraBold", 1, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 102, 102));
        jLabel27.setText("MFG DATE :");

        mfg_date.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        mfg_date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mfg_dateActionPerformed(evt);
            }
        });

        jLabel34.setBackground(new java.awt.Color(255, 255, 255));
        jLabel34.setFont(new java.awt.Font("Raleway ExtraBold", 1, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 102, 102));
        jLabel34.setText("COMPANY :");

        comp1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        comp1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comp1ActionPerformed(evt);
            }
        });

        jLabel35.setBackground(new java.awt.Color(255, 255, 255));
        jLabel35.setFont(new java.awt.Font("Raleway ExtraBold", 1, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 102, 102));
        jLabel35.setText("BRAND :");

        brand1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        brand1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brand1ActionPerformed(evt);
            }
        });

        jLabel36.setBackground(new java.awt.Color(255, 255, 255));
        jLabel36.setFont(new java.awt.Font("Raleway ExtraBold", 1, 18)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 102, 102));
        jLabel36.setText("NOTE :");

        note.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        note.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noteActionPerformed(evt);
            }
        });

        QRcodeBtn.setBackground(new java.awt.Color(255, 102, 102));
        QRcodeBtn.setFont(new java.awt.Font("Raleway Light", 1, 18)); // NOI18N
        QRcodeBtn.setForeground(new java.awt.Color(255, 255, 255));
        QRcodeBtn.setText("Write Barcode");
        QRcodeBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 102), 3));
        QRcodeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QRcodeBtnActionPerformed(evt);
            }
        });

        AddBtn.setBackground(new java.awt.Color(255, 102, 102));
        AddBtn.setFont(new java.awt.Font("Raleway Light", 1, 18)); // NOI18N
        AddBtn.setForeground(new java.awt.Color(255, 255, 255));
        AddBtn.setText("Save");
        AddBtn.setToolTipText("");
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

        DelBtn.setBackground(new java.awt.Color(255, 102, 102));
        DelBtn.setFont(new java.awt.Font("Raleway Light", 1, 18)); // NOI18N
        DelBtn.setForeground(new java.awt.Color(255, 255, 255));
        DelBtn.setText("Delete");
        DelBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 102), 3));
        DelBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DelBtnMouseClicked(evt);
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
        ClearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearBtnActionPerformed(evt);
            }
        });

        ExImport.setBackground(new java.awt.Color(255, 102, 102));
        ExImport.setFont(new java.awt.Font("Raleway Light", 1, 18)); // NOI18N
        ExImport.setForeground(new java.awt.Color(255, 255, 255));
        ExImport.setText("Exel Import");
        ExImport.setToolTipText("");
        ExImport.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 102), 3));
        ExImport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ExImportMouseClicked(evt);
            }
        });
        ExImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExImportActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 102, 102));
        jLabel2.setText("SEARCH");

        name_src1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        name_src1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                name_src1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel20)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Code1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(description, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(CatCb1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(ProdName1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(ProdId, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(Unit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(33, 33, 33)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(ProdPrice1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(ProdQty1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addComponent(UpdateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ExImport, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(135, 135, 135)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel36)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(note, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel35)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(brand1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel34)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(comp1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(mfg_date, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(SupName1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(exp_date, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CPrice1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(81, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(AddBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(QRcodeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(327, 327, 327)
                                .addComponent(DelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(50, 50, 50)
                        .addComponent(ClearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(name_src1, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(256, 256, 256)
                                .addComponent(jLabel21)
                                .addGap(18, 29, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(name_src1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(ProdId, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(ProdName1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16))
                                .addGap(23, 23, 23)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(CatCb1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel19))
                                .addGap(18, 18, 18)
                                .addComponent(Unit, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(ProdPrice1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ProdQty1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Code1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(description, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addComponent(jLabel10))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addGap(95, 95, 95)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(mfg_date, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel27))
                                .addGap(31, 31, 31)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(exp_date, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel24))
                                .addGap(22, 22, 22)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel23)
                                    .addComponent(CPrice1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(31, 31, 31)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel22)
                                    .addComponent(SupName1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comp1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel34))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(brand1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel35))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel36)
                            .addComponent(note))))
                .addGap(65, 65, 65)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(QRcodeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ClearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UpdateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ExImport, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(143, 143, 143))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Add Product's", jPanel1);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setPreferredSize(new java.awt.Dimension(960, 890));

        jLabel28.setBackground(new java.awt.Color(255, 255, 255));
        jLabel28.setFont(new java.awt.Font("Raleway ExtraBold", 1, 30)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 102, 102));
        jLabel28.setText("MANAGE CATEGORIES");

        jLabel29.setBackground(new java.awt.Color(255, 255, 255));
        jLabel29.setFont(new java.awt.Font("Raleway ExtraBold", 1, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 102, 102));
        jLabel29.setText("CATID");

        jLabel30.setBackground(new java.awt.Color(255, 255, 255));
        jLabel30.setFont(new java.awt.Font("Raleway ExtraBold", 1, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 102, 102));
        jLabel30.setText("NAME");

        jLabel31.setBackground(new java.awt.Color(255, 255, 255));
        jLabel31.setFont(new java.awt.Font("Raleway ExtraBold", 1, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 102, 102));
        jLabel31.setText("DESCRIPTION");

        CatDesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CatDescActionPerformed(evt);
            }
        });

        AddBtn4.setBackground(new java.awt.Color(255, 102, 102));
        AddBtn4.setFont(new java.awt.Font("Raleway Light", 1, 18)); // NOI18N
        AddBtn4.setForeground(new java.awt.Color(255, 255, 255));
        AddBtn4.setText("Add");
        AddBtn4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 102), 3));
        AddBtn4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddBtn4MouseClicked(evt);
            }
        });
        AddBtn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddBtn4ActionPerformed(evt);
            }
        });

        UpdateBtn2.setBackground(new java.awt.Color(255, 102, 102));
        UpdateBtn2.setFont(new java.awt.Font("Raleway Light", 1, 18)); // NOI18N
        UpdateBtn2.setForeground(new java.awt.Color(255, 255, 255));
        UpdateBtn2.setText("Update");
        UpdateBtn2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 102), 3));
        UpdateBtn2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UpdateBtn2MouseClicked(evt);
            }
        });
        UpdateBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateBtn2ActionPerformed(evt);
            }
        });

        ClrBtn.setBackground(new java.awt.Color(255, 102, 102));
        ClrBtn.setFont(new java.awt.Font("Raleway Light", 1, 18)); // NOI18N
        ClrBtn.setForeground(new java.awt.Color(255, 255, 255));
        ClrBtn.setText("Clear");
        ClrBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 102), 3));
        ClrBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ClrBtnMouseClicked(evt);
            }
        });

        DelBtn2.setBackground(new java.awt.Color(255, 102, 102));
        DelBtn2.setFont(new java.awt.Font("Raleway Light", 1, 18)); // NOI18N
        DelBtn2.setForeground(new java.awt.Color(255, 255, 255));
        DelBtn2.setText("Delete");
        DelBtn2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 102), 3));
        DelBtn2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DelBtn2MouseClicked(evt);
            }
        });

        CatTable.setFont(new java.awt.Font("Raleway Medium", 0, 14)); // NOI18N
        CatTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NAME", "DESCRIPTION"
            }
        ));
        CatTable.setGridColor(new java.awt.Color(102, 102, 102));
        CatTable.setRowHeight(25);
        CatTable.setSelectionBackground(new java.awt.Color(255, 102, 102));
        CatTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        CatTable.setShowGrid(true);
        CatTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CatTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(CatTable);

        jLabel32.setBackground(new java.awt.Color(255, 255, 255));
        jLabel32.setFont(new java.awt.Font("Raleway ExtraBold", 1, 30)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 102, 102));
        jLabel32.setText("CATEGORIES LIST");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(AddBtn4, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(UpdateBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel30)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(CatName, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CatId, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(174, 174, 174)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel31)
                        .addGap(18, 18, 18)
                        .addComponent(CatDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(DelBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ClrBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(100, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel28)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel32)
                .addGap(307, 307, 307))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 856, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(CatDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel31))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(CatId, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel29)))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(CatName, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(120, 120, 120)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddBtn4, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UpdateBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DelBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ClrBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 160, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Add Category", jPanel6);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 960, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 890, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        // TODO add your handling code here:
        new MenuAdmin().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel12MouseClicked

    private void compActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_compActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_compActionPerformed

    private void ProductTblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProductTblMouseClicked
        tableModel =(DefaultTableModel)ProductTbl.getModel();
        int myIndex =ProductTbl.getSelectedRow();
        //ProdId.setText(tableModel.getValueAt(myIndex, 0).toString());
        ProdName.setText(tableModel.getValueAt(myIndex, 1).toString());
        //ProdQty.setText(tableModel.getValueAt(myIndex, 2).toString());
        //ProdPrice.setText(tableModel.getValueAt(myIndex, 4).toString());
        CatCb.setSelectedItem(tableModel.getValueAt(myIndex, 2).toString());
        //Code.setText(tableModel.getValueAt(myIndex, 6).toString());
        SupName.setSelectedItem(tableModel.getValueAt(myIndex, 6).toString());
        comp.setText(tableModel.getValueAt(myIndex, 12).toString());
        brand.setText(tableModel.getValueAt(myIndex, 13).toString());
        
    }//GEN-LAST:event_ProductTblMouseClicked

    private void name_srcKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_name_srcKeyReleased
        try{

            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarket","root","");
            St = Con.createStatement();
            Rs = St.executeQuery("Select * from product where PRODNAME LIKE'%"+name_src.getText()+"%'");
            ResultSetMetaData rsmd = Rs.getMetaData();
            tableModel =(DefaultTableModel)ProductTbl.getModel();
            tableModel.setRowCount(0);
            String []colsName = {"ID","Name","Cat", "Unit"," Price","Barcode","SupName","CostPrice","ExpiredDate","MFGDate","Quantity","Description","Company","Brand"};
            tableModel.setColumnIdentifiers(colsName);
     
            String ID,Name,Cat, Quantity, Price,Barcode,SupName,CostPrice,ExpiredDate,Unit,MFGDate,Description,Company,Brand;
            while(Rs.next())
            {
                ID = Rs.getString(1);
                Name = Rs.getString(2);
                Quantity = Rs.getString(3);
                Price =Rs.getString(4);
                Cat= Rs.getString(5);
                Unit=Rs.getString(12);
                Barcode=Rs.getString(6);
                SupName=Rs.getString(8);
                CostPrice=Rs.getString(9);
                ExpiredDate=Rs.getString(10);
                MFGDate=Rs.getString(11);
                Company=Rs.getString(13);
                Brand=Rs.getString(14);
                Description=Rs.getString(15);
                String[] add ={ID,Name,Cat, Unit, Price,Barcode,SupName,CostPrice,ExpiredDate,MFGDate,Quantity,Description,Company,Brand};
                tableModel.addRow(add);
            }
            

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_name_srcKeyReleased

    private void SupNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SupNameActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_SupNameActionPerformed

    private void ProdQty1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProdQty1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ProdQty1ActionPerformed

    private void SupName1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SupName1ActionPerformed
        
    }//GEN-LAST:event_SupName1ActionPerformed

    private void exp_dateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exp_dateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_exp_dateActionPerformed

    private void CatDescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CatDescActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CatDescActionPerformed

    private void AddBtn4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddBtn4MouseClicked
        tableModel =(DefaultTableModel)CatTable.getModel();
        if(CatId.getText().isEmpty() || CatName.getText().isEmpty() || CatDesc.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Missing Information");
        }else{
            try {
                Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarket","root","");
                PreparedStatement add =Con.prepareStatement("insert into CATEGORY values(?,?,?)");
                add.setInt(1, Integer.valueOf(CatId.getText()));
                add.setString(2, CatName.getText());
                add.setString(3, CatDesc.getText());
                int row = add.executeUpdate();
                JOptionPane.showMessageDialog(this, "Category Added Successfully");
                tableModel.getDataVector().removeAllElements();
                tableModel.fireTableDataChanged();
                SelectCat();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_AddBtn4MouseClicked

    private void AddBtn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddBtn4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddBtn4ActionPerformed

    private void UpdateBtn2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateBtn2MouseClicked
        tableModel =(DefaultTableModel)CatTable.getModel();
        if(CatId.getText().isEmpty() || CatName.getText().isEmpty() || CatDesc.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"Missing Infor");
        }else{
            try {
                Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarket","root","");
                String Query = "Update CATEGORY set CATNAME='" + CatName.getText() + "'" + ",CATDESC='" + CatDesc.getText() + "'" + "where CATID=" + CatId.getText();
                Statement Add = Con.createStatement();
                Add.executeUpdate(Query);
                JOptionPane.showMessageDialog(this,"Seller Updated");
                tableModel.getDataVector().removeAllElements();
                tableModel.fireTableDataChanged();
                SelectCat();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_UpdateBtn2MouseClicked

    private void UpdateBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateBtn2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateBtn2ActionPerformed

    private void ClrBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClrBtnMouseClicked
        CatId.setText("");
        CatName.setText("");
        CatDesc.setText("");
    }//GEN-LAST:event_ClrBtnMouseClicked

    private void DelBtn2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DelBtn2MouseClicked
        tableModel =(DefaultTableModel)CatTable.getModel();
        if(CatId.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Select category to be deleted");
        }else{
            try {
                Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarket","root","");
                String SId = CatId.getText();
                String Query = "Delete from CATEGORY where CATEGORY.CatId="+SId;
                Statement Add = Con.createStatement();
                Add.executeUpdate(Query);
                int delRow =CatTable.getSelectedRow();
                JOptionPane.showMessageDialog(this, "Category successfully deleted");
                tableModel.removeRow(delRow);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_DelBtn2MouseClicked

    private void CatTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CatTableMouseClicked
        tableModel =(DefaultTableModel)CatTable.getModel();
        int myIndex =CatTable.getSelectedRow();
        CatId.setText(tableModel.getValueAt(myIndex, 0).toString());
        CatName.setText(tableModel.getValueAt(myIndex, 1).toString());
        CatDesc.setText(tableModel.getValueAt(myIndex, 2).toString());
    }//GEN-LAST:event_CatTableMouseClicked

    private void brandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brandActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_brandActionPerformed

    private void Code1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Code1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Code1ActionPerformed

    private void CPrice1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CPrice1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CPrice1ActionPerformed

    private void descriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descriptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_descriptionActionPerformed

    private void comp1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comp1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comp1ActionPerformed

    private void brand1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brand1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_brand1ActionPerformed

    private void noteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_noteActionPerformed

    private void QRcodeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QRcodeBtnActionPerformed
        // TODO add your handling code here:
        try {
            ByteArrayOutputStream out =QRCode.from(Code1.getText()).to(ImageType.PNG).stream();
            String f_name = Code1.getText();
            String Path_name="D:/QRcode/";

            FileOutputStream fout = new FileOutputStream(new File(Path_name+(f_name+".PNG")));
            fout.write(out.toByteArray());
            fout.flush();
            JOptionPane.showMessageDialog(this, "QRCode Generated Successfully");
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_QRcodeBtnActionPerformed

    private void AddBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddBtnMouseClicked
        // TODO add your handling code here:
        tableModel =(DefaultTableModel)ProductTbl.getModel();
        if(ProdId.getText().isEmpty() || ProdName1.getText().isEmpty() || comp1.getText().isEmpty() || comp1.getText().isEmpty()
                || ProdPrice1.getText().isEmpty()
                || Code1.getText().isEmpty()
                || CPrice1.getText().isEmpty()
                || exp_date.getText().isEmpty()
                || mfg_date.getText().isEmpty()
                || ProdQty1.getText().isEmpty()
                || brand1.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Missing Information");
        }else{
            try {
                Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarket","root","");
                PreparedStatement add =Con.prepareStatement("insert into PRODUCT values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                add.setInt(1, Integer.valueOf(ProdId.getText()));
                add.setString(2, ProdName1.getText());
                add.setString(3, ProdQty1.getText());
                add.setString(4, ProdPrice1.getText());
                add.setString(5, CatCb1.getSelectedItem().toString());
                add.setString(6, Code1.getText());
                add.setInt(7, Integer.valueOf("0"));
                add.setString(8, SupName1.getSelectedItem().toString());
                add.setString(9, CPrice1.getText());
                add.setString(10,exp_date.getText());
                add.setString(11,mfg_date.getText());
                add.setString(12,Unit.getSelectedItem().toString());
                add.setString(13,comp1.getText());
                add.setString(14,brand1.getText());
                add.setString(15,description.getText());
                add.setString(16,note.getText());
                int row = add.executeUpdate();
                JOptionPane.showMessageDialog(this, "Product Added Successfully");
                tableModel.getDataVector().removeAllElements();
                tableModel.fireTableDataChanged();
                SelectProduct();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_AddBtnMouseClicked

    private void AddBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddBtnActionPerformed

    private void UpdateBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateBtnMouseClicked
        tableModel =(DefaultTableModel)ProductTbl.getModel();
        if (ProdId.getText().isEmpty() || ProdName1.getText().isEmpty() || comp1.getText().isEmpty() || comp1.getText().isEmpty()
                || ProdPrice1.getText().isEmpty()
                || Code1.getText().isEmpty()
                || CPrice1.getText().isEmpty()
                || exp_date.getText().isEmpty()
                || mfg_date.getText().isEmpty()
                || ProdQty1.getText().isEmpty()
                || brand1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this,"Missing Infor");
        }else{
            try {
                Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarket","root","");
                String Query = "Update PRODUCT set PRODNAME='" + ProdName1.getText() + "'" + ",PRODCAT='" + CatCb1.getSelectedItem().toString()+"'" + ",UNIT='" + Unit.getSelectedItem().toString() + "'" + ",PRODQTY='" + ProdQty1.getText() + "'" +",PRODPRICE='"+ProdPrice1.getText()+"'"+",BARCODE='" + Code1.getText() + "'" +",MFGDATE='" + mfg_date.getText() + "'" +",COMPANY='" + comp1.getText() + "'" +",BRAND='" + brand1.getText() + "'" +",DESCRIPTION='" + description.getText() + "'" +",NOTE='" + note.getText() + "'" +",ExpDate='" + exp_date.getText() + "'"+",SUPNAME='" + SupName1.getSelectedItem().toString() + "'"+",COSTPRICE='" + CPrice1.getText() + "'" + "where PRODID=" + ProdId.getText();
                Statement Add = Con.createStatement();
                Add.executeUpdate(Query);
                JOptionPane.showMessageDialog(this,"Product Updated");
                tableModel.getDataVector().removeAllElements();
                tableModel.fireTableDataChanged();
                SelectProduct();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_UpdateBtnMouseClicked

    private void UpdateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateBtnActionPerformed

    private void DelBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DelBtnMouseClicked
        tableModel =(DefaultTableModel)ProductTbl.getModel();
        if(ProdId.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Select product to be deleted");
        }else{
            try {
                Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarket","root","");
                String SId = ProdId.getText();
                String Query = "Delete from PRODUCT where PRODUCT.ProdId="+SId;
                Statement Add = Con.createStatement();
                Add.executeUpdate(Query);
                JOptionPane.showMessageDialog(this, "Product successfully deleted");
                tableModel.getDataVector().removeAllElements();
                tableModel.fireTableDataChanged();
                SelectProduct();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_DelBtnMouseClicked

    private void ClearBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClearBtnMouseClicked
        ProdId.setText("");
        ProdName1.setText("");
        comp1.setText("");
        ProdPrice1.setText("");
        Code1.setText("");
        CPrice1.setText("");
        exp_date.setText("");
        mfg_date.setText("");
        ProdQty1.setText("");
        brand1.setText("");
        
    }//GEN-LAST:event_ClearBtnMouseClicked

    private void ClearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearBtnActionPerformed
        // TODO add your handling code here:
        /*ProdId.setText("");
        ProdName.setText("");
        ProdQty.setText("");
        ProdPrice.setText("");
        Code.setText("");*/
    }//GEN-LAST:event_ClearBtnActionPerformed

    private void ExImportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExImportMouseClicked
        // TODO add your handling code here:
        File file = null ;
        tableModel =(DefaultTableModel)ProductTbl.getModel();
        JFileChooser fins = new JFileChooser();
        int response = fins.showOpenDialog(null);
        if(response==JFileChooser.APPROVE_OPTION){
            file = new File(fins.getSelectedFile().getAbsolutePath());
            try {
                Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarket","root","");
                PreparedStatement add =Con.prepareStatement("insert into PRODUCT values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                BufferedReader lineReader = new BufferedReader(new FileReader(file.getAbsolutePath().toString()));
                
                String lineText = null;
                int count = 0;
                lineReader.readLine();
                while((lineText=lineReader.readLine())!=null){
                   String[] data = lineText.split(",");
                   
                add.setInt(1,Integer.valueOf(data[0]));
                add.setString(2, data[1]);
                add.setString(3, data[2]);
                add.setString(4, data[3]);
                add.setString(5, data[4]);
                add.setString(6, data[5]);
                add.setInt(7, Integer.valueOf(data[6]));
                add.setString(8, data[7]);
                add.setString(9, data[8]);
                add.setString(10,data[9]);
                add.setString(11,data[10]);
                add.setString(12,data[11]);
                add.setString(13,data[12]);
                add.setString(14,data[13]);
                add.setString(15,data[14]);
                add.setString(16,data[15]);
                add.addBatch();
                
                }
                lineReader.close();
                add.executeBatch();
                JOptionPane.showMessageDialog(this, "Product Added Successfully");
                tableModel.getDataVector().removeAllElements();
                tableModel.fireTableDataChanged();
                SelectProduct();
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_ExImportMouseClicked

    private void ExImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExImportActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ExImportActionPerformed

    private void name_src1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_name_src1ActionPerformed
        // TODO add your handling code here:
        boolean count =false;
        try{

            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarket","root","");
            St = Con.createStatement();
            Rs = St.executeQuery("Select * from product where PRODNAME ='"+name_src1.getText()+"'");
           
                while (Rs.next()) {
                    String MyId = Rs.getString("PRODID");
                    String MyName = Rs.getString("PRODNAME");
                    String MyQty = Rs.getString("PRODQTY");
                    String MyPrice = Rs.getString("PRODPRICE");
                    String MyCat = Rs.getString("PRODCAT");
                    String MyBC = Rs.getString("BARCODE");
                    String MySupN = Rs.getString("SUPNAME");
                    String MyCPrice = Rs.getString("COSTPRICE");
                    String MyEXP = Rs.getString("EXPDATE");
                    String MyMFG = Rs.getString("MFGDATE");
                    String MyUnit = Rs.getString("UNIT");
                    String MyComp = Rs.getString("COMPANY");
                    String MyBrand = Rs.getString("BRAND");
                    String MyDesc = Rs.getString("DESCRIPTION");
                    String MyNote = Rs.getString("NOTE");
                    ProdId.setText(MyId);
                    ProdName1.setText(MyName);
                    comp1.setText(MyComp);
                    ProdPrice1.setText(MyPrice);
                    Code1.setText(MyBC);
                    CPrice1.setText(MyCPrice);
                    exp_date.setText(MyEXP);
                    mfg_date.setText(MyMFG);
                    ProdQty1.setText(MyQty);
                    brand1.setText(MyBrand);
                    description.setText(MyDesc);
                    note.setText(MyNote);
                    Unit.setSelectedItem(MyUnit);
                    SupName1.setSelectedItem(MySupN);
                    CatCb1.setSelectedItem(MyCat);
                    count=true;
                }
            if(count==false){
                JOptionPane.showMessageDialog(this, "Wrong Product Name!");
            }
            
            

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_name_src1ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        
        
            ReportView r =new ReportView("src\\main\\java\\hieucao\\sieuthiBigK\\reportsController\\report2.jasper");
            r.setVisible(true);
    }//GEN-LAST:event_jButton1MouseClicked

    private void mfg_dateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mfg_dateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mfg_dateActionPerformed

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
            java.util.logging.Logger.getLogger(ProductMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProductMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddBtn;
    private javax.swing.JButton AddBtn4;
    private javax.swing.JTextField CPrice1;
    private javax.swing.JComboBox<String> CatCb;
    private javax.swing.JComboBox<String> CatCb1;
    private javax.swing.JTextField CatDesc;
    private javax.swing.JTextField CatId;
    private javax.swing.JTextField CatName;
    private javax.swing.JTable CatTable;
    private javax.swing.JButton ClearBtn;
    private javax.swing.JButton ClrBtn;
    private javax.swing.JTextField Code1;
    private javax.swing.JButton DelBtn;
    private javax.swing.JButton DelBtn2;
    private javax.swing.JButton ExImport;
    private javax.swing.JTextField ProdId;
    private javax.swing.JTextField ProdName;
    private javax.swing.JTextField ProdName1;
    private javax.swing.JTextField ProdPrice1;
    private javax.swing.JTextField ProdQty1;
    private javax.swing.JTable ProductTbl;
    private javax.swing.JButton QRcodeBtn;
    private javax.swing.JComboBox<String> SupName;
    private javax.swing.JComboBox<String> SupName1;
    private javax.swing.JComboBox<String> Unit;
    private javax.swing.JButton UpdateBtn;
    private javax.swing.JButton UpdateBtn2;
    private javax.swing.JTextField brand;
    private javax.swing.JTextField brand1;
    private javax.swing.JTextField comp;
    private javax.swing.JTextField comp1;
    private javax.swing.JTextField description;
    private javax.swing.JTextField exp_date;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTextField mfg_date;
    private javax.swing.JTextField name_src;
    private javax.swing.JTextField name_src1;
    private javax.swing.JTextField note;
    // End of variables declaration//GEN-END:variables
}
