package model.entity;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Access {

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY) private Long id;
	@Persistent private Long role;
	@Persistent private Long resource;
	@Persistent private boolean status;
	
	public Access(){}
	public Access(Long role, Long resource) {
		super();
		this.role = role;
		this.resource = resource;
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
	public Long getRole() {
		return role;
	}
	public void setRole(Long role) {
		this.role = role;
	}
	public Long getResource() {
		return resource;
	}
	public void setResource(Long resource) {
		this.resource = resource;
	}
}
