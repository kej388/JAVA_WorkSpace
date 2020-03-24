package inheritanceSample;

public class InheritanceSample {
	public static void main(String[] args) {
		//Person person = new Person();
		
		//person.speak();
		
		Student student = new Student();
		student.eat();
		student.study();
		
		StudentWorker sw = new StudentWorker();
		sw.walk();
		sw.study();
		sw.work();
	}
}
