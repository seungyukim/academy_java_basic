package book.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import book.exception.DuplicateException;
import book.exception.NotFoundException;
import book.vo.Book;


public class JdbcBookShelf implements BookShelf {
	
	// DB 커넥션을 위한 정보
	private static final String URL = "jdbc:oracle:thin:@//127.0.0.1:1521/XE";
	private static final String USER = "SCOTT";
	private static final String PASSWORD = "TIGER";
	private static final String DRIVER = "oracle.jdbc.OracleDriver";

	// 2. 생성자 선언
	public JdbcBookShelf() { }
	

	@Override
	public int insert(Book book) throws DuplicateException {
		// 추가하려는 제품이 이미 존재하는지 검사
		if (isExists(book)) {
			throw new DuplicateException("추가", book);
		}
		
		// 0. 필요 객체 선언
		int isCnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			// 1. 드라이버 로드
			Class.forName(DRIVER);
			
			// 2. 커넥션 맺기
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			// 3. 쿼리 준비
			String sql = " INSERT INTO book(bookId, title, author, price, isbn, publish)"
			           + " VALUES (?, ?, ?, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, book.getBookId());
			pstmt.setString(2, book.getTitle());
			pstmt.setString(3, book.getAuthor());
			pstmt.setInt(4, book.getPrice());
			pstmt.setString(5, book.getIsbn());
			pstmt.setString(6, book.getPublish());
			
			// 4. 쿼리 실행
			isCnt = pstmt.executeUpdate();
			
			// 5. 결과 처리
			//   ==> 쿼리 실행 전 중복 여부 검사하므로 특별한
			//       결과 처리가 필요 없음
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			// 6. 자원 해제
			try {
				if (pstmt != null) {
					pstmt.close();					
				}
				if (conn != null) {
					conn.close();
				}
				
			} catch (SQLException e) {
				System.err.println("자원 반납 오류!");
				e.printStackTrace();
				
			}
		}
		
