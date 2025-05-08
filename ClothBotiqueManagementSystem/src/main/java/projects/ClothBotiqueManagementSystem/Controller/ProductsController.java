package projects.ClothBotiqueManagementSystem.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import projects.ClothBotiqueManagementSystem.Model.Products;
import projects.ClothBotiqueManagementSystem.Service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductsController {
	
	@Autowired
	private ProductService service;
	
	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addProducts(@RequestBody Products product ) {
		
		service.addProduct(product);
		
		return "Successfully added product";
	}
	
	@ResponseBody
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public String updateProducts(@RequestBody Products updatedProduct, @PathVariable("id") int id, HttpServletRequest request) {
		
		HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            return "Access denied: No active session.";
        } else {
		Products prod = service.getProductsById(id);
		prod.setProductName(updatedProduct.getProductName());
		prod.setDescription(updatedProduct.getDescription());
		prod.setStock(updatedProduct.getStock());
		prod.setCreatedOn(updatedProduct.getCreatedOn());
		service.updateProducts(prod);
		System.out.println("Updated data " + prod);
        }
		return "Successfully Updated";
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public Products getProductsById(@PathVariable("id") int id) {
		
		Products body = service.getProductsById(id);
		
		return body;
	}
	
	@ResponseBody
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public String removeProducts(@PathVariable("id") int id) {
		
		service.removeProducts(id);
		
		return "Product " + id + " has been deleted";
	}
	
	@ResponseBody
	@RequestMapping(value = "/gets", method = RequestMethod.GET)
	public List<Products> getAll(){
		
		return service.listProducts();
	}

}
