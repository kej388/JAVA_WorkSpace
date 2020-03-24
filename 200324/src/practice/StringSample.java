package practice;

public class StringSample {
	public static void main(String[] args) {
		String tel = "010-1234-5678";
		
		String telchange = tel.replace("-", "");
		
		System.out.println(telchange);
	}
}
