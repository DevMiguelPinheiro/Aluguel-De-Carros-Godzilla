/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.projeto.cursojava;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author migue
 */
public class Localdatr {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LocalDate d01 = LocalDate.now();
        LocalDateTime d02 = LocalDateTime.now();
        
        DateTimeFormatter fmt01 = DateTimeFormatter.ofPattern("dd/MM/yyyy");// coloco um formato de data 
        DateTimeFormatter fmt02 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        // imprime na tela os dados formatado
        System.out.println(d01.format(fmt01));
        System.out.println(d02.format(fmt02));
    }
    
}
