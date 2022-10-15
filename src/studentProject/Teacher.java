package studentProject;

import java.io.Serializable;

public class Teacher implements Serializable {

	private String phone;
	private String teacherName;
	private int age;
	private String major;

	public Teacher() {
		this(null , null , 0 ,null);
	}
	
	
	public Teacher(String phone, String name, int age, String major) {
		this.phone = phone;
		this.teacherName = teacherName;
		this.age = age;
		this.major = major;
	}

	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}

	@Override
	public String toString() {
		return phone + "\t" + teacherName + "\t" + age + "\t" + major;
	}
	
}
