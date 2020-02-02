package com.gawari.himanshu.rest.webservices.restfulwebservice.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {

	// used in static filtering example
	@GetMapping(path = "/filtering")
	public SomeBean retrieveSomeBean() {
		SomeBean someBean = new SomeBean("value1", "Vvalue2", "Vvalue3");
		return someBean;
	}

	// used in static filtering example
	@GetMapping(path = "/filtering-list")
	public List<SomeBean> retrieveListOfSomeBean() {
		List<SomeBean> asList = Arrays.asList(new SomeBean("value1", "Vvalue2", "Vvalue3"),
				new SomeBean("any1", "any2", "any3"));
		return asList;
	}

	// used in dynamic filtering example
	@GetMapping(path = "/dynamic-filter")
	public MappingJacksonValue retrieveSomeBeanDynamically() {
		SomeBean someBean = new SomeBean("value1", "Vvalue2", "Vvalue3");

		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		MappingJacksonValue mapping = new MappingJacksonValue(someBean);
		mapping.setFilters(filters);

		return mapping;
	}

	// used in dynamic filtering example
	@GetMapping(path = "/dynamic-filter-list")
	public MappingJacksonValue retrieveListOfSomeBeanDynamically() {
		List<SomeBean> asList = Arrays.asList(new SomeBean("value1", "Vvalue2", "Vvalue3"),
				new SomeBean("any1", "any2", "any3"));

		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field3", "field2");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		MappingJacksonValue mapping = new MappingJacksonValue(asList);
		mapping.setFilters(filters);

		return mapping;
	}
}
