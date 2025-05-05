package projects.ClothBotiqueManagementSystem.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import projects.ClothBotiqueManagementSystem.DAO.ProductsDAO;
import projects.ClothBotiqueManagementSystem.Model.Products;
@Service
public class ProductServiceImpli implements ProductService {
	
	@Autowired
	private ProductsDAO productsDao;

	@Override
	@Transactional
	public void addProduct(Products product) {
		
		productsDao.addProduct(product);
		
	}

	@Override
	@Transactional
	public void updateProducts(Products products) {
		
		productsDao.updateProducts(products);
		
	}

	@Override
	@Transactional
	public Products getProductsById(int id) {
		
		Products prod = productsDao.getProductsById(id);
		return prod;
	}

	@Override
	@Transactional
	public void removeProducts(int id) {
		
		productsDao.removeProducts(id);
		
	}

	@Override
	@Transactional
	public List<Products> listProducts() {
		
		return productsDao.listProducts();
	}

}
