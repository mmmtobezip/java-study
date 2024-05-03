package chat.gui; 
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.Socket;


//프로그래밍 로직 chatwindow에서 구현 필요 
//gui ..? 구현 ..? 
public class ChatWindow {

	private Frame frame;
	private Panel pannel;
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;
	private Socket socket;

	//1. 소켓 추가 필요 
	public ChatWindow(String name) {
		frame = new Frame(name); //윈도우 프레임, 윈도우창의 가장 바깥창 = 타이틀 
		pannel = new Panel();  //buttonSend + textField를 위한 위젯 
		buttonSend = new Button("Send");
		textField = new TextField();
		textArea = new TextArea(30, 80);
	}

	//구현 필요 show()
	public void show() {
		// Button
		buttonSend.setBackground(Color.GRAY);
		buttonSend.setForeground(Color.WHITE);
		buttonSend.addActionListener( new ActionListener() { //ActionListener: 인터페이스 
			@Override
			public void actionPerformed( ActionEvent actionEvent ) { //옵저버 패턴 - click 이벤트, 버튼을 누를 떄 발생
				System.out.println("click!!!");
				//sendMessage();
			}
		});

		// Textfield - 한줄 
		textField.setColumns(80);
		
		; //addKeyListener의 KeyListener인터페이스를 구현한 클래스 객체를 넣어야함. 자주 사용하지 않기에 클래스로 따로 만들지 않음 
		textField.addKeyListener(new KeyAdapter() { //인터페이스의 기본을 만들어 놓은 추상클래스 KeyAdapter, 사실 new를 못하지만 {} 바로 구현하겠, 단 클래스 이름없이로 정의하는 방법 -> 어노니머스 클래스?
													//인터페이스가 구현할 게 많으면 기본적인건 구현해놓고, 클래스를 가져와서 상속받아 디테일하게 구현하는 패턴: 어댑터패턴(요즘은 없어지는 추세)
			@Override
			public void keyPressed(KeyEvent e) {
//				System.out.println("!!!!!");
				char keyCode = e.getKeyChar();
				if(keyCode == KeyEvent.VK_ENTER) {
					sendMessage(); //text읽어와서 엔터치면 읽은 문장 출력 -> textfield에 쓴 text 삭제 -> 다시 쓸 수 있게 textField 커서 활성화
				}
			} 
			
		});
			
		// Pannel
		pannel.setBackground(Color.LIGHT_GRAY);
		pannel.add(textField);
		pannel.add(buttonSend);
		frame.add(BorderLayout.SOUTH, pannel);

		// TextArea
		textArea.setEditable(false); //textArea은 대화내용이 나오는창 -> edit 불가 
		frame.add(BorderLayout.CENTER, textArea);

		// Frame
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) { //윈도우가 닫힐 떄 받는 이벤트, 윈도우 창 또한 스레드로 동작하기에 
				 //JVM 종료 
				finish();
			}
		});
		frame.setVisible(true);
		frame.pack(); //위 일련의 코드가 전부 윈도우 창으로 만들어짐
		
		//Get IO Stream - printwriter/bufferedReader 사용을 위해 / scanner는 필요x(textfield가 이 역할을 이미함) 
		
		//ChatClientThread 생성  - 스레드 생성 필요 ?
		//ChatClientThread를 외부에서 만들지 말고 내부에서 만들자 
		
		
		
	}
	
	private void sendMessage() {
		//클릭 시 textFiled의 내용을 가져와야함. 
		String message = textField.getText();
		//비었는지 확인하는 추가 코드 필요 
		System.out.println("메세지 보내는 프로토콜 구현!:" + message); 
		
		textField.setText("");
		textField.requestFocus(); //한 줄 입력하고 -> button -> 다시 입력을 위해 한줄 입력한건 삭제해주고, 텍스트 입력 커서의 포커스를 다시 활성화 해줌. = enter()랑 같음
		
		//메시지가 가고 ack가 thread로 들어오면 메시지를 화면창에 뿌릴 수 있음
		//ChatClientThread에서 서버로 부터 받은 메시지가 있다고 가정하고, 이 아래 코드는 sendMessage()가 아니라 chatclientthread()에서 구현해야함.
		//스레드에서 메시지 받고 updateTextArea()불러야함.
		updateTextArea("마이콜:" + message);
	}
	
	private void updateTextArea(String message) {
		textArea.append(message);
		textArea.append("\n"); //
	}
	
	private void finish() {
		//quit protocol 구현 
		
		//exit java application 
		System.exit(0); //정상 JVM 종료 - 안쓰면 
	}
	private class ChatClientThread extends Thread {
		public void run() { //오버라이드 
			//io stream 넘겨서 무한루프로 readLine() - 클라이언트의 역할 
			//String message = br.readLine(); 
			
			//읽어서 메시지가 왔다면, 해당 스레드에서 메시지를 뿌려야할 공간은 textarea 
			//ChatClientThread 스레드가 있는 이유는 textarea 메서드를 쓰기 위해 외부가 아니라 내부에서 만들라는 것. 
			
			//받은 메시지를 textArea에 뿌리면됨. 
			String message = textField.getText();
			updateTextArea("마이콜:" + message); //소켓으로 오는 메시지가 여기에서 호출되고 -> textarea에 보여줘야함.

		}
	}
}
