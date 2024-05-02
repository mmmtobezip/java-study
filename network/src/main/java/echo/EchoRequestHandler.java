package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;

public class EchoRequestHandler extends Thread {

	private Socket socket; //accept()에서 만들어진 소켓(in EchoServerThread.java)
	public EchoRequestHandler(Socket socket) {//생성자 지정 
		this.socket = socket;
	}
	
	@Override
	public void run() {
			try {
			InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress)socket.getRemoteSocketAddress(); 
			String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress(); 
			int remotePort = inetRemoteSocketAddress.getPort(); 
			EchoServerThread.log("connected by client[" + remoteHostAddress + ":" + remotePort + "]");
		
			//4. IO Stream 받아오기 
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();

			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true); 
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));

			while(true) {
				String data = br.readLine(); 
				
				if(data == null) { 
					EchoServerThread.log("closed by client");
					break;
				}

				EchoServerThread.log("recevied:" + data);

				pw.println(data);
			}
		} catch(SocketException e) { 
			EchoServerThread.log("Socket Exception :" + e);
		} catch(IOException e) {
			EchoServerThread.log("error:" + e);
		}finally {
			try {
				if(socket != null && !socket.isClosed()) {
					socket.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}	 
		
	}

}
