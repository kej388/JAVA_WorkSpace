package practice;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Practice3 extends JFrame {
	private ImageIcon[] image = { new ImageIcon("images/apple.jpg"), new ImageIcon("images/pear.jpg"),
			new ImageIcon("images/cherry.jpg") };
	
	JButton btn1 = new JButton("prev");
	JButton btn2 = new JButton("next");
	JLabel imageLabel;
	
	public Practice3() {
		setTitle("세번째 문제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());

		//default image
		imageLabel = new JLabel(image[0]);
		
		
		// buttonPanel
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {				
				Practice3.this.imageLabel
			}
			
		}) ;
		buttonPanel.add(btn1);
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton bb = (JButton)e.getSource();
				
				/*
				 * if(bb==1) { imageLabel = new JLabel(image[1]); }
				 */
				
			}
		});
		buttonPanel.add(btn2);
		
		// image
		
		
		c.add(buttonPanel, BorderLayout.NORTH); 
		c.add(imageLabel, BorderLayout.CENTER);
		imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		 
		 

		setSize(500, 400);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Practice3();
	}
}
