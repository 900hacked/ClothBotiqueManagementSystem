package projects.ClothBotiqueManagementSystem.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import projects.ClothBotiqueManagementSystem.Model.User;

@Repository
public class UserDAOImpli implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(user);
		
	}

	@Override
	public void updateUsers(User users) {
		
		try {
			Session session = sessionFactory.getCurrentSession();
			 session.update(users);
			 System.out.println("Successfully updated" + users);
			}
			catch(Exception e) {
				System.out.println("Something went wrong" + e);
			}
		
	}

	@Override
	public User getUserById(int id) {
		Session session = sessionFactory.getCurrentSession();
		User body = (User) session.get(User.class, new Integer(id));
		return body;
	}

	@Override
	public void removeUser(int id) {
		Session session = sessionFactory.getCurrentSession();
		User remove = (User) session.get(User.class, new Integer(id));
		if(null != remove) {
			session.delete(remove);
		}
		
	}

	@Override
	public List<User> listUser() {
		Session session = sessionFactory.getCurrentSession();
		List<User> productList = session.createQuery("from User").list();
		return productList;
	}

}
