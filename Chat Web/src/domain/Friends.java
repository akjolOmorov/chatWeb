package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author A.Omorov
 */
@Access(AccessType.PROPERTY)
@Cacheable(true)
@Entity
@Table(name="friends")
public class Friends extends AbstractEntity<Integer> {
	private static final long serialVersionUID = -1712716513986944385L;
	private Person person;
	private Person friend;
	private boolean active;

	@ManyToOne
	@JoinColumn(name="friend_id")
	public Person getPerson() {
		return person;
	}
	
	public void setPerson(Person person) {
		this.person = person;
	}

	@ManyToOne
	@JoinColumn(name="friend2_id")
	public Person getFriend() {
		return friend;
	}
	

	public void setFriend(Person friend) {
		this.friend = friend;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
}

	