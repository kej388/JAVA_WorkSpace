package practice;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GridLayoutEx extends JFrame{
	public GridLayoutEx() {
		this.setTitle("GridLayout Sample");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		c.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		c.add(new JLabel("이름"));
		c.add(new JTextField(10));
		c.add(new JLabel("학번"));
		c.add(new JTextField(10));
		c.add(new JLabel("학과"));
		c.add(new JTextField(10));
		c.add(new JLabel("과목"));
		c.add(new JTextField(10));
		
		this.setSize(200, 200);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new GridLayoutEx();
	}
}
