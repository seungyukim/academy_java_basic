package book.exception;

import book.vo.Book;

public class DuplicateException extends Exception {

	public DuplicateException() {
		super("도서 정보가 중복되었습니다.");
	}
	
	// 매개변수가 있는 생성자
	public DuplicateException(String type, Book book) {
		super(String.format("%s:[%s] 도서 정보가 중복되었습니다.", type, book.getBookId()));
	}
}
