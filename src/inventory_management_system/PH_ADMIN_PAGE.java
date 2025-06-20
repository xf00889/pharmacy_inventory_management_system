/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory_management_system;

import com.mysql.jdbc.PreparedStatement;
import java.awt.Graphics;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
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
public class PH_ADMIN_PAGE extends javax.swing.JFrame {
private boolean isLoggedIn;
private UserSession userSession;
 private Connection conn;
    private PreparedStatement stm;
    private ResultSet rs;
    /**
     * Creates new form PH_SELLER_PAGE
     */
    public PH_ADMIN_PAGE() {
        initComponents();
        
        loggedin();
        userSession = UserSession.getInstance();
        updateData();
           
           
    
           
           
           
           
           
           java.net.URL imageURL3 = getClass().getResource("/icon/icon-logouts.png");
ImageIcon originalIcon3 = new ImageIcon(imageURL3);
int width3 = 30;
int height3 = 30; 
Image resizedImage3 = originalIcon3.getImage().getScaledInstance(width3, height3, java.awt.Image.SCALE_DEFAULT);
jButton5.setIcon(new ImageIcon(resizedImage3));
   
        
           java.net.URL imageURL4 = getClass().getResource("/icon/icons8-list-50.png");
ImageIcon originalIcon4 = new ImageIcon(imageURL4);
int width4 = 30;
int height4 = 30; 
Image resizedImage4 = originalIcon4.getImage().getScaledInstance(width4, height4, java.awt.Image.SCALE_DEFAULT);
jButton6.setIcon(new ImageIcon(resizedImage4));   
           
  
           
            
           
 java.net.URL imageURL6 = getClass().getResource("/icon/icons8-information-50.png");
ImageIcon originalIcon6 = new ImageIcon(imageURL6);
int width6 = 30;
int height6 = 30; 
Image resizedImage6 = originalIcon6.getImage().getScaledInstance(width6, height6, java.awt.Image.SCALE_DEFAULT);
jButton4.setIcon(new ImageIcon(resizedImage6));   

          java.net.URL imageURL7 = getClass().getResource("/icon/icons8-edit-16.png");
ImageIcon originalIcon7 = new ImageIcon(imageURL7);
int width7 = 30;
int height7 = 30; 
Image resizedImage7 = originalIcon7.getImage().getScaledInstance(width7, height7, java.awt.Image.SCALE_DEFAULT);
jButton2.setIcon(new ImageIcon(resizedImage7));     

          java.net.URL imageURL8 = getClass().getResource("/icon/icons8-transaction-48.png");
ImageIcon originalIcon8 = new ImageIcon(imageURL8);
int width8 = 30;
int height8 = 30; 
Image resizedImage8 = originalIcon8.getImage().getScaledInstance(width8, height8, java.awt.Image.SCALE_DEFAULT);
jButton3.setIcon(new ImageIcon(resizedImage8));


       java.net.URL imageURL9 = getClass().getResource("/icon/icons8-activity-history-64.png");
ImageIcon originalIcon9 = new ImageIcon(imageURL9);
int width9 = 30;
int height9 = 30; 
Image resizedImage9 = originalIcon9.getImage().getScaledInstance(width9, height9, java.awt.Image.SCALE_DEFAULT);
jButton7.setIcon(new ImageIcon(resizedImage9));

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
    
    private void loggedin(){
        
        String getLastLoggedInUser = "SELECT * FROM log_in_history WHERE LOG_ID = (SELECT MAX(LOG_ID) FROM log_in_history)";
        String getUserInfo = "SELECT * FROM pharmacists_inf WHERE PHAR_ID = ?";
        String insertActivity = "INSERT INTO activity_history (PHAR_ID, PHAR_USERNAME, PHAR_NAME, PHAR_POS, ACT_DATE, ACT_TIME, ACT_ACTION) VALUES (?,?,?,?,?,?,?)";
       

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

        jMenuItem1 = new javax.swing.JMenuItem();
        logid = new javax.swing.JTextField();
        logname = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        ImageIcon icon = new ImageIcon (getClass().getResource("/icon/pharma-shelf.jpg"));
        Image img = icon.getImage();
        admindesktop = new javax.swing.JDesktopPane() {

            public void paintComponent(Graphics g) {

                g.drawImage(img, 0, 0, getWidth(),getHeight(),this);

            }

        };
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jMenuItem1.setText("jMenuItem1");

        logid.setEditable(false);
        logid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logidActionPerformed(evt);
            }
        });

        logname.setEditable(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ADMIN PAGE");
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.white, null, null));
        jPanel1.setPreferredSize(new java.awt.Dimension(180, 548));

        jButton2.setBackground(new java.awt.Color(204, 204, 204));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setText("LOG H'STRY");
        jButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setText("TRANS H'STRY");
        jButton3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton4.setText("USER INFO");
        jButton4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(255, 204, 0));
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton5.setText("LOG OUT");
        jButton5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton6.setText("MEDCN LIST");
        jButton6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton7.setText("ACTIVITY LOG");
        jButton7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton8.setText("PERSONAL INFO");
        jButton8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton9.setText("SALES SUMMARY");
        jButton9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(96, 96, 96))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout admindesktopLayout = new javax.swing.GroupLayout(admindesktop);
        admindesktop.setLayout(admindesktopLayout);
        admindesktopLayout.setHorizontalGroup(
            admindesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        admindesktopLayout.setVerticalGroup(
            admindesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 715, Short.MAX_VALUE)
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

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-close-35 (1).png"))); // NOI18N
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-minimize-50 (1).png"))); // NOI18N
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5))
                        .addContainerGap(136, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(12, 12, 12)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))))
                .addContainerGap())
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
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(admindesktop)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(admindesktop)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

