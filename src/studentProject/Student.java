package studentProject;

import java.io.Serializable;
import java.util.Objects;

public class Student extends Teacher implements Comparable<Student> , Serializable  {

	
	private String no;
	private String name;
	private boolean gender;
	private int kor;
	private int eng;
	private int math;
	private int total;
	private double avg;
	private char grade;
	private int rank;
	public static final double AVG_VALUE = 3.0 , GRADE_A = 90.0 , GRADE_B = 70.0 , GRADE_C = 50.0 , GRADE_D = 30.0;
	
	
	public Student(String name , String no , boolean gender , int kor , int eng , int math) {
		super();
		this.name = name;
		this.no = no;
		this.gender = gender;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}


	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}


	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}


	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}


	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}


	public int getTotal() {
		return total;
	}
	public void calTotal() {
		this.total = this.kor + this.eng + this.math;
	}


	public double getAvg() {
		return avg;
	}
	public void calAvg() {
		String avgValue = String.format("%.2f", (double)this.total / AVG_VALUE ) ;
		this.avg = Double.parseDouble(avgValue);
	}


	public char getGrade() {
		return grade;
	}
	public void calGrade() {
		if (avg >= GRADE_A) {
			this.grade = 'A';
		} else if (avg >= GRADE_B) {
			this.grade = 'B';
		} else if (avg >= GRADE_C) {
			this.grade = 'C';
		} else if (avg >= GRADE_D) {
			this.grade = 'D';
		} else {
			this.grade = 'F';
		}
	}
	

	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}

	public static String infoString() {
		return "번호\t이름\t성별\t국어\t영어\t수학\t총합\t평균\t등급\t등수";
	}
	
	@Override
	public String toString() {
		char charGender = this.gender == false ? '남' : '여';
		System.out.println("-".repeat(80));
		System.out.println("선생님 정보 \n핸드폰 번호\t\t이름\t나이\t전공");
		System.out.println(super.toString());
		System.out.println("학생 정보");
		System.out.println(infoString());
		return no + "\t" + name + "\t" + charGender + "\t" + kor + "\t" + eng +"\t"+ math + "\t" + total + "\t" + avg + "\t" + grade + "\t" + rank;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Student)) return false;
		Student student = (Student) obj;
		if (this.no.equals(student.no)) {
			return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(no);
	}
	
	
	@Override
	public int compareTo(Student o) {
		return this.total - o.total;
	}
}
