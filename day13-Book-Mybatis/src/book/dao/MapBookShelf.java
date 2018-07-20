package book.dao;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import book.exception.DuplicateException;
import book.exception.NotFoundException;
import book.vo.Book;


public class MapBookShelf implements BookShelf {
	
	// 1. 멤버 변수 선언 : 제품정보를 저장할 맵
	Map<String, Book> books;
	
	// 2. 생성자
	// (1) 기본 생성자
	public MapBookShelf() {
		super();
		books = new HashMap<>();
	}

	// (2) 매개변수를 받는 생성자
	public MapBookShelf(Map<String, Book> books) {
		super();
		this.books = books;
	}

	@Override
	public int insert(Book book) throws DuplicateException {
		int isCnt = 0;
		
		// 같은 객체가 있는지 검사
		if (!isExists(book)) {
			books.put(book.getBookId(), book);
			isCnt++;
		} else {
			// 같은 객체가 존재함
			throw new DuplicateException("insert", book);
		}
		
		return isCnt;
	}

	@Override
	public Book select(Book book) throws NotFoundException {
		Book found = null;
		
		if (isExists(book)) {
			found = books.get(book.getBookId());
		} else {
			// 조회할 제품이 존재하지 않음
			throw new NotFoundException("get", book);
		}
		
		return found;
	}

	@Override
	public int update(Book book) throws NotFoundException {
		int udCnt = 0;
		
		if (isExists(book)) {
			books.replace(book.getBookId(), book);
			udCnt++;
		} else {
			// 수정할 제품이 존재하지 않음
			throw new NotFoundException("update", book);
		}
		
		return udCnt;
	}

	@Override
	public int delete(Book book) throws NotFoundException {
		int dlCnt = 0;
		
		if (isExists(book)) {
			books.remove(book.getBookId());
			dlCnt++;
		} else {
			// 삭제할 제품이 존재하지 않음
			throw new NotFoundException("delete", book);
		}
		
		return dlCnt;
	}

	@Override
	public List<Book> select() {
		Collection<Book> collection = books.values();
		Book[] prodArr = new Book[collection.size()];
		
		return Arrays.asList(collection.toArray(prodArr));
	}

	// 제품이 이미 존재하는지 여부 확인
	// true  : 존재함
	// false : 없음
	private boolean isExists(Book book) {
		return books.containsKey(book.getBookId());
	}

}
