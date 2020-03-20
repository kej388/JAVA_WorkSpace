package practice;

import java.util.Scanner;

public class Member {
	String name;
	String address;
	String job;
	int age;
	
	public void showInfo() {
		System.out.println(name + "," + address + "," + job + "," + age);
	}
	
	public Member() {};
	
	public Member(String name) {
		this(name, "미정", "미정", 00);
	}
	
	public Member(String name, String address, String job, int age) {
		this.name = name;
		this.address = address;
		this.job = job;
		this.age = age;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Member person = new Member();
		
		System.out.println("이름을 입력하세요");
		person.name = sc.next();
		System.out.println("주소을 입력하세요");
		person.address = sc.next();
		System.out.println("직업을 입력하세요");
		person.job = sc.next();
		System.out.println("나이을 입력하세요");
		person.age = sc.nextInt();
		
		person.showInfo();
		
		sc.close();
	}
	
}
