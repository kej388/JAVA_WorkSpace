import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;

public class NullContainerEx extends JFrame{
	
	public NullContainerEx() {
		this.setTitle("레이아웃없이 컴포넌트 배치");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = this.getContentPane();
		c.setLayout(null);
		
		JButton btn1 = new JButton("버튼 1");
		btn1.setBounds(0, 0, 100, 100);
		c.add(btn1);
		
		this.setSize(500, 500);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new NullContainerEx();
	}
}
