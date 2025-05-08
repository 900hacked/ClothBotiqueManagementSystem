package projects.ClothBotiqueManagementSystem.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import projects.ClothBotiqueManagementSystem.DAO.OrdersDAO;
import projects.ClothBotiqueManagementSystem.Model.Orders;
import projects.ClothBotiqueManagementSystem.Model.Products;

@Service
public class OrderServiceImpli implements OrderService {
	
	@Autowired
	private OrdersDAO orderDao;

	@Override
	@Transactional
	public void addOrder(Orders order) {
		
		orderDao.addOrder(order);
		
	}

	
	
	@Override
	@Transactional
	public void updateOrders(Orders name) {
		
		orderDao.updateOrders(name);
		
	}

	@Override
	@Transactional
	public Orders getOrdersById(int id) {
		
		Orders order = orderDao.getOrdersById(id);
		return order;
	}

	@Override
	@Transactional
	public void removeOrders(int id) {
		
		orderDao.removeOrders(id);
		
	}

	@Override
	@Transactional
	public List<Orders> listOrders() {
		
		return orderDao.listOrders();
	}

}
