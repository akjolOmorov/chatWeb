package dao;

import domain.Person;



/***
 * 
 * @author dolphin
 *
 */

public interface PersonDao extends GenericDao<Person, Integer> {
	
	Person login(String email, String password);
	
}
