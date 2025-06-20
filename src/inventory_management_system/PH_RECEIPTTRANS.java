/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory_management_system;



import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

/**
 *
 * @author Mariz
 */
public class PH_RECEIPTTRANS extends javax.swing.JFrame implements Printable {
    @Override
    public int print(Graphics g, PageFormat pf, int page)throws PrinterException{
    if(page > 0){
    return NO_SUCH_PAGE;
    }
    Graphics2D g2d = (Graphics2D)g;
    g2d.translate(pf.getImageableX(),pf.getImageableY());
            this.printAll(g);
            return PAGE_EXISTS;
    
    }
    
    

    
  
   public PH_RECEIPTTRANS(String selectedValue) {
    initComponents();
     setupButtonShortcuts();

setLayout(new BorderLayout());
setPreferredSize(new Dimension(565, 597));





try {
    Class.forName("com.mysql.jdbc.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/psystem", "root", "");
    String sql = "SELECT * FROM trans_history WHERE TRANS_ID = ?";
    PreparedStatement pstmt = conn.prepareStatement(sql);
    pstmt.setString(1, selectedValue);
    ResultSet rs = pstmt.executeQuery();

    if (rs.next()) {
        
            String transactionID = rs.getString("TRANS_ID");
            String sellerName = rs.getString("PHAR_NAME");
            String totalprice = rs.getString("TOTAL_PRICE");
            String time1 = rs.getString("TRANS_TIME");
            String date1 = rs.getString("TRANS_DATE");
            String cash1 = rs.getString("TRANS_CASH");
            String change1 = rs.getString("TRANS_CHANGE");

            rnum.setText(transactionID);
            sname.setText(sellerName);
            tprice.setText(totalprice);
            date.setText(date1);
            time.setText(time1);
            cash.setText(cash1);
            change.setText(change1);
            
           
        jPanel3.setLayout(new GridLayout(0, 4));
        JLabel productNameLabel = new JLabel("Product Name", JLabel.CENTER);
        productNameLabel.setFont(new Font("Arial", Font.BOLD, 15));
        jPanel3.add(productNameLabel);
        JLabel quantityLabel = new JLabel("Quantity", JLabel.CENTER);
        quantityLabel.setFont(new Font("Arial", Font.BOLD, 15));
        jPanel3.add(quantityLabel);
        JLabel pricePerUnitLabel = new JLabel("Price Per Unit", JLabel.CENTER);
        pricePerUnitLabel.setFont(new Font("Arial", Font.BOLD, 15));
        jPanel3.add(pricePerUnitLabel);
        JLabel totalPriceLabel = new JLabel("Total Price", JLabel.CENTER);
        totalPriceLabel.setFont(new Font("Arial", Font.BOLD, 15));
        jPanel3.add(totalPriceLabel);
                
        String transID = rs.getString("TRANS_ID");
        PreparedStatement pstmtItems = conn.prepareStatement(
                "SELECT MED_NAME, QUANTITY, MED_PRICE FROM med_purchased WHERE TRANS_ID = ?");
        pstmtItems.setString(1, transID);
        ResultSet rsItems = pstmtItems.executeQuery();

        while (rsItems.next()) {
            String medName = rsItems.getString("MED_NAME");
            int quantity = rsItems.getInt("QUANTITY");
            double price = rsItems.getDouble("MED_PRICE");
            double totalPricePerItem = quantity * price;

            jPanel3.add(new JLabel(medName, JLabel.CENTER));
            jPanel3.add(new JLabel(String.valueOf(quantity), JLabel.CENTER));
            jPanel3.add(new JLabel(String.valueOf(price), JLabel.CENTER));
            jPanel3.add(new JLabel(String.valueOf(totalPricePerItem), JLabel.CENTER));
        }

        conn.close();
    } else {
        JOptionPane.showMessageDialog(null, "Transaction ID not found!");
    }

    conn.close();
} catch (Exception ex) {
    JOptionPane.showMessageDialog(null, ex);
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

        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        rnum = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        sname = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tprice = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        date = new javax.swing.JTextField();
        time = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        cash = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        change = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        jLabel5.setFont(new java.awt.Font("GungsuhChe", 0, 40)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("D&J|PHARMACY INVENTORY MANAGEMENT SYSTEM");

        jLabel7.setFont(new java.awt.Font("Narkisim", 0, 14)); // NOI18N
        jLabel7.setText("Barangay Villareal, Bayawan City, Negros Oriental, Philippines 6114");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        rnum.setEditable(false);
        rnum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rnumActionPerformed(evt);
            }
        });

