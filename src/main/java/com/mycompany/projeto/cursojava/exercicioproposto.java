/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.projeto.cursojava;

import com.mycompany.projeto.entidades.funcionario;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
Fazer um programa para ler um número inteiro N e depois os 
dados (id, nome e salario) de N funcionários. Não deve haver 
repetição de id. 
 
Em seguida, efetuar o aumento de X por cento no salário de 
um determinado funcionário. Para isso, o programa deve ler 
um id e o valor X. Se o id informado não existir, mostrar 
uma mensagem e abortar a operação. Ao final, mostrar a 
listagem atualizada dos funcionários, conforme exemplos.
 
Lembre-se de aplicar a técnica de encapsulamento para não 
permitir que o salário possa ser mudado livremente. Um 
salário só pode ser aumentado com base em uma operação 
de aumento por porcentagem dada
 */
public class exercicioproposto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        Scanner sc  = new Scanner(System.in);
        
        List<funcionario> list = new ArrayList<>(); 
        
        System.out.println("Digite N : ");
        int n = sc.nextInt();
        
        // loop para receber os dados
        for(int i = 0 ; i<n; i++){
        System.out.print("Digite o Id :"); // le os dados
        Integer id  = sc.nextInt(); // armazena em um object
        System.out.print("Digite o Nome: ");
        sc.nextLine();
        String nome = sc.nextLine();
        System.out.print("Digite o Salario: ");
        Double salario = sc.nextDouble();
        
        funcionario func  = new funcionario(id, nome ,salario); // instancia um novo fun com os dados inseridos
        list.add(func); // adiciona o novo funcionario com as infos coletadas na lista
        }
        
        System.out.print("Qual salario deseja incrementar: ");
        int idsalario = sc.nextInt();
        Integer pos  = position(list,idsalario);
        if(pos == null){
            System.out.println("O Id nao existe na lista");
        }else{
        
            System.out.println("Digite quantos porcento deseja aumentar o salario");
            double porcento_salario = sc.nextInt();
            list.get(pos).incrementasal(porcento_salario);//encontra a posicao do funcionario e depois aplica o metodo
                
        }
        
        sc.close();
      
    }
    
    // metodo para dizer a posicao do item na lista
    public static Integer position(List<funcionario> list, int id ){
     for(int i = 0 ; i < list.size() ; i++){     
        if( list.get(i).getId() == id){
            return i ;     // caso seja igual retorna a posicao
        }    
     }
     return null;   
    }
    
    
}
