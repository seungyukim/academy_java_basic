package book.test;

import book.controller.BookManager;
import book.dao.BookShelf;
import book.dao.JdbcBookShelf;
import book.dao.MybatisBookShelf;
import book.vo.Book;


public class BookStore {

	public static void main(String[] args) {

//		Book[] books = new Book[0];
//		List<Book> Books = new ArrayList<Book>();
//		Set<Book> booksSet = new HashSet<Book>();
//		Map<String, Book> booksMap = new HashMap<>();
		
		// 2. 도서를 배치할 책장이 필요
//		BookShelf books = new ListBookShelf();
//		BookShelf books = new SetBookShelf();
//		BookShelf books = new MapBookShelf();
		BookShelf books = new JdbcBookShelf();
		BookShelf boks = new MybatisBookShelf();
		
		// 3. 책장을 관리할 도서 매니저를 고용함
		BookManager manager = new BookManager(books);
		
		//--------------------------------------------------
	
		// 책장에 배치할 신규 도서가 도착했다.
		Book hesse = new Book("BK001", "데미안", "헤르만 헤세", 9800, "9783161484100", "더스토리");
		Book ove = new Book("BK002", "오베라는 남자", "프레드릭 배크만", 13800, "9553261685100", "다산책방");
		Book cat = new Book("BK003", "고양이", "베르나르 베르베르", 12800, "9283589484120", "열린책들");
		Book nami = new Book("BK004", "나미야 잡화점의 기적 ", "히가시노게이고", 14800, "9453861487110", "현대문학");
		Book promise = new Book("BK005", "돌이킬 수 없는 약속 ", "야쿠마루가쿠 ", 15000, "9163461784200", "북프라자");
		
		// 0. 전체 1건씩 모두 삭제		
		manager.delete(hesse);
		manager.delete(ove);
		manager.delete(cat);
		manager.delete(nami);
		manager.delete(promise);
				
		// 1. 도착한 도서의 정보를 추가
		manager.insert(hesse);
		manager.insert(ove);
		manager.insert(cat);
		manager.insert(nami);
		manager.insert(promise);
		
		// 2. 도서 정보 전체 확인
		manager.select();
		
		// 3. hesse 도서 수정
		Book hesse2 = new Book("BK001", "데미안", "헤르만 헤세", 8600, "9783161484100", "더스토리");
		manager.update(hesse2);
		
		// 4. 수정된 hesse 도서 수정 확인		
		manager.select(new Book("BK001", null, null, 0, null, null));
				
		// 5. 개시 종료할 도서 정보 폐기
		manager.delete(new Book("BK001", null, null, 0, null, null));
	 			
		// 6. 폐기 확인을 위해 전체 목록 재 조회
		System.out.println("====================");
		manager.select();
		
		// 7. 없는 코드 조회 ==> NotFoundException 발생 상황
		Book bk007 = new Book("BK006");
		manager.select(bk007);
				
		// 8. 없는 제품 수정 ==> NotFoundException 발생 상황
		manager.update(bk007);
				
		// 9. 있는 제품 중복 추가 ==> DuplicateException
		Book bk002 = new Book("BK002");
		manager.insert(bk002);
				
//		// 10. 전체 1건씩 모두 삭제
//		manager.delete(ove);
//		manager.delete(cat);
//		manager.delete(nami);
//		manager.delete(promise);
	}
}























