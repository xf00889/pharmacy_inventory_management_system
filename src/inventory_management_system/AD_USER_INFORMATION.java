/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory_management_system;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.TableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.awt.Color;
import java.awt.Window;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;


/**
 *
 * @author Mariz
 */
public class AD_USER_INFORMATION extends javax.swing.JInternalFrame {
 private Connection conn;
    private PreparedStatement stm;
    private ResultSet rs;
    /**
     * Creates new form AD_USER_INFORMATION
     */
    public AD_USER_INFORMATION() {
        initComponents();
        updateTableData();
      Timer timer = new Timer(10000 , e -> updateTableData());
         timer.start(); 
    }
    
    public void updateData(String pid){
    
            PID1.setText(pid);
    
    }
    
    private static class CustomHeaderRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                   boolean hasFocus, int row, int column) {
        Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // Set the desired font and size for the title
        Font font = new Font("Tahoma", Font.BOLD, 18);  // Customize the font and size as per your needs
        component.setFont(font);
         component.setBackground(Color.BLUE);  // Customize the color as per your needs

        // Set the foreground (text) color for the title
        component.setForeground(Color.WHITE);  // Customize the color as per your needs


        return component;
    }
}

    

public void updateTableData() {
    try {
        DefaultTableModel model1 = (DefaultTableModel) jTable1.getModel();
        model1.setRowCount(0);
        DefaultTableModel model2 = (DefaultTableModel) jTable2.getModel();
        model2.setRowCount(0);

        String sql = "SELECT * FROM pharmacists_inf";

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
            String column10Value = rs.getString("PHAR_STATUS");
            posi.setText(column5Value);
            statu.setText(column10Value);
            // Check if PHAR_POS and PHAR_STATUS have values
            if (posi.getText().isEmpty() && posi.getText().isEmpty()) {
                model2.addRow(new Object[]{column1Value, column2Value, column3Value, column4Value, column5Value, column6Value, column7Value, column8Value, column10Value});
            } else {
                model1.addRow(new Object[]{column1Value, column2Value, column3Value, column4Value, column5Value, column6Value, column7Value, column8Value, column10Value});
            }
        }

        rs.close();
        stm.close();
        conn.close();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }

    JTableHeader header1 = jTable1.getTableHeader();
    header1.setDefaultRenderer(new AD_USER_INFORMATION.CustomHeaderRenderer());
    String[] headerTitles1 = {"ID", "First Name", "Last Name", "Birthdate", "Position", "Address", "Phone No.", "Username", "Status"};
    for (int i = 0; i < headerTitles1.length; i++) {
        header1.getColumnModel().getColumn(i).setHeaderValue(headerTitles1[i]);
    }

    JTableHeader header2 = jTable2.getTableHeader();
    header2.setDefaultRenderer(new AD_USER_INFORMATION.CustomHeaderRenderer());
    String[] headerTitles2 = {"ID", "First Name", "Last Name", "Birthdate", "Position", "Address", "Phone No.", "Username", "Status"};
    for (int i = 0; i < headerTitles2.length; i++) {
        header2.getColumnModel().getColumn(i).setHeaderValue(headerTitles2[i]);
    }

    // Adjust the table column widths
    jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    jTable2.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

    String[] statusOptions = {"","Active", "Inactive"};
    String[] positionOptions = {"","Seller", "Manager", "Inventory Clerk"};
    DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>(statusOptions);
    DefaultComboBoxModel<String> comboBoxModel1 = new DefaultComboBoxModel<>(positionOptions);
    pstatus.setModel(comboBoxModel);
    ppos.setModel(comboBoxModel1);
}

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
 
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PID1 = new javax.swing.JTextField();
        statu = new javax.swing.JTextField();
        posi = new javax.swing.JTextField();
        jInternalFrame1 = new javax.swing.JInternalFrame();
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
        jLabel8 = new javax.swing.JLabel();
        paddress = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        pphone = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        puname = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        ppos = new javax.swing.JComboBox<>();
        pstatus = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        search = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

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

        jInternalFrame1.setPreferredSize(new java.awt.Dimension(372, 501));
        jInternalFrame1.setVisible(true);

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));
        jPanel2.setForeground(new java.awt.Color(204, 255, 255));

        jLabel3.setText("User ID:");

        PID.setEnabled(false);

        jLabel4.setText("First Name:");

        fname.setEnabled(false);

        jLabel5.setText("Last Name:");

        lname.setEnabled(false);

        jLabel6.setText("Birthdate:");

        bdate.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Position:");

        jLabel8.setText("Address:");

        paddress.setEnabled(false);

        jLabel9.setText("Phone No.:");

        pphone.setEnabled(false);

        jLabel10.setText("Username:");

        puname.setEnabled(false);

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton4.setText("Update");
        jButton4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel12.setText("Status:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pstatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(PID)
                            .addComponent(fname)
                            .addComponent(lname)
                            .addComponent(bdate)
                            .addComponent(paddress)
                            .addComponent(pphone)
                            .addComponent(puname, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                            .addComponent(ppos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
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
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(pstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(0, 0, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("UPDATE USER");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel2)
                .addContainerGap(58, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Search:");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search (1).png"))); // NOI18N
        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

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

        search.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Unassigned Users: ");

        jTable2.setBackground(new java.awt.Color(51, 51, 51));
        jTable2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTable2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable2.setForeground(new java.awt.Color(255, 255, 255));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "First Name", "Last Name", "Birthdate", "Position", "Address", "Phone No.", "Username", "Status"
            }
        ));
        jTable2.getTableHeader().setReorderingAllowed(false);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 999, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton1)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jInternalFrame1, javax.swing.GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
 Timer timer = new Timer(10000 , e -> updateTableData());
        if(search.getText().isEmpty()){
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            String sql = "SELECT `PHAR_ID`, `PHAR_FNAME`, `PHAR_LNAME`, `PHAR_BIRTHDATE`, `PHAR_POS`,`PHAR_ADD`, `PHAR_CELL_NUM`, `PHAR_USERNAME`, PHAR_STATUS FROM `pharmacists_inf`";

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
            String column81Value = rs.getString("PHAR_STATUS");
           
            model.addRow(new Object[]{column1Value, column2Value,column81Value, column3Value, column4Value, column5Value, column6Value, column7Value, column8Value});
                }

                rs.close();
                stm.close();
                conn.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }

        }
        else{
            Connection conn;
            ResultSet rs;
            com.mysql.jdbc.PreparedStatement stm;

            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID");
            model.addColumn("First Name");
            model.addColumn("Last Name");
            model.addColumn("Birthdate");
            model.addColumn("Position");
            model.addColumn("Address");
            model.addColumn("Phone No.");
            model.addColumn("Username");
            model.addColumn("Status");

            String sql = "SELECT * FROM `pharmacists_inf`  where PHAR_USERNAME LIKE ?";

            try{
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql:///psystem","root","");
                stm = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement(sql);
                String searchTerm = "%" + search.getText() + "%";
            stm.setString(1, searchTerm);    
                rs = stm.executeQuery();
                boolean itemExists = false;

                while(rs.next()){
                    String column1Value = rs.getString("PHAR_ID");
            String column2Value = rs.getString("PHAR_FNAME");
            String column3Value = rs.getString("PHAR_LNAME");
            String column4Value = rs.getString("PHAR_BIRTHDATE");
            String column5Value = rs.getString("PHAR_POS");
            String column6Value = rs.getString("PHAR_ADD");
            String column7Value = rs.getString("PHAR_CELL_NUM");
            String column8Value = rs.getString("PHAR_USERNAME");
            String column9Value = rs.getString("PHAR_STATUS");
//            String column9Value = rs.getString("PHAR_PASS");
            model.addRow(new Object[]{column1Value, column2Value, column3Value, column4Value, column5Value, column6Value, column7Value, column8Value, column9Value});
                    itemExists = true;

                }
                if (!itemExists) {
                    JOptionPane.showMessageDialog(null, "The User does not exist.");
                }
                jTable1.setModel(model);
            }
            catch(ClassNotFoundException | SQLException e){

                JOptionPane.showMessageDialog(null,e);
            }
             if (search.getText().isEmpty()) {
        timer.start(); // Start the refresh timer when the text field is empty
    } else {
        timer.stop(); // Stop the refresh timer when a search is being performed
    
        }
                                        

        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
int selectedRowIndex = jTable1.getSelectedRow();
int selectedColumnIndex = jTable1.getSelectedColumn();

if (selectedRowIndex >= 0 && selectedColumnIndex >= 0) {
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    int numColumns = model.getColumnCount();

    if (numColumns >= 8) {
        String col0 = model.getValueAt(selectedRowIndex, 0).toString();
        String col1 = model.getValueAt(selectedRowIndex, 1).toString();
        String col2 = model.getValueAt(selectedRowIndex, 2).toString();
        String col3 = model.getValueAt(selectedRowIndex, 3).toString();
        String col4 = model.getValueAt(selectedRowIndex, 4).toString();
        String col5 = model.getValueAt(selectedRowIndex, 5).toString();
        String col6 = model.getValueAt(selectedRowIndex, 6).toString();
        String col7 = model.getValueAt(selectedRowIndex, 7).toString();
        String col8 = model.getValueAt(selectedRowIndex, 8).toString();
       
  

        PID.setText(col0);
        fname.setText(col1);
        lname.setText(col2);
        bdate.setText(col3);
       JComboBox<String> pposComboBox = new JComboBox<>();
pposComboBox.addItem(col4); 
pposComboBox.addItem("");
pposComboBox.addItem("Seller");
pposComboBox.addItem("Manager"); 
pposComboBox.addItem("Clerk"); 
ppos.setModel(pposComboBox.getModel());
//        classifComboBox.addItem("Syrup");
//        classifComboBox.addItem("Tablet");
//        classifComboBox.addItem("Others");
        
        paddress.setText(col5);
        pphone.setText(col6);
        puname.setText(col7);
        JComboBox<String> pstatusComboBox = new JComboBox<>();
pstatusComboBox.addItem(col8); // Add mstatus value to the combobox
pstatusComboBox.addItem("");
pstatusComboBox.addItem("Active");
pstatusComboBox.addItem("Inactive");
pstatus.setModel(pstatusComboBox.getModel());
      
//        mstatComboBox.addItem("Unvailable");
        // ... Continue setting values to other fields

    } else {
        System.out.println("The table does not have enough columns.");
    }
} else {
    System.out.println("No cell is selected");
}

        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

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
            int selectedRowIndex1 = jTable2.getSelectedRow();

            if (selectedRowIndex >= 0 || selectedRowIndex1 >= 0) {
String id = PID.getText();
String f_name = fname.getText();
String l_name = lname.getText();
String b_date = bdate.getText();
String p_pos = (String)ppos.getSelectedItem();
String p_address = paddress.getText();
String p_phone = pphone.getText();
String p_uname = puname.getText();
String pstat = (String)pstatus.getSelectedItem();

String updateQuery = "UPDATE pharmacists_inf SET PHAR_POS = ?, PHAR_STATUS=? WHERE PHAR_ID = ?";
stm = conn.prepareStatement(updateQuery);
stm.setString(1, p_pos);
stm.setString(2, pstat);
stm.setString(3, id);
stm.executeUpdate();




                
                    //          Timer timer = new Timer(1000, e -> updateTableData());
                    timer.start();

                    JOptionPane.showMessageDialog(null, "User updated successfully.");

                   // JDialog dialog = JOptionPane.getRootFrame().getComponentCount() > 0 ? (JDialog) JOptionPane.getRootFrame().getComponents()[0] : null;
                    JDialog dialog = null;
Window[] windows = JOptionPane.getRootFrame().getOwnedWindows();
for (Window window : windows) {
    if (window instanceof JDialog) {
        dialog = (JDialog) window;
        break;
    }
}

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

        String getLastLoggedInUser = "SELECT * FROM log_in_history WHERE LOG_ID = (SELECT MAX(LOG_ID) FROM log_in_history)";
        String getUserInfo = "SELECT * FROM pharmacists_inf WHERE PHAR_ID = ?";
        String insertActivity = "INSERT INTO activity_history (PHAR_ID, PHAR_USERNAME, PHAR_NAME, PHAR_POS, ACT_DATE, ACT_TIME, ACT_ACTION) VALUES (?,?,?,?,?,?,?)";
       

        try {
            Connection conn;
            
            
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql:///psystem", "root", "");
            

            
                String userId = PID1.getText();

                stm = conn.prepareStatement(getUserInfo);
                stm.setString(1, userId);
                rs = stm.executeQuery();

                if (rs.next()) {
                    String username = rs.getString("PHAR_USERNAME");
                    String fullName = rs.getString("PHAR_FNAME") + " " + rs.getString("PHAR_LNAME");
                    String position = rs.getString("PHAR_POS");

                    stm = conn.prepareStatement(insertActivity);
                    stm.setString(1, userId);
                    stm.setString(2, username);
                    stm.setString(3, fullName);
                    stm.setString(4, position);
                    stm.setDate(5, java.sql.Date.valueOf(LocalDate.now()));
                    stm.setTime(6, java.sql.Time.valueOf(LocalTime.now()));
                    stm.setString(7, "Updated user Position/Status");

                    int rowsInserted1 = stm.executeUpdate();

                    

                        
           
                
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } 
        catch (ClassNotFoundException ex) { 
             Logger.getLogger(PH_SELLER.class.getName()).log(Level.SEVERE, null, ex);
         }   

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
try {
            this.setMaximum(true);
        } catch (java.beans.PropertyVetoException ex) {
        
            System.err.println("Error maximizing internal frame: " + ex.getMessage());
        }
            // TODO add your handling code here:
    }//GEN-LAST:event_formInternalFrameOpened

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
            try {
    int index = jTable2.getSelectedRow();
    
    // Check if a row is selected
    if (index >= 0) {
        TableModel model = jTable2.getModel();
    
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
        
        
        if (col6Obj != null) {
            paddress.setText(col6Obj.toString());
        }
        if (col7Obj != null) {
            pphone.setText(col7Obj.toString());
        }
        if (col8Obj != null) {
            puname.setText(col8Obj.toString());
        }
        
    } else {
        // No row is selected, handle this case as needed
        // For example, display a message or clear the fields
    }
} catch (Exception e) {
    JOptionPane.showMessageDialog(null, e);
}
    }//GEN-LAST:event_jTable2MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField PID;
    private javax.swing.JTextField PID1;
    private javax.swing.JTextField bdate;
    private javax.swing.JTextField fname;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JInternalFrame jInternalFrame1;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField lname;
    private javax.swing.JTextField paddress;
    private javax.swing.JTextField posi;
    private javax.swing.JTextField pphone;
    private javax.swing.JComboBox<String> ppos;
    private javax.swing.JComboBox<String> pstatus;
    private javax.swing.JTextField puname;
    private javax.swing.JTextField search;
    private javax.swing.JTextField statu;
    // End of variables declaration//GEN-END:variables
}
