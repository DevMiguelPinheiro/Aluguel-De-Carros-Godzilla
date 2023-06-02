/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projeto.entidades;

/**
 *
 * @author migue
 */
public class student {
    
    public String name;
    public double n1;
    public double n2;
    public double n3;
    
    
    public double sum() {
    return n1 + n2 + n3;
    }
    
    public double missingPoints() {
        if (sum() < 60.0) {
        return 60.0 - sum();
        }
            else {
            return 0.0;
            }
        }
    }

