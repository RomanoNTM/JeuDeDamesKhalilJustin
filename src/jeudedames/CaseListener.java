/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeudedames;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import static jeudedames.Couleur.BLANC;

/**
 *
 * @author Khalil
 */
public class CaseListener implements MouseListener {
    private Case c;
    private Plateau plateau;

    public CaseListener(Case c, Plateau plateau) {
        this.c = c;
        this.plateau = plateau;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (plateau.getCaseActive() == null){
            if (c.getP() != null){
                plateau.setCaseActive(c);
            }
        } else{
            if (c.getP() == null){
                for (Case c1 : plateau.casesDisponibles(plateau.getCaseActive())){
                    c1.setBackground(Color.BLACK);
                    c1.validate();
                    c1.repaint();
                }
                plateau.deplacer(plateau.getCaseActive(), c);
            } else{
                plateau.setCaseActive(c);
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
       
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
}
