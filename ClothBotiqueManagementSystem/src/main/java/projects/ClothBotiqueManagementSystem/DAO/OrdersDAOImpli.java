package projects.ClothBotiqueManagementSystem.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import projects.ClothBotiqueManagementSystem.Model.Orders;

@Repository
public class OrdersDAOImpli implements OrdersDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addProduct(Orders order) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(order);
		
	}

	@Override
	public void updateOrders(Orders name) {
		
		try {
			Session session = sessionFactory.getCurrentSession();
			 session.update(name);
			 System.out.println("Successfully updated" + name);
			}
			catch(Exception e) {
				System.out.println("Something went wrong" + e);
			}
		
	}

	@Override
	public Orders getOrdersById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Orders body = (Orders) session.get(Orders.class, new Integer(id));
		return body;
	}

	@Override
	public void removeOrders(int id) {
		Session session = sessionFactory.getCurrentSession();
		Orders remove = (Orders) session.get(Orders.class, new Integer(id));
		if(null != remove){
			session.delete(remove);
		}
		
	}

	@Override
	public List<Orders> listOrders() {
		Session session = sessionFactory.getCurrentSession();
		List<Orders> OrderList = session.createQuery("from Orders").list();
		return OrderList;
	}

	
}
