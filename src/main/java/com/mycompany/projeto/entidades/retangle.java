/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projeto.entidades;

/**
 *
 * @author migue
 */
public class retangle {
    public double a;
    public double b;
    public double c;
    
    public double area(){
    double area = ( a*b ) ;
    return  area;
      
    }
    
    public double perimeter(){
        double p = 2*(a+b);
        return p;
        
    }
    
    public double diagonal(){
        double d = Math.sqrt((a*a)+(b*b));
        return d;
    }
    
}
