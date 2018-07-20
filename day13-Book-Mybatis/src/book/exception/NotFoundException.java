package book.exception;

import book.vo.Book;

/**
 * 수정, 삭제 작업 중 대상 제품이 없는 경우 
 * 발생시킬 예외를 정의한 클래스
 * 
 * @author PC38209
 *
 */
public class NotFoundException extends Exception {

	public NotFoundException() {
		super("도서 정보가 존재하지 않습니다.");
	}
	
	public NotFoundException(String type, Book book) {
		super(String.format("%s:[%s] 도서 정보가 존재하지 않습니다.", type, book.getBookId()));
	}
}
