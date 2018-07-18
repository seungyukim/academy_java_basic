package book.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import book.vo.Book;

public class SetBookShelf implements BookShelf {

	// 1. 멤버변수 : 도서를 저장할 자료구조로 set 선택
	private Set<Book> books;
	
	// 2. 생성자
	public SetBookShelf() {
		books = new HashSet<Book>();
	}
	
	public SetBookShelf(Set<Book> book) {
		super();
		this.books = books;
	}
	
	// 3. 메소드 
	@Override
	public int insert(Book book) {
		boolean success = ((Set<Book>) book).add(book);
		return success ? 1 : 0;
	}

	@Override
	public Book select(Book book) {
		return findBook(book);
	}

	@Override
	public int update(Book book) {
		// Set 은 수정기능의 api 가 없으므로 
		// 기존 것 remove 후 add
		boolean rmSuccess = ((Set<Book>) book).remove(book);
		boolean addSuccess = false;
		if (rmSuccess) {
			books.add(book);
			addSuccess = true;
		}
		return addSuccess ? 1 : 0 ;
	}

	@Override
	public int delete(Book book) {
		boolean success = books.remove(book);
		return success ? 1 : 0;
	}

	@Override
	public List<Book> select() {
		List<Book> books = new ArrayList<Book>();
		
		for (Book book: this.books) {
			books.add(book);
		}
		
		return books;
	}


	private Book findBook(Book book) {
		Book found = null;
		
		for (Book bk: books) {
			if (bk.equals(book)) {
				found = bk;
				break;
			}
		}
		
		return found;
	}
}
