package Student.Details.Repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import Student.Details.Entites.Student;

@Component
public class StudentRepo {

	@Autowired
	NamedParameterJdbcTemplate jd;

	public List<Student> getStudents() {

		String sql = "select * from Student";
		List<Student> stds = jd.query(sql, BeanPropertyRowMapper.newInstance(Student.class));
		return stds;

	}

	public String register(Student student) {
		String sql = "Insert into student (name,classNum,age,marks) values (:name,:classNum,:age,:marks)";

		MapSqlParameterSource namedparameter = new MapSqlParameterSource("name", student.getName())
				.addValue("classNum", student.getClassNum()).addValue("age", student.getAge())
				.addValue("marks", student.getMarks());
		int std = jd.update(sql, namedparameter);
		if (std > 0)
			return "inserted Succesful";
		else
			return "insertion failed";

	}

	public String update(int rollno, String name) {
		String sql = "Update student set name=:name where rollno=:rollno";
		MapSqlParameterSource namedparameter = new MapSqlParameterSource("name", name).addValue("rollno",rollno);
		int value = jd.update(sql, namedparameter);
		if (value > 0)
			return "update Success";
		else
			return "update fail";
	}

	public Student getStudent(int rollno) {
		String Sql="select * from Student where rollno=:rollno";
		MapSqlParameterSource namedparameter = new MapSqlParameterSource("rollno",rollno);
		Student st=jd.queryForObject(Sql, namedparameter,BeanPropertyRowMapper.newInstance(Student.class));
		return st;
	}

	public String delete(int rollno) {
		String sql="delete from student where rollno=:rollno";
		MapSqlParameterSource namedparameter = new MapSqlParameterSource("rollno",rollno);
		int val=jd.update(sql,namedparameter);
		if (val > 0)
			return "delete Success";
		else
			return "delete fail";
	}

	public List<Student> getStudentsOfsameClass(int clas) {
		String sql="select * from student where classNum=:clas";
		MapSqlParameterSource namedparameter = new MapSqlParameterSource("clas",clas);
		List<Student> stds=jd.query(sql, namedparameter, new BeanPropertyRowMapper<>(Student.class));
		return stds;
	}

	public List<Student> getStudentsBetweenRange(int min, int max) {
		String sql="select * from student where age> :min and age<:max";
		MapSqlParameterSource namedparameter = new MapSqlParameterSource("min",min)
															.addValue("max",max);
		List<Student> stds=jd.query(sql,namedparameter,BeanPropertyRowMapper.newInstance(Student.class));
		return stds;
	}

	

	

	public List<Student> getAverageStudents() {
		String sql="select * from student where marks>(select avg(marks) from student)";
		List<Student> stds=jd.query(sql,BeanPropertyRowMapper.newInstance(Student.class));
		return stds;
	}
	
	
	
	


}
