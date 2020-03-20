
public class DevideByZeroeHandling {

	public static void main(String[] args) {
		
		try {
		int result = 10 / 0;
		} catch(Exception e) {
			// e.printStackTrace();	// 디버깅용
			System.out.println("예상치 못한 에러가 발생했습니다.");	// 배포용
		}
		
		System.out.println("이부분이 출력되는지 보세요....");
	}

}
