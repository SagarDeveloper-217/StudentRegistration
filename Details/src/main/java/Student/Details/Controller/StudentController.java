package Student.Details.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Student.Details.Entites.Student;
import Student.Details.Service.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService service;
	
	@GetMapping("/students")
	public List<Student> getStudents(){
		
		return service.getStudents();
	}
	
	@PostMapping("/register")
	public String register(@RequestBody Student st) {
		
		return service.register(st);
		
	}
	
	@PutMapping("/update/{rollno}")
	public String update(@PathVariable int rollno, @RequestParam String name) {
		return service.update(rollno,name);
	}
	
	@GetMapping("/byRollno/{rollno}")
	public Student getStudent(@PathVariable int rollno) {
		return service.getStudent(rollno);
	}
	
	
	@DeleteMapping("/delete/{rollno}")
	public String delete(@PathVariable int rollno) {
		return service.delete(rollno);
	}
	
	@GetMapping("/class/{classNum}")
	public List<Student> getStudentsOfsameClass(@PathVariable int classNum){
		return service.getStudentsOfsameClass(classNum);
	}
	
	@GetMapping("/range")
	public List<Student> getStudentsBetweenRange(@RequestParam int min,@RequestParam int max){
		return service.getStudentsBetweenRange(min,max);
	}
	
	@GetMapping("/averageStudents")
	public List<Student> getAverageStudents(){
		return service.getAverageStudents();
	}
}
