package human;

public class Person {
	public String name;
	public int age;
	
	public Person() {};
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void showMe() {
		System.out.println(this.name + " : " + this.age);
		
	}
}
