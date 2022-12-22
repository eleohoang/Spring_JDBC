package jdbc_ex;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class StudentJDBCTemplate implements StudentDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	@Override
	public void setDataSource(DataSource ds) {
		// TODO Auto-generated method stub
		this.dataSource = ds;
		this.jdbcTemplateObject = new JdbcTemplate(ds);
		
	}

	@Override
	public void create(String name, Integer age) {
		// TODO Auto-generated method stub
		String SQL = "insert into Student (name, age) values (?, ?)";
		jdbcTemplateObject.update(SQL, name, age);
		System.out.println("Created Record Name = "+name + " Age = " +age);
		return;
	}

	@Override
	public Student getStudent(Integer id) {
		// TODO Auto-generated method stub
		String SQL = "select * from Student where id = ?";
		Student student = jdbcTemplateObject.queryForObject(SQL, new StudentMapper(), new Object[]{id});
		
		return student;
	}

	@Override
	public List<Student> listStudents() {
		// TODO Auto-generated method stub
		String SQL = "select * from Student";
		List<Student> students = jdbcTemplateObject.query(SQL, new StudentMapper());
		
		return students;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		String SQL = "delete from Student where id=?";
		jdbcTemplateObject.update(SQL, id);
		System.out.println("Deleted Record with ID = "+id);
		return;
	}

	@Override
	public void update(Integer id, Integer age) {
		// TODO Auto-generated method stub
		String SQL = "update Student set age=? where id=?";
		jdbcTemplateObject.update(SQL, age, id);
		System.out.println("Updated Record with ID = "+id);
		return;
	}

}
