/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model.dao;

import java.util.List;
import model.entities.Cliente;

/**
 *
 * @author migue
 */
public interface ClienteInterface {
    
    	public boolean save(Cliente cliente);

	public List<Cliente> getClientes();
	
	
	public boolean update(Cliente cliente);
	
	public boolean deleteCliente(Cliente cliente) ;
}
