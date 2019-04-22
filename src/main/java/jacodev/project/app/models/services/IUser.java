package jacodev.project.app.models.services;

import java.util.List;


import jacodev.project.app.models.entity.User;


public interface IUser{
	public List<User> findAll();
	public User logIn(String user, String password);
}
