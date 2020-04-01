import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

class MyDialog extends JDialog{
	
	private JTextField tf = new JTextField(10);
	private JPasswordField pw = new JPasswordField(10);
	private JButton loginButton = new JButton("login");
	
	public MyDialog(JFrame frame, String title) {
		super(frame, title, true);
		setLayout(new FlowLayout());
		add(tf);
		add(pw);
		add(loginButton);
		setSize(200,  200);
		
		loginButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 로그인처리, DB연동, ID, Pw일치 여부 확인
				System.out.println("로그인처리...");
				setVisible(false);
			}
		});
	}
}

public class DialogEx extends JFrame{
	private MyDialog dialog;
	
	public DialogEx() {
		super("학사관리");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btn = new JButton("로그인");
		
		dialog = new MyDialog(this, "로그인");
		
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.setVisible(true);
				
			}
		});
		
		getContentPane().add(btn);
		
		setSize(250, 200);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new DialogEx();
	}
}
