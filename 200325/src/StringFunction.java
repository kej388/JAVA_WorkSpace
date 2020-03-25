import java.util.ArrayList;

class Student {
	public String name;
	public Student(String name) {
		this.name = name;
	}
}

public class StringFunction {
	public static void main(String[] args) {
		ArrayList<Student> a = new ArrayList<Student>();
		a.add(new Student("홍길동"));
		a.add(new Student("이순신"));
		
		System.out.println(a.get(0).name);
		System.out.println(a.get(1).name);
	}
}
