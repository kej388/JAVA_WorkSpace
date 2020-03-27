package practice;

import java.awt.Container;
import java.awt.FlowLayout;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Practice2 extends JFrame{
	
	public Practice2() {
		setTitle("두번째 문제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		Calendar now = Calendar.getInstance();
		
		int hourOfDay = now.get(Calendar.HOUR_OF_DAY);
		
		if(hourOfDay < 12) c.add(new JLabel("Good Morning!!"));
		else if(hourOfDay >= 12 && hourOfDay < 18)
			c.add(new JLabel("Good Afternoon!!"));
		else 
			c.add(new JLabel("Good Evening!!"));
		
		setSize(300, 200);
		setVisible(true);
		
		
	}
	
	public static void main(String[] args) {
		
		
		new Practice2();
	}
	
	
}
