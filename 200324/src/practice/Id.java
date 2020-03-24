package practice;

import java.util.Scanner;

public class Id {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("아이디를 입력하세요 >> ");
		
		String id = sc.next();
		
		char[] check = {'!','@','#','$','%','^'};
		
		for(int i = 0; i < id.length(); i++) {
			for(int j = 0; j < check.length; j++) {
				if(id.charAt(i) == check[j]) {
					System.out.println("아이디에 !,@,#,$,%,^가 포함되면 안됩니다.");
				}
			}
			
		}
		
		sc.close();
	}
}
