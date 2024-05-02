package httpd;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.file.Files;

//Thread를 상속받은 RequestHandler
public class RequestHandler extends Thread {
	private Socket socket;
	private final String DOCUMENT_ROOT = "./webapp";
	
	public RequestHandler( Socket socket ) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		try {
			// get IOStream
			OutputStream outputStream = socket.getOutputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8")); 
			
			// logging Remote Host IP Address & Port - 어디서 접속이 됐는지 확인
			InetSocketAddress inetSocketAddress = ( InetSocketAddress )socket.getRemoteSocketAddress();
			consoleLog( "connected from " + inetSocketAddress.getAddress().getHostAddress() + ":" + inetSocketAddress.getPort() );
			
			String request = null; 
			while(true) {
				String line = br.readLine();
				
				//브라우저에서 연결을 끊으면 
				if(line == null) {
					break; 
				}
				
				//SimpleHttpServer는 HTTP Header만 처리 
				if("".equals(line)) {
					break;
				}
				
				//request header의 첫 줄만 읽은 후 서버가 응답을 끊음
				if(request == null) {
					request = line;
					break;
				}
			}
			//요청 처리
			consoleLog(request); //HTTP method, URL, HTTP protocol=> GET / HTTP/1.1
			
			String[] tokens = request.split(" ");
			if("GET".equals(tokens[0])) {
				responseStaticResource(outputStream, tokens[1], tokens[2]); //GET일때 응답을 하기위해선 outputStream필요, 읽을 URL 자원,  protocol 필요
			} else {
				 // method: POST, PUT, DELETE, HEAD, CONNECT 
				 // SimpleHttpServer에서는 무시(400 Bad Request)
				 response400Error(outputStream, tokens[2]);  //GET이 아니면 400 응답
				 
			}
			
			// header
//			outputStream.write( "HTTP/1.1 200 OK\r\n".getBytes( "UTF-8" ) );
//			outputStream.write( "Content-Type:text/html; charset=utf-8\r\n".getBytes( "UTF-8" ) );
//			outputStream.write( "\n".getBytes() ); //"\r\n" == "\n"(빈 개행)
//			// body
//			outputStream.write( "<h1>이 페이지가 잘 보이면 실습과제 SimpleHttpServer를 시작할 준비가 된 것입니다.</h1>".getBytes( "UTF-8" ) ); 

		} catch( Exception ex ) { //responseStaticResource에 대한 예외처리
			consoleLog( "error:" + ex );
		} finally {
			try{
				if( socket != null && socket.isClosed() == false ) {
					socket.close();
				}
				
			} catch( IOException ex ) {
				consoleLog( "error:" + ex );
			}
		}			
	}

	//url에 해당하는 자원을 읽어 outputStream으로 주석처리된 write() 포멧에 맞게 보내기 
	private void responseStaticResource(OutputStream outputStream, String url, String protocol) throws IOException {
		// GET에 대한 요청에 url이 '/'일 경우 default(welcome) file set
		if("/".equals(url)) {
			url = "/index.html";
		}
		
		File file = new File(DOCUMENT_ROOT + url); 
		//지정한 url이 아닌경우, 
		if(!file.exists()) {
			response404Error(outputStream, protocol); //응답시에도 outputStream, http protocol 포멧
			return;
		}
		
		//nio
		byte[] body = Files.readAllBytes(file.toPath()); //파일은 객체이므로 경로를 알려줘야함.
		String contentType = Files.probeContentType(file.toPath()); //파일 경로를 가지고 
		
		outputStream.write((protocol + " 200 OK\n").getBytes( "UTF-8" ) ); //byte+string불가 
		outputStream.write(("Content-Type:" + contentType + "; charset=utf-8\n").getBytes( "UTF-8" ) );
		outputStream.write("\n".getBytes() ); //"\r\n" == "\n"(빈 개행)
		outputStream.write(body); //body내용을 byte로 뿌리기
	}

	//회원 가입 누를 때 400
	private void response400Error(OutputStream outputStream, String protocol) throws IOException {
		String url = "/error/400.html";
		File file = new File(DOCUMENT_ROOT + url);
		byte[] body = Files.readAllBytes(file.toPath());
	
		outputStream.write((protocol + " 400 Bad Request\n").getBytes("UTF-8"));
		outputStream.write("Content-Type:text/html; charset=utf-8\n".getBytes("UTF-8"));
		outputStream.write("\n".getBytes());
		outputStream.write(body);
	}

	//로그인 누를 때 404
	private void response404Error(OutputStream outputStream, String protocol) throws IOException {
		String url = "/error/404.html";
		File file = new File(DOCUMENT_ROOT + url);
		byte[] body = Files.readAllBytes(file.toPath());
		
		//1. http protocol / status code 
		outputStream.write((protocol + " 404 File Not Found\n").getBytes("UTF-8"));
		//2. content type
		outputStream.write("Content-Type:text/html; charset=utf-8\n".getBytes("UTF-8"));
		//3. 개행 
		outputStream.write("\n".getBytes());
		outputStream.write(body);
		
	}

	public void consoleLog( String message ) {
		System.out.println( "[RequestHandler#" + getId() + "] " + message );
	}
}
