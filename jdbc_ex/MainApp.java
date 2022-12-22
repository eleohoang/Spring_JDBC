package jdbc_ex;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans_jdbc.xml");
		
		StudentJDBCTemplate studentJDBCTemplate = (StudentJDBCTemplate)context.getBean("studentJDBCTemplate");
		
		System.out.println("----------Record Creation-------");
		studentJDBCTemplate.create("Eleo", 11);
		studentJDBCTemplate.create("Aleo", 9);
		studentJDBCTemplate.create("Xleo", 11);
		
		System.out.println("-----List Multiple Records----");
		List<Student> students = studentJDBCTemplate.listStudents();
		
		for (Student record:students) {
			System.out.print("ID: " +record.getId());
			System.out.print(", Name: " +record.getName());
			System.out.println(", Age: " +record.getAge());
		}
		
		System.out.println("------List record with id = 2 ----------");
		studentJDBCTemplate.update(2, 11);
		
		System.out.println("----List Record with id = 2-----");
		Student student = studentJDBCTemplate.getStudent(2);
		System.out.print("ID: " +student.getId());
		System.out.print(", Name: " +student.getName());
		System.out.println(", Age: " +student.getAge());
	}
}
