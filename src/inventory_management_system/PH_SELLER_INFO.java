/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory_management_system;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

/**
 *
 * @author Mariz
 */
public class PH_SELLER_INFO extends javax.swing.JInternalFrame {
   private boolean isLoggedIn;
private UserSession userSession;
 private Timer refreshTimer;
    /**
     * Creates new form PH_SELLER_INFO
     */
    public PH_SELLER_INFO() {
        initComponents();
        updateTableData();
         startRefreshTimer();
        setupSearchListener();
        userSession = UserSession.getInstance();
    }
    
    
    
    
    

private void startRefreshTimer() {
        if (refreshTimer == null || !refreshTimer.isRunning()) {
            refreshTimer = new Timer(100, e -> updateTableData());
            refreshTimer.start();
        }
    }

    private void stopRefreshTimer() {
        if (refreshTimer != null && refreshTimer.isRunning()) {
            refreshTimer.stop();
        }
    }

    private void setupSearchListener() {
        search.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                handleSearchChange();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                handleSearchChange();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                handleSearchChange();
            }

            private void handleSearchChange() {
                if (search.getText().isEmpty()) {
                    startRefreshTimer(); // Start the refresh timer when the text field is empty
                } else {
                    stopRefreshTimer(); // Stop the refresh timer when a search is being performed
                }
            }
        });
    }


    
    
    
    
    
    
    
    
    
    
    
    
    
    
    private static class CustomHeaderRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                   boolean hasFocus, int row, int column) {
        Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // Set the desired font and size for the title
        Font font = new Font("Nasalization Rg", Font.BOLD, 18);  // Customize the font and size as per your needs
        component.setFont(font);
         component.setBackground(Color.BLUE);  // Customize the color as per your needs

        // Set the foreground (text) color for the title
        component.setForeground(Color.WHITE);  // Customize the color as per your needs


        return component;
    }
}

    

    public void updateTableData() {
    
  
        
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    model.setRowCount(0); 
 UserSession session = UserSession.getInstance();
                session.setLoggedIn(true);
                session.setUserType("");
                
    String sql = "SELECT PHAR_USERNAME from pharmacists_inf WHERE PHAR_POS=?";

    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql:///psystem", "root", "");
        com.mysql.jdbc.PreparedStatement stm = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();

        while (rs.next()) {
            String column1Value = rs.getString("PHAR_ID");
            String column2Value = rs.getString("PHAR_FNAME");
            String column3Value = rs.getString("PHAR_LNAME");
            String column4Value = rs.getString("PHAR_BIRTHDATE");
            String column5Value = rs.getString("PHAR_POS");
            String column6Value = rs.getString("PHAR_ADD");
            String column7Value = rs.getString("PHAR_CELL_NUM");
            String column8Value = rs.getString("PHAR_USERNAME");
            String column9Value = rs.getString("PHAR_PASS");
            model.addRow(new Object[]{column1Value, column2Value, column3Value, column4Value, column5Value, column6Value, column7Value, column8Value, column9Value});
        }

        rs.close();
        stm.close();
        conn.close();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }
      JTableHeader header1 = jTable1.getTableHeader();
    header1.setDefaultRenderer(new PH_SELLER_INFO.CustomHeaderRenderer());
    String[] headerTitles1 = {"ID", "First Name", "Last Name", "Birthdate", "Position", "Address", "Phone No.", "Username", "Password"};
    for (int i = 0; i < headerTitles1.length; i++) {
        header1.getColumnModel().getColumn(i).setHeaderValue(headerTitles1[i]);
    }
   
    
    // Adjust the table column widths
    jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
//    jTable2.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

