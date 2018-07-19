package shop.dao;

import java.util.List;

import shop.exception.DuplicateException;
import shop.exception.NotFoundException;
import shop.vo.Product;

public class MybatisWarehouse implements GeneralWarehouse {

	@Override
	public int add(Product product) throws DuplicateException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Product get(Product product) throws NotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int set(Product product) throws NotFoundException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int remove(Product product) throws NotFoundException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}
	
	// isExist 지원 메소드 작성
	private boolean isExists(Product product) {
		boolean isExists
	}

}
