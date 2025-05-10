package projects.ClothBotiqueManagementSystem.Controller;

import java.nio.charset.StandardCharsets;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import projects.ClothBotiqueManagementSystem.Model.Orders;
import projects.ClothBotiqueManagementSystem.Service.OrderService;




@Controller
@RequestMapping("/orders")
public class OrdersController {

	@Autowired
	private OrderService service;
	

	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addOrder(@RequestBody @Valid Orders orders ) {
		

		service.addOrder(orders);
		
		return "Order successfully added";
		
		
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/update/{id}",  method = RequestMethod.PUT)
	
	public String updateOrder(@RequestBody Orders updatedProduct, @PathVariable("id") int id, HttpServletRequest request) {
		

		Orders ord = service.getOrdersById(id);
		ord.setOrderDate(updatedProduct.getOrderDate());
		ord.setStatus(updatedProduct.getStatus());
		ord.setTotalAmount(updatedProduct.getTotalAmount());
		service.updateOrders(ord);
		System.out.println("updated data:" + ord);
		return "Successfully updated";
        
	}
	
	@ResponseBody
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public Orders getOrdersById(@PathVariable("id") int id) {
		
		Orders body = service.getOrdersById(id);
		return body;
	}
	
	@ResponseBody
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public String removeOrders(@PathVariable("id") int id ) {
		
		service.removeOrders(id);
		return "Order " + id + " has been deleted";
	
	}
	
	@ResponseBody
	@RequestMapping(value = "/gets", method = RequestMethod.GET)
	public List<Orders> getAll() {
		
		return  service.listOrders();
	}
}
