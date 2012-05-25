/**
 * 
 */
package actions.user;

import java.util.ArrayList;
import java.util.List;

import domain.Friends;
import domain.Person;
import web.ChatAction;
import web.LoginUtil;

/**
 *
 * @author A.Omorov
 */
public class FriendRelations extends ChatAction {
	private static final long serialVersionUID = 1497365735251923303L;
	private int id;
	private Friends friends;
	private String login;
	private List<Person> people; 
	private List<Friends> friendList;
	public String execute(){
		
		
		friendList=getFriendsManager().findByProperty("person", LoginUtil.getCurrentUser());
		
		return SUCCESS;
	}
	public String search(){		
		people=getPersonManager().findByProperty("username", login);
		return SUCCESS;
	}
	public String addFriend(){		
		friends=new Friends();
		friends.setPerson(LoginUtil.getCurrentUser());
		friends.setFriend(getPersonManager().findById(id, false));
		getFriendsManager().save(friends);
		
		
		
		return SUCCESS;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public List<Person> getPeople() {
		return people;
	}
	public void setPeople(List<Person> people) {
		this.people = people;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Friends getFriends() {
		return friends;
	}
	public void setFriends(Friends friends) {
		this.friends = friends;
	}
	public List<Friends> getFriendList() {
		return friendList;
	}
	public void setFriendList(List<Friends> friendList) {
		this.friendList = friendList;
	}
	

}
