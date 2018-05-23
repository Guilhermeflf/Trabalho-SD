package Interface;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Mensageiro extends Remote{

	boolean cadastoProduto(int id, String nome, float valor) throws RemoteException;

	String pesquisaInfo(int id) throws RemoteException;

	boolean removerProduto(int id) throws RemoteException;

	boolean atualizaProduto(int id, String nome, float valor) throws RemoteException;

	boolean pesquisa(int id) throws RemoteException;		
}