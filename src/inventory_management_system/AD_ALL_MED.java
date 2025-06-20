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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.Timer;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Mariz
 */
public class AD_ALL_MED extends javax.swing.JInternalFrame {

    /**
     * Creates new form AD_ALL_MED
     */
    public AD_ALL_MED() {
        initComponents();
        updateTableData();
         Timer timer = new Timer(10000 , e -> updateTableData());
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

  
    public void updateTableData(){    
    DefaultTableModel model1 = (DefaultTableModel) jTable1.getModel();
model1.setRowCount(0);

String sql1 = "SELECT * FROM med_inventory WHERE MED_CLASSIFICATION = 'Capsule'";
            
             

try {
    Class.forName("com.mysql.jdbc.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mysql:///psystem", "root", "");
    PreparedStatement stm1 = conn.prepareStatement(sql1);
    ResultSet rs1 = stm1.executeQuery();

    while (rs1.next()) {
        String column1Value = rs1.getString("MED_ID");
        String column2Value = rs1.getString("MED_NAME");
        String column3Value = rs1.getString("MED_DOSAGE");
        String column4Value = rs1.getString("MED_TYPE");
        String column5Value = rs1.getString("MED_CLASSIFICATION");
                    String column6Value = rs1.getString("MED_MANUFACTURER");
                    String column7Value = rs1.getString("MED_EXPIRY");
                    String column8Value = rs1.getString("MED_LOCATION");
                    String column9Value = rs1.getString("MED_QUANTITY");
                    String column10Value = rs1.getString("MED_PRICE");
                    String column11Value = rs1.getString("MED_STATUS");
        model1.addRow(new Object[]{column1Value, column2Value, column3Value, column4Value, column5Value, column6Value, column7Value, column8Value, column9Value, column10Value, column11Value});
    }

    rs1.close();
    stm1.close();
    conn.close();
} catch (Exception e) {
    JOptionPane.showMessageDialog(null, e);
}

DefaultTableModel model2 = (DefaultTableModel) jTable2.getModel();
model2.setRowCount(0);

String sql2 = "SELECT * FROM med_inventory WHERE MED_CLASSIFICATION = 'Tablet'";

try {
    Class.forName("com.mysql.jdbc.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mysql:///psystem", "root", "");
    PreparedStatement stm2 = conn.prepareStatement(sql2);
    ResultSet rs2 = stm2.executeQuery();

    while (rs2.next()) {
        String column1Value = rs2.getString("MED_ID");
        String column2Value = rs2.getString("MED_NAME");
        String column3Value = rs2.getString("MED_DOSAGE");
        String column4Value = rs2.getString("MED_TYPE");
        String column5Value = rs2.getString("MED_CLASSIFICATION");
                    String column6Value = rs2.getString("MED_MANUFACTURER");
                    String column7Value = rs2.getString("MED_EXPIRY");
                    String column8Value = rs2.getString("MED_LOCATION");
                    String column9Value = rs2.getString("MED_QUANTITY");
                    String column10Value = rs2.getString("MED_PRICE");
                    String column11Value = rs2.getString("MED_STATUS");
        model2.addRow(new Object[]{column1Value, column2Value, column3Value, column4Value,  column5Value, column6Value, column7Value, column8Value, column9Value, column10Value, column11Value});
    }

    rs2.close();
    stm2.close();
    conn.close();
} catch (Exception e) {
    JOptionPane.showMessageDialog(null, e);
}

DefaultTableModel model3 = (DefaultTableModel) jTable3.getModel();
model3.setRowCount(0);

String sql3 =  "SELECT * FROM med_inventory WHERE MED_CLASSIFICATION = 'Syrup'";

try {
    Class.forName("com.mysql.jdbc.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mysql:///psystem", "root", "");
    PreparedStatement stm3 = conn.prepareStatement(sql3);
    ResultSet rs3 = stm3.executeQuery();

    while (rs3.next()) {
        String column1Value = rs3.getString("MED_ID");
        String column2Value = rs3.getString("MED_NAME");
        String column3Value = rs3.getString("MED_DOSAGE");
        String column4Value = rs3.getString("MED_TYPE");
        String column4AValue = rs3.getString("MED_CLASSIFICATION");
        String column5Value = rs3.getString("MED_MANUFACTURER");
        String column6Value = rs3.getString("MED_EXPIRY");
        String column7Value = rs3.getString("MED_LOCATION");
        String column8Value = rs3.getString("MED_QUANTITY");
        String column9Value = rs3.getString("MED_PRICE");
          String column10Value = rs3.getString("MED_STATUS");
        model3.addRow(new Object[]{column1Value, column2Value, column3Value, column4Value, column4AValue, column5Value, column6Value, column7Value, column8Value, column9Value, column10Value});
    }

    rs3.close();
    stm3.close();
    conn.close();
} catch (Exception e) {
    JOptionPane.showMessageDialog(null, e);
}

DefaultTableModel model4 = (DefaultTableModel) jTable4.getModel();
model4.setRowCount(0);

String sql4 = "SELECT * FROM med_inventory WHERE MED_CLASSIFICATION = 'Others'";

try {
    Class.forName("com.mysql.jdbc.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mysql:///psystem", "root", "");
    PreparedStatement stm3 = conn.prepareStatement(sql4);
    ResultSet rs3 = stm3.executeQuery();

    while (rs3.next()) {
        String column1Value = rs3.getString("MED_ID");
        String column2Value = rs3.getString("MED_NAME");
        String column3Value = rs3.getString("MED_DOSAGE");
        String column4Value = rs3.getString("MED_TYPE");
        String column4AValue = rs3.getString("MED_CLASSIFICATION");
        String column5Value = rs3.getString("MED_MANUFACTURER");
        String column6Value = rs3.getString("MED_EXPIRY");
        String column7Value = rs3.getString("MED_LOCATION");
        String column8Value = rs3.getString("MED_QUANTITY");
        String column9Value = rs3.getString("MED_PRICE");
        String column10Value = rs3.getString("MED_STATUS");
        model4.addRow(new Object[]{column1Value, column2Value, column3Value, column4Value, column4AValue, column5Value, column6Value, column7Value, column8Value, column9Value, column10Value});
    }

    rs3.close();
    stm3.close();
    conn.close();
} catch (Exception e) {
    JOptionPane.showMessageDialog(null, e);
}

     JTableHeader header1 = jTable1.getTableHeader();
    header1.setDefaultRenderer(new AD_ALL_MED.CustomHeaderRenderer());
    String[] headerTitles1 = {"Product ID", "Product Name", "Dosage", "Type", "Classification","Manufacturer", "Expiry", "Location", "Quantity", "Price", "Status"};
    for (int i = 0; i < headerTitles1.length; i++) {
        header1.getColumnModel().getColumn(i).setHeaderValue(headerTitles1[i]);
    }
     JTableHeader header2 = jTable2.getTableHeader();
    header2.setDefaultRenderer(new AD_ALL_MED.CustomHeaderRenderer());
    String[] headerTitles2 = {"Product ID", "Product Name", "Dosage", "Type", "Classification","Manufacturer", "Expiry", "Location", "Quantity", "Price", "Status"};
    for (int i = 0; i < headerTitles1.length; i++) {
        header2.getColumnModel().getColumn(i).setHeaderValue(headerTitles2[i]);
    }
     JTableHeader header3 = jTable3.getTableHeader();
    header3.setDefaultRenderer(new AD_ALL_MED.CustomHeaderRenderer());
    String[] headerTitles3 = {"Product ID", "Product Name", "Dosage", "Type", "Classification","Manufacturer", "Expiry", "Location", "Quantity", "Price", "Status"};
    for (int i = 0; i < headerTitles1.length; i++) {
        header3.getColumnModel().getColumn(i).setHeaderValue(headerTitles3[i]);
    }
     JTableHeader header4 = jTable4.getTableHeader();
    header4.setDefaultRenderer(new AD_ALL_MED.CustomHeaderRenderer());
    String[] headerTitles4 = {"Product ID", "Product Name", "Dosage", "Type", "Classification","Manufacturer", "Expiry", "Location", "Quantity", "Price", "Status"};
    for (int i = 0; i < headerTitles1.length; i++) {
        header4.getColumnModel().getColumn(i).setHeaderValue(headerTitles4[i]);
    }
    
    
    
    // Adjust the table column widths
    jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
//    jTable2.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        search1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        search = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        search2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        search3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();

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

        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jTable1.setBackground(new java.awt.Color(51, 51, 51));
        jTable1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTable1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Product ID", "Product Name", "Dosage", "Type", "Classification", "Manufacturer", "EXP-D", "Location", "Quantity", "Price", "Status"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTable1MouseEntered(evt);
            }
        });
        jTable1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jTable1ComponentShown(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        search1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search1ActionPerformed(evt);
            }
        });
        search1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search1KeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Search Items:");

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search (1).png"))); // NOI18N
        jButton5.setText("Search");
        jButton5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1157, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(search1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(search1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        jTabbedPane1.addTab("Capsule", jPanel2);

        jTable2.setBackground(new java.awt.Color(51, 51, 51));
        jTable2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTable2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable2.setForeground(new java.awt.Color(255, 255, 255));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Product ID", "Product Name", "Dosage", "Type", "Classification", "Manufacturer", "EXP-D", "Location", "Quantity", "Price", "Status"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTable2MouseEntered(evt);
            }
        });
        jTable2.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jTable2ComponentShown(evt);
            }
        });
        jScrollPane5.setViewportView(jTable2);

        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Search Items:");

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search (1).png"))); // NOI18N
        jButton4.setText("Search");
        jButton4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 1157, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        jTabbedPane1.addTab("Tablet", jPanel4);

        jTable3.setBackground(new java.awt.Color(51, 51, 51));
        jTable3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTable3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable3.setForeground(new java.awt.Color(255, 255, 255));
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Product ID", "Product Name", "Dosage", "Type", "Classification", "Manufacturer", "EXP-D", "Location", "Quantity", "Price", "Status"
            }
        ));
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTable3MouseEntered(evt);
            }
        });
        jTable3.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jTable3ComponentShown(evt);
            }
        });
        jScrollPane6.setViewportView(jTable3);

        search2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search2ActionPerformed(evt);
            }
        });
        search2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search2KeyReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Search Items:");

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search (1).png"))); // NOI18N
        jButton6.setText("Search");
        jButton6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 1157, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(search2, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(search2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        jTabbedPane1.addTab("Syrup", jPanel3);

        jTable4.setBackground(new java.awt.Color(51, 51, 51));
        jTable4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTable4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable4.setForeground(new java.awt.Color(255, 255, 255));
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Product ID", "Product Name", "Dosage", "Type", "Classification", "Manufacturer", "EXP-D", "Location", "Quantity", "Price", "Status"
            }
        ));
        jTable4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTable4MouseEntered(evt);
            }
        });
        jTable4.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jTable4ComponentShown(evt);
            }
        });
        jScrollPane7.setViewportView(jTable4);

        search3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search3ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Search Items:");

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search (1).png"))); // NOI18N
        jButton7.setText("Search");
        jButton7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 1157, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(search3, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(search3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        jTabbedPane1.addTab("Others", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        // TODO add your handling code here:
         try {
            this.setMaximum(true);
        } catch (java.beans.PropertyVetoException ex) {
        
            System.err.println("Error maximizing internal frame: " + ex.getMessage());
        }
        
        // TODO add your handling code here:
    }//GEN-LAST:event_formInternalFrameOpened

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
      // TODO add your handling code here:
    }//GEN-LAST:event_formInternalFrameClosed

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void jTable1ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jTable1ComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1ComponentShown

    private void jTable1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseEntered
        // TODO add your handling code here:
        //
        //        Connection conn;
        //        ResultSet rs;
        //        com.mysql.jdbc.PreparedStatement stm;
        //
        //        DefaultTableModel model = new DefaultTableModel();
        //        model.addColumn("Product ID");
        //        model.addColumn("Product Name");
        //        model.addColumn("Dosage");
        //        model.addColumn("Type");
        //        model.addColumn("Manufacturer");
        //        model.addColumn("Expiry Date");
        //        model.addColumn("Location");
        //        model.addColumn("Quantity");
        //        model.addColumn("Price");
        //
        //        String sql = "SELECT `MED_ID`, `MED_NAME`, `MED_DOSAGE`, `MED_TYPE`, `MED_MANUFACTURER`, `MED_EXPIRY`, `MED_LOCATION`, `MED_QUANTITY`, `MED_PRICE` FROM `med_inventory`";
        //
        //        try{
            //            Class.forName("com.mysql.jdbc.Driver");
            //            conn = DriverManager.getConnection("jdbc:mysql:///psystem","root","");
            //            stm = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement(sql);
            //            rs = stm.executeQuery();
            //
            //            while(rs.next()){
                //                String column1Value = rs.getString("MED_ID");
                //                String column2Value = rs.getString("MED_NAME");
                //                String column3Value = rs.getString("MED_DOSAGE");
                //                String column4Value = rs.getString("MED_TYPE");
                //                String column5Value = rs.getString("MED_MANUFACTURER");
                //                String column6Value = rs.getString("MED_EXPIRY");
                //                String column7Value = rs.getString("MED_LOCATION");
                //                String column8Value = rs.getString("MED_QUANTITY");
                //                String column9Value = rs.getString("MED_PRICE");
                //                model.addRow(new Object[]{column1Value, column2Value, column3Value, column4Value, column5Value, column6Value, column7Value, column8Value, column9Value});
                //            }
            //            jTable1.setModel(model);
            //        }
        //        catch(Exception e){
            //
            //            JOptionPane.showMessageDialog(null,e);
            //        }
    }//GEN-LAST:event_jTable1MouseEntered

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked


        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable2MouseClicked

    private void jTable2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable2MouseEntered

    private void jTable2ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jTable2ComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable2ComponentShown

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable3MouseClicked

    private void jTable3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable3MouseEntered

    private void jTable3ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jTable3ComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable3ComponentShown

    private void jTable4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable4MouseClicked

    private void jTable4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable4MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable4MouseEntered

    private void jTable4ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jTable4ComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable4ComponentShown

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
  Timer timer = new Timer(10000 , e -> updateTableData());
        if (search.getText().isEmpty()) {
    DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
    model.setRowCount(0);

    String sql = "SELECT * FROM med_inventory WHERE MED_CLASSIFICATION = 'Tablet'";

    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql:///psystem", "root", "");
        PreparedStatement stm = conn.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();

        while (rs.next()) {
            String column1Value = rs.getString("MED_ID");
            String column2Value = rs.getString("MED_NAME");
            String column3Value = rs.getString("MED_DOSAGE");
            String column4Value = rs.getString("MED_TYPE");
            String column4AValue = rs.getString("MED_CLASSIFICATION");
            String column5Value = rs.getString("MED_MANUFACTURER");
            String column6Value = rs.getString("MED_EXPIRY");
            String column7Value = rs.getString("MED_LOCATION");
            String column8Value = rs.getString("MED_QUANTITY");
            String column9Value = rs.getString("MED_PRICE");
            String column10Value = rs.getString("MED_STATUS");
            model.addRow(new Object[]{column1Value, column2Value, column3Value, column4Value, column4AValue, column5Value, column6Value, column7Value, column8Value, column9Value, column10Value});
        }

        rs.close();
        stm.close();
        conn.close();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }

} else {
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("Product ID");
    model.addColumn("Product Name");
    model.addColumn("Dosage");
    model.addColumn("Type");
    model.addColumn("Classification");
    model.addColumn("Manufacturer");
    model.addColumn("Expiry Date");
    model.addColumn("Location");
    model.addColumn("Quantity");
    model.addColumn("Price");
    model.addColumn("Status");

    String sql = "SELECT * FROM med_inventory WHERE MED_NAME LIKE ? AND MED_CLASSIFICATION = 'Tablet'";

    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql:///psystem", "root", "");
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setString(1, "%" + search.getText() + "%");
        ResultSet rs = stm.executeQuery();
        boolean itemExists = false;

        while (rs.next()) {
            String column1Value = rs.getString("MED_ID");
            String column2Value = rs.getString("MED_NAME");
            String column3Value = rs.getString("MED_DOSAGE");
            String column4Value = rs.getString("MED_TYPE");
            String column4AValue = rs.getString("MED_CLASSIFICATION");
            String column5Value = rs.getString("MED_MANUFACTURER");
            String column6Value = rs.getString("MED_EXPIRY");
            String column7Value = rs.getString("MED_LOCATION");
            String column8Value = rs.getString("MED_QUANTITY");
            String column9Value = rs.getString("MED_PRICE");
            String column10Value = rs.getString("MED_STATUS");
            model.addRow(new Object[]{column1Value, column2Value, column3Value, column4Value, column4AValue, column5Value, column6Value, column7Value, column8Value, column9Value, column10Value});
            itemExists = true;
        }

        rs.close();
        stm.close();
        conn.close();

        if (!itemExists) {
            JOptionPane.showMessageDialog(null, "The item does not exist.");
        }

        jTable2.setModel(model);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }
 if (search.getText().isEmpty()) {
        timer.start(); // Start the refresh timer when the text field is empty
    } else {
        timer.stop(); // Stop the refresh timer when a search is being performed
    }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void search1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
 Timer timer = new Timer(10000 , e -> updateTableData());

        if (search1.getText().isEmpty()) {
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    model.setRowCount(0);

    String sql = "SELECT * FROM med_inventory WHERE MED_CLASSIFICATION = 'Capsule'";

    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql:///psystem", "root", "");
        PreparedStatement stm = conn.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();

        while (rs.next()) {
            String column1Value = rs.getString("MED_ID");
            String column2Value = rs.getString("MED_NAME");
            String column3Value = rs.getString("MED_DOSAGE");
            String column4Value = rs.getString("MED_TYPE");
            String column4AValue = rs.getString("MED_CLASSIFICATION");
            String column5Value = rs.getString("MED_MANUFACTURER");
            String column6Value = rs.getString("MED_EXPIRY");
            String column7Value = rs.getString("MED_LOCATION");
            String column8Value = rs.getString("MED_QUANTITY");
            String column9Value = rs.getString("MED_PRICE");
            String column10Value = rs.getString("MED_STATUS");
            model.addRow(new Object[]{column1Value, column2Value, column3Value, column4Value, column4AValue, column5Value, column6Value, column7Value, column8Value, column9Value, column10Value});
        }

        rs.close();
        stm.close();
        conn.close();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }

} else {
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("Product ID");
    model.addColumn("Product Name");
    model.addColumn("Dosage");
    model.addColumn("Type");
    model.addColumn("Classification");
    model.addColumn("Manufacturer");
    model.addColumn("Expiry Date");
    model.addColumn("Location");
    model.addColumn("Quantity");
    model.addColumn("Price");
    model.addColumn("Status");

    String sql = "SELECT * FROM med_inventory WHERE MED_NAME LIKE ? AND MED_CLASSIFICATION = 'Capsule'";

    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql:///psystem", "root", "");
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setString(1, "%" + search1.getText() + "%");
        ResultSet rs = stm.executeQuery();
        boolean itemExists = false;

        while (rs.next()) {
            String column1Value = rs.getString("MED_ID");
            String column2Value = rs.getString("MED_NAME");
            String column3Value = rs.getString("MED_DOSAGE");
            String column4Value = rs.getString("MED_TYPE");
            String column4AValue = rs.getString("MED_CLASSIFICATION");
            String column5Value = rs.getString("MED_MANUFACTURER");
            String column6Value = rs.getString("MED_EXPIRY");
            String column7Value = rs.getString("MED_LOCATION");
            String column8Value = rs.getString("MED_QUANTITY");
            String column9Value = rs.getString("MED_PRICE");
            String column10Value = rs.getString("MED_STATUS");
            model.addRow(new Object[]{column1Value, column2Value, column3Value, column4Value, column4AValue, column5Value, column6Value, column7Value, column8Value, column9Value, column10Value});
            itemExists = true;
        }

        rs.close();
        stm.close();
        conn.close();

        if (!itemExists) {
            JOptionPane.showMessageDialog(null, "The item does not exist.");
        }

        jTable1.setModel(model);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }
 if (search1.getText().isEmpty()) {
        timer.start(); // Start the refresh timer when the text field is empty
    } else {
        timer.stop(); // Stop the refresh timer when a search is being performed
    }
        
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void search2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
Timer timer = new Timer(1000 , e -> updateTableData());
        if (search2.getText().isEmpty()) {
    DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
    model.setRowCount(0);

    String sql = "SELECT * FROM med_inventory WHERE MED_CLASSIFICATION = 'Syrup'";

    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql:///psystem", "root", "");
        PreparedStatement stm = conn.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();

        while (rs.next()) {
            String column1Value = rs.getString("MED_ID");
            String column2Value = rs.getString("MED_NAME");
            String column3Value = rs.getString("MED_DOSAGE");
            String column4Value = rs.getString("MED_TYPE");
            String column4AValue = rs.getString("MED_CLASSIFICATION");
            String column5Value = rs.getString("MED_MANUFACTURER");
            String column6Value = rs.getString("MED_EXPIRY");
            String column7Value = rs.getString("MED_LOCATION");
            String column8Value = rs.getString("MED_QUANTITY");
            String column9Value = rs.getString("MED_PRICE");
            String column10Value = rs.getString("MED_STATUS");
            model.addRow(new Object[]{column1Value, column2Value, column3Value, column4Value, column4AValue, column5Value, column6Value, column7Value, column8Value, column9Value, column10Value});
        }

        rs.close();
        stm.close();
        conn.close();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }

} else {
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("Product ID");
    model.addColumn("Product Name");
    model.addColumn("Dosage");
    model.addColumn("Type");
    model.addColumn("Classification");
    model.addColumn("Manufacturer");
    model.addColumn("Expiry Date");
    model.addColumn("Location");
    model.addColumn("Quantity");
    model.addColumn("Price");
    model.addColumn("Status");

    String sql = "SELECT * FROM med_inventory WHERE MED_NAME LIKE ? AND MED_CLASSIFICATION = 'Syrup'";

    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql:///psystem", "root", "");
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setString(1, "%" + search2.getText() + "%");
        ResultSet rs = stm.executeQuery();
        boolean itemExists = false;

        while (rs.next()) {
            String column1Value = rs.getString("MED_ID");
            String column2Value = rs.getString("MED_NAME");
            String column3Value = rs.getString("MED_DOSAGE");
            String column4Value = rs.getString("MED_TYPE");
            String column4AValue = rs.getString("MED_CLASSIFICATION");
            String column5Value = rs.getString("MED_MANUFACTURER");
            String column6Value = rs.getString("MED_EXPIRY");
            String column7Value = rs.getString("MED_LOCATION");
            String column8Value = rs.getString("MED_QUANTITY");
            String column9Value = rs.getString("MED_PRICE");
            String column10Value = rs.getString("MED_STATUS");
            model.addRow(new Object[]{column1Value, column2Value, column3Value, column4Value, column4AValue, column5Value, column6Value, column7Value, column8Value, column9Value, column10Value});
            itemExists = true;
        }

        rs.close();
        stm.close();
        conn.close();

        if (!itemExists) {
            JOptionPane.showMessageDialog(null, "The item does not exist.");
        }

        jTable3.setModel(model);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }
  if (search2.getText().isEmpty()) {
        timer.start(); // Start the refresh timer when the text field is empty
    } else {
        timer.stop(); // Stop the refresh timer when a search is being performed
    }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void search3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search3ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
 Timer timer = new Timer(10000 , e -> updateTableData());
        if (search3.getText().isEmpty()) {
    DefaultTableModel model = (DefaultTableModel) jTable4.getModel();
    model.setRowCount(0);

    String sql = "SELECT * FROM med_inventory WHERE MED_CLASSIFICATION = 'Others'";

    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql:///psystem", "root", "");
        PreparedStatement stm = conn.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();

        while (rs.next()) {
            String column1Value = rs.getString("MED_ID");
            String column2Value = rs.getString("MED_NAME");
            String column3Value = rs.getString("MED_DOSAGE");
            String column4Value = rs.getString("MED_TYPE");
            String column4AValue = rs.getString("MED_CLASSIFICATION");
            String column5Value = rs.getString("MED_MANUFACTURER");
            String column6Value = rs.getString("MED_EXPIRY");
            String column7Value = rs.getString("MED_LOCATION");
            String column8Value = rs.getString("MED_QUANTITY");
            String column9Value = rs.getString("MED_PRICE");
            String column10Value = rs.getString("MED_STATUS");
            model.addRow(new Object[]{column1Value, column2Value, column3Value, column4Value, column4AValue, column5Value, column6Value, column7Value, column8Value, column9Value, column10Value});
        }

        rs.close();
        stm.close();
        conn.close();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }

} else {
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("Product ID");
    model.addColumn("Product Name");
    model.addColumn("Dosage");
    model.addColumn("Type");
    model.addColumn("Classification");
    model.addColumn("Manufacturer");
    model.addColumn("Expiry Date");
    model.addColumn("Location");
    model.addColumn("Quantity");
    model.addColumn("Price");
    model.addColumn("Status");

    String sql = "SELECT * FROM med_inventory WHERE MED_NAME LIKE ? AND MED_CLASSIFICATION = 'Others'";

    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql:///psystem", "root", "");
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setString(1, "%" + search3.getText() + "%");
        ResultSet rs = stm.executeQuery();
        boolean itemExists = false;

        while (rs.next()) {
            String column1Value = rs.getString("MED_ID");
            String column2Value = rs.getString("MED_NAME");
            String column3Value = rs.getString("MED_DOSAGE");
            String column4Value = rs.getString("MED_TYPE");
            String column4AValue = rs.getString("MED_CLASSIFICATION");
            String column5Value = rs.getString("MED_MANUFACTURER");
            String column6Value = rs.getString("MED_EXPIRY");
            String column7Value = rs.getString("MED_LOCATION");
            String column8Value = rs.getString("MED_QUANTITY");
            String column9Value = rs.getString("MED_PRICE");
            String column10Value = rs.getString("MED_STATUS");
            model.addRow(new Object[]{column1Value, column2Value, column3Value, column4Value, column4AValue, column5Value, column6Value, column7Value, column8Value, column9Value, column10Value});
            itemExists = true;
        }

        rs.close();
        stm.close();
        conn.close();

        if (!itemExists) {
            JOptionPane.showMessageDialog(null, "The item does not exist.");
        }

        jTable4.setModel(model);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }
  if (search3.getText().isEmpty()) {
        timer.start(); // Start the refresh timer when the text field is empty
    } else {
        timer.stop(); // Stop the refresh timer when a search is being performed
    }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void search1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search1KeyReleased

        // TODO add your handling code here:
    }//GEN-LAST:event_search1KeyReleased

    private void searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_searchKeyReleased

    private void search2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search2KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_search2KeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTextField search;
    private javax.swing.JTextField search1;
    private javax.swing.JTextField search2;
    private javax.swing.JTextField search3;
    // End of variables declaration//GEN-END:variables
}
