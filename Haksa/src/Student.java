import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Student extends JPanel {

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

	DefaultTableModel model;
	JTable table;

	public Student() {

		this.setLayout(new FlowLayout());

		this.add(new JLabel("학번"));
		this.tfId = new JTextField(14);
		this.add(tfId);

		this.btnSearch = new JButton("검색");
		this.add(this.btnSearch);

		this.add(new JLabel("이름"));
		this.tfName = new JTextField(20);
		this.add(this.tfName);

		this.add(new JLabel("학과"));
		this.tfDeapartment = new JTextField(20);
		this.add(this.tfDeapartment);

		this.add(new JLabel("주소"));
		this.tfAddress = new JTextField(20);
		this.add(this.tfAddress);

		String colName[] = { "학번", "이름", "학과", "주소"};
		model = new DefaultTableModel(colName, 0);
		table = new JTable(model);
		table.setPreferredScrollableViewportSize(new Dimension(250, 200));
		add(new JScrollPane(table));

		// table에서 한행을 선택하면 편집할 수 있도록 TextField에 출력
		table.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				table = (JTable) e.getComponent();// 클릭한 테이블 구하기
				model = (DefaultTableModel) table.getModel();// 테이블의 모델 구하기
				String id = (String) model.getValueAt(table.getSelectedRow(), 0);
				tfId.setText(id);
				String name = (String) model.getValueAt(table.getSelectedRow(), 1);
				tfName.setText(name);
				String dept = (String) model.getValueAt(table.getSelectedRow(), 2);
				tfDeapartment.setText(dept);
				String address = (String)model.getValueAt(table.getSelectedRow(), 3);
				tfAddress.setText(address);
			}
		});

		this.btnList = new JButton("목록");
		this.btnInsert = new JButton("등록");
		this.btnUpdate = new JButton("수정");
		this.btnDelete = new JButton("삭제");

		// 학생검색
		this.btnSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Haksa4.rs = Haksa4.stmt.executeQuery("select * from student where id ='" + tfId.getText() + "'");

					// jTable 초기화
					model.setNumRows(0);

					if (Haksa4.rs.next()) {

						tfName.setText(Haksa4.rs.getString("name"));
						tfDeapartment.setText(Haksa4.rs.getString("dept"));

						list();
					}

				} catch (Exception e1) {
					e1.printStackTrace();
				} finally {
					try {
						if (Haksa.rs != null)
							Haksa.rs.close();
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
				list();
			}

		});

		// 학생등록
		this.btnInsert.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (tfId.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "학번을 입력하세요");
				}

				if (tfName.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "이름을 입력하세요");
				}

				if (tfDeapartment.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "학과을 입력하세요");
				}

				if (tfId.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "주소을 입력하세요");
				}

				try {
					Haksa4.stmt.executeUpdate("insert into student values('" + tfId.getText() + "', '"
							+ tfName.getText() + "', '" + tfDeapartment.getText() + "', '" + tfAddress.getText() + "')");

					// 목록출력. 메서드로 변환추천
					Haksa4.rs = Haksa4.stmt.executeQuery("select * from student order by id");

					while (Haksa4.rs.next()) {
						list();
					}
					Haksa4.rs.close();

					// 등록처리완료 메시지 출력
					JOptionPane.showMessageDialog(null, "등록되었습니다.");
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});

		// 학생수정
		this.btnUpdate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Haksa4.stmt.executeUpdate("update student set name='" + tfName.getText() + "', dept='"
							+ tfDeapartment.getText() + "' where id = '" + tfId.getText() + "'");

					// 목록출력. 메서드로 변환추천
					Haksa4.rs = Haksa4.stmt.executeQuery("select * from student where id = '" + tfId.getText() + "'");

					// jTable 초기화
					model.setNumRows(0);

					while (Haksa4.rs.next()) {
						list();
					}
					Haksa4.rs.close();

					JOptionPane.showMessageDialog(null, "수정되었습니다.");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		// 학생삭제
		this.btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "삭제하시겠습니까?", "삭제", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					// 삭제처리. DB 연동해서 삭제
					try {
						Haksa4.stmt.executeUpdate("delete from student where id ='" + tfId.getText() + "'");

						// 목록출력. 메서드로 변환추천
						Haksa4.rs = Haksa4.stmt.executeQuery("select * from student where id = '" + tfId.getText() + "'");

						// jTable 초기화
						model.setNumRows(0);

					} catch (Exception e1) {
						e1.printStackTrace();
					}
					// 입력항목 초기화
					tfId.setText("");
					tfName.setText("");
					tfDeapartment.setText("");
					tfAddress.setText("");

					JOptionPane.showMessageDialog(null, "삭제되었습니다.");
				}
			}

		});

		this.add(this.btnList);
		this.add(this.btnInsert);
		this.add(this.btnUpdate);
		this.add(this.btnDelete);

		this.setSize(280, 500);
		this.setVisible(true);
	}

	public void list() {
		try {
			System.out.println("연결되었습니다.....");

			// Select문 실행
			ResultSet rs = Haksa4.stmt.executeQuery("select * from student");

			// JTable 초기화
			model.setNumRows(0);

			while (rs.next()) {
				String[] row = new String[4];// 컬럼의 갯수가 3
				row[0] = rs.getString("id");
				row[1] = rs.getString("name");
				row[2] = rs.getString("dept");
				row[3] = rs.getString("address");
				model.addRow(row);
			}
			rs.close();

		} catch (Exception e1) {
			// e.getStackTrace();
			System.out.println(e1.getMessage());
		}
	}
}
