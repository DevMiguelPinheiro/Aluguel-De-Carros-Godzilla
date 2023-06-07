
package com.mycompany.projeto.godzilla;


import view.Login;
/**
 *
 * @author equipeGodzilla
 */
public class Godzilla  {
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Login login = new Login();
                login.setVisible(true);
            }
        });
    }
}

 



