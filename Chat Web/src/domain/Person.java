package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import enums.Role;

/***
 * 
 * @author A.Omorov
 *
 */

@Access(AccessType.PROPERTY)
@Cacheable(true)
@Entity
@Table(name="person", uniqueConstraints=@UniqueConstraint(columnNames="username"))
public class Person extends AbstractEntity<Integer> {

	private static final long serialVersionUID = -2364219456977430260L;
	private String fullName;
	private String username;
	private String password;
	private Role role;
	
	private String email;
	
	
	public Person() {
		
	}
	
	@NotNull(message="fullNameIsRequired")
	public String getFullName() {
		return fullName;
	}
	
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	@Size(min=1, message="userNameIsRequired")

	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	@Pattern(regexp = "^[\\w-]+(\\.[\\w-]+)*@([a-z0-9-]+(\\.[a-z0-9-]+)*?\\.[a-z]{2,6}|(\\d{1,3}\\.){3}\\d{1,3})(:\\d{4})?$", message="emailIsWrong")
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	



	@Enumerated(EnumType.STRING)
	@Column(name="role")
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
