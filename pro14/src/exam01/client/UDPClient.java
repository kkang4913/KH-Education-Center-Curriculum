package exam01.client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class UDPClient {
public static void main(String[] args) {
		/*
		 * 1. 네트워크 통신을 위한 IP 주소 정보 설정
		 */
	try {
		//1. 방법
		//InetAddress ip = InetAddress.getByName("localhost");
		//출력으로 확인							//외부통신이 아닌 내부pc안
		
		//2. 방법
		//바이트 배열에 직접 주소를 넣는다.
		//byte[] addr = new byte[] {(byte)172,(byte)30,(byte)1,(byte)38};
		//InetAddress ip = InetAddress.getByAddress(addr);
		
		//3. 방법
		//자바 안에서 직접 알아오게 하는 방법
		//클라이언트 주소 준비
		InetAddress clientIp = InetAddress.getLocalHost();
		int clientPort = 50000;
		
		//서버 주소 준비
		byte[] addr = new byte[] {(byte)172,(byte)30,(byte)1,(byte)38};
		InetAddress serverIp = InetAddress.getByAddress(addr);
		int serverPort = 51000;
		
		/*
		 * 2. UDP 통신용 소켓 생성
		 */										   //클라이언트포트 , 아이피
		DatagramSocket udpSock = new DatagramSocket(clientPort, clientIp);
		
		/*
		 * 3. 서버에 데이터 송신하기 위한 패킷 생성 (서버가 활성화 되어 있어여 한다.)
		 */
		
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("서버에 전송할 데이터를 입력 : ");
			String userdata = sc.nextLine();
			byte[] data = userdata.getBytes();
			DatagramPacket packet = new DatagramPacket(data, data.length, serverIp, serverPort);
			udpSock.send(packet);
		}
		/*
		 * 4. 데이터 송신을 완료하였으면 모든 자원 반납.
		 */
		//udpSock.close();
		
		
		
	} catch (UnknownHostException e) {
		e.printStackTrace();
	} catch (SocketException e) {
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
