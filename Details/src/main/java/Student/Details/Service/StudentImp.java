package Student.Details.Service;

import java.util.List;

import Student.Details.Entites.Student;

public interface StudentImp {

	List<Student> getStudents();
	String register(Student st) ;
	String update(int rollno,String val);
	Student getStudent(int rollno);
	String delete(int rollno);
	List<Student> getStudentsOfsameClass(int clas);
}
