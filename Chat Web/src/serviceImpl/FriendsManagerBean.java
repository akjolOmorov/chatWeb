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

import services.FriendsManager;

import dao.FriendsDao;
import daoImpl.FriendsDaoImpl;
import domain.Friends;


/****
 * 
 * @author A.Omorov
 *
 */

@Alternative
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class FriendsManagerBean extends BaseManager<Friends, Integer, FriendsDao> implements FriendsManager {
	
	@PersistenceContext
	private EntityManager em;
	private FriendsDao dao;
	
	@PostConstruct
	public void initialize() {
		dao = new FriendsDaoImpl(em);
		System.out.println("entityManager is " + em + " " + getValidator());
	}
	
	@Override
	public FriendsDao getDao() {
		return dao;
	}

	/* (non-Javadoc)
	 * @see services.FriendsManager#login(java.lang.String, java.lang.String)
	 */
	
	
	
}
