class Circle04{
	int radius;
	
	public Circle04() {};
	
	public Circle04(int radius) {
		this.radius = radius;
	}
	
	public double getArea() {
		return 3.14 * radius * radius;
	}
}

public class CircleArray {
	public static void main(String[] args) {
		Circle04 [] c = new Circle04[5];
		
		for(int i = 0; i < c.length; i++) {
			c[i] = new Circle04(i);
		}
		
		for(int i = 0; i < c.length; i++) {
			System.out.println((int)(c[i].getArea()) + " ");
		}
	}
}
