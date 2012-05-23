package services;

import javax.ejb.Local;

import dao.PersonDao;
import domain.Person;



/***
 * 
 * @author A.Omorov
 *
 */

@Local
public interface PersonManager extends IBaseManager<Person, Integer, PersonDao> {
	
	Person login(String email, String password);
	
}
