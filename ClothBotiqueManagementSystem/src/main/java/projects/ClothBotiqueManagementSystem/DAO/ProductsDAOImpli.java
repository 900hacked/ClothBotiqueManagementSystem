package projects.ClothBotiqueManagementSystem.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import projects.ClothBotiqueManagementSystem.Model.Products;

@Repository
public class ProductsDAOImpli implements ProductsDAO{
	
	@Autowired
	private SessionFactory sesh;

	@Override
	public void addProduct(Products product) {
		Session session = sesh.getCurrentSession();
		session.persist(product);
		
	}

	@Override
	public void updateProducts(Products product) {
		
		try {
			Session session = sesh.getCurrentSession();
			 session.update(product);
			 System.out.println("Successfully updated" + product);
			}
			catch(Exception e) {
				System.out.println("Something went wrong" + e);
			}
		
	}

	@Override
	public Products getProductsById(int id) {
		Session session = sesh.getCurrentSession();
		Products body = (Products) session.get(Products.class, new Integer(id));
		return body;
	}

	@Override
	public void removeProducts(int id) {
		
		Session session = sesh.getCurrentSession();
		Products remove = (Products) session.get(Products.class, new Integer(id));
		if(null != remove) {
			session.delete(remove);
		}
		
	}

	@Override
	public List<Products> listProducts() {
		Session session = sesh.getCurrentSession();
		List<Products> productList = session.createQuery("from Products").list();
		return productList;
	}

}
