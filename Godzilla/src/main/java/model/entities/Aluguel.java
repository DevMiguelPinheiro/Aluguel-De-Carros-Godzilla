/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.Date;

/**
 *
 * @author migue
 */
public class Aluguel {
    private int id_aluguel;
    private String placaCarro;
    private int idCliente;
    private String nomeCliente;    
    private LocalDate dataAluguel;
    private LocalDate dataRetorno;
    private double taxaAluguel;
    

 
    
    public Aluguel() {
    }

    public Aluguel(String placaCarro) {
        this.placaCarro = placaCarro;
    }
    
    
    public int getId_aluguel() {
        return id_aluguel;
    }

    public void setId_aluguel(int id_aluguel) {
        this.id_aluguel = id_aluguel;
    }

    public String getPlacaCarro() {
        return placaCarro;
    }

    public void setPlacaCarro(String placaCarro) {
        this.placaCarro = placaCarro;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public LocalDate getDataAluguel() {
        return dataAluguel;
    }

    public void setDataAluguel(LocalDate dataAluguel) {
        this.dataAluguel = dataAluguel;
    }
    
    public void setDataAluguelString(String dataAluguelString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.dataAluguel = LocalDate.parse(dataAluguelString, formatter);
    }

    public LocalDate getDataRetorno() {
        return dataRetorno;
    }

    public void setDataRetorno(LocalDate dataRetorno) {
        this.dataRetorno = dataRetorno;
    }
    public void setDataRetornoString(String dataRetornoString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.dataRetorno = LocalDate.parse(dataRetornoString, formatter);
    }

    public double getTaxaAluguel() {
        return taxaAluguel;
    }

    public void setTaxaAluguel(double taxaAluguel) {
        this.taxaAluguel = taxaAluguel;
    }

    
}
