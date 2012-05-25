package services;

import javax.ejb.Local;

import dao.ConversationDao;
import domain.Conversation;



/***
 * 
 * @author A.Omorov
 *
 */

@Local
public interface ConversationManager extends IBaseManager<Conversation, Integer, ConversationDao> {
	

	
}
