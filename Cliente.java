package Cliente;


import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

import Interface.Mensageiro;


public class Cliente {
    
	private static void exibirMenu() {
		System.out.println("1. cadastrar um produto");
		System.out.println("2. alterar as informações de um produto"); 
		System.out.println("3. deletar um produto");
		System.out.println("4. recuperar as informações de um produto cadastrado");
		System.out.println("0. sair");
		System.out.println("Opção:");
	}

	
	
	/**
    *
    * @param args
    */
    public static void main(String[] args) {
    	try {
    		Mensageiro gerente = (Mensageiro) Naming.lookup("rmi://localhost:1234/produtos");

    		Scanner sc = new Scanner(System.in);
    		String nome;
    		String op ="1";
    		int id;
    		float valor;
    		while (!op.equals("0")) {
    			exibirMenu();
    			op = sc.next();
    			switch (op) {
    			case "1":
    				System.out.println("Cadastrar um produto");
    				System.out.print("Infome id(somente numeros):");
    				id = sc.nextInt();
    				System.out.print("Descrição do produto:");
    				nome = sc.next();
    				System.out.println("Informe valor:");
    				valor = sc.nextFloat();
    				if(gerente.cadastoProduto(id, nome, valor)) {
    					System.out.println("Produto cadastrado com sucesso!");
    				}else {
    					System.out.println("Não foi posivel criar ou o id já foi usado! \n*************************");
    				}
    				break;
    			case "2":
    				System.out.println("Alterar as informações de um produto\n Informe id:");
    				id=sc.nextInt();
    				if(gerente.pesquisa(id)) {
    					System.out.print("Descrição do produto:");
    					nome = sc.next();
    					System.out.println("Informe valor:");
    					valor = sc.nextFloat();
    					if(gerente.atualizaProduto(id, nome, valor)) {
    						System.out.println("Alteração efetuada com sucesso! \n*************************");
    					}else {
    						System.out.println("A alteração não pode ser efetuada.\n*************************");
    					}
    				}else {
    					System.out.println("Produto não encontrado ou não cadastrado.\n*************************");
    				}
    				break;
    			case "3":
    				System.out.println("Deletar um produto:\n Informe id:");
    				id =sc.nextInt();
    				if(gerente.removerProduto(id)) {
    					System.out.println("Produto removido com sucesso! \n*************************");
    				}else {
    					System.out.println("O produto não foi removido ou não foi cadastrado!\n*************************");
    				}
    				break;
    			case "4":
    				System.out.println("Recuperar as informações de um produto cadastrado:\n Informe id:");
    				id = sc.nextInt();
    				System.out.println(gerente.pesquisaInfo(id)+"\n*************************");
    				break;
    			default:
    				break;
    			}
    		}
    	} catch (MalformedURLException | RemoteException | NotBoundException e) {
    		System.out.println("Erro:" + e.toString());
    	} catch (Exception e) {
    		//JOptionPane.showMessageDialog(null, "Entrada inválida", e.getMessage(), JOptionPane.ERROR_MESSAGE);
    		System.out.println("Entrada inválida"+ e.getMessage());
    		System.exit(-1);
    	}
    }
} 
