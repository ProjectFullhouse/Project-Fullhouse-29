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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Raymond
 */
public class Toernooi extends javax.swing.JFrame {

    /**
     * Creates new form SpelerZoeken
     */
    private Connection connection = DatabaseConnectie.getConnection();
    private int selectedTCode = 0;
    private int neededRating = 0;
    private int aantalRijen = 0;

    public Toernooi() {
        initComponents();
        vulToernooiTabel();
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

        jf_inschrijving = new javax.swing.JFrame();
        jScrollPane3 = new javax.swing.JScrollPane();
        jt_persoon = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jt_inschrijvingen = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        tf_voornaam = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tf_achternaam = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jl_beschikbarePlaatsen = new javax.swing.JLabel();
        jb_inschrijven = new javax.swing.JButton();
        jb_update = new javax.swing.JButton();
        jcb_betaald = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jt_toernooi = new javax.swing.JTable();
        jt_toernooicode = new javax.swing.JTextField();
        jl_toernooiCode = new javax.swing.JLabel();
        jl_datum = new javax.swing.JLabel();
        tf_datum = new javax.swing.JTextField();
        jb_cancel = new javax.swing.JButton();
        jb_speler = new javax.swing.JButton();
        jb_tafel = new javax.swing.JButton();
        jb_masterclass = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tf_plaats = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        jf_inschrijving.setMinimumSize(new java.awt.Dimension(850, 400));
        jf_inschrijving.setResizable(false);

        jt_persoon.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jt_persoon);

        jt_inschrijvingen.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(jt_inschrijvingen);

        jLabel3.setText("Voornaam:");

        tf_voornaam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_voornaamActionPerformed(evt);
            }
        });

        jLabel4.setText("Achternaam:");

        jLabel5.setText("Beschikbare plaatsen:");

        jl_beschikbarePlaatsen.setText("---");

        jb_inschrijven.setText("Inschijven");
        jb_inschrijven.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_inschrijvenActionPerformed(evt);
            }
        });

        jb_update.setText("Update");
        jb_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_updateActionPerformed(evt);
            }
        });

        jcb_betaald.setText("Betaald");
        jcb_betaald.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_betaaldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jf_inschrijvingLayout = new javax.swing.GroupLayout(jf_inschrijving.getContentPane());
        jf_inschrijving.getContentPane().setLayout(jf_inschrijvingLayout);
        jf_inschrijvingLayout.setHorizontalGroup(
            jf_inschrijvingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jf_inschrijvingLayout.createSequentialGroup()
                .addGroup(jf_inschrijvingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jf_inschrijvingLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jf_inschrijvingLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_voornaam, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_achternaam, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jf_inschrijvingLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jf_inschrijvingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jb_inschrijven, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                    .addComponent(jb_update, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jf_inschrijvingLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jcb_betaald)))
                .addGap(106, 106, 106)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jl_beschikbarePlaatsen)
                .addGap(151, 151, 151))
        );
        jf_inschrijvingLayout.setVerticalGroup(
            jf_inschrijvingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jf_inschrijvingLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jf_inschrijvingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jf_inschrijvingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jl_beschikbarePlaatsen)
                    .addComponent(jb_inschrijven))
                .addGroup(jf_inschrijvingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jf_inschrijvingLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jf_inschrijvingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tf_voornaam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(tf_achternaam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jf_inschrijvingLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jb_update)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jcb_betaald)
                .addGap(50, 50, 50))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(650, 400));
        setResizable(false);

        jScrollPane1.setPreferredSize(new java.awt.Dimension(452, 248));

        jt_toernooi.setModel(new javax.swing.table.DefaultTableModel(
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
        jt_toernooi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jt_toernooiMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jt_toernooi);

        jt_toernooicode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jt_toernooicodeActionPerformed(evt);
            }
        });
        jt_toernooicode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jt_toernooicodeKeyReleased(evt);
            }
        });

        jl_toernooiCode.setText("Toernooicode:");

        jl_datum.setText("Datum:");

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

        jb_cancel.setText("Sluit");
        jb_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_cancelActionPerformed(evt);
            }
        });

        jb_speler.setText("Speler zoeken");
        jb_speler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_spelerActionPerformed(evt);
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

        jLabel1.setText("dd-mm-jjjj");

        tf_plaats.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_plaatsKeyReleased(evt);
            }
        });

        jLabel2.setText("Plaats:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jb_tafel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                            .addComponent(jb_speler, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jb_masterclass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jl_toernooiCode)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jt_toernooicode, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jl_datum)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jb_cancel))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tf_datum, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tf_plaats, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jb_speler)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jb_tafel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jb_masterclass))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jl_datum)
                                .addComponent(jt_toernooicode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jl_toernooiCode))
                            .addComponent(tf_datum, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jb_cancel))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel1))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tf_plaats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jt_toernooicodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jt_toernooicodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jt_toernooicodeActionPerformed

    private void jb_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_cancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_jb_cancelActionPerformed

    private void jb_spelerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_spelerActionPerformed
        SpelerZoeken spelerZoeken = new SpelerZoeken();
        spelerZoeken.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jb_spelerActionPerformed

    private void jb_tafelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_tafelActionPerformed
        Tafel ta = new Tafel();
        ta.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jb_tafelActionPerformed

    private void jb_masterclassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_masterclassActionPerformed
        Masterclass mc = new Masterclass();
        mc.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jb_masterclassActionPerformed

    private void jt_toernooicodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jt_toernooicodeKeyReleased

        vulToernooiTabel();
        // TODO add your handling code here:
    }//GEN-LAST:event_jt_toernooicodeKeyReleased

    private void tf_datumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_datumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_datumActionPerformed

    private void tf_datumKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_datumKeyReleased
        vulToernooiTabel();
