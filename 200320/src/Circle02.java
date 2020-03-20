
public class Circle02 {
	int radius;
	String name;
	
	public Circle02() {
		radius = 1; name = "";
	}
	
	public Circle02(int r, String n) {
		radius = r; name = n;
	}
	
	public double getArea( ) {
		return 3.14 * radius * radius;
	}
	
	public static void main(String[] args) {
		Circle02 pizza = new Circle02(10, "자바피자");
		
		double area = pizza.getArea();
		System.out.println(pizza.name + "의 면적은 " + area);
		
		Circle02 donut = new Circle02();
		donut.name = "자바도넛";
		area = donut.getArea();
		System.out.println(donut.name + "의 면적은 " + area);
	}
}
