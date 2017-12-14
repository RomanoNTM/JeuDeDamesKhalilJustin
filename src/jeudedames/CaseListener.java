/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeudedames;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
        if (plateau.getCaseActive()==null) {
            plateau.setCaseActive(c);
        }
        else {
            plateau.deplacer(plateau.getCaseActive(),c);
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
