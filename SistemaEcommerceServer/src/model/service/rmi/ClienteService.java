package model.service.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import model.domain.Cliente;

public interface ClienteService extends Remote {
	
	static final String NOME_SERVICO = "ServicoCliente";
	
	static final String URL_SERVICO = "rmi://127.0.0.1/"+NOME_SERVICO;
	
	public void salvar(Cliente cliente) throws RemoteException;
	
	public void excluir(Cliente cliente) throws RemoteException;
	
	public List<Cliente> pesquisar(Cliente cliente) throws RemoteException;
    
}
