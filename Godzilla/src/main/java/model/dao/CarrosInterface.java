/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model.dao;

import java.util.List;
import model.entities.Carros;

/**
 *
 * @author migue
 */
public interface CarrosInterface {
        //salvar carro
	boolean save(Carros carro);

	//listar carros
	
	List<Carros> getCarros();
	
	//editar
	
	boolean update(Carros carro);
	
	//deletar carro pela placa
	
	boolean delete(String placa);
}
