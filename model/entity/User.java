package model.entity;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class User {

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY) private Long id;
	@Persistent private String email;
	@Persistent private Long role;
	@Persistent private boolean status;
	public User(){}
	
	public User(String email, Long role) {
		super();
		this.email = email;
		this.role = role;
		this.status = true;
	}
	
	public boolean getStatus(){
		return this.status;
	}
	public void setStatus(boolean status){
		this.status = status;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getRole() {
		return role;
	}

	public void setRole(Long role) {
		this.role = role;
	}
}
