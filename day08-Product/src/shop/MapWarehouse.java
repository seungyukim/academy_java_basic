package shop;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapWarehouse implements GeneralWarehouse {
	
	// 1. 멤버 변수 선언 : 제품정보를 저장할 맵
	Map<String, Product> products;
	
	// 2. 생성자
	// (1) 기본 생성자
	public MapWarehouse() {
		super();
		products = new HashMap<>();
	}

	// (2) 매개변수를 받는 생성자
	public MapWarehouse(Map<String, Product> products) {
		super();
		this.products = products;
	}

	@Override
	public int add(Product product) {
		int addCnt = 0;
		
		// 같은 객체가 있는지 검사
		if (!isExists(product)) {
			products.put(product.getProdCode(), product);
			addCnt++;
		}
		
		return addCnt;
	}

	@Override
	public Product get(Product product) {
		Product found = null;
		
		if (isExists(product)) {
			found = products.get(product.getProdCode());
		}
		
		return found;
	}

	@Override
	public int set(Product product) {
		int setCnt = 0;
		
		if (isExists(product)) {
			products.replace(product.getProdCode(), product);
			setCnt++;
		}
		
		return setCnt;
	}

	@Override
	public int remove(Product product) {
		int rmCnt = 0;
		
		if (isExists(product)) {
			products.remove(product.getProdCode());
			rmCnt++;
		}
		
		return rmCnt;
	}

	@Override
	public List<Product> getAllProducts() {
		Collection<Product> collection = products.values();
		Product[] prodArr = new Product[collection.size()];
		
		return Arrays.asList(collection.toArray(prodArr));
	}

	// 제품이 이미 존재하는지 여부 확인
	// true  : 존재함
	// false : 없음
	private boolean isExists(Product product) {
		return products.containsKey(product.getProdCode());
	}
}
