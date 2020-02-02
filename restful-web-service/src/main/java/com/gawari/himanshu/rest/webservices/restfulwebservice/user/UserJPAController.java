package com.gawari.himanshu.rest.webservices.restfulwebservice.user;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserJPAController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping(path = "/jpa/users")
	public List<User> retrieveAllUsers() {
		return userRepository.findAll();
	}

	// Simple Get User
	/*
	 * @GetMapping(path = "/users/{id}") public User retrieveUser(@PathVariable int
	 * id) { User user = userDaoService.findOne(id); if (user == null) throw new
	 * UserNotFoundException("id - " + id); return user; }
	 */

	// Get User with HATEOAS having
	// some compatibility issues with
	// latest spring 2.2.4
	/*
	 * @GetMapping(path = "/users/{id}") public EntityModel<User>
	 * retrieveUser(@PathVariable int id) { User user = userDaoService.findOne(id);
	 * if (user == null) throw new UserNotFoundException("id - " + id);
	 * EntityModel<User> model = new EntityModel<>(user); WebMvcLinkBuilder linkTo =
	 * WebMvcLinkBuilder
	 * .linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).retrieveAllUsers());
	 * model.add(linkTo.withRel("all-users")); return model; }
	 */

	// Get User with HATEOAS
	// with old spring 2.1.3
	@GetMapping(path = "/jpa/users/{id}")
	public Resource<User> retrieveUser(@PathVariable int id) {
		Optional<User> user = userRepository.findById(id);
		if (!user.isPresent())
			throw new UserNotFoundException("id - " + id);

		// HATEOAS
		Resource<User> resource = new Resource<User>(user.get());
		ControllerLinkBuilder linkTo = ControllerLinkBuilder
				.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).retrieveAllUsers());
		resource.add(linkTo.withRel("all-users"));
		return resource;
	}

	@PostMapping(path = "/jpa/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser = userRepository.save(user);

		// 201 CREATED response
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@DeleteMapping(path = "/jpa/users/{id}")
	public void deleteUser(@PathVariable int id) {
		userRepository.deleteById(id);
	}
}
