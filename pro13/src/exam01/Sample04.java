package exam01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Sample04 {
public static void main(String[] args) {
	/*
	 * FileReader
	 * 		- 문자 기반 스트림으로 문자 단위로 파일을 읽는다.
	 * 		- 보통 텍스트 파일을 읽기 위해 사용
	 */
	
	File f = new File("C:/Users/kang/file_test.txt");

	try {
		FileReader fr = new FileReader(f);

		char[] buffer = new char[4];
		char[] chars = new char[0];
		
		while (true) {
			int i = fr.read(buffer);
			if (i == -1) { // -1 : 더 이상 읽은 것이 없는 것 /
				break;
			}
			chars = Arrays.copyOf(chars,chars.length + i);
			System.arraycopy(buffer, 0, chars,chars.length - i , i);
		}
		System.out.println(new String(chars));
		
		fr.close(); //안하면 메모리 누수의 원인
		
	} catch (FileNotFoundException e) {
		System.out.println("해당 파일을 찾지 못하였습니다."); // 오타, 잦은 실수 등등
		e.printStackTrace();
	} catch (IOException e) {
		System.out.println("해당 파일을 읽는 과정에 문제가 발생하였습니다.");
		e.printStackTrace();
	}
}
}
