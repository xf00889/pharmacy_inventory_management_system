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
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;


/**
 *
 * @author Mariz
 */
public class AD_EDIT_INVENTORY extends javax.swing.JInternalFrame {

 

    /**
     * Creates new form ADMIN_PAGE
     */
    public AD_EDIT_INVENTORY() {
        initComponents();
         updateTableData();
         
  
         Timer timer = new Timer(10000 , e -> updateTableData());
         timer.start(); 
//            startRefreshTimer();
//            
//        setupSearchListener();
    }
    
//      private Timer refreshTimer;
//private void startRefreshTimer() {
//        if (refreshTimer == null || !refreshTimer.isRunning()) {
//            refreshTimer = new Timer(100, e -> updateTableData());
//            refreshTimer.start();
//        }
//    }
//
//    private void stopRefreshTimer() {
//        if (refreshTimer != null && refreshTimer.isRunning()) {
//            refreshTimer.stop();
//        }
//    }
//
//    private void setupSearchListener() {
//        search.getDocument().addDocumentListener(new DocumentListener() {
//            @Override
//            public void insertUpdate(DocumentEvent e) {
//                handleSearchChange();
//            }
//
//            @Override
//            public void removeUpdate(DocumentEvent e) {
//                handleSearchChange();
//            }
//
//            @Override
//            public void changedUpdate(DocumentEvent e) {
//                handleSearchChange();
//            }
//
//            private void handleSearchChange() {
//                if (search.getText().isEmpty()) {
//                    startRefreshTimer(); // Start the refresh timer when the text field is empty
//                } else {
//                    stopRefreshTimer(); // Stop the refresh timer when a search is being performed
//                }
//            }
//        });
//    }
    
    
    
    
    private static class CustomHeaderRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                   boolean hasFocus, int row, int column) {
        Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // Set the desired font and size for the title
        Font font = new Font("Tahoma", Font.BOLD, 15);  // Customize the font and size as per your needs
        component.setFont(font);
         component.setBackground(Color.BLUE);  // Customize the color as per your needs

        // Set the foreground (text) color for the title
        component.setForeground(Color.WHITE);  // Customize the color as per your needs


        return component;
    }
}
public void updateData(String pid){
    
            PID.setText(pid);
    
    }
    
