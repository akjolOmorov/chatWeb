package services;

import javax.ejb.Local;

import dao.FriendsDao;
import domain.Friends;



/***
 * 
 * @author A.Omorov
 *
 */

@Local
public interface FriendsManager extends IBaseManager<Friends, Integer, FriendsDao> {
	

	
}
