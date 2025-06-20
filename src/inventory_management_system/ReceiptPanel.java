package inventory_management_system;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ReceiptPanel extends JPanel {
     private String transID;
    private String sellerName;
    private double totalPrice;

    public ReceiptPanel(String transID, String sellerName) {
        this.transID = transID;
        this.sellerName = sellerName;
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(500, 400));
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        JPanel titlePanel = new JPanel(new BorderLayout());
        JLabel titleLabel = new JLabel("D&J PHARMACY", JLabel.CENTER);
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 36));
        titlePanel.add(titleLabel, BorderLayout.NORTH);
        titlePanel.add(new JLabel("Receipt #" + transID, JLabel.CENTER), BorderLayout.SOUTH);
        add(titlePanel, BorderLayout.NORTH);
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql:///psystem", "root", "");
            PreparedStatement pstmt = conn.prepareStatement("SELECT MED_NAME, QUANTITY, MED_PRICE FROM med_purchased WHERE TRANS_ID = ?");
            pstmt.setString(1, transID);
            ResultSet rs = pstmt.executeQuery();
            JPanel itemsPanel = new JPanel(new GridLayout(0, 4));
            JLabel productNameLabel = new JLabel("Product Name", JLabel.CENTER);
            productNameLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
            itemsPanel.add(productNameLabel);
            JLabel quantityLabel = new JLabel("Quantity", JLabel.CENTER);
            quantityLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
            itemsPanel.add(quantityLabel);
            JLabel pricePerUnitLabel = new JLabel("Price Per Unit", JLabel.CENTER);
            pricePerUnitLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
            itemsPanel.add(pricePerUnitLabel);
            JLabel totalPriceLabel = new JLabel("Total Price", JLabel.CENTER);
            totalPriceLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
            itemsPanel.add(totalPriceLabel);
            while (rs.next()) {
                String medName = rs.getString("MED_NAME");
                int quantity = rs.getInt("QUANTITY");
                double price = rs.getDouble("MED_PRICE");
                double totalPricePerItem = quantity * price;
                itemsPanel.add(new JLabel(medName, JLabel.CENTER));
                itemsPanel.add(new JLabel(String.valueOf(quantity), JLabel.CENTER));
                itemsPanel.add(new JLabel(String.valueOf(price), JLabel.CENTER));
                itemsPanel.add(new JLabel(String.valueOf(totalPricePerItem), JLabel.CENTER));
                totalPrice += totalPricePerItem;
            }
            add(itemsPanel, BorderLayout.CENTER);
            JPanel infoPanel = new JPanel(new GridLayout(0, 2));
            infoPanel.add(new JLabel("Seller Name:", JLabel.CENTER));
            infoPanel.add(new JLabel(sellerName, JLabel.CENTER));
            infoPanel.add(new JLabel("Total Price:", JLabel.CENTER));
            infoPanel.add(new JLabel(String.valueOf(totalPrice), JLabel.CENTER));
            add(infoPanel, BorderLayout.SOUTH);

            JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            JButton printButton = new JButton("Print");
            printButton.setPreferredSize(new Dimension(120, 40));
            printButton.setFont(new Font("Tahoma", Font.BOLD, 16));
            printButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    printReceipt();
                }
            });
            buttonPanel.add(printButton);
            add(buttonPanel, BorderLayout.SOUTH);

            conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    private void printReceipt() {
        PrinterJob printerJob = PrinterJob.getPrinterJob();
        printerJob.setPrintable(new ReceiptPrintable(this));
        if (printerJob.printDialog()) {
            try {
                printerJob.print();
            } catch (PrinterException ex) {
                JOptionPane.showMessageDialog(this, "Error printing: " + ex.getMessage());
            }
        }
    }

    private class ReceiptPrintable implements java.awt.print.Printable {
        private JPanel panelToPrint;

        public ReceiptPrintable(JPanel panelToPrint) {
            this.panelToPrint = panelToPrint;
        }

        @Override
        public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
            if (pageIndex > 0) {
                return NO_SUCH_PAGE;
            }

            Graphics2D g2d = (Graphics2D) graphics;
            g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

            panelToPrint.printAll(graphics);

            return PAGE_EXISTS;
        }
    }
}
