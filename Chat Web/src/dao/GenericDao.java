package dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.PersistenceException;

import domain.PersistentEntity;



/**
 * @author Kuttubek Aidaraliev
 *
 * @param <T> Entity
 * @param <ID> Identification for entity
 */
public interface GenericDao<T extends PersistentEntity<ID>, ID extends Serializable> {
 
    /**
     * @param entity
     * @return
     */
    T makePersistent(T entity) throws PersistenceException;
 
    /**
     * @param entity
     */
    void makeTransient(T entity);
    
    /**
     * @param entity
     */
    T makeMerged(T entity);
    
    /**
     * @param refresh
     */
    void makeRefresh(T entity);
    
    /**
     * @return
     */
    long countAll();
    
    /**
     * @param id
     * @param lock
     * @return
     */
    T findById(ID id, boolean lock);
    
    /**
     * @param id
     * @param fields fields that include
     * @return
     */
	T getByIdWithFields(ID id, String[] fields);
	
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
	 * @return
	 */
	List<T> findByProperty(String property, Object value);
	
	/***
	 * 
	 * @param property
	 * @param value
	 * @param fields
	 * @return
	 */
	List<T> fingByProperty(String property, Object value, String[] fields);
	
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
     * @param firstResult
     * @param maxResults
     * @param sort
     * @return
     */
 
    /**
     * @return void
     */
    void begin();
    
    /**
     * @return void
     */
    void end();
    
    /**
     * @return void
     */
    void evict(ID id);
    
    /**
     * @return void
     */
    void evictByEntity();
    
    /**
     * @return void
     */
    void evictAll();

}

