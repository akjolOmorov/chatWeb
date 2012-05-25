package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author A.Omorov
 */
@Access(AccessType.PROPERTY)
@Cacheable(true)
@Entity
@Table(name="conversation")
public class Conversation extends AbstractEntity<Integer> {
	private static final long serialVersionUID = -1712716513986944385L;
	private Person from;
	private Person to;
	private String conversation;
	@ManyToOne
	@JoinColumn(name="fromPerson")
	public Person getFrom() {
		return from;
	}
	public void setFrom(Person from) {
		this.from = from;
	}
	@ManyToOne
	@JoinColumn(name="toPerson")
	public Person getTo() {
		return to;
	}
	public void setTo(Person to) {
		this.to = to;
	}
	public String getConversation() {
		return conversation;
	}
	public void setConversation(String conversation) {
		this.conversation = conversation;
	}
	
	
	
}

	