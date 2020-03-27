import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

// 외부클래스
class MyAction implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// Action 이벤트가 발생될 때 처리할 작업
		//System.out.println("btn1이 클릭됨");
		JButton btn = (JButton)e.getSource();
		if(btn.getText().equals("버튼1")) {
			System.out.println("btn1이 클릭됨");
		}else if(btn.getText().equals("버튼2")) {
			System.out.println("버튼2가 클릭됨");
		}else if(btn.getText().equals("버튼3")) {
			System.out.println("버튼3이 클릭됨");
		}
	}
	
}

public class EventSample extends JFrame implements ActionListener{
	
	public EventSample() {
		this.setTitle("Event");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = this.getContentPane();
		c.setLayout(new FlowLayout());
		JButton btn1 = new JButton("버튼1");
		c.add(btn1);
		MyAction ma = new MyAction();
		btn1.addActionListener(ma);
		
		JButton btn2 = new JButton("버튼2");
		c.add(btn2);
		//btn2.addActionListener(new MyAction2());
		btn2.addActionListener(ma);
		
		JButton btn3 = new JButton("버튼3");
		c.add(btn3);
		btn3.addActionListener(ma);
		/*
		 * //btn3.addActionListener(new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) {
		 * System.out.println("btn3클릭됨");
		 * 
		 * } });
		 */
		
		JButton btn4 = new JButton("버튼4");
		c.add(btn4);
		btn4.addActionListener(this);
		
		this.setSize(500, 500);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new EventSample();
		
	
	}
	// 내부 클래스
	class MyAction2 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("btn2클릭됨");
			
		}
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("btn4가 클릭됨");
		
	}
}
