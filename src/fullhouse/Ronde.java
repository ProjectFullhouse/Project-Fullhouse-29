/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fullhouse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author max
 */
public class Ronde extends javax.swing.JFrame {

    /**
     * Creates new form Ronde
     */
    public Ronde() {
        initComponents();
        vulSpelerTabel();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jt_speler = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        tf_ronde = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        tf_achternaam = new javax.swing.JTextField();
        tf_spelerscode = new javax.swing.JTextField();
        tf_toernooicode = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        tf_rondeCode = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jt_speler.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jt_speler);

        jButton1.setText("Voeg toe ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tf_ronde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_rondeActionPerformed(evt);
            }
        });

        jLabel1.setText("Nieuwe Ronde Nummer:");

        tf_achternaam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_achternaamActionPerformed(evt);
            }
        });
        tf_achternaam.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_achternaamKeyReleased(evt);
            }
        });

        tf_spelerscode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_spelerscodeKeyReleased(evt);
            }
        });

        tf_toernooicode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_toernooicodeKeyReleased(evt);
            }
        });

        jLabel2.setText("Achternaam");

        jLabel3.setText("Spelers code");

        jLabel4.setText("Toernooi code");

        jButton2.setText("Sluit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel5.setText("Ronde code");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(348, 348, 348)
                        .addComponent(jButton1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(33, 33, 33))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(237, 237, 237)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(tf_ronde, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                                .addComponent(tf_spelerscode, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tf_achternaam, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tf_toernooicode)
                                    .addComponent(tf_rondeCode, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))))
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(178, 178, 178))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tf_achternaam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tf_spelerscode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_toernooicode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_rondeCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(tf_ronde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addGap(26, 26, 26))
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_achternaamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_achternaamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_achternaamActionPerformed

    private void tf_achternaamKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_achternaamKeyReleased
        vulSpelerTabel();
    }//GEN-LAST:event_tf_achternaamKeyReleased

    private void tf_spelerscodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_spelerscodeKeyReleased
        vulSpelerTabel();
    }//GEN-LAST:event_tf_spelerscodeKeyReleased

    private void tf_toernooicodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_toernooicodeKeyReleased
        vulSpelerTabel();
    }//GEN-LAST:event_tf_toernooicodeKeyReleased

    private void tf_rondeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_rondeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_rondeActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int[] selectedRows = jt_speler.getSelectedRows();
        try {
            String rondeNummerString = tf_ronde.getText();
            int rondeNummer = Integer.parseInt(rondeNummerString);
            for (int i = 0; i < selectedRows.length; i++) {
                String selectedPCode = (String) jt_speler.getValueAt(selectedRows[i], 0);
                String selectedTCode = (String) jt_speler.getValueAt(selectedRows[i], 3);
                eersteRondeToekennen(selectedPCode, rondeNummer, selectedTCode);
                
            }
            vulSpelerTabel();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Voer alleen getallen in");
        }


    }//GEN-LAST:event_jButton1ActionPerformed
    private final Connection connection = DatabaseConnectie.getConnection();

    private void vulSpelerTabel() {
        try {
            DefaultTableModel datamodel = createSpelerModel();
            this.jt_speler.setModel(datamodel);
            String query;
            PreparedStatement statement;

            query = "SELECT r.speler_code, p.voornaam, p.achternaam, r.toernooi_code, r.ronde_code " +
                    "FROM Ronde_deelnemers r JOIN persoon p ON r.speler_code = p.p_code " + 
                    "WHERE r.speler_code LIKE ? AND p.achternaam LIKE ? AND r.toernooi_code LIKE ? AND (r.ronde_code LIKE ? OR r.ronde_code IS NULL); ";
            statement = connection.prepareStatement(query);
            statement.setString(2, getZoekTermAchternaam());
            statement.setString(1, getZoekTermSpelerscode());
            statement.setString(3, getZoekTermToernooicode());
            statement.setString(4, getZoekTermRondecode());
            

            ResultSet results = statement.executeQuery();

            while (results.next()) {
                String spelercode = results.getString("speler_code");
                String voornaam = results.getString("voornaam");
                String achternaam = results.getString("achternaam");
                String toernooicode = results.getString("toernooi_code");
                String rondeCode = results.getString("ronde_code");

                Object[] rij = {spelercode, voornaam, achternaam, toernooicode, rondeCode};
                datamodel.addRow(rij);

            }

            this.jt_speler.setModel(datamodel);

        } catch (SQLException ex) {
            Logger.getLogger(SpelerZoeken.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void eersteRondeToekennen(String spelerCode, int rondeNummer, String toernooiCode) {
        try {
            int pCode = Integer.parseInt(spelerCode);
            int tCode = Integer.parseInt(toernooiCode);
            String query = "update Ronde_deelnemers set ronde_code = ? where speler_code = ? and toernooi_code = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(2, pCode);
            statement.setInt(1, rondeNummer);
            statement.setInt(3, tCode);
            statement.execute();
            
            String query2 = "insert into tafel_deelnemers(persoon_code, ronde_code, toernooi_code) "
                          + "values(?, ?, ?);";
            PreparedStatement statement2 = connection.prepareStatement(query2);
            statement2.setInt(1, pCode);
            statement2.setInt(2, rondeNummer);
            statement2.setInt(3, tCode);
  
            statement2.execute();

        } catch (SQLException ex) {
            Logger.getLogger(Ronde.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void getRonde(int pCode, int tCode) {
        try {
            String queryRonde = "SELECT ronde_code from ronde where speler_code like ? and toernooi_code like ?";
            PreparedStatement statementR = connection.prepareStatement(queryRonde);
            statementR.setInt(1, pCode);
            statementR.setInt(2,tCode);
        } catch (SQLException ex) {
            Logger.getLogger(Ronde.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private DefaultTableModel createSpelerModel() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("speler code");
        model.addColumn("voornaam");
        model.addColumn("achternaam");
        model.addColumn("toernooi code");
        model.addColumn("ronde nummer");
        return model;
    }

    private String getZoekTermAchternaam() {
        String text2 = tf_achternaam.getText();
        if (text2.length() == 0) {
            return "%";
        } else {
            return "%" + text2 + "%";
        }
    }

    private String getZoekTermToernooicode() {
        String text2 = tf_toernooicode.getText();
        if (text2.length() == 0) {
            return "%";
        } else {
            return "%" + text2 + "%";
        }
    }

    private String getZoekTermSpelerscode() {
        String text3 = tf_spelerscode.getText();
        if (text3.length() == 0) {
            return "%";
        } else {
            return "%" + text3 + "%";
        }
    }
   
    private String getZoekTermRondecode() {
        String text3 = tf_rondeCode.getText();
        if (text3.length() == 0) {
            return "%";
        } else {
            return "%" + text3 + "%";
        }
    }

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
            java.util.logging.Logger.getLogger(Ronde.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ronde.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ronde.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ronde.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ronde().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jt_speler;
    private javax.swing.JTextField tf_achternaam;
    private javax.swing.JTextField tf_ronde;
    private javax.swing.JTextField tf_rondeCode;
    private javax.swing.JTextField tf_spelerscode;
    private javax.swing.JTextField tf_toernooicode;
    // End of variables declaration//GEN-END:variables
}
