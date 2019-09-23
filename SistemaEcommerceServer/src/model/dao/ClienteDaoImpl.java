/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.HashMap;
import java.util.Map;

import model.domain.Cliente;

/**
 *
 * @author Eduardo
 */
public class ClienteDaoImpl  
	implements Crudavel<Cliente,Integer> {
    
	@Override
	public Integer getChave(Cliente cliente) {
		return cliente.getCodigo();
	}


	@Override
	public String getConsultaSql(Cliente cliente) {
        StringBuilder sql = new StringBuilder("from Cliente c "
                + "where 1 = 1 ");
        if (cliente.getCodigo() != null) {
            sql.append("and c.codigo = :codigo ");
        }
        if (cliente.getNome() != null && 
                !cliente.getNome().equals("")) {
            sql.append("and c.nome like :nome");
        }
        return sql.toString();
	}

	@Override
	public Map<String, Object> getParametrosMapa(Cliente cliente) {
		Map<String,Object> mapa = new HashMap<String, Object>();
		if (cliente.getCodigo() != null) {
            mapa.put("codigo",cliente.getCodigo());            
        }
        if (cliente.getNome() != null && 
                !cliente.getNome().equals("")) {
            mapa.put("nome", cliente.getNome());            
        }
        return mapa;
	}
    
}
