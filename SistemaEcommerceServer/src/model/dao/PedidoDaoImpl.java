package model.dao;

import java.util.HashMap;
import java.util.Map;

import model.domain.Pedido;

public class PedidoDaoImpl  
	implements Crudavel<Pedido,Integer> {
	   
	@Override
	public Integer getChave(Pedido pedido) {
		return pedido.getNumero();
	}

	@Override
	public String getConsultaSql(Pedido pedido) {
		StringBuilder sql = new StringBuilder("from Pedido p "
                + "where 1 = 1 ");
        if (pedido.getNumero() != null) {
            sql.append("and p.numero = :numero ");
        }
        if (pedido.getCliente() != null) {
            sql.append("and p.cliente.codigo = :codigoCliente");
        }
        return sql.toString();
	}

	@Override
	public Map<String, Object> getParametrosMapa(Pedido pedido) {
		Map<String,Object> mapa = new HashMap<String, Object>();
		if (pedido.getNumero() != null) {
            mapa.put("numero",pedido.getNumero());            
        }
        if (pedido.getCliente() != null) {
        	mapa.put("codigoCliente",pedido.getCliente().getCodigo());            
        }
        return mapa;        
	}
}