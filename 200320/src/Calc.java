
public class Calc {

	public int add(int a, int b) {
		return a + b;
	}
	
	public static void main(String[] args) {
		double sum = 0.0;
		
		for(int i = 0; i < args.length; i++) {
			sum += Double.parseDouble(args[i]);
		}
		
		System.out.println("sum = " + sum);
		
		Calc c = new Calc();
		
		int result = c.add(10, 20);
		System.out.println(result);
	}

}
