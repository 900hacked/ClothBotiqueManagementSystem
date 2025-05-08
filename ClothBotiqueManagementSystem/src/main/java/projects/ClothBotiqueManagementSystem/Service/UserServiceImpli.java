package projects.ClothBotiqueManagementSystem.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import projects.ClothBotiqueManagementSystem.DAO.UserDAO;
import projects.ClothBotiqueManagementSystem.Model.User;

@Service
public class UserServiceImpli implements UserService {

	@Autowired
	private UserDAO userDao;
	
	@Override
	@Transactional
	public void addUser(User user) {
		
		userDao.addUser(user);
		
	}

	@Override
	@Transactional
	public void updateUsers(User users) {
		
		userDao.updateUsers(users);
		
	}

	@Override
	@Transactional
	public User getUserById(int id) {
		User use = userDao.getUserById(id);
		return use;
	}

	@Override
	@Transactional
	public void removeUser(int id) {
		
		userDao.removeUser(id);
		
	}

	@Override
	@Transactional
	public List<User> listUser() {
		
		return userDao.listUser();
	}

}
