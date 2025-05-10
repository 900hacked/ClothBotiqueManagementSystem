package projects.ClothBotiqueManagementSystem.Service;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


import projects.ClothBotiqueManagementSystem.Model.User;

public class UserValidation implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
        User use = (User) target;
        
        if (use.getEmail() == null || !use.getEmail().matches(".+@.+\\..+")) {
            errors.rejectValue("email", "email.invalid", "Invalid email format");
        }
        if (use.getFirstName() == null || use.getFirstName().length() < 4) {
            errors.rejectValue("firstName", "firstName.invalid", "First name must be at least 4 characters long");
        }
        if (use.getLastName()== null || use.getLastName().length() < 4) {
            errors.rejectValue("LastName", "LastName.invalid", "Last name must be at least 4 characters long");
        }
        
        if (use.getPassword() == null || !use.getPassword().matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$")) {
            errors.rejectValue("password", "Password.invalid", "Invalid Password format");
        }
		
	}

}
