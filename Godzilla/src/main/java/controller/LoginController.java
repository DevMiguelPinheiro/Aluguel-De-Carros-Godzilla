/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import factory.ConnectionFactory;


/**
 *
 * @author migue
 */
public class LoginController {
    public boolean realizarLogin(String usuario, String senha) {
        return ConnectionFactory.login(usuario, senha);
    }
   
}

    

