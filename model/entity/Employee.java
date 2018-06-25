package model.entity;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Employee {

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY) private Long id;
	@Persistent private String name;
	@Persistent private String age;
	@Persistent private String salary;
	@Persistent private String address;
	@Persistent private String date;
	@Persistent private String dni;
	@Persistent private String email;

	public Employee(String name, String age, String salary, String address, String dni, String email) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.address = address;
		this.dni = dni;
		this.email = email;

		Locale l = new Locale("es","PE");
		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("America/Lima"),l);
		SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE MMMM d HH:mm:ss yyyy");
		this.date = dateFormat.format(cal.getTime());
	}

	public String getEmail(){
		return email;
	}
	public void setEmail( String email){
		this.email = email;
	}
	public String getDni(){
		return dni;
	}
	public void setDni(String dni){
		this.dni = dni;
	}
	public Long getId(){
		return id;
	}
	public void setId(Long id){
		this.id = id;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	public String getDate(){
		return this.date;
	}
}
