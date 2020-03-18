import java.util.Scanner;

public class Practice02 {

	public static void main(String[] args) {
		//6번 문제
		Scanner sc = new Scanner(System.in);
		
		System.out.println("이름, 학번, 학과를 입력하세요");
		
		String name = sc.next();
		
		int schoolNum = sc.nextInt();
		
		String subject = sc.next();
		
		System.out.print("이름 : " + name + ", 학번 : " + schoolNum + ", 학과 : " + subject);
		
		System.out.println();
		
		// 7번문제
		
		System.out.println("국어, 영어, 수학 점수를 입력하세요");
		
		int korea = sc.nextInt();
		int english = sc.nextInt();
		int math = sc.nextInt();
		
		double avg;
		
		avg = (double)(korea + english + math / 3);
		
		System.out.println("평균 : " + avg);
		
		sc.close();
	}

}
