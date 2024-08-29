package com.contrerasjose.ecommercemanagement.ecommercemgt.controller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.contrerasjose.ecommercemanagement.ecommercemgt.entity.User;


@Repository
public interface UserDao extends JpaRepository <User, Long> {

}

