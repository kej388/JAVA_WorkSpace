package practice;

import java.util.ArrayList;
import java.util.Scanner;

class Book {
	String title;
	String author;
	String publisher;
	String price;
	
	public void setBook(String title, String author, String publisher, String price) {
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
	}
	
	
}

public class BookList {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Book> data = new ArrayList<Book>();
		
		// 입력
		System.out.print("책제목을 입력하세요 >> ");
		String title = sc.next();
		
		System.out.print("저자를 입력하세요 >> ");
		String author = sc.next();
		
		System.out.print("출판사를 입력하세요 >> ");
		String publisher = sc.next();
		
		System.out.print("가격을 입력하세요>> ");
		String price = sc.next();
		
		Book b = new Book();
		b.setBook(title, author, publisher, price);
		
		// 배열요소 저장
		data.add(b);
		
		System.out.println(data.get(0).title);
		System.out.println(data.get(0).author);
		System.out.println(data.get(0).publisher);
		System.out.println(data.get(0).price);
		
		sc.close();
	}
}
