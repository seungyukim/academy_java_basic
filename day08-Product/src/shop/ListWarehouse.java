package shop;

import java.util.ArrayList;
import java.util.List;

/**
 * 제품정보를 저장할 자료구를 리스트로 관리하는 창고 클래스
 * @author PC38206
 *
 */
public class ListWarehouse implements GeneralWarehouse {
	
	// 1. 멤버 변수 선언부
	private List<Product> products;
	
	// 2. 생성자 선언부
	// (1) 기본 생성자
	public ListWarehouse() {
		products = new ArrayList<Product>();
	}
	
	// (2) 매개 변수를 받는 생성자
	public ListWarehouse(List<Product> products) {
		this.products = products;
	}

	//  접근자
	public List<Product> getProducts() {
		return products;
	}

	// 수정자
	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public int add(Product product) {
		boolean success = products.add(product);
		int addCnt = 0;
		
		if (success) {
			addCnt++;
		}
		
		return addCnt;
	}
	
	@Override
	public Product get(Product product) {
		int getIndex = findProductIdx(product);
		Product found = null;
		
		if (getIndex > -1) {
			// 찾아올 제품이 존재
			found = products.get(getIndex); 
		} 
		
		return found;
	}

	@Override
	public int set(Product product) {
		int setCnt = 0;
		int setIdx = findProductIdx(product);
		
		if (setIdx > -1) {
			products.set(setIdx, product);
			setCnt++;
		}
		
		return setCnt;
	}

	@Override
	public int remove(Product product) {
		int rmCnt = 0;
		int rmIdx = findProductIdx(product);
		
		if (rmIdx > -1) {
			products.remove(rmIdx);
			rmCnt++;
		}
		
		return rmCnt;
	}

	@Override
	public List<Product> getAllProducts() {		
		return this.products;
	}
	
	
	// 리스트 안에 찾으려는 제품의 인덱스를 구하는 지원 메소드
	private int findProductIdx(Product product) {
		int index = -1;

		for (int idx = 0; idx < products.size(); idx++) {
			if (products.get(idx).equals(product)) {
				index = idx;
				break;
			}
		}
		
		return index;
	}

}







