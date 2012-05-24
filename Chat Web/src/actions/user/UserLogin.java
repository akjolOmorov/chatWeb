package actions.user;

import crypto.Digest;
import domain.Person;
import enums.Role;
import java.io.PrintStream;
import web.ChatAction;
import web.LoginUtil;

public  class UserLogin extends ChatAction {
	private static final long serialVersionUID = -6175869694383444227L;
	private Person person;

    public UserLogin (){};
    public String execute(){
    	return SUCCESS;
    }
    public String tryLogin(){
    	try {
			person.setPassword(new Digest("SHA-512").doEncypt(person.getPassword()));
			
			if(LoginUtil.login(getPerson())) {
				person=LoginUtil.getCurrentUser();
				System.out.println(person.getRole());
				if(person.getRole().equals(Role.ADMIN)){
						return "admin";
					}
				
				if(person.getRole().equals(Role.CLIENT)){
					return "client";
				}
			}
			addActionMessage(getText("loginFailed"));
			return INPUT;
		} catch (Exception e) {
			addActionMessage(getText("loginFailed"));
			return INPUT;
		}
    	
    	
    	
    }
    
   
	public String logout() throws Exception {
		LoginUtil.logout();
		return SUCCESS;
	}
    public Person getPerson(){
    	return person;
    }
    public void setPerson(Person person){
    	this.person=person;
    }

}
