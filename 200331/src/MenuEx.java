import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuEx extends JFrame{
	public MenuEx() {
		setTitle("Menu 만들기 예제");
		createMenu();
		setSize(250, 200);
		setVisible(true);
	}
	private void createMenu() {
		JMenuBar mb = new JMenuBar();
		JMenu screenJMenu = new JMenu("Screen");
		
		JMenuItem load = new JMenuItem("Load");
		JMenuItem hide = new JMenuItem("Hide");
		JMenuItem reshow = new JMenuItem("ReShow");
		JMenuItem exit = new JMenuItem("Exit");
		
		screenJMenu.add(load);
		screenJMenu.add(hide);
		screenJMenu.add(reshow);
		screenJMenu.addSeparator();
		screenJMenu.add(exit);
		
		mb.add(screenJMenu);
		mb.add(new JMenu("Edit"));
		mb.add(new JMenu("Source"));
		mb.add(new JMenu("Project"));
		mb.add(new JMenu("Run"));
		
		setJMenuBar(mb);
	}
	
	public static void main(String[] args) {
		new MenuEx();
	}
}
