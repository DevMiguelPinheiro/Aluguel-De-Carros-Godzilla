/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.projeto.cursojava;

import com.mycompany.projeto.entidades.student;
import java.util.Locale;
import java.util.Scanner;

/**
Fazer um programa para ler o nome de um aluno e as três notas que ele obteve nos três trimestres do ano 
(primeiro trimestre vale 30 e o segundo e terceiro valem 35 cada). Ao final, mostrar qual a nota final do aluno no 
ano. Dizer também se o aluno está aprovado (PASS) ou não (FAILED) e, em caso negativo, quantos pontos faltam 
para o aluno obter o mínimo para ser aprovado (que é 60% da nota). Você deve criar uma classe Student para 
resolver este problema.
 */
public class atividade3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        try (Scanner sc = new Scanner(System.in)) {
            student x;
            
            x = new student();
            Locale.setDefault(Locale.US);
            
            System.out.println("Enter the name of the student");
            x.name = sc.nextLine();
            System.out.printf("First note of %s : ",x.name);
            x.n1 = sc.nextDouble();
            System.out.printf("Second note of %s : ",x.name);
            x.n2 = sc.nextDouble();
            System.out.printf("Last note of %s : ",x.name);
            x.n3 = sc.nextDouble();
            
            System.out.printf("FINAL GRADE: %.2f%n", x.sum());
            if (x.sum() < 60.0) {
                System.out.println("FAILED");
                System.out.printf("MISSING %.2f POINTS%n", x.missingPoints());
            }
            else {
                System.out.println("PASS");
            }
        }
    }
    
}
