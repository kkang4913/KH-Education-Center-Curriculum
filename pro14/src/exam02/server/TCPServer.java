package exam02.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TCPServer {
public static void main(String[] args) {
	try {
		/*
		 * 1. 네트워크 통신을 위한 IP 주소 정보 설정
		 */
		byte[] addr = new byte[] {(byte)172,(byte)30,(byte)1,(byte)38};	
		InetAddress serverIp = InetAddress.getByAddress(addr);
		int serverPort =50000;
		System.out.println("네트워크 통신 주소 설정중....");
		
		/*
		 * 2. 서버용 소켓 생성 후 서버 IP, 서버Port 바인딩
		 */
		System.out.println("서버용 소켓 생성!");
		ServerSocket serverSock = new ServerSocket();
		InetSocketAddress serverIpPort = new InetSocketAddress(serverIp,serverPort);
		serverSock.bind(serverIpPort);
		System.out.println("서버용 소켓에 주소 바인딩....");
		
		/*
		 * 3. 클라이언트 요청 대기 후 승낙하(accept)하여 클라이어트용 소켓 생성
		 */
		System.out.println("클라이언트 접속 대기중.....");
		Socket sock = serverSock.accept();
		System.out.println("클라이언트 접속 승낙!! 클라이언트용 소켓 생성");
		/*
		 * 4. 통신용 입출력 스트림 생성 
		 */
		System.out.println("통신용 입출력 스트림 생성중...");
		BufferedReader sIn =new BufferedReader(new InputStreamReader(sock.getInputStream()));  //기반 스트림
		BufferedWriter sOut =new BufferedWriter(new OutputStreamWriter(sock.getOutputStream())); //기반 스트림
		System.out.println("통신용 입출력 스트림 생성 완료");

		SimpleDateFormat time = new SimpleDateFormat("yyyy년 MM월 dd일 a hh시 mm분 ss초");
		InetAddress clientIp = sock.getInetAddress();
		int clientPort = sock.getPort();
		while(true) {
		while (sIn.ready()) {
			String now = time.format(new Date());
			String line = sIn.readLine();
			System.out.printf("[%s] [%s:%d] - \"%s\" 메시지를 수신하였습니다.\n",now, clientIp.getHostAddress(), clientPort, line);
		}
		}
		/*
		 * 5. 모든 데이터 수신을 완료하였으면 모든 자원 반납
		 */
		
	} catch (UnknownHostException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	
}
}
