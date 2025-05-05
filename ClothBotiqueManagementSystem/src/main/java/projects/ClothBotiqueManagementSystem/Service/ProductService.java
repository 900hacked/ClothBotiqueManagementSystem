package projects.ClothBotiqueManagementSystem.Service;

import java.util.List;


import projects.ClothBotiqueManagementSystem.Model.Products;

public interface ProductService {

	public void addProduct(Products product);


	public void updateProducts(Products products);
		
		public Products getProductsById(int id);
		
		public void removeProducts(int id);
		
		public List<Products> listProducts();

}
