/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeudedames;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import static jeudedames.Couleur.*;

/**
 * Classe de gestion d'un pion
 *
 * @author Khalil
 */
public class Pion {

    private Couleur couleur;
    private boolean monte;

    public Pion(Couleur couleur) {
        this.couleur = couleur;
        if (couleur == BLANC) {
            this.monte = true;
        } else {
            this.monte = false;
        }

    }

    public Couleur getCouleur() {
        return couleur;
    }

    public void setCouleur(Couleur couleur) {
        this.couleur = couleur;
    }

    public boolean isMonte() {
        return monte;
    }

    public void setMonte(boolean monte) {
        this.monte = monte;
    }

}
