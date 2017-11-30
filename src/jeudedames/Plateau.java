/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeudedames;

import static java.lang.Math.abs;
import java.util.ArrayList;
import javax.swing.JPanel;
import java.awt.GridLayout;

/**
 *
 * @author Justin
 */
public class Plateau extends JPanel{

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
                    if ((i+j) % 2 == 1) {
                        env[i][j] = new Case(new Pion(Couleur.NOIR), Couleur.NOIR,i,j);
                        this.add(this.env[i][j]);
                        //this.getLayout().addLayoutComponent("Case [" + i + ";" + j + "]", this.env[i][j]);
                    } else {
                        env[i][j] = new Case(null, Couleur.BLANC,i,j);
                        this.add(this.env[i][j]);
                    }
                } else if (i >= 6) {
                    if ((i+j) % 2 == 1) {
                        env[i][j] = new Case(new Pion(Couleur.BLANC), Couleur.NOIR,i,j);
                        this.add(this.env[i][j]);
                    } else {
                        env[i][j] = new Case(null, Couleur.BLANC,i,j);
                        this.add(this.env[i][j]);
                    }
                } else{
                    if ((i+j)%2 == 1){
                        env[i][j] = new Case(null, Couleur.NOIR, i, j);
                        this.add(this.env[i][j]);
                    } else{
                        env[i][j] = new Case(null, Couleur.BLANC, i, j);
                        this.add(this.env[i][j]);
                    }
                }
            }
        }
        caseActive = null;
    }

    public boolean deplacer(Case depart, Case arrivee) {
        ArrayList<Case> casesDispo = casesDisponibles(depart);
        if (depart.getP() != null) {
            if (casesDispo.contains(arrivee)) {
                arrivee.setP(depart.getP());
                depart.setP(null);
                if (abs(depart.getI() - arrivee.getI()) > 1 || abs(depart.getJ() - arrivee.getJ()) > 1) {
                   this.env[(depart.getI()+arrivee.getI())/2][(depart.getJ()+arrivee.getJ())/2].setP(null);
                }
                return true;
            } else {
                return false;
            }
        }
        else {
            return false;
        }
    }

    public ArrayList<Case> casesDisponibles(Case c){
        ArrayList<Case> listeCases = new ArrayList<>();
        
        if (c.getP() != null){
            Pion p = c.getP();
            int i = c.getI();
            int j = c.getJ();
            
            if (p.isMonte() || p.isDame()){
                if (i != 0){
                    if (j != 0){
                        if (env[i-1][j-1].getP() == null){
                            listeCases.add(env[i-1][j-1]);
                        } else{
                            if (i > 1 && j > 1){
                                if (env[i-1][j-1].getC() != c.getC()){
                                    listeCases.add(env[i-2][j-2]);
                                }
                            }
                        }
                    }
                        
                    if (j != TAILLE - 1){
                        if (env[i-1][j+1].getP() == null){
                            listeCases.add(env[i-1][j+1]);
                        } else{
                            if (i > 1 && j < TAILLE - 2){
                                if (env[i-1][j+1].getC() != c.getC()){
                                    listeCases.add(env[i-2][j+2]);
                                }
                            }
                        }
                    }
                }                   
            }
            if (!p.isMonte() || p.isDame()){
                if (i != TAILLE - 1){
                    if (j != 0){
                        if (env[i+1][j-1].getP() == null){
                            listeCases.add(env[i+1][j-1]);
                        } else{
                            if (i < TAILLE - 2 && j > 1){
                                if (env[i+1][j-1].getC() != c.getC()){
                                    listeCases.add(env[i+2][j-2]);
                                }
                            }
                        }
                    }
                        
                    if (j != TAILLE - 1){
                        if (env[i+1][j+1].getP() == null){
                            listeCases.add(env[i+1][j+1]);
                        } else{
                            if (i < TAILLE - 2 && j < TAILLE - 2){
                                if (env[i-1][j+1].getC() != c.getC()){
                                    listeCases.add(env[i+2][j+2]);
                                }
                            }
                        }
                    }
                }
            }
        }
        
        return listeCases;
    }
    
    void setCaseActive(Case c){
        this.caseActive = c;
    }
}
