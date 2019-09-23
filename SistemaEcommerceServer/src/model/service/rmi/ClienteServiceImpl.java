package model.service.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import model.dao.ClienteDaoImpl;
import model.dao.CrudDao;
import model.dao.CrudDaoImpl;
import model.domain.Cliente;

public class ClienteServiceImpl extends UnicastRemoteObject
	implements ClienteService {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private CrudDao<Cliente> crudDao;
	
	public ClienteServiceImpl() throws RemoteException{
		crudDao = new CrudDaoImpl<Cliente, Integer>(new ClienteDaoImpl());
	}

	@Override
	public void salvar(Cliente cliente) throws RemoteException {
		crudDao.salvarAtualizar(cliente);
	}

	@Override
	public void excluir(Cliente cliente) throws RemoteException {
		crudDao.excluir(cliente);
	}

	@Override
	public List<Cliente> pesquisar(Cliente cliente) throws RemoteException {
		return crudDao.pesquisar(cliente);
	}

}
