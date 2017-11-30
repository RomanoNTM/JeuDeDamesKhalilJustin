/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeudedames;
import javax.swing.JFrame;
/**
 *
 * @author Justin
 */
public class JeuDeDames {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setSize(600, 600);
        f.setResizable(false);
	f.setLocationRelativeTo(null);
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	f.add(new Plateau());
	f.setVisible(true);
    }
    
}
