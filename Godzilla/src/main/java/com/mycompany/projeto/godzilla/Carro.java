/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author migue
 */
public class Carro {
    public char placa;
    public char marca;
    public char status;
    public double preco;
    public char imagem;
    
    public Carro(){
    
    }
    
    public Carro( char placa,char marca,char status,double preco,char imagem){
        this.placa = placa;
        this.marca = marca;
        this.status = status;
        this.preco = preco;
        this.imagem = imagem;
    }
    
    // GETTERS
    public char getPlaca(){
    return placa;
    }  
    public char getMarca(){
    return marca;
    }  
    public char getStatus(){
    return status;
    }  
    public double getPreco(){
    return preco;
    }
    public char getImagem(){
    return imagem;
    }  
    
    
    //SETTERS
    public void setPlaca(){
    this.placa = placa;
    }
    public void setMarca(){
    this.placa = marca;
    } 
    public void setStatus(){
    this.status = status;
    } 
    public void setPreco(){
    this.preco = preco;
    } 
    public void setImagem(){
    this.imagem = imagem;
    } 
                    
    
}
