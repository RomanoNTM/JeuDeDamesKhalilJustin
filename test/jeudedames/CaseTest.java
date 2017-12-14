/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeudedames;

import static jeudedames.Couleur.*;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Khalil
 */
public class CaseTest {
    
    private Case classToTest;
    

    /**
     * Test of getC method, of class Case.
     */
    @Test
    public void testGetC() {
        System.out.println("Testons la méthode getC");
        Case instance1 = new Case(new Pion(BLANC), BLANC, 1,1);
        Case instance2 = new Case(new Pion(BLANC), NOIR, 2,2);
        
        Couleur result1 = instance1.getC();
        Couleur result2 = instance2.getC();
        
        assertEquals(result1, BLANC);
        assertEquals(result2, NOIR);
        
    }

    /**
     * Test of setC method, of class Case.
     */
    @Test
    public void testSetC() {
        System.out.println("Testons la méthode setC");
        Case instance1 = new Case(new Pion(BLANC), BLANC, 1,1);
        Case instance2 = new Case(new Pion(BLANC), NOIR, 2,2);
        
        instance1.setC(NOIR);
        instance2.setC(BLANC);
        
        assertEquals(instance1.getC(),NOIR);
        assertEquals(instance2.getC(),BLANC);
        
        
    }



    
}
