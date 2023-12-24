package com.shopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.entity.ShoppingUser;
import com.shopping.repository.ShoppingUserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ShoppingService {
	@Autowired
	private ShoppingUserRepository shoppingUserRepository;

	public List<ShoppingUser> listAll() {
		return shoppingUserRepository.findAll();
	}

	public void save(ShoppingUser shoppingUser) {
		shoppingUserRepository.save(shoppingUser);

	}

	public ShoppingUser get(Integer id) {
		return shoppingUserRepository.findById(id).get();
	}

	public void delete(Integer id) {
		shoppingUserRepository.deleteById(id);
	}

}
