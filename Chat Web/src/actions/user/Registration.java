package actions.user;

import domain.Person;
import java.util.ArrayList;
import java.util.List;

import crypto.Digest;
import web.ChatAction;

public  class Registration extends ChatAction {
	private static final long serialVersionUID = -3345200700429308023L;
	private Person person;
    private String passwordConfirmation;
    private List<String> roles;

    public Registration (){
    	
    }
    
    public String execute(){
    	setRoles(new ArrayList<String>());
    	roles.add("ADMIN");
    	roles.add("CLIENT");
    	return SUCCESS;
    }
    public String register(){
    	setRoles(new ArrayList<String>());
    	roles.add("ADMIN");
    	roles.add("CLIENT");
    	if((person.getPassword().equals(passwordConfirmation))&&(passwordConfirmation!=null)){
    		try{
    		Digest digest = new Digest("SHA-512");
			person.setPassword(digest.doEncypt(person.getPassword()));
			getPersonManager().save(person);
			return SUCCESS;
			
    		}catch(Exception e){}
    	}
    		
    	return "input";
    }
    public Person getPerson(){
    	return person;
    }
    public void setPerson(Person person){
    	this.person=person;
    }

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
    

}
