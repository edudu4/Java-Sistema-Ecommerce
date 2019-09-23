package model.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class CrudDaoImpl<E extends Serializable,I> implements CrudDao<E> {
	
	private Crudavel<E, I> crudavel;
		
	public CrudDaoImpl(Crudavel<E, I> crudavel) {
		this.crudavel = crudavel;
	}
	
	@Override
    public void salvarAtualizar(E e) {
        EntityManager em = Conexao.getEntityManager();
        em.getTransaction().begin();
        if (crudavel.getChave(e) != null) {
            e = em.merge(e);
        }
        em.persist(e);
        em.getTransaction().commit();
        em.close();
    }
    
	@Override
    public void excluir(E e) {
        EntityManager em = Conexao.getEntityManager();
        em.getTransaction().begin();
        e = em.merge(e);
        em.remove(e);
        em.getTransaction().commit();
        em.close();
    }
    
	@Override
    @SuppressWarnings("unchecked")
    public List<E> pesquisar(E e) {
        EntityManager em = Conexao.getEntityManager();
        Query query = em.createQuery(crudavel.getConsultaSql(e));
        Map<String,Object> parametros = crudavel.getParametrosMapa(e);
        for (String chave:parametros.keySet()) {
        	query.setParameter(chave,parametros.get(chave));
        }
        return query.getResultList();
     }

}
