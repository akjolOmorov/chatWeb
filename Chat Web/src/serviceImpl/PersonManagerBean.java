package serviceImpl;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.enterprise.inject.Alternative;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import services.PersonManager;

import dao.PersonDao;
import daoImpl.PersonDaoImpl;
import domain.Person;


/****
 * 
 * @author dolphin
 *
 */

@Alternative
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class PersonManagerBean extends BaseManager<Person, Integer, PersonDao> implements PersonManager {
	
	@PersistenceContext(name="etender") 
	private EntityManager em;
	private PersonDao dao;
	
	@PostConstruct
	public void initialize() {
		dao = new PersonDaoImpl(em);
		System.out.println("entityManager is " + em + " " + getValidator());
	}
	
	@Override
	public PersonDao getDao() {
		return dao;
	}
	
	@Override
	public Person login(String username, String password) {
		return getDao().login(username, password);
	}
	
}
