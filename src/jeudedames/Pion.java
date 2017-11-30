/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeudedames;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import static jeudedames.Couleur.*;

/**
 * Classe de gestion d'un pion
 *
 * @author Khalil
 */
public class Pion extends JPanel {

    private Couleur couleur;
    private boolean monte;
    private boolean dame;

    public Pion(Couleur couleur) {
        this.couleur = couleur;
        if (couleur == BLANC) {
            this.monte = true;
        } else {
            this.monte = false;
        }
        dame = false;
        initPion();
    }

    protected void initPion() {
        if (this.couleur == BLANC) {
            this.setBackground(new Color(230,230,230));
        }
        else {
            this.setBackground(new Color(10,10,10));
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawOval(0, 0, g.getClipBounds().width, g.getClipBounds().height);
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

    public boolean isDame() {
        return dame;
    }

    public void setDame(boolean dame) {
        this.dame = dame;
    }

}
