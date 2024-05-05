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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatWindow {

	private Frame frame;
	private Panel pannel;
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;
	
	private Socket socket;
	private BufferedReader br;
	private PrintWriter pw;

	public ChatWindow(String name, Socket socket, BufferedReader br, PrintWriter pw) {
		frame = new Frame(name); 
		pannel = new Panel(); 
		buttonSend = new Button("Send");
		textField = new TextField();
		textArea = new TextArea(30, 80);
		
		this.socket = socket;
		this.br = br;
		this.pw = pw;
	}
 
	public void show() {
		// Button
		buttonSend.setBackground(Color.GRAY);
		buttonSend.setForeground(Color.WHITE);
		buttonSend.addActionListener( new ActionListener() { 
			@Override
			public void actionPerformed( ActionEvent actionEvent ) { 
				sendMessage();
			}
		});

		// Textfield
		textField.setColumns(80);
		textField.addKeyListener(new KeyAdapter() { 										
			@Override
			public void keyPressed(KeyEvent e) {
				char keyCode = e.getKeyChar();
				if(keyCode == KeyEvent.VK_ENTER) {
					sendMessage(); 
				}
			} 	
		});
		
		// Pannel
		pannel.setBackground(Color.LIGHT_GRAY);
		pannel.add(textField);
		pannel.add(buttonSend);
		frame.add(BorderLayout.SOUTH, pannel);

		// TextArea
		textArea.setEditable(false); 
		frame.add(BorderLayout.CENTER, textArea);

		// Frame
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				finish();
			}
		});
		
		frame.setVisible(true);
		frame.pack(); 
		
	    new ChatClientThread().start();
	}
	
	private void sendMessage() {
		String message = textField.getText();
		
		if(!message.isEmpty()) {
			if(("quit").equals(message)) {
				finish();
				return;
			} else {
				pw.println("message:" + message);
			}
			textField.setText("");
			textField.requestFocus(); 
		}
	}
	
	private void updateTextArea(String message) {
		textArea.append(message);
		textArea.append("\n"); 
	}
	
	private void finish() {
		//Exit JVM
		pw.println("quit"); 
		System.exit(0);
	}
	
	private class ChatClientThread extends Thread {
		public void run() { 
			try {
				while(true) {
					String message = br.readLine();
					if(message == null) {
						break;
					}
					updateTextArea(message);
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					//Closed socket 
					if(socket != null && !socket.isClosed()) {
						socket.close();
					}
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
