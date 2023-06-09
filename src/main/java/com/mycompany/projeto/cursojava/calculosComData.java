/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.projeto.cursojava;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author migue
 */
public class calculosComData {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LocalDate d04 = LocalDate.parse("2023-06-09");
        LocalDateTime d05 = LocalDateTime.parse("2023-06-09T01:40:26");
        
        LocalDate calcDataMenos = d04.minusDays(7);
        LocalDateTime calcDataMais = d05.plusDays(7);
        
        System.out.println(calcDataMenos);
        System.out.println(calcDataMais);
        
        
        
    }
    
}
