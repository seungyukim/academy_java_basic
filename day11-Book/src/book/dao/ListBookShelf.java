package book.dao;

import java.util.ArrayList;
import java.util.List;

import book.exception.DuplicateException;
import book.exception.NotFoundException;
import book.vo.Book;


public class ListBookShelf implements BookShelf {
			
			// 1. 멤버 변수 선언부
			private List<Book> books;
			
			// 2. 생성자 선언부
			// (1) 기본 생성자
			public ListBookShelf() {
				books = new ArrayList<Book>();
			}
			
			// (2) 매개 변수를 받는 생성자
			public ListBookShelf(List<Book> books) {
				this.books = books;
			}

			/** 접근자 */
			public List<Book> getBooks() {
				return books;
			}

			/** 수정자 */
			public void setBooks(List<Book> books) {
				this.books = books;
			}

			// 3. 메소드 선언부
			
			@Override
			public int insert(Book book) throws DuplicateException {
				int index = findBookIdx(book);
				int isCnt = 0;
				return isCnt;
			}

			@Override
			public int update(Book book) throws NotFoundException {
				int udCnt = 0;
				int udIdx = findBookIdx(book);
				
				if (udIdx > -1) {
					books.set(udIdx, book);
					udCnt++;
					
				} else {
					throw new NotFoundException("set", book);
				}
				
				return udCnt;
			}

			@Override
			public int delete(Book book) throws NotFoundException {
				int dlCnt = 0;
				int dlIdx = findBookIdx(book);
				
				if (dlIdx > -1) {
					books.remove(dlIdx);
					dlCnt++;
					
				} else {
					throw new NotFoundException("delete", book);
				}
				
				return dlCnt;
			}

			@Override
			public Book select(Book book) throws NotFoundException {
				int slIndex = findBookIdx(book);
				Book found = null;
				
				if (slIndex > -1) {
					// 찾아올 제품이 존재
					found = books.get(slIndex); 
					
				} else {
					throw new NotFoundException("select", book);
				}
				
				return found;
			}

			@Override
			public List<Book> select() {
				return this.books;
			}
			
			// 리스트 안에 찾으려는 제품의 인덱스를 구하는 지원 메소드
			private int findBookIdx(Book book) {
				int index = -1;
				
				for (int idx = 0; idx < books.size(); idx++) {
					if (books.get(idx).equals(book)) {
						index = idx;
						break;
					}
				}
				
				return index;
					
			}
				
}





















