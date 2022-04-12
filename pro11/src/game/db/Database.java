package game.db;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Database {
	private File file;
	
	public Database() {
		this.file = new File("C:/Users/kang/data_write");
	}
	
	public Database(File file) {
		this.file = file;
	}
	
	
	
	public int[] load() {
		//파일을 읽고 배열로 반환
		
		int[] iArr2 = new int[3];
		if (file.exists()) {
			try (FileReader fr = new FileReader(file)) {
				char[] buffer = new char[16];
				char[] data = new char[0];
				while (true) {
					int rSize = fr.read(buffer);
					
					if (rSize == -1) {
						break;
					}
					
					data = Arrays.copyOf(data, data.length + rSize);
					System.arraycopy(buffer, 0, data, data.length - rSize, rSize);
				}
				
				StringTokenizer st = new StringTokenizer(new String(data), " ");
				iArr2 = new int[st.countTokens()];
				int i =0;
				while (st.hasMoreTokens()) {
					iArr2[i++] = Integer.parseInt(st.nextToken());
				}
				
				System.out.println(Arrays.toString(iArr2));
				
			} catch (FileNotFoundException e) {
				System.out.println("해당 파일이 존재하지 않습니다.");
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("파일 쓰기 작업중 문제가 발생하였습니다.");
				e.printStackTrace();
			}
		}
		return iArr2;
	}
	public void save(int[] record) {
		//정수 배열을 파일로 저장
		String[] sArr = new String[record.length];
		for (int i = 0; i < record.length; i++) {
			sArr[i] = Integer.valueOf(record[i]).toString();
		}
		
		try (FileWriter fw = new FileWriter(file)) {
			fw.write(String.join(" ", sArr));
			fw.flush();
		} catch (FileNotFoundException e) {
			System.out.println("해당 파일이 존재하지 않습니다.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("파일 쓰기 작업중 문제가 발생하였습니다.");
			e.printStackTrace();
		}
		
	}
	
}
