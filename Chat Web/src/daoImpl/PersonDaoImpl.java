package daoImpl;

import java.util.List;

import javax.persistence.EntityManager;

import dao.PersonDao;
import domain.Person;



/***
 * 
 * @author dolphin
 *
 */

public class PersonDaoImpl extends GenericDaoImpl<Person, Integer> implements PersonDao {

	public PersonDaoImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public Person login(String email, String password) {
		Person person = null;
		try {
			person = getEntityManager().createQuery("SELECT person FROM Person person WHERE UPPER(username) = UPPER(:username) AND password=:password", Person.class)
					.setParameter("username", email).setParameter("password", password).setMaxResults(1).getSingleResult();
		} catch (Exception e) {
			return null;
		}
		return person;
	}

	/* (non-Javadoc)
	 * @see dao.GenericDao#findEntries(int, int)
	 */
	@Override
	public List<Person> findEntries(int firstResult, int maxResults) {
		// TODO Auto-generated method stub
		return null;
	}

}
