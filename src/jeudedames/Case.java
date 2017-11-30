/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeudedames;

/**
 *Classe de gestion d'une case
 * @author Justin
 */
public class Case {
    private Pion p;
    private Couleur c;
    private int i;
    private int j;
    
    public Case(Pion p, Couleur c, int i, int j){
        this.p = p;
        this.c = c;
        this.i = i;
        this.j = j;
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
