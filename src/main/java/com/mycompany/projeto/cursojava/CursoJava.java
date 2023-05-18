/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.projeto.cursojava;
import com.mycompany.projeto.entidades.retangle;
import java.util.Locale;
import java.util.Scanner;


/**
Fazer um programa para ler os valores da largura e altura 
de um retângulo. Em seguida, mostrar na tela o valor de 
sua área, perímetro e diagonal. Usar uma classe como 
mostrado no projeto ao lado.
* 
* .format() serve pra formatar o  resultado final como casas decimais
 */
public class CursoJava {

    public static void main(String[] args)  {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        retangle x;

        x = new retangle();
        System.out.println("Enter the width of retangle X: ");
        x.a = sc.nextDouble();
        System.out.println("Enter the height of retangle X: ");
        x.b = sc.nextDouble();
  
     
        double areaX = x.area();
        double perimeterX = x.perimeter();
        double diagonalX = x.diagonal();
        
        System.out.printf("retangle X area: %.4f%n", areaX);
        System.out.printf("retangle X perimeter: %.4f%n", perimeterX);
        System.out.printf("retangle X perimeter: %.4f%n", diagonalX);
 
        sc.close();
    }
}
