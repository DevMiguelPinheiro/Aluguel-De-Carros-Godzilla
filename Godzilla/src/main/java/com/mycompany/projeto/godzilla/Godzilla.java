
package com.mycompany.projeto.godzilla;


import com.formdev.flatlaf.intellijthemes.FlatDarkPurpleIJTheme;
import javax.swing.UIManager;
import view.Login;
/**
 *
 * @author equipeGodzilla
 */
public class Godzilla  {
    public static void main(String args[]) {
    try {
            UIManager.setLookAndFeel(new FlatDarkPurpleIJTheme());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Login login = new Login();
                login.setVisible(true);
            }
        });
    }
}
        


 



