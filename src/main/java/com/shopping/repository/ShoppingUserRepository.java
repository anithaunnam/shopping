package com.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopping.entity.ShoppingUser;

public interface ShoppingUserRepository extends JpaRepository<ShoppingUser, Integer> {

}
