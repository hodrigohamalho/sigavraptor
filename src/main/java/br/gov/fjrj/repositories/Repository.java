package br.gov.fjrj.repositories;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public abstract class Repository<T, I extends Serializable> {
	
	protected final Session session;
	protected final Class<T> clazz;

	protected Repository(Session session) {
		this.session = session;
		
		@SuppressWarnings("unchecked")
		Class<T> clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

		this.clazz = clazz;
	}
	
	public void create(T entity) {
		session.persist(entity);
	}
	
	public void update(T entity) {
		session.update(entity);
	}
	
	public void destroy(T entity) {
		session.delete(entity);
	}
	
	@SuppressWarnings("unchecked")
	public T find(I id) {
		return (T) session.load(clazz, id);
	}
	
	public List<T> findAll() {
		String hql = "from " + clazz.getName();
		Query query = session.createQuery(hql);

		@SuppressWarnings("unchecked")
		List<T> resultList = query.list();

		return resultList;
	}
}