if (search.getText().isEmpty()) {
        startRefreshTimer(); // Start the refresh timer when the text field is empty
    } else {
        stopRefreshTimer(); // Stop the refresh timer when a search is being performed
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

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        PID = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        fname = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        lname = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        bdate = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        ppos = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        paddress = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        pphone = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        puname = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        ppword = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        search = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
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

        jInternalFrame1.setPreferredSize(new java.awt.Dimension(372, 501));
        jInternalFrame1.setVisible(true);

        jPanel3.setBackground(new java.awt.Color(0, 0, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("UPDATE USER");

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));
        jPanel2.setForeground(new java.awt.Color(204, 255, 255));

        jLabel3.setText("User ID:");

        jLabel4.setText("First Name:");

        jLabel5.setText("Last Name:");

        jLabel6.setText("Birthdate:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Position:");

        ppos.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        ppos.setEnabled(false);

        jLabel8.setText("Address:");

        jLabel9.setText("Phone No.:");

        jLabel10.setText("Username:");

        jButton4.setFont(new java.awt.Font("Nasalization Rg", 1, 18)); // NOI18N
        jButton4.setText("Update");
        jButton4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel11.setText("Password:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PID)
                    .addComponent(fname)
                    .addComponent(lname)
                    .addComponent(bdate)
                    .addComponent(ppos)
                    .addComponent(paddress)
                    .addComponent(pphone)
                    .addComponent(puname, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                    .addComponent(ppword))
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(PID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(fname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(bdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(ppos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(paddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(pphone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(puname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(ppword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel2)
                .addContainerGap(58, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable1.setBackground(new java.awt.Color(51, 51, 51));
        jTable1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTable1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "First Name", "Last Name", "Birthdate", "Position", "Address", "Phone No.", "Username", "Status"
            }
        ));
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search (1).png"))); // NOI18N
        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Search:");

        search.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(jButton1)
                        .addContainerGap())
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1009, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addComponent(jInternalFrame1, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
Timer timer = new Timer(1000 , e -> updateTableData());

        try {
            Connection conn;
            int rowsAffected = 0;
            PreparedStatement stm;

            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql:///psystem", "root", "");

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            int selectedRowIndex = jTable1.getSelectedRow();

            if (selectedRowIndex >= 0) {
String id = PID.getText();
String f_name = fname.getText();
String l_name = lname.getText();
String b_date = bdate.getText();
String p_pos = ppos.getText();
String p_address = paddress.getText();
String p_phone = pphone.getText();
String p_uname = puname.getText();
String pword = ppword.getText();

String updateQuery = "UPDATE pharmacists_inf SET PHAR_NAME, PHAR_LNAME, PHAR_BIRTHDATE, PHAR_ADD, PHAR_CELL_NUM, PHAR_USERNAME, PHAR_PASS = ? WHERE PHAR_ID = ?";
stm = conn.prepareStatement(updateQuery);
stm.setString(1, id);
stm.setString(2, f_name);
stm.setString(3, l_name);
stm.setString(4, b_date);
stm.setString(5, p_pos);
stm.setString(6, p_address);
stm.setString(7, p_phone);
stm.setString(8, p_uname);
stm.setString(9, pword);
stm.executeUpdate();




                
                    //          Timer timer = new Timer(1000, e -> updateTableData());
                    timer.start();

                    JOptionPane.showMessageDialog(null, "Information updated successfully.");

                    JDialog dialog = JOptionPane.getRootFrame().getComponentCount() > 0 ? (JDialog) JOptionPane.getRootFrame().getComponents()[0] : null;
                    if (dialog != null) {
                        dialog.addWindowListener(new WindowAdapter() {
                            @Override
                            public void windowClosed(WindowEvent e) {
                                timer.stop();
                            }
                        });
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "User update failed.");
                }

            
            

            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {

            if (timer != null && timer.isRunning()) {
                timer.stop();
            }
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        try {
            int index = jTable1.getSelectedRow();
            TableModel model = jTable1.getModel();

            Object col1Obj = model.getValueAt(index, 0);
            Object col2Obj = model.getValueAt(index, 1);
            Object col3Obj = model.getValueAt(index, 2);
            Object col4Obj = model.getValueAt(index, 3);
            Object col5Obj = model.getValueAt(index, 4);
            Object col6Obj = model.getValueAt(index, 5);
            Object col7Obj = model.getValueAt(index, 6);
            Object col8Obj = model.getValueAt(index, 7);
            Object col9Obj = model.getValueAt(index, 8);

            if (col1Obj != null) {
                PID.setText(col1Obj.toString());
            }
            if (col2Obj != null) {
                fname.setText(col2Obj.toString());
            }
            if (col3Obj != null) {
                lname.setText(col3Obj.toString());
            }
            if (col4Obj != null) {
                bdate.setText(col4Obj.toString());
            }
            if (col5Obj != null) {
                ppos.setText(col5Obj.toString());
            }
            if (col6Obj != null) {
                paddress.setText(col6Obj.toString());
            }
            if (col7Obj != null) {
                pphone.setText(col7Obj.toString());
            }
            if (col8Obj != null) {
                puname.setText(col8Obj.toString());
            }
            if (col9Obj != null) {
                ppword.setText(col9Obj.toString());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if(search.getText().isEmpty()){
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            String sql = "SELECT * FROM med_inventory WHERE MED_NAME LIKE ?";

            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql:///psystem", "root", "");
                com.mysql.jdbc.PreparedStatement stm = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement(sql);
                // Add the wildcard characters to the search term
            String searchTerm = "%" + search.getText() + "%";
            stm.setString(1, searchTerm);
                ResultSet rs = stm.executeQuery();

                while (rs.next()) {
                    String column1Value = rs.getString("PHAR_ID");
                    String column2Value = rs.getString("PHAR_FNAME");
                    String column3Value = rs.getString("PHAR_LNAME");
                    String column4Value = rs.getString("PHAR_BIRTHDATE");
                    String column5Value = rs.getString("PHAR_POS");
                    String column6Value = rs.getString("PHAR_ADD");
                    String column7Value = rs.getString("PHAR_CELL_NUM");
                    String column8Value = rs.getString("PHAR_USERNAME");
                    String column9Value = rs.getString("PHAR_PASS");
                      String column10Value = rs.getString("PHAR_STATUS");
                    model.addRow(new Object[]{column1Value, column2Value, column3Value, column4Value, column5Value, column6Value, column7Value, column8Value, column9Value, column10Value});
                }

                rs.close();
                stm.close();
                conn.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }

        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
     try {
            this.setMaximum(true);
        } catch (java.beans.PropertyVetoException ex) {
        
            System.err.println("Error maximizing internal frame: " + ex.getMessage());
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_formInternalFrameOpened

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_formInternalFrameClosed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchActionPerformed

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
         // TODO add your handling code here:
    }//GEN-LAST:event_jButton4MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField PID;
    private javax.swing.JTextField bdate;
    private javax.swing.JTextField fname;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField lname;
    private javax.swing.JTextField paddress;
    private javax.swing.JTextField pphone;
    private javax.swing.JTextField ppos;
    private javax.swing.JTextField ppword;
    private javax.swing.JTextField puname;
    private javax.swing.JTextField search;
    // End of variables declaration//GEN-END:variables
}
