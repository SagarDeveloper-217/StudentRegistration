package Student.Details.Entites;

public class Student {

	private int rollno;
	private String name;
	private int classNum;
	private int age;
	private int marks;

	public Student(int rollno, String name, int classNum, int age, int marks) {
		super();
		this.rollno = rollno;
		this.name = name;
		this.classNum = classNum;
		this.age = age;
		this.marks = marks;
	}

	public Student() {
		super();
	}

	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getClassNum() {
		return classNum;
	}

	public void setClassNum(int classNum) {
		this.classNum = classNum;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", name=" + name + ", classNum=" + classNum + ", age=" + age + ", marks="
				+ marks + "]";
	}

}
