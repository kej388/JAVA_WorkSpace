package practice;

public class Address {
	public static void main(String[] args) {
		String csv = "EL201800001,CH201800021,EN12231";
		
		String csv1[] = csv.split(",");
		
		for(int i = 0; i < csv1.length; i++) {
			if(csv1[i].contains("EL"))
				System.out.println("전자공학과");
			else if(csv1[i].contains("CH"))
				System.out.println("화학공학과");
			else if(csv1[i].contains("EN"))
				System.out.println("영어영문학과");
		}
		
	}
}