		return isCnt;
	}


	@Override
	public Book select(Book book) throws NotFoundException {
		// 조회하려는 제품 존재여부 검사 : isExists()
		if (!isExists(book)) {
			throw new NotFoundException("조회", book);
		}
		
		// 0. 필요 객체 선언
		Book found = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		
		try {
			// 1. 드라이버 로드
			Class.forName(DRIVER);
			
			// 2. 커넥션 맺기
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			// 3. 쿼리 준비
			String sql = "SELECT b.bookId" 
			           + "     , b.title" 
			           + "     , b.author" 
			           + "     , b.price" 
			           + "     , b.isbn" 
			           + "     , b.publish" 
					   + "  FROM book b" 
			           + " WHERE b.bookId = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, book.getBookId());
			
			// 4. 쿼리 실행
			result = pstmt.executeQuery();
			
			// 5. 결과 처리
			while (result.next()) {
				String bookId = result.getString(1);
				String title = result.getString(2);
				String author = result.getString(3);
				int price = result.getInt(4);
				String isbn = result.getString(5);
				String publish = result.getString(6);
				
				found = new Book(bookId, title, author, price, isbn, publish);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			// 6. 자원 해제
			try {
				if (result != null) {
					result.close();
				}
				if (pstmt != null) {
					pstmt.close();					
				}
				if (conn != null) {
					conn.close();
				}
				
			} catch (SQLException e) {
				System.err.println("자원 반납 오류!");
				e.printStackTrace();
			}
		}
		
		return found;
	}

	@Override
	public int update(Book book) throws NotFoundException {
		// 추가하려는 제품이 이미 존재하는지 검사
		if (!isExists(book)) {
			throw new NotFoundException("수정", book);
		}
		
		// 0. 필요 객체 선언
		int udCnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			// 1. 드라이버 로드
			Class.forName(DRIVER);
			
			// 2. 커넥션 맺기
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			// 3. 쿼리 준비
			String sql = "UPDATE book b"  
					   + "   SET b.title = ?" 
					   + "     , b.author = ?" 
					   + "     , b.price = ?" 
					   + "     , b.isbn = ?" 
					   + "     , b.publish = ?" 
					   + "     , b.MODDATE  = sysdate" 
					   + " WHERE b.bookId = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, book.getTitle());
			pstmt.setString(2, book.getAuthor());
			pstmt.setInt(3, book.getPrice());
			pstmt.setString(4, book.getIsbn());
			pstmt.setString(5, book.getPublish());
			pstmt.setString(6, book.getBookId());
			
			// 4. 쿼리 실행
			udCnt = pstmt.executeUpdate();
			
			// 5. 결과 처리
			//   ==> 쿼리 실행 전 중복 여부 검사하므로 특별한
			//       결과 처리가 필요 없음
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			// 6. 자원 해제
			try {
				if (pstmt != null) {
					pstmt.close();					
				}
				if (conn != null) {
					conn.close();
				}
				
			} catch (SQLException e) {
				System.err.println("자원 반납 오류!");
				e.printStackTrace();
				
			}
		}
		
		return udCnt;
	}

	@Override
	public int delete(Book book) throws NotFoundException {
		// 추가하려는 제품이 이미 존재하는지 검사
		if (!isExists(book)) {
			throw new NotFoundException("삭제", book);
		}
		
		// 0. 필요 객체 선언
		int dlCnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			// 1. 드라이버 로드
			Class.forName(DRIVER);
			
			// 2. 커넥션 맺기
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			// 3. 쿼리 준비
			String sql = "DELETE book b ";			
			sql       += " WHERE b.bookId = ?";
				
			pstmt = conn.prepareStatement(sql);			
			pstmt.setString(1, book.getBookId());
			
			// 4. 쿼리 실행
			dlCnt = pstmt.executeUpdate();
			
			// 5. 결과 처리
			//   ==> 쿼리 실행 전 중복 여부 검사하므로 특별한
			//       결과 처리가 필요 없음
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			// 6. 자원 해제
			try {
				if (pstmt != null) {
					pstmt.close();					
				}
				if (conn != null) {
					conn.close();
				}
				
			} catch (SQLException e) {
				System.err.println("자원 반납 오류!");
				e.printStackTrace();
				
			}
		}
		
		return dlCnt;
	}

	@Override
	public List<Book> select() {
		
		// 0. 필요 객체 선언
		List<Book> books = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		
		try {
			// 1. 드라이버 로드
			Class.forName(DRIVER);
			
			// 2. 커넥션 맺기
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			// 3. 쿼리 준비
			String sql = "SELECT b.bookId" 
			           + "     , b.title" 
			           + "     , b.author" 
					   + "     , b.price" 
			           + "     , b.isbn" 
			           + "     , b.publish" 
					   + "  FROM book b ";
			
			pstmt = conn.prepareStatement(sql);
			
			// 4. 쿼리 실행
			result = pstmt.executeQuery();
			
			// 5. 결과 처리
			while (result.next()) {
				String bookId = result.getString(1);
				String title = result.getString(2);
				String author = result.getString(3);
				int price = result.getInt(4);
				String isbn = result.getString(5);
				String publish = result.getString(6);
				
				Book book = new Book(bookId, title, author, price, isbn, publish);
				
				books.add(book);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			// 6. 자원 해제
			try {
				if (result != null) {
					result.close();
				}
				if (pstmt != null) {
					pstmt.close();					
				}
				if (conn != null) {
					conn.close();
				}
				
			} catch (SQLException e) {
				System.err.println("자원 반납 오류!");
				e.printStackTrace();
			}
		}
		
		return books;
	}
	
	
	// 지원 메소드 : 등록, 수정, 삭제, 조회할 대상 제품의
	//               존재여부를 확인하는 메소드
	private boolean isExists(Book book) {
		boolean isExist = false;
		
		// 0. 필요객체 선언
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;		

		try {
			// 1. 드라이버 로드
			Class.forName(DRIVER);
			
			// 2. 커넥션
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			// 3. 쿼리 준비
			String sql = "SELECT b.bookId" 
			           + "  FROM book b" 
					   + " WHERE b.bookId = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, book.getBookId());
			
			// 4. 쿼리 실행
			result = pstmt.executeQuery();
			
			// 5. 결과 처리
			while (result.next()) {
				// 조회 결과가 있다는 뜻은 동일 제품 코드가 등록되었음
				isExist = true;
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			// 6. 자원 해제
			try {
				if (result != null) {
					result.close();
				}
				if (pstmt != null) {
					pstmt.close();					
				}
				if (conn != null) {
					conn.close();
				}
				
			} catch (SQLException e) {
				System.err.println("자원 반납 오류!");
				e.printStackTrace();
				
			}
		}
		
		return isExist;
	}


}
