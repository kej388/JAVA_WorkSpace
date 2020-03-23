package practice;

public class InstanceMouse {
	
	static void print(Mouse p) {
		p.mouseMove();
	}
	
	public static void main(String[] args) {
		Mouse m0 = new Mouse();
		Mouse m1 = new WheelMouse();
		Mouse m2 = new LaserMouse();
		
		print(m0);
		print(m1);
		print(m2);
		
	}
}
