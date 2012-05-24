package web;

import constants.ScopeConstants;

import serviceImpl.PersonManagerBean;
import services.PersonManager;
import util.ServiceLocator;

import domain.Person;



/***
 * 
 * @author dolphin
 *
 */

public class LoginUtil {
		
	public static final String CURRENT_USER_SESSION_KEY = "org.infosystema.projects.etender.current_user_session_key";
	public static final String CURRENT_LANGUAGE_SESSION_KEY = "org.infosystema.projects.etender.current_language_session_key";
	
	public static boolean login(Person person) {
		
		try {
			PersonManager manager = (PersonManager)ServiceLocator.getInstance().getObject(PersonManagerBean.class);
			System.out.println(person.getUsername() + " " + person.getPassword());
			Person managedPerson = manager.login(person.getUsername(), person.getPassword());
			if(managedPerson == null) return false;
			setCurrentUser(manager.findById(managedPerson.getId(),false));
			System.out.println(person.getUsername() + " " + person.getPassword());
			//MessagesUtil.addMessage("Login successed!");
			return true;
		} catch (Exception e) {
			System.out.println("Login failed: " + e);
			e.printStackTrace();
			//MessagesUtil.addMessage("Login failed!");
			return false;
		}
		
	}
	
	public static boolean login(String name, String password) {
		Person person = new Person();
		person.setEmail(name);
		person.setPassword(password);
		return login(person);
	}
	
	public static boolean userHasRole(Person person, String roleName) {
		
		if(roleName == null) return false;
			
		if(person.getRole().toString().equals(roleName))
				return true;
			
		
		return false;		
	}
	
	
	public static void setCurrentUser(Person person) {
		new Struts2ScopeQualifier().setValue(CURRENT_USER_SESSION_KEY, person, ScopeConstants.SESSION_SCOPE);
	}
	
	public static Person getCurrentUser() {
		return new Struts2ScopeQualifier().getValue(CURRENT_USER_SESSION_KEY, ScopeConstants.SESSION_SCOPE);
	}
	
	public static boolean isLogged() {
		Person person = new Struts2ScopeQualifier().getValue(CURRENT_USER_SESSION_KEY, ScopeConstants.SESSION_SCOPE);
		System.out.println("user = " + person);
		return (person == null ? false : true);
	}
	
	public static void logout() {
		new Struts2ScopeQualifier().remove(CURRENT_USER_SESSION_KEY, ScopeConstants.SESSION_SCOPE);
	}
	
}
