package daoImpl;

import java.util.List;

import javax.persistence.EntityManager;

import dao.FriendsDao;
import domain.Friends;



/***
 * 
 * @author dolphin
 *
 */

public class FriendsDaoImpl extends GenericDaoImpl<Friends, Integer> implements FriendsDao {

	public FriendsDaoImpl(EntityManager entityManager) {
		super(entityManager);
	}

	/* (non-Javadoc)
	 * @see dao.GenericDao#findEntries(int, int)
	 */
	@Override
	public List<Friends> findEntries(int firstResult, int maxResults) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see dao.GenericDao#findEntries(int, int)
	 */
	
	

	
}
