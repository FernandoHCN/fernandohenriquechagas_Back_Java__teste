/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fernando.teste.aplicacao;

import fernando.teste.control.ConexaoBD;
import fernando.teste.control.DaoCostumerAccount;
import fernando.teste.model.CostumerAccount;
import fernando.teste.util.CostumerUtil;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author fer_n
 */
public class Aplicacao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        ConexaoBD conexao =  new ConexaoBD("root", "1234");
        conexao.setDriver("com.mysql.jdbc.Driver");
        conexao.setConnectionString("jdbc:mysql://localhost:3306/costumer");
        
        Scanner sc = new Scanner(System.in);
        int opcao;

        DaoCostumerAccount daoCostumer;
        CostumerUtil costumerUtil;
        daoCostumer = new DaoCostumerAccount(conexao.conectar());
        costumerUtil = new CostumerUtil(daoCostumer);
              
        int id_customer;
        String cpf_cnpj;
        String nm_customer;
        boolean is_active;
        double vl_total;

        do {
            System.out.printf("Digite o Numero da Opcao: "
                    + "\n1 - Inserir Registros "
                    + "\n2 - Exibir Média Final"
                    + "\n3 - Imprimir clientes utilizados"
                    + "\n4 - Sair\n");
            opcao = sc.nextInt();
            if(opcao == 4)
                break;
            
            switch(opcao){
                case 1:
                    System.out.println("------- Inserir Registro -------");
                    System.out.println("Digite o ID de Identificação");
                    id_customer = sc.nextInt();
                    System.out.println("Digite o CPF ou CNPJ");
                    cpf_cnpj = sc.next();
                    System.out.println("Digite o Nome do Cliente");
                    nm_customer = sc.next();
                    System.out.println("O cliente esta ativo? Digite Sim ou Nao");
                    if(sc.next().equals("Sim"))
                        is_active = true;
                    else
                        is_active = false;
                    System.out.println("Digite o valor total do saldo");
                    vl_total = sc.nextDouble();
                    daoCostumer.inserir(new CostumerAccount(id_customer, cpf_cnpj, nm_customer, is_active, vl_total));
                    break;
                case 2:
                    System.out.println("------- impresso da media final -------");
                    System.out.println("Media Final: " + costumerUtil.mediaFinal());
                    break;
                case 3:
                    System.out.println("------- Clientes utilizados para o cálculo da média -------");
                    costumerUtil.imprimirClientes();
                    break;
            }
        }while(true);
    
    }

}
