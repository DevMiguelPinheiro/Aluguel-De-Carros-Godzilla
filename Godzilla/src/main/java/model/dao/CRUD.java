/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.entities.Carros;
import model.entities.Cliente;

/**
 *
 * @author migue
 */
public class CRUD {

    public boolean save(Carros carro) {
        String sql = "INSERT INTO carros(placa, marca, modelo, status, preco,caminhoimg) VALUES(?, ?, ?, ?, ?,?)";

        Connection conn = null;

        PreparedStatement pstm = null;

        try {
            //cria conexão com o bd
            conn = ConnectionFactory.getConnection();

            //cria uma PreparedStatement para executar uma query
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setString(1, carro.getPlaca());
            pstm.setString(2, carro.getMarca());
            pstm.setString(3, carro.getModelo());
            pstm.setString(4, carro.getStatus());
            pstm.setDouble(5, carro.getPreco());
            pstm.setString(6,carro.getImagem());

            //Executa query
            pstm.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            //fecha conexoes
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //listar carros
    public List<Carros> getCarros() {

        String sql = "SELECT * FROM listas.carros";

        List<Carros> carros = new ArrayList<Carros>();

        Connection conn = null;
        PreparedStatement pstm = null;
        //Classe que vai recuperar os dados do banco. ***SELECT****
        ResultSet rset = null;

        try {
            conn = ConnectionFactory.getConnection();

            pstm = (PreparedStatement) conn.prepareStatement(sql);

            rset = pstm.executeQuery();

            while (rset.next()) {

                Carros carro = new Carros();

                //Recuperar placa
                carro.setPlaca(rset.getString("placa"));;
                //Recuperar marca
                carro.setMarca(rset.getString("marca"));
                //Recuperar modelo
                carro.setModelo(rset.getString("modelo"));
                //Recuperar status do carro
                carro.setStatus(rset.getString("status_carro"));
                //Recuperar preco
                carro.setPreco(rset.getDouble("preco"));

                carros.add(carro);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rset != null) {
                    rset.close();
                }

                if (pstm != null) {
                    pstm.close();
                }

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return carros;
    }

    //editar
    public boolean update(Carros carro) {

        String sql = "UPDATE carros SET marca = ?, modelo = ?, status = ?, preco = ?, caminhoimg = ? "
                + "WHERE placa = ?";

        Connection conn = null;

        PreparedStatement pstm = null;

        try {
            //cria conexão
            conn = ConnectionFactory.getConnection();

            //criar a classe para executar a query
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            //adicionar os valores para atualizar
            pstm.setString(1, carro.getMarca());
            pstm.setString(2, carro.getModelo());
            pstm.setString(3, carro.getStatus());
            pstm.setDouble(4, carro.getPreco());
            pstm.setString(6,carro.getImagem());

            //qual id pra atualizar
            pstm.setString(5, carro.getPlaca());
            

            //executar
            pstm.execute();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public boolean delete(String placa) {

        String sql = "DELETE FROM carros WHERE placa = ?";

        Connection conn = null;

        PreparedStatement pstm = null;

        try {
            //cria conexão
            conn = ConnectionFactory.getConnection();

            //criar a classe para executar a query
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setString(1, placa);

            pstm.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    //parte do cliente
    public boolean save(Cliente cliente) {
        String sql = "INSERT INTO clientes(nome, endereco, telefone) VALUES(?, ?, ?)";

        Connection conn = null;

        PreparedStatement pstm = null;

        try {
            //cria conexão com o bd
            conn = ConnectionFactory.getConnection();

            //cria uma PreparedStatement para executar uma query
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setString(1, cliente.getNome());
            pstm.setString(2, cliente.getEndereco());
            pstm.setString(3, cliente.getTelefone());

            //Executa query
            pstm.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            //fecha conexoes
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public List<Cliente> getClientes() {

        String sql = "SELECT * FROM listas.clientes";

        List<Cliente> clientes = new ArrayList<Cliente>();

        Connection conn = null;
        PreparedStatement pstm = null;
        //Classe que vai recuperar os dados do banco. ***SELECT****
        ResultSet rset = null;

        try {
            conn = ConnectionFactory.getConnection();

            pstm = (PreparedStatement) conn.prepareStatement(sql);

            rset = pstm.executeQuery();

            while (rset.next()) {

                Cliente cliente = new Cliente();

                //Recuperar o id
                cliente.setId_cliente(rset.getInt("id"));;
                //Recuperar o nome
                cliente.setNome(rset.getString("nome"));
                //Recuperar a endereço
                cliente.setEndereco(rset.getString("endereco"));
                //Recuperar telefone
                cliente.setTelefone(rset.getString("telefone"));

                clientes.add(cliente);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rset != null) {
                    rset.close();
                }

                if (pstm != null) {
                    pstm.close();
                }

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return clientes;
    }

    public boolean update(Cliente cliente) {

        String sql = "UPDATE clientes SET nome = ?, endereco = ?, telefone = ? "
                + "WHERE id = ?";

        Connection conn = null;

        PreparedStatement pstm = null;

        try {
            //cria conexão
            conn = ConnectionFactory.getConnection();

            //criar a classe para executar a query
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            //adicionar os valores para atualizar
            pstm.setString(1, cliente.getNome());
            pstm.setString(2, cliente.getEndereco());
            pstm.setString(3, cliente.getTelefone());

            //qual id pra atualizar
            pstm.setInt(4, cliente.getId_cliente());

            //executar
            pstm.execute();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public boolean delete(Carros carro) {

        String sql = "DELETE FROM clientes WHERE id = ?";

        Connection conn = null;

        PreparedStatement pstm = null;

        try {
            //cria conexão
            conn = ConnectionFactory.getConnection();

            //criar a classe para executar a query
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setString(1, carro.getPlaca());

            pstm.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
