package practice;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Scanner;

public class Question1 {
	
	public static String printCalendar(Calendar cal) {
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		int day = cal.get(Calendar.DAY_OF_MONTH);;
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		
		String fileName = year+""+month+""+day+""+hour+""+minute+""+second + ".log";
		return fileName;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n1;
		int n2;
		File f;
		Calendar now;
		FileWriter fout;
		
		try {
			System.out.println("테스트하시오");
			System.out.print("숫자입력(분자) : ");
			n1 = sc.nextInt();
			
			System.out.print("숫자입력(분모) : ");
			n2 = sc.nextInt();
			
			int result = n1 / n2;
			
			System.out.println(result);
		}catch(Exception e) {
			now = Calendar.getInstance();
			f = new File("c:\\JAVA_WorkSpace\\log", printCalendar(now));
			
			try {
				fout = new FileWriter(printCalendar(now));
				String error = "에러가 발생하였습니다.";
				fout.write(error);
				fout.flush();
				fout.close();
			}catch(IOException a) {
				a.printStackTrace();
			}
			
		}
		
		sc.close();
	}
}
