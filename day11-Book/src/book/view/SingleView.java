package book.view;

import book.vo.Book;

public class SingleView implements BookView {

	@Override
	public void display(Object object) {
		// object 로 들어오는 대상이 Product 타입인 것이
		// 확실하다 / instanceof 생략 
		Book book = (Book)object;
		book.toString();

	}

}
