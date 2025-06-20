/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory_management_system;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

/**
 *
 * @author Mariz
 */
public class TRANS_HISTORY extends javax.swing.JInternalFrame {

    /**
     * Creates new form TRANS_HISTORY
     */
    public TRANS_HISTORY() {
        initComponents();
         trans_history_Data();
          Timer timer = new Timer(10000 , e -> trans_history_Data());
         timer.start(); 
    }
    
    private static class CustomHeaderRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                   boolean hasFocus, int row, int column) {
        Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // Set the desired font and size for the title
        Font font = new Font("Arial", Font.BOLD, 16);  // Customize the font and size as per your needs
        component.setFont(font);
         component.setBackground(Color.BLUE);  // Customize the color as per your needs

        // Set the foreground (text) color for the title
        component.setForeground(Color.WHITE);  // Customize the color as per your needs


        return component;
    }
}

    public String getStringValue() {
    int index = jTable3.getSelectedRow();
    TableModel model = jTable3.getModel();
    String stringValue = model.getValueAt(index, 0).toString();
    return stringValue;
}

    

    public void trans_history_Data() {
    
    
     if(search1.getText().isEmpty()){
            Connection conn;
            ResultSet rs;
            com.mysql.jdbc.PreparedStatement stm;

            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Transaction ID");
            model.addColumn("Seller ID");
            model.addColumn("Seller Name");
            model.addColumn("Total Price");
            model.addColumn("Cash");
        model.addColumn("Change");
            

            String sql = "SELECT * FROM `trans_history` ORDER BY TRANS_ID DESC";

            try{
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql:///psystem","root","");
                stm = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement(sql);
                rs = stm.executeQuery();

                while(rs.next()){
       String column1Value = rs.getString("TRANS_ID");
                    String column2Value = rs.getString("PHAR_ID");
                    String column3Value = rs.getString("PHAR_NAME");
                    String column4Value = rs.getString("TOTAL_PRICE");
                    String column5Value = rs.getString("TRANS_CASH");
                String column6Value = rs.getString("TRANS_CHANGE");
                model.addRow(new Object[]{column1Value, column2Value, column3Value, column4Value, column5Value, column6Value});
                }
                jTable3.setModel(model);
            }
            catch(Exception e){

                JOptionPane.showMessageDialog(null,e);
            }
              JTableHeader header1 = jTable3.getTableHeader();
    header1.setDefaultRenderer(new TRANS_HISTORY.CustomHeaderRenderer());
    String[] headerTitles1 = {"Transaction ID", "Pharmacists ID", "Name", "Total Price", "Cash","Change"};
    for (int i = 0; i < headerTitles1.length; i++) {
        header1.getColumnModel().getColumn(i).setHeaderValue(headerTitles1[i]);
    }
    jTable3.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        }
        
        else {

            Connection conn;
            ResultSet rs;
            com.mysql.jdbc.PreparedStatement stm;

            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Transaction ID");
            model.addColumn("Seller ID");
            model.addColumn("Seller Name");
            model.addColumn("Total Price");
            model.addColumn("Cash");
        model.addColumn("Change");

            String sql = "SELECT * FROM `trans_history` where TRANS_ID = ?";

            try{
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql:///psystem","root","");
                stm = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement(sql);
                stm.setString(1,search1.getText());
                rs = stm.executeQuery();

                while(rs.next()){
                    String column1Value = rs.getString("TRANS_ID");
                    String column2Value = rs.getString("PHAR_ID");
                    String column3Value = rs.getString("PHAR_NAME");
                    String column4Value = rs.getString("TOTAL_PRICE");
                    String column5Value = rs.getString("TRANS_CASH");
                String column6Value = rs.getString("TRANS_CHANGE");
                model.addRow(new Object[]{column1Value, column2Value, column3Value, column4Value, column5Value, column6Value});
                }
                jTable3.setModel(model);
            }
            catch(Exception e){

                JOptionPane.showMessageDialog(null,e);
            }
             JTableHeader header1 = jTable3.getTableHeader();
    header1.setDefaultRenderer(new TRANS_HISTORY.CustomHeaderRenderer());
    String[] headerTitles1 = {"Transaction ID", "Pharmacists ID", "Name", "Total Price", "Cash", "Change"};
    for (int i = 0; i < headerTitles1.length; i++) {
        header1.getColumnModel().getColumn(i).setHeaderValue(headerTitles1[i]);
    }
    jTable3.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        search1 = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setClosable(true);
        setIconifiable(true);
        setTitle("TRANSACTION HISTORY");
        setName("Transaction History"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1189, 662));
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTable3.setBackground(new java.awt.Color(0, 0, 0));
        jTable3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTable3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTable3.setForeground(new java.awt.Color(255, 255, 255));
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable3);

        search1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        search1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search1ActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search (1).png"))); // NOI18N
        jButton8.setText("Search");
        jButton8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(search1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1109, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(search1)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE)
                .addContainerGap())
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
    }// </editor-fold>//GEN-END:initComponents

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        

    int index = jTable3.getSelectedRow();
    TableModel model = jTable3.getModel();

    String selectedValue = model.getValueAt(index, 0).toString();
    
    PH_RECEIPTTRANS receiptTransForm = new PH_RECEIPTTRANS(selectedValue);
    receiptTransForm.setVisible(true);
        

    }//GEN-LAST:event_jTable3MouseClicked

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
         Timer timer = new Timer(10000 , e -> trans_history_Data());
         timer.start(); 
        Connection conn;
        ResultSet rs;
        com.mysql.jdbc.PreparedStatement stm;

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Transaction ID");
         model.addColumn("Seller ID");
        model.addColumn("Seller Name");
        model.addColumn("Total Price");
        model.addColumn("Cash");
        model.addColumn("Change");

        String sql = "SELECT * FROM `trans_history` where PHAR_NAME LIKE ?";

        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql:///psystem","root","");
            stm = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement(sql);
            
             // Add the wildcard characters to the search term
            String searchTerm = "%" + search1.getText() + "%";
            stm.setString(1, searchTerm);    
            
            rs = stm.executeQuery();

            while(rs.next()){
                    String column1Value = rs.getString("TRANS_ID");
                    String column2Value = rs.getString("PHAR_ID");
                    String column3Value = rs.getString("PHAR_NAME");
                    String column4Value = rs.getString("TOTAL_PRICE");
                    String column5Value = rs.getString("TRANS_CASH");
                String column6Value = rs.getString("TRANS_CHANGE");
                model.addRow(new Object[]{column1Value, column2Value, column3Value, column4Value, column5Value, column6Value});
            }
            jTable3.setModel(model);
        }
        catch(Exception e){

            JOptionPane.showMessageDialog(null,e);
        }
            if (search1.getText().isEmpty()) {
        timer.start(); // Start the refresh timer when the text field is empty
    } else {
        timer.stop(); // Stop the refresh timer when a search is being performed
    }
        
    }//GEN-LAST:event_jButton8ActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        // TODO add your handling code here:
         try {
            this.setMaximum(true);
        } catch (java.beans.PropertyVetoException ex) {
        
            System.err.println("Error maximizing internal frame: " + ex.getMessage());
        }
        

    }//GEN-LAST:event_formInternalFrameOpened

    private void search1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextField search1;
    // End of variables declaration//GEN-END:variables
}
