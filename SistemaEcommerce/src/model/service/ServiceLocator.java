/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import model.service.rmi.ClienteService;
import model.service.rmi.PedidoService;

/**
 *
 * @author Eduardo
 */
public class ServiceLocator {

    public static ClienteService getClienteService() throws RemoteException{
        try {
            return (ClienteService)Naming.lookup(ClienteService.URL_SERVICO);
        } catch(NotBoundException | MalformedURLException | RemoteException e ){
            throw new RemoteException(e.getMessage());
        }       
    }
    
    public static PedidoService getPedidoService() throws RemoteException{
        try {
            return (PedidoService)Naming.lookup(PedidoService.URL_SERVICO);
        } catch(NotBoundException | MalformedURLException | RemoteException e ){
            throw new RemoteException(e.getMessage());
        }       
    }
}
