package com.shopping.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.entity.ShoppingUser;
import com.shopping.service.ShoppingService;

@RestController
public class UserManagementController {
	@Autowired
	private ShoppingService shoppingService;

	@GetMapping("/shoppingUsers")
	public List<ShoppingUser> list() {
		return shoppingService.listAll();
	}

	@GetMapping("/shoppingUsers/{id}")
	public ResponseEntity<ShoppingUser> get(@PathVariable Integer id) {
		try {
			ShoppingUser user = shoppingService.get(id);
			return new ResponseEntity<ShoppingUser>(user, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<ShoppingUser>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/shoppingUsers")
	public void add(@RequestBody ShoppingUser shoppingUser) {
		shoppingService.save(shoppingUser);
	}

	@PutMapping("/shoppingUsers/{id}")
	public ResponseEntity<?> update(@RequestBody ShoppingUser shoppingUser, @PathVariable Integer id) {
		try {
			ShoppingUser existShoppingUser = shoppingService.get(id);
			shoppingService.save(shoppingUser);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/shoppingUsers/{id}")
	public void delete(@PathVariable Integer id) {
		shoppingService.delete(id);
	}
}
