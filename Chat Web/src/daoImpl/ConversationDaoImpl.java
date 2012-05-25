package daoImpl;

import java.util.List;

import javax.persistence.EntityManager;

import dao.ConversationDao;
import domain.Conversation;



/***
 * 
 * @author dolphin
 *
 */

public class ConversationDaoImpl extends GenericDaoImpl<Conversation, Integer> implements ConversationDao {

	public ConversationDaoImpl(EntityManager entityManager) {
		super(entityManager);
	}

	/* (non-Javadoc)
	 * @see dao.GenericDao#findEntries(int, int)
	 */
	@Override
	public List<Conversation> findEntries(int firstResult, int maxResults) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see dao.GenericDao#findEntries(int, int)
	 */
	
	

	
}
