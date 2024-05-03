package chat.gui;
import java.util.Scanner;

public class ChatClientApp {

	public static void main(String[] args) {
		String name = null;
		Scanner scanner = new Scanner(System.in);

		while( true ) {
			
			System.out.println("대화명을 입력하세요.");
			System.out.print(">>> ");
			name = scanner.nextLine();
			
			if (!name.isEmpty()) { 
				break;
			}
			
			System.out.println("대화명은 한글자 이상 입력해야 합니다.\n");
		}
		
		scanner.close();

		new ChatWindow(name).show(); //채팅 열기 -> 윈도우창 뜰 예정, 즉 ChatClientApp에서 join 프로토콜 미리 하고 show() 
		/*
		 * name뿐만 아니라 socket도 넘겨야함. new ChatWindow(name, socket).show();
		 * name을 넘기는 이유는, 윈도우 타이틀에 둘리라고 넣기 위함
		 * 해당 클래스에서 소켓 열고, join이 완료되면 채팅창을 하나 띄워야함.  -> 소켓으로 이미 통신끝남 
		 */
	}

}
