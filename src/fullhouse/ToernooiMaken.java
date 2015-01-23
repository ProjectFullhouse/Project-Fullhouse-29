/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fullhouse;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * @author Raymond
 */
public class ToernooiMaken extends javax.swing.JFrame {

    /**
     * Creates new form ToernooiMaken
     */
    private int tcode = 0;
    private String tafelRegex = "[0-9]{0,3}";
    private String datumRegex = "[0-9]{2}[-]{1}[0-9]{2}[-]{1}[0-9]{4}";
    private String tijdRegex = "[0-9]{2}[:]{1}[0-9]{2}";
    private String inlegGeldRegex = "[0-9]{1,6}";
    private String plaatsRegex = "[^0-9]{0,45}";
    String tafels = "";
    String datum = "";
    String tijd = "";
    String inlegGeld = "";
    String plaats = "";

    public ToernooiMaken() {
        initComponents();
        jl_tafels.setVisible(false);
        jl_datum.setVisible(false);
        jl_tijd.setVisible(false);
        jl_inlegGeld.setVisible(false);
        jl_plaats.setVisible(false);
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
        jb_maken = new javax.swing.JButton();
        tf_plaats = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jb_cancel = new javax.swing.JButton();
        jt_buttonZoeken = new javax.swing.JButton();
        jl_tafels = new javax.swing.JLabel();
        jl_datum = new javax.swing.JLabel();
        jl_tijd = new javax.swing.JLabel();
        jl_inlegGeld = new javax.swing.JLabel();
        jl_plaats = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Aantal tafels               :");

        tf_aantalTafels.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_aantalTafelsKeyReleased(evt);
            }
        });

        jLabel3.setText("Datum                        :");

        tf_datum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_datumActionPerformed(evt);
            }
        });
        tf_datum.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_datumKeyReleased(evt);
            }
        });

        tf_tijd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_tijdActionPerformed(evt);
            }
        });
        tf_tijd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_tijdKeyReleased(evt);
            }
        });

        jLabel4.setText(" Tijd                            :");

        jLabel5.setText("Inleggeld                    :");

        tf_inlegGeld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_inlegGeldActionPerformed(evt);
            }
        });
        tf_inlegGeld.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_inlegGeldKeyReleased(evt);
            }
        });

        jb_maken.setText("Maken");
        jb_maken.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_makenActionPerformed(evt);
            }
        });

        tf_plaats.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_plaatsKeyReleased(evt);
            }
        });

        jLabel2.setText(" plaats                        :");

        jb_cancel.setText("Sluit");
        jb_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_cancelActionPerformed(evt);
            }
        });

        jt_buttonZoeken.setText("Toernooi zoeken");
        jt_buttonZoeken.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jt_buttonZoekenActionPerformed(evt);
            }
        });

        jl_tafels.setForeground(new java.awt.Color(255, 51, 51));
        jl_tafels.setText("Alleen cijfers toegestaan");

        jl_datum.setForeground(new java.awt.Color(255, 51, 51));
        jl_datum.setText("Voorbeeld: dd-mm-yyyy");

        jl_tijd.setForeground(new java.awt.Color(255, 51, 51));
        jl_tijd.setText("Voorbeeld: 12:00");

        jl_inlegGeld.setForeground(new java.awt.Color(255, 51, 51));
        jl_inlegGeld.setText("Alleen cijfers toegestaan");

        jl_plaats.setForeground(new java.awt.Color(255, 51, 51));
        jl_plaats.setText("Alleen letters toegestaan");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jt_buttonZoeken)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jb_cancel))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jb_maken)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel1))
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tf_aantalTafels, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                                    .addComponent(tf_datum))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jl_tafels)
                                    .addComponent(jl_datum)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel4))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(20, 20, 20)
                                                .addComponent(tf_plaats, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addGap(24, 24, 24)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(tf_inlegGeld, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(tf_tijd, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jl_tijd)
                                    .addComponent(jl_inlegGeld)
                                    .addComponent(jl_plaats))))
                        .addGap(0, 14, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_aantalTafels, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jl_tafels))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tf_datum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jl_datum))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tf_tijd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jl_tijd))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_inlegGeld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jl_inlegGeld))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tf_plaats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jl_plaats))
                .addGap(18, 18, 18)
                .addComponent(jb_maken)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jb_cancel)
                    .addComponent(jt_buttonZoeken))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_inlegGeldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_inlegGeldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_inlegGeldActionPerformed

    private void jb_makenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_makenActionPerformed
        if (tafels.matches(tafelRegex) && datum.matches(datumRegex) && tijd.matches(tijdRegex) && inlegGeld.matches(inlegGeldRegex) && plaats.matches(plaatsRegex)) {
            String aantalTafels = tf_aantalTafels.getText();
            int tafels = Integer.parseInt(aantalTafels);
            String datumString = tf_datum.getText();
            String tijd = tf_tijd.getText();
            String inlegGeldString = tf_inlegGeld.getText();
            int inlegGeld = Integer.parseInt(inlegGeldString);
            String plaats = tf_plaats.getText();
            toernooiMaken(tafels, datumString, tijd, inlegGeld, plaats);
        }
        else {
            JOptionPane.showMessageDialog(null, "Foute invoer! Toevoegen mislukt!");
        }

    }//GEN-LAST:event_jb_makenActionPerformed

    private void jb_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_cancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_jb_cancelActionPerformed

    private void tf_tijdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_tijdActionPerformed

    }//GEN-LAST:event_tf_tijdActionPerformed

    private void jt_buttonZoekenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jt_buttonZoekenActionPerformed
        Toernooi t = new Toernooi();
        t.setVisible(true);
    }//GEN-LAST:event_jt_buttonZoekenActionPerformed

    private void tf_datumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_datumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_datumActionPerformed

    private void tf_aantalTafelsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_aantalTafelsKeyReleased
        tafels = tf_aantalTafels.getText();
        if (tafels.matches(tafelRegex)) {
            jl_tafels.setVisible(false);

        } else {
            jl_tafels.setVisible(true);

        }
    }//GEN-LAST:event_tf_aantalTafelsKeyReleased

    private void tf_datumKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_datumKeyReleased
        datum = tf_datum.getText();
        if (datum.matches(datumRegex)) {
            jl_datum.setVisible(false);

        } else {
            jl_datum.setVisible(true);

        }
    }//GEN-LAST:event_tf_datumKeyReleased

    private void tf_tijdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_tijdKeyReleased
        tijd = tf_tijd.getText();
        if (tijd.matches(tijdRegex)) {
            jl_tijd.setVisible(false);

        } else {
            jl_tijd.setVisible(true);

        }
    }//GEN-LAST:event_tf_tijdKeyReleased

    private void tf_inlegGeldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_inlegGeldKeyReleased
        inlegGeld = tf_inlegGeld.getText();
        if (inlegGeld.matches(inlegGeldRegex)) {
            jl_inlegGeld.setVisible(false);

        } else {
            jl_inlegGeld.setVisible(true);

        }
    }//GEN-LAST:event_tf_inlegGeldKeyReleased

    private void tf_plaatsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_plaatsKeyReleased
        plaats = tf_plaats.getText();
        if (plaats.matches(plaatsRegex)) {
            jl_plaats.setVisible(false);

        } else {
            jl_plaats.setVisible(true);

        }
    }//GEN-LAST:event_tf_plaatsKeyReleased

    /**
     * @param args the command line arguments
     */
    

    private void toernooiMaken(int aantalTafels, String datum, String tijd, int inlegGeld, String plaats) {
        try {
            String query = "insert into toernooi(inlegGeld, deelnemerAantal, plaats, datum, tijd) "
                    + "values(?, ?, ?, ?, ?);";

            int aantalDeelnemers = aantalTafels * 8;

            Connection connection = DatabaseConnectie.getConnection();
            PreparedStatement toernooiStatement = connection.prepareStatement(query);



            toernooiStatement.setInt(1, inlegGeld);
            toernooiStatement.setInt(2, aantalDeelnemers);
            toernooiStatement.setString(3, plaats);
            toernooiStatement.setString(4, datum);
            toernooiStatement.setString(5, tijd);

            toernooiStatement.execute();
            JOptionPane.showMessageDialog(rootPane, "Toevoegen voltooid!");
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton jb_cancel;
    private javax.swing.JButton jb_maken;
    private javax.swing.JLabel jl_datum;
    private javax.swing.JLabel jl_inlegGeld;
    private javax.swing.JLabel jl_plaats;
    private javax.swing.JLabel jl_tafels;
    private javax.swing.JLabel jl_tijd;
    private javax.swing.JButton jt_buttonZoeken;
    private javax.swing.JTextField tf_aantalTafels;
    private javax.swing.JTextField tf_datum;
    private javax.swing.JTextField tf_inlegGeld;
    private javax.swing.JTextField tf_plaats;
    private javax.swing.JTextField tf_tijd;
    // End of variables declaration//GEN-END:variables
}
