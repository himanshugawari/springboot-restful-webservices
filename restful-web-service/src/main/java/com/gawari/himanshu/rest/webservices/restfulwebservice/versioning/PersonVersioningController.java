package com.gawari.himanshu.rest.webservices.restfulwebservice.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {

	@GetMapping(path = "/v1/person")
	public PersonV1 personV1() {
		return new PersonV1("Himanshu Gawari");
	}

	@GetMapping(path = "/v2/person")
	public PersonV2 personV2() {
		return new PersonV2(new Name("Himanshu", "Gawari"));
	}
}
