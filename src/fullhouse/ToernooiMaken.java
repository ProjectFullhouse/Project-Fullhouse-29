/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fullhouse;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *go ahe
 * @author Raymond
 */
public class ToernooiMaken extends javax.swing.JFrame {

    /**
     * Creates new form ToernooiMaken
     */
    private int tcode = 0;
    public ToernooiMaken() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tf_aantalTafels = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tf_datum = new javax.swing.JTextField();
        tf_tijd = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tf_inlegGeld = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jb_maken = new javax.swing.JButton();
        tf_plaats = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jb_cancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Aantal tafels               :");

        jLabel3.setText("Datum                        :");

        jLabel4.setText(" Tijd                            :");

        jLabel5.setText("Inleggeld                   :");

        tf_inlegGeld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_inlegGeldActionPerformed(evt);
            }
        });

        jButton1.setText("Toernooi zoeken");

        jb_maken.setText("Maken");
        jb_maken.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_makenActionPerformed(evt);
            }
        });

        jLabel2.setText("plaats                        :");

        jb_cancel.setText("Cancel");
        jb_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_cancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jb_cancel))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_datum, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_aantalTafels, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jb_maken)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tf_tijd, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tf_inlegGeld, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                            .addComponent(tf_plaats))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tf_aantalTafels, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_datum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(tf_tijd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_inlegGeld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_plaats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(28, 28, 28)
                .addComponent(jb_maken)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jb_cancel))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_inlegGeldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_inlegGeldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_inlegGeldActionPerformed

    private void jb_makenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_makenActionPerformed
        String aantalTafels = tf_aantalTafels.getText();
        int tafels = Integer.parseInt(aantalTafels);
        String datumString = tf_datum.getText();
        String tijd = tf_tijd.getText();
        String inlegGeldString = tf_inlegGeld.getText();
        int inlegGeld = Integer.parseInt(inlegGeldString);
        String plaats = tf_plaats.getText();
        toernooiMaken(tafels, datumString, tijd, inlegGeld, plaats);
    }//GEN-LAST:event_jb_makenActionPerformed

    private void jb_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_cancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_jb_cancelActionPerformed

    /**
     * @param args the command line arguments
     */
    public void tCode() {
        try {
            Connection connectie = DatabaseConnectie.getConnection();
            Statement statement = connectie.createStatement();
            
            String query = "select max(t_code) as maxtcode from toernooi";
            
            ResultSet result = statement.executeQuery(query);

            if (result.next()) {
            tcode = result.getInt("maxtcode"); 
            
            }
            System.out.println(tcode);
            
        } catch (SQLException ex) {
            Logger.getLogger(Persoon.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("pCode Statement error!");
        }
    }
    private void toernooiMaken(int aantalTafels, String datum, String tijd, int inlegGeld, String plaats) {
        try {
            String query = "insert into toernooi(ingelegdGeld, deelnemerAantal, plaats, datum, tijd, t_code) " +
                           "values(?, ?, ?, ?, ?, ?);";
            
            int aantalDeelnemers = aantalTafels * 8;
            
            Connection connection = DatabaseConnectie.getConnection();
            PreparedStatement toernooiStatement = connection.prepareStatement(query);
           
            tCode();
            
     
            
            int nieuweTcode = tcode + 1;
            
            toernooiStatement.setInt(1, inlegGeld);
            toernooiStatement.setInt(2, aantalDeelnemers);
            toernooiStatement.setString(3, plaats);
            toernooiStatement.setString(4, datum);
            toernooiStatement.setString(5, tijd);
            toernooiStatement.setInt(6, nieuweTcode);
            
        } catch (SQLException ex) {
            Logger.getLogger(ToernooiMaken.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
  
    
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ToernooiMaken.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ToernooiMaken.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ToernooiMaken.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ToernooiMaken.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new ToernooiMaken().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton jb_cancel;
    private javax.swing.JButton jb_maken;
    private javax.swing.JTextField tf_aantalTafels;
    private javax.swing.JTextField tf_datum;
    private javax.swing.JTextField tf_inlegGeld;
    private javax.swing.JTextField tf_plaats;
    private javax.swing.JTextField tf_tijd;
    // End of variables declaration//GEN-END:variables
}
