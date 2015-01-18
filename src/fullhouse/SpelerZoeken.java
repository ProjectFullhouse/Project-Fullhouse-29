/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fullhouse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Raymond
 */
public class SpelerZoeken extends javax.swing.JFrame {

    private boolean eersteKeer = true;

    public SpelerZoeken() {
        initComponents();
        vulSpelerTabel();
        this.setLocationRelativeTo(null);
    }

    private void vulSpelerTabel() {
        try {
            DefaultTableModel datamodel = createSpelerModel();
            this.jt_speler.setModel(datamodel);

            String query = "select p_code, voornaam, achternaam, postcode, rating from persoon "
                         + "where achternaam like ? and voornaam like ? and p_code like ?;";
            Connection connection = DatabaseConnectie.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            //if (eersteKeer || text1.length() == 0) {
            // statement.setString(1, "p_code");
            // statement.setString(2, getZoekTermSpelerCode());
            
            statement.setString(1, getZoekTermAchternaam());
            statement.setString(2, getZoekTermVoornaam());
            statement.setString(3, getZoekTermSpelerscode());
            

            ResultSet results = statement.executeQuery();

            while (results.next()) {
                int spelercode = results.getInt("p_code");
                String voornaam = results.getString("voornaam");
                String achternaam = results.getString("achternaam");
                String postcode = results.getString("postcode");
                int rating = results.getInt("rating");
                Object[] rij = {spelercode, voornaam, achternaam, postcode, rating};
                datamodel.addRow(rij);

            }

            this.jt_speler.setModel(datamodel);
        } catch (SQLException ex) {
            Logger.getLogger(SpelerZoeken.class.getName()).log(Level.SEVERE, null, ex);
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
    
    private String getZoekTermVoornaam() {
        String text2 = tf_voornaam.getText();
        if (text2.length() == 0) {
            return "%";
        } else {
            return "%" + text2 + "%";
        }
    }
    
    private String getZoekTermSpelerscode() {
        String text2 = tf_spelersCode.getText();
        if (text2.length() == 0) {
            return "%";
        } else {
            return "%" + text2 + "%";
        }
    }

    private DefaultTableModel createSpelerModel() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("speler code");
        model.addColumn("voornaam");
        model.addColumn("achternaam");
        model.addColumn("postcode");
        model.addColumn("rating");
        return model;
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
        jl_achternaam = new javax.swing.JLabel();
        tf_achternaam = new javax.swing.JTextField();
        jb_cancel = new javax.swing.JButton();
        jl_voornaam = new javax.swing.JLabel();
        tf_voornaam = new javax.swing.JTextField();
        jl_spelersCode = new javax.swing.JLabel();
        tf_spelersCode = new javax.swing.JTextField();
        jb_toernooi = new javax.swing.JButton();
        jb_tafel = new javax.swing.JButton();
        jb_masterclass = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(650, 350));
        setPreferredSize(new java.awt.Dimension(650, 350));
        setResizable(false);

        jScrollPane1.setPreferredSize(new java.awt.Dimension(452, 248));

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

        jl_achternaam.setText("Achternaam:");

        tf_achternaam.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_achternaamKeyReleased(evt);
            }
        });

        jb_cancel.setText("Cancel");
        jb_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_cancelActionPerformed(evt);
            }
        });

        jl_voornaam.setText("Voornaam:");

        tf_voornaam.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_voornaamKeyReleased(evt);
            }
        });

        jl_spelersCode.setText("Spelerscode:");

        tf_spelersCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_spelersCodeKeyReleased(evt);
            }
        });

        jb_toernooi.setText("Toernooi zoeken");
        jb_toernooi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_toernooiActionPerformed(evt);
            }
        });

        jb_tafel.setText("Tafelindeling zoeken");
        jb_tafel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_tafelActionPerformed(evt);
            }
        });

        jb_masterclass.setText("Masterclass zoeken");
        jb_masterclass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_masterclassActionPerformed(evt);
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
                        .addComponent(jb_cancel))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jl_spelersCode)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_spelersCode, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jl_voornaam)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tf_voornaam, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jl_achternaam)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tf_achternaam, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jb_toernooi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jb_tafel, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                            .addComponent(jb_masterclass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jl_spelersCode)
                            .addComponent(tf_spelersCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jl_voornaam)
                            .addComponent(tf_voornaam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jl_achternaam)
                            .addComponent(tf_achternaam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jb_toernooi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jb_tafel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jb_masterclass)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jb_cancel)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_achternaamKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_achternaamKeyReleased
        this.vulSpelerTabel();
    }//GEN-LAST:event_tf_achternaamKeyReleased

    private void jb_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_cancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_jb_cancelActionPerformed

    private void tf_voornaamKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_voornaamKeyReleased
        vulSpelerTabel();
    }//GEN-LAST:event_tf_voornaamKeyReleased

    private void tf_spelersCodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_spelersCodeKeyReleased
        vulSpelerTabel();
    }//GEN-LAST:event_tf_spelersCodeKeyReleased

    private void jb_toernooiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_toernooiActionPerformed
        Toernooi t = new Toernooi();
        t.setVisible(true);
    }//GEN-LAST:event_jb_toernooiActionPerformed

    private void jb_tafelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_tafelActionPerformed
        Tafel ta = new Tafel();
        ta.setVisible(true);
    }//GEN-LAST:event_jb_tafelActionPerformed

    private void jb_masterclassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_masterclassActionPerformed
        Masterclass mc = new Masterclass();
        mc.setVisible(true);
    }//GEN-LAST:event_jb_masterclassActionPerformed

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
            java.util.logging.Logger.getLogger(SpelerZoeken.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SpelerZoeken.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SpelerZoeken.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SpelerZoeken.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new SpelerZoeken().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jb_cancel;
    private javax.swing.JButton jb_masterclass;
    private javax.swing.JButton jb_tafel;
    private javax.swing.JButton jb_toernooi;
    private javax.swing.JLabel jl_achternaam;
    private javax.swing.JLabel jl_spelersCode;
    private javax.swing.JLabel jl_voornaam;
    private javax.swing.JTable jt_speler;
    private javax.swing.JTextField tf_achternaam;
    private javax.swing.JTextField tf_spelersCode;
    private javax.swing.JTextField tf_voornaam;
    // End of variables declaration//GEN-END:variables
}
