package book.factory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import book.dao.BookShelf;
import book.dao.JdbcBookShelf;
import book.dao.ListBookShelf;
import book.dao.MapBookShelf;
import book.dao.SetBookShelf;
import book.vo.Book;


/**
 * 창고 객체(GeneralWarehouse 타입) 생성을 
 * 전문적으로 수행하는 팩토리 클래스
 * @author PC38206
 *
 */
public class BookShelfFactory {
	
	public static BookShelf getWarehouse(String type) {
		BookShelf booksf = null;
		
		if ("list".equals(type)) {
			List<Book> products = new ArrayList<>(); 
			booksf = new ListBookShelf(products);
			
		} else if ("set".equals(type)) {
			Set<Book> products = new HashSet<>();
			booksf = new SetBookShelf(products);
			
		} else if ("map".equals(type)) {
			Map<String, Book> products = new HashMap<>();
			booksf = new MapBookShelf(products);
			
		} else if ("jdbc".equals(type)) {
			booksf = new JdbcBookShelf();
		}
		
		return booksf;
	}

}
