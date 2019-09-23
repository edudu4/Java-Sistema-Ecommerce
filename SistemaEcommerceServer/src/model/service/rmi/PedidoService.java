package model.service.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import model.domain.Cliente;
import model.domain.Pedido;

public interface PedidoService extends Remote {
	
	static final String NOME_SERVICO = "ServicoPedido";
	
	static final String URL_SERVICO = "rmi://127.0.0.1/"+NOME_SERVICO;
    
    List<Cliente> buscarClientes() throws RemoteException;
    
    public void salvar(Pedido pedido) throws RemoteException;
	
	public void excluir(Pedido pedido) throws RemoteException;
	
	public List<Pedido> pesquisar(Pedido pedido) throws RemoteException;

}
