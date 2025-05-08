package projects.ClothBotiqueManagementSystem.DAO;

import java.util.List;

import projects.ClothBotiqueManagementSystem.Model.Orders;



public interface OrdersDAO {

	public void addOrder(Orders order);


	public void updateOrders(Orders name);
		
		public Orders getOrdersById(int id);
		
		public void removeOrders(int id);
		
		public List<Orders> listOrders();
}
