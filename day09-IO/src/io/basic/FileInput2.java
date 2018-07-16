package io.basic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 파일로 입력을 받아서
 * 표준 출력(콘솔창)을 하는 클래스
 * -----------------------------
 * -- 입력 --
 * 1. node stream (파일(문자 파일:reader) : FileReader) 
 * 2. filter stream (reader -> reader : BufferedReader)
 * 2. filter stream 메소드 사용 : readLine()
 * 
 * -- 출력 --
 * 4. node stream (표준 출력 : System.out : PrintStream)
 * 5. 1줄 출력 : println() 메소드 사용
 * 
 * -- 정리 --
 * 6. 입력 filter stream 닫기 
 *  
 * @author PC38209
 *
 */
public class FileInput2 {

	public static void main(String[] args) {

		// 1. input node stream : file reader
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("out.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		// 3. filter stream 메소드로 읽기 : readLine();
		String input = null;
		
		try {
			while ((input = br.readLine()) != null) {
				// 4. 5.
				System.out.println("파일에서 읽은 데이터:" + input);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}

}






















