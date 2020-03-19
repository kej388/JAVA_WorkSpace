package java_200319;

import java.util.Scanner;

public class Practice03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//한 학급의 학생수 입력
		System.out.println("한 학급의 학생수를 입력하세요 : ");
		int studentNum = sc.nextInt();
		
		int sum[] = new int[studentNum];
		double avg[] = new double[studentNum];
		int classSum = 0;
		double classAvg = 0;
		
		String names[] = new String[studentNum];
		int classA[][] = new int[studentNum][3];
		//이름, 국어, 영어, 수학, 점수 반복 입력
		System.out.println("학생 수 만큼 이름을 입력하세요");
		for(int i = 0; i < studentNum; i++) {
			names[i] = sc.next();
		}
		
		for(int i = 0; i < studentNum; i++) {
			System.out.println(names[i] +"학생의 국어점수, 영어점수, 수학점수를 순서대로 입력하세요 :");
			for(int j = 0; j < 3; j++) {
				classA[i][j] = sc.nextInt();
				sum[i] += classA[i][j];
			}
		}
		
		// 개인 평균, 학급 전체 평균 구하기
		
		for(int i = 0; i < studentNum; i++) {
			avg[i] = (double)(sum[i]) / 3;
		}
		
		for(int i = 0; i < studentNum; i++) {
			System.out.printf("%s학생의 평균 : %.1f\n", names[i], avg[i]);
		}
		
		for(int i: sum) {
			classSum += i;
		}
		
		classAvg = (double)(classSum) / (studentNum * 3);
		
		System.out.printf("학급 전체 평균 : %.1f\n", classAvg);
		
		
		sc.close();
	}

}
