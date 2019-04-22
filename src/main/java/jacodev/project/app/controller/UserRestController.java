package jacodev.project.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jacodev.project.app.models.entity.User;
import jacodev.project.app.models.services.IUser;

@RestController
@RequestMapping("/user")
public class UserRestController {

	@Autowired
	private IUser userService;
	
	@GetMapping("/users")
	public ResponseEntity<?> showAll(){
		//MAP PARA ENVIAR RESPUESTAS A TRAVES DE UN JSON
		Map<String, Object> response = new HashMap<String, Object>();
		List<User> users = null;
		try {
			users = userService.findAll();
		}catch(DataAccessException e) {
			response.put("mensaje", "Error en la select a la base de datos");
			response.put("error", e.getMessage() + " : " + e.getMostSpecificCause());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "Consulta realizada correctamente");
		response.put("users", users);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		
	}
	
	@PostMapping("/users")
	public ResponseEntity<?> logIn(@Valid @RequestBody User user){
		Map<String, Object> response = new HashMap<String, Object>();
		User u = null;
		try {
			u = userService.logIn(user.getUsername(), user.getPassword());
		}catch(DataAccessException e) {
			response.put("mensaje", "Error en la select a la base de datos");
			response.put("error", e.getMessage() + " : " + e.getMostSpecificCause());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "Se ha logeado satisfactoriamente el usuario " + u.getUsername());
		response.put("usuario", u);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
}
