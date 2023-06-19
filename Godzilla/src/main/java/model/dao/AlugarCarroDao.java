/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import java.sql.Date;
import java.sql.SQLException;
import factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.entities.Aluguel;
import model.entities.Carros;
import model.entities.Cliente;
import model.entities.Retorno;

/**
 *
 * @author migue
 */
public class AlugarCarroDao {
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    ConnectionFactory connectionFactory = new ConnectionFactory();

    public AlugarCarroDao() {
        con = connectionFactory.getConnection();
    }

    public void  alugarCarro(Aluguel aluguel, int id_cliente, String placa) {
		 
				
	PreparedStatement pstm2  = null;			
	try {
		String sql = "INSERT INTO aluguel2(id_do_cliente, placa_do_carro, data_aluguel, data_retorno, taxa) VALUES(?, ?, ?, ?, ?)";
		String sql2 = "UPDATE carros SET status = ?"+
		"WHERE placa = ?";
			//cria uma PreparedStatement para executar uma query
			ps = (PreparedStatement) con.prepareStatement(sql);
			pstm2 = con.prepareStatement(sql2);
				
			pstm2.setString(1, "ALUGADO");
			pstm2.setString(2, aluguel.getPlacaCarro());
				
                        ps.setInt(1, id_cliente);
			ps.setString(2, placa);
//			ps.setString(3, procurar.retorna_nome_pelo_Id(id_cliente));
			ps.setString(3, aluguel.getDataAluguel().toString());
			ps.setString(4, aluguel.getDataRetorno().toString());
			ps.setDouble(5, aluguel.getTaxaAluguel());
				
				//Executa query
				ps.execute();
				pstm2.execute();
			}catch (Exception e) {
				e.printStackTrace();
			}
    
    }
    public boolean retorno(String placa) {
    try {
        String sql1 = "UPDATE aluguel SET retorno = ?, WHERE placa = ?";
        ps = con.prepareStatement(sql1);
        ps.setDate(1, Date.valueOf(LocalDate.now()));
        ps.setString(2, placa);
        ps.executeUpdate();

        String sql2 = "UPDATE carros SET status = 'DISPONIVEL' WHERE placa = ?";
        ps = con.prepareStatement(sql2);
        ps.setString(1, placa);
        ps.executeUpdate();

        return true;
    } catch (SQLException ex) {
        ex.printStackTrace();
        return false;
    }
    
}
    
