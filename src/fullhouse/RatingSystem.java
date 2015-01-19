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
 * @author Gebruiker
 */
public class RatingSystem extends javax.swing.JFrame {

    /**
     * Creates new form RatingSystem
     */
    private Connection connection = DatabaseConnectie.getConnection();

    public RatingSystem() {
        initComponents();
        vulSpelerTabel();
        this.setLocationRelativeTo(null);
    }

    private void vulSpelerTabel() {
        try {
            DefaultTableModel datamodel = createSpelerModel();
            this.j_spelerTabel.setModel(datamodel);

            String query = "select p_code, voornaam, achternaam, rating from persoon where p_code like ?;";

            PreparedStatement statement = connection.prepareStatement(query);

            //if (eersteKeer || text1.length() == 0) {
            // statement.setString(1, "p_code");
            // statement.setString(2, getZoekTermSpelerCode());

            statement.setString(1, getZoekRating());

            ResultSet results = statement.executeQuery();

            while (results.next()) {
                String spelercode = results.getString("p_code");
                String voornaam = results.getString("voornaam");
                String achternaam = results.getString("achternaam");
                String rating = results.getString("rating");
                Object[] rij = {spelercode, voornaam, achternaam, rating};
                datamodel.addRow(rij);

            }

            this.j_spelerTabel.setModel(datamodel);
        } catch (SQLException ex) {
            Logger.getLogger(SpelerZoeken.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private String getZoekRating() {
        String text2 = j_spelerCode.getText();
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
        model.addColumn("rating");
        return model;
    }
    private int nieuweRating1;
    private int nieuweRating2;
    private double expScore;
    private int score = 1;
    private int constant = 30;

    private void berekenRating() {

        String oudeRatingString = j_rating1.getText();
        String oudeRating2String = j_rating2.getText();


        int oudeRating = Integer.parseInt(oudeRatingString);
        int oudeRating2 = Integer.parseInt(oudeRating2String);

        int maxRating = Math.max(oudeRating, oudeRating2);
        int minRating = Math.min(oudeRating, oudeRating2);

        if (maxRating - minRating == 0) {
            expScore = 0.5;
        } else if (maxRating - minRating <= 21 && maxRating - minRating > 0) {
            expScore = 0.53;
        } else if (maxRating - minRating <= 41 && maxRating - minRating > 20) {
            expScore = 0.58;
        } else if (maxRating - minRating <= 61 && maxRating - minRating > 40) {
            expScore = 0.62;
        } else if (maxRating - minRating <= 81 && maxRating - minRating > 60) {
            expScore = 0.66;
        } else if (maxRating - minRating <= 101 && maxRating - minRating > 80) {
            expScore = 0.69;
        } else if (maxRating - minRating <= 121 && maxRating - minRating > 100) {
            expScore = 0.73;
        } else if (maxRating - minRating <= 141 && maxRating - minRating > 120) {
            expScore = 0.76;
        } else if (maxRating - minRating <= 161 && maxRating - minRating > 140) {
            expScore = 0.79;
        } else if (maxRating - minRating <= 181 && maxRating - minRating > 160) {
            expScore = 0.82;
        } else if (maxRating - minRating <= 201 && maxRating - minRating > 180) {
            expScore = 0.84;
        } else if (maxRating - minRating <= 301 && maxRating - minRating > 200) {
            expScore = 0.93;
        } else if (maxRating - minRating <= 401 && maxRating - minRating > 300) {
            expScore = 0.97;
        }

        double nieuweRating = constant * (score - expScore);



        nieuweRating1 = (int) (oudeRating + nieuweRating);
        nieuweRating2 = (int) (oudeRating2 - nieuweRating);
        j_nrating1.setText("" + nieuweRating1 + "");
        j_nrating2.setText("" + nieuweRating2 + "");
    }

    private int getRating(int pCode) {
        int rating = 0;
        try {
            String query = "select rating from persoon where p_code = ?";

            PreparedStatement ratingStatement = connection.prepareStatement(query);
            ratingStatement.setInt(1, pCode);

            ResultSet resultsRating = ratingStatement.executeQuery();
            while(resultsRating.next()) {
                rating = resultsRating.getInt("rating");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(RatingSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rating;

    }
    
    private void updateRating(){

            try {
                String p_code = r_Speler1.getText();
                int p_codeint = Integer.parseInt(p_code);
                String query = "UPDATE persoon "
                            + "SET rating = ? WHERE p_code like ?;";
                    
                    PreparedStatement persoonStatement = connection.prepareStatement(query);

                    persoonStatement.setInt(1, nieuweRating1);
                    persoonStatement.setInt(2, p_codeint);

                    persoonStatement.execute();
            } catch (SQLException ex) {
                Logger.getLogger(RatingSystem.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
            
            String p_code = r_Speler2.getText();
                int p_codeint = Integer.parseInt(p_code);
                String query = "UPDATE persoon "
                            + "SET rating = ? WHERE p_code like ?;";
                    
                    PreparedStatement persoonStatement = connection.prepareStatement(query);

                    persoonStatement.setInt(1, nieuweRating2);
                    persoonStatement.setInt(2, p_codeint);

                    persoonStatement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(RatingSystem.class.getName()).log(Level.SEVERE, null, ex);
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
        jLabel1 = new javax.swing.JLabel();
        j_spelerCode = new javax.swing.JTextField();
        r_Speler2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        j_nrating1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        j_rating1 = new javax.swing.JTextField();
        j_rating2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        j_nrating2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        j_spelerTabel = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        r_Speler1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("OK!");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("eerste");

        j_spelerCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j_spelerCodeActionPerformed(evt);
            }
        });
        j_spelerCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                j_spelerCodeKeyReleased(evt);
            }
        });

        r_Speler2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_Speler2ActionPerformed(evt);
            }
        });
        r_Speler2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                r_Speler2FocusGained(evt);
            }
        });

        jLabel2.setText("laatste");

        jLabel3.setText("N_Rating 1");

        j_nrating1.setEditable(false);

        jLabel4.setText("Rating");

        j_rating1.setEditable(false);

        jLabel5.setText("N_Rating 2");

        j_spelerTabel.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(j_spelerTabel);

        jLabel6.setText("Spelerscode:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(r_Speler2, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                            .addComponent(r_Speler1))
                        .addGap(5, 5, 5)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(j_rating1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(j_rating2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(j_nrating2))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(j_nrating1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton1))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(j_spelerCode, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(j_rating1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(r_Speler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(r_Speler2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(j_rating2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(j_nrating1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(j_nrating2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(j_spelerCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void r_Speler2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_Speler2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_r_Speler2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            String p_code = r_Speler1.getText();
            int p_codeint = Integer.parseInt(p_code);
            int rating = getRating(p_codeint);
            String ratingString = String.valueOf(rating);
            j_rating1.setText(ratingString);
            String p_code2 = r_Speler2.getText();
            int p_codeint2 = Integer.parseInt(p_code2);
            int rating2 = getRating(p_codeint2);
            String ratingString2 = String .valueOf(rating2);
            j_rating2.setText(ratingString2);
            //de rating word hier berekend.
            berekenRating();
            updateRating();
            vulSpelerTabel();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void j_spelerCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_j_spelerCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_j_spelerCodeActionPerformed

    private void j_spelerCodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_j_spelerCodeKeyReleased

        this.vulSpelerTabel();
        // TODO add your handling code here:
    }//GEN-LAST:event_j_spelerCodeKeyReleased

    private void r_Speler2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_r_Speler2FocusGained
    }//GEN-LAST:event_r_Speler2FocusGained

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
            java.util.logging.Logger.getLogger(RatingSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RatingSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RatingSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RatingSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new RatingSystem().setVisible(true);
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
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField j_nrating1;
    private javax.swing.JTextField j_nrating2;
    private javax.swing.JTextField j_rating1;
    private javax.swing.JTextField j_rating2;
    private javax.swing.JTextField j_spelerCode;
    private javax.swing.JTable j_spelerTabel;
    private javax.swing.JTextField r_Speler1;
    private javax.swing.JTextField r_Speler2;
    // End of variables declaration//GEN-END:variables
}
