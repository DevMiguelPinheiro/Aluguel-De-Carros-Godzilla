/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import model.entities.Aluguel;
import model.entities.Carros;
import model.entities.Cliente;

/**
 *
 * @author migue
 */
public class Procura_no_banco {
    
        public boolean procura_pelo_id_cliente(int id) {
		ClientesDao bancoClientes = new ClientesDao();
		
		for (Cliente c: bancoClientes.getClientes() ) {
			if(id == c.getId_cliente()) {
				return true;
			}
		}
		return false;
		
	}
	
	public boolean procura_pela_placa_carrob(String placa) {
		CarrosDao bancoCarros = new CarrosDao();

		for (Carros c: bancoCarros.getCarros() ) {
			if(placa.equals(c.getPlaca())) {
				return true;
			}
		}
		return false;
		
	}
        public String procura_pela_placa_carro(String placa) {
        CarrosDao bancoCarros = new CarrosDao();

         for (Carros c : bancoCarros.getCarros()) {
        if (placa.equals(c.getPlaca())) {
            return c.getPlaca();
            }
        }
        return null; // Retorna null caso a placa não seja encontrada
        }
	
	public String retorna_nome_pelo_Id(int id) {
		ClientesDao bancoClientes = new ClientesDao();

		for (Cliente c: bancoClientes.getClientes()) {
			if(c.getId_cliente() == id) {
				return c.getNome();
			}
		}
		return "";
		
	}
	
	public boolean procura_pelo_id_aluguel(int id) {
		AlugarCarroDao bancoAlugueis = new AlugarCarroDao();
		
		for (Aluguel c: bancoAlugueis.getAlugueis() ) {
			if(id == c.getId_aluguel()) {
				return true;
			}
		}
		return false;
		
	}
	
	public String placa_aluguel_pelo_id(int id) {
		AlugarCarroDao bancoAlugueis = new AlugarCarroDao();
		
		for (Aluguel c: bancoAlugueis.getAlugueis() ) {
			if(id == c.getId_aluguel()) {
				return c.getPlacaCarro();
			}
		}
		return "";
	}
	
	public String nome_aluguel_pelo_id(int id) {
		AlugarCarroDao bancoAlugueis = new AlugarCarroDao();
		
		for (Aluguel c: bancoAlugueis.getAlugueis() ) {
			if(id == c.getId_aluguel()) {
				return c.getNomeCliente();
			}
		}
		return "";
	}
}
