package web;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.validation.Validator;

import serviceImpl.ConversationManagerBean;
import serviceImpl.FriendsManagerBean;
import serviceImpl.PersonManagerBean;
import services.ConversationManager;
import services.FriendsManager;
import services.PersonManager;
import util.ServiceLocator;
import util.ServiceLocatorException;

import com.mirbek.struts2.common.actions.BaseAction;

import domain.Person;

/***
 * 
 * @author dolphin
 *
 */

public class ChatAction extends BaseAction {
	
	private static final long serialVersionUID = 8716665701526156179L;
	protected Person currentUser = null;
	protected String backUrl; 

	public ChatAction() {
		super();
	}
	
	public boolean isLogged() {
		System.out.println("isLogged = " + LoginUtil.isLogged());
		return LoginUtil.isLogged();
	}
	
	
	protected PersonManager getPersonManager(){
		try {
			return (PersonManager) ServiceLocator.getInstance().getObject(PersonManagerBean.class);
		} catch (ServiceLocatorException e) {
			e.printStackTrace();
			return null;
		}
	}
	protected FriendsManager getFriendsManager(){
		try {
			return (FriendsManager) ServiceLocator.getInstance().getObject(FriendsManagerBean.class);
		} catch (ServiceLocatorException e) {
			e.printStackTrace();
			return null;
		}
	}
	protected ConversationManager getConversationManager(){
		try {
			return (ConversationManager) ServiceLocator.getInstance().getObject(ConversationManagerBean.class);
		} catch (ServiceLocatorException e) {
			e.printStackTrace();
			return null;
		}
	}

	
	
	
}