    public List<Aluguel> getAlugueis(){
		
		String sql = "SELECT * FROM alugueis";
		
		List<Aluguel> listaAluguel = new ArrayList<Aluguel>();
		
		try {
			
			
			ps =  con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				
				Aluguel aluguel = new Aluguel();
				
				//Recuperar id aluguel
				aluguel.setId_aluguel(rs.getInt("id"));
				//Recuperar id cliente
				aluguel.setIdCliente(rs.getInt("id_cliente"));
				//Recuperar placa
				aluguel.setPlacaCarro(rs.getString("placa_carro"));
				//Recuperar nome
				aluguel.setNomeCliente(rs.getString("nome"));
				//Recuperar da
				aluguel.setDataAluguel(LocalDate.parse(rs.getString("data_aluguel")));
				//Recuperar dr
				aluguel.setDataRetorno(LocalDate.parse(rs.getString("data_retorno")));
				//Recuperar taxa
				aluguel.setTaxaAluguel(rs.getDouble("taxa"));
				
				
				listaAluguel.add(aluguel);
				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {
					rs.close();
				}
					
				if(ps!=null) {
					ps.close();
				}
					
				if(con!=null) {
					con.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return listaAluguel;
	}
    
    public void retorna_carro(Retorno retorno, int id_aluguel) {
		Procura_no_banco procurar = new Procura_no_banco();
		if (procurar.procura_pelo_id_aluguel(id_aluguel)) {
			String sql = "INSERT INTO retorno(id_aluguel, placa, nome, data_retorno, atraso, multaConta) VALUES(?, ?, ?, ?, ?, ?)";
			String sql2 = "UPDATE carros SET status_carro = ?"+
			"WHERE placa = ?";
			String sql3 = "DELETE FROM alugueis WHERE id = ?";
			Connection conn = null;
			
			PreparedStatement pstm = null;
			PreparedStatement pstm2  = null;
			PreparedStatement pstm3  = null;
			
			
			try {
				
				
				//cria uma PreparedStatement para executar uma query
				ps =  con.prepareStatement(sql);
				pstm2 =  con.prepareStatement(sql2);
				pstm3 =  con.prepareStatement(sql3);
				
				pstm3.setInt(1, id_aluguel);
				
				
				pstm2.setString(1, "DISPONIVEL");
				pstm2.setString(2, procurar.placa_aluguel_pelo_id(id_aluguel));
				
				pstm.setInt(1, id_aluguel);
				pstm.setString(2, procurar.placa_aluguel_pelo_id(id_aluguel));
				pstm.setString(3, procurar.nome_aluguel_pelo_id(id_aluguel));
				pstm.setString(4, retorno.getData_retorno().toString());
				pstm.setLong(5, retorno.getAtraso());//fazer o calculo
				pstm.setDouble(6, retorno.getMultaConta());//fazer o calculo
				
				//Executa query
				pstm.execute();
				pstm2.execute();
				pstm3.execute();
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				//fecha conexoes
				try {
					if (ps != null) {
						ps.close();
					}
					if (pstm2 != null) {
						pstm2.close();
					}
					if (conn != null) {
						conn.close();
					}
				}catch (Exception e){
					e.printStackTrace();
				}
			}
		}else {
			System.out.println("nao encontrado correspondente");
		}	
	}
    
    public List<Retorno> getRetornos(){
		
		String sql = "SELECT * FROM listas.retorno";
		
		List<Retorno> listaRetorno = new ArrayList<Retorno>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		//Classe que vai recuperar os dados do banco. ***SELECT****
		ResultSet rset = null;
		
		try {
			
			ps= con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				
				Retorno retorno = new Retorno();
				
				//Recuperar id retorno
				retorno.setId_retorno(rs.getInt("id"));
				//Recuperar id aluguel
				retorno.setId_aluguel(rs.getInt("id_aluguel"));
				//Recuperar placa
				retorno.setPlaca(rs.getString("placa"));
				//Recuperar nome
				retorno.setNome(rs.getString("nome"));
				//Recuperar dr
				retorno.setData_retorno(LocalDate.parse(rs.getString("data_retorno")));
				//Recuperar atraso
				retorno.setAtraso(rs.getLong("atraso"));
				//Recuperar multaConta
				retorno.setMultaConta(rs.getDouble("multaConta"));
				
				
				listaRetorno.add(retorno);
				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rset!=null) {
					rset.close();
				}
					
				if(pstm!=null) {
					pstm.close();
				}
					
				if(conn!=null) {
					conn.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return listaRetorno;
	}
        
    public void atualizarTabela(DefaultTableModel model) throws SQLException {
         String query = "SELECT * FROM carros";
    try {
        ps = con.prepareStatement(query);
        rs = ps.executeQuery();

        model.setRowCount(0); // Limpar os dados existentes na tabela

        while (rs.next()) {
            Object[] rowData = new Object[5]; // Adicionei mais um elemento para o array

            // Preencher o array rowData com os dados do ResultSet
            rowData[0] = rs.getString("placa");
            rowData[1] = rs.getString("marca");
            rowData[2] = rs.getString("modelo");
            rowData[3] = rs.getString("status");
            rowData[4] = rs.getDouble("preco");

            model.addRow(rowData);
        }

        rs.close();
    } finally {
        if (ps != null) {
            ps.close();
        }
    }
        
    }
    
    
    

    
}