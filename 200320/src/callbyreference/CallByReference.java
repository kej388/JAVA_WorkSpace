package callbyreference;
class Circle {
	public int radius;
	
	public Circle() {};
	
	public Circle(int radius) {
		this.radius = radius;
	}
}


public class CallByReference {
	static void increase(Circle m) {
		m.radius++;
	}
	public static void main(String[] args) {
		Circle c = new Circle(10);
		
		increase(c);
		System.out.println(c.radius);
		
	}
	
}
