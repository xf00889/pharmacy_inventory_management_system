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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Mariz
 */
public class AD_SALES extends javax.swing.JInternalFrame {

    /**
     * Creates new form AD_ALL_MED
     */
    public AD_SALES() {
        initComponents();
        updateTableData();
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
//   DefaultTableModel model1 = (DefaultTableModel) jTable1.getModel();
//model1.setRowCount(0);
//
//String sql1 = "SELECT TRANS_ID, TRANS_DATE, SUM(TOTAL_PRICE) AS total_sum FROM trans_history GROUP BY TRANS_ID";
//String sql2 = "SELECT SUM(QUANTITY) AS total_quan FROM med_purchased WHERE TRANS_ID = ?";
//
//try {
//    Class.forName("com.mysql.jdbc.Driver");
//    Connection conn = DriverManager.getConnection("jdbc:mysql:///psystem", "root", "");
//    PreparedStatement stm1 = conn.prepareStatement(sql1);
//    ResultSet rs1 = stm1.executeQuery();
//
//    while (rs1.next()) {
//        String transID = rs1.getString("TRANS_ID");
//        String transDate = rs1.getString("TRANS_DATE");
//        String totalSum = rs1.getString("total_sum");
//
//        PreparedStatement stm2 = conn.prepareStatement(sql2);
//        stm2.setString(1, transID);
//        ResultSet rs2 = stm2.executeQuery();
//
//        if (rs2.next()) {
//            String totalQuantity = rs2.getString("total_quan");
//
//            // Check if the transDate is already present in the jTable1
//            boolean isPresent = false;
//            for (int i = 0; i < model1.getRowCount(); i++) {
//                String existingTransDate = model1.getValueAt(i, 0).toString();
//                if (existingTransDate.equals(transDate)) {
//                    isPresent = true;
//                    int existingTotalQuantity = Integer.parseInt(model1.getValueAt(i, 1).toString());
//                    int existingTotalSum = Integer.parseInt(model1.getValueAt(i, 2).toString());
//                    int newTotalQuantity = existingTotalQuantity + Integer.parseInt(totalQuantity);
//                    int newTotalSum = existingTotalSum + Integer.parseInt(totalSum);
//                    model1.setValueAt(newTotalQuantity, i, 1);
//                    model1.setValueAt(newTotalSum, i, 2);
//                    break;
//                }
//            }
//
//            // If the transDate is not present, add a new row to jTable1
//            if (!isPresent) {
//                model1.addRow(new Object[]{transDate, totalQuantity, totalSum});
//            }
//        }
//
//        rs2.close();
//        stm2.close();
//    }
//
//    rs1.close();
//    stm1.close();
//    conn.close();
//} catch (Exception e) {
//    JOptionPane.showMessageDialog(null, e);
//}
//
//DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//
//// Populate the dataset with sales data from jTable1
//for (int i = 0; i < model1.getRowCount(); i++) {
//    String transDate = model1.getValueAt(i, 0).toString();
//    int totalQuantity = Integer.parseInt(model1.getValueAt(i, 1).toString());
//    int totalSum = Integer.parseInt(model1.getValueAt(i, 2).toString());
//
//    // Add the sales data to the dataset
//    dataset.addValue(totalQuantity, "Total Quantity", transDate);
//    dataset.addValue(totalSum, "Total Sum", transDate);
//}
//
//// Create the chart using the dataset
//JFreeChart chart = ChartFactory.createLineChart("Sales Report", "Date", "Value", dataset);
//
//// Create a ChartPanel to hold the chart
//ChartPanel chartPanel = new ChartPanel(chart);
//
//// Set the size of the chartPanel
//chartPanel.setPreferredSize(new java.awt.Dimension(400, 800));
//
//// Add the chartPanel to jPanel1 (assumes you have a jPanel1 already)
//jPanel5.setLayout(new java.awt.BorderLayout());
//jPanel5.add(chartPanel, java.awt.BorderLayout.CENTER);
//
//// Repaint the jPanel1 to reflect the changes
//jPanel5.revalidate();
//jPanel5.repaint();



DefaultTableModel model2 = (DefaultTableModel) jTable2.getModel();
model2.setRowCount(0);

String sql3 = "SELECT MIN(TRANS_DATE) AS start_date, MAX(TRANS_DATE) AS end_date, SUM(TOTAL_PRICE) AS total_sum FROM trans_history GROUP BY YEARWEEK(TRANS_DATE) ORDER BY start_date";
String sql4 = "SELECT SUM(QUANTITY) AS total_quan FROM med_purchased WHERE TRANS_ID IN (SELECT TRANS_ID FROM trans_history WHERE YEARWEEK(TRANS_DATE) = YEARWEEK(?))";

try {
    Class.forName("com.mysql.jdbc.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mysql:///psystem", "root", "");
    PreparedStatement stm1 = conn.prepareStatement(sql3);
    ResultSet rs1 = stm1.executeQuery();

    while (rs1.next()) {
        String startDate = rs1.getString("start_date");
        String endDate = rs1.getString("end_date");
        String totalSum = rs1.getString("total_sum");

        PreparedStatement stm2 = conn.prepareStatement(sql4);
        stm2.setString(1, startDate);
        ResultSet rs2 = stm2.executeQuery();

        if (rs2.next()) {
            String totalQuantity = rs2.getString("total_quan");

            // Check if the date range is already present in the jTable2
            boolean isPresent = false;
            for (int i = 0; i < model2.getRowCount(); i++) {
                String existingStartDate = model2.getValueAt(i, 0).toString();
                String existingEndDate = model2.getValueAt(i, 1).toString();
                if (existingStartDate.equals(startDate) && existingEndDate.equals(endDate)) {
                    isPresent = true;
                    int existingTotalQuantity = Integer.parseInt(model2.getValueAt(i, 2).toString());
                    int existingTotalSum = Integer.parseInt(model2.getValueAt(i, 3).toString());
                    int newTotalQuantity = existingTotalQuantity + Integer.parseInt(totalQuantity);
                    int newTotalSum = existingTotalSum + Integer.parseInt(totalSum);
                    model2.setValueAt(newTotalQuantity, i, 2);
                    model2.setValueAt(newTotalSum, i, 3);
                    break;
                }
            }

            // If the date range is not present, add a new row to jTable2
            if (!isPresent) {
                model2.addRow(new Object[]{startDate +" up to "+endDate, totalQuantity, totalSum});
            }
        }

        rs2.close();
        stm2.close();
    }

    rs1.close();
    stm1.close();
    conn.close();
} catch (Exception e) {
    JOptionPane.showMessageDialog(null, e);
}

DefaultCategoryDataset dataset2 = new DefaultCategoryDataset();

// Populate the dataset with sales data from jTable2
for (int i = 0; i < model2.getRowCount(); i++) {
    String dateRange = model2.getValueAt(i, 0).toString();
    int totalQuantity = Integer.parseInt(model2.getValueAt(i, 1).toString());
    int totalSum = Integer.parseInt(model2.getValueAt(i, 2).toString());

    // Add the sales data to the dataset
    dataset2.addValue(totalQuantity, "Total Quantity", dateRange);
    dataset2.addValue(totalSum, "Total Sum", dateRange);
}

// Create the chart using the dataset
JFreeChart chart2 = ChartFactory.createLineChart("Sales Report", "Date Range", "Value", dataset2);

// Create a ChartPanel to hold the chart
ChartPanel chartPanel2 = new ChartPanel(chart2);

// Set the size of the chartPanel
chartPanel2.setPreferredSize(new java.awt.Dimension(800, 330));

// Add the chartPanel to jPanel6 (assumes you have a jPanel6 already)
jPanel6.setLayout(new java.awt.BorderLayout());
jPanel6.add(chartPanel2, java.awt.BorderLayout.CENTER);

// Repaint the jPanel6 to reflect the changes
jPanel6.revalidate();
jPanel6.repaint();


DefaultTableModel model3 = (DefaultTableModel) jTable3.getModel();
model3.setRowCount(0);

String sql5 = "SELECT MIN(TRANS_DATE) AS start_date, MAX(TRANS_DATE) AS end_date, DATE_FORMAT(TRANS_DATE, '%Y-%m') AS month, SUM(TOTAL_PRICE) AS total_sum FROM trans_history GROUP BY month";
String sql6 = "SELECT SUM(QUANTITY) AS total_quan FROM med_purchased WHERE TRANS_ID IN (SELECT TRANS_ID FROM trans_history WHERE DATE_FORMAT(TRANS_DATE, '%Y-%m') = ?)";

try {
    Class.forName("com.mysql.jdbc.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mysql:///psystem", "root", "");
    PreparedStatement stm1 = conn.prepareStatement(sql5);
    ResultSet rs1 = stm1.executeQuery();

    while (rs1.next()) {
        String startDate = rs1.getString("start_date");
        String endDate = rs1.getString("end_date");
        String month = rs1.getString("month");
        String totalSum = rs1.getString("total_sum");

        PreparedStatement stm2 = conn.prepareStatement(sql6);
        stm2.setString(1, month);
        ResultSet rs2 = stm2.executeQuery();

        if (rs2.next()) {
            String totalQuantity = rs2.getString("total_quan");

            model3.addRow(new Object[]{month, totalQuantity, totalSum});
        }

        rs2.close();
        stm2.close();
    }

    rs1.close();
    stm1.close();
    conn.close();
} catch (Exception e) {
    JOptionPane.showMessageDialog(null, e);
}

DefaultCategoryDataset dataset3 = new DefaultCategoryDataset();

// Populate the dataset with sales data from jTable3
for (int i = 0; i < model3.getRowCount(); i++) {
    String month = model3.getValueAt(i, 0).toString();
    int totalQuantity = Integer.parseInt(model3.getValueAt(i, 1).toString());
    int totalSum = Integer.parseInt(model3.getValueAt(i, 2).toString());

    // Add the sales data to the dataset
    dataset3.addValue(totalQuantity, "Total Quantity", month);
    dataset3.addValue(totalSum, "Total Sum", month);
}

// Create the chart using the dataset
JFreeChart chart3 = ChartFactory.createLineChart("Monthly Sales Report", "Month", "Value", dataset3);

// Create a ChartPanel to hold the chart
ChartPanel chartPanel3 = new ChartPanel(chart3);

// Set the size of the chartPanel
chartPanel3.setPreferredSize(new java.awt.Dimension(800, 330));

// Add the chartPanel to jPanel1 (assumes you have a jPanel1 already)
jPanel7.setLayout(new java.awt.BorderLayout());
jPanel7.add(chartPanel3, java.awt.BorderLayout.CENTER);

// Repaint the jPanel1 to reflect the changes
jPanel7.revalidate();
jPanel7.repaint();

DefaultTableModel model4 = (DefaultTableModel) jTable4.getModel();
model4.setRowCount(0);

String sql7 = "SELECT YEAR(TRANS_DATE) AS year, MIN(TRANS_DATE) AS start_date, MAX(TRANS_DATE) AS end_date, SUM(TOTAL_PRICE) AS total_sum FROM trans_history GROUP BY year";
String sql8 = "SELECT SUM(QUANTITY) AS total_quan FROM med_purchased WHERE TRANS_ID IN (SELECT TRANS_ID FROM trans_history WHERE YEAR(TRANS_DATE) = ?)";

try {
    Class.forName("com.mysql.jdbc.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mysql:///psystem", "root", "");
    PreparedStatement stm1 = conn.prepareStatement(sql7);
    ResultSet rs1 = stm1.executeQuery();

    while (rs1.next()) {
        String year = rs1.getString("year");
        String startDate = rs1.getString("start_date");
        String endDate = rs1.getString("end_date");
        String totalSum = rs1.getString("total_sum");

        PreparedStatement stm2 = conn.prepareStatement(sql8);
        stm2.setString(1, year);
        ResultSet rs2 = stm2.executeQuery();

        if (rs2.next()) {
            String totalQuantity = rs2.getString("total_quan");

            model4.addRow(new Object[]{year, totalQuantity, totalSum});
        }

        rs2.close();
        stm2.close();
    }

    rs1.close();
    stm1.close();
    conn.close();
} catch (Exception e) {
    JOptionPane.showMessageDialog(null, e);
}

DefaultCategoryDataset dataset4 = new DefaultCategoryDataset();

// Populate the dataset with sales data from jTable4
for (int i = 0; i < model4.getRowCount(); i++) {
    String year = model4.getValueAt(i, 0).toString();
    int totalQuantity = Integer.parseInt(model4.getValueAt(i, 1).toString());
    int totalSum = Integer.parseInt(model4.getValueAt(i, 2).toString());

    // Add the sales data to the dataset
    dataset4.addValue(totalQuantity, "Total Quantity", year);
    dataset4.addValue(totalSum, "Total Sum", year);
}

// Create the chart using the dataset
JFreeChart chart4 = ChartFactory.createLineChart("Yearly Sales Report", "Year", "Value", dataset4, PlotOrientation.VERTICAL, true, true, false);

// Create a ChartPanel to hold the chart
ChartPanel chartPanel4 = new ChartPanel(chart4);

// Set the size of the chartPanel
chartPanel4.setPreferredSize(new java.awt.Dimension(800, 330));

// Add the chartPanel to jPanel5 (assumes you have a jPanel5 already)
jPanel5.setLayout(new java.awt.BorderLayout());
jPanel5.add(chartPanel4, java.awt.BorderLayout.CENTER);

// Repaint the jPanel5 to reflect the changes
jPanel5.revalidate();
jPanel5.repaint();


     JTableHeader header1 = jTable2.getTableHeader();
    header1.setDefaultRenderer(new AD_SALES.CustomHeaderRenderer());
    String[] headerTitles1 = {"Date","Items Sold", "Sales"};
    for (int i = 0; i < headerTitles1.length; i++) {
        header1.getColumnModel().getColumn(i).setHeaderValue(headerTitles1[i]);
    }
    JTableHeader header2 = jTable3.getTableHeader();
    header2.setDefaultRenderer(new AD_SALES.CustomHeaderRenderer());
    String[] headerTitles2 = {"Date","Items Sold", "Sales"};
    for (int i = 0; i < headerTitles2.length; i++) {
        header2.getColumnModel().getColumn(i).setHeaderValue(headerTitles2[i]);
    }
    
    JTableHeader header3 = jTable4.getTableHeader();
    header3.setDefaultRenderer(new AD_SALES.CustomHeaderRenderer());
    String[] headerTitles3 = {"Date","Items Sold", "Sales"};
    for (int i = 0; i < headerTitles3.length; i++) {
        header3.getColumnModel().getColumn(i).setHeaderValue(headerTitles3[i]);
    }
//     JTableHeader header2 = jTable2.getTableHeader();
//    header2.setDefaultRenderer(new AD_SALES.CustomHeaderRenderer());
//    String[] headerTitles2 = {"Product ID", "Product Name", "Dosage", "Type", "Classification","Manufacturer", "Expiry", "Location", "Quantity", "Price", "Status"};
//    for (int i = 0; i < headerTitles1.length; i++) {
//        header2.getColumnModel().getColumn(i).setHeaderValue(headerTitles2[i]);
//    }
//     JTableHeader header3 = jTable3.getTableHeader();
//    header3.setDefaultRenderer(new AD_SALES.CustomHeaderRenderer());
//    String[] headerTitles3 = {"Product ID", "Product Name", "Dosage", "Type", "Classification","Manufacturer", "Expiry", "Location", "Quantity", "Price", "Status"};
//    for (int i = 0; i < headerTitles1.length; i++) {
//        header3.getColumnModel().getColumn(i).setHeaderValue(headerTitles3[i]);
//    }
//     JTableHeader header4 = jTable4.getTableHeader();
//    header4.setDefaultRenderer(new AD_SALES.CustomHeaderRenderer());
//    String[] headerTitles4 = {"Product ID", "Product Name", "Dosage", "Type", "Classification","Manufacturer", "Expiry", "Location", "Quantity", "Price", "Status"};
//    for (int i = 0; i < headerTitles1.length; i++) {
//        header4.getColumnModel().getColumn(i).setHeaderValue(headerTitles4[i]);
//    }
    
    
    
    // Adjust the table column widths
    jTable2.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
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
        jPanel4 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();

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

        jTable2.setBackground(new java.awt.Color(51, 51, 51));
        jTable2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTable2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable2.setForeground(new java.awt.Color(255, 255, 255));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Date", "Items Sold", "Sales"
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

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 329, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 1157, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        jTabbedPane1.addTab("Weekly", jPanel4);

        jTable3.setBackground(new java.awt.Color(51, 51, 51));
        jTable3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTable3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable3.setForeground(new java.awt.Color(255, 255, 255));
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Date", "Items Sold", "Sales"
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

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 361, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 1157, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Monthly", jPanel3);

        jTable4.setBackground(new java.awt.Color(51, 51, 51));
        jTable4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTable4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable4.setForeground(new java.awt.Color(255, 255, 255));
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Date", "Items Sold", "Sales"
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

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 339, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 1157, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Yearly", jPanel1);

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
                .addComponent(jTabbedPane1))
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

    private void jTable4ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jTable4ComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable4ComponentShown

    private void jTable4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable4MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable4MouseEntered

    private void jTable4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable4MouseClicked

    private void jTable2ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jTable2ComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable2ComponentShown

    private void jTable2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable2MouseEntered

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable2MouseClicked

    private void jTable3ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jTable3ComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable3ComponentShown

    private void jTable3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable3MouseEntered

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable3MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    // End of variables declaration//GEN-END:variables
}
