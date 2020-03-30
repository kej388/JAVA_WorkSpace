import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Chart extends JFrame{
	
	private MyPanel panel = new MyPanel();
	
	
	class MyPanel extends JPanel{
		
		int vGap = 10;
		int height = 20;
		int startX = 100;
		int startY = 100;

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			g.drawString("분기별 매출 현황", startX, startY);
			
			g.setColor(Color.CYAN);
			g.fillRect(100, 100, 50, height);
			g.setColor(Color.MAGENTA);
			g.fillRect(100, 100+20+vGap, 70, height);
			g.setColor(Color.GREEN);
			g.fillRect(100, 100+(height+vGap)*2, 100, height);
			g.setColor(Color.RED);
			g.fillRect(100, 100+(height+vGap)*3, 100, height);
			
			
			g.drawLine(50, 350, 100, 300);
			g.drawLine(100, 300, 150, 280);
			g.drawLine(150, 280, 200, 290);
			g.drawLine(200, 290, 250, 250);
			
			g.setColor(Color.RED);
			g.fillArc(50, 400, 100, 100, 0, 45);
			g.setColor(Color.BLUE);
			g.fillArc(50, 400, 100, 100, 45, 135);
			g.setColor(Color.YELLOW);
			g.fillArc(50, 400, 100, 100, 180, 90);
			g.setColor(Color.GREEN);
			g.fillArc(50, 400, 100, 100, 270, 90);
		}
		
	}
	
	public Chart() {
		this.setTitle("차트");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setContentPane(this.panel);
		this.setSize(500, 600);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Chart();
	}
}