public void updateTableData() {
    
  
        
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    model.setRowCount(0); 

    String sql = "SELECT * FROM med_inventory";

    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql:///psystem", "root", "");
        com.mysql.jdbc.PreparedStatement stm = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement(sql);
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
    
    JTableHeader header2 = jTable1.getTableHeader();
    header2.setDefaultRenderer(new AD_EDIT_INVENTORY.CustomHeaderRenderer());
    String[] headerTitles2 = {"ID" ,"Name", "Dosage","Type", "Classification", "Manufacturer", "Expiry","Location", "Quantity", "Price","Status"};
    for (int i = 0; i < headerTitles2.length; i++) {
        header2.getColumnModel().getColumn(i).setHeaderValue(headerTitles2[i]);
    }
    
    // Adjust the table column widths
    jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
//    jTable3.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    
    String[] statusOptions = {" ","Available","Unavailable"};
        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>(statusOptions);
        mstat.setModel(comboBoxModel);
        
    String[] classOptions = {" ","Capsule","Tablet","Syrup","Others"};
        DefaultComboBoxModel<String> comboBoxModel1 = new DefaultComboBoxModel<>(classOptions);
        classif.setModel(comboBoxModel1);
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PID = new javax.swing.JTextField();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        mid = new javax.swing.JTextField();
        pname = new javax.swing.JTextField();
        pdosage = new javax.swing.JTextField();
        ptype = new javax.swing.JTextField();
        pmanu = new javax.swing.JTextField();
        plocation = new javax.swing.JTextField();
        pquan = new javax.swing.JTextField();
        pprice = new javax.swing.JTextField();
        pexpiry = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        mstat = new javax.swing.JComboBox<>();
        classif = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        search = new javax.swing.JTextField();

        PID.setEditable(false);

        setBackground(new java.awt.Color(204, 255, 255));
        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setClosable(true);
        setMaximizable(true);
        setTitle("Edit Inventory");
        setPreferredSize(new java.awt.Dimension(1053, 825));
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

        jInternalFrame1.setVisible(true);
        jInternalFrame1.addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
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
                jInternalFrame1InternalFrameOpened(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Name:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Dosage:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Type:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Manufacturer: ");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Expiry Date:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Location:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Quantity:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Price:");

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton4.setText("Update");
        jButton4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("ID:");

        mid.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        pname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        pdosage.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        ptype.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        pmanu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        plocation.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        pquan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        pprice.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        pexpiry.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Status:");

        mstat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "       ", "Available", "Unavailable", " " }));
        mstat.setToolTipText("");

        classif.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "          ", "Syrup", "Tablet", "Capsule", "Others" }));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Classification:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel13))
                                .addGap(4, 4, 4)))
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(classif, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pquan)
                    .addComponent(plocation)
                    .addComponent(pmanu)
                    .addComponent(ptype)
                    .addComponent(pdosage)
                    .addComponent(pname)
                    .addComponent(mid)
                    .addComponent(pprice, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                    .addComponent(pexpiry)
                    .addComponent(mstat, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mid, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pname, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pdosage, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ptype, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(classif, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pmanu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pexpiry, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(plocation, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pquan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pprice, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mstat, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(0, 0, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("UPDATE ITEM");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel2)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable1.setBackground(new java.awt.Color(51, 51, 51));
        jTable1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTable1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", " Dosage", "Type", "Classification", " Manufacturer", "Expiry Date", "Location", "Quantity", "Price", "Status"
            }
        ));
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Search:");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search (1).png"))); // NOI18N
        jButton1.setText("Search");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setText("Add Items");
        jButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

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
                .addGap(2, 2, 2)
                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(159, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 635, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jInternalFrame1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

         
      
        PH_ADD_ITEM item = new PH_ADD_ITEM();
       new PH_ADD_ITEM().setVisible(true);
        
       
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

         Timer timer = new Timer(1000 , e -> updateTableData());
        
        if(search.getText().isEmpty()){
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            String sql = "SELECT `MED_ID`, `MED_NAME`, `MED_DOSAGE`, `MED_TYPE`, `MED_MANUFACTURER`, `MED_EXPIRY`, `MED_LOCATION`, `MED_QUANTITY`, `MED_PRICE`, `MED_STATUS` FROM `med_inventory`";

            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql:///psystem", "root", "");
                com.mysql.jdbc.PreparedStatement stm = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement(sql);
                ResultSet rs = stm.executeQuery();

                while (rs.next()) {
                    String column1Value = rs.getString("MED_ID");
                    String column2Value = rs.getString("MED_NAME");
                    String column3Value = rs.getString("MED_DOSAGE");
                    String column4Value = rs.getString("MED_TYPE");
                    String column5Value = rs.getString("MED_MANUFACTURER");
                    String column6Value = rs.getString("MED_EXPIRY");
                    String column7Value = rs.getString("MED_LOCATION");
                    String column8Value = rs.getString("MED_QUANTITY");
                    String column9Value = rs.getString("MED_PRICE");
                    String column10Value = rs.getString("MED_STATUS");
                    model.addRow(new Object[]{column1Value, column2Value, column3Value, column4Value, column5Value, column6Value, column7Value, column8Value, column9Value, column10Value});
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
            model.addColumn("Name");
            model.addColumn("Dosage");
            model.addColumn("Type");
            model.addColumn("Classification");
            model.addColumn("Manufacturer");
            model.addColumn("Expiry Date");
            model.addColumn("Location");
            model.addColumn("Quantity");
            model.addColumn("Price");
            model.addColumn("Status");
            

           String sql = "SELECT * FROM `med_inventory` where MED_NAME LIKE ?";

            try{
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql:///psystem","root","");
                stm = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement(sql);
                  String searchTerm = "%" + search.getText() + "%";
            stm.setString(1, searchTerm);   
             
                rs = stm.executeQuery();
                boolean itemExists = false;

                while(rs.next()){
                    String column1Value = rs.getString("MED_ID");
                    String column2Value = rs.getString("MED_NAME");
                    String column3Value = rs.getString("MED_DOSAGE");
                    String column4Value = rs.getString("MED_TYPE");
                     String column4aValue = rs.getString("MED_CLASSIFICATION");
                    String column5Value = rs.getString("MED_MANUFACTURER");
                    String column6Value = rs.getString("MED_EXPIRY");
                    String column7Value = rs.getString("MED_LOCATION");
                    String column8Value = rs.getString("MED_QUANTITY");
                    String column9Value = rs.getString("MED_PRICE");
                     String column10Value = rs.getString("MED_STATUS");
                    model.addRow(new Object[]{column1Value, column2Value, column3Value, column4Value, column4aValue, column5Value, column6Value, column7Value, column8Value, column9Value, column10Value});
                    itemExists = true;

                }
                if (!itemExists) {
                    JOptionPane.showMessageDialog(null, "The item does not exist.");
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

    if (numColumns >= 10) {
        String col1 = model.getValueAt(selectedRowIndex, 0).toString();
        String col2 = model.getValueAt(selectedRowIndex, 1).toString();
        String col3 = model.getValueAt(selectedRowIndex, 2).toString();
        String col4 = model.getValueAt(selectedRowIndex, 3).toString();
        String col5 = model.getValueAt(selectedRowIndex, 4).toString();
        String col6 = model.getValueAt(selectedRowIndex, 5).toString();
        String col7 = model.getValueAt(selectedRowIndex, 6).toString();
        String col8 = model.getValueAt(selectedRowIndex, 7).toString();
        String col9 = model.getValueAt(selectedRowIndex, 8).toString();
        String col10 = model.getValueAt(selectedRowIndex, 9).toString();
        String col11 = model.getValueAt(selectedRowIndex, 10).toString();

        mid.setText(col1);
        pname.setText(col2);
        pdosage.setText(col3);
        ptype.setText(col4);

        // Create and populate the classification combo box
        JComboBox<String> classifComboBox = new JComboBox<>();
        classifComboBox.addItem(col5);
        classifComboBox.addItem("");
        classifComboBox.addItem("Capsule");
        classifComboBox.addItem("Tablet");
        classifComboBox.addItem("Syrup");
        classifComboBox.addItem("Others");
        classif.setModel(classifComboBox.getModel());

        pmanu.setText(col6);
        pexpiry.setText(col7);
        plocation.setText(col8);
        pquan.setText(col9);
        pprice.setText(col10);

        // Create and populate the mstatus combo box
        JComboBox<String> mstatComboBox = new JComboBox<>();
        mstatComboBox.addItem(col11);
        mstatComboBox.addItem("");
        mstatComboBox.addItem("Available");
        mstatComboBox.addItem("Unavailable");
        mstat.setModel(mstatComboBox.getModel());

        // ... Continue setting values to other fields

    } else {
        System.out.println("The table does not have enough columns.");
    }
} else {
    System.out.println("No cell is selected");
}




        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        // TODO add your handling code here:
         try {
            this.setMaximum(true);
        } catch (java.beans.PropertyVetoException ex) {
        
            System.err.println("Error maximizing internal frame: " + ex.getMessage());
        }
        
    }//GEN-LAST:event_formInternalFrameOpened

    private void jInternalFrame1InternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_jInternalFrame1InternalFrameOpened
         try {
            this.setMaximum(true);
        } catch (java.beans.PropertyVetoException ex) {
        
            System.err.println("Error maximizing internal frame: " + ex.getMessage());
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jInternalFrame1InternalFrameOpened

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
Timer timer = new Timer(1000 , e -> updateTableData());
        
        try {
    Connection conn;
    int rowsAffected;
    PreparedStatement stm;

    Class.forName("com.mysql.jdbc.Driver");
    conn = DriverManager.getConnection("jdbc:mysql:///psystem", "root", "");

    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    
        String name = pname.getText();
        String dos = pdosage.getText();
        String type = ptype.getText();
        String classi = (String) classif.getSelectedItem();
        String manu = pmanu.getText();
        
        String loc = plocation.getText();
        String quan = pquan.getText();
        String price = pprice.getText();
        String status = (String) mstat.getSelectedItem();
        String id = mid.getText();

        String updateQuery = "UPDATE med_inventory SET MED_NAME = ?, MED_DOSAGE = ?, MED_TYPE = ?,MED_CLASSIFICATION = ?, MED_MANUFACTURER = ?, MED_EXPIRY = ?, MED_LOCATION = ?, MED_QUANTITY = ?, MED_PRICE = ?, MED_STATUS = ? WHERE MED_ID = ?";
        stm = conn.prepareStatement(updateQuery);

        stm.setString(1, name);
        stm.setString(2, dos);
        stm.setString(3, type);
        stm.setString(4, classi);
        stm.setString(5, manu);
        stm.setString(6, pexpiry.getText());
        stm.setString(7, loc);
        stm.setString(8, quan);
        stm.setString(9, price);
        stm.setString(10, status);
        stm.setString(11, id);
        
        
        rowsAffected = stm.executeUpdate();

        if (rowsAffected > 0) {
            
             String getLastLoggedInUser = "SELECT * FROM log_in_history WHERE LOG_ID = (SELECT MAX(LOG_ID) FROM log_in_history)";
        String getUserInfo = "SELECT * FROM pharmacists_inf WHERE PHAR_ID = ?";
        String insertActivity = "INSERT INTO activity_history (PHAR_ID, PHAR_USERNAME, PHAR_NAME, PHAR_POS, ACT_ACTION, ACT_DATE, ACT_TIME) VALUES (?,?,?,?,?,?,?)";
       

        try {
            
            
            
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql:///psystem", "root", "");
           

            
                String userId = PID.getText();

                stm = conn.prepareStatement(getUserInfo);
                stm.setString(1, userId);
                ResultSet rs = stm.executeQuery();

                if (rs.next()) {
                    String username = rs.getString("PHAR_USERNAME");
                    String fullName = rs.getString("PHAR_FNAME") + " " + rs.getString("PHAR_LNAME");
                    String position = rs.getString("PHAR_POS");

                    stm = conn.prepareStatement(insertActivity);
                    stm.setString(1, userId);
                    stm.setString(2, username);
                    stm.setString(3, fullName);
                    stm.setString(4, position);
                    stm.setString(5, "Updated an item in inventory");
                    stm.setDate(6, java.sql.Date.valueOf(LocalDate.now()));
                    stm.setTime(7, java.sql.Time.valueOf(LocalTime.now()));
                    

                    int rowsInserted1 = stm.executeUpdate();

                    

                        
           
               
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } 
        catch (ClassNotFoundException ex) { 
             Logger.getLogger(PH_SELLER.class.getName()).log(Level.SEVERE, null, ex);
         } 

            timer.start();

            JOptionPane.showMessageDialog(null, "Item updated successfully.");

         
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
            JOptionPane.showMessageDialog(null, "Item update failed.");
        }

        stm.close();
   

    conn.close();
} catch (Exception e) {
    JOptionPane.showMessageDialog(null, e);
} finally {
    
    if (timer != null && timer.isRunning()) {
        timer.stop();
    }
}
    }//GEN-LAST:event_jButton4ActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField PID;
    private javax.swing.JComboBox<String> classif;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JTextField mid;
    private javax.swing.JComboBox<String> mstat;
    private javax.swing.JTextField pdosage;
    private javax.swing.JTextField pexpiry;
    private javax.swing.JTextField plocation;
    private javax.swing.JTextField pmanu;
    private javax.swing.JTextField pname;
    private javax.swing.JTextField pprice;
    private javax.swing.JTextField pquan;
    private javax.swing.JTextField ptype;
    private javax.swing.JTextField search;
    // End of variables declaration//GEN-END:variables
}
