package model.service.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import model.dao.ClienteDaoImpl;
import model.dao.CrudDao;
import model.dao.CrudDaoImpl;
import model.dao.PedidoDaoImpl;
import model.domain.Cliente;
import model.domain.Pedido;

public class PedidoServiceImpl	extends UnicastRemoteObject 
implements PedidoService {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private CrudDao<Pedido> crudDao;

	public PedidoServiceImpl() throws RemoteException {
		crudDao = new CrudDaoImpl<Pedido, Integer>(new PedidoDaoImpl());
	}

	@Override
	public List<Cliente> buscarClientes() throws RemoteException {
		CrudDao<Cliente> crudDao = 
				new CrudDaoImpl<Cliente, Integer>(new ClienteDaoImpl());
		return crudDao.pesquisar(new Cliente());
	}

	@Override
	public void salvar(Pedido pedido) throws RemoteException {
		crudDao.salvarAtualizar(pedido);
	}

	@Override
	public void excluir(Pedido pedido) throws RemoteException {
		crudDao.excluir(pedido);

	}

	@Override
	public List<Pedido> pesquisar(Pedido pedido) throws RemoteException {
		return crudDao.pesquisar(pedido);
	}

}
