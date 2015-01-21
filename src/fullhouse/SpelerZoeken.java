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
public class SpelerZoeken extends javax.swing.JFrame {

    private Connection connection = DatabaseConnectie.getConnection();
    private Toernooi t = new Toernooi();

    public SpelerZoeken() {
        initComponents();
        vulSpelerTabel();
        this.setLocationRelativeTo(null);
        jf_spelerInfo.setLocationRelativeTo(null);

    }

    private void vulSpelerTabel() {
        try {
            TableModel datamodel = createSpelerModel();
            this.jt_speler.setModel(datamodel);

            String query = "select p_code, voornaam, achternaam, postcode, rating from persoon "
                    + "where achternaam like ? and voornaam like ? and p_code like ?;";

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

    private void vulSpelerInfo(int pCode) {
        try {
            String query = "SELECT voornaam, achternaam, adres, woonplaats, postcode, telefoon_nummer, email_adres, rating "
                    + "FROM persoon WHERE p_code = ?;";

            PreparedStatement statementSI = connection.prepareStatement(query);
            statementSI.setInt(1, pCode);

            ResultSet resultsSI = statementSI.executeQuery();
            String pcodeString = String.valueOf(pCode);
            while (resultsSI.next()) {
                jl_achternaamSI.setText(resultsSI.getString("achternaam"));
                jl_pcode.setText(pcodeString);
                jl_voornaamSI.setText(resultsSI.getString("voornaam"));
                jl_adresSI.setText(resultsSI.getString("adres"));
                jl_woonplaatsSI.setText(resultsSI.getString("woonplaats"));
                jl_postcodeSI.setText(resultsSI.getString("postcode"));
                jl_telefoonnummerSI.setText(resultsSI.getString("telefoon_nummer"));
                jl_emailSI.setText(resultsSI.getString("email_adres"));
                jl_ratingSI.setText(resultsSI.getString("rating"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SpelerZoeken.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void vulMasterclassModel(int pCode) {
        boolean betaald = true;
        try {
            MasterclassTableModel masterclassModel = createMasterclassModel();
            this.jt_ingeschrevenM.setModel(masterclassModel);

            String query = "SELECT m.m_code, m.naam, m.datum, m.tijd, i.betaald FROM masterclass m JOIN masterclass_inschrijvingen i ON m.m_code = i.masterclass_code "
                    + "WHERE m_code IN(SELECT masterclass_code FROM masterclass_inschrijvingen JOIN persoon ON masterclass_inschrijvingen.persoon_code = persoon.p_code WHERE persoon.p_code = ?) "
                    + "GROUP BY m_code;";

            PreparedStatement statementToernooi = connection.prepareStatement(query);
            statementToernooi.setInt(1, pCode);

            ResultSet resultToernooi = statementToernooi.executeQuery();

            while (resultToernooi.next()) {
                int m_code = resultToernooi.getInt("m.m_code");
                String naam = resultToernooi.getString("m.naam");
                String datum = resultToernooi.getString("m.datum");
                String betaaldString = resultToernooi.getString("i.betaald");
                String tijd = resultToernooi.getString("m.tijd");

                if (betaaldString.equals("j")) {
                    betaald = true;
                } else if (betaaldString.equals("n")) {
                    betaald = false;
                }

                Object[] rij = {m_code, naam, datum, tijd, betaald};
                masterclassModel.addRow(rij);

            }

        } catch (SQLException ex) {
            Logger.getLogger(SpelerZoeken.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void vulToernooiModel(int pCode) {
        boolean betaald = true;
        try {
            MasterclassTableModel toernooiModel = createToernooiModel();
            this.jt_ingeschrevenT.setModel(toernooiModel);

            String query = "SELECT t.t_code, t.plaats, t.datum, t.tijd, i.betaald FROM toernooi t JOIN toernooi_inschrijvingen i ON t.t_code = i.toernooi_code "
                    + "WHERE t_code IN(SELECT toernooi_code FROM toernooi_inschrijvingen JOIN persoon ON toernooi_inschrijvingen.persoon_code = persoon.p_code WHERE persoon.p_code = ?) "
                    + "GROUP BY t_code;";

            PreparedStatement statementToernooi = connection.prepareStatement(query);
            statementToernooi.setInt(1, pCode);

            ResultSet resultToernooi = statementToernooi.executeQuery();

            while (resultToernooi.next()) {
                int t_code = resultToernooi.getInt("t.t_code");
                String plaats = resultToernooi.getString("t.plaats");
                String datum = resultToernooi.getString("t.datum");
                String betaaldString = resultToernooi.getString("i.betaald");
                String tijd = resultToernooi.getString("t.tijd");

                if (betaaldString.equals("j")) {
                    betaald = true;
                } else if (betaaldString.equals("n")) {
                    betaald = false;
                }

                Object[] rij = {t_code, plaats, datum, tijd, betaald};
                toernooiModel.addRow(rij);

            }

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

    private String getBetaaldMasterclass(int mCode, int pCode) {
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

    private String getBetaaldToernooi(int tCode, int pCode) {
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

    private TableModel createSpelerModel() {
        TableModel model = new TableModel();
        model.addColumn("speler code");
        model.addColumn("voornaam");
        model.addColumn("achternaam");
        model.addColumn("postcode");
        model.addColumn("rating");
        return model;
    }

    private MasterclassTableModel createToernooiModel() {
        MasterclassTableModel model = new MasterclassTableModel();
        model.addColumn("Toernooi code");
        model.addColumn("Plaats");
        model.addColumn("Datum");
        model.addColumn("Tijd");
        model.addColumn("Betaald");
        return model;
    }

    private MasterclassTableModel createMasterclassModel() {
        MasterclassTableModel model = new MasterclassTableModel();
        model.addColumn("Masterclass code");
        model.addColumn("Soort");
        model.addColumn("Datum");
        model.addColumn("Tijd");
        model.addColumn("Betaald");
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

        jf_spelerInfo = new javax.swing.JFrame();
        jl_achternaamSI = new javax.swing.JLabel();
        jl_voornaamSI = new javax.swing.JLabel();
        jl_adresSI = new javax.swing.JLabel();
        jl_woonplaatsSI = new javax.swing.JLabel();
        jl_postcodeSI = new javax.swing.JLabel();
        jl_telefoonnummerSI = new javax.swing.JLabel();
        jl_emailSI = new javax.swing.JLabel();
        jl_ratingSI = new javax.swing.JLabel();
        jl_agt = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jt_ingeschrevenT = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jt_ingeschrevenM = new javax.swing.JTable();
        jl_pcode = new javax.swing.JLabel();
        jl_pcodeSI2 = new javax.swing.JLabel();
        jb_cancelSI = new javax.swing.JButton();
        jb_update = new javax.swing.JButton();
        rb_toernooi = new javax.swing.JRadioButton();
        rb_masterclass = new javax.swing.JRadioButton();
        buttonGroup1 = new javax.swing.ButtonGroup();
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

        jf_spelerInfo.setMinimumSize(new java.awt.Dimension(650, 460));
        jf_spelerInfo.setPreferredSize(new java.awt.Dimension(650, 460));

        jl_achternaamSI.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jl_achternaamSI.setText("Achternaam");

        jl_voornaamSI.setText("voornaam");

        jl_adresSI.setText("Adres");

        jl_woonplaatsSI.setText("Woonplaats");

        jl_postcodeSI.setText("Postcode");

        jl_telefoonnummerSI.setText("Telefoonnummer");

        jl_emailSI.setText("Email");

        jl_ratingSI.setText("Rating");

        jl_agt.setText("Aantal gewonnen Toernooien");

        jt_ingeschrevenT.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jt_ingeschrevenT);

        jt_ingeschrevenM.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jt_ingeschrevenM);

        jl_pcode.setText("p_code");

        jl_pcodeSI2.setText("persoon code:");

        jb_cancelSI.setText("Cancel");
        jb_cancelSI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_cancelSIActionPerformed(evt);
            }
        });

        jb_update.setText("Update");
        jb_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_updateActionPerformed(evt);
            }
        });

        buttonGroup1.add(rb_toernooi);
        rb_toernooi.setText("Betaling Toernooi");
        rb_toernooi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_toernooiActionPerformed(evt);
            }
        });

        buttonGroup1.add(rb_masterclass);
        rb_masterclass.setText("Betaling Masterclass");
        rb_masterclass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_masterclassActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jf_spelerInfoLayout = new javax.swing.GroupLayout(jf_spelerInfo.getContentPane());
        jf_spelerInfo.getContentPane().setLayout(jf_spelerInfoLayout);
        jf_spelerInfoLayout.setHorizontalGroup(
            jf_spelerInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jf_spelerInfoLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jf_spelerInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jl_ratingSI)
                    .addComponent(jl_agt)
                    .addGroup(jf_spelerInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jf_spelerInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jl_voornaamSI)
                            .addComponent(jl_achternaamSI, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jl_adresSI)
                            .addComponent(jl_woonplaatsSI)
                            .addComponent(jl_telefoonnummerSI)
                            .addComponent(jl_emailSI))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jf_spelerInfoLayout.createSequentialGroup()
                            .addComponent(jl_pcodeSI2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jl_pcode)))
                    .addComponent(jl_postcodeSI))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                .addGroup(jf_spelerInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rb_masterclass)
                    .addGroup(jf_spelerInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jf_spelerInfoLayout.createSequentialGroup()
                        .addComponent(jb_update)
                        .addGap(262, 262, 262)
                        .addComponent(jb_cancelSI))
                    .addComponent(rb_toernooi))
                .addContainerGap())
        );
        jf_spelerInfoLayout.setVerticalGroup(
            jf_spelerInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jf_spelerInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jf_spelerInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jf_spelerInfoLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(jb_update)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rb_toernooi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rb_masterclass)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addComponent(jb_cancelSI))
                    .addGroup(jf_spelerInfoLayout.createSequentialGroup()
                        .addComponent(jl_achternaamSI, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jl_voornaamSI)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jf_spelerInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jl_pcode)
                            .addComponent(jl_pcodeSI2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jl_adresSI)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jl_woonplaatsSI)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jl_postcodeSI)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jl_telefoonnummerSI)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jl_emailSI)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jl_ratingSI)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jl_agt)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(650, 350));
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
        jt_speler.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jt_spelerMousePressed(evt);
            }
        });
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

        Toernooi toernooi = new Toernooi();
        toernooi.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_jb_toernooiActionPerformed

    private void jb_tafelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_tafelActionPerformed
        Tafel ta = new Tafel();
        ta.setVisible(true);
    }//GEN-LAST:event_jb_tafelActionPerformed

    private void jb_masterclassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_masterclassActionPerformed
        Masterclass mc = new Masterclass();
        mc.setVisible(true);
    }//GEN-LAST:event_jb_masterclassActionPerformed

    private void jt_spelerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jt_spelerMousePressed
        if (evt.getClickCount() == 2) {
            int rij = jt_speler.getSelectedRow();
            if (rij > -1) {
                int selectedPCode = (Integer) jt_speler.getValueAt(rij, 0);
                jf_spelerInfo.setVisible(true);
                vulSpelerInfo(selectedPCode);
                vulToernooiModel(selectedPCode);
                vulMasterclassModel(selectedPCode);
            }
        }
    }//GEN-LAST:event_jt_spelerMousePressed

    private void rb_masterclassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_masterclassActionPerformed
        jb_update.isEnabled();
    }//GEN-LAST:event_rb_masterclassActionPerformed

    private void rb_toernooiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_toernooiActionPerformed
        jb_update.isEnabled();
    }//GEN-LAST:event_rb_toernooiActionPerformed

    private void jb_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_updateActionPerformed

        if (rb_masterclass.isSelected()) {
            int selectedRowM = jt_ingeschrevenM.getSelectedRow();

            if (selectedRowM > -1) {
                Boolean betaald = (Boolean) jt_ingeschrevenM.getValueAt(selectedRowM, 4);
                String selectedPCodeString = jl_pcode.getText();
                int selectedPCode = Integer.parseInt(selectedPCodeString);
                int selectedMCode = (Integer) jt_ingeschrevenM.getValueAt(selectedRowM, 0);
                String betaaldState = getBetaaldMasterclass(selectedMCode, selectedPCode);
                System.out.println(betaaldState);
                System.out.println(selectedPCode);
                System.out.println(selectedMCode);

                if (betaald && betaaldState.equals("n")) {
                    try {
                        String query = "update masterclass_inschrijvingen set betaald = 'j' where masterclass_code = ? and persoon_code = ?;";
                        PreparedStatement statementUpdateBetaald = connection.prepareStatement(query);
                        statementUpdateBetaald.setInt(1, selectedMCode);
                        statementUpdateBetaald.setInt(2, selectedPCode);

                        statementUpdateBetaald.execute();

                    } catch (SQLException ex) {
                        Logger.getLogger(Masterclass.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (betaald && betaaldState.equals("j") || !betaald && betaaldState.equals("n") || !betaald && betaaldState.equals("j")) {
                    JOptionPane.showMessageDialog(null, "Aanpassing niet toegestaan!");
                }
                vulMasterclassModel(selectedPCode);
            }
        } else if (rb_toernooi.isSelected()) {
            int selectedRowT = jt_ingeschrevenT.getSelectedRow();

            if (selectedRowT > -1) {
                Boolean betaald = (Boolean) jt_ingeschrevenT.getValueAt(selectedRowT, 4);
                String selectedPCodeString = jl_pcode.getText();
                int selectedPCode = Integer.parseInt(selectedPCodeString);
                int selectedTCode = (Integer) jt_ingeschrevenT.getValueAt(selectedRowT, 0);
                String betaaldState = getBetaaldToernooi(selectedTCode, selectedPCode);
                System.out.println(betaaldState);
                System.out.println(selectedPCode);
                System.out.println(selectedTCode);

                if (betaald && betaaldState.equals("n")) {
                    try {
                        String query = "update toernooi_inschrijvingen set betaald = 'j' where toernooi_code = ? and persoon_code = ?;";
                        PreparedStatement statementUpdateBetaald = connection.prepareStatement(query);
                        statementUpdateBetaald.setInt(1, selectedTCode);
                        statementUpdateBetaald.setInt(2, selectedPCode);

                        statementUpdateBetaald.execute();

                        t.tellenIngelegdGeld(selectedTCode);
                    } catch (SQLException ex) {
                        Logger.getLogger(Masterclass.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (betaald && betaaldState.equals("j") || !betaald && betaaldState.equals("n") || !betaald && betaaldState.equals("j")) {
                    JOptionPane.showMessageDialog(null, "Aanpassing niet toegestaan!");
                    t.tellenIngelegdGeld(selectedTCode);
                }
                vulToernooiModel(selectedPCode);
            } else {
                System.out.println("Geen focues");
            }
        }
    }//GEN-LAST:event_jb_updateActionPerformed

    private void jb_cancelSIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_cancelSIActionPerformed
        jf_spelerInfo.dispose();
    }//GEN-LAST:event_jb_cancelSIActionPerformed

    /**
     * @param args the command line arguments
     */
    class TableModel extends DefaultTableModel {

        public boolean isCellEditable(int row, int column) {
            return false;
        }
    }

    class MasterclassTableModel extends DefaultTableModel {

        @Override
        public boolean isCellEditable(int row, int column) {
            return (column == 4);
        }

        @Override
        public Class getColumnClass(int columnIndex) {
            return (columnIndex == 4) ? Boolean.class : super.getColumnClass(columnIndex);
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
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton jb_cancel;
    private javax.swing.JButton jb_cancelSI;
    private javax.swing.JButton jb_masterclass;
    private javax.swing.JButton jb_tafel;
    private javax.swing.JButton jb_toernooi;
    private javax.swing.JButton jb_update;
    private javax.swing.JFrame jf_spelerInfo;
    private javax.swing.JLabel jl_achternaam;
    private javax.swing.JLabel jl_achternaamSI;
    private javax.swing.JLabel jl_adresSI;
    private javax.swing.JLabel jl_agt;
    private javax.swing.JLabel jl_emailSI;
    private javax.swing.JLabel jl_pcode;
    private javax.swing.JLabel jl_pcodeSI2;
    private javax.swing.JLabel jl_postcodeSI;
    private javax.swing.JLabel jl_ratingSI;
    private javax.swing.JLabel jl_spelersCode;
    private javax.swing.JLabel jl_telefoonnummerSI;
    private javax.swing.JLabel jl_voornaam;
    private javax.swing.JLabel jl_voornaamSI;
    private javax.swing.JLabel jl_woonplaatsSI;
    private javax.swing.JTable jt_ingeschrevenM;
    private javax.swing.JTable jt_ingeschrevenT;
    private javax.swing.JTable jt_speler;
    private javax.swing.JRadioButton rb_masterclass;
    private javax.swing.JRadioButton rb_toernooi;
    private javax.swing.JTextField tf_achternaam;
    private javax.swing.JTextField tf_spelersCode;
    private javax.swing.JTextField tf_voornaam;
    // End of variables declaration//GEN-END:variables
}
