package services;

import java.io.Serializable;
import java.util.List;

import javax.persistence.PersistenceException;
import javax.validation.Validator;

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

public interface IBaseManager<T extends PersistentEntity<ID>, ID extends Serializable, D extends GenericDao<T, ID>> {
	
	/**
     * @return DAO
     */
	D getDao();
	
	/***
	 * 
	 * @return
	 */
	Validator getValidator();
	
    /**
     * @param entity
     * @return
     */
    T save(T entity) throws PersistenceException;
    
    /**
     * @param entity
     * @return
     */
    T update(T entity) throws PersistenceException;    
 
    /**
     * @param entity
     */
    void delete(T entity) throws PersistenceException;
    
    /**
     * @param refresh
     */
    void refresh(T entity);
    
    /**
     * @return
     */
    long countAll() throws PersistenceException;
    
    /**
     * @param l
     * @param lock
     * @return
     */
    T findById(ID id, boolean lock) throws PersistenceException;
    
    /***
     * 
     * @param id
     * @param fields
     * @return
     */
    T findByIdWithFields(ID id, String[] fields);
    
    /***
	 * 
	 * @param property
	 * @param value
	 * @return
	 */
	List<T> findByProperty(String property, Object value);
	
	/***
	 * 
	 * @param property
	 * @param value
	 * @return
	 */
	Long countByProperty(String property, Object value);
	
	/***
	 * 
	 * @param property
	 * @param value
	 * @param fields
	 * @return
	 */
	List<T> findByPropertyWithFields(String property, Object value, String[] fields);
    
    /**
     * @return
     */
    List<T> findAll();
    
    /**
     * @param firstResult
     * @param maxResults
     * @return
     */
    List<T> findEntries(int firstResult, int maxResults);

	 /**
     * @param clazz
     * @param paginatedList
     * @return
     */

    /**
     * @return void
     */
    void evict(ID id);
    
}
