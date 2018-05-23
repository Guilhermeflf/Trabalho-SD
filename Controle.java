package Servidor;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import Interface.Mensageiro;

public class Controle extends UnicastRemoteObject implements Mensageiro {
	private static Mensageiro instance = null;
	private static final long serialVersionUID = 1L;
	private List<Produto> produtos;
	
	public Controle() throws RemoteException {
		this.produtos = new ArrayList<Produto>();
    }
	@Override
	public boolean cadastoProduto(int id, String nome, float valor) throws RemoteException{
		for (Produto p : produtos) {
			if(p.getId() == id) {
				return false;
			}
		}
		Produto novoProduto = new Produto(id, nome, valor);
		produtos.add(novoProduto);
		return true;
	}
	@Override
	public String pesquisaInfo(int id) throws RemoteException {
		String saida ="";
		for (Produto p : produtos) {
			if(p.getId() == id) {
				saida= "Id do produto:"+ p.getId() +"\n Nmome do produto: "+ p.getNome()+"\nValor: "+p.getValor();
				return saida;
			}
		}
		saida=  "produto não encontrado!";
		return saida;
		
	}
	@Override
	public boolean pesquisa(int id) throws RemoteException{
		for(Produto p : produtos) {
			if (p.getId()== id) {
				return true;
			}
		}
		return false;
	}
	@Override
	public boolean removerProduto (int id) throws RemoteException{
		for (Produto p : produtos) {
			if(p.getId() == id) {
				produtos.remove(p);
				return true;
			}
		}
		return false;
	}
	@Override
	public boolean atualizaProduto(int id, String nome, float valor) throws RemoteException {
		for (Produto p : produtos) {
			if(p.getId()==id) {
				removerProduto(id);
				cadastoProduto(id, nome, valor);
				return true;
			}
		}
		return false;
	}
	
	public static Mensageiro getInstance() throws RemoteException{
		if (instance == null) {
			instance = new Controle();
		}
		return instance;
	}
	
	
}