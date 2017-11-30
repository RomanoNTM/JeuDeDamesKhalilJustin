/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeudedames;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import static jeudedames.Couleur.BLANC;

/**
 *Classe de gestion d'une case
 * @author Justin
 */
public class Case extends JPanel {
    private Pion p;
    private Couleur c;
    private int i;
    private int j;
    
    public Case(Pion p, Couleur c, int i, int j){
        super();
        this.p = p;
        this.c = c;
        this.i = i;
        this.j = j;
        initCase();
    }
    
    protected void initCase() {
        if (this.c == BLANC) {
            this.setBackground(new Color(255,255,255));
        }
        else {
            this.setBackground(new Color(0,0,0));
        }
        if (this.p != null) {
           this.add(p); 
        }
        this.setPreferredSize(new Dimension(60,60));
        this.setMaximumSize(new Dimension(60,60));
        this.setMinimumSize(new Dimension(60,60));
    }
   

    public Pion getP() {
        return p;
    }

    public void setP(Pion p) {
        this.p = p;
    }

    public Couleur getC() {
        return c;
    }

    public void setC(Couleur c) {
        this.c = c;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }

    
}
