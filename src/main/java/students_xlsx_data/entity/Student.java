package students_xlsx_data.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PersistenceUnit;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@PersistenceUnit(unitName="stud")
@Entity
@Table(name = "students_data")
public class Student implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "STUDENTS_ID_GENERATOR", sequenceName = "students_data_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STUDENTS_ID_GENERATOR")
	@Column(unique = true, nullable = false)
	private int id;
	
	@Column
	private  String firstName;
	
	@Column
    private String lastName;
    
	@Column
    private String age;
    
	@Column
    private String birthday;
    
	@Column
    private  String faculty;
	
	public Student() {
    }
	

	public Student(String firstName, String lastName, String age, String birthday, String faculty) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.birthday = birthday;
        this.faculty = faculty;
    }
	
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }


	@Override
	public String toString() {
		return "Student [id= " + id + ", firstName= " + firstName + ", lastName= " + lastName + ", age= " + age
				+ ", birthday= " + birthday + ", faculty= " + faculty + "]";
	}
    
}
