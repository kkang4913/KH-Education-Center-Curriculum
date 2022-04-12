package exam01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class Sample02 {							//처리 x 미룬것
public static void main(String[] args) { //throws FileNotFoundException {
	
	/*
	 * FileInputStream 클래스
	 * 		- 바이트 기반 스트림으로 바이트 단위로 파일을 읽는다.
	 * 		- 미디어, 이미지, 텍스트 파일 등 모든 종류의 파일 읽기 가능
	 */

	File f = new File("C:/Users/kang/file_test.txt");

	try {
		FileInputStream fis = new FileInputStream(f);
		/*
		while (true) {
			int i = fis.read();
			if (i == -1) { // -1 : 더 이상 읽은 것이 없는 것 /
				break;
			}
			System.out.print((char) i); // 읽은 byte 데이터를 출력
		}
		*/
		byte[] buffer = new byte[4];
		byte[] bytes = new byte[0];
		while (true) {
			int i = fis.read(buffer);
			if (i == -1) { // -1 : 더 이상 읽은 것이 없는 것 /
				break;
			}
			bytes = Arrays.copyOf(bytes,bytes.length + i);
			System.arraycopy(buffer, 0, bytes,bytes.length - i , i);
		}
		System.out.println(new String(bytes));
		
		fis.close(); //안하면 메모리 누수의 원인
		
	} catch (FileNotFoundException e) {
		System.out.println("해당 파일을 찾지 못하였습니다."); // 오타, 잦은 실수 등등
		e.printStackTrace();
	} catch (IOException e) {
		System.out.println("해당 파일을 읽는 과정에 문제가 발생하였습니다.");
		e.printStackTrace();
	}

}
}
