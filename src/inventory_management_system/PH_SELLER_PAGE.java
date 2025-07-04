/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory_management_system;

import java.awt.Graphics;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


/**
 *
 * @author Mariz
 */
public class PH_SELLER_PAGE extends javax.swing.JFrame {
private boolean isLoggedIn;
private UserSession userSession;
 private Connection conn;
    private java.sql.PreparedStatement stm;
    private ResultSet rs;
    
    /**

/**
     * 
     * 
     * 
     * Creates new form PH_SELLER_PAGE
     */
    public PH_SELLER_PAGE() {
        initComponents();
        loggedin();
        updateData();
           userSession = UserSession.getInstance();
        
        java.net.URL imageURL = getClass().getResource("/icon/icons8-sell-48.png");
ImageIcon originalIcon = new ImageIcon(imageURL);
int width = 30; 
int height = 30; 
Image resizedImage = originalIcon.getImage().getScaledInstance(width, height, java.awt.Image.SCALE_DEFAULT);
jButton1.setIcon(new ImageIcon(resizedImage));

java.net.URL imageURL2 = getClass().getResource("/icon/icons8-transaction-48.png");
ImageIcon originalIcon2 = new ImageIcon(imageURL2);
int width2 = 30;
int height2 = 30; 
Image resizedImage2 = originalIcon2.getImage().getScaledInstance(width2, height2, java.awt.Image.SCALE_DEFAULT);
jButton2.setIcon(new ImageIcon(resizedImage2));

java.net.URL imageURL3 = getClass().getResource("/icon/icon-logouts.png");
ImageIcon originalIcon3 = new ImageIcon(imageURL3);
int width3 = 30;
int height3 = 30; 
Image resizedImage3 = originalIcon3.getImage().getScaledInstance(width3, height3, java.awt.Image.SCALE_DEFAULT);
jButton3.setIcon(new ImageIcon(resizedImage3));
   

 java.net.URL imageURL6 = getClass().getResource("/icon/icons8-information-50.png");
ImageIcon originalIcon6 = new ImageIcon(imageURL6);
int width6 = 30;
int height6 = 30; 
Image resizedImage6 = originalIcon6.getImage().getScaledInstance(width6, height6, java.awt.Image.SCALE_DEFAULT);
jButton4.setIcon(new ImageIcon(resizedImage6));  
    }
    
    private void updateData(){
        
        Connection connec;
        ResultSet rs;
        PreparedStatement stm;

String sqlSelect = "SELECT * FROM log_in_history WHERE LOG_ID = (SELECT MAX(LOG_ID) FROM log_in_history)";

try {
    Class.forName("com.mysql.jdbc.Driver");
    connec = DriverManager.getConnection("jdbc:mysql:///psystem", "root", "");
    stm = (PreparedStatement) connec.prepareStatement(sqlSelect);
    rs = stm.executeQuery();

    if (rs.next()) {
        // Successful login
        String pharId = rs.getString("PHAR_ID");
        
        logid.setText(pharId);
        
            
        }
        else {
        
        JOptionPane.showMessageDialog(null, "Error logging out");
    }
    
    }
    catch (Exception e) {
    JOptionPane.showMessageDialog(null, e);
}
    
    
    }
    