admindesktop.removeAll();
       AD_LOGIN_HISTORY F2  = new AD_LOGIN_HISTORY();
       admindesktop.add(F2).setVisible(true);
       
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
   this.setExtendedState(JFrame.MAXIMIZED_BOTH);        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
String pid = logid.getText();
admindesktop.removeAll();
       AD_USER_INFORMATION F2  = new AD_USER_INFORMATION();
       admindesktop.add(F2).setVisible(true);     
        
       F2.updateData(pid);
// TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
setState(PH_ADMIN_PAGE.ICONIFIED);          // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
      if (userSession.isLoggedIn()) {
       
         int confirmLogout = JOptionPane.showConfirmDialog(this, "Are you sure you want to log out?", "Logout Confirmation", JOptionPane.YES_NO_OPTION);
        if (confirmLogout == JOptionPane.YES_OPTION) {
        userSession.logout();

       
        JOptionPane.showMessageDialog(this, "You have been logged out.");
      new PH_LOGINPAGE().setVisible(true);
      dispose();

      
      
    } else if(confirmLogout==JOptionPane.NO_OPTION) {
      new PH_ADMIN_PAGE().setVisible(true);
      dispose();
    }
    else{
    JOptionPane.showMessageDialog(this, "You are logged out.");
    
    }                                        
       Connection connec;
        ResultSet rs;
        PreparedStatement stm;

String sqlSelect = "SELECT * FROM log_in_history WHERE LOG_ID = (SELECT MAX(LOG_ID) FROM log_in_history)";
String sqlUserAccess = "SELECT * FROM pharmacists_inf WHERE PHAR_ID=?";

try {
    Class.forName("com.mysql.jdbc.Driver");
    connec = DriverManager.getConnection("jdbc:mysql:///psystem", "root", "");
   

    
        // Successful login
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
            // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
  if (userSession.isLoggedIn()) {
       admindesktop.removeAll();
        AD_ALL_MED EDIT = new AD_ALL_MED();
       admindesktop.add(EDIT).setVisible(true);
            
    } else {
      JOptionPane.showMessageDialog(null, "Please log in to continue.");
       new PH_LOGINPAGE().setVisible(true);
       dispose();
    }
               // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

  if (userSession.isLoggedIn()) {
        admindesktop.removeAll();
        TRANS_HISTORY f1 = new TRANS_HISTORY();
        admindesktop.add(f1).setVisible(true);
            
    } else {
      JOptionPane.showMessageDialog(null, "Please log in to continue.");
       new PH_LOGINPAGE().setVisible(true);
       dispose();
    }
                // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
         if (userSession.isLoggedIn()) {
        admindesktop.removeAll();
        AD_ACT_LOG activity = new AD_ACT_LOG();
        admindesktop.add(activity).setVisible(true);
            
    } else {
      JOptionPane.showMessageDialog(null, "Please log in to continue.");
       new PH_LOGINPAGE().setVisible(true);
       dispose();
         }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void logidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_logidActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
         if (userSession.isLoggedIn()) {
            String pid = logid.getText();

            admindesktop.removeAll();
            PH_OWN_INFO F2 = new PH_OWN_INFO();
            admindesktop.add(F2).setVisible(true);

            F2.updateData1(pid);

        } else {
            JOptionPane.showMessageDialog(null, "Please log in to continue.");
            new PH_LOGINPAGE().setVisible(true);
            dispose();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
          if (userSession.isLoggedIn()) {
       admindesktop.removeAll();
        AD_SALES Sale = new AD_SALES();
       admindesktop.add(Sale).setVisible(true);
            
    } else {
      JOptionPane.showMessageDialog(null, "Please log in to continue.");
       new PH_LOGINPAGE().setVisible(true);
       dispose();
    
               // TODO add your handling code here:
    }
    }//GEN-LAST:event_jButton9ActionPerformed

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
    private javax.swing.JDesktopPane admindesktop;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField logid;
    private javax.swing.JTextField logname;
    // End of variables declaration//GEN-END:variables
}
