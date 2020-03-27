package practice;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

class BtnClass1 implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton)e.getSource();	
		if(b.getText().equals("외부클래스")) {
			
		}
	}
	
}

public class Practice1 extends JFrame{
	
	public Practice1() {
		setTitle("첫번째 문제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JButton btn1 = new JButton("외부클래스");
		btn1.addActionListener(new BtnClass1());
		c.add(btn1);
		
		setSize(350, 150);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Practice1();
	}
	
	private class BtnClass2 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
			
			
		}
		
	}
}
