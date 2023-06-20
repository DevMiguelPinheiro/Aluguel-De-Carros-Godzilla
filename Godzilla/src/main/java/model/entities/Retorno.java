/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entities;

import java.time.LocalDate;

/**
 *
 * @author migue
 */
public class Retorno {
        private int id_retorno;
	private int id_aluguel;
	private String placa;
	private String nome;
	private LocalDate data_retorno;
	private long atraso;
	private double multaConta;
	
	public Retorno() {
	}
	
	
	public Retorno(int id_retorno, int id_aluguel, String placa, String nome, LocalDate data_retorno, long atraso,
		double multaConta) {
		this.id_retorno = id_retorno;
		this.id_aluguel = id_aluguel;
		this.placa = placa;
		this.nome = nome;
		this.data_retorno = data_retorno;
		this.atraso = atraso;
		this.multaConta = multaConta;
	}



	public int getId_aluguel() {
		return id_aluguel;
	}



	public void setId_aluguel(int id_aluguel) {
		this.id_aluguel = id_aluguel;
	}



	public int getId_retorno() {
		return id_retorno;
	}

	public void setId_retorno(int id_retorno) {
		this.id_retorno = id_retorno;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getData_retorno() {
		return data_retorno;
	}

	public void setData_retorno(LocalDate data_retorno) {
		this.data_retorno = data_retorno;
	}

	public long getAtraso() {
		return atraso;
	}

	public void setAtraso(long atraso) {
		this.atraso = atraso;
	}

	public double getMultaConta() {
		return multaConta;
	}

	public void setMultaConta(double multaConta) {
		this.multaConta = multaConta;
	}

    
}
