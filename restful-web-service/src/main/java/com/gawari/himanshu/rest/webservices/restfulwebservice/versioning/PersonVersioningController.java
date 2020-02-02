package com.gawari.himanshu.rest.webservices.restfulwebservice.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {

	// Basic Versioning
	@GetMapping(path = "/v1/person")
	public PersonV1 personV1() {
		return new PersonV1("Himanshu Gawari");
	}

	// Basic Versioning
	@GetMapping(path = "/v2/person")
	public PersonV2 personV2() {
		return new PersonV2(new Name("Himanshu", "Gawari"));
	}

	// http://localhost:8080/person/param?version=1
	// versioning using request parameter
	@GetMapping(path = "/person/param", params = "version=1")
	public PersonV1 paramV1() {
		return new PersonV1("Himanshu Gawari");
	}

	// http://localhost:8080/person/param?version=2
	// versioning using request parameter
	@GetMapping(path = "/person/param", params = "version=2")
	public PersonV2 paramV2() {
		return new PersonV2(new Name("Himanshu", "Gawari"));
	}

	// http://localhost:8080/person/header
	// pass version=1 as headers
	// versioning using request header
	@GetMapping(path = "/person/header", headers = "version=1")
	public PersonV1 headerV1() {
		return new PersonV1("Himanshu Gawari");
	}

	// http://localhost:8080/person/header
	// pass version=2 as headers
	// versioning using request header
	@GetMapping(path = "/person/header", headers = "version=2")
	public PersonV2 headerV2() {
		return new PersonV2(new Name("Himanshu", "Gawari"));
	}
}
