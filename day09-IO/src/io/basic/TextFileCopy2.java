package io.basic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 파일 입력을 받아서
 * 파일로 출력하는 클래스
 * -------------------------------
 * -- 입력 --
 * 1. node stream (문자(reader) 파일 : FileReade)
 * 2. filter stream (reader -> reader : BufferedReader)
 * 3. filter stream 의 메소드 사용 : readLine()
 * 
 * -- 출력 --
 * 4. node stream (문자(writer) 파일 : FileWriter)
 * 5. filter stream (writer -> writer : PrintWriter)
 * 6. write 작업 : filter stream 의 메소드 사용 : println()
 * 
 * -- 정리 --
 * 7. 입력 filter stream 닫기
 * 7. 출력 filter stream 닫기
 * 
 * @author PC38209
 *
 */
public class TextFileCopy2 {

	public static void main(String[] args) {

		// 1. input node stream
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("out.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		// ========== 입력 객체 선언 끝
		
		// 4. output code stream
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new FileWriter("copied.txt"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// ========== 출력 객체 선언, 초기화 끝
		
		// 3. read 작업
		String input = null;
		
		try {
			while ((input = br.readLine()) != null) {
				// 6. write 작업
				pw.println("복사된 내용:" + input);
				// 화면 출력을 같이
				System.out.println("파일에서 읽은 데이터:" + input);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
			try {
				if (br != null)
					br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("파일 복사가 완료되었습니다.");
		if (pw != null)
			pw.close();
		
	}

}





























