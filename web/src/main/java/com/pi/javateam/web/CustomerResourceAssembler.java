package com.pi.javateam.web;

import com.pi.javateam.services.*;
import org.springframework.hateoas.*;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;


@Component
class CustomerResourceAssembler implements ResourceAssembler<Customer, Resource<Customer>> {

	public static final String USER_REL = "user";
	private Class<UserController> controllerClass = com.pi.javateam.web.UserController.class;

	@Override
	public Resource<Customer> toResource(Customer customer) {
		long userId = customer.getUser().getId();
		customer.setUser(null);
		Resource<Customer> customerResource = new Resource<Customer>(customer);
		Link selfLink = linkTo(methodOn(controllerClass).loadSingleUserCustomer(userId, customer.getId())).withSelfRel();
		Link userLink = linkTo(methodOn(controllerClass).loadUser( userId)).withRel(USER_REL);
		customerResource.add(selfLink);
		customerResource.add(userLink);
		return customerResource;
	}
}
