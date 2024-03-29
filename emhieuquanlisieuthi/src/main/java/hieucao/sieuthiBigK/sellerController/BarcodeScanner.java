/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hieucao.sieuthiBigK.sellerController;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;

/**
 *
 * @author Admin
 */
public class BarcodeScanner extends javax.swing.JFrame implements Runnable,ThreadFactory{

    private WebcamPanel panel =null;
    private Webcam webcam =null;
    private Executor executor =Executors.newFixedThreadPool(2);
    public static Selling selling1;
    public static String sellerName;
    
    
    public BarcodeScanner() {
        initComponents();
        initWebcam();
    }
    
    Connection Con = null;
    Statement St =null;
    ResultSet Rs =null;
    private void changeInFor(){
        String item =selling1.BCode.getText();
        String Query ="Select * from product where BARCODE= ?";
        try {
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarket","root","");
            PreparedStatement St  = Con.prepareStatement(Query);
            St.setString(1,item);
            Rs = St.executeQuery();
            while (Rs.next()) {                
                String rcqty=Rs.getString("PRODQTY");
                String rcprc=Rs.getString("PRODPRICE");
                String rcun =Rs.getString("UNIT");
                selling1.RecentQty.setText(rcqty);
                selling1.CartPrice.setText(rcprc);
                String rcCatCb = Rs.getString("PRODNAME");
                selling1.CatCb.setSelectedItem(rcCatCb);
                selling1.ProdQty.setText("1");
                selling1.Unit.setText(rcun);
                selling1.seller.setText(sellerName);
            }     
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BarcodeSc = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        result_field = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BarcodeSc.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        BarcodeSc.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 480, 340));

        jLabel1.setText("Result");
        BarcodeSc.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, -1, 20));

        result_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                result_fieldActionPerformed(evt);
            }
        });
        BarcodeSc.add(result_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, 480, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BarcodeSc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BarcodeSc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void result_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_result_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_result_fieldActionPerformed

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
            java.util.logging.Logger.getLogger(BarcodeScanner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BarcodeScanner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BarcodeScanner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BarcodeScanner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BarcodeScanner().setVisible(true);
            }
        });
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                selling1 =new Selling();
                selling1.setVisible(true);
            }
        });
        
    }
    
    
    
    private void initWebcam(){
       Dimension size =WebcamResolution.QVGA.getSize();
       webcam =Webcam.getWebcams().get(0);
       if (!webcam.isOpen()) {
       webcam.setViewSize(size);
       }
       
       panel = new WebcamPanel(webcam);
       panel.setPreferredSize(size);
       panel.setFPSDisplayed(true);
       
       
       jPanel2.add(panel,new org.netbeans.lib.awtextra.AbsoluteConstraints(0,0,470,300));
       executor.execute(this);
    }
    @Override
    public void run(){
       do{ 
           try {
               Thread.sleep(100);
           } catch (InterruptedException ex) {
               Logger.getLogger(BarcodeScanner.class.getName()).log(Level.SEVERE,null,ex);
           }
           
           Result result =null;
           BufferedImage image =null;
           
           if(webcam.isOpen()){
              if((image=webcam.getImage())==null){
                 continue;
              }
           }
           
           LuminanceSource source = new BufferedImageLuminanceSource(image);
           BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
           
           try {
               result = new MultiFormatReader().decode(bitmap);
           } catch (NotFoundException ex) {
               Logger.getLogger(BarcodeScanner.class.getName()).log(Level.SEVERE, null, ex);
           }
           
           if(result!=null){
               result_field.setText(result.getText());
               selling1.BCode.setText(result.getText());
               changeInFor();
               
       }
       }while(true);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BarcodeSc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JTextField result_field;
    // End of variables declaration//GEN-END:variables

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r,"My Thread");
        t.setDaemon(true);
        return t;
    }
    
}

   
