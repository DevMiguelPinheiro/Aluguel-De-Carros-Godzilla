/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projeto.entidades;

/**
 *
 * @author migue
 */
public class funcionario {
    
    private int id ;
    private String name;
    private double salario;

    public funcionario() {
    }

    public funcionario(int id, String name, double salario) {
        this.id = id;
        this.name = name;
        this.salario = salario;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    public void incrementasal(double percent){
    
    salario  += salario * percent / 100.0;
    
    }
    
}
