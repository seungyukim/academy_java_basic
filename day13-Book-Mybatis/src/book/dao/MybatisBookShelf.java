package book.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import book.exception.DuplicateException;
import book.exception.NotFoundException;
import book.mapper.BookMapper;
import book.mybatis.MybatisClient;
import book.vo.Book;

public class MybatisBookShelf implements BookShelf {
	
	private SqlSessionFactory factory;
	
	public MybatisBookShelf() {
		factory = MybatisClient.getFactory(); 
	}

	public int insert(Book book) throws DuplicateException {
		// 추가할 대상 제품이 있는지 선 조회
		if (!isExists(book)) {
			throw new DuplicateException("추가", book);
		}
				
		// 1. SqlSession 얻기 : DML 작업은 auto-commit을 활성화
		SqlSession session = factory.openSession(true);
		int addCnt = 0;
				
		// 2. Mapper 인터페이스 객체를 session에서 얻기
		BookMapper mapper;
		mapper = session.getMapper(BookMapper.class);
				
		try {
			// 3. mapper를 통하여 삭제진행
			addCnt = mapper.insert(book);
		} finally {
			if (session != null) {
				session.close();
			}
		}
				
		return addCnt;
		
	}

	public Book select(Book book) throws NotFoundException {
		// 조회할 대상 제품이 있는지 선 조회
		if (!isExists(book)) {
			throw new NotFoundException("조회", book);
		}
		
		// 1. SqlSession 얻기 : DML 작업은 auto-commit을 활성화
		SqlSession session = factory.openSession(false); // true가 아님
		Book found = null;
		
		// 2. Mapper 인터페이스 객체를 session에서 얻기
		BookMapper mapper;
		mapper = session.getMapper(BookMapper.class);
		
		try {
			// 3. mapper를 통하여 삭제진행
			found = mapper.selectOne(book);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		
		return found;
	}

	public int update(Book book) throws NotFoundException {
		// 수정할 대상 제품이 있는지 선 조회
		if (!isExists(book)) {
			throw new NotFoundException("수정", book);
		}
				
		// 1. SqlSession 얻기 : DML 작업은 auto-commit을 활성화
		SqlSession session = factory.openSession(true);
		int setCnt = 0;
				
		// 2. Mapper 인터페이스 객체를 session에서 얻기
		BookMapper mapper;
		mapper = session.getMapper(BookMapper.class);
				
		try {
			// 3. mapper를 통하여 삭제진행
			setCnt = mapper.update(book);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		
		return setCnt;
	}

	public int delete(Book book) throws NotFoundException {
		// 삭제할 대상 제품이 있는지 선 조회
		if (!isExists(book)) {
			throw new NotFoundException("삭제", book);
		}
		
		// 1. SqlSession 얻기 : DML 작업은 auto-commit을 활성화
		SqlSession session = factory.openSession(true);
		int rmCnt = 0;
		
		// 2. Mapper 인터페이스 객체를 session에서 얻기
		BookMapper mapper;
		mapper = session.getMapper(BookMapper.class);
		
		try {
			// 3. mapper를 통하여 삭제진행
			rmCnt = mapper.deleteOne(book);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		
		return rmCnt;
	}

	@Override
	public List<Book> select() {
		// 1. SqlSession 얻기
		SqlSession session = factory.openSession();
		
		// 2. Mapper 인터페이스 객체를 session에서 얻기
		BookMapper mapper;
		mapper = session.getMapper(BookMapper.class);
		
		List<Book> books = null;
		
		try {
			// 3. mapper 를 통하여 조회
			books = mapper.selectAll();
		} finally {
			// 4. session 닫기
			if (session != null)
				session.close();
		}
		
		return books;
	}
	
	
	// isExists 지원 메소드 작성
	private boolean isExists(Book book) {
		boolean isExists = false;
		
		// 1. SqlSession 얻기
		SqlSession session = factory.openSession();
		
		// 2. Mapper 인터페이스 객체를 session에서 얻기
		BookMapper mapper;
		mapper = session.getMapper(BookMapper.class);
		
		// 3. mapper 객체에 메소드 호출로 쿼리 실행
		try {
			String bookId = mapper.isExists(book);
			if (bookId != null) {
				isExists = true;
			}
		} finally {
			// 4. session 닫기
			if (session != null)
				session.close();
		}
		
		return isExists;
	}

	
}






