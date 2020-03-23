package practice;

public class Mouse {
	String leftButton;
	String rigthButton;
	
	public Mouse() {};
	
	public Mouse(String leftBtn, String rigthBtn) {
		this.leftButton = leftBtn;
		this.rigthButton = rigthBtn;
	}
	
	public void mouseMove() {
		System.out.println("mouseMove");
	}
}
