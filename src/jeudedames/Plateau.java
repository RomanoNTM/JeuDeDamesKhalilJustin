/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeudedames;

import static java.lang.Math.abs;
import java.util.ArrayList;

/**
 *
 * @author Justin
 */
public class Plateau {

    private static final int TAILLE = 10;
    private boolean tourNoir;
    private Case[][] env;

    public Plateau() {
        tourNoir = false;
        env = new Case[TAILLE][TAILLE];
        for (int i = 0; i < TAILLE; i++) {
            for (int j = 0; j < TAILLE; j++) {
                if (i <= 3) {
                    if (j % 2 == 1) {
                        env[i][j] = new Case(new Pion(Couleur.NOIR), Couleur.NOIR);
                    } else {
                        env[i][j] = new Case(null, Couleur.BLANC);
                    }
                } else if (i >= 6) {
                    if (j % 2 == 1) {
                        env[i][j] = new Case(new Pion(Couleur.BLANC), Couleur.NOIR);
                    } else {
                        env[i][j] = new Case(null, Couleur.BLANC);
                    }
                } else {
                    if (j % 2 == 1) {
                        env[i][j] = new Case(null, Couleur.NOIR);
                    } else {
                        env[i][j] = new Case(null, Couleur.BLANC);
                    }
                }
            }
        }
    }

    public boolean deplacer(Case depart, Case arrivee) {
        ArrayList<Case> casesDispo = casesDisponible(depart);
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

}
