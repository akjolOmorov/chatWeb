package daoImpl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceException;
import dao.GenericDao;
import domain.PersistentEntity;



/****
 * 
 * @author dolphin
 *
 * @param <T>
 * @param <ID>
 */

public abstract class GenericDaoImpl<T extends PersistentEntity<ID>, ID extends Serializable> implements GenericDao<T, ID> {

	private Class<T> persistentClass;
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public GenericDaoImpl(EntityManager entityManager) {
		this.persistentClass = (Class<T>) ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		this.entityManager = entityManager;
	}
	
	protected EntityManager getEntityManager()
	{
	    return entityManager;
	}
	
	@Override
	public void begin() {
		entityManager.getTransaction().begin();
	}
	
	@Override
	public void end() {
		entityManager.getTransaction().commit();		
	}

	/**
	 * 
	*/
	public void flush() {
	  getEntityManager().flush();
	}
	 
	  /**
	  * 
	  */
	   public void clear() {
	       getEntityManager().clear();
	  }
	  
	  /**
       * @return
       */
      protected Class<T> getPersistentClass() {
    	  return persistentClass;
      }

	
	@Override
	public T makePersistent(T entity) throws PersistenceException {
		getEntityManager().persist(entity);
		return entity;
	}
	
	@Override
	public T makeMerged(T entity) {
		return getEntityManager().merge(entity);
	};

	@Override
	public void makeTransient(T entity) {
		getEntityManager().remove(entity);
	}
	
	@Override
	public void makeRefresh(T entity) {
		getEntityManager().refresh(entity);
	};
	
	@Override
	public long countAll() {
		return getEntityManager().createQuery(new StringBuilder("select count(*) from ")
			.append(getPersistentClass().getName()).toString(), Long.class).getSingleResult();
	}

	@Override
	public T findById(ID id, boolean lock) {
		 T entity;
	        if (lock)
	            entity = (T) getEntityManager().find(getPersistentClass(), id, LockModeType.WRITE);
	        else
	            entity = (T) getEntityManager().find(getPersistentClass(), id);
	 
	        return entity;
	}

	@Override
	public List<T> findAll() {
		return getEntityManager().createQuery(new StringBuilder("select entity from ").append(getPersistentClass().getSimpleName())
				.append(" as entity").toString(), getPersistentClass()).getResultList();

	}



	@Override
	public void evict(ID id) {
		getEntityManager().getEntityManagerFactory().getCache().evict(getPersistentClass(), id);
	}

	@Override
	public void evictByEntity() {
		getEntityManager().getEntityManagerFactory().getCache().evict(getPersistentClass());
	}

	@Override
	public void evictAll() {
		getEntityManager().getEntityManagerFactory().getCache().evictAll();
	}
	
	@Override
	public Long countByProperty(String property, Object value) {
		String query = new StringBuilder("select count(entity) from ").append(getPersistentClass().getSimpleName())
				.append(" as entity where entity." + property + " = :property").toString();
		return getEntityManager().createQuery(query, Long.class).setParameter("property", value).getSingleResult();
	}
	
	@Override
	public List<T> findByProperty(String property, Object value) {
		String query = new StringBuilder("select entity from ").append(getPersistentClass().getSimpleName())
				.append(" as entity where entity." + property + " = :property").toString();
		return getEntityManager().createQuery(query, getPersistentClass()).setParameter("property", value).getResultList();
	}

	@Override
	public List<T> fingByProperty(String property, Object value, String[] fields) {
		StringBuffer buffer = new StringBuffer("SELECT entity FROM ");
		buffer.append(getPersistentClass().getSimpleName());
		buffer.append(" AS entity");
		for (String string : fields) {
			buffer.append(" LEFT JOIN FETCH entity." + string);
		}
		buffer.append(" where entity." + property + " = :property");
		return getEntityManager().createQuery(buffer.toString(), getPersistentClass()).setParameter("property", property).getResultList();
	}

	@Override
	public T getByIdWithFields(ID id, String[] fields) {
		StringBuffer buffer = new StringBuffer("SELECT entity FROM ");
		buffer.append(getPersistentClass().getSimpleName());
		buffer.append(" AS entity");
		for (String string : fields) {
			buffer.append(" LEFT JOIN FETCH entity." + string);
		}
		buffer.append(" where entity.id = :id");
		return getEntityManager().createQuery(buffer.toString(), getPersistentClass()).setParameter("id", id).getSingleResult();
	}

	

}