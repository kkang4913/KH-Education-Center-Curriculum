package exam01;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Sample01 {
	public static void main(String[] args) {
		/*
		 * 입출력(IO, Input/Output)
		 *     - 컴퓨터 내부/외부 장치간에 데이터를 주고받는 것
		 *     - 프로그램을 기준으로 내부/외부 장치에서 데이터가 현재 동작하는 프로그램으로 들어오면 입력
		 *       현재 동작하는 프로그램이 내부/외부 장치로 데이터를 보내면 출력
		 *       
		 * 스트림(Stream)
		 *     - 입력스트림, 출력스트림으로 나누어서 부른다.
		 *     - 두 장치간에 데이터를 지속적으로 입/출력하기 위해 생성된 연결 통로
		 *     - 단방향 통신을 지원하기 때문에 입력/출력을 동시에 할 수 없다.
		 *       동시에 하기 위해서 입력스트림, 출력스트림을 개별적으로 만든다.
		 *     - 스트림을 통해 데이터를 입/출력 할 때 문자기반스트림과 바이트기반스트림
		 *       으로 분류한다.
		 *     - 문자기반스트림의 경우 일반 텍스트 문서를 입/출력하기 위해 사용(보통 txt 확장자를 가지는 파일)
		 *     - 바이트기반스트림의 경우 일반 텍스트 문서를 제외한 모든 파일을 입/출력하기 위해 사용
		 *       (영상, 음향, 이미지, 각종 실행파일 등...)
		 */

		/*
		 * File 클래스
		 * 		- 파일의 크기, 이름, 그 외 여러 정보를 알아내기 위한 클래스로 사용
		 * 		- 파일 생성, 삭제 및 폴더 생성 삭제 기능을 제공
		 */
		//java.io.File
		File f = new File("C:/Users/kang/eclipse/jee-2021-12/eclipse/eclipse.ini");
		
		
		System.out.printf("파일 크기 : %d Byte\n",f.length());
		System.out.printf("파일 크기 : %.2f KByte\n",f.length() /1024.0);
		
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy년 MM월 dd일  a : hh시 mm분 ss초");
		String modifyDate = sFormat.format(new Date(f.lastModified()));
		System.out.printf("수정 날짜 : %s\n",modifyDate);
		
		System.out.printf("실행파일 : %s\n", f.canExecute());
		System.out.printf("읽기파일 : %s\n", f.canRead());
		System.out.printf("쓰기파일 : %s\n", f.canWrite());
		
		System.out.printf("파일 : %s\n", f.isFile());
		System.out.printf("폴더 : %s\n", f.isDirectory());
		System.out.printf("숨김 : %s\n", f.isHidden());
		
		System.out.printf("파일/폴더명 : %s\n", f.getName());
		System.out.printf("상위 폴더명 : %s\n", f.getParent());
		System.out.printf("전체 경로명 : %s\n", f.getPath());
		
		System.out.printf("실제 존재하는 파일/폴더 유무 : %s\n",f.exists());
		
		//다양한 확장자를 지닌 파일 생성
		File f2 = new File("C:/Users/kang/eclipse/jee-2021-12/eclipse/my_file.wav");
		try {
			f2.createNewFile();
		} catch (IOException e) {
			System.out.println("my_file.txt 파일 생성문 에러 발생!");
			e.printStackTrace();
		}
		
		
		//폴더 생성
		File f3 = new File("C:/Users/kang/eclipse/jee-2021-12/eclipse/my_folder");
		f3.mkdir();

		File f4 = new File("C:/Users/kang/eclipse/jee-2021-12/eclipse/my_folder");
		f3.delete();
		
		File f5 = new File("C:/Users/kang/eclipse/jee-2021-12/eclipse");
		String[] strfiles = f5.list();
		File[] fFiles =f5.listFiles();
		
		System.out.println(Arrays.toString(strfiles));
		System.out.println(Arrays.toString(fFiles));
		
		for (int i = 0; i < fFiles.length; i++) {
			String name = fFiles[i].getName();
			if (name.startsWith("my_")) {
				System.out.println(fFiles[i].getPath() + "파일을 삭제하였습니다.");
				fFiles[i].delete();
			}
		}
		
		
		
		
		
		
		
		
		
		
	}
}
