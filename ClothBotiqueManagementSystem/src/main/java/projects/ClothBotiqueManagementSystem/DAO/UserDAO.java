package projects.ClothBotiqueManagementSystem.DAO;

import java.util.List;

import projects.ClothBotiqueManagementSystem.Model.User;



public interface UserDAO {

	public void addUser(User user);


	public void updateUsers(User users);
		
		public User getUserById(int id);
		
		public void removeUser(int id);
		
		public List<User> listUser();
}
