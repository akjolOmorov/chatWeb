package serviceImpl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.validation.Validator;

import org.displaytag.properties.SortOrderEnum;

import services.IBaseManager;

import dao.GenericDao;
import domain.PersistentEntity;

/****
 * 
 * @author dolphin
 *
 * @param <T>
 * @param <ID>
 * @param <D>
 */

public abstract class BaseManager<T extends PersistentEntity<ID>, ID extends Serializable, D extends GenericDao<T, ID>> implements IBaseManager<T, ID, D> {

	@Resource Validator validator;
	
	@Override
	public T save(T entity) throws PersistenceException {
		return getDao().makePersistent(entity);
	}

	@Override
	public T update(T entity) throws PersistenceException {
		return getDao().makeMerged(entity);
	}

	@Override
	public void delete(T entity) {
		getDao().makeTransient(getDao().makeMerged(entity));
	}
	
	@Override
	public void refresh(T entity) {
		getDao().makeRefresh(getDao().makeMerged(entity));
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public long countAll() {
		return getDao().countAll();
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public T findById(ID id, boolean lock) {
		try {
			return getDao().findById(id, lock);
		} catch (NoResultException e) {
			return null;
		}
	}
	
	public T findByIdWithFields(ID id, String[] fields){
		try {
			return getDao().getByIdWithFields(id, fields) ;
		} catch (NoResultException e) {
			return null;
		}
	}
	
	@Override
	public Long countByProperty(String property, Object value) {
		try {
			return getDao().countByProperty(property, value);
		} catch (NoResultException e) {
			return null;
		}
	}
	
	@Override
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<T> findByProperty(String property, Object value) {
		try {
			return getDao().findByProperty(property, value);
		} catch (NoResultException e) {
			return null;
		}
	}
	
	@Override
	public List<T> findByPropertyWithFields(String property, Object value, String[] fields){
		try {
			return getDao().fingByProperty(property, value, fields);
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<T> findAll() {
		return getDao().findAll();
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<T> findEntries(int firstResult, int maxResults) {
		return getDao().findEntries(firstResult, maxResults);
	}
	
	

	@Override
	public Validator getValidator() {
		return validator;
	}
	
	@Override
    public void evict(ID id){
		getDao().evict(id);
	}

}
