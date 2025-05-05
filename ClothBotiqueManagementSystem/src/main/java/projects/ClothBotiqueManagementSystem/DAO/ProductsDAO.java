package projects.ClothBotiqueManagementSystem.DAO;

import java.util.List;


import projects.ClothBotiqueManagementSystem.Model.Products;

public interface ProductsDAO {
	
	public void addProduct(Products product);


	public void updateProducts(Products product);
		
		public Products getProductsById(int id);
		
		public void removeProducts(int id);
		
		public List<Products> listProducts();

}