        jLabel1.setText("Receipt#:");

        sname.setEditable(false);

        jLabel2.setText("Seller Name: ");

        tprice.setEditable(false);

        jLabel3.setText("Total Price:");

        date.setEditable(false);

        time.setEditable(false);
        time.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timeActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 367, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton2.setText("Okay");
        jButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("Print");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("Save");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel11.setText("Cash:");

        cash.setEditable(false);

        jLabel12.setText("Change:");

        change.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 202, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButton3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton1))
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(28, 28, 28)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cash, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                            .addComponent(tprice)
                            .addComponent(change))
                        .addGap(24, 24, 24))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sname, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rnum, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rnum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tprice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(cash, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(change, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(54, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton3))
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("GungsuhChe", 1, 18)); // NOI18N
        jLabel6.setText("PHARMACY INVENTORY MANAGEMENT SYSTEM");

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Californian FB", 0, 12)); // NOI18N
        jLabel8.setText("Barangay Villareal, Bayawan City, Negros Oriental, Philippines 6114");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logoSYSTEM (1).png"))); // NOI18N
        jLabel4.setText("    ");
        jLabel4.setToolTipText("");

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-close-35 (1).png"))); // NOI18N
        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-minimize-50 (1).png"))); // NOI18N
        jLabel10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8))
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(1, 1, 1)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addContainerGap(23, Short.MAX_VALUE))
            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void rnumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rnumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rnumActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_formComponentShown

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        setState(PH_RECEIPTTRANS.ICONIFIED);          // TODO add your handling code here:
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(this);
        boolean ok = job.printDialog();
        if (ok){
            try{
                job.print();
            }catch(PrinterException ex){
                JOptionPane.showMessageDialog(null,"Error");
            }
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // JFileChooser fileChooser = new JFileChooser();
        //    int option = fileChooser.showSaveDialog(this);
        //
        //    if (option == JFileChooser.APPROVE_OPTION) {
            //        File file = fileChooser.getSelectedFile();
            //
            //        try {
                //            Document document = new Document();
                //            PdfWriter.getInstance(document, new FileOutputStream(file));
                //            document.open();
                //
                //            // Retrieve form data and add it to the PDF document
                //            document.add(new Paragraph("Form Data"));
                //
                //            // Example: Retrieve text from a JTextField and add it to the PDF
                //            String textFieldValue = sname.getText();
                //            document.add(new Paragraph("Seller Name: " + textFieldValue));
                //
                //             String textFieldValue1 = rnum.getText();
                //            document.add(new Paragraph("Seller Name: " + textFieldValue1));
                //
                ////
                ////            // Example: Retrieve selected item from a JComboBox and add it to the PDF
                ////            String selectedItem = comboBox.getSelectedItem().toString();
                ////            document.add(new Paragraph("Combo Box: " + selectedItem));
                ////
                ////            // Example: Retrieve selected option from a JRadioButton or JCheckBox and add it to the PDF
                ////            String radioButtonValue = radioButton.isSelected() ? "Selected" : "Not Selected";
                ////            document.add(new Paragraph("Radio Button: " + radioButtonValue));
                //
                //            // Add other form data to the PDF document as needed
                //
                //            document.close();
                //
                //            JOptionPane.showMessageDialog(this, "Form saved as PDF successfully!");
                //        } catch (DocumentException | IOException ex) {
                //            ex.printStackTrace();
                //        }
            //    }
       JFileChooser fileChooser = new JFileChooser();
    int option = fileChooser.showSaveDialog(this);

    if (option == JFileChooser.APPROVE_OPTION) {
        File file = fileChooser.getSelectedFile();

        try {
            // Capture the form as an image
            BufferedImage image = captureFormImage();

            // Save the image as a file
            ImageIO.write(image, "png", file);

            JOptionPane.showMessageDialog(this, "Form saved as image successfully!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void timeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_timeActionPerformed
private BufferedImage captureFormImage() {
    try {
        // Get the size of the form
        Dimension formSize = getContentPane().getSize();

        // Create a BufferedImage with the form size
        BufferedImage image = new BufferedImage(formSize.width, formSize.height, BufferedImage.TYPE_INT_RGB);

        // Create a graphics object from the image
        Graphics2D graphics = image.createGraphics();

        // Paint the form onto the image
        getContentPane().paint(graphics);

        // Dispose the graphics object
        graphics.dispose();

        return image;
    } catch (Exception ex) {
        ex.printStackTrace();
    }

    return null;
}
    
    
    
    
    private void saveComponentData(Document document, Container container) throws DocumentException {
    Component[] components = container.getComponents();

    for (Component component : components) {
        if (component instanceof JTextField) {
            JTextField textField = (JTextField) component;
            String textFieldValue = textField.getText();
            document.add(new Paragraph("" + textFieldValue));
        } else if (component instanceof JButton) {
            JButton button = (JButton) component;
            String buttonText = button.getText();
            document.add(new Paragraph("" + buttonText));
        } else if (component instanceof JLabel) {
            JLabel label = (JLabel) component;
            String labelText = label.getText();
            document.add(new Paragraph("" + labelText));
        } else if (component instanceof JPanel) {
            saveComponentData(document, (Container) component);
        }

        // Add more conditions for other types of components as needed
    }
}

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PH_RECEIPTTRANS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            private String getSelectedValue;
            public void run() {
                new PH_RECEIPTTRANS(getSelectedValue).setVisible(true);
                
            }
        });
    }
        

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cash;
    private javax.swing.JTextField change;
    private javax.swing.JTextField date;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField rnum;
    private javax.swing.JTextField sname;
    private javax.swing.JTextField time;
    private javax.swing.JTextField tprice;
    // End of variables declaration//GEN-END:variables


    
     private void setupButtonShortcuts() {
        // Set up shortcut key bindings for each button
       setupButtonShortcut(jButton3, KeyEvent.VK_S);
        setupButtonShortcut(jButton1, KeyEvent.VK_P);
       setupButtonShortcut(jButton2, KeyEvent.VK_ENTER);
        // ... Set up shortcuts for other buttons
    }
    
    
    
  private void setupButtonShortcut(JButton button, int keyCode) {
 int condition = JComponent.WHEN_IN_FOCUSED_WINDOW;
    InputMap inputMap = button.getInputMap(condition);
    ActionMap actionMap = button.getActionMap();

    KeyStroke keyStroke = KeyStroke.getKeyStroke(keyCode, 0);
    inputMap.put(keyStroke, button);
    actionMap.put(button, new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Object source = e.getSource();
            
            if (source == jButton3) {
                // Call your clear logic here
                save();
          
            }
            else if(source == jButton1){
            print();
            }
            else if (source == jButton2){
            okay();
            }
        }
    });    }
    private void okay(){
    dispose();
    }
  private void print(){
          PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(this);
        boolean ok = job.printDialog();
        if (ok){
            try{
                job.print();
            }catch(PrinterException ex){
                JOptionPane.showMessageDialog(null,"Error");
            }
        }

  }
  
  
  private void save(){
 JFileChooser fileChooser = new JFileChooser();
        int option = fileChooser.showSaveDialog(this);

        if (option == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();

            try {
                // Capture the form as an image
                BufferedImage image = captureFormImage();

                // Save the image as a file
                ImageIO.write(image, "png", file);

                JOptionPane.showMessageDialog(this, "Form saved as image successfully!");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

}       
  
}
         
                
