package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class EchoClient {
	private static final String SERVER_IP = "127.0.0.1";

	public static void main(String[] args) {
		Scanner sc = null;
		Socket socket = null;
		try {
			//scanner 작업 필요(hello를 주고 받아야 하기 때문) 
			sc = new Scanner(System.in);
			socket = new Socket();
			
			//소켓 연결
			socket.connect(new InetSocketAddress(SERVER_IP, EchoServer.PORT)); //서버 ip, port
			
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true); 
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8")); 
			
			while(true) { //exit입력 전까지 무한루프
				System.out.print(">>");
				String line = sc.nextLine(); //개행을 뺌
				if(line.equals("exit")) {
					break;
				}
				
				//exit는 echo로 받지 못하고 정상으로 넘어온 데이터를 읽어야함
				pw.println(line); // 개행을 붙여서 서버에 보냄
				String data = br.readLine(); //blocking
				if(data == null) { //서버와 연결 끊김
					log("closed by server"); 
					break;
				}
				
				//클라가 보낸 데이터가 제대로 다시 돌아온 것
				System.out.println("<<" + data);
			}
		} catch (SocketException e) {
			System.out.println("[Client] Socket Exception: " + e);
		}  catch(IOException e) {
			log("error:" + e);
		} finally {
			try {
				sc.close();
				
				if(socket != null && !socket.isClosed()) {
					socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	//log
	private static void log(String message) {
		System.out.println("[EchoClient] " + message);
	}
}
