/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fullhouse;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Raymond
 */
public class Masterclass extends javax.swing.JFrame {

    /**
     * Creates new form Masterclass
     */
    private Connection connection = DatabaseConnectie.getConnection();
    private int selectedMCode = 0;
    private int neededRating = 0;
    int aantalRijen = 0;

    public Masterclass() {
        initComponents();
        vulMasterClassTable();
        this.setLocationRelativeTo(null);
        jf_inschrijving.setLocationRelativeTo(null);

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
        jScrollPane2 = new javax.swing.JScrollPane();
        jt_inschrijvingen = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jt_persoon = new javax.swing.JTable();
        tf_achternaam = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jb_inschrijven = new javax.swing.JButton();
        jl_voornaam = new javax.swing.JLabel();
        tf_voornaam = new javax.swing.JTextField();
        jb_cancelInschrijven = new javax.swing.JButton();
        jcb_betaald = new javax.swing.JCheckBox();
        jl_beschikbarePlaatsenTekst = new javax.swing.JLabel();
        jl_beschikbarePlaatsen = new javax.swing.JLabel();
        jb_update = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jt_masterclass = new javax.swing.JTable();
        jb_cancelMasterclass = new javax.swing.JButton();
        jb_speler = new javax.swing.JButton();
        jb_toernooi = new javax.swing.JButton();
        jb_tafel = new javax.swing.JButton();
        jl_naamCLass = new javax.swing.JLabel();
        tf_naamClass = new javax.swing.JTextField();
        jl_naamDocent = new javax.swing.JLabel();
        tf_naamDocent = new javax.swing.JTextField();
        jl_datum = new javax.swing.JLabel();
        tf_datum = new javax.swing.JTextField();

        jf_inschrijving.setMinimumSize(new java.awt.Dimension(850, 400));
        jf_inschrijving.setResizable(false);

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
        jt_inschrijvingen.setMinimumSize(new java.awt.Dimension(80, 64));
        jScrollPane2.setViewportView(jt_inschrijvingen);

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

        tf_achternaam.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_achternaamKeyReleased(evt);
            }
        });

        jLabel1.setText("Achternaam:");

        jb_inschrijven.setText("Inschrijven");
        jb_inschrijven.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_inschrijvenActionPerformed(evt);
            }
        });

        jl_voornaam.setText("Voornaam:");

        tf_voornaam.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_voornaam.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_voornaamKeyReleased(evt);
            }
        });

        jb_cancelInschrijven.setText("Cancel");
        jb_cancelInschrijven.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_cancelInschrijvenActionPerformed(evt);
            }
        });

        jcb_betaald.setText("Betaald");

        jl_beschikbarePlaatsenTekst.setText("Beschikbare plaatsen:");

        jl_beschikbarePlaatsen.setText("---");

        jb_update.setText("Update");
        jb_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_updateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jf_inschrijvingLayout = new javax.swing.GroupLayout(jf_inschrijving.getContentPane());
        jf_inschrijving.getContentPane().setLayout(jf_inschrijvingLayout);
        jf_inschrijvingLayout.setHorizontalGroup(
            jf_inschrijvingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jf_inschrijvingLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jf_inschrijvingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jf_inschrijvingLayout.createSequentialGroup()
                        .addComponent(jl_voornaam)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_voornaam, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_achternaam, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(86, 86, 86)
                        .addGroup(jf_inschrijvingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jf_inschrijvingLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jcb_betaald)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 326, Short.MAX_VALUE)
                                .addComponent(jb_cancelInschrijven))
                            .addGroup(jf_inschrijvingLayout.createSequentialGroup()
                                .addGroup(jf_inschrijvingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jb_update, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jb_inschrijven, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(99, 99, 99)
                                .addComponent(jl_beschikbarePlaatsenTekst)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jl_beschikbarePlaatsen))))
                    .addGroup(jf_inschrijvingLayout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jf_inschrijvingLayout.setVerticalGroup(
            jf_inschrijvingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jf_inschrijvingLayout.createSequentialGroup()
                .addGroup(jf_inschrijvingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jf_inschrijvingLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jf_inschrijvingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jf_inschrijvingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jl_beschikbarePlaatsenTekst)
                        .addComponent(jl_beschikbarePlaatsen))
                    .addComponent(jb_inschrijven))
                .addGap(3, 3, 3)
                .addGroup(jf_inschrijvingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jf_inschrijvingLayout.createSequentialGroup()
                        .addGroup(jf_inschrijvingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jl_voornaam)
                            .addComponent(tf_voornaam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                        .addComponent(jb_cancelInschrijven))
                    .addGroup(jf_inschrijvingLayout.createSequentialGroup()
                        .addGroup(jf_inschrijvingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jb_update)
                            .addComponent(tf_achternaam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcb_betaald)))
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jt_masterclass.setModel(new javax.swing.table.DefaultTableModel(
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
        jt_masterclass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jt_masterclassMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jt_masterclass);

        jb_cancelMasterclass.setText("Cancel");
        jb_cancelMasterclass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_cancelMasterclassActionPerformed(evt);
            }
        });

        jb_speler.setText("Speler zoeken");
        jb_speler.setPreferredSize(new java.awt.Dimension(160, 23));
        jb_speler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_spelerActionPerformed(evt);
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

        jl_naamCLass.setText("Naam class:");

        tf_naamClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_naamClassActionPerformed(evt);
            }
        });
        tf_naamClass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_naamClassKeyReleased(evt);
            }
        });

        jl_naamDocent.setText("Naam docent:");

        tf_naamDocent.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_naamDocentKeyReleased(evt);
            }
        });

        jl_datum.setText("Datum:");

        tf_datum.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_datumKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jb_cancelMasterclass, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jb_toernooi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jb_tafel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jb_speler, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jl_naamCLass, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tf_naamClass, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jl_naamDocent)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tf_naamDocent, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jl_datum)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tf_datum, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jb_speler, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jb_toernooi, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jb_tafel))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_naamCLass)
                    .addComponent(tf_naamClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jl_naamDocent)
                    .addComponent(tf_naamDocent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jl_datum)
                    .addComponent(tf_datum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(jb_cancelMasterclass)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jt_masterclassMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jt_masterclassMousePressed
        if (evt.getClickCount() == 2) {
            int rij = jt_masterclass.getSelectedRow();
            if (rij > -1) {
                selectedMCode = (Integer) jt_masterclass.getValueAt(rij, 0);
                neededRating = (Integer) jt_masterclass.getValueAt(rij, 5);
                jf_inschrijving.setVisible(true);

            }
            String beschikbarePlaatsen = String.valueOf(getAantalPlaatsen(selectedMCode));
            jl_beschikbarePlaatsen.setText(beschikbarePlaatsen);
            vulPersoonTable();
            vulInschrijvenTabel();

        }
    }//GEN-LAST:event_jt_masterclassMousePressed

    private void tf_achternaamKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_achternaamKeyReleased
        this.vulPersoonTable();
    }//GEN-LAST:event_tf_achternaamKeyReleased

    private void jb_inschrijvenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_inschrijvenActionPerformed
        int[] selectedRows = jt_persoon.getSelectedRows();
        int aantalPlaatsen = getAantalPlaatsen(selectedMCode);
        aantalRijen = jt_persoon.getSelectedRowCount();

        for (int i = 0;  i < selectedRows.length; i++) {
            int selectedPCode = (Integer) jt_persoon.getValueAt(selectedRows[i], 0);
            int selectedRating = (Integer) jt_persoon.getValueAt(selectedRows[i], 3);
            
            if (jcb_betaald.isSelected() && selectedRating > neededRating && aantalPlaatsen > 0) {

                inschrijvenMasterclass(selectedPCode, "j", aantalPlaatsen);
            } else if (!jcb_betaald.isSelected() && selectedRating > neededRating && aantalPlaatsen > 0) {

                inschrijvenMasterclass(selectedPCode, "n", aantalPlaatsen);
            }
            else {
                JOptionPane.showMessageDialog(null, "Toevoegen niet toegestaan!");
            }
        }
        
            
        
        aantalPlaatsen = getAantalPlaatsen(selectedMCode);
        String aantalPlaatsenString = String.valueOf(aantalPlaatsen);
        jl_beschikbarePlaatsen.setText(aantalPlaatsenString);
        vulPersoonTable();
        vulInschrijvenTabel();
        vulMasterClassTable();
    }//GEN-LAST:event_jb_inschrijvenActionPerformed

    private void tf_voornaamKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_voornaamKeyReleased
        vulPersoonTable();
    }//GEN-LAST:event_tf_voornaamKeyReleased

    private void jb_cancelInschrijvenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_cancelInschrijvenActionPerformed
        jf_inschrijving.dispose();
    }//GEN-LAST:event_jb_cancelInschrijvenActionPerformed

    private void jb_cancelMasterclassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_cancelMasterclassActionPerformed
        this.dispose();
    }//GEN-LAST:event_jb_cancelMasterclassActionPerformed

    private void jb_spelerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_spelerActionPerformed
        SpelerZoeken sz = new SpelerZoeken();
        sz.setVisible(true);
    }//GEN-LAST:event_jb_spelerActionPerformed

    private void jb_toernooiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_toernooiActionPerformed
        Toernooi t = new Toernooi();
        t.setVisible(true);
    }//GEN-LAST:event_jb_toernooiActionPerformed

    private void jb_tafelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_tafelActionPerformed
        Tafel ta = new Tafel();
        ta.setVisible(true);
    }//GEN-LAST:event_jb_tafelActionPerformed

    private void jb_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_updateActionPerformed
        int[] selectedRows = jt_inschrijvingen.getSelectedRows();

        for (int i = 0; i < 10; i++) {
            Boolean betaald = (Boolean) jt_inschrijvingen.getValueAt(selectedRows[i], 3);
            int selectedMCode1 = (Integer) jt_inschrijvingen.getValueAt(selectedRows[i], 2);
            int selectedPCode1 = (Integer) jt_inschrijvingen.getValueAt(selectedRows[i], 0);
            String betaaldState = getBetaald(selectedMCode1, selectedPCode1);

            if (betaald && betaaldState.equals("n")) {
                try {
                    String query = "update masterclass_inschrijvingen set betaald = 'j' where masterclass_code = ? and persoon_code = ?;";
                    PreparedStatement statementUpdateBetaald = connection.prepareStatement(query);
                    statementUpdateBetaald.setInt(1, selectedMCode1);
                    statementUpdateBetaald.setInt(2, selectedPCode1);
                    
                    statementUpdateBetaald.execute();
                    vulInschrijvenTabel();
                } catch (SQLException ex) {
                    Logger.getLogger(Masterclass.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else {
                JOptionPane.showMessageDialog(null, "Aanpassing niet toegestaan!");
            }
        }

        
    }//GEN-LAST:event_jb_updateActionPerformed

    private void tf_naamClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_naamClassActionPerformed
        vulMasterClassTable();
    }//GEN-LAST:event_tf_naamClassActionPerformed

    private void tf_naamClassKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_naamClassKeyReleased
        vulMasterClassTable();
    }//GEN-LAST:event_tf_naamClassKeyReleased

    private void tf_naamDocentKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_naamDocentKeyReleased
        vulMasterClassTable();
    }//GEN-LAST:event_tf_naamDocentKeyReleased

    private void tf_datumKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_datumKeyReleased
        vulMasterClassTable();
    }//GEN-LAST:event_tf_datumKeyReleased
   
    /**
     * @param args the command line arguments
     */
    private void vulMasterClassTable() {
        try {
            TableModel datamodelMasterclass = createMasterclassTable();
            this.jt_masterclass.setModel(datamodelMasterclass);

            String query = "SELECT m.m_code, m.naam, p.achternaam, m.beschikbare_plaatsen, m.datum, minimumRating "
                    + "FROM persoon p JOIN docent d ON p.p_code = d.persoon "
                    + "LEFT OUTER JOIN masterclass m ON d.d_code = m.docent "
                    + "WHERE m.naam like ? and p.achternaam like ? and m.datum like ?;";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, getZoekTermNaamClass());
            statement.setString(2, getZoekTermNaamDocent());
            statement.setString(3, getZoekTermDatum());
            ResultSet results = statement.executeQuery();

            while (results.next()) {
                int mCode = results.getInt("m.m_code");
                String naamToernooi = results.getString("naam");
                String naamDocent = results.getString("p.achternaam");
                int plaatsen = results.getInt("m.beschikbare_plaatsen");
                String datum = results.getString("datum");
                int minimumRating = results.getInt("minimumRating");
                Object[] rij = {mCode, naamToernooi, naamDocent, plaatsen, datum, minimumRating};
                datamodelMasterclass.addRow(rij);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Masterclass.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Er is een fout opgetreden!");
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
                    + "FROM masterclass_inschrijvingen "
                    + "WHERE masterclass_code = ?); ";
            PreparedStatement statement = connection.prepareStatement(queryPersoon);

            statement.setString(1, getZoekTermAchternaam());
            statement.setString(2, getZoekTermVoornaam());
            statement.setInt(3, selectedMCode);

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

            String queryInschrijven = "SELECT i.persoon_code, p.achternaam, i.masterclass_code, i.betaald "
                    + "FROM masterclass_inschrijvingen i JOIN persoon p ON i.persoon_code = p.p_code "
                    + "WHERE masterclass_code LIKE ? "
                    + "ORDER BY i.persoon_code;";
            PreparedStatement statement = connection.prepareStatement(queryInschrijven);

            statement.setInt(1, selectedMCode);

            ResultSet resultsInschrijven = statement.executeQuery();

            while (resultsInschrijven.next()) {
                int p_code = resultsInschrijven.getInt("i.persoon_code");
                String achternaam = resultsInschrijven.getString("p.achternaam");
                int m_code = resultsInschrijven.getInt("i.masterclass_code");
                String betaaldString = resultsInschrijven.getString("betaald");
                boolean betaald = betaaldString.equals("j");
                Object[] rij = {p_code, achternaam, m_code, betaald};
                datamodelInschrijven.addRow(rij);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Masterclass.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Er is een fout opgetreden!");
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
    
    private String getZoekTermNaamClass() {
        String text2 = tf_naamClass.getText();
        if (text2.length() == 0) {
            return "%";
        } else {
            return "%" + text2 + "%";
        }
    }
    
    private String getZoekTermNaamDocent() {
        String text2 = tf_naamDocent.getText();
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
   

    private int getAantalPlaatsen(int mCode) {
        int aantalPlaatsen = 0;
        try {

            String query = "select beschikbare_plaatsen from masterclass where m_code = ?;";
            PreparedStatement statementAP = connection.prepareStatement(query);
            statementAP.setInt(1, mCode);

            ResultSet resultAP = statementAP.executeQuery();

            while (resultAP.next()) {
                aantalPlaatsen = resultAP.getInt("beschikbare_plaatsen");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Masterclass.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aantalPlaatsen;
    }

    private String getBetaald(int mCode, int pCode) {
        String betaaldState = "";
        try {
            String query = "select betaald from masterclass_inschrijvingen where masterclass_code like ? and persoon_code like ?;";
            PreparedStatement statementBetaald = connection.prepareStatement(query);
            statementBetaald.setInt(1, mCode);
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
            String queryInsert2 = "update masterclass set beschikbare_plaatsen = ? where m_code = ? ";
            PreparedStatement statement3 = connection.prepareStatement(queryInsert2);
            int nieuweBeschikbarePlaatsen = beschikbarePlaatsen - aantalRijen;
            statement3.setInt(1, nieuweBeschikbarePlaatsen);
            statement3.setInt(2, selectedMCode);

            statement3.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Masterclass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void inschrijvenMasterclass(int code, String betaaldString, int beschikbarePlaatsen) {
        try {

            String queryInsert = "insert into masterclass_inschrijvingen(persoon_code, masterclass_code, betaald) "
                    + "values(?, ?, ?);";
            PreparedStatement statement2 = connection.prepareStatement(queryInsert);

            statement2.setInt(1, code);
            statement2.setInt(2, selectedMCode);
            statement2.setString(3, betaaldString);
            statement2.execute();
            System.out.println(code);
            System.out.println(beschikbarePlaatsen);

            updateMasterclass(beschikbarePlaatsen);

        } catch (SQLException ex) {
            Logger.getLogger(Masterclass.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Er is een fout opgetreden!");
        }
    }

    private TableModel createMasterclassTable() {

        TableModel model = new TableModel();
        model.addColumn("Masterclass code");
        model.addColumn("Naam class");
        model.addColumn("Docent");
        model.addColumn("Aantal Plaatsen");
        model.addColumn("Datum");
        model.addColumn("Benodigde rating");
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
        model.addColumn("Masterclass code");
        model.addColumn("Betaald");
        return model;
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
            java.util.logging.Logger.getLogger(Masterclass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Masterclass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Masterclass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Masterclass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new Masterclass().setVisible(true);
            }
        });
    }

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
            return (column == 3);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton jb_cancelInschrijven;
    private javax.swing.JButton jb_cancelMasterclass;
    private javax.swing.JButton jb_inschrijven;
    private javax.swing.JButton jb_speler;
    private javax.swing.JButton jb_tafel;
    private javax.swing.JButton jb_toernooi;
    private javax.swing.JButton jb_update;
    private javax.swing.JCheckBox jcb_betaald;
    private javax.swing.JFrame jf_inschrijving;
    private javax.swing.JLabel jl_beschikbarePlaatsen;
    private javax.swing.JLabel jl_beschikbarePlaatsenTekst;
    private javax.swing.JLabel jl_datum;
    private javax.swing.JLabel jl_naamCLass;
    private javax.swing.JLabel jl_naamDocent;
    private javax.swing.JLabel jl_voornaam;
    private javax.swing.JTable jt_inschrijvingen;
    private javax.swing.JTable jt_masterclass;
    private javax.swing.JTable jt_persoon;
    private javax.swing.JTextField tf_achternaam;
    private javax.swing.JTextField tf_datum;
    private javax.swing.JTextField tf_naamClass;
    private javax.swing.JTextField tf_naamDocent;
    private javax.swing.JTextField tf_voornaam;
    // End of variables declaration//GEN-END:variables
}
