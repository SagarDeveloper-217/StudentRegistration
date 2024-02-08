package Student.Details.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Student.Details.Entites.Student;
import Student.Details.Repo.StudentRepo;


@Service
public class StudentService implements StudentImp{

	@Autowired
	StudentRepo stdRepo;

	@Override
	public List<Student> getStudents() {
		return stdRepo.getStudents();
	}
	
	public String register(Student st) {
	
	return stdRepo.register(st);
}

	@Override
	public String update(int rollno,String val) {
		
		return stdRepo.update(rollno,val);
	}

	

	public Student getStudent(int rollno) {
		
		return stdRepo.getStudent(rollno);
	}

	

	

	public String delete(int rollno) {
		
		return stdRepo.delete(rollno);
	}



	public List<Student> getStudentsOfsameClass(int clas) {
		return stdRepo.getStudentsOfsameClass(clas);
	}

	

	public List<Student> getStudentsBetweenRange(int min, int max) {
		return stdRepo.getStudentsBetweenRange(min,max);
	}


	public List<Student> getAverageStudents() {
		return stdRepo.getAverageStudents();
	}

	



}
