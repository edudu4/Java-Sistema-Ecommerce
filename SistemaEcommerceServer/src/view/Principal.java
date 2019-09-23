package view;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import model.service.rmi.ClienteService;
import model.service.rmi.ClienteServiceImpl;
import model.service.rmi.PedidoService;
import model.service.rmi.PedidoServiceImpl;

public class Principal {

	public static void main(String[] args) {
		try {
			System.out.println("Tentando subir o serviço");
			LocateRegistry.createRegistry(1099);
			Naming.rebind(ClienteService.NOME_SERVICO, new ClienteServiceImpl());
			Naming.rebind(PedidoService.NOME_SERVICO, new PedidoServiceImpl());
			System.out.println("Serviço de pé");
		} catch (Exception e) {
			System.out.println("Erro ao iniciar o serviço " + e);
		}
	}
}
