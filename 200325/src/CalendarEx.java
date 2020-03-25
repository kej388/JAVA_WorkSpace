import java.util.Calendar;

public class CalendarEx {
	public static void main(String[] args) {
		Calendar now = Calendar.getInstance();
		System.out.println(now.get(Calendar.YEAR));
		System.out.println(now.get(Calendar.MONTH) + 1);
		System.out.println(now.get(Calendar.DAY_OF_MONTH));
		System.out.println(now.get(Calendar.DAY_OF_WEEK));
		System.out.println(now.get(Calendar.HOUR));
		System.out.println(now.get(Calendar.HOUR_OF_DAY));
		System.out.println(now.get(Calendar.AM_PM));
		System.out.println(now.get(Calendar.MINUTE));
		int dayOfWeek = now.get(Calendar.DAY_OF_WEEK);
		
		if(dayOfWeek == Calendar.SUNDAY) {
			System.out.println("일요일");
		}
	}
}
