/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory_management_system;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.RowFilter;
import javax.swing.Timer;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;

// Add an event listener to the JTable to track selection changes


/**
 *
 * @author Mariz
 */

public class PH_SELLER extends javax.swing.JInternalFrame {
    
    
    
     private Connection conn;
    private PreparedStatement stm;
    private ResultSet rs;
    /**
     * Creates new form PH_SELLER
     */
    public PH_SELLER() {
      
        initComponents();
    updateTableData();
    
     Timer timer = new Timer(10000 , e -> updateTableData());
         timer.start(); 
              setupButtonShortcuts();
    
            }  
    

    
    
    

    public void updateData(String pid){
        PID.setText(pid);
        
    }

    
    
// Method to calculate and update the total price

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


public void updateTableData() {
    
  
        
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    model.setRowCount(0); 
    
    
    String sql = "SELECT * FROM med_inventory WHERE MED_STATUS = 'Available'";

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
            model.addRow(new Object[]{column1Value, column2Value, column3Value, column4Value, column5Value, column6Value, column7Value, column8Value, column9Value});
        }

        rs.close();
        stm.close();
        conn.close();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }
    
     JTableHeader header1 = jTable1.getTableHeader();
    header1.setDefaultRenderer(new CustomHeaderRenderer());
    String[] headerTitles1 = {"ID", "Name", "Dosage", "Type", "Manufacturer", "Expiry", "Location", "Quantity", "Price"};
    for (int i = 0; i < headerTitles1.length; i++) {
        header1.getColumnModel().getColumn(i).setHeaderValue(headerTitles1[i]);
    }
    
    JTableHeader header2 = jTable2.getTableHeader();
    header2.setDefaultRenderer(new CustomHeaderRenderer());
    String[] headerTitles2 = {"ID" ,"Quantity", "Price"};
    for (int i = 0; i < headerTitles2.length; i++) {
        header2.getColumnModel().getColumn(i).setHeaderValue(headerTitles2[i]);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        PID = new javax.swing.JTextField();
        change = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        pprice = new javax.swing.JTextField();
        pquan = new javax.swing.JTextField();
        pname = new javax.swing.JTextField();
        pid = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        tp = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        cash = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        search = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton8 = new javax.swing.JButton();

        change.setEditable(false);

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setClosable(true);
        setIconifiable(true);
        setTitle("Sell items");
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

        jPanel5.setBackground(new java.awt.Color(0, 0, 0));
        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Product ID:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Product Name:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Price:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Quantity:");

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton5.setText("Select Item");
        jButton5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        pprice.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        pquan.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        pquan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pquanActionPerformed(evt);
            }
        });

        pname.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        pname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pnameActionPerformed(evt);
            }
        });

        pid.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pid)
                    .addComponent(pquan, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pname)
                    .addComponent(pprice, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(pid, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pquan, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(pname, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(pprice, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        jPanel4.setBackground(new java.awt.Color(204, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTable2.setBackground(new java.awt.Color(0, 0, 0));
        jTable2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTable2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTable2.setForeground(new java.awt.Color(255, 255, 255));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product ID", "Quantity", "Price"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jTable2);

        tp.setEditable(false);
        tp.setFont(new java.awt.Font("Tahoma", 1, 40)); // NOI18N
        tp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tpActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setText("Buy");
        jButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton2KeyPressed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("Clear");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setMnemonic('R');
        jButton3.setText("Remove");
        jButton3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        cash.setFont(new java.awt.Font("Tahoma", 1, 40)); // NOI18N
        cash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cashActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setText("Total:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setText("Cash:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(cash, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(tp, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(tp, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(cash, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Search Items:");

        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        jTable1.setBackground(new java.awt.Color(51, 51, 51));
        jTable1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTable1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Dosage", "Type", "Manufacturer", "EXP-D", "Location", "Quantity", "Price"
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
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 836, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
////    
    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
//   try {
//            this.setMaximum(true);
//        } catch (java.beans.PropertyVetoException ex) {
//        
//            System.err.println("Error maximizing internal frame: " + ex.getMessage());
//        }
    
        // TODO add your handling code here:
    }//GEN-LAST:event_formInternalFrameOpened

    private void pnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pnameActionPerformed

    private void pquanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pquanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pquanActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
//try {
//    DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
//    int rowCount = model.getRowCount();
//
//    for (int i = rowCount - 1; i >= 0; i--) {
//        Object value1 = model.getValueAt(i, 0);
//        int value2 = Integer.parseInt(model.getValueAt(i, 1).toString());
//        int value3 = Integer.parseInt(model.getValueAt(i, 2).toString());
//
//        // Check if the current row's value in column 1 is the same as the next row
//        if (i + 1 < rowCount && value1.equals(model.getValueAt(i + 1, 0))) {
//            int nextValue2 = Integer.parseInt(model.getValueAt(i + 1, 1).toString());
//            int nextValue3 = Integer.parseInt(model.getValueAt(i + 1, 2).toString());
//
//            // Add the values together
//            int sum2 = value2 + nextValue2;
//            int sum3 = value3 + nextValue3;
//
//            // Update the combined sum in the second column
//            model.setValueAt(sum2, i, 1);
//
//            // Update the combined sum in the third column
//            model.setValueAt(sum3, i, 2);
//
//            // Remove the next row
//            model.removeRow(i + 1);
//            rowCount--;
//        }
//    }
//} catch (NumberFormatException e) {
//    JOptionPane.showMessageDialog(null, "Invalid numeric value in the table");
//} catch (ArrayIndexOutOfBoundsException e) {
//    JOptionPane.showMessageDialog(null, "Table index out of bounds");
//}
//
//try {
//    DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
//
//    double total = 0.0;
//
//    for (int i = 0; i < model.getRowCount(); i++) {
//        double value = Double.parseDouble(model.getValueAt(i, 2).toString());
//        total += value;
//    }
//
//    tp.setText(String.valueOf(total));
//} catch (NumberFormatException e) {
//    JOptionPane.showMessageDialog(null, "Invalid numeric value in the table");
//} catch (ArrayIndexOutOfBoundsException e) {
//    JOptionPane.showMessageDialog(null, "Table index out of bounds");
//}

 try {
        Connection conn;
        ResultSet rs;
        PreparedStatement stm;

        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql:///psystem", "root", "");

        String sql = "SELECT MED_QUANTITY FROM med_inventory WHERE MED_ID = ?";
        stm = conn.prepareStatement(sql);
        stm.setString(1, pid.getText());
        rs = stm.executeQuery();

        int availableQuantity = 0;
        if (rs.next()) {
            availableQuantity = rs.getInt("MED_QUANTITY");
        }

        int requestedQuantity = Integer.parseInt(pquan.getText());

        String quan = pquan.getText();
        int quan1 = Integer.parseInt(quan);

        if (requestedQuantity <= availableQuantity) {
            int price = Integer.parseInt(pprice.getText());
            int totalp = requestedQuantity * price;
            String totalprice = String.valueOf(totalp);
            String id = pid.getText();

            DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
            model.addRow(new Object[]{id, requestedQuantity, totalprice});
        } else if (requestedQuantity != availableQuantity && requestedQuantity < availableQuantity) {
            JOptionPane.showMessageDialog(null, "Invalid Quantity");
        } else {
            JOptionPane.showMessageDialog(null, "Insufficient medicine in inventory");
        }
    } catch (HeadlessException | ClassNotFoundException | NumberFormatException | SQLException e) {
        JOptionPane.showMessageDialog(null, "Please select quantity.");
    }

    try {
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();

        int columnIndex = 2;

        double total = 0.0;

        for (int i = 0; i < model.getRowCount(); i++) {
            Object value = model.getValueAt(i, columnIndex);
            if (value != null) {
                double numericValue = Double.parseDouble(value.toString());
                total += numericValue;
            }
        }
        tp.setText(String.valueOf(total));

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }

    JTableHeader header = jTable2.getTableHeader();
    header.setDefaultRenderer(new CustomHeaderRenderer());
    jTable2.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

    try {
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        int rowCount = model.getRowCount();

        for (int i = rowCount - 1; i >= 0; i--) {
            Object value1 = model.getValueAt(i, 0);
            int value2 = (int) model.getValueAt(i, 1);
            String value3Str = (String) model.getValueAt(i, 2);

            // Check if the current row's value in column 0, 1, and 2 is null or empty
            if (value1 == null || value2 == 0 || value3Str == null || value3Str.isEmpty()) {
                // Remove the row if any of the values are null or empty
                model.removeRow(i);
            }
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
     PH_PAYMENT ppay = new PH_PAYMENT();
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        String totalprice = tp.getText();
        String cash1 = cash.getText();
        String pId = PID.getText();
        int rowcount = model.getRowCount();
        
        if(rowcount == 0){
            JOptionPane.showMessageDialog(null, "Select Items First");
        
        }
        else if(cash1.isEmpty()){
            JOptionPane.showMessageDialog(null, "Input Cash");
        
        }
        
        else{
            
            
            
            
            double cash2 = Double.parseDouble(cash1);
        double total2 = Double.parseDouble(totalprice);

        double change1 = cash2 - total2;
        
        if(change1 < 0){
            JOptionPane.showMessageDialog(null, "Insufficient Cash");
        
        }
        else{

        String change2 = String.valueOf(change1);

        change.setText(change2);
        
            ppay.setDataToJTable1(model);
            ppay.setVisible(true);
            ppay.updateTamount(totalprice);
            ppay.cashUpdate(cash1);
            ppay.updateData(pId);
            ppay.updateChange(change2);
            
        }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tpActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchActionPerformed

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
int index = jTable1.getSelectedRow();
if (index >= 0) {
    TableModel model = jTable1.getModel();

    String col1 = model.getValueAt(index, 0).toString();
    String col2 = model.getValueAt(index, 1).toString();
    String col8 = model.getValueAt(index, 8).toString();

    pid.setText(col1);
    pname.setText(col2);
    pprice.setText(col8);
} else {
JOptionPane.showMessageDialog(null, "Please select item");
}


        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.setRowCount(0);

            int columnIndex = 100;

            double total = 0.0;

            for(int i = 0; i < model.getRowCount(); i++){

                double value = Double.parseDouble(model.getValueAt(i, columnIndex).toString());

                total += value;

            }
            tp.setText(String.valueOf(total));
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton2KeyPressed
      
    }//GEN-LAST:event_jButton2KeyPressed
    
    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable2MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
int selectedRow = jTable2.getSelectedRow();

if (selectedRow >= -1) { // Check if selectedRow is greater than or equal to 0
    model.removeRow(selectedRow);

    int rowCount = model.getRowCount();
    if (rowCount > 0) {
        int columnIndex = 2;
        // Verify that columnIndex is valid based on the structure of your table

        double total = 0.0;

        if (columnIndex >= 0 && columnIndex < model.getColumnCount()) {
            for (int i = 0; i < rowCount; i++) {
                Object value = model.getValueAt(i, columnIndex);
                if (value != null) {
                    double numericValue = Double.parseDouble(value.toString());
                    total += numericValue;
                }
            }
        }

        tp.setText(String.valueOf(total));
    } else {
        tp.setText("0.0");
    }

    if (rowCount > 0) {
        int newSelectedRow = Math.min(selectedRow, rowCount - 1);
        jTable2.setRowSelectionInterval(newSelectedRow, newSelectedRow);
    }
}

    }//GEN-LAST:event_jButton3ActionPerformed

    private void cashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cashActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cashActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
   if (search.getText().isEmpty()) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);

        String sql = "SELECT `MED_ID`, `MED_NAME`, `MED_DOSAGE`, `MED_TYPE`, `MED_MANUFACTURER`, `MED_EXPIRY`, `MED_LOCATION`, `MED_QUANTITY`, `MED_PRICE` FROM `med_inventory`";

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
                model.addRow(new Object[]{column1Value, column2Value, column3Value, column4Value, column5Value, column6Value, column7Value, column8Value, column9Value});
            }

            rs.close();
            stm.close();
            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    } else {
        Connection conn;
        ResultSet rs;
        com.mysql.jdbc.PreparedStatement stm;

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Product ID");
        model.addColumn("Product Name");
        model.addColumn("Dosage");
        model.addColumn("Type");
        model.addColumn("Manufacturer");
        model.addColumn("Expiry Date");
        model.addColumn("Location");
        model.addColumn("Quantity");
        model.addColumn("Price");

        String sql = "SELECT * FROM med_inventory WHERE MED_NAME LIKE ?";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql:///psystem", "root", "");
            stm = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement(sql);
            
            // Add the wildcard characters to the search term
            String searchTerm = "%" + search.getText() + "%";
            stm.setString(1, searchTerm);
            
            rs = stm.executeQuery();
            boolean itemExists = false;

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
                model.addRow(new Object[]{column1Value, column2Value, column3Value, column4Value, column5Value, column6Value, column7Value, column8Value, column9Value});
                itemExists = true;
            }

            if (!itemExists) {
                JOptionPane.showMessageDialog(null, "The item does not exist.");
            }
            jTable1.setModel(model);
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    }//GEN-LAST:event_jButton8ActionPerformed
 private void setupButtonShortcut(javax.swing.JButton button, int keyCode) {
    int condition = JComponent.WHEN_IN_FOCUSED_WINDOW;
    InputMap inputMap = button.getInputMap(condition);
    ActionMap actionMap = button.getActionMap();

    KeyStroke keyStroke = KeyStroke.getKeyStroke(keyCode, 0);
    inputMap.put(keyStroke, button);
    actionMap.put(button, new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Object source = e.getSource();
            if (source == jButton1) {
                // Call your clear logic here
                clearTable();
            } else if (source == jButton2) {
                // Call your buy logic here
                performBuyAction();
            } else if (source == jButton3) {
                // Call your remove logic here
                removeSelectedRowAndUpdateTotal();
            } else if (source == jButton5) {
                // Call your selectItem logic here
                selectItem();
            }
        }
    });
}

private void selectItem() {
    try {
        Connection conn;
        ResultSet rs;
        PreparedStatement stm;

        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql:///psystem", "root", "");

        String sql = "SELECT MED_QUANTITY FROM med_inventory WHERE MED_ID = ?";
        stm = conn.prepareStatement(sql);
        stm.setString(1, pid.getText());
        rs = stm.executeQuery();

        int availableQuantity = 0;
        if (rs.next()) {
            availableQuantity = rs.getInt("MED_QUANTITY");
        }

        int requestedQuantity = Integer.parseInt(pquan.getText());

        String quan = pquan.getText();
        int quan1 = Integer.parseInt(quan);

        if (requestedQuantity <= availableQuantity) {
            int price = Integer.parseInt(pprice.getText());
            int totalp = requestedQuantity * price;
            String totalprice = String.valueOf(totalp);
            String id = pid.getText();

            DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
            model.addRow(new Object[]{id, requestedQuantity, totalprice});
        } else if (requestedQuantity != availableQuantity && requestedQuantity < availableQuantity) {
            JOptionPane.showMessageDialog(null, "Invalid Quantity");
        } else {
            JOptionPane.showMessageDialog(null, "Insufficient medicine in inventory");
        }
    } catch (HeadlessException | ClassNotFoundException | NumberFormatException | SQLException e) {
        JOptionPane.showMessageDialog(null, "Please select quantity.");
    }

    try {
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();

        int columnIndex = 2;

        double total = 0.0;

        for (int i = 0; i < model.getRowCount(); i++) {
            Object value = model.getValueAt(i, columnIndex);
            if (value != null) {
                double numericValue = Double.parseDouble(value.toString());
                total += numericValue;
            }
        }
        tp.setText(String.valueOf(total));

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }

    JTableHeader header = jTable2.getTableHeader();
    header.setDefaultRenderer(new CustomHeaderRenderer());
    jTable2.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

    try {
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        int rowCount = model.getRowCount();

        for (int i = rowCount - 1; i >= 0; i--) {
            Object value1 = model.getValueAt(i, 0);
            int value2 = (int) model.getValueAt(i, 1);
            String value3Str = (String) model.getValueAt(i, 2);

            // Check if the current row's value in column 0, 1, and 2 is null or empty
            if (value1 == null || value2 == 0 || value3Str == null || value3Str.isEmpty()) {
                // Remove the row if any of the values are null or empty
                model.removeRow(i);
            }
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }
}
private void removeSelectedRowAndUpdateTotal() {
    DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
    int selectedRow = jTable2.getSelectedRow();

    if (selectedRow != -1) {
        model.removeRow(selectedRow);
    }

    double total = 0.0;

    for (int i = 0; i < model.getRowCount(); i++) {
        Object value = model.getValueAt(i, 2);
        if (value != null) {
            double numericValue = Double.parseDouble(value.toString());
            total += numericValue;
        }
    }
    tp.setText(String.valueOf(total));
}

private void clearTable() {
    DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
    model.setRowCount(0);
    tp.setText("0.0");
}

private void performBuyAction() {
           PH_PAYMENT ppay = new PH_PAYMENT();
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        String totalprice = tp.getText();
        String cash1 = cash.getText();
        String pId = PID.getText();
        int rowcount = model.getRowCount();
        
        if(rowcount == 0){
            JOptionPane.showMessageDialog(null, "Select Items First");
        
        }
        else if(cash1.isEmpty()){
            JOptionPane.showMessageDialog(null, "Input Cash");
        
        }
        
        else{
            
            
            
            
            double cash2 = Double.parseDouble(cash1);
        double total2 = Double.parseDouble(totalprice);

        double change1 = cash2 - total2;
        
        if(change1 < 0){
            JOptionPane.showMessageDialog(null, "Insufficient Cash");
        
        }
        else{

        String change2 = String.valueOf(change1);

        change.setText(change2);
        
            ppay.setDataToJTable1(model);
            ppay.setVisible(true);
            ppay.updateTamount(totalprice);
            ppay.cashUpdate(cash1);
            ppay.updateData(pId);
            ppay.updateChange(change2);
            
        }
        }
    }                                        



    private void setupButtonShortcuts() {
        // Set up shortcut key bindings for each button
        setupButtonShortcut(jButton1, KeyEvent.VK_F5);//CLEAR
        setupButtonShortcut(jButton2, KeyEvent.VK_F2);//BUY
          setupButtonShortcut(jButton3, KeyEvent.VK_F4);//REMOVE
          setupButtonShortcut(jButton5, KeyEvent.VK_F1);// select
        // ... Set up shortcuts for other buttons
    }

// Call this method to set up the button's shortcut key
// For example, in the constructor or initialization code
//setButtonShortcutKey();

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField PID;
    private javax.swing.JTextField cash;
    private javax.swing.JTextField change;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField pid;
    private javax.swing.JTextField pname;
    private javax.swing.JTextField pprice;
    private javax.swing.JTextField pquan;
    private javax.swing.JTextField search;
    private javax.swing.JTextField tp;
    // End of variables declaration//GEN-END:variables
}
