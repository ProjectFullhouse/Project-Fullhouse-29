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
        telSpelers();
        initComponents();
        vulSpelerTabel();
        this.setLocationRelativeTo(null);
    }

    private String[] Deelnemers;
    private int i = 0;
    private int aantalDeelnemers = 0;
    private int aantalTafels = 0;
    private final Connection connection = DatabaseConnectie.getConnection();
    private int tcode = 1;
    private int pcode = 0;

    private void maakTafel(int pcode) {
        try {
            String[] Tafel = new String[8];
            String query = "insert into tafel_deelnemers(persoon_code, tafel_code)"
                    + " values(?, ? );";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, pcode);//code is hier 11 want dat is de laatste die hij vind in vul tafel

            statement.setInt(2, tcode);

            statement.execute();
            for (int j = 0; j <= (aantalDeelnemers - 1); j++) {

                if (j % 8 == 0) {
                    tcode++;

                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(Tafel.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    private void telSpelers() {
        try {

            String query;
            PreparedStatement statement;

            query = "select * from persoon ;";
            statement = connection.prepareStatement(query);

            ResultSet results = statement.executeQuery();

            while (results.next()) {

                aantalDeelnemers++;
            }
            Deelnemers = new String[aantalDeelnemers];

        } catch (SQLException ex) {
            Logger.getLogger(Tafel.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    private void getPcode() {

        try {
            String query = "select p_code from persoon;";
            PreparedStatement statement = connection.prepareStatement(query);
            
            ResultSet results = statement.executeQuery();
            String[] spelerArray = new String[aantalDeelnemers];
            int i = 0;
            while (results.next()) {
                String spelercode = results.getString("p_code");
                pcode = Integer.parseInt(spelercode);
                spelerArray[i] = spelercode;
                i++;

            }
            
            Collections.shuffle(Arrays.asList(spelerArray));

            

            String query2 = "insert into tafel_deelnemers(persoon_code, tafel_code)"
                    + " values(?, ? );";
            PreparedStatement statement2 = connection.prepareStatement(query2);
            int countTCode = 0;
            for (int j = 0; j < aantalDeelnemers; j++) {
                String pcodeArrayResult = spelerArray[j];
                statement2.setString(1, pcodeArrayResult);
                statement2.setInt(2, tcode);
                statement2.execute();
                String queryCountT = "select count(tafel_code) as aantal_t from tafel_deelnemers where tafel_code = ?";
                PreparedStatement statementCountT = connection.prepareStatement(queryCountT);
                statementCountT.setInt(1, tcode);
                ResultSet resultCountT = statementCountT.executeQuery();
                
                while(resultCountT.next()) {
                    countTCode = resultCountT.getInt("aantal_t");
                }
                if (countTCode == 8) {
                    tcode++;
                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(Tafel.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void vulSpelerTabel() {
        try {
            DefaultTableModel datamodel = createSpelerModel();
            this.jt_speler.setModel(datamodel);
            String query;
            PreparedStatement statement;

            query = "select p.p_code, p.voornaam, p.achternaam, t.tafel_code from persoon p LEFT OUTER JOIN tafel_deelnemers t ON p.p_code = t.persoon_code  where p.achternaam like ? and p.p_code like ? order by p.p_code;";
            statement = connection.prepareStatement(query);
            statement.setString(1, getZoekTermAchternaam());
            statement.setString(2, getZoekTermSpelerscode());

            // statement.setString(1, getZoekTermAchternaam());
            //statement.setString(1, getZoekTermSpelerscode());
            ResultSet results = statement.executeQuery();

            while (results.next()) {
                String spelercode = results.getString("p_code");
                String voornaam = results.getString("voornaam");
                String achternaam = results.getString("achternaam");
                String tafelcode = results.getString("tafel_code");
                Object[] rij = {spelercode, voornaam, achternaam, tafelcode};
                datamodel.addRow(rij);

            }

            this.jt_speler.setModel(datamodel);

        } catch (SQLException ex) {
            Logger.getLogger(SpelerZoeken.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    private DefaultTableModel createSpelerModel() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("speler code");
        model.addColumn("voornaam");
        model.addColumn("achternaam");
        model.addColumn("tafel code");
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

    private String getZoekTermSpelerscode() {
        String text3 = tf_spelerscode.getText();
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
        jTextField3 = new javax.swing.JTextField();
        deelIn = new javax.swing.JButton();
        jb_test = new javax.swing.JButton();

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

        jLabel2.setText("Spelercode:");

        tf_spelerscode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_spelerscodeKeyReleased(evt);
            }
        });

        jButton2.setText("Toernooi zoeken");

        jButton3.setText("Speler zoeken:");

        jLabel3.setText("Toernooicode:");

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deelIn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jb_test)
                        .addGap(0, 20, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jt_achternaam)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_achternaam, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_spelerscode, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField3)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jt_achternaam)
                    .addComponent(tf_achternaam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(tf_spelerscode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(deelIn)
                    .addComponent(jb_test))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_achternaamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_achternaamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_achternaamActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

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
        getPcode();
        vulSpelerTabel();

    }//GEN-LAST:event_deelInActionPerformed

    private void jb_testActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_testActionPerformed
this.dispose();

    }//GEN-LAST:event_jb_testActionPerformed

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
            java.util.logging.Logger.getLogger(Tafel.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tafel.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tafel.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tafel.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JButton jb_test;
    private javax.swing.JLabel jt_achternaam;
    private javax.swing.JTable jt_speler;
    private javax.swing.JTextField tf_achternaam;
    private javax.swing.JTextField tf_spelerscode;
    // End of variables declaration//GEN-END:variables
}
