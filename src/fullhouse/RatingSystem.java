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

            String query = "select p_code, voornaam, achternaam, rating from persoon where p_code like ?" +
                            "and achternaam like ?;";

            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, getZoekRating());
            statement.setString(2, getZoekTermAchternaam());

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
        String text2 = t_spelerCode.getText();
        if (text2.length() == 0) {
            return "%";
        } else {
            return "%" + text2 + "%";
        }
    }
    
    private String getZoekTermAchternaam() {
        String text2 = t_achternaam.getText();
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
    private int nieuweRating3;
    private int nieuweRating4;
    private int nieuweRating5;
    private int nieuweRating6;
    private int nieuweRating7;
    private int nieuweRating8;
    private double expScore;
    private int score = 1;
    private int constant = 20;

    private void berekenRating() {

        String oudeRatingString = j_rating1.getText();
        String oudeRatingString2 = j_rating2.getText();
        String oudeRatingString3 = j_rating3.getText();
        String oudeRatingString4 = j_rating4.getText();
        String oudeRatingString5 = j_rating5.getText();
        String oudeRatingString6 = j_rating6.getText();
        String oudeRatingString7 = j_rating7.getText();
        String oudeRatingString8 = j_rating8.getText();


        int oudeRating = Integer.parseInt(oudeRatingString);
        int oudeRating2 = Integer.parseInt(oudeRatingString2);
        int oudeRating3 = Integer.parseInt(oudeRatingString3);
        int oudeRating4 = Integer.parseInt(oudeRatingString4);
        int oudeRating5 = Integer.parseInt(oudeRatingString5);
        int oudeRating6 = Integer.parseInt(oudeRatingString6);
        int oudeRating7 = Integer.parseInt(oudeRatingString7);
        int oudeRating8 = Integer.parseInt(oudeRatingString8);

        int maxRating1_8 = Math.max(oudeRating, oudeRating8);
        int minRating1_8 = Math.min(oudeRating, oudeRating8);
        
        int maxRating2_7 = Math.max(oudeRating2, oudeRating7);
        int minRating2_7 = Math.min(oudeRating2, oudeRating7);
        
        int maxRating3_6 = Math.max(oudeRating3, oudeRating6);
        int minRating3_6 = Math.min(oudeRating3, oudeRating6);
        
        int maxRating4_5 = Math.max(oudeRating4, oudeRating5);
        int minRating4_5 = Math.min(oudeRating4, oudeRating5);

        if (maxRating1_8 - minRating1_8 == 0) {
            expScore = 0.5;
        } else if (maxRating1_8 - minRating1_8 <= 21 && maxRating1_8 - minRating1_8 > 0) {
            expScore = 0.53;
        } else if (maxRating1_8 - minRating1_8 <= 41 && maxRating1_8 - minRating1_8 > 20) {
            expScore = 0.58;
        } else if (maxRating1_8 - minRating1_8 <= 61 && maxRating1_8 - minRating1_8 > 40) {
            expScore = 0.62;
        } else if (maxRating1_8 - minRating1_8 <= 81 && maxRating1_8 - minRating1_8 > 60) {
            expScore = 0.66;
        } else if (maxRating1_8 - minRating1_8 <= 101 && maxRating1_8 - minRating1_8 > 80) {
            expScore = 0.69;
        } else if (maxRating1_8 - minRating1_8 <= 121 && maxRating1_8 - minRating1_8 > 100) {
            expScore = 0.73;
        } else if (maxRating1_8 - minRating1_8 <= 141 && maxRating1_8 - minRating1_8 > 120) {
            expScore = 0.76;
        } else if (maxRating1_8 - minRating1_8 <= 161 && maxRating1_8 - minRating1_8 > 140) {
            expScore = 0.79;
        } else if (maxRating1_8 - minRating1_8 <= 181 && maxRating1_8 - minRating1_8 > 160) {
            expScore = 0.82;
        } else if (maxRating1_8 - minRating1_8 <= 201 && maxRating1_8 - minRating1_8 > 180) {
            expScore = 0.84;
        } else if (maxRating1_8 - minRating1_8 <= 301 && maxRating1_8 - minRating1_8 > 200) {
            expScore = 0.93;
        } else if (maxRating1_8 - minRating1_8 <= 401 && maxRating1_8 - minRating1_8 > 300) {
            expScore = 0.97;
        }
        
        if (maxRating2_7 - minRating2_7 == 0) {
            expScore = 0.5;
        } else if (maxRating2_7 - minRating2_7 <= 21 && maxRating2_7 - minRating2_7 > 0) {
            expScore = 0.53;
        } else if (maxRating2_7 - minRating2_7 <= 41 && maxRating2_7 - minRating2_7 > 20) {
            expScore = 0.58;
        } else if (maxRating2_7 - minRating2_7 <= 61 && maxRating2_7 - minRating2_7 > 40) {
            expScore = 0.62;
        } else if (maxRating2_7 - minRating2_7 <= 81 && maxRating2_7 - minRating2_7 > 60) {
            expScore = 0.66;
        } else if (maxRating2_7 - minRating2_7 <= 101 && maxRating2_7 - minRating2_7 > 80) {
            expScore = 0.69;
        } else if (maxRating2_7 - minRating2_7 <= 121 && maxRating2_7 - minRating2_7 > 100) {
            expScore = 0.73;
        } else if (maxRating2_7 - minRating2_7 <= 141 && maxRating2_7 - minRating2_7 > 120) {
            expScore = 0.76;
        } else if (maxRating2_7 - minRating2_7 <= 161 && maxRating2_7 - minRating2_7 > 140) {
            expScore = 0.79;
        } else if (maxRating2_7 - minRating2_7 <= 181 && maxRating2_7 - minRating2_7 > 160) {
            expScore = 0.82;
        } else if (maxRating2_7 - minRating2_7 <= 201 && maxRating2_7 - minRating2_7 > 180) {
            expScore = 0.84;
        } else if (maxRating2_7 - minRating2_7 <= 301 && maxRating2_7 - minRating2_7 > 200) {
            expScore = 0.93;
        } else if (maxRating2_7 - minRating2_7 <= 401 && maxRating2_7 - minRating2_7 > 300) {
            expScore = 0.97;
        }
        
        if (maxRating3_6 - minRating3_6 == 0) {
            expScore = 0.5;
        } else if (maxRating3_6 - minRating3_6 <= 21 && maxRating3_6 - minRating3_6 > 0) {
            expScore = 0.53;
        } else if (maxRating3_6 - minRating3_6 <= 41 && maxRating3_6 - minRating3_6 > 20) {
            expScore = 0.58;
        } else if (maxRating3_6 - minRating3_6 <= 61 && maxRating3_6 - minRating3_6 > 40) {
            expScore = 0.62;
        } else if (maxRating3_6 - minRating3_6 <= 81 && maxRating3_6 - minRating3_6 > 60) {
            expScore = 0.66;
        } else if (maxRating3_6 - minRating3_6 <= 101 && maxRating3_6 - minRating3_6 > 80) {
            expScore = 0.69;
        } else if (maxRating3_6 - minRating3_6 <= 121 && maxRating3_6 - minRating3_6 > 100) {
            expScore = 0.73;
        } else if (maxRating3_6 - minRating3_6 <= 141 && maxRating3_6 - minRating3_6 > 120) {
            expScore = 0.76;
        } else if (maxRating3_6 - minRating3_6 <= 161 && maxRating3_6 - minRating3_6 > 140) {
            expScore = 0.79;
        } else if (maxRating3_6 - minRating3_6 <= 181 && maxRating3_6 - minRating3_6 > 160) {
            expScore = 0.82;
        } else if (maxRating3_6 - minRating3_6 <= 201 && maxRating3_6 - minRating3_6 > 180) {
            expScore = 0.84;
        } else if (maxRating3_6 - minRating3_6 <= 301 && maxRating3_6 - minRating3_6 > 200) {
            expScore = 0.93;
        } else if (maxRating3_6 - minRating3_6 <= 401 && maxRating3_6 - minRating3_6 > 300) {
            expScore = 0.97;
        }
        
        if (maxRating4_5 - minRating4_5 == 0) {
            expScore = 0.5;
        } else if (maxRating4_5 - minRating4_5 <= 21 && maxRating4_5 - minRating4_5 > 0) {
            expScore = 0.53;
        } else if (maxRating4_5 - minRating4_5 <= 41 && maxRating4_5 - minRating4_5 > 20) {
            expScore = 0.58;
        } else if (maxRating4_5 - minRating4_5 <= 61 && maxRating4_5 - minRating4_5 > 40) {
            expScore = 0.62;
        } else if (maxRating4_5 - minRating4_5 <= 81 && maxRating4_5 - minRating4_5 > 60) {
            expScore = 0.66;
        } else if (maxRating4_5 - minRating4_5 <= 101 && maxRating4_5 - minRating4_5 > 80) {
            expScore = 0.69;
        } else if (maxRating4_5 - minRating4_5 <= 121 && maxRating4_5 - minRating4_5 > 100) {
            expScore = 0.73;
        } else if (maxRating4_5 - minRating4_5 <= 141 && maxRating4_5 - minRating4_5 > 120) {
            expScore = 0.76;
        } else if (maxRating4_5 - minRating4_5 <= 161 && maxRating4_5 - minRating4_5 > 140) {
            expScore = 0.79;
        } else if (maxRating4_5 - minRating4_5 <= 181 && maxRating4_5 - minRating4_5 > 160) {
            expScore = 0.82;
        } else if (maxRating4_5 - minRating4_5 <= 201 && maxRating4_5 - minRating4_5 > 180) {
            expScore = 0.84;
        } else if (maxRating4_5 - minRating4_5 <= 301 && maxRating4_5 - minRating4_5 > 200) {
            expScore = 0.93;
        } else if (maxRating4_5 - minRating4_5 <= 401 && maxRating4_5 - minRating4_5 > 300) {
            expScore = 0.97;
        }

        double opafRating = constant * (score - expScore);



        nieuweRating1 = (int) (oudeRating + opafRating);
        nieuweRating2 = (int) (oudeRating2 + opafRating);
        nieuweRating3 = (int) (oudeRating3 + opafRating);
        nieuweRating4 = (int) (oudeRating4 + opafRating);
        nieuweRating5 = (int) (oudeRating5 - opafRating);
        nieuweRating6 = (int) (oudeRating6 - opafRating);
        nieuweRating7 = (int) (oudeRating7 - opafRating);
        nieuweRating8 = (int) (oudeRating8 - opafRating);
        j_nrating1.setText("" + nieuweRating1 + "");
        j_nrating2.setText("" + nieuweRating2 + "");
        j_nrating3.setText("" + nieuweRating3 + "");
        j_nrating4.setText("" + nieuweRating4 + "");
        j_nrating5.setText("" + nieuweRating5 + "");
        j_nrating6.setText("" + nieuweRating6 + "");
        j_nrating7.setText("" + nieuweRating7 + "");
        j_nrating8.setText("" + nieuweRating8 + "");
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
            
            try {
            
            String p_code = r_Speler3.getText();
                int p_codeint = Integer.parseInt(p_code);
                String query = "UPDATE persoon "
                            + "SET rating = ? WHERE p_code like ?;";
                    
                    PreparedStatement persoonStatement = connection.prepareStatement(query);

                    persoonStatement.setInt(1, nieuweRating3);
                    persoonStatement.setInt(2, p_codeint);

                    persoonStatement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(RatingSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            try {
            
            String p_code = r_Speler4.getText();
                int p_codeint = Integer.parseInt(p_code);
                String query = "UPDATE persoon "
                            + "SET rating = ? WHERE p_code like ?;";
                    
                    PreparedStatement persoonStatement = connection.prepareStatement(query);

                    persoonStatement.setInt(1, nieuweRating4);
                    persoonStatement.setInt(2, p_codeint);

                    persoonStatement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(RatingSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            try {
            
            String p_code = r_Speler5.getText();
                int p_codeint = Integer.parseInt(p_code);
                String query = "UPDATE persoon "
                            + "SET rating = ? WHERE p_code like ?;";
                    
                    PreparedStatement persoonStatement = connection.prepareStatement(query);

                    persoonStatement.setInt(1, nieuweRating5);
                    persoonStatement.setInt(2, p_codeint);

                    persoonStatement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(RatingSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            try {
            
            String p_code = r_Speler6.getText();
                int p_codeint = Integer.parseInt(p_code);
                String query = "UPDATE persoon "
                            + "SET rating = ? WHERE p_code like ?;";
                    
                    PreparedStatement persoonStatement = connection.prepareStatement(query);

                    persoonStatement.setInt(1, nieuweRating6);
                    persoonStatement.setInt(2, p_codeint);

                    persoonStatement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(RatingSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            try {
            
            String p_code = r_Speler7.getText();
                int p_codeint = Integer.parseInt(p_code);
                String query = "UPDATE persoon "
                            + "SET rating = ? WHERE p_code like ?;";
                    
                    PreparedStatement persoonStatement = connection.prepareStatement(query);

                    persoonStatement.setInt(1, nieuweRating7);
                    persoonStatement.setInt(2, p_codeint);

                    persoonStatement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(RatingSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            try {
            
            String p_code = r_Speler8.getText();
                int p_codeint = Integer.parseInt(p_code);
                String query = "UPDATE persoon "
                            + "SET rating = ? WHERE p_code like ?;";
                    
                    PreparedStatement persoonStatement = connection.prepareStatement(query);

                    persoonStatement.setInt(1, nieuweRating8);
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

        b_ok = new javax.swing.JButton();
        l_1ste = new javax.swing.JLabel();
        t_spelerCode = new javax.swing.JTextField();
        r_Speler2 = new javax.swing.JTextField();
        l_2de = new javax.swing.JLabel();
        l_nieuw1 = new javax.swing.JLabel();
        j_nrating1 = new javax.swing.JTextField();
        l_oudeRating = new javax.swing.JLabel();
        j_rating1 = new javax.swing.JTextField();
        j_rating2 = new javax.swing.JTextField();
        l_nieuw2 = new javax.swing.JLabel();
        j_nrating2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        j_spelerTabel = new javax.swing.JTable();
        l_pcode = new javax.swing.JLabel();
        r_Speler1 = new javax.swing.JTextField();
        j_rating5 = new javax.swing.JTextField();
        j_rating6 = new javax.swing.JTextField();
        j_rating4 = new javax.swing.JTextField();
        j_rating3 = new javax.swing.JTextField();
        j_rating8 = new javax.swing.JTextField();
        j_rating7 = new javax.swing.JTextField();
        r_Speler8 = new javax.swing.JTextField();
        l_8ste = new javax.swing.JLabel();
        l_1pijltje8 = new javax.swing.JLabel();
        r_Speler3 = new javax.swing.JTextField();
        r_Speler4 = new javax.swing.JTextField();
        r_Speler5 = new javax.swing.JTextField();
        r_Speler7 = new javax.swing.JTextField();
        r_Speler6 = new javax.swing.JTextField();
        l_7de = new javax.swing.JLabel();
        l_6de = new javax.swing.JLabel();
        l_5de = new javax.swing.JLabel();
        l_3de = new javax.swing.JLabel();
        l_4de = new javax.swing.JLabel();
        l_2pijltje7 = new javax.swing.JLabel();
        l_3pijltje6 = new javax.swing.JLabel();
        l_4pijltje5 = new javax.swing.JLabel();
        l_plaatsRonde = new javax.swing.JLabel();
        l_nieuweRating = new javax.swing.JLabel();
        j_nrating4 = new javax.swing.JTextField();
        j_nrating8 = new javax.swing.JTextField();
        j_nrating7 = new javax.swing.JTextField();
        j_nrating6 = new javax.swing.JTextField();
        j_nrating5 = new javax.swing.JTextField();
        j_nrating3 = new javax.swing.JTextField();
        l_nieuw3 = new javax.swing.JLabel();
        l_nieuw4 = new javax.swing.JLabel();
        l_nieuw5 = new javax.swing.JLabel();
        l_nieuw6 = new javax.swing.JLabel();
        l_nieuw7 = new javax.swing.JLabel();
        l_nieuw8 = new javax.swing.JLabel();
        l_1oud = new javax.swing.JLabel();
        l_2oud = new javax.swing.JLabel();
        l_oud5 = new javax.swing.JLabel();
        l_oud4 = new javax.swing.JLabel();
        l_oud3 = new javax.swing.JLabel();
        l_oud6 = new javax.swing.JLabel();
        l_oud7 = new javax.swing.JLabel();
        l_oud8 = new javax.swing.JLabel();
        l_achternaam = new javax.swing.JLabel();
        t_achternaam = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        b_ok.setText("OK!");
        b_ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_okActionPerformed(evt);
            }
        });

        l_1ste.setText("1.");

        t_spelerCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_spelerCodeActionPerformed(evt);
            }
        });
        t_spelerCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t_spelerCodeKeyReleased(evt);
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

        l_2de.setText("2.");

        l_nieuw1.setText("1.");

        j_nrating1.setEditable(false);

        l_oudeRating.setText("Oude rating:");

        j_rating1.setEditable(false);

        j_rating2.setEditable(false);

        l_nieuw2.setText("2.");

        j_nrating2.setEditable(false);

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

        l_pcode.setText("Spelerscode:");

        r_Speler1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_Speler1ActionPerformed(evt);
            }
        });

        j_rating5.setEditable(false);

        j_rating6.setEditable(false);
        j_rating6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j_rating6ActionPerformed(evt);
            }
        });

        j_rating4.setEditable(false);
        j_rating4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j_rating4ActionPerformed(evt);
            }
        });

        j_rating3.setEditable(false);

        j_rating8.setEditable(false);
        j_rating8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j_rating8ActionPerformed(evt);
            }
        });

        j_rating7.setEditable(false);

        l_8ste.setText("8.");

        l_1pijltje8.setText("<-->");

        l_7de.setText("7.");

        l_6de.setText("6.");

        l_5de.setText("5.");

        l_3de.setText("3.");

        l_4de.setText("4.");

        l_2pijltje7.setText("<-->");

        l_3pijltje6.setText("<-->");

        l_4pijltje5.setText("<-->");

        l_plaatsRonde.setText("Plaats in de ronde:");

        l_nieuweRating.setText("Nieuwe rating:");

        j_nrating4.setEditable(false);

        j_nrating8.setEditable(false);

        j_nrating7.setEditable(false);

        j_nrating6.setEditable(false);

        j_nrating5.setEditable(false);

        j_nrating3.setEditable(false);

        l_nieuw3.setText("3.");

        l_nieuw4.setText("4.");

        l_nieuw5.setText("5.");

        l_nieuw6.setText("6.");

        l_nieuw7.setText("7.");

        l_nieuw8.setText("8.");

        l_1oud.setText("1.");

        l_2oud.setText("2.");

        l_oud5.setText("5.");

        l_oud4.setText("4.");

        l_oud3.setText("3.");

        l_oud6.setText("6.");

        l_oud7.setText("7.");

        l_oud8.setText("8.");

        l_achternaam.setText("Achternaam");

        t_achternaam.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t_achternaamKeyReleased(evt);
            }
        });

        jButton1.setText("Cancel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(l_plaatsRonde)
                                .addGap(111, 111, 111))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(l_nieuw3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(j_nrating3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(l_nieuw1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(j_nrating1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(l_nieuw2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(j_nrating2))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(l_nieuw4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(j_nrating4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(l_nieuw5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(j_nrating5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(l_nieuw6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(j_nrating6, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(l_nieuw7)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(j_nrating7, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(l_nieuw8)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(j_nrating8, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(b_ok)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(l_2de)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(r_Speler2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(l_1ste)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(r_Speler1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(l_3de)
                                                            .addComponent(l_4de))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                            .addComponent(r_Speler4, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                                                            .addComponent(r_Speler3))))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(l_1pijltje8)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(l_8ste))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(l_2pijltje7)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(l_7de))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(l_3pijltje6)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(l_6de))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(l_4pijltje5)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(l_5de)))))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(r_Speler6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(r_Speler7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(r_Speler8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(r_Speler5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(l_1oud, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(l_2oud, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(l_oud3, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(l_oud4, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(l_oudeRating)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(j_rating2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(j_rating4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(j_rating3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(j_rating1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(l_oud5)
                                            .addComponent(l_oud6)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(l_oud8)
                                            .addComponent(l_oud7))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(j_rating6, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(j_rating5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(j_rating8, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(j_rating7, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                    .addComponent(l_nieuweRating)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(l_pcode)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(t_spelerCode, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(l_achternaam)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(t_achternaam))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(l_pcode)
                            .addComponent(t_spelerCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(l_achternaam)
                            .addComponent(t_achternaam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(l_plaatsRonde, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(l_oudeRating))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(l_1ste)
                                            .addComponent(r_Speler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(r_Speler2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(l_2de))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(l_3de)
                                            .addComponent(r_Speler3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(r_Speler4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(l_4de)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(l_8ste)
                                            .addComponent(l_1pijltje8)
                                            .addComponent(r_Speler8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(r_Speler7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(l_7de))
                                            .addComponent(l_2pijltje7))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(r_Speler6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(l_6de)
                                            .addComponent(l_3pijltje6))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(r_Speler5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(l_5de)
                                            .addComponent(l_4pijltje5))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b_ok)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                                .addComponent(l_nieuweRating)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(l_nieuw1)
                                    .addComponent(j_nrating1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(j_nrating5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(l_nieuw5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(l_nieuw2)
                                    .addComponent(j_nrating2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(j_nrating6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(l_nieuw6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(j_nrating3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(j_nrating7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(l_nieuw3)
                                    .addComponent(l_nieuw7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(j_nrating4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(j_nrating8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(l_nieuw4)
                                    .addComponent(l_nieuw8))
                                .addGap(27, 27, 27)
                                .addComponent(jButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(j_rating1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(j_rating5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(l_1oud)
                                    .addComponent(l_oud5))
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(j_rating6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(l_2oud)
                                    .addComponent(j_rating2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(l_oud6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(j_rating7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(j_rating8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(j_rating3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(l_oud3)
                                            .addComponent(l_oud7))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(j_rating4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(l_oud4)
                                            .addComponent(l_oud8))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void r_Speler2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_Speler2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_r_Speler2ActionPerformed

    private void b_okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_okActionPerformed
            String p_code = r_Speler1.getText();
            int p_codeint = Integer.parseInt(p_code);
            int rating = getRating(p_codeint);
            String ratingString = String.valueOf(rating);
            j_rating1.setText(ratingString);
            
            String p_code2 = r_Speler2.getText();
            int p_codeint2 = Integer.parseInt(p_code2);
            int rating2 = getRating(p_codeint2);
            String ratingString2 = String.valueOf(rating2);
            j_rating2.setText(ratingString2);
            
            String p_code3 = r_Speler3.getText();
            int p_codeint3 = Integer.parseInt(p_code3);
            int rating3 = getRating(p_codeint3);
            String ratingString3 = String.valueOf(rating3);
            j_rating3.setText(ratingString3);
            
            String p_code4 = r_Speler4.getText();
            int p_codeint4 = Integer.parseInt(p_code4);
            int rating4 = getRating(p_codeint4);
            String ratingString4 = String.valueOf(rating4);
            j_rating4.setText(ratingString4);
            
            String p_code5 = r_Speler5.getText();
            int p_codeint5 = Integer.parseInt(p_code5);
            int rating5 = getRating(p_codeint5);
            String ratingString5 = String.valueOf(rating5);
            j_rating5.setText(ratingString5);
            
            String p_code6 = r_Speler6.getText();
            int p_codeint6 = Integer.parseInt(p_code6);
            int rating6 = getRating(p_codeint6);
            String ratingString6 = String.valueOf(rating6);
            j_rating6.setText(ratingString6);
            
            String p_code7 = r_Speler7.getText();
            int p_codeint7 = Integer.parseInt(p_code7);
            int rating7 = getRating(p_codeint7);
            String ratingString7 = String.valueOf(rating7);
            j_rating7.setText(ratingString7);
            
            String p_code8 = r_Speler8.getText();
            int p_codeint8 = Integer.parseInt(p_code8);
            int rating8 = getRating(p_codeint8);
            String ratingString8 = String .valueOf(rating8);
            j_rating8.setText(ratingString8);
            
            
            berekenRating();
            updateRating();
            vulSpelerTabel();

    }//GEN-LAST:event_b_okActionPerformed

    private void t_spelerCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_spelerCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_spelerCodeActionPerformed

    private void t_spelerCodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_spelerCodeKeyReleased

        this.vulSpelerTabel();
        // TODO add your handling code here:
    }//GEN-LAST:event_t_spelerCodeKeyReleased

    private void r_Speler2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_r_Speler2FocusGained
    }//GEN-LAST:event_r_Speler2FocusGained

    private void j_rating6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_j_rating6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_j_rating6ActionPerformed

    private void j_rating4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_j_rating4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_j_rating4ActionPerformed

    private void j_rating8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_j_rating8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_j_rating8ActionPerformed

    private void r_Speler1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_Speler1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_r_Speler1ActionPerformed

    private void t_achternaamKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_achternaamKeyReleased
        this.vulSpelerTabel();
    }//GEN-LAST:event_t_achternaamKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
    private javax.swing.JButton b_ok;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField j_nrating1;
    private javax.swing.JTextField j_nrating2;
    private javax.swing.JTextField j_nrating3;
    private javax.swing.JTextField j_nrating4;
    private javax.swing.JTextField j_nrating5;
    private javax.swing.JTextField j_nrating6;
    private javax.swing.JTextField j_nrating7;
    private javax.swing.JTextField j_nrating8;
    private javax.swing.JTextField j_rating1;
    private javax.swing.JTextField j_rating2;
    private javax.swing.JTextField j_rating3;
    private javax.swing.JTextField j_rating4;
    private javax.swing.JTextField j_rating5;
    private javax.swing.JTextField j_rating6;
    private javax.swing.JTextField j_rating7;
    private javax.swing.JTextField j_rating8;
    private javax.swing.JTable j_spelerTabel;
    private javax.swing.JLabel l_1oud;
    private javax.swing.JLabel l_1pijltje8;
    private javax.swing.JLabel l_1ste;
    private javax.swing.JLabel l_2de;
    private javax.swing.JLabel l_2oud;
    private javax.swing.JLabel l_2pijltje7;
    private javax.swing.JLabel l_3de;
    private javax.swing.JLabel l_3pijltje6;
    private javax.swing.JLabel l_4de;
    private javax.swing.JLabel l_4pijltje5;
    private javax.swing.JLabel l_5de;
    private javax.swing.JLabel l_6de;
    private javax.swing.JLabel l_7de;
    private javax.swing.JLabel l_8ste;
    private javax.swing.JLabel l_achternaam;
    private javax.swing.JLabel l_nieuw1;
    private javax.swing.JLabel l_nieuw2;
    private javax.swing.JLabel l_nieuw3;
    private javax.swing.JLabel l_nieuw4;
    private javax.swing.JLabel l_nieuw5;
    private javax.swing.JLabel l_nieuw6;
    private javax.swing.JLabel l_nieuw7;
    private javax.swing.JLabel l_nieuw8;
    private javax.swing.JLabel l_nieuweRating;
    private javax.swing.JLabel l_oud3;
    private javax.swing.JLabel l_oud4;
    private javax.swing.JLabel l_oud5;
    private javax.swing.JLabel l_oud6;
    private javax.swing.JLabel l_oud7;
    private javax.swing.JLabel l_oud8;
    private javax.swing.JLabel l_oudeRating;
    private javax.swing.JLabel l_pcode;
    private javax.swing.JLabel l_plaatsRonde;
    private javax.swing.JTextField r_Speler1;
    private javax.swing.JTextField r_Speler2;
    private javax.swing.JTextField r_Speler3;
    private javax.swing.JTextField r_Speler4;
    private javax.swing.JTextField r_Speler5;
    private javax.swing.JTextField r_Speler6;
    private javax.swing.JTextField r_Speler7;
    private javax.swing.JTextField r_Speler8;
    private javax.swing.JTextField t_achternaam;
    private javax.swing.JTextField t_spelerCode;
    // End of variables declaration//GEN-END:variables
}
