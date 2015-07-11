package model.tdo;

public class Student {
	private String id;
	private String name;
	private int gender;
	private String university;
	private String stu_class;
	private int status;
	
	public Student(String id, String name, int gender, String university, String stu_class, int status){
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.university = university;
		this.stu_class = stu_class;
		this.status = status;
	}

	public Student() {
		// TODO Auto-generated constructor stub
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getUniversity() {
		return university;
	}
	public void setUniversity(String university) {
		this.university = university;
	}
	public String getStu_class() {
		return stu_class;
	}
	public void setStu_class(String stu_class) {
		this.stu_class = stu_class;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}
