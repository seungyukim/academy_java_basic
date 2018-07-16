package io.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 표준 입력인 키보드 입력을 받아서
 * 표준 출력인 모니터로 출력하는 클래스
 * ---------------------------------
 * 1. node stream   (키보드 : System.in : inputStream)
 * 2. filter stream (stream --> reader : inputStreamReader)
 *    1바이트 인풋스트림을 2바이트 문자로 변경
 *    (키보드는 사실 문자 입력이므로)
 *  
 * 3. filter stream (reader --> reader : BufferedReader)
 *    2바이트 문자 1개를 1줄 단위로 읽어서 스트링으로 만들 수 있는
 *    편리한 메소드를 사용한다.
 * 
 * 4. 3에서 만들어진 filter stream 객체를 사용하여
 *    read() 작업 진행
 *    
 * 5. 읽은 내용을 표준 출력(모니터 = System.out)
 * 
 * 6. 마지막 filter stream 닫기(자원 해제)
 * 
 * @author PC38209
 *
 */
public class KeyboardInput {

	public static void main(String[] args) throws IOException {
		// 1. 입력 노드 스트림(표준 입력:키보드)
//		InputStream in = System.in;
		
		// 2. 노드 스트림을 포장할 필터 스트림
//		InputStreamReader ir = new InputStreamReader(in);
		
		// 3. 2의 필터 스트림을 편리한 사용을 위하여 
		//    한번 더 포장할 필터 스트림
//		BufferedReader br = new BufferedReader(ir);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("값을 입력하세요... (ctrl + z 입력시 중단) ");
		
		// 4. 3의 필더 스트림의 메소드를 사용하여
		//    키보드 입력을 읽어 들인다.
		String readData = null;
		while ((readData = br.readLine()) != null) {
			// 5. null 이 아니면 읽은 데이터가 있으므로 출력
			System.out.println("읽은 데이터 : " + readData);
		}
		
		// 6. 자원 해제
		br.close();
		
	}

}

































