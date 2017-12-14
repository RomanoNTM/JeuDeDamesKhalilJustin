/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeudedames;

import java.awt.Color;
import static java.lang.Math.abs;
import java.util.ArrayList;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JFrame;
import static jeudedames.Couleur.BLANC;

/**
 *
 * @author Justin
 */
public class Plateau extends JPanel {

    private static final int TAILLE = 10;
    private boolean tourNoir;
    private final Case[][] env;
    private Case caseActive;

    public Plateau() {
        super();
        this.setLayout(new java.awt.GridLayout(TAILLE, TAILLE));
        tourNoir = false;
        env = new Case[TAILLE][TAILLE];
        for (int i = 0; i < TAILLE; i++) {
            for (int j = 0; j < TAILLE; j++) {
                if (i <= 3) {
                    if ((i + j) % 2 == 1) {
                        env[i][j] = new Case(new Pion(Couleur.NOIR), Couleur.NOIR, i, j);
                        this.add(this.env[i][j]);
                        this.env[i][j].addMouseListener(new CaseListener(this.env[i][j], this));
                        //this.getLayout().addLayoutComponent("Case [" + i + ";" + j + "]", this.env[i][j]);
                    } else {
                        env[i][j] = new Case(null, Couleur.BLANC, i, j);
                        this.add(this.env[i][j]);
                        this.env[i][j].addMouseListener(new CaseListener(this.env[i][j], this));
                    }
                } else if (i >= 6) {
                    if ((i + j) % 2 == 1) {
                        env[i][j] = new Case(new Pion(Couleur.BLANC), Couleur.NOIR, i, j);
                        this.add(this.env[i][j]);
                        this.env[i][j].addMouseListener(new CaseListener(this.env[i][j], this));
                    } else {
                        env[i][j] = new Case(null, Couleur.BLANC, i, j);
                        this.add(this.env[i][j]);
                        this.env[i][j].addMouseListener(new CaseListener(this.env[i][j], this));
                    }
                } else {
                    if ((i + j) % 2 == 1) {
                        env[i][j] = new Case(null, Couleur.NOIR, i, j);
                        this.add(this.env[i][j]);
                        this.env[i][j].addMouseListener(new CaseListener(this.env[i][j], this));
                    } else {
                        env[i][j] = new Case(null, Couleur.BLANC, i, j);
                        this.add(this.env[i][j]);
                        this.env[i][j].addMouseListener(new CaseListener(this.env[i][j], this));
                    }
                }
            }
        }
        caseActive = null;
    }

    public boolean deplacer(Case depart, Case arrivee) {
        ArrayList<Case> casesDispo = casesDisponibles(depart);
        int i1 = depart.getI(), i2 = arrivee.getI(), j1 = depart.getJ(), j2 = arrivee.getJ();
        if (depart.getP() != null) {
            if (casesDispo.contains(arrivee)) {
                arrivee.setP(depart.getP(), false);
                depart.setP(null, false);
                if (abs(i1 - i2) > 1 || abs(j1 - j2) > 1) {
                    this.env[(i1 + i2) / 2][(j1 + j2) / 2].setP(null, true);
                }
                caseActive=null;
                return true;
            } else {
                for (Case c1 : casesDispo){
                    c1.setBackground(new Color(0, 153, 204));
                    c1.validate();
                    c1.repaint();
                }
                return false;
            }
        } else {
            for (Case c1 : casesDispo){
                c1.setBackground(new Color(0, 153, 204));
                c1.validate();
                c1.repaint();
            }
            return false;
        }
    }

    public ArrayList<Case> casesDisponibles(Case c) {
        ArrayList<Case> listeCases = new ArrayList<>();

        if (c.getP() != null) {
            Pion p = c.getP();
            int i = c.getI();
            int j = c.getJ();

            if (p.isMonte() || p.isDame()) {
                if (i != 0) {
                    if (j != 0) {
                        if (env[i - 1][j - 1].getP() == null) {
                            listeCases.add(env[i - 1][j - 1]);
                        } else {
                            if (i > 1 && j > 1) {
                                if (env[i - 1][j - 1].getP().getCouleur() != c.getP().getCouleur() && (env[i - 2][j - 2].getP() == null)) {
                                    listeCases.add(env[i - 2][j - 2]);
                                }
                            }
                        }
                    }

                    if (j != TAILLE - 1) {
                        if (env[i - 1][j + 1].getP() == null) {
                            listeCases.add(env[i - 1][j + 1]);
                        } else {
                            if (i > 1 && j < TAILLE - 2) {
                                if (env[i - 1][j + 1].getP().getCouleur() != c.getP().getCouleur() && (null == env[i-2][j+2].getP())) {
                                    listeCases.add(env[i - 2][j + 2]);
                                }
                            }
                        }
                    }
                }
            }
            if (!p.isMonte() || p.isDame()) {
                if (i != TAILLE - 1) {
                    if (j != 0) {
                        if (env[i + 1][j - 1].getP() == null) {
                            listeCases.add(env[i + 1][j - 1]);
                        } else {
                            if (i < TAILLE - 2 && j > 1) {
                                if (env[i + 1][j - 1].getP().getCouleur() != c.getP().getCouleur() && (null == env[i+2][j-2].getP())) {
                                    listeCases.add(env[i + 2][j - 2]);
                                }
                            }
                        }
                    }

                    if (j != TAILLE - 1) {
                        if (env[i + 1][j + 1].getP() == null) {
                            listeCases.add(env[i + 1][j + 1]);
                        } else {
                            if (i < TAILLE - 2 && j < TAILLE - 2) {
                                if (env[i + 1][j + 1].getP().getCouleur() != c.getP().getCouleur() && (null == env[i+2][j+2].getP())) {
                                    listeCases.add(env[i + 2][j + 2]);
                                }
                            }
                        }
                    }
                }
            }
        }

        return listeCases;
    }

    void setCaseActive(Case c) {
        if (c.getP() != null){
            if (caseActive == null){
                casesDisponibles(c).stream().map((c1) -> {
                    c1.setBackground(new Color(0, 153, 204));
                    return c1;
                }).map((c1) -> {
                    c1.validate();
                    return c1;
                }).forEachOrdered((c1) -> {
                    c1.repaint();
                });
            } else{
                casesDisponibles(caseActive).stream().map((c1) -> {
                    if (c1.getC() == BLANC){
                        c1.setBackground(Color.WHITE);
                    } else{
                        c1.setBackground(Color.BLACK);
                    }
                    return c1;
                }).map((c1) -> {
                    c1.validate();
                    return c1;
                }).forEachOrdered((c1) -> {
                    c1.repaint();
                });

                casesDisponibles(c).stream().map((c1) -> {
                    c1.setBackground(new Color(0, 153, 204));
                    return c1;
                }).map((c1) -> {
                    c1.validate();
                    return c1;
                }).forEachOrdered((c1) -> {
                    c1.repaint();
                });
            }
        } else{
            if (caseActive != null){
                casesDisponibles(caseActive).stream().map((c1) -> {
                    if (c1.getC() == BLANC){
                        c1.setBackground(Color.WHITE);
                    } else{
                        c1.setBackground(Color.BLACK);
                    }
                    return c1;
                }).map((c1) -> {
                    c1.validate();
                    return c1;
                }).forEachOrdered((c1) -> {
                    c1.repaint();
                });
            }
        }
        
        this.caseActive = c;
    }

    public Case getCaseActive() {
        return caseActive;
    }

}
