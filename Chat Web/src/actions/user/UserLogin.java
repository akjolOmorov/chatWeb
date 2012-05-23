package actions.user;

import crypto.Digest;
import domain.Person;
import enums.Role;
import java.io.PrintStream;
import web.ChatAction;
import web.LoginUtil;

public  class UserLogin extends ChatAction {

    private static final long serialVersionUID = 14821602085006426112;
    private Person person;

    public UserLogin (){};
    public String execute(){
    	return SUCCESS;
    }
    public String tryLogin(){
    	
    	
    	return "input";
    }
    public Person getPerson(){
    	return person;
    }
    public void setPerson(Person person){
    	this.person=person;
    }

}
