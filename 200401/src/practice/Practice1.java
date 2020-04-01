package practice;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Practice1 extends JFrame{
	
	PaintColor pc = new PaintColor();
	
	public Practice1() {
		this.setTitle("그림판 색변경");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		
		c.add(pc, BorderLayout.CENTER);
		createMenu();
		
		this.setSize(300, 300);
		this.setVisible(true);
	}
	
	class PaintColor extends JPanel{
		
		private ArrayList<Point> aPoint=new ArrayList<Point>();		
		private ArrayList<Boolean> aPointFlag=new ArrayList<Boolean>();
		
		Point startP;
		Point endP;

		public PaintColor() {
			addMouseMotionListener(new MouseMotionListener() {

				@Override
				public void mouseDragged(MouseEvent e) {
					
					aPoint.add(e.getPoint());
					aPointFlag.add(false);
					repaint();
				}

				@Override
				public void mouseMoved(MouseEvent e) {}
			});
			
			addMouseListener(new MouseListener() {
				@Override
				public void mousePressed(MouseEvent e) {
					aPoint.add(e.getPoint());
					aPointFlag.add(false);
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					aPointFlag.remove(aPointFlag.size()-1);	
					aPointFlag.add(true);
					repaint();//눌렀다 바로 띈 경우를 위해
					
				}
				@Override
				public void mouseClicked(MouseEvent arg0) {}
				@Override
				public void mouseEntered(MouseEvent e) {}
				@Override
				public void mouseExited(MouseEvent e) {}
				
				
				});
		}
		
		@Override
		protected void paintComponent(Graphics g) {			
			super.paintComponent(g);
			
			for(int i=0;i<aPoint.size();i++) {
				//첫번째 점이거나 이전 점이 마지막 점이면
				if(i==0 || aPointFlag.get(i-1)==true) {
					startP=aPoint.get(i);					
				}				
				
				endP=aPoint.get(i);
				g.drawLine((int)startP.getX(), (int)startP.getY(), (int)endP.getX(), (int)endP.getY());
				startP=endP;				
			}			
		}
		
	}
	
	private void createMenu( ) {
		JMenuBar mb = new JMenuBar();
		JMenuItem colorMenuItem = new JMenuItem("Color");
		JMenu fileMenu = new JMenu("설정");
		
		colorMenuItem.addActionListener(new MenuActionListener());
		
		fileMenu.add(colorMenuItem);
		mb.add(fileMenu);
		this.setJMenuBar(mb);
	}
	
	class MenuActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			if(cmd.equals("Color")) {
				Color selectedColor = JColorChooser.showDialog(null, "Color", Color.YELLOW);
				
				if(selectedColor != null) {
					pc.setForeground(selectedColor);
				}
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		new Practice1();
	}
}