// TODO add your handling code here:
    }//GEN-LAST:event_tf_datumKeyReleased

    private void tf_plaatsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_plaatsKeyReleased
        vulToernooiTabel();
    }//GEN-LAST:event_tf_plaatsKeyReleased

    private void jt_toernooiMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jt_toernooiMousePressed
        if (evt.getClickCount() == 2) {
            int rij = jt_toernooi.getSelectedRow();
            if (rij > -1) {
                selectedTCode = (Integer) jt_toernooi.getValueAt(rij, 0);
                neededRating = (Integer) jt_toernooi.getValueAt(rij, 4);
                jf_inschrijving.setVisible(true);

            }
            String beschikbarePlaatsen = String.valueOf(getAantalPlaatsen(selectedTCode));
            jl_beschikbarePlaatsen.setText(beschikbarePlaatsen);
            vulPersoonTable();
            vulInschrijvenTabel();

        }
    }//GEN-LAST:event_jt_toernooiMousePressed

    private void tf_voornaamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_voornaamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_voornaamActionPerformed

    private void jcb_betaaldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_betaaldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcb_betaaldActionPerformed

    private void jb_inschrijvenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_inschrijvenActionPerformed
        int[] selectedRows = jt_persoon.getSelectedRows();
        int aantalPlaatsen = getAantalPlaatsen(selectedTCode);
        aantalRijen = jt_persoon.getSelectedRowCount();

        for (int i = 0; i < selectedRows.length; i++) {
            int selectedPCode = (Integer) jt_persoon.getValueAt(selectedRows[i], 0);
            int selectedRating = (Integer) jt_persoon.getValueAt(selectedRows[i], 3);

            if (jcb_betaald.isSelected() && aantalPlaatsen > 0) {

                inschrijvenToernooi(selectedPCode, "j", aantalPlaatsen);
            } else if (!jcb_betaald.isSelected() && aantalPlaatsen > 0) {

                inschrijvenToernooi(selectedPCode, "n", aantalPlaatsen);
            } else if (aantalPlaatsen == 0) {
                JOptionPane.showMessageDialog(null, "Geen beschikbare plaatsen!");
            }
            else {
                JOptionPane.showMessageDialog(null, "Toevoegen niet toegestaan!");
            }

        }

        aantalPlaatsen = getAantalPlaatsen(selectedTCode);
        String aantalPlaatsenString = String.valueOf(aantalPlaatsen);
        jl_beschikbarePlaatsen.setText(aantalPlaatsenString);
        tellenIngelegdGeld(selectedTCode);
        vulPersoonTable();
        vulInschrijvenTabel();
        vulToernooiTabel();
    }//GEN-LAST:event_jb_inschrijvenActionPerformed

    private void jb_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_updateActionPerformed

        int[] selectedRows = jt_inschrijvingen.getSelectedRows();

        for (int i = 0; i < selectedRows.length; i++) {
            Boolean betaald = (Boolean) jt_inschrijvingen.getValueAt(selectedRows[i], 3);
            int selectedTCode1 = (Integer) jt_inschrijvingen.getValueAt(selectedRows[i], 2);
            int selectedPCode1 = (Integer) jt_inschrijvingen.getValueAt(selectedRows[i], 0);
            String betaaldState = getBetaald(selectedTCode1, selectedPCode1);
            System.out.println(i);
            System.out.println(selectedTCode1);
            System.out.println(selectedPCode1);
            if (jcb_betaald.isSelected() && betaaldState.equals("n")) {
                try {
                    String query = "update toernooi_inschrijvingen set betaald = 'j' where toernooi_code = ? and persoon_code = ?;";
                    PreparedStatement statementUpdateBetaald = connection.prepareStatement(query);
                    statementUpdateBetaald.setInt(1, selectedTCode1);
                    statementUpdateBetaald.setInt(2, selectedPCode1);

                    statementUpdateBetaald.execute();
                    vulInschrijvenTabel();
                } catch (SQLException ex) {
                    Logger.getLogger(Masterclass.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Aanpassing niet toegestaan!");
            }

        }

        tellenIngelegdGeld(selectedTCode);
    }//GEN-LAST:event_jb_updateActionPerformed

    public void vulToernooiTabel() {
        try {
            TableModel toernooiModel = createToernooiModel();

            String query = "SELECT t_code, plaats, datum, tijd, deelnemerAantal, inlegGeld, totaal_inlegGeld FROM toernooi where t_code like ? and datum like ? and plaats like ?;";

            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, getZoekTermToernooicode());
            statement.setString(2, getZoekTermDatum());
            statement.setString(3, getZoekTermPlaats());

            ResultSet results = statement.executeQuery();

            while (results.next()) {
                int t_code = results.getInt("t_code");
                String plaats = results.getString("plaats");
                String datum = results.getString("datum");
                String tijd = results.getString("tijd");
                int deelnemerAantal = results.getInt("deelnemerAantal");
                int inlegGeld = results.getInt("inlegGeld");
                int totaalInlegGeld = results.getInt("totaal_inlegGeld");
                Object[] rij = {t_code, plaats, datum, tijd, deelnemerAantal, inlegGeld, totaalInlegGeld};
                toernooiModel.addRow(rij);
            }
            this.jt_toernooi.setModel(toernooiModel);
        } catch (SQLException ex) {
            Logger.getLogger(Toernooi.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void vulPersoonTable() {
        try {
            TableModel datamodelPersoon = createPersoonTable();
            this.jt_persoon.setModel(datamodelPersoon);

            String queryPersoon = "SELECT p_code, voornaam, achternaam, rating "
                    + "FROM persoon WHERE achternaam LIKE ? "
                    + "AND voornaam like ? "
                    + "AND p_code NOT IN(SELECT persoon_code "
                    + "FROM toernooi_inschrijvingen "
                    + "WHERE toernooi_code = ?); ";
            PreparedStatement statement = connection.prepareStatement(queryPersoon);

            statement.setString(1, getZoekTermAchternaam());
            statement.setString(2, getZoekTermVoornaam());
            statement.setInt(3, selectedTCode);

            ResultSet resultsPersoon = statement.executeQuery();

            while (resultsPersoon.next()) {
                int p_code = resultsPersoon.getInt("p_code");
                String voornaam = resultsPersoon.getString("voornaam");
                String achternaam = resultsPersoon.getString("achternaam");
                int rating = resultsPersoon.getInt("rating");
                Object[] rij = {p_code, voornaam, achternaam, rating};
                datamodelPersoon.addRow(rij);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Masterclass.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Er is een fout opgetreden!");
        }

    }

    private void vulInschrijvenTabel() {
        try {
            InschrijvenTableModel datamodelInschrijven = createInschrijvingTable();
            this.jt_inschrijvingen.setModel(datamodelInschrijven);

            String queryInschrijven = "SELECT i.persoon_code, p.achternaam, i.toernooi_code, i.betaald "
                    + "FROM toernooi_inschrijvingen i JOIN persoon p ON i.persoon_code = p.p_code "
                    + "WHERE toernooi_code LIKE ? "
                    + "ORDER BY i.persoon_code;";
            PreparedStatement statement = connection.prepareStatement(queryInschrijven);

            statement.setInt(1, selectedTCode);

            ResultSet resultsInschrijven = statement.executeQuery();

            while (resultsInschrijven.next()) {
                int p_code = resultsInschrijven.getInt("i.persoon_code");
                String achternaam = resultsInschrijven.getString("p.achternaam");
                int t_code = resultsInschrijven.getInt("i.toernooi_code");
                String betaaldString = resultsInschrijven.getString("betaald");
                boolean betaald = betaaldString.equals("j");
                Object[] rij = {p_code, achternaam, t_code, betaald};
                datamodelInschrijven.addRow(rij);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Masterclass.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Er is een fout opgetreden!");
        }
    }

    private int getAantalPlaatsen(int tCode) {
        int aantalPlaatsen = 0;
        try {

            String query = "select deelnemerAantal from toernooi where t_code = ?;";
            PreparedStatement statementAP = connection.prepareStatement(query);
            statementAP.setInt(1, tCode);

            ResultSet resultAP = statementAP.executeQuery();

            while (resultAP.next()) {
                aantalPlaatsen = resultAP.getInt("deelnemerAantal");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Masterclass.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aantalPlaatsen;
    }

    private String getBetaald(int tCode, int pCode) {
        String betaaldState = "";
        try {
            String query = "select betaald from toernooi_inschrijvingen where toernooi_code like ? and persoon_code like ?;";
            PreparedStatement statementBetaald = connection.prepareStatement(query);
            statementBetaald.setInt(1, tCode);
            statementBetaald.setInt(2, pCode);

            ResultSet resultBetaald = statementBetaald.executeQuery();

            while (resultBetaald.next()) {
                betaaldState = resultBetaald.getString("betaald");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Masterclass.class.getName()).log(Level.SEVERE, null, ex);
        }
        return betaaldState;
    }

    private void updateMasterclass(int beschikbarePlaatsen) {
        try {
            String queryInsert2 = "update toernooi set deelnemerAantal = ? where t_code = ? ";
            PreparedStatement statement3 = connection.prepareStatement(queryInsert2);
            int nieuweBeschikbarePlaatsen = beschikbarePlaatsen - aantalRijen;
            statement3.setInt(1, nieuweBeschikbarePlaatsen);
            statement3.setInt(2, selectedTCode);

            statement3.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Masterclass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void inschrijvenToernooi(int code, String betaaldString, int beschikbarePlaatsen) {
        try {

            String queryInsertTI = "insert into toernooi_inschrijvingen(persoon_code, toernooi_code, betaald) "
                    + "values(?, ?, ?);";
            PreparedStatement statement2 = connection.prepareStatement(queryInsertTI);

            statement2.setInt(1, code);
            statement2.setInt(2, selectedTCode);
            statement2.setString(3, betaaldString);
            statement2.execute();
            
            String queryInsertRD = "insert into Ronde_deelnemers(speler_code, toernooi_code) values (?, ?)";
            PreparedStatement statementRD = connection.prepareStatement(queryInsertRD);
            statementRD.setInt(1, code);
            statementRD.setInt(2, selectedTCode);
            statementRD.execute();
            

            updateMasterclass(beschikbarePlaatsen);

        } catch (SQLException ex) {
            Logger.getLogger(Masterclass.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Er is een fout opgetreden!");
        }
    }

    public void tellenIngelegdGeld(int selectedTCode) {
        try {
            String query = "select count(i.betaald) as count_betaald, t.inlegGeld from toernooi t join toernooi_inschrijvingen i on t.t_code = i.toernooi_code "
                    + "where i.betaald = 'j' and t.t_code like ?;";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, selectedTCode);

            ResultSet resultTotaal = statement.executeQuery();
            int aantalBetaald = 0;
            int inlegGeld = 0;
            while (resultTotaal.next()) {
                aantalBetaald = resultTotaal.getInt("count_betaald");
                inlegGeld = resultTotaal.getInt("t.inlegGeld");
            }
            int totaalInlegGeld = aantalBetaald * inlegGeld;
            System.out.println(totaalInlegGeld);
            String queryUpdate = "update toernooi set totaal_inlegGeld = ? where t_code = ?;";

            PreparedStatement statementUpdate = connection.prepareStatement(queryUpdate);
            statementUpdate.setInt(1, totaalInlegGeld);
            statementUpdate.setInt(2, selectedTCode);

            statementUpdate.execute();

        } catch (SQLException ex) {
            Logger.getLogger(Toernooi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private TableModel createToernooiModel() {
        TableModel model = new TableModel();
        model.addColumn("Toernooi code");
        model.addColumn("Plaats");
        model.addColumn("Datum");
        model.addColumn("Tijd");
        model.addColumn("Aantal Deelnemers");
        model.addColumn("Kosten");
        model.addColumn("Totaal Prijzengeld");
        return model;
    }

    private TableModel createPersoonTable() {

        TableModel model = new TableModel();
        model.addColumn("Persoon code");
        model.addColumn("Voornaam");
        model.addColumn("Achternaam");
        model.addColumn("Rating");
        return model;
    }

    private InschrijvenTableModel createInschrijvingTable() {

        InschrijvenTableModel model = new InschrijvenTableModel();
        model.addColumn("Persoon code");
        model.addColumn("achternaam");
        model.addColumn("Toernooi code");
        model.addColumn("Betaald");
        return model;
    }

    /**
     * @param args the command line arguments
     */
    class TableModel extends DefaultTableModel {

        public boolean isCellEditable(int row, int column) {
            return false;
        }
    }

    class InschrijvenTableModel extends TableModel {

        @Override
        public Class getColumnClass(int columnIndex) {
            return (columnIndex == 3) ? Boolean.class : super.getColumnClass(columnIndex);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    }

    private String getZoekTermToernooicode() {
        String text2 = jt_toernooicode.getText();
        if (text2.length() == 0) {
            return "%";
        } else {
            return "%" + text2 + "%";
        }
    }

    private String getZoekTermDatum() {
        String text2 = tf_datum.getText();
        if (text2.length() == 0) {
            return "%";
        } else {
            return "%" + text2 + "%";
        }
    }

    private String getZoekTermPlaats() {
        String text2 = tf_plaats.getText();
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

    private String getZoekTermVoornaam() {
        String text2 = tf_voornaam.getText();
        if (text2.length() == 0) {
            return "%";
        } else {
            return "%" + text2 + "%";
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
            java.util.logging.Logger.getLogger(Toernooi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Toernooi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Toernooi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Toernooi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Toernooi().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton jb_cancel;
    private javax.swing.JButton jb_inschrijven;
    private javax.swing.JButton jb_masterclass;
    private javax.swing.JButton jb_speler;
    private javax.swing.JButton jb_tafel;
    private javax.swing.JButton jb_update;
    private javax.swing.JCheckBox jcb_betaald;
    private javax.swing.JFrame jf_inschrijving;
    private javax.swing.JLabel jl_beschikbarePlaatsen;
    private javax.swing.JLabel jl_datum;
    private javax.swing.JLabel jl_toernooiCode;
    private javax.swing.JTable jt_inschrijvingen;
    private javax.swing.JTable jt_persoon;
    private javax.swing.JTable jt_toernooi;
    private javax.swing.JTextField jt_toernooicode;
    private javax.swing.JTextField tf_achternaam;
    private javax.swing.JTextField tf_datum;
    private javax.swing.JTextField tf_plaats;
    private javax.swing.JTextField tf_voornaam;
    // End of variables declaration//GEN-END:variables
}
