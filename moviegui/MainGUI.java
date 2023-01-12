/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package moviegui;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MD
 */
public class MainGUI extends javax.swing.JFrame {
    
    public static Movie movie;
    
    /**
     * Creates new form MainGUI
     */
    public MainGUI() {
        initComponents();
//        LocalDate todayDate=LocalDate.now();
//        Date now = Date.valueOf(todayDate);
//        Date RegisterdDate = User_login.currentUser.getDate();
//        LocalDate RDate_inlocalform = RegisterdDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(); // convert it to localdate to use the plus function
//        LocalDate RDA365 = RDate_inlocalform.plusDays(365);
//        java.util.Date d = null;
//        try {
//            d = new SimpleDateFormat("yyyy-MM-dd").parse(RDA365.toString());
//        } catch (ParseException ex) {
//            Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
//        }

        
        if(User_login.currentUser.getStatus() ){
            jButton5.setEnabled(true);
            
        }
        else{
            jButton5.setEnabled(false);
            
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MovieGui");
        setIconImages(null);
        setSize(new java.awt.Dimension(800, 600));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BlackAdam.jpeg"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 190, 260));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BlackPanther.jpg"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 160, 190, 260));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/JamesBond.jpeg"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 160, 180, 260));

        jLabel12.setText("jLabel1");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 330, 120, 20));

        jButton3.setText("Cancel");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 510, 110, 20));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Welcome");
        jLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 730, 40));

        jLabel9.setText("Cancel ticket:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 510, 100, -1));

        jLabel10.setText("Cancel ticket:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 510, 100, -1));

        jButton5.setText("pay");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 500, 110, 30));

        jLabel11.setText("Annal_fee_payment");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 500, 160, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String movieName="Black Adam";
        
        
        
        TestConnection sqlCon =new TestConnection();
        try{
            String summary= sqlCon.getMovieSummary(movieName);
            String language=sqlCon.getMovieLang(movieName);
            String url=sqlCon.getUrlImage(language);
            String rating=sqlCon.getMovieRating(movieName);
            java.sql.Date year = sqlCon.getMovieYear(movieName);
            
            movie=new Movie(language,movieName,summary,url,rating,year);
            
             System.out.println(MainGUI.movie.getPoster_path());
        
        }
        catch (SQLException e) {
      System.out.println("Connection fail");
       System.out.println(MainGUI.movie.getPoster_path());
    }
       
        MovieObject x = new MovieObject();
        x.setVisible(true);
        dispose();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String movieName="Black Panther";
        
        
        TestConnection sqlCon =new TestConnection();
        try{
            String summary= sqlCon.getMovieSummary(movieName);
            String language=sqlCon.getMovieLang(movieName);
            String url=sqlCon.getUrlImage(language);
            String rating=sqlCon.getMovieRating(movieName);
            java.sql.Date year = sqlCon.getMovieYear(movieName);
            
            movie=new Movie(language,movieName,summary,url,rating,year);
            
            
         System.out.println(MainGUI.movie.getPoster_path());
        }
        catch (SQLException e) {
      System.out.println("Connection fail");
      
    }
        
        
        MovieObject x = new MovieObject();
        x.setVisible(true);
        dispose();
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        String movieName="James Bond: No time to die";
        
        
        TestConnection sqlCon =new TestConnection();
        try{
            String summary= sqlCon.getMovieSummary(movieName);
            String language=sqlCon.getMovieLang(movieName);
            String url=sqlCon.getUrlImage(language);
            String rating=sqlCon.getMovieRating(movieName);
            java.sql.Date year = sqlCon.getMovieYear(movieName);
            
            movie=new Movie(language,movieName,summary,url,rating,year);
            
             System.out.println(MainGUI.movie.getPoster_path());
        
        }
        catch (SQLException e) {
      System.out.println("Connection fail");
      
    }
        
        MovieObject x = new MovieObject();
        x.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        Cancel_tickets x = new Cancel_tickets();
        x.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       Annual_pay x = new Annual_pay();
        x.setVisible(true);
        dispose();
        
    }//GEN-LAST:event_jButton5ActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}