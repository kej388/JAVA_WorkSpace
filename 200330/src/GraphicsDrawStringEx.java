import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicsDrawStringEx extends JFrame{
	private MyPanel panel = new MyPanel();
	
	public GraphicsDrawStringEx() {
		this.setTitle("drawString 사용 예제");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		
		setSize(500, 500);
		setVisible(true);
	}
	
	class MyPanel extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawString("자바는 재밌다~", 30, 30);
			g.drawString("얼마나? 하늘만큼 땅만큼", 60, 60);
			
			g.setColor(Color.RED);
			g.drawLine(70, 100, 170, 200);
			g.drawOval(300, 300, 80, 80);
			g.drawRect(300, 100, 80, 80);
			g.drawRoundRect(70, 300, 120, 80, 40, 60);
		
		}
	}
	
	public static void main(String[] args) {
		new GraphicsDrawStringEx();
	}
}
