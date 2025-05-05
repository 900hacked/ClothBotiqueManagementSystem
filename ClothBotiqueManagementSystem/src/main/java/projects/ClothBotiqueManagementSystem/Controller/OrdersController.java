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
	public String addProduct(@RequestBody @Valid Orders orders ) {
		
//		HttpSession session = request.getSession(false);
//        if (session == null || session.getAttribute("user") == null) {
//            return "Access denied: No active session.";
//        }
		
//		if (result.hasErrors()) {
//            return "Email validation failed: " + result.getAllErrors();
//        }
//        else {
//        	service.addProduct(name);
//        	 return "User registered successfully";
//        }
		
		service.addProduct(orders);
		
		return "Order successfully added";
		
		
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/update/{id}",  method = RequestMethod.PUT)
	
	public String updateProduct(@RequestBody Orders updatedProduct, @PathVariable("id") int id, HttpServletRequest request) {
		
////		HttpSession session = request.getSession(false);
////        if (session == null || session.getAttribute("user") == null) {
////            return "Access denied: No active session.";
////        } else {
//        
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
////	@ResponseBody
////	@RequestMapping(value = "/login", method = RequestMethod.POST)
////	public String login(HttpServletRequest request, HttpServletResponse response) {
////		
////		String authHeader = request.getHeader("Authorization");
////		
////		if (authHeader == null || !authHeader.startsWith("Basic ")) {
////            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
////            return "Missing or invalid Authorization header";
////        }
////		String base64Credentials = authHeader.substring(6);
////
////		 
////        String credentials = new String(Base64.decodeBase64(base64Credentials), StandardCharsets.UTF_8);
////  
////        String[] values = credentials.split(":", 2);
////
////        
//// 
////        if ("admin".equals(values[0]) && "password".equals(values[1])) {
////            HttpSession session = request.getSession();
////            session.setAttribute("user", values[0]);
////            return "Session Token: " + session.getId();
////        } else {
////            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
////            return "Invalid credentials";
////        }
////	}
//	
//	@ResponseBody
//	@RequestMapping(value = "/gets", method = RequestMethod.GET)
//	public List<Orders> getAll() {
//		
//		return  service.listOrders();
//	}
}
