public class Circle03 {
	int radius;
	public Circle03(int radius) {
		this.radius = radius;
	}
	
	public void set(int radius) {
		this.radius = radius;
	}
	
	public static void main(String[] args) {
		Circle03 ob1 = new Circle03(1);
		Circle03 ob2 = new Circle03(2);
		Circle03 ob3 = new Circle03(3);
		
		ob1.set(4);
		ob2.set(5);
		ob3.set(6);
	}
}
