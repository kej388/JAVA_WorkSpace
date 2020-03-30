package practice;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Practice1 extends JFrame{
	
	private MyPanel panel = new MyPanel();
	
	public Practice1() {
		this.setTitle("막대그래프 완성하기");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		
		setSize(300, 300);
		setVisible(true);
	}
	
	class MyPanel extends JPanel {
		
		int vGap = 20;
		int height = 20;
		int startX = 100;
		int startY = 30;

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			g.drawString("분기별 매출현황(억단위)", startX, startY);
			
			// 1분기
			g.setColor(Color.PINK);
			g.fillRect(startX-10, startY+vGap, 70, height);
			
			g.setColor(Color.BLACK);
			g.drawString("70", startX + 10, startY + 35);
			
			// 2분기
			g.setColor(Color.MAGENTA);
			g.fillRect(startX-10, startY+vGap+height, 120, height);
			
			g.setColor(Color.BLACK);
			g.drawString("120", startX + 10, startY + 35 + height);
			
			// 3분기
			g.setColor(Color.RED);
			g.fillRect(startX-10, startY+vGap+(height*2), 50, height);
			
			g.setColor(Color.BLACK);
			g.drawString("50", startX + 10, startY + 35 + height*2);
			
			// 4분기
			g.setColor(Color.LIGHT_GRAY);
			g.fillRect(startX-10, startY+vGap+(height*3), 120, height);
			
			g.setColor(Color.BLACK);
			g.drawString("120", startX + 10, startY + 35 + height*3);
		}
		
	}
	
	
	public static void main(String[] args) {
		new Practice1();
	}
}
