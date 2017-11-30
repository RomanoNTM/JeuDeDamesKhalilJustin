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
                        env[i][j] = new Case(new Pion(Couleur.NOIR), Couleur.NOIR, i, j);
                    } else{
                        env[i][j] = new Case(null, Couleur.BLANC, i, j);
                    }
                } else if (i >= 6){
                    if (j%2 == 1){
                        env[i][j] = new Case(new Pion(Couleur.BLANC), Couleur.NOIR, i, j);
                    } else{
                        env[i][j] = new Case(null, Couleur.BLANC, i, j);
                    }
                } else{
                    if (j%2 == 1){
                        env[i][j] = new Case(null, Couleur.NOIR, i, j);
                    } else{
                        env[i][j] = new Case(null, Couleur.BLANC, i, j);
                    }
                }
            }
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
    
}
     
