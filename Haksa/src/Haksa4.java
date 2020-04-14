
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Haksa4 extends JFrame {

	static Connection conn = null; // 메모리를 아끼지 위해서 공유을 함
	static Statement stmt = null;
	static ResultSet rs = null;

	JPanel panel; // 메뉴별 화면이 출력되는 패널

	public Haksa4() {
		this.setTitle("학사관리");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:myoracle", "ora_user", "hong");// 연결

			stmt = conn.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 윈도우종료시 Connection Close
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				try {
					if (conn != null) {
						conn.close();
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

		JMenuBar bar = new JMenuBar();

		JMenu m_student = new JMenu("학생관리");// File메뉴
		bar.add(m_student);
		JMenu m_book = new JMenu("도서관리");// Edit메뉴
		bar.add(m_book);

		JMenuItem mi_list = new JMenuItem("학생정보");
		m_student.add(mi_list);
		mi_list.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panel.removeAll(); // 모든컴포넌트 삭제
				panel.revalidate(); // 다시 활성화
				panel.repaint(); // 다시 그리기
				panel.add(new Student()); //화면 생성.
				panel.setLayout(null);// 레이아웃적용안함

			}
		});

		JMenuItem mi_bookRent = new JMenuItem("대출목록");
		m_book.add(mi_bookRent);
		mi_bookRent.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panel.removeAll(); // 모든컴포넌트 삭제
				panel.revalidate(); // 다시 활성화
				panel.repaint(); // 다시 그리기
				panel.add(new BookRent()); //화면 생성.
				panel.setLayout(null);// 레이아웃적용안함

			}
		});

		panel = new JPanel();// panel생성
		add(panel);// 프레임에 패널 추가

		this.setJMenuBar(bar);
		this.setSize(500, 430);
		this.setLocationRelativeTo(null); // 화면 중앙에 출력
		this.setVisible(true);

	}

	public static void main(String[] args) {
		new Haksa4();
	}

}
