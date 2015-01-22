/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fullhouse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Raymond
 */
public class Tafel extends javax.swing.JFrame {

    /**
     * Creates new form SpelerZoeken
     */
    public Tafel() {
        initComponents();
        vulSpelerTabel();
        this.setLocationRelativeTo(null);
    }
    private String[] Deelnemers;
    private int i = 0;
    private int aantalDeelnemers = 0;
    private int aantalTafels = 0;
    private final Connection connection = DatabaseConnectie.getConnection();
    private int tafelcode = 1;
    private int pcode = 0;

    private int telSpelers(int tCode, int rCode) {
        try {
            String query = "select count(*) as aantal from persoon p left outer join toernooi_inschrijvingen ti on p.p_code = ti.persoon_code "
                    + "left outer join Ronde_deelnemers r on ti.persoon_code = r.speler_code "
                    + "where r.ronde_code like ? and ti.toernooi_code like ?;";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(2, tCode);
            statement.setInt(1, rCode);
            ResultSet results = statement.executeQuery();



            while (results.next()) {

                aantalDeelnemers = results.getInt("aantal");
            }


        } catch (SQLException ex) {
            Logger.getLogger(Tafel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aantalDeelnemers;
    }

    private void spelersIndelen(int[] array, int selectedRows, int toernooiCode, int rCode, int tafelSize) {
        aantalDeelnemers = selectedRows;


        try {

            String[] spelerArray = new String[aantalDeelnemers];

            for (int o = 0; o < spelerArray.length - 1; o++) {
                int spelercode = array[o];
                String spelerCodeString = String.valueOf(spelercode);

                spelerArray[o] = spelerCodeString;


            }
            int lengte = spelerArray.length;


            Collections.shuffle(Arrays.asList(spelerArray));
            for (int j = 0; j < spelerArray.length; j++) {
            }




            int countTCode = 0;
            for (int k = 0; k < spelerArray.length - 1; k++) {
                String query2 = "update tafel_deelnemers set tafel_code = ? where toernooi_code = ? and ronde_code = ? and persoon_code like ?";
                PreparedStatement statement2 = connection.prepareStatement(query2);
                String pcodeArrayResult = spelerArray[k];
                statement2.setInt(1, tafelcode);
                statement2.setInt(2, toernooiCode);
                statement2.setInt(3, rCode);
                statement2.setString(4, pcodeArrayResult);
                statement2.execute();

                String queryCountT = "select count(tafel_code) as aantal_t from tafel_deelnemers where tafel_code = ?";
                PreparedStatement statementCountT = connection.prepareStatement(queryCountT);
                statementCountT.setInt(1, tafelcode);
                ResultSet resultCountT = statementCountT.executeQuery();

                while (resultCountT.next()) {
                    countTCode = resultCountT.getInt("aantal_t");
                    System.out.println(countTCode);
                    if (countTCode % tafelSize == 0) {
                        tafelcode++;
                        System.out.println(tafelcode);
                    }
                }


            }

        } catch (SQLException ex) {
            Logger.getLogger(Tafel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void vulSpelerTabel() {
        try {
            DefaultTableModel datamodel = createSpelerModel();
            this.jt_speler.setModel(datamodel);
            String query;
            PreparedStatement statement;

            query = "SELECT ta.persoon_code, p.voornaam, p.achternaam, ta.toernooi_code, ta.ronde_code, ta.tafel_code "
                    + "FROM tafel_deelnemers ta "
                    + "JOIN Ronde_deelnemers r ON ta.persoon_code = r.speler_code "
                    + "JOIN persoon p ON r.speler_code = p.p_code "
                    + "WHERE p.achternaam LIKE ? AND ta.persoon_code LIKE ? "
                    + "AND ta.toernooi_code LIKE ? AND ta.ronde_code LIKE ?"
                    + "AND ta.tafel_code LIKE ? order by tafel_code; ";
            statement = connection.prepareStatement(query);
            statement.setString(1, getZoekTermAchternaam());
            statement.setString(2, getZoekTermSpelerscode());
            statement.setString(3, getZoekTermToernooicode());
            statement.setString(4, getZoekTermRondecode());
            statement.setString(5, getZoekTermTafelcode());
            
            ResultSet results = statement.executeQuery();

            while (results.next()) {
                String spelercode = results.getString("persoon_code");
                String voornaam = results.getString("voornaam");
                String achternaam = results.getString("achternaam");
                String tafelcode = results.getString("tafel_code");
                String toernooicode = results.getString("toernooi_code");
                String rondeCode = results.getString("ronde_code");
                Object[] rij = {spelercode, voornaam, achternaam, toernooicode, rondeCode, tafelcode};
                datamodel.addRow(rij);

            }

            this.jt_speler.setModel(datamodel);

        } catch (SQLException ex) {
            Logger.getLogger(SpelerZoeken.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
 private void voegWinnaarToe(String spelerCode, String tafelCode, String toernooiCode, String rondeCode) {
        try {

            String query = "update tafel_deelnemers set tafel_winnaar = ? WHERE "
                    + " tafel_code like ? and toernooi_code like  ? and ronde_code like ?";
            PreparedStatement statement = connection.prepareStatement(query);
            
            statement.setString(1, spelerCode);
            statement.setString(2, tafelCode);
            statement.setString(3, toernooiCode);
            statement.setString(4, rondeCode);
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Tafel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private DefaultTableModel createSpelerModel() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("speler code");
        model.addColumn("voornaam");
        model.addColumn("achternaam");
        model.addColumn("Toernooi code");
        model.addColumn("Ronde code");
        model.addColumn("Tafel code");
        return model;
    }
 
        private String getZoekTermTafelcode() {
        String text2 = tf_tafelcode.getText();
        if (text2.length() == 0) {
            return "%";
        } else {
            return "%" + text2 + "%";
        }
    }
    
    
    private String getZoekTermAchternaam() {
        String text2 = tf_achternaam.getText();
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

    private String getZoekTermToernooicode() {
        String text3 = tf_toernooicode.getText();
        if (text3.length() == 0) {
            return "%";
        } else {
            return "%" + text3 + "%";
        }
    }

    private String getZoekTermRondecode() {
        String text3 = tf_ronde.getText();
        if (text3.length() == 0) {
            return "%";
        } else {
            return "%" + text3 + "%";
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

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jt_speler = new javax.swing.JTable();
        tf_achternaam = new javax.swing.JTextField();
        jt_achternaam = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tf_spelerscode = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        tf_toernooicode = new javax.swing.JTextField();
        deelIn = new javax.swing.JButton();
        jb_test = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tf_ronde = new javax.swing.JTextField();
        tf_tafelSize = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        tf_tafelcode = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        jButton1.setText("jButton1");

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

        tf_achternaam.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_achternaamFocusGained(evt);
            }
        });
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

        jt_achternaam.setText("achternaam: ");

        jLabel2.setText("Speler code:");

        tf_spelerscode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_spelerscodeKeyReleased(evt);
            }
        });

        jButton2.setText("Toernooi zoeken");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Speler zoeken");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel3.setText("Toernooi code:");

        tf_toernooicode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_toernooicodeActionPerformed(evt);
            }
        });
        tf_toernooicode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_toernooicodeKeyReleased(evt);
            }
        });

