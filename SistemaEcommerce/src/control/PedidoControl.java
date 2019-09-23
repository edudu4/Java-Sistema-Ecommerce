/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.domain.Cliente;
import model.domain.Pedido;
import model.service.ServiceLocator;
import model.service.rmi.PedidoService;
import org.jdesktop.observablecollections.ObservableCollections;
import util.ValidacaoException;

/**
 *
 * @author Eduardo
 */
public final class PedidoControl {

    private final PropertyChangeSupport propertyChangeSupport = 
            new PropertyChangeSupport(this);
    
    private Pedido pedidoDigitado;
    
    private Pedido pedidoSelecionado;
    
    private List<Cliente> clientesTabela;
    
    private List<Pedido> pedidosTabela;
    
    private final PedidoService pedidoService;
    
    public PedidoControl() throws RemoteException {
        pedidoService = ServiceLocator.getPedidoService();
        pedidosTabela = ObservableCollections.observableList(
                new ArrayList<Pedido>());
        clientesTabela = ObservableCollections.observableList(
                new ArrayList<Cliente>());
        clientesTabela.addAll(pedidoService.buscarClientes());
        novo();
        pesquisar();
    }
    
    public void novo() {
       setPedidoDigitado(new Pedido()); 
    }   

    public void pesquisar() throws RemoteException {
        pedidosTabela.clear();
        pedidosTabela.addAll(pedidoService.pesquisar(pedidoDigitado));
    }
    
    public void salvar() throws ValidacaoException,RemoteException {
        pedidoDigitado.validar();
        pedidoDigitado.setDataHora(new Date());
        pedidoService.salvar(pedidoDigitado);
        novo();
        pesquisar();
    }
    
    public void excluir() throws RemoteException{
        pedidoService.excluir(pedidoDigitado);
        novo();
        pesquisar();
    }

    public Pedido getPedidoDigitado() {
        return pedidoDigitado;
    }

    public void setPedidoDigitado(Pedido pedidoDigitado) {
        Pedido oldPedidoDigitado = this.pedidoDigitado;
        this.pedidoDigitado = pedidoDigitado;
        propertyChangeSupport.firePropertyChange(
        "pedidoDigitado",oldPedidoDigitado,pedidoDigitado);
    }

    public Pedido getPedidoSelecionado() {
        return pedidoSelecionado;
    }

    public void setPedidoSelecionado(Pedido pedidoSelecionado) {
        this.pedidoSelecionado = pedidoSelecionado;
        if (this.pedidoSelecionado != null) {
            setPedidoDigitado(pedidoSelecionado);
        }
    }

    public List<Pedido> getPedidosTabela() {
        return pedidosTabela;
    }

    public void setPedidosTabela(List<Pedido> pedidosTabela) {
        this.pedidosTabela = pedidosTabela;
    }

    public List<Cliente> getClientesTabela() {
        return clientesTabela;
    }

    public void setClientesTabela(List<Cliente> clientesTabela) {
        this.clientesTabela = clientesTabela;
    }
    
    public void addPropertyChangeListener(PropertyChangeListener e) {
        propertyChangeSupport.addPropertyChangeListener(e);
    }
    
    public void removePropertyChangeListener(PropertyChangeListener e) {
        propertyChangeSupport.removePropertyChangeListener(e);
    }

}
