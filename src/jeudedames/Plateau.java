/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeudedames;

import java.util.ArrayList;

/**
 *
 * @author Justin
 */
public class Plateau{
    
    private static final int TAILLE =10;
    private boolean tourNoir;
    private final Case[][] env;
    
    public Plateau(){
        tourNoir = false;
        env = new Case[TAILLE][TAILLE];
        for (int i=0;i<TAILLE;i++){
            for (int j=0;j<TAILLE;j++){
                if (i <= 3){
                    if (j%2 == 1){
                        env[i][j] = new Case(new Pion(Couleur.NOIR), Couleur.NOIR);
                    } else{
                        env[i][j] = new Case(null, Couleur.BLANC);
                    }
                } else if (i >= 6){
                    if (j%2 == 1){
                        env[i][j] = new Case(new Pion(Couleur.BLANC), Couleur.NOIR);
                    } else{
                        env[i][j] = new Case(null, Couleur.BLANC);
                    }
                } else{
                    if (j%2 == 1){
                        env[i][j] = new Case(null, Couleur.NOIR);
                    } else{
                        env[i][j] = new Case(null, Couleur.BLANC);
                    }
                }
            }
        }
    }
    
    public ArrayList<Case> casesDisponibles(Case c){
        ArrayList<Case> listeCases = new ArrayList<>();
        
        if (c.getP() != null){
            Pion p = c.getP();
            
        }
        
        return listeCases;
    }
    
}
     
