package exam01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Sample03 {
public static void main(String[] args) {
	/*
	 * FileOutputStream
	 * 		- 바이트 단위로 파일에 데이터를 쓰기 위해 사용
	 * 		- 미디어, 이미지, 텍스트 파일 등 모든 종류의 파일 쓰기 가능
	 */

	File f = new File("C:/Users/kang/file_test.txt");

	try (FileOutputStream fos = new FileOutputStream(f, true)) {
		fos.write(65);
		
		byte[] bArr = new byte[] {66,67,68,69};
		fos.write(bArr);
		
		fos.write("\nFileOutputStream\n".getBytes());
		
		fos.write("\n한글쓰기\n".getBytes());
		
		
		fos.flush();

	} catch (FileNotFoundException e) {
		System.out.println("해당 파일을 찾지 못하였습니다.");
		e.printStackTrace();
	} catch (IOException e) {
		System.out.println("파일 쓰기 작업중 문제가 발생하였습니다.");
		e.printStackTrace();
	}

}
}
