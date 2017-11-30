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
    
    public Case(Pion p, Couleur c){
        this.p = p;
        this.c = c;
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
 
}
