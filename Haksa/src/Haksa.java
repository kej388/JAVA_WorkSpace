import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Haksa extends JFrame{
	
	static Connection  conn = null; // 메모리를 아끼지 위해서 공유을 함
	static Statement stmt = null;
	static ResultSet rs = null;
	JTextField tfId = null;
	JTextField tfName = null;
	JTextField tfDeapartment = null;
	JTextField tfAddress = null;
	JTextArea taList = null;
	JButton btnList = null;
	JButton btnInsert = null;
	JButton btnUpdate = null;
	JButton btnDelete = null;
	
	JButton btnSearch = null;
	
	public Haksa() {
		this.setTitle("학사관리");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c =this.getContentPane();
		c.setLayout(new FlowLayout());
		
		c.add(new JLabel("학번"));
		this.tfId = new JTextField(14);
		c.add(tfId);
		this.btnSearch = new JButton("검색");
		c.add(this.btnSearch);
		
		c.add(new JLabel("이름"));
		this.tfName = new JTextField(20);
		c.add(this.tfName);
		c.add(new JLabel("학과"));
		this.tfDeapartment = new JTextField(20);
		c.add(this.tfDeapartment);
		
		c.add(new JLabel("주소"));
		this.tfAddress = new JTextField(20);
		c.add(this.tfAddress);
		
		this.taList = new JTextArea(10 ,23);
		c.add(new JScrollPane(this.taList));
		
		this.btnList = new JButton("목록");
		this.btnInsert = new JButton("등록");
		this.btnUpdate = new JButton("수정");
		this.btnDelete = new JButton("삭제");
		
		// 학생검색
		this.btnSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:myoracle","ora_user","hong");// 연결
					
					stmt = conn.createStatement();
					rs = stmt.executeQuery("select * from student where id ='"+ tfId.getText() +"'");
					
					// 목록 초기화
					taList.setText("");
					
					taList.append("학번"+"\t"+"이름"+"\t"+"학과"+"\n");
					taList.append("====================================\n");
					
					while(rs.next()) {
												
						taList.append(rs.getString("id") + "\t" + rs.getString("name") +
						"\t" + rs.getString("dept") + "\n");
						tfName.setText(rs.getString("name"));
						tfDeapartment.setText(rs.getString("dept"));
					}
					
					
					
				} catch (Exception e1) {
					e1.printStackTrace();
				} finally {
					try {
						if(rs != null) 
							rs.close();
						if(conn != null) 
							conn.close();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					
					
				}
				
			}
		});
		
		// 학생목록
		this.btnList.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:myoracle","ora_user","hong");// 연결
					
					stmt = conn.createStatement();
					rs = stmt.executeQuery("select * from student order by id");
					
					// 목록 초기화
					taList.setText("");
					
					taList.append("학번"+"\t"+"이름"+"\t"+"학과"+"\n");
					taList.append("====================================\n");
					
					while(rs.next()) {
						//System.out.print(rs.getString("id") + "-");
						//System.out.print(rs.getString("name") + "-");
						//System.out.println(rs.getString("dept"));
						
						taList.append(rs.getString("id") + "\t" + rs.getString("name") +
						"\t" + rs.getString("dept") + "\n");
					}
				} catch(Exception e1) {
					e1.printStackTrace();
				} finally {
					try {
						rs.close();
						conn.close();
					} catch(Exception e1) {
						e1.printStackTrace();
					}
				}
				
			}
		});
		
		// 학생등록
		this.btnInsert.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				if(tfId.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "학번을 입력하세요");
				}
				
				if(tfName.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "이름을 입력하세요");
				}
				
				if(tfDeapartment.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "학과을 입력하세요");
				}
				
				if(tfId.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "학번을 입력하세요");
				}
				
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:myoracle","ora_user","hong");// 연결
					
					stmt = conn.createStatement();
					stmt.executeUpdate("insert into student values('"+ tfId.getText()
					+"', '"+ tfName.getText() +"', '"+ tfDeapartment.getText() +"')");
					
					// 목록출력. 메서드로 변환추천
					rs = stmt.executeQuery("select * from student order by id");
					
					// 목록 초기화
					taList.setText("");
					
					taList.append("학번"+"\t"+"이름"+"\t"+"학과"+"\n");
					taList.append("====================================\n");
					
					while(rs.next()) {
						//System.out.print(rs.getString("id") + "-");
						//System.out.print(rs.getString("name") + "-");
						//System.out.println(rs.getString("dept"));
						
						taList.append(rs.getString("id") + "\t" + rs.getString("name") +
						"\t" + rs.getString("dept") + "\n");
					}
					rs.close();
					conn.close();
					
					// 등록처리완료 메시지 출력
					JOptionPane.showMessageDialog(null, "등록되었습니다.");
				} catch(Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		
		// 학생수정
		this.btnUpdate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:myoracle","ora_user","hong");// 연결
					
					stmt = conn.createStatement();
					stmt.executeUpdate("update student set name='" + tfName.getText()
					+"', dept='" + tfDeapartment.getText() + "' where id = '" +tfId.getText() + "'");
					
					// 목록출력. 메서드로 변환추천
					rs = stmt.executeQuery("select * from student where id = '" + tfId.getText() + "'");
					
					// 목록 초기화
					taList.setText("");
					
					taList.append("학번"+"\t"+"이름"+"\t"+"학과"+"\n");
					taList.append("====================================\n");
					
					while(rs.next()) {
						//System.out.print(rs.getString("id") + "-");
						//System.out.print(rs.getString("name") + "-");
						//System.out.println(rs.getString("dept"));
						
						taList.append(rs.getString("id") + "\t" + rs.getString("name") +
						"\t" + rs.getString("dept") + "\n");
					}
					rs.close();
					conn.close();
				
					JOptionPane.showMessageDialog(null, "수정되었습니다.");
			}catch(Exception e1) {
				e1.printStackTrace();
				}
			}
		});
		
		// 학생삭제
		this.btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "삭제하시겠습니까?", 
						"삭제", JOptionPane.YES_NO_OPTION);
				if(result == JOptionPane.YES_OPTION) {
					// 삭제처리. DB 연동해서 삭제
					try {
						Class.forName("oracle.jdbc.driver.OracleDriver");
						conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:myoracle","ora_user","hong");// 연결
						
						stmt = conn.createStatement();
						stmt.executeUpdate("delete from student where id ='" + tfId.getText() + "'");
						
						// 목록출력. 메서드로 변환추천
						rs = stmt.executeQuery("select * from student where id = '" + tfId.getText() + "'");
						
						// 목록 초기화
						taList.setText("");
						
						taList.append("학번"+"\t"+"이름"+"\t"+"학과"+"\n");
						taList.append("====================================\n");
						
						while(rs.next()) {
							//System.out.print(rs.getString("id") + "-");
							//System.out.print(rs.getString("name") + "-");
							//System.out.println(rs.getString("dept"));
							
							taList.append(rs.getString("id") + "\t" + rs.getString("name") +
							"\t" + rs.getString("dept") + "\n");
						}
						rs.close();
						conn.close();
						
				} catch(Exception e1) {
					e1.printStackTrace();
				}
					//입력항목 초기화
					tfId.setText("");
					tfName.setText("");
					tfDeapartment.setText("");
					
					
					JOptionPane.showMessageDialog(null, "삭제되었습니다.");
				}
			}
			
		});
		
		
		c.add(this.btnList);
		c.add(this.btnInsert);
		c.add(this.btnUpdate);
		c.add(this.btnDelete);
		
		this.setSize(290, 400);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Haksa();
	}
}
