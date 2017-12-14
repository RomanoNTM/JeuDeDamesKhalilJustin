/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeudedames;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
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
        this.setPreferredSize(new Dimension(50, 50));
        this.setMaximumSize(new Dimension(50, 50));
        this.setMinimumSize(new Dimension(50, 50));
        if (this.couleur == BLANC) {
            this.setBackground(new Color(250, 250, 250));
        } else {
            this.setBackground(new Color(100, 100, 100));
        }
        this.setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        Paint paint;
        Graphics2D g2d;
        if (g instanceof Graphics2D) {
            g2d = (Graphics2D) g;
        } else {
            System.out.println("Error");
            return;
        }
        paint = new GradientPaint(0, 0, getBackground(), getWidth(), getHeight(), getForeground());
        g2d.setPaint(paint);
        g.fillOval(5, 5, getWidth() - 10, getHeight() - 10);
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
