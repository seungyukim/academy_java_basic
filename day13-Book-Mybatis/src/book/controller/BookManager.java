package book.controller;

import java.util.List;

import book.dao.BookShelf;
import book.exception.DuplicateException;
import book.exception.NotFoundException;
import book.view.BookView;
import book.view.ErrorView;
import book.view.ListView;
import book.view.MessageView;
import book.view.SingleView;
import book.vo.Book;

/**
 * 책장(BookShelf)을 사용하는
 * 도서 매니저를 나타내는 클래스
 * @author PC38206
 *
 */
public class BookManager {
	
	// 1. 멤버 변수 선언부
	// 작업할 책장에 대한 변수
	private BookShelf books;
	// 작업후 응답에 대한 변수
	private BookView display;
	
	// 2. 생성자 선언부
	// (1) 도서 매니저 기본 생성자
	public BookManager() {
	}
	
	// (2) 매개변수가 있는 도서 매니저 생성자
	public BookManager(BookShelf books) {
		this.books = books;
	}
	
	// books 필드의 접근자 / 수정자 
	public BookShelf getBooks() {
		return books;
	}

	public void setBooks(BookShelf books) {
		this.books = books;
	}

	// 3. 메소드 선언부
	/**
	 * 도서 매니저는 도서 한권를 
	 * 등록을 할 수 있다
	 * @param book
	 */
	public void insert(Book book) {
		int isCnt = 0;
		String message = null;
		try {
			isCnt = books.insert(book);
//			if (addCnt > 0) {
				// 추가 성공한 경우
				message = String.format("도서 정보[%s]추가에 성공하였습니다."
						, book.getBookId());
				display = new MessageView();
				
//			} else {
				// 추가 실패한 경우
//			}
		} catch (DuplicateException e) {
			message = String.format("도서 정보[%s]추가에 실패하였습니다."
					, book.getBookId());
			display = new ErrorView();
			e.printStackTrace();
			
		} finally {
			// 도서 추가시 예외가 발생 해도, 안해도
			// 도서 추가에 대한 메시지가 출력되어야 하므로
			// finally 블록에 작성
			display.display(message);
		}
		
	}
	
	/**
	 * 도서 매니저는 한권의 도서 정보를 수정할 수 있다.
	 * @param book
	 */
	public void update(Book book) {
		int udCnt = 0;
		String message = null;
		try {
			udCnt = books.update(book);
//			if (setCnt > 0) {
				// 수정이 성공한 경우
				message = String.format("도서 정보[%s]수정에 성공하였습니다."
						, book.getBookId());
				display = new MessageView();
//			} else {
				// 수정이 실패한 경우
//			}
		} catch (NotFoundException e) {
			message = String.format("도서 정보[%s]수정에 실패하였습니다."
					, book.getBookId());
			display = new ErrorView();
			e.printStackTrace();
		} finally {
			
			display.display(message);
		}
		
		
	}
	
	/**
	 * 도서 매니저는 더 이상 필요하지 않은
	 * 도서 정보를 제거할 수 있다.
	 * 이 때, 제거할 도서의 정보는 알고 있어야 한다.
	 * @param book
	 */
	public void delete(Book book) {
		int dlCnt = 0;
		String message = null;
		try {
			dlCnt = books.delete(book);
//			if (rmCnt > 0) {
				// 삭제 성공한 경우
				message = String.format("도서 정보[%s]삭제에 성공하였습니다."
						, book.getBookId());
				display = new MessageView();
//			} else {
				// 삭제 실패한 경우
//			}
		} catch (NotFoundException e) {
			message = String.format("도서 정보[%s]삭제에 실패하였습니다."
					, book.getBookId());
			display = new ErrorView();
			e.printStackTrace();
		} finally {
			
			display.display(message);
		}
		
		
	}
	
	/**
	 * 도서 매니저는 요청된 도서 한권을 가지고 올 수 있다.
	 * @param book
	 * @return
	 */
	public void select(Book book) {
		Book found;
		try {
			found = books.select(book);
			
//			if (found != null) {
//				// 찾아올 제품이 존재할 때
			display = new SingleView();
			display.display(found);
//			} else {
		
		} catch (NotFoundException e) {
			display = new ErrorView();
			display.display("찾는 도서["
					+ book.getBookId()
					+"]이(가) 존재하지 않습니다.");
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * 도서 매니저는 현재 등록되어 남아있는 
	 * 도서 정보 전체 목록을 조회할 수 있다
	 * @return
	 */
	public void select() {
		List<Book> boks = books.select();
		display = new ListView();
		display.display(boks);
	}
	
	// 추가 기능 구현
	
	/**
	 * low ~ high 사이의 가격대 책을 검색
	 * @param low  : 검색하고자 하는 최저 금액
	 * @param high : 검색하고자 하는 최고 금액
	 * @return low ~ high 사이의 가격대 도서 목록
	 */
//	public List<Book> select(int low, int high) {
//		
//	}
//	
//	/**
//	 * 도서 title 에 keyword 가 들어가는 책을 검색
//	 * @param keyword : 검색하고자 하는 키워드
//	 * @return 도서 title 에 keyword 가 들어가는 도서 목록
//	 */
//	public List<Book> select(String keyword) {
//		Book found;
//		try {
//			found = books.select(keyword);
//			
////			if (found != null) {
////				// 찾아올 제품이 존재할 때
//			display = new SingleView();
//			display.display(found);
////			} else {
//		
//		} catch (NotFoundException e) {
//			display = new ErrorView();
//			display.display("찾는 도서가 존재하지 않습니다.");
//			e.printStackTrace();
//		}
//	}
//	
//	/**
//	 * 전체 등록된 책의 개수를 구하여 리턴
//	 * @return 전체 등록된 책의 개수
//	 */
//	public int total() {
//		
//	}
//	
//	/**
//	 * 등록된 전체 책 정보를 삭제 후 삭제된 건수를 리턴
//	 * @return 삭제된 건수
//	 */
//	public int delete() {
//		
//	}
//	
}







