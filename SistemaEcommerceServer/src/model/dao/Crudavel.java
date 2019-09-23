package model.dao;

import java.io.Serializable;
import java.util.Map;

public interface Crudavel<E extends Serializable,I> {
	
	public abstract I getChave(E e);
	
	public abstract String getConsultaSql(E e);
	
	public abstract Map<String,Object> getParametrosMapa(E e);


}
