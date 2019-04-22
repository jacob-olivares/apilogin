package jacodev.project.app.models.DAO;



import org.springframework.data.repository.CrudRepository;

import jacodev.project.app.models.entity.User;

public interface IUserDAO extends CrudRepository<User, Long>{

}
