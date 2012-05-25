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

import services.ConversationManager;

import dao.ConversationDao;
import daoImpl.ConversationDaoImpl;
import domain.Conversation;


/****
 * 
 * @author A.Omorov
 *
 */

@Alternative
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class ConversationManagerBean extends BaseManager<Conversation, Integer, ConversationDao> implements ConversationManager {
	

	private EntityManager em;
	private ConversationDao dao;
	
	@PostConstruct
	public void initialize() {
		dao = new ConversationDaoImpl(em);
		System.out.println("entityManager is " + em + " " + getValidator());
	}
	
	@Override
	public ConversationDao getDao() {
		return dao;
	}

	/* (non-Javadoc)
	 * @see services.ConversationManager#login(java.lang.String, java.lang.String)
	 */
	
	
	
}
