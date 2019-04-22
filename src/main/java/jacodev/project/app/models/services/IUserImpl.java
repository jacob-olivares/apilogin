package jacodev.project.app.models.services;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jacodev.project.app.models.DAO.IUserDAO;
import jacodev.project.app.models.entity.User;

@Service
public class IUserImpl implements IUser{
	@Autowired
	private IUserDAO userDAO;
	
	@Override
	@Transactional(readOnly = true)
	public List<User> findAll() {
		return (List<User>)userDAO.findAll();
	}

	@Override
	@Transactional
	public User logIn(String username, String password) {
		List<User> users = (List<User>)userDAO.findAll();
		User user = null;
		for(User u : users) {
			if(u.getUsername().equals(username) && u.getPassword().equals(password)) {
				user = u;
			}
		}
		return user;
	}

}
