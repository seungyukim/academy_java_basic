package book.factory;

import book.view.ErrorView;
import book.view.ListView;
import book.view.MessageView;
import book.view.BookView;
import book.view.SingleView;

/**
 * 매니저가 특정 응답을 할 때,
 * 응답 객체를 Reply 타입으로 생성하는 클래스
 * @author PC38206
 *
 */
public class ViewFactory {

	public static BookView getView(String type) {
		BookView view = null;
		
		if ("list".equals(type)) {
			view = new ListView();
			
		} else if ("message".equals(type)) {
			view = new MessageView();
			
		} else if ("error".equals(type)) {
			view = new ErrorView();
			
		} else if ("single".equals(type)) {
			view = new SingleView();
		}
		
		return view;
	}
}











