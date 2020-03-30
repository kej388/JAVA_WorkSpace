package practice;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Practice2 extends JFrame{
	
	private MyPanel panel = new MyPanel();
	
	public Practice2() {
		this.setTitle("꺽은선그래프 완성하기");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		
		setSize(500, 400);
		setVisible(true);
	}
	
	class MyPanel extends JPanel {

		@Override
		protected void paintComponent(Graphics g) {
			
			int startX = 30;
			int startY = 200;
			int hGap = 100;
			
			super.paintComponent(g);
			g.drawString("꺽은선 그래프", 200, 30);
			g.setColor(Color.BLACK);
			
			//x축, y축
			g.drawString("y축", 20, 40);
			g.drawString("x축", 450, 210);
			g.drawLine(startX - 10, startY + 10, startX - 10, 50);
			g.drawLine(startX - 10, startY + 10, 440, startY + 10);
			
			g.drawString("1분기", startX + 50, startY + 30);
			g.drawString("2분기", startX + 150, startY + 30);
			g.drawString("3분기", startX + 250, startY + 30);
			g.drawString("4분기", startX + 350, startY + 30);
			
			//1 ~ 4분기
			g.setColor(Color.BLUE);
			g.drawLine(startX, startY, startX + hGap, startY - 70);
			g.drawString("70", startX + hGap, startY - 70);
			g.drawLine(startX + hGap, startY - 70, startX + hGap * 2, startY - 120);
			g.drawString("120", startX + hGap * 2, startY - 120);
			g.drawLine(startX + hGap * 2, startY - 120, startX + hGap * 3, startY - 50);
			g.drawString("50", startX + hGap * 3, startY - 50);
			g.drawLine(startX + hGap * 3, startY - 50, startX + hGap * 4, startY - 120);
			g.drawString("120", startX + hGap * 4, startY - 120);
			
			
			
			
		}
		
	}
	
	
	public static void main(String[] args) {
		new Practice2();
	}
}
