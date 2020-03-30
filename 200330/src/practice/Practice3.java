package practice;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Practice3 extends JFrame{
	
	private MyPanel panel = new MyPanel();
	
	JLabel apple = new JLabel("apple");
	JLabel cherry = new JLabel("cherry");
	JLabel strawberry = new JLabel("strawberry");
	JLabel prune = new JLabel("prune");
	JTextField jfApple = new JTextField(5);
	JTextField jfCherry = new JTextField(5);
	JTextField jfStrawberry = new JTextField(5);
	JTextField jfPrune = new JTextField(5);
	int num[] = new int[4];
	int sum = 0;
	public Practice3() {
		this.setTitle("파이차트그리기");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		JPanel inputPanel = new JPanel();
		
		inputPanel.setBackground(Color.GRAY);
		inputPanel.setLayout(new FlowLayout());
		
		
		inputPanel.add(apple);
		inputPanel.add(jfApple);
		jfApple.addActionListener(new Calculate());
		inputPanel.add(cherry);
		inputPanel.add(jfCherry);
		inputPanel.add(strawberry);
		inputPanel.add(jfStrawberry);
		inputPanel.add(prune);
		inputPanel.add(jfPrune);
		
		c.add(inputPanel, BorderLayout.NORTH);
		c.add(panel, BorderLayout.CENTER);
		
		setSize(500, 300);
		setVisible(true);
	}
	
	class MyPanel extends JPanel {
		
		int result;
		
		public MyPanel() {
			
			
			
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.RED);
			g.drawString("apple", 50, 20);
			
			g.setColor(Color.BLUE);
			g.drawString("cherry", 150, 20);
			
			g.setColor(new Color(81, 18, 75));
			g.drawString("strawberry", 250, 20);
			
			g.setColor(Color.ORANGE);
			g.drawString("prune", 380, 20);
			
			g.fillArc(200, 200, 200, 200, 0, result);
			
		}
		
	}
	
	class Calculate implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JTextField t = (JTextField)e.getSource();
			
		}
		
	}
	
	
	public static void main(String[] args) {
		new Practice3();
	}
	}
