package book.vo;

public class Book {

	// 1. 매개 변수 선언부
	/** 책을 관리할 아이디 BK001 등 */
	private String bookId;
	/** 책 제목 */ 
	private String title;
	/** 저자명 */
	private String author;
	/** 가격 */
	private int price;
	/** 13자리 숫자 도서 */
	private String isbn;
	/** 출판사 */
	private String publish;
	
	// 2. 생성자 선언부
	/** 기본생성자 */
	Book() {
		
	}
	
	/**
	 * bookId 필드만 초기화하는 생성자
	 * @param bookId
	 */
	public Book(String bookId) {
		this.bookId = bookId;
	}

	/**
	 * bookId, title 필드를 초기화하는 생성자
	 * @param bookId
	 * @param title
	 */
	Book(String bookId, String title) {
		this(bookId);
		this.title = title;
	}

	/**
	 * bookId, title, author 필드를 초기화하는 생성자
	 * @param bookId
	 * @param title
	 * @param author
	 */
	Book(String bookId, String title, String author) {
		this(bookId, title);
		this.author = author;
	}

	/**
	 * bookId, title, author, price 필드를 초기화하는 생성자
	 * @param bookId
	 * @param title
	 * @param author
	 * @param price
	 */
	Book(String bookId, String title, String author, int price) {
		this(bookId, title, author);
		this.price = price;
	}

	/**
	 * bookId, title, author, price, isbn 필드를 초기화하는 생성자
	 * @param bookId
	 * @param title
	 * @param author
	 * @param price
	 * @param isbn
	 */
	Book(String bookId, String title, String author, int price, String isbn) {
		this(bookId, title, author, price);
		this.isbn = isbn;
	}

	/**
	 * 모든 필드를 초기화하는 생성자
	 * @param bookId
	 * @param title
	 * @param author
	 * @param price
	 * @param isbn
	 * @param publish
	 */
	public Book(String bookId, String title, String author, int price, String isbn, String publish) {
		this(bookId, title, author, price, isbn);
		this.publish = publish;
	}

	/** bookId 접근자 */
	public String getBookId() {
		return bookId;
	}

	/** bookId 수정자 */
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	/** title 접근자 */
	public String getTitle() {
		return title;
	}

	/** title 수정자 */
	public void setTitle(String title) {
		this.title = title;
	}

	/** author 접근자 */
	public String getAuthor() {
		return author;
	}

	/** author 수정자 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/** price 접근자 */
	public int getPrice() {
		return price;
	}

	/** price 수정자 */
	public void setPrice(int price) {
		this.price = price;
	}

	/** isbn 접근자 */
	public String getIsbn() {
		return isbn;
	}

	/** isbn 수정자 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	/** publish 접근자 */
	public String getPublish() {
		return publish;
	}

	/** publish 수정자 */
	public void setPublish(String publish) {
		this.publish = publish;
	}

	// 3. 메소드 선언부
	/** bookId 기준 hashCode */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookId == null) ? 0 : bookId.hashCode());
		return result;
	}

	/** bookId 기준 equals */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (bookId == null) {
			if (other.bookId != null)
				return false;
		} else if (!bookId.equals(other.bookId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		String strBook = String.format(
				"도서 정보 [도서코드 : %s, 도서제목 : %s, 저자명 : %s, 가격  : %,d, isbn : %s, 출판사 : %s]%n"
		         , bookId, title, author, price, isbn, publish);
		return strBook;

	}
	
	
}