        deelIn.setText("deel in ");
        deelIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deelInActionPerformed(evt);
            }
        });

        jb_test.setText("Cancel");
        jb_test.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_testActionPerformed(evt);
            }
        });

        jLabel1.setText("Ronde code:");

        tf_ronde.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_rondeKeyReleased(evt);
            }
        });

        jLabel4.setText("Personen per tafel:");

        jButton4.setText("Voeg Winnaar Toe");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        tf_tafelcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_tafelcodeActionPerformed(evt);
            }
        });
        tf_tafelcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_tafelcodeKeyReleased(evt);
            }
        });

        jLabel5.setText("Tafel code");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addGap(133, 133, 133)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jb_test)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5)
                            .addComponent(jt_achternaam))
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_achternaam)
                            .addComponent(tf_spelerscode, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                            .addComponent(tf_toernooicode)
                            .addComponent(tf_ronde)
                            .addComponent(tf_tafelcode))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tf_tafelSize, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(deelIn, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(298, 298, 298))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jt_achternaam)
                            .addComponent(tf_achternaam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_spelerscode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_toernooicode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_ronde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_tafelcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deelIn)
                    .addComponent(tf_tafelSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jb_test)
                    .addComponent(jButton4))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_achternaamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_achternaamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_achternaamActionPerformed

    private void tf_toernooicodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_toernooicodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_toernooicodeActionPerformed

    private void tf_achternaamFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_achternaamFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_achternaamFocusGained

    private void tf_achternaamKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_achternaamKeyReleased
        vulSpelerTabel();
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_achternaamKeyReleased

    private void tf_spelerscodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_spelerscodeKeyReleased
        vulSpelerTabel();
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_spelerscodeKeyReleased

    private void deelInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deelInActionPerformed
        try {
            int[] selectedRows = jt_speler.getSelectedRows();
            int aantalRijen = jt_speler.getSelectedRowCount();
            String tafelSizeString = tf_tafelSize.getText();
            int tafelSize = Integer.parseInt(tafelSizeString);

            String tCode = (String) jt_speler.getValueAt(selectedRows[0], 3);
            String rCode = (String) jt_speler.getValueAt(selectedRows[0], 4);
            int tCodeInt = Integer.parseInt(tCode);
            int rCodeInt = Integer.parseInt(rCode);
            spelersIndelen(selectedRows, aantalRijen, tCodeInt, rCodeInt, tafelSize);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Alleen getallen invoeren!");
        }

        vulSpelerTabel();

    }//GEN-LAST:event_deelInActionPerformed

    private void jb_testActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_testActionPerformed
        this.dispose();

    }//GEN-LAST:event_jb_testActionPerformed

    private void tf_toernooicodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_toernooicodeKeyReleased
        vulSpelerTabel();
    }//GEN-LAST:event_tf_toernooicodeKeyReleased

    private void tf_rondeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_rondeKeyReleased
        vulSpelerTabel();
    }//GEN-LAST:event_tf_rondeKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Toernooi t = new Toernooi();
        t.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        SpelerZoeken sz = new SpelerZoeken();
        sz.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
    int selectedRow = jt_speler.getSelectedRow();
        String spelerCode = (String) jt_speler.getValueAt(selectedRow, 0);
        String tafelCode = (String) jt_speler.getValueAt(selectedRow, 5);
        String toernooiCode = (String) jt_speler.getValueAt(selectedRow, 3);
        String rondeCode = (String) jt_speler.getValueAt(selectedRow, 4);
        
        voegWinnaarToe(spelerCode, tafelCode, toernooiCode, rondeCode);
// TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void tf_tafelcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_tafelcodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_tafelcodeActionPerformed

    private void tf_tafelcodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_tafelcodeKeyReleased
       vulSpelerTabel();
    }//GEN-LAST:event_tf_tafelcodeKeyReleased

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Tafel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tafel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tafel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tafel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new Tafel().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deelIn;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jb_test;
    private javax.swing.JLabel jt_achternaam;
    private javax.swing.JTable jt_speler;
    private javax.swing.JTextField tf_achternaam;
    private javax.swing.JTextField tf_ronde;
    private javax.swing.JTextField tf_spelerscode;
    private javax.swing.JTextField tf_tafelSize;
    private javax.swing.JTextField tf_tafelcode;
    private javax.swing.JTextField tf_toernooicode;
    // End of variables declaration//GEN-END:variables
}
