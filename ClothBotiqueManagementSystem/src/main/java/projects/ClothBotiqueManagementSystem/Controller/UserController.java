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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import projects.ClothBotiqueManagementSystem.Model.User;
import projects.ClothBotiqueManagementSystem.Service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService service;
	
	@ResponseBody
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerUser(@RequestBody @Valid User user ) {
		
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
		
		service.addUser(user);
		
		return "User successfully added";
		
		
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/update/{id}",  method = RequestMethod.PUT)
	
	public String updateUser(@RequestBody User updatedUser, @PathVariable("id") int id, HttpServletRequest request) {
		
//		HttpSession session = request.getSession(false);
//        if (session == null || session.getAttribute("user") == null) {
//            return "Access denied: No active session.";
//        } else {
        
		User you = service.getUserById(id);
		you.setEmail(updatedUser.getEmail());
		you.setFirstName(updatedUser.getFirstName());
		you.setLastName(updatedUser.getLastName());
		you.setPassword(updatedUser.getPassword());
		you.setRole(updatedUser.getRole());
		service.updateUsers(you);
		System.out.println("updated data:" + you);
		return "Successfully updated";
        
	}
	
	@ResponseBody
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public User getUserById(@PathVariable("id") int id) {
		
		User body = service.getUserById(id);
		return body;
	}
	
	@ResponseBody
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public String removeUser(@PathVariable("id") int id ) {
		
		service.removeUser(id);
		return "Order " + id + " has been deleted";
	
}
	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpServletRequest request, HttpServletResponse response) {
		
		String authHeader = request.getHeader("Authorization");
		
		if (authHeader == null || !authHeader.startsWith("Basic ")) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return "Missing or invalid Authorization header";
        }
		String base64Credentials = authHeader.substring(6);

		 
        String credentials = new String(Base64.decodeBase64(base64Credentials), StandardCharsets.UTF_8);
  
        String[] values = credentials.split(":", 2);

        
 
        if ("admin".equals(values[0]) && "password".equals(values[1])) {
            HttpSession session = request.getSession();
            session.setAttribute("user", values[0]);
            return "Session Token: " + session.getId();
        } else if ("employee".equals(values[0]) && "employee123".equals(values[1])) {
        	HttpSession session = request.getSession();
            session.setAttribute("employee", values[0]);
            return "Session Token: " + session.getId();
        } else if ("customer".equals(values[0]) && "customer123".equals(values[1])) {
        	HttpSession session = request.getSession();
            session.setAttribute("customer", values[0]);
            return "Session Token: " + session.getId();
        }
        
        else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return "Invalid credentials";
        }
	}
	
	@ResponseBody
	@RequestMapping(value = "/gets", method = RequestMethod.GET)
	public List<User> getAll(HttpServletRequest request) {
		
		HttpSession session = request.getSession(false);
      if (session == null || session.getAttribute("user") == null) {
          return null;
      } else {
    	  return  service.listUser();
      }
		
		
	}
}