    public void data(String id,String name){
    
        id = logid.getText();
        name = logname.getText();
    
    
    }
    
    
    private void loggedin(){
        
        String getLastLoggedInUser = "SELECT * FROM log_in_history WHERE LOG_ID = (SELECT MAX(LOG_ID) FROM log_in_history)";
        
       

        try {
            Connection conn;
            
            
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql:///psystem", "root", "");
            stm = (PreparedStatement) conn.prepareStatement(getLastLoggedInUser);
            rs = stm.executeQuery();

            if (rs.next()) {
                String userId = rs.getString("PHAR_ID");
                String userName = rs.getString("PHAR_NAME");
                logid.setText(userId);
                logname.setText(userName);
               
                } 
            else {
                    JOptionPane.showMessageDialog(null, "Error logging In! Pls contact Administrator!");
                    dispose();
                    new PH_LOGINPAGE().setVisible(true);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } 
        catch (ClassNotFoundException ex) { 
             Logger.getLogger(PH_SELLER.class.getName()).log(Level.SEVERE, null, ex);
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

        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        logid = new javax.swing.JTextField();
        logname = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        ImageIcon icon = new ImageIcon (getClass().getResource("/icon/pharma-shelf.jpg"));
        Image img = icon.getImage();
        jDesktopPane1 = new javax.swing.JDesktopPane() {

            public void paintComponent(Graphics g) {

                g.drawImage(img, 0, 0, getWidth(),getHeight(),this);

            }

        };
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        logid.setEditable(false);

        logname.setEditable(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SELLER PAGE");
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.white, null, null));

        jButton1.setBackground(new java.awt.Color(204, 204, 204));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("SELL ITEMS");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(204, 204, 204));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setText("TRANS HISTORY");
        jButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 204, 0));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setText("LOG OUT");
        jButton3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton4.setText("PERSONAL INFO");
        jButton4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 328, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jButton1.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logoSYSTEM (2).png"))); // NOI18N
        jLabel4.setText("    ");
        jLabel4.setToolTipText("");

        jLabel5.setFont(new java.awt.Font("GungsuhChe", 0, 40)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("PHARMACY INVENTORY MANAGEMENT SYSTEM");

        jLabel7.setFont(new java.awt.Font("Narkisim", 0, 14)); // NOI18N
        jLabel7.setText("Barangay Villareal, Bayawan City, Negros Oriental, Philippines 6114");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/squares.png"))); // NOI18N
        jLabel1.setText("jLabel1");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-close-35 (1).png"))); // NOI18N
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-minimize-50 (1).png"))); // NOI18N
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 749, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(385, 385, 385)))
                        .addGap(0, 400, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                        .addGap(14, 14, 14)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDesktopPane1))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDesktopPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

  if (userSession.isLoggedIn()) {
      String pid = logid.getText();
        jDesktopPane1.removeAll();
        PH_SELLER f1 = new PH_SELLER();
        jDesktopPane1.add(f1).setVisible(true);
        f1.updateData(pid);   
    } else {
      JOptionPane.showMessageDialog(null, "Please log in to continue.");
       new PH_LOGINPAGE().setVisible(true);
       dispose();
    }
       
       
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
  if (userSession.isLoggedIn()) {
      
        jDesktopPane1.removeAll();
        TRANS_HISTORY F2 = new TRANS_HISTORY();
        jDesktopPane1.add(F2).setVisible(true);
        
    } else {
       JOptionPane.showMessageDialog(null, "Please log in to continue.");
       new PH_LOGINPAGE().setVisible(true);
       dispose();
    }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
 this.setExtendedState(JFrame.MAXIMIZED_BOTH);        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
      if (userSession.isLoggedIn()) {
       
         int confirmLogout = JOptionPane.showConfirmDialog(this, "Are you sure you want to log out?", "Logout Confirmation", JOptionPane.YES_NO_OPTION);
        if (confirmLogout == JOptionPane.YES_OPTION) {
        userSession.logout();

       
        JOptionPane.showMessageDialog(this, "You have been logged out.");
      new PH_LOGINPAGE().setVisible(true);
      dispose();

      
      
    } else if(confirmLogout==JOptionPane.NO_OPTION) {
      new PH_SELLER_PAGE().setVisible(true);
       dispose();
    }
    else{
    JOptionPane.showMessageDialog(this, "You are logged out.");
    
    }//GEN-LAST:event_jButton3ActionPerformed
  Connection connec;
        ResultSet rs;
        PreparedStatement stm;

String sqlSelect = "SELECT * FROM log_in_history WHERE LOG_ID = (SELECT MAX(LOG_ID) FROM log_in_history)";
String sqlUserAccess = "SELECT * FROM pharmacists_inf WHERE PHAR_ID=?";

try {
    Class.forName("com.mysql.jdbc.Driver");
    connec = DriverManager.getConnection("jdbc:mysql:///psystem", "root", "");
    

   
        
        String pharId = logid.getText();

        PreparedStatement accessStm = (PreparedStatement) connec.prepareStatement(sqlUserAccess);
        accessStm.setString(1, pharId);
        ResultSet accessRs = accessStm.executeQuery();

        if (accessRs.next()) {
            String userType = accessRs.getString("PHAR_POS");
            
            String sqlInsert = "INSERT INTO log_in_history (LOG_TIME, LOG_DATE, PHAR_ID, PHAR_NAME, PHAR_POS, LOG_TYPE) VALUES (?, ?, ?, ?, ?,?)";
            PreparedStatement insertStm = (PreparedStatement) connec.prepareStatement(sqlInsert);
            insertStm.setTime(1, java.sql.Time.valueOf(LocalTime.now()));
            insertStm.setDate(2, java.sql.Date.valueOf(LocalDate.now()));
            insertStm.setString(3, pharId);
            insertStm.setString(4, accessRs.getString("PHAR_FNAME")+"  "+accessRs.getString("PHAR_LNAME"));
            insertStm.setString(5, userType);
            insertStm.setString(6, "Logged Out");
            insertStm.executeUpdate();
            insertStm.close();
            accessRs.close();
            accessStm.close();

            
        }
        else {
        
        JOptionPane.showMessageDialog(null, "Error logging out");
    }
    
    }
    catch (Exception e) {
    JOptionPane.showMessageDialog(null, e);
}
    }
    }
    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
 setState(PH_SELLER_PAGE.ICONIFIED);               // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
  if (userSession.isLoggedIn()) {
      String pid = logid.getText();
      
        jDesktopPane1.removeAll();
        PH_OWN_INFO F2 = new PH_OWN_INFO();
        jDesktopPane1.add(F2).setVisible(true);
        
        F2.updateData1(pid); 
        
    } else {
       JOptionPane.showMessageDialog(null, "Please log in to continue.");
       new PH_LOGINPAGE().setVisible(true);
       dispose();
    }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed
     
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
            java.util.logging.Logger.getLogger(PH_SELLER_PAGE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PH_SELLER_PAGE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PH_SELLER_PAGE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PH_SELLER_PAGE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PH_SELLER_PAGE().setVisible(true);
            }
        });
    }
  
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JTextField logid;
    private javax.swing.JTextField logname;
    // End of variables declaration//GEN-END:variables
}
