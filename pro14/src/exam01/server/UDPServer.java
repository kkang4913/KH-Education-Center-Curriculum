package exam01.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPServer {
public static void main(String[] args) {
	/*
	 * 1. 네트워크 통신을 위한 IP 주소 정보 설정
	 */
	
	try {
		//서버 주소 준비
		byte[] addr = new byte[] {(byte)172,(byte)30,(byte)1,(byte)38};
		InetAddress serverIp = InetAddress.getByAddress(addr);
		int serverPort = 51000;
		
		/*
		 * 2. UDP 통신용 소켓 생성
		 */										   //서버포트 , 서버아이피
		DatagramSocket udpSock = new DatagramSocket(serverPort, serverIp);
		
		while (true) {
			
			/*
			 * 3. 클라이언트가 서버에 송신한 데이터를 송신하기 위한 패킷 생성 
			 *    (서버가 활성화 되어 있어여 한다.)
			 */
			byte[] data = new byte[1024];
			DatagramPacket packet = new DatagramPacket(data, data.length);
			udpSock.receive(packet);
			
			/*
			 * 수신한 패킷에서 클라이언트 정보 확인
			 */
			InetAddress clientIp = packet.getAddress();
			int clientPort = packet.getPort();
			
			
			/*
			 * 4. 수신한 데이터를 출력하여 확인
			 */
			String msg = new String(packet.getData());
			System.out.printf("%s:%d 주소로 부터 \"%s\" 메시지를 수신하였습니다.\n",clientIp.getHostAddress(), clientPort, msg);
			
		}
		
		
		
		/*
		 * 5. 데이터 송신을 완료하였으면 모든 자원 반밥
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
