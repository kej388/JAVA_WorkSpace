package human;

public class Human {
	public static void main(String[] args) {
		Person p1 = new Person("a", 13);
		p1.showMe();
		
		Person[] peaple = new Person[3];
		peaple[0] = new Person("이순신", 25);
		peaple[1] = new Person("왕건", 33);
		peaple[2] = new Person("을지문덕", 55);
		
		for(Person i : peaple) {
			i.showMe();
		}
	}
}